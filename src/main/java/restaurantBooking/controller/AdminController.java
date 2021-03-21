package restaurantBooking.controller;

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

import restaurantBooking.dao.AdminDao;
import restaurantBooking.dao.HomeDao;
import restaurantBooking.entity.EmailContent;
import restaurantBooking.entity.Menu;
import restaurantBooking.entity.Seat;

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
//		System.out.println(seats.get(1).getUsers().get(0).getPhone());
		model.addAttribute("seats", seats);
		return "admin/manage-table";
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
	public String getOrders() {
		return "admin/manage-order";
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
	public String sendAdvertisement(@ModelAttribute("content")EmailContent content,Model model) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailContext.xml");
	    MailSender mailSender = (MailSender) context.getBean("mailSender");
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom("hanurestaurant@gmail.com");
	    message.setTo(content.getEmail());
	    message.setSubject(content.getSubject());
	    message.setText(content.getContent());
	    mailSender.send(message);
	    context.close();
		return "redirect:/admin/send-advertisement";
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
}
