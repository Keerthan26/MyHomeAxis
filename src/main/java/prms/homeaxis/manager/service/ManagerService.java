package prms.homeaxis.manager.service;

import java.util.List;
import java.util.Map;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.user.entities.User;


public interface ManagerService {
	
	List<Map<String,Object>> getAllManger();
	List<Map<String,Object>> getAllManagers();
	List<Map<String,Object>> getApprovedManagers();

}
