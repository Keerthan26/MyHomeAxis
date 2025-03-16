package prms.homeaxis.user.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import prms.homeaxis.tenant.entities.Tenant;

public class TenantRowMapper implements RowMapper<Tenant> {

	@Override
	public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
		// `tenant_id`, `tenant_type`, `no_of_person`, `tenant_status`,
		// `created_at`, `updated_at`, `property_id`, `user_id`
		int tenantId = rs.getInt("tenant_id");
		String tenantType = rs.getString("tenant_type");
		int noOfPerson = rs.getInt("no_of_person");
		String tenantStatus = rs.getString("tenant_status");
		Date createdAt = rs.getDate("created_at");
		Date updatedAt = rs.getDate("updated_at");

		return new Tenant(tenantId, tenantType, noOfPerson, tenantStatus, createdAt, updatedAt);
	}

}
