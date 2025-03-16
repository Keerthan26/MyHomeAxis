package prms.homeaxis.manager.service;
 
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import prms.homeaxis.manager.entities.Request;
import prms.homeaxis.manager.repository.RequestRepository;
 
@Service
public class RequestServiceImpl implements RequestService {
@Autowired
     RequestRepository requestRepository ;
 
    @Override
    public List<Map<String,Object>> getAllRequests(int managerId) {
        return requestRepository.fetchAllRequests(managerId);
    }
 
	@Override
	public void saveRequest(Request request) throws SQLException {
	}
	@Override
	public int updateRequestStatus(int maintenanceId, String status) {
	    return requestRepository.updateRequestStatus(maintenanceId, status);
	}
}