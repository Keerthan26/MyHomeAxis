package prms.homeaxis.user.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.Role;
import prms.homeaxis.user.entities.User;

public interface UserService {
	
	int registerManager(User user,Manager manager);
	int registerTenant(User user,Tenant tenant);
	List<Role> getAllRoles();
	Optional<User>fetchUserBy(String username);
	boolean matchPassword(String pwdFromUI,User userDb);
	int updateAuthority(int userId);
	int resetPassword(User user);
	int updatePassword(User user, String newPassword);
	List<User> getAllUsers();
	void updateUser(User user, MultipartFile profileImage, MultipartFile idProof) throws IOException ;
}
