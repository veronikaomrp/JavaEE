package del.ac.id.demo.controller;

import del.ac.id.demo.service.FlightImpl;
import del.ac.id.demo.jpa.Flight;
import del.ac.id.demo.jpa.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FlightController {

	@Autowired
	private FlightImpl flightService;
	
	@GetMapping("/index")
	public String showFlightPage(Model model) {
		model.addAttribute("listFlight", flightService.getAllFlight());
		return "index";
	}
	
	/*@RequestMapping("/index")
	public String showNewFlightPage(Model model) {
    List<Flight> listFlight = flightService.getAllFlight();
    model.addAttribute("listFlight", listFlight);
     
    return "index"
	}*/
	
	@GetMapping("/new")
	public String showNewFlightPage(Model model) {
		Flight flight = new Flight();
		model.addAttribute("flight", flight);
		
		return "new_flight";
	}
	
	/*
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Flight flight = new Flight();
		model.addAttribute("flight", flight);
		
		return "new_flight";
	}
	*/
	
	@PostMapping("/saveFlight")
	public String saveFlight(@ModelAttribute("flight") Flight flight) {
		flightService.saveFlight(flight);
		return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteFlight(@PathVariable(value="id") Long id) {
		this.flightService.deleteFlightById(id);
		return "redirect:/index";
	}
	/*
	 @RequestMapping("/delete/{id}")
	 public String deleteFlight(@PathVariable(name = "id") int id) {
	 flightservice.delete(id);
	 return "redirect:/";       
}
	 */
	
	@GetMapping("/edit/{id}")
	public String showEditFlightPage(@PathVariable (value="id") long id, Model model) {
		Flight flight = flightService.getFlightById(id);

		model.addAttribute("flight", flight);
		return "edit_flight";
		
		/*
		@RequestMapping("/edit/{id}")
		public ModelAndView showEditFlightPage(@PathVariable(name = "id") int id) {
		    ModelAndView mav = new ModelAndView("edit_flight");
		    Flight flight = flightService.get(id);
		    mav.addObject("product", product);
		     
		    return mav;
		    
		}
		*/
	}

}
