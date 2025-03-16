package prms.homeaxis.tenant.repository;

import java.util.List;
import java.util.Map;

import prms.homeaxis.user.entities.User;


public interface TenantRepository {
	
	List<User> fetchAllTenants();
	List<Map<String, Object>> fetchAllTenant(int managerId);
	int updateTenantStatus(int tenantId, String tenantStatus);

}
