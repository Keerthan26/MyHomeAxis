package prms.homeaxis.manager.repository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
 
 
@Repository
public interface RequestRepository {
    List<Map<String,Object>> fetchAllRequests( int managerId);
 
	int updateRequestStatus(Integer maintenanceId, String status);
 
 

}