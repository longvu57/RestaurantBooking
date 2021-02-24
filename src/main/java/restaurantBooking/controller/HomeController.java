package restaurantBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/admin")
	public String index() {
		return "admin/form";
	}
	@RequestMapping("/admin/login")
	public String index1() {
		return "admin/login";
	}
	@RequestMapping("/")
	public String index2() {
		return "user/foodMenu";
	}
}
