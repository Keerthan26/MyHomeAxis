package prms.homeaxis.user.repository;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.utils.Utils;

public class ManagerRowMapper implements RowMapper<Manager>{

	@Override
	public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
		//`manager_id`, `user_id`, `experience`, `resume`, `status`
		
		int managerId=rs.getInt("manager_id");
		int experience=rs.getInt("experience");
		Blob blobResume=rs.getBlob("resume");
		
		MultipartFile resume = Utils.convertToMultipart(blobResume);
		
		return new Manager(managerId, experience, resume);
		

		
		
	}

 

}
