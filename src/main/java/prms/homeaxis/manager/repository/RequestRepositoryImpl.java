package prms.homeaxis.manager.repository;
 
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
@Repository
public class RequestRepositoryImpl implements RequestRepository {
 
 
	@Autowired
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Map<String, Object>> fetchAllRequests(int managerId) {
		final String GET_ALL_REQUESTS = "select \r\n"
				+"u.name,m.tenant_id,m.manager_id,m.maintenance_id,m.request_type,m.description,m.requested_date,\r\n"
				+"m.status\r\n"
				+"from \r\n"
				+"user u \r\n"
				+"inner join \r\n"
				+"maintenance_request m \r\n"
				+"on u.user_id = m.tenant_id where m.manager_id=? \r\n";
				return  jdbcTemplate.queryForList(GET_ALL_REQUESTS,managerId);
	}
 
	@Override
	public int updateRequestStatus(Integer maintenanceId, String status) {
		String UPDATE_AUTHORITY="";
		System.out.println("Request Status: " + status);
		if ("open".equals(status)) {
			UPDATE_AUTHORITY = "update maintenance_request set  status= 'completed' where maintenance_id=? ";
			System.out.println("Request Status query: " + UPDATE_AUTHORITY);
		} else {
			UPDATE_AUTHORITY = "update maintenance_request set  status= 'open' where maintenance_id=?";
			System.out.println("Request Status query: " + UPDATE_AUTHORITY);
 
		}
		return jdbcTemplate.update(UPDATE_AUTHORITY, maintenanceId);
	}
}