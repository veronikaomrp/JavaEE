package del.ac.id.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import del.ac.id.demo.jpa.User;
import del.ac.id.demo.jpa.UserRepository;

@RestController
public class LoginController {
	private UserRepository userRepository;
	
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute User user) {
		User temp = userRepository.findByUsername(user.getUsername());
		
		String url="login";
		
		if(temp != null) {
			if (user.getPwd().equals(user.getPwd())) {
				url="index";
			}
		}
		
		return new ModelAndView("redirect:/" + url);
	}
}