package prms.homeaxis.landlord.repository;

import java.util.List;
import java.util.Map;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.manager.entities.Manager;

public interface PropertyRepository {

	int insertProperty(Property property);
	int assignManagerToProperty(int managerId, int propertyId);
	List<Property> fetchAllProperties();
	List<Property> getAllProperty();
	List<Map<String,Object>> viewAllPropertyStatus();
	List<Manager> getAssignedManagers(int propertyId);
	Property findById(Long id);
	int updateProperty(Property property);
	int deletePropertyById(int propertyId);
	List<Property> findPropertyByUserId(int userId);
	
	
	

}
