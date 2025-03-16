package prms.homeaxis.tenant.repository;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.tenant.entities.MaintenanceRequest;
import prms.homeaxis.utils.Utils;

public class MaintenanceRequestRowMapper implements RowMapper<MaintenanceRequest> {
	
	// `maintenance_id`, `request_type`, `description`, `photo`, `status`,
		// `manager_id`,
		// `tenant_id`, `requested_date`, `resolved_date`, `final_cost`


	@Override
	public MaintenanceRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		int maintenanceId=rs.getInt("maintenance_id");
		String requestType=rs.getString("request_type");
		String description=rs.getString("description");
		String status=rs.getString("status");
		Blob image=rs.getBlob("photo");
		int managerId=rs.getInt("manager_id");
		int tenantId=rs.getInt("tenant_id");
		Date requestedDate=rs.getDate("requested_date");
		Date resolvedDate=rs.getDate("resolved_date");
		float finalCost=rs.getFloat("final_cost");
		
		MultipartFile photo = Utils.convertToMultipart(image);
		
		return new MaintenanceRequest(maintenanceId, requestType, description,
				photo, status, managerId, tenantId, requestedDate, resolvedDate, finalCost);
	}

	
}
