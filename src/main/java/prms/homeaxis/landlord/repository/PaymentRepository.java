package prms.homeaxis.landlord.repository;

import java.util.List;
import java.util.Map;

import prms.homeaxis.landlord.entities.Payments;

public interface PaymentRepository {
	
	public List<Map<String,Object>> getAllPayments();
	public int updatePaymentStatus(int paymentId, String status);
	List<Map<String,Object>>fetchAllPayments(int managerId);
	int updatePaymentstatus(Integer paymentId, String status);

}
