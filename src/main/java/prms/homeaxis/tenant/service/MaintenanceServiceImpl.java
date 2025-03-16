package prms.homeaxis.tenant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prms.homeaxis.tenant.entities.MaintenanceRequest;
import prms.homeaxis.tenant.repository.MaintenanceRepository;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{
	
	@Autowired
	MaintenanceRepository maintenanceRepository;

	@Override
	public List<Map<String, Object>> getAllRequests() {
		return maintenanceRepository.fetchAllRequests();
	}

	@Override
	public int updateMaintenanceStatus(int maintenanceId, String status) {
		return maintenanceRepository.updateMaintenanceStatus(maintenanceId, status);
	}

}
