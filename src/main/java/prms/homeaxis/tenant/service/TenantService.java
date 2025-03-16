package prms.homeaxis.tenant.service;

import java.util.List;
import java.util.Map;

import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.User;

public interface TenantService {
	List<User> getAllTenants();
	
	List<Map<String,Object>> getAllTenant(int managerId);
	int updateTenantStatus(int tenantId, String tenantStatus);

}
