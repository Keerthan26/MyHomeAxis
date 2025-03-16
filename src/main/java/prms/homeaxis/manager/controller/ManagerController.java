package prms.homeaxis.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.service.PropertyService;
import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.manager.service.ManagerService;
import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.service.UserService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	UserService userservice;

	@Autowired
	ManagerService managerservice;
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/dashboard")
	public String ManagerDashboard() {
		return "manager/dashboard";
	}

	@GetMapping("/viewAllMangers")
	public ModelAndView viewAllBankManagers(ModelAndView mView) {
		List<Map<String,Object>> listOfManagers = managerservice.getAllManger();
		mView.addObject("listOfManagers", listOfManagers);
		mView.setViewName("landlord/manage_managers");
		return mView;

	}
	
	@GetMapping("/assignManagers")
	public String showAssignManagersPage(Model model) {

		List<Map<String, Object>> approvedManagers = managerservice.getApprovedManagers();
		List<Property> properties = propertyService.getAllProperty();

		model.addAttribute("approvedManagers", approvedManagers);
		model.addAttribute("properties", properties);
		return "landlord/assign_managers"; // JSP page name
	}

	@PostMapping("/assignManager")
	public String assignManager(@RequestParam int managerId, @RequestParam int propertyId,
			RedirectAttributes redirectAttributes, Model model) {
		propertyService.assignManagerToProperty(managerId, propertyId);

		List<Manager> assignedManagers = propertyService.getAssignedManagers(propertyId);
		List<Property> properties = propertyService.getAllProperty();
		System.out.println(
				"Manager assigned to a property " + "manager id = " + managerId + " " + "property id = " + propertyId);
		model.addAttribute("assignedManagers", assignedManagers);
		model.addAttribute("properties", properties);
		model.addAttribute("propertyId", propertyId);
		redirectAttributes.addFlashAttribute("message", "Manager assigned successfully!");
		return "redirect:/manager/assignManagers";
	}
	
	@GetMapping("/viewAssignManagers")
	public String viewAssignManagersPage(Model model) {
		
		List<Map<String,Object>> viewListOfAssingManagers = propertyService.viewAllPropertyStatus();
		model.addAttribute("viewListOfAssingManagers", viewListOfAssingManagers);
		
		return "landlord/view_assign_manager"; // JSP page name
	}
	
	
	@GetMapping("/toogleAuthority/{userId}")
	public String toogleAuthority(@PathVariable String userId) {
		int id=Integer.parseInt(userId);
		userservice.updateAuthority(id);
		System.out.println("User id:"+userId);
		return "redirect:/manager/viewAllMangers";
	}
}
