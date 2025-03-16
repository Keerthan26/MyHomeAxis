package prms.homeaxis.landlord.repository;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.user.repository.ManagerRowMapper;
import prms.homeaxis.utils.Utils;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertProperty(Property property) {
		Blob image = Utils.convertToBlob(property.getImage());

		String query = "INSERT INTO property (title, description, address, price, swimming_pool,"
				+ " gym, parking, garden, ac, lift, cctv, wifi, furnished, image, status, type_id, CreatedAt) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		return jdbcTemplate.update(query, property.getTitle(), property.getDescription(), property.getAddress(),
				property.getPrice(), property.isSwimmingPool(), property.isGym(), property.isParking(),
				property.isGarden(), property.isAc(), property.isLift(), property.isCctv(), property.isWifi(),
				property.isFurnished(), image, property.getStatus(), property.getTypeId());
	}

	@Override
	public int assignManagerToProperty(int managerId, int propertyId) {
		String sql = "UPDATE property SET manager_id = ? WHERE property_id = ?";
		return jdbcTemplate.update(sql, managerId, propertyId);

	}

	public List<Property> fetchAllProperties() {

		String sql = "SELECT p.*, pt.type_name AS type FROM property p "
				+ "JOIN property_type pt ON p.type_id = pt.type_id WHERE p.status = 'Active' "; // Add this line
		return jdbcTemplate.query(sql, new PropertyRowMapper());

	}

	@Override
	public List<Property> getAllProperty() {
		String sql = "SELECT property_id,title FROM property";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Property.class));
	}

	@Override
	public List<Map<String,Object>> viewAllPropertyStatus() {
		String sql = "SELECT  \r\n"
		           + "    p.title AS property_title,\r\n"
		           + "    u.mobile_no, u.name AS manager_name\r\n"
		           + "FROM \r\n"
		           + "    property p\r\n"
		           + "LEFT JOIN \r\n"
		           + "    managers mgr ON p.manager_id = mgr.manager_id\r\n"
		           + "LEFT JOIN \r\n"
		           + "    user u ON mgr.manager_id = u.user_id";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Manager> getAssignedManagers(int propertyId) {
		String sql = "SELECT m.* FROM managers m JOIN property p ON"
				+ " m.manager_id = p.manager_id WHERE p.property_id = ?";
		return jdbcTemplate.query(sql, new Object[] { propertyId }, new ManagerRowMapper());
	}

	@Override
	public Property findById(Long id) {
		String sql = "SELECT * FROM property WHERE property_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new PropertyRowMapper());
	}

	@Override
	public int updateProperty(Property property) {
	    Blob image = Utils.convertToBlob(property.getImage());
	    String sql = "UPDATE property SET title = ?, description = ?, price = ?, address = ?, swimming_pool = ?, gym = ?, parking = ?, "
	               + "garden = ?, ac = ?, lift = ?, cctv = ?, wifi = ?, furnished = ?, image = ? WHERE property_id = ?";
	    return jdbcTemplate.update(sql, property.getTitle(), property.getDescription(), property.getPrice(),
	            property.getAddress(), property.isSwimmingPool(), property.isGym(), property.isParking(),
	            property.isGarden(), property.isAc(), property.isLift(), property.isCctv(), property.isWifi(),
	            property.isFurnished(), image, property.getPropertyId());
	}

	@Override
	public int deletePropertyById(int propertyId) {
		 String sql = "DELETE FROM property WHERE property_id = ?";
	       return jdbcTemplate.update(sql, propertyId);
	}
	
	@Override
	public List<Property> findPropertyByUserId(int userId) {
		String sql = "SELECT p.* FROM property p " +
                "JOIN tenants t ON p.property_id = t.property_id " +
                "WHERE t.tenant_id = ?";
		return jdbcTemplate.query(sql, new Object[] { userId }, new PropertyRowMapper());
 
	}
}
