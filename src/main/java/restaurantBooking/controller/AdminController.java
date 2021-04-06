package restaurantBooking.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import restaurantBooking.dao.AdminDao;
import restaurantBooking.dao.HomeDao;
import restaurantBooking.entity.EmailContent;
import restaurantBooking.entity.Menu;
import restaurantBooking.entity.Order;
import restaurantBooking.entity.OrderDetail;
import restaurantBooking.entity.Seat;
import restaurantBooking.entity.User;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@Autowired
	HomeDao homeDao;

	@Autowired
	ServletContext context;

	@RequestMapping("/admin")
	public String getLogin(@RequestParam(name = "success", required = false) String success, Model model) {
		List<Menu> foods = new ArrayList<Menu>();
		foods = homeDao.getAllMenu();
				
		model.addAttribute("foods", foods);
		model.addAttribute("success", success);
		return "admin/manage-menu";
	}

	@RequestMapping("/admin/manage-menu")
	public String getManageMenu(Model model) {
		List<Menu> foods = new ArrayList<Menu>();
		foods = homeDao.getAllMenu();
		model.addAttribute("foods", foods);
		return "admin/manage-menu";
	}

	@RequestMapping("/admin/manage-table")
	public String getTable(Model model) {
		List<Seat> seats = new ArrayList<Seat>();
		seats = adminDao.getAllSeats();
		model.addAttribute("seats", seats);
		return "admin/manage-table";
	}

	@RequestMapping("/admin/manage-user")
	public String getUser(Model model) {
		List<User> users = new ArrayList<User>();
		users = adminDao.getAllUsers();
		model.addAttribute("users", users);
		return "admin/manage-user";
	}

	@RequestMapping("/admin/accept-table")
	public String acceptTable(@RequestParam int id) {
		adminDao.accepTable(id);
		return "redirect:/admin/manage-table";
	}

	@RequestMapping("/admin/finish-table")
	public String finishTable(@RequestParam int id) {
		adminDao.finishTable(id);
		return "redirect:/admin/manage-table";
	}

	@RequestMapping("/admin/manage-order")
	public String getOrders(Model model) {
		List<Order> orders = new ArrayList<Order>();
		orders = adminDao.getAllOrders();
		model.addAttribute("orders", orders);
		return "admin/manage-order";
	}

	@RequestMapping("/admin/order-details")
	public String orderDetails(@RequestParam int id, Model model) {
		Order order = adminDao.getOrderById(id);
		String content = order.getContent();
		String username = order.getUserName();
		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode contentObject = mapper.readTree(content);
			System.out.println(contentObject);
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			for (int i = 0; i < contentObject.size(); i++) {
				OrderDetail orderDetail = new OrderDetail();
				JsonNode item = contentObject.get(i);
				String foodName = item.get("menu").get("foodName").asText();
				double foodPrice = item.get("menu").get("foodPrice").asDouble();
				int quantity = item.get("quantity").asInt();
				double subTotal = item.get("subTotal").asDouble();

				orderDetail.setFoodName(foodName);
				orderDetail.setFoodPrice(foodPrice);
				orderDetail.setQuantity(quantity);
				orderDetail.setSubTotal(subTotal);

				orderDetails.add(orderDetail);
			}
			model.addAttribute("content", orderDetails);
			model.addAttribute("username", username);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin/details-order";
	}

	@RequestMapping("/admin/profile")
	public String getProfile() {
		return "admin/edit-admin-profile";
	}

	@RequestMapping("/admin/send-advertisement")
	public String getAdvertisement(Model model) {
		EmailContent content = new EmailContent();
		model.addAttribute("content", content);
		return "admin/send-advertisement";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/send-advertisement")
	public String sendAdvertisement(@ModelAttribute("content") EmailContent content, Model model,
			@RequestParam("email") String email) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailContext.xml");
		MailSender mailSender = (MailSender) context.getBean("mailSender");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hanurestaurant@gmail.com");
		message.setTo(email);
		message.setSubject("Hanu Restaurant Recruitment");
		message.setText(
				"HANU Restaurant has a vacancy for a shop keeper to work in the area of sales and marketing, particularly with our household.");
		mailSender.send(message);
		context.close();
		return "redirect:/admin/manage-user";
	}

	@RequestMapping("/admin/success")
	public String success() {
		return "admin/success";
	}

	@RequestMapping("/admin/remove")
	public String removeFood(@RequestParam("foodId") int id, Model model) {
		Menu menu = new Menu();
		int status = adminDao.removeFoodById(id);
		String message;
		if (status > 0) {
			message = "Remove successfully!";
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			message = "Cannot remove!";
			model.addAttribute("message", message);
			return "redirect:/admin";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin/edit")
	public String editFood(@RequestParam(required = false, name = "foodId") int id, Model model) {
		Menu menu = new Menu();
		menu = homeDao.findFoodById(id);
		model.addAttribute("menu", menu);
		model.addAttribute("id", id);
		return "admin/edit-food";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/edit")
	public String editFood(@ModelAttribute("menu") Menu menu, Model model) {
		adminDao.updateFood(menu);
		return "redirect:/admin";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/add-food")
	public String addNewFood(Model model, @RequestParam("imageUrl") MultipartFile imageFile,
			@RequestParam("foodName") String foodName, @RequestParam("foodPrice") double foodPrice,
			@RequestParam("foodDescription") String foodDescription, @RequestParam("subtitle") String subtitle,
			@RequestParam("foodType") int foodType, HttpServletRequest request) {
		int status;
		String success, error;
		Menu menu = new Menu();
		String fileName = imageFile.getOriginalFilename();
		menu.setFoodName(foodName);
		menu.setFoodPrice(foodPrice);
		menu.setSubtitle(subtitle);
		menu.setFoodDescription(foodDescription);
		menu.setFoodType(foodType);
		
		BasicAWSCredentials cred = new BasicAWSCredentials("AKIATYVICPYH2CYRSP4C", "7v3E7m3zCL3yYdjpS7IPGPA9J4Ywz9BDdlLW1WqH");
		
		AmazonS3 s3client = AmazonS3Client.builder()
							.withRegion("ap-southeast-1")
							.withCredentials(new AWSStaticCredentialsProvider(cred))
							.build();
		String bucketName = "hanu-food";
		
		try {
			InputStream	is = imageFile.getInputStream();
			s3client.putObject(new PutObjectRequest(bucketName, fileName, is, new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, imageFile.getOriginalFilename()));
		String imageUrl = s3object.getObjectContent().getHttpRequest().getURI().toString();
		System.out.println(s3object);
		System.out.println(s3object.getObjectContent().getHttpRequest().getURI().toString());
		menu.setImageUrl(imageUrl);
		status = adminDao.addNewFood(menu);

		
		if (status > 0) {		
			success = "Add new food succesfully!";
			model.addAttribute("success", success);
			return "redirect:/admin";
		} else {
			error = "Cannot add new food!";
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/ship-order")
	public String shipOrder(@RequestParam("id") int id) {
		adminDao.ship(id);
		return "redirect:/admin/manage-order";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/reject-order")
	public String rejectOrder(@RequestParam("id") int id) {
		adminDao.reject(id);
		return "redirect:/admin/manage-order";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/accept-order")
	public String acceptOrder(@RequestParam("id") int id) {
		adminDao.accept(id);
		return "redirect:/admin/manage-order";
	}
}
