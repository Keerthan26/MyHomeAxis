package prms.homeaxis.user.repository;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.user.entities.User;
import prms.homeaxis.utils.Utils;

public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		// `user_id`, `name`, `email_id`, `mobile_no`, `date_of_birth`, `username`,
		// `passwordSalt`, `passwordHash`, `status`, `role_id`, `profile_image`,
		// `id_proof`
		int userId = rs.getInt("user_id");
		String name = rs.getString("name");
		String email = rs.getString("email_id");
		String mobile = rs.getString("mobile_no");
		Date dateOfBirth = rs.getDate("date_of_birth");
		Blob blobProfileImage = rs.getBlob("profile_image");
		Blob blobIdProof = rs.getBlob("id_proof");
		String username = rs.getString("username");
		String pwd_salt = rs.getString("passwordSalt");
		String pwd_hash = rs.getString("passwordHash");
		int roleId = rs.getInt("role_id");
		boolean isAuthorized = rs.getBoolean("status");

		MultipartFile profileImage = Utils.convertToMultipart(blobProfileImage);
		MultipartFile idCard = Utils.convertToMultipart(blobIdProof);

		return new User(userId, name, email, mobile, dateOfBirth, username, username, pwd_salt, pwd_hash, roleId,
				isAuthorized, profileImage, idCard);

	}
	
}
