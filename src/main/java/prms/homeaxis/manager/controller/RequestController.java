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
 
import prms.homeaxis.manager.entities.Request;
import prms.homeaxis.manager.service.RequestService;
import prms.homeaxis.user.service.UserService;
 
@Controller
public class RequestController {
	@Autowired
	RequestService requestService;
	@Autowired
	UserService userService;
 
 
	@GetMapping("/openRequestPage/{managerId}")
	public String openRequestPage(@PathVariable String managerId, Model model) {
    	System.out.println("\n ManagerId "+managerId);
    	int id=Integer.parseInt(managerId);
		List<Map<String,Object>> requests = requestService.getAllRequests(id);
		if (requests == null || requests.isEmpty()) {
   		 System.out.println("No Requests Information Found") ;
   	 }else {
   		 for(Map<String,Object> request:requests){
   			 System.out.println("data--"+request);
   		 }
   	 }
		model.addAttribute("requests", requests);
		return "manager/request_list";
	}
	@GetMapping("/requestStatusToggle/{maintenanceId}")
	public String requestStatusToggle(@PathVariable String maintenanceId, @RequestParam("status") String status,
			@RequestParam("manager_id") String managerId, Model model) {
		int Id = Integer.parseInt(maintenanceId);
		System.out.println("\nManager Id:" + managerId);
		requestService.updateRequestStatus(Id, status);
 
		// whenever data enters your methods, make sure you print them
		// if it is working correctly you can delete these s.o.ps
		System.out.println("\n Request id:" + maintenanceId);
		return "redirect:/openRequestPage/" + managerId;
	}

 
	/*
	 * @PostMapping("/manager/updateStatus1") public String
	 * updateRequestStatus(@RequestParam("maintenanceId") Integer maintenanceId,
	 * 
	 * @RequestParam("status") String status,
	 * 
	 * @RequestParam("managerId") String managerId) {
	 * requestService.updateRequestStatus(maintenanceId, status); return
	 * "redirect:/openRequestPage/" + managerId; // Redirect to payments list with
	 * managerId }
	 */
}