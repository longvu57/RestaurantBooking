package restaurantBooking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/admin")
	public String getLogin(@RequestParam(name = "success", required = false) String success, Model model) {
		Menu menu = new Menu();
		List<Menu> foods = new ArrayList<Menu>();
		foods = homeDao.getAllMenu();
		model.addAttribute("foods", foods);
		model.addAttribute("menu", menu);
		model.addAttribute("success", success);
		return "admin/manage-menu";
	}

	@RequestMapping("/admin/manage-menu")
	public String getManageMenu(Model model) {
		Menu menu = new Menu();
		List<Menu> foods = new ArrayList<Menu>();
		foods = homeDao.getAllMenu();
		model.addAttribute("foods", foods);
		model.addAttribute("menu", menu);
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
	public String sendAdvertisement(@ModelAttribute("content") EmailContent content, Model model, @RequestParam("email")String email) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailContext.xml");
		MailSender mailSender = (MailSender) context.getBean("mailSender");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hanurestaurant@gmail.com");
		message.setTo(email);
		message.setSubject("Hanu Restaurant Recruitment");
		message.setText("HANU Restaurant has a vacancy for a shop keeper to work in the area of sales and marketing, particularly with our household.");
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
	public String addNewFood(@ModelAttribute("menu") Menu menu, Model model) {
		int status;
		String success, error;

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
