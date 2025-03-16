package prms.homeaxis.landlord.repository;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.utils.Utils;

public class PropertyRowMapper implements RowMapper<Property>{

	@Override
	public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// `property_id`, `title`, `description`, `address`, `price`, `swimming_pool`,
		// `gym`, `parking`, `garden`, `ac`, `lift`, `cctv`, `wifi`, `furnished`,
		// `image`, `status`, `type_id`, `manager_id`, `CreatedAt`
		
		int propertyId=rs.getInt("property_id");
		String title=rs.getString("title");
		String description=rs.getString("description");
		String address=rs.getString("address");
		int price=rs.getInt("price");
		boolean swimmingPool=rs.getBoolean("swimming_pool");
		boolean gym=rs.getBoolean("gym");
		boolean parking=rs.getBoolean("parking");
		boolean garden=rs.getBoolean("garden");
		boolean ac=rs.getBoolean("ac");
		boolean lift=rs.getBoolean("lift");
		boolean cctv=rs.getBoolean("cctv");
		boolean wifi=rs.getBoolean("wifi");
		boolean furnished=rs.getBoolean("furnished");
		Blob image=rs.getBlob("image");
		String status=rs.getString("status");
		int typeId=rs.getInt("type_id");
		int managerId=rs.getInt("manager_id");
		Date created_at=rs.getDate("CreatedAt");
		
		MultipartFile Image = Utils.convertToMultipart(image);
		
		
		return new Property(propertyId, title, description, address, price, swimmingPool, gym,
				parking, garden, ac, lift, cctv, wifi, furnished, Image, status, typeId, managerId, created_at);
				
	}
	
}
