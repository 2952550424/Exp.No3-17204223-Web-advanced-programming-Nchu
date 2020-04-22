package lab3.nchu17204223;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("welcome");
	}

	@GetMapping("/")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@GetMapping("/login")
	public String gotoLogin(@Validated User user, Model model) {
		model.addAttribute(user);
		return "login";
	}

	@PostMapping("/login")
	public String login(@Validated User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasFieldErrors()) {
			model.addAttribute(user);
			return "login";
		} else
			return "redirect:home";
	}

	@GetMapping("/register")
	public String gotoRegister(@Validated User user, Model model) {
		model.addAttribute(user);
		return "register";
	}

	@PostMapping("/register")
	public String register(@Validated User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasFieldErrors()) {
			model.addAttribute(user);
			return "register";
		} else
			return "redirect:home";
	}
}
