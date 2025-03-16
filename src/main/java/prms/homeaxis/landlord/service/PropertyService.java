package prms.homeaxis.landlord.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.repository.PropertyRepository;
import prms.homeaxis.manager.entities.Manager;

public interface PropertyService {
	
	int registerProperty(Property property) ; 
	int assignManagerToProperty(int managerId, int propertyId);
	List<Manager> getAssignedManagers(int propertyId);
	List<Property> getAllProperties();
	List<Property> getAllProperty();
	List<Map<String,Object>> viewAllPropertyStatus();
	Property getPropertyById(Long propertyId);
	int saveProperty(Property property);
	int deletePropertyById(int propertyId);
	List<Property> findPropertyByUserId(int userId);
	
}
