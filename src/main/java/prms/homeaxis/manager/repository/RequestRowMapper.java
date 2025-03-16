package prms.homeaxis.manager.repository;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
 
import prms.homeaxis.manager.entities.Request;
 
public class RequestRowMapper implements RowMapper<Request> {
    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
    	String name = rs.getString("name");
    	  int tenantId = rs.getInt("tenant_id");
    	  int managerId = rs.getInt("manager_id");
        int maintenanceId = rs.getInt("maintenance_id");
        String requestType = rs.getString("request_type");
        String description = rs.getString("description");
       Date requestedDate = rs.getDate("requested_date");
      Date resolvedDate = rs.getDate("resolved_date");
        Double finalCost = rs.getDouble("final_cost");
        String status = rs.getString("status");
 
       
       return new Request (name,tenantId,managerId,maintenanceId,requestType,description,
    		   requestedDate,resolvedDate,finalCost,status);
    }
}