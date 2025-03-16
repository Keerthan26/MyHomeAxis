package prms.homeaxis.tenant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import prms.homeaxis.tenant.service.TenantService;
import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.service.UserService;

@Controller
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	TenantService tenantservice;
	@GetMapping("/dashboard")
	public String openDashboard() {
		return "tenant/dashboard";
	}
	
	
	@GetMapping("/viewAllTenants")
	public ModelAndView viewAllBankManagers(ModelAndView mView) {
		List<User> listOfTenants = tenantservice.getAllTenants();
		mView.addObject("listOfTenants", listOfTenants);
		mView.setViewName("landlord/manage_tenants");
		return mView;

	}
	
	@GetMapping("/toogleAuthority/{userId}")
	public String toogleAuthority(@PathVariable String userId) {
		int id=Integer.parseInt(userId);
		userservice.updateAuthority(id);
		System.out.println("User id:"+userId);
		return "redirect:/tenant/viewAllTenants";
	}
	
	 @GetMapping("/openTenantPage/{managerId}")
	    public String openTenantPage(@PathVariable String managerId, Model model) {
	        System.out.println("\nManager Id:" + managerId);
	        int id = Integer.parseInt(managerId);
	        List<Map<String, Object>> tenants = tenantservice.getAllTenant(id);
	        if (tenants == null || tenants.isEmpty()) {
	            System.out.println("No Tenants Information Found");
	        } 
	        else {
	            for (Map<String, Object> tenant : tenants) {
	                System.out.println("data--" + tenant);
	            }
	        }
	        model.addAttribute("tenants", tenants);
	        return "manager/tenant_list";
	    }
	 
		
		
	 
	 @GetMapping("/tenantStatusToggle/{tenantId}")
	 public String tenantStatusToggle(@PathVariable String tenantId, @RequestParam("tenant_status") String tenantStatus,
	                                  @RequestParam("manager_id") String managerId, Model model) {
	     int Id = Integer.parseInt(tenantId);
	     System.out.println("\nManager Id:" + managerId);
	     tenantservice.updateTenantStatus(Id, tenantStatus);

	     System.out.println("\n Tenant id:" + tenantId);
	     return "redirect:/tenant/openTenantPage/" + managerId;
	 }
	}


