package prms.homeaxis.landlord.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.repository.PropertyRepository;
import prms.homeaxis.manager.entities.Manager;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Override
	public int registerProperty(Property property){
		return propertyRepository.insertProperty(property);
	}

	@Override
	public int assignManagerToProperty(int managerId, int propertyId) {
		return propertyRepository.assignManagerToProperty(managerId, propertyId);
		
	}
	

	@Override
	public List<Manager> getAssignedManagers(int propertyId) {
		return propertyRepository.getAssignedManagers(propertyId);
	}

	@Override
	public List<Property> getAllProperties() {
		
		return propertyRepository.fetchAllProperties();
	}

	@Override
	public List<Property> getAllProperty() {
		return propertyRepository.getAllProperty();
	}

	@Override
	public List<Map<String,Object>> viewAllPropertyStatus() {
		return propertyRepository.viewAllPropertyStatus();
	}

	@Override
	public Property getPropertyById(Long propertyId) {
		return propertyRepository.findById(propertyId);
	}

	@Override
	public int saveProperty(Property property) {
		
		return propertyRepository.updateProperty(property);
	}

	@Override
	public int deletePropertyById(int propertyId) {
		return propertyRepository.deletePropertyById(propertyId);
	}
	@Override
	public List<Property> findPropertyByUserId(int userId) {
		return propertyRepository.findPropertyByUserId(userId);
	}


}
