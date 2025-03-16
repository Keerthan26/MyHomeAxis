package prms.homeaxis.tenant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prms.homeaxis.tenant.repository.TenantRepository;
import prms.homeaxis.user.entities.User;

@Service
public class TenantServiceImpl implements TenantService{
	
	@Autowired
	TenantRepository tenantRepository;

	@Override
	public List<User> getAllTenants() {
		
		return tenantRepository.fetchAllTenants();
	}
	@Override
	public List<Map<String, Object>> getAllTenant(int managerId) {
		
		return tenantRepository.fetchAllTenant( managerId);
	}



	@Override
	public int updateTenantStatus(int tenantId, String tenantStatus) {
		
		return tenantRepository.updateTenantStatus(tenantId, tenantStatus);
		
	}

	
	}

