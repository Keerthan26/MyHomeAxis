package prms.homeaxis.landlord.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import prms.homeaxis.landlord.entities.Payments;
import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.service.PaymentsService;
import prms.homeaxis.landlord.service.PropertyService;

@Controller
@RequestMapping("/landlord")
public class LandlordController {
	
	@Autowired
	PaymentsService paymentService;
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "landlord/dashboard";
	}
	@GetMapping("/manageproperties")
	public String manageproperties() {
		return "landlord/manage_properties";
	}
	
	@GetMapping("/getAllPayments")
	public ModelAndView getAllPayments() {

		ModelAndView modelAndView = new ModelAndView();

		List<Map<String,Object>> allPayments = paymentService.getAllPayments();
		System.out.println("allPayments :" + allPayments);

		// Set the assigned payments in the ModelAndView
		modelAndView.addObject("allPayments", allPayments);

		// Set the view name
		modelAndView.setViewName("landlord/payments");

		return modelAndView;
	}

	@PostMapping("/updateStatus")
	public String updatePaymentStatus(@RequestParam("paymentId") Integer paymentId,
			@RequestParam("status") String status) {
		paymentService.updatePaymentStatus(paymentId, status);
		return "redirect:/landlord/getAllPayments"; // Redirect to payments list
	}
	
	
}
