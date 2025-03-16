package prms.homeaxis.tenant.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import prms.homeaxis.tenant.entities.MaintenanceRequest;
import prms.homeaxis.tenant.service.MaintenanceService;

@Controller
public class MaintenanceController {
	@Autowired
	MaintenanceService maintenanceService;
	
	@GetMapping("/viewMaintenanceRequest")
	public String getAllRequests(Model model) {
		List<Map<String, Object>> requests = maintenanceService.getAllRequests();
		model.addAttribute("requests", requests != null ? requests : Collections.emptyList());
		return "landlord/viewMaintence"; // Refers to maintenanceRequests.jsp
	}
	@PostMapping("/maintenanceUpdateStatus")
	public String maintenanceUpdateStatus(@RequestParam("maintenanceId") int maintenanceId,
			@RequestParam("status") String status) {
		maintenanceService.updateMaintenanceStatus(maintenanceId, status);
			return "redirect:/viewMaintenanceRequest";
		} 
	}


