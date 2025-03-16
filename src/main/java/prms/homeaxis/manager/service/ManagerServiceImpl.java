package prms.homeaxis.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.manager.repository.ManagerRepository;
import prms.homeaxis.user.entities.User;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public List<Map<String,Object>> getAllManger() {
		return managerRepository.fetchAllManagers();
	}

	@Override
	public List<Map<String,Object>> getAllManagers() {
		return managerRepository.getAllManagers();
	}

	@Override
	public List<Map<String,Object>> getApprovedManagers() {
		return managerRepository.getApprovedManagers();
	}

}
