package prms.homeaxis.tenant.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import prms.homeaxis.tenant.entities.MaintenanceRequest;
import prms.homeaxis.user.repository.ManagerRowMapper;
import prms.homeaxis.user.repository.TenantRowMapper;
import prms.homeaxis.user.repository.UserRowMapper;

@Repository
public class MaintenanceRepositoryImpl implements MaintenanceRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>>  fetchAllRequests() {
		String sql = "SELECT \r\n"
				+ "    u.name AS tenant_name,mr.request_type,mr.description,\r\n"
				+ "    t.tenant_type,\r\n"
				
				+ "    mr.status,\r\n"
				+ "    DATE(t.created_at) as created_at,\r\n"
				+ "    m.name AS manager_name\r\n"
				+ "FROM \r\n"
				+ "    maintenance_request mr\r\n"
				+ "JOIN \r\n"
				+ "    tenants t ON mr.tenant_id = t.tenant_id\r\n"
				+ "JOIN \r\n"
				+ "    user u ON t.tenant_id = u.user_id\r\n"
				+ "LEFT JOIN \r\n"
				+ "    managers mgr ON mr.manager_id = mgr.manager_id\r\n"
				+ "LEFT JOIN \r\n"
				+ "    user m ON mgr.manager_id = m.user_id";

		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public int updateMaintenanceStatus(int maintenanceId, String status) {
		String sql = "UPDATE maintenance_request SET status = ? WHERE maintenance_id = ?";
		return jdbcTemplate.update(sql, status, maintenanceId);

	}

}
