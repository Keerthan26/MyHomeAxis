package prms.homeaxis.user.repository;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.Role;
import prms.homeaxis.user.entities.User;
import prms.homeaxis.utils.Utils;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertManager(User user, Manager manager) {
		
		Blob profileImage = Utils.convertToBlob(user.getProfileImage());
		Blob idCard = Utils.convertToBlob(user.getIdProof());
		Blob resume = Utils.convertToBlob(manager.getResume());

		int result = 0;

		String userSql = "INSERT INTO user (name, email_id, mobile_no, date_of_birth, username, passwordSalt, passwordHash, status, role_id, profile_image, id_proof) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
			try {
				int userRows = jdbcTemplate.update(connection -> {
					PreparedStatement ps = connection.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getName());
					ps.setString(2, user.getEmailId());
					ps.setString(3, user.getMobile());
					ps.setDate(4, user.getDateOfBirth());
					ps.setString(5, user.getUsername());
					ps.setString(6, user.getPasswordSalt());
					ps.setString(7, user.getPasswordHash());
					ps.setBoolean(8, user.isStatus());
					ps.setInt(9, user.getRole_id());
					ps.setBlob(10, profileImage);
					ps.setBlob(11, idCard);

					return ps;
				}, keyHolder);

				if (userRows > 0) {

					// Retrieve the generated user_id from the user table
					int manager_id = keyHolder.getKey().intValue();

					// Step 2: Insert into the 'manager' table using the generated user_id
					String managerSql = "insert into managers (manager_id ,experience, resume) values (?, ?, ?)";

					int rowsAffectedManager = jdbcTemplate.update(managerSql,manager_id,  manager.getExperience(), resume);
					
					if (rowsAffectedManager > 0) {
						result = 1;
					}
				}
			} catch (InvalidDataAccessApiUsageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return result;
	}

	
	@Override
	public int insertTenant(User user, Tenant tenant) {
		
		Blob profileImage = Utils.convertToBlob(user.getProfileImage());
		Blob idCard = Utils.convertToBlob(user.getIdProof());
		int result = 0;

		String userSql = "INSERT INTO user (name, email_id, mobile_no, date_of_birth, username, passwordSalt, passwordHash, status, role_id, profile_image, id_proof) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		try {
			int userRows = jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmailId());
				ps.setString(3, user.getMobile());
				ps.setDate(4, user.getDateOfBirth());
				ps.setString(5, user.getUsername());
				ps.setString(6, user.getPasswordSalt());
				ps.setString(7, user.getPasswordHash());
				ps.setBoolean(8, user.isStatus());
				ps.setInt(9, user.getRole_id());
				ps.setBlob(10, profileImage);
				ps.setBlob(11, idCard);

				return ps;
			}, keyHolder);
			
			if (userRows > 0) {

				// Retrieve the generated user_id from the user table
				int tenant_id = keyHolder.getKey().intValue();
				String tenantSql = "insert into tenants (tenant_id ,tenant_type, no_of_person,tenant_status,created_at,updated_at)"
						+ " values (?, ?, ?,?,NOW(),NOW())";

				int rowsAffectedManager = jdbcTemplate.update(tenantSql,tenant_id,  tenant.getTenantType(),tenant.getNoOfPerson(),tenant.getTenantStatus());
				
				if (rowsAffectedManager > 0) {
					result = 1;
				}
			}
		} catch (InvalidDataAccessApiUsageException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	@Override
	public List<Role> fetchAllRoles() {

		final String GET_ALL_ROLES = "select * from roles";

		// db column -role_id,role_name
		// java class instance varaiable:roleId ,roleName
		return jdbcTemplate.query(GET_ALL_ROLES, (rs, rowNum) -> {

			int roleId = rs.getInt("role_id");
			String roleName = rs.getString("role_name");

			return new Role(roleId, roleName);

		});
	}

	@Override
	public Optional<User> getUserBy(String username) {
		User user = null;

		final String FETCH_ALL_USERS = "SELECT * FROM user WHERE username=?";

		try {
			user = jdbcTemplate.queryForObject(FETCH_ALL_USERS, new UserRowMapper(), username);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return Optional.ofNullable(user);

	}

	@Override
	public int toogleAuthority(int userId) {
		final String UPDATE_AUTHORITY="update user set  status= !status where user_id=?";
		return jdbcTemplate.update(UPDATE_AUTHORITY,userId);
	}
	
	@Override
	public int updatePassword(User user) {
 
		final String UPDATE_PASSWORD_SQL = "UPDATE user SET passwordSalt = ?, passwordHash = ? WHERE username = ?";
		return jdbcTemplate.update(UPDATE_PASSWORD_SQL, user.getPasswordSalt(), user.getPasswordHash(),
				user.getUsername());
	}

	@Override
	public List<User> fetchAllUsers() {
		String sql="select * from user";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public void updateProfile(User user) {
		Blob profileImage = Utils.convertToBlob(user.getProfileImage());
		Blob idCard = Utils.convertToBlob(user.getIdProof());

		String sql = "UPDATE user SET name = ?,date_of_birth=?, email_id = ?, mobile_no = ?, profile_image = ?, id_proof = ? WHERE user_id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getDateOfBirth(),user.getEmailId(),
				user.getMobile(), profileImage, idCard, user.getUserId());
	}

	

	
}
