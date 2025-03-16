package prms.homeaxis.landlord.service;

import java.util.List;
import java.util.Map;

import prms.homeaxis.landlord.entities.Payments;
import prms.homeaxis.landlord.entities.Property;

public interface PaymentsService {
	
	public List<Map<String,Object>> getAllPayments();
	public int updatePaymentStatus(int paymentId, String status);
	List<Map<String,Object>> getAllPayments(int managerId);
	 
	int updatePaymentstatus(Integer paymentId, String status);
}
