package prms.homeaxis.tenant.repository;

import java.util.List;
import java.util.Map;


public interface MaintenanceRepository {
	
	List<Map<String, Object>> fetchAllRequests();
	int updateMaintenanceStatus(int maintenanceId, String status); 

}
