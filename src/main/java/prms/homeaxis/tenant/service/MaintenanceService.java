package prms.homeaxis.tenant.service;

import java.util.List;
import java.util.Map;

import prms.homeaxis.tenant.entities.MaintenanceRequest;

public interface MaintenanceService {

	List<Map<String, Object>> getAllRequests();
	int updateMaintenanceStatus(int maintenanceId, String status);
}
