package prms.homeaxis.user.repository;

import java.util.List;
import java.util.Optional;

import prms.homeaxis.landlord.entities.Landlord;
import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.Role;
import prms.homeaxis.user.entities.User;

public interface UserRepository {
	
	int insertManager(User user,Manager manager);
	List<Role>fetchAllRoles();
	Optional<User> getUserBy(String username);
	int insertTenant(User user,Tenant tenant);
	int toogleAuthority(int userId);
	int updatePassword(User user);
	List<User> fetchAllUsers();
	void updateProfile(User user);


}
