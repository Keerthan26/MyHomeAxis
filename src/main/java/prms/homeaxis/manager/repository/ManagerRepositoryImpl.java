package prms.homeaxis.manager.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.repository.UserRowMapper;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository {
	@Autowired
	private  JdbcTemplate jdbcTemplate ;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Map<String,Object>> fetchAllManagers() {
		final String MANAGERS="select u.* ,m.experience ,m.manager_id from User u  join managers m where u.user_id=m.manager_id;";
		return jdbcTemplate.queryForList(MANAGERS);
	}


	
	@Override
	public List<Map<String,Object>> getAllManagers() {
		String sql = "SELECT m.*, u.name, u.mobile_no " + "FROM managers m "
				+ "JOIN user u ON m.manager_id = u.user_id ";
		return jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public List<Map<String,Object>> getApprovedManagers() {
		String sql = "SELECT m.*, u.name, u.mobile_no ,u.email_id " + "FROM managers m "
				+ "JOIN user u ON m.manager_id = u.user_id WHERE u.status = 1 ";
		List<Map<String,Object>> m=jdbcTemplate.queryForList(sql);
		System.out.println(m);
		return m;
	}

}
