package prms.homeaxis.manager.repository;

import java.util.List;
import java.util.Map;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.user.entities.User;

public interface ManagerRepository {
	
	List<Map<String,Object>> fetchAllManagers();
	List<Map<String,Object>> getAllManagers();
	List<Map<String,Object>> getApprovedManagers();

}
