package prms.homeaxis.manager.service;
 
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
 
import prms.homeaxis.manager.entities.Request;
 
public interface RequestService {
    void saveRequest(Request request) throws SQLException;
 
    List<Map<String,Object>> getAllRequests(int managerIdint);
 
 
	int updateRequestStatus(int maintenanceId, String status);
 
    
}