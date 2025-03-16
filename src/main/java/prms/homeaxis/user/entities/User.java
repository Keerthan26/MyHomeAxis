package prms.homeaxis.user.entities;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	// `user_id`, `name`, `email_id`, `mobile_no`, `date_of_birth`,
	// `username`, `passwordSalt`, `passwordHash`, `status`, `role_id`,
	// `profile_image`, `id_proof`
	private int userId;
	private String name;
	private String emailId;
	private String mobile;
	private Date dateOfBirth;
	private String username;
	private String password;
	private String passwordSalt;
	private String passwordHash;
	private int role_id;
	private boolean status;
	private MultipartFile profileImage;
	private MultipartFile idProof;

	public User() {
		super();
	}

	public User(int userId, String name, String emailId, String mobile, Date dateOfBirth, String username,
			String password, String passwordSalt, String passwordHash, int role_id, boolean status,
			MultipartFile profileImage, MultipartFile idProof) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.passwordHash = passwordHash;
		this.role_id = role_id;
		this.status = status;
		this.profileImage = profileImage;
		this.idProof = idProof;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public MultipartFile getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}

	public MultipartFile getIdProof() {
		return idProof;
	}

	public void setIdProof(MultipartFile idProof) {
		this.idProof = idProof;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", mobile=" + mobile
				+ ", dateOfBirth=" + dateOfBirth + ", username=" + username + ", passwordSalt=" + passwordSalt
				+ ", passwordHash=" + passwordHash + ", role_id=" + role_id + ", status=" + status + "]";
	}
	
	

}
