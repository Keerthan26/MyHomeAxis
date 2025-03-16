package prms.homeaxis.manager.controller;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import prms.homeaxis.landlord.service.PaymentsService;
import prms.homeaxis.tenant.service.TenantService;
import prms.homeaxis.user.service.UserService;
 
@Controller
public class PaymentController {
 
	@Autowired
	PaymentsService paymentService;
 
	@Autowired
	UserService userService;
	@Autowired
	TenantService tenantService;
 
	
	@GetMapping("/openPaymentPage/{managerId}")
	public String openPaymentPage(@PathVariable String managerId, Model model) {
		System.out.println("\n ManagerId "+managerId);
		int id=Integer.parseInt(managerId);
		List<Map<String, Object>> payments = paymentService.getAllPayments(id);
		if (payments == null || payments.isEmpty()) {
			System.out.println("No Payment Information Found");
		} else {
			for (Map<String, Object> pay : payments) {
				System.out.println("data--" + pay);
			}
		}
 
		model.addAttribute("payments", payments);
		return "manager/payment_list";
	}
	@GetMapping("/paymentStatusToggle/{paymentId}")
	public String paymentStatusToggle(@PathVariable String paymentId, @RequestParam("status") String status,
			@RequestParam("manager_id") String managerId, Model model) {
		int Id = Integer.parseInt(paymentId);
		System.out.println("\nManager Id:" + managerId);
		paymentService.updatePaymentstatus(Id, status);
 
		// whenever data enters your methods, make sure you print them
		// if it is working correctly you can delete these s.o.ps
		System.out.println("\n payment id:" + paymentId);
		return "redirect:/openPaymentPage/" + managerId;
	}

 
	
 
	@GetMapping("/viewAllPayments/{managerId}")
	public String viewAllPayments(@PathVariable String managerId, ModelAndView mView) {
		int id = Integer.parseInt(managerId);
 
		List<Map<String, Object>> payments = paymentService.getAllPayments(id);
		System.out.println("data--" + payments);
		// fetch the data of all mangers from the database
		mView.addObject("payments", payments);
		mView.setViewName("manager/payment_list");
		return "manager/payments_list";
	}
}