package prms.homeaxis.tenant.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.repository.UserRowMapper;

@Repository
public class TenantRepositoryImpl implements TenantRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> fetchAllTenants() {
		final String Tenant="select * from user where role_id = 3";
		return jdbcTemplate.query(Tenant, new UserRowMapper());

	}
	public List<Map<String, Object>> fetchAllTenant(int managerId) {
		final String GET_ALL_TENANTS = " SELECT \r\n" + "u.name,\r\n" + "t.tenant_id,\r\n" + "p.manager_id,\r\n"+"u.mobile_no,\r\n" + "t.tenant_type,\r\n"
				+ "t.no_of_person,\r\n" + "p.title,\r\n" + "t.tenant_status \r\n" + "from \r\n" + "user u \r\n"
				+ "inner join \r\n" + "tenants t \r\n" + "on u.user_id = t.tenant_id \r\n" + "inner join \r\n"
				+ "property p \r\n" + "on t.property_id = p.property_id where p.manager_id = ? \r\n";
		return jdbcTemplate.queryForList(GET_ALL_TENANTS, managerId);
	}
 
	@Override
	public int updateTenantStatus(int tenantId,String tenantStatus) {
		String UPDATE_AUTHORITY="";
		System.out.println("Tenant Status: " + tenantStatus);
		
		if ("active".equals(tenantStatus)) {
			//UPDATE_AUTHORITY = "update tenants set  tenant_status= 'inactive' where tenant_id=? ";
			UPDATE_AUTHORITY = "UPDATE tenants SET tenant_status = 'inactive' WHERE tenant_id = ?";
			System.out.println("Tenant Status query: " + UPDATE_AUTHORITY);
			
		} else {
			//UPDATE_AUTHORITY = "update tenants set  tenant_status= 'active' where tenant_id=?";
			UPDATE_AUTHORITY = "UPDATE tenants SET tenant_status = 'active' WHERE tenant_id = ?";
			System.out.println("Tenant Status query: " + UPDATE_AUTHORITY);
 
		}
		return jdbcTemplate.update(UPDATE_AUTHORITY, tenantId);
 
	}

}
