package prms.homeaxis.user.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.Role;
import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.repository.UserRepository;
import prms.homeaxis.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public int registerManager(User user, Manager manager) {
		String pwdFromUI = user.getPassword();
		String pwdSalt = Utils.generateSalt();
		String modifiedPwd = pwdFromUI + pwdSalt;

		String pwdHash = Utils.generateHash(modifiedPwd);

		user.setPasswordSalt(pwdSalt);
		user.setPasswordHash(pwdHash);
		if (user.getRole_id() == 1)
			user.setStatus(true);

		return userRepository.insertManager(user, manager);
	}

	@Override
	public List<Role> getAllRoles() {

		return userRepository.fetchAllRoles();
	}

	@Override
	public Optional<User> fetchUserBy(String username) {
		return userRepository.getUserBy(username);
	}

	@Override
	public boolean matchPassword(String pwdFromUI, User userDb) {
		String modifiedPwd = pwdFromUI + userDb.getPasswordSalt();
		String newHash = Utils.generateHash(modifiedPwd);
		String oldHash = userDb.getPasswordHash();

		System.out.println(pwdFromUI);
		System.out.println(newHash);
		System.out.println(oldHash);
		return newHash.equals(oldHash);
	}

	@Override
	public int registerTenant(User user, Tenant tenant) {

		String pwdFromUI = user.getPassword();
		String pwdSalt = Utils.generateSalt();
		String modifiedPwd = pwdFromUI + pwdSalt;

		String pwdHash = Utils.generateHash(modifiedPwd);

		user.setPasswordSalt(pwdSalt);
		user.setPasswordHash(pwdHash);
		if (user.getRole_id() == 1)
			user.setStatus(true);

		return userRepository.insertTenant(user, tenant);
	}

	@Override
	public int updateAuthority(int userId) {
		return userRepository.toogleAuthority(userId);
	}

	@Override
	public int updatePassword(User user, String newPassword) {
		String pwdSalt = Utils.generateSalt();
		String modifiedPwd = newPassword + pwdSalt;
		String pwdHash = Utils.generateHash(modifiedPwd);

		user.setPasswordSalt(pwdSalt);
		user.setPasswordHash(pwdHash);

		return userRepository.updatePassword(user);
	}

	@Override
	public int resetPassword(User user) {
		String newPassword = Utils.generateRandomPassword(); // Generate a new random password String
		newPassword = Utils.generateSalt();
		String modifiedPwd = newPassword + newPassword;
		String pwdHash = Utils.generateHash(modifiedPwd);

		user.setPasswordSalt(newPassword);
		user.setPasswordHash(pwdHash);

		return userRepository.updatePassword(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.fetchAllUsers();
	}

	@Override
	public void updateUser(User user, MultipartFile profileImage, MultipartFile idProof) throws IOException {
		if (profileImage != null && !profileImage.isEmpty()) {
			user.setProfileImage(profileImage);
		}
		if (idProof != null && !idProof.isEmpty()) {
			user.setIdProof(idProof);
		}
		userRepository.updateProfile(user);

	}
}
