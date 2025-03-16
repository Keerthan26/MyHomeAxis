package prms.homeaxis.landlord.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prms.homeaxis.landlord.entities.Payments;
import prms.homeaxis.landlord.repository.PaymentRepository;
@Service
public class PaymentsServiceImpl implements PaymentsService{

	@Autowired
	PaymentRepository paymentRepository;
	@Override
	public List<Map<String,Object>> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.getAllPayments();
	}
	@Override
	public int updatePaymentStatus(int paymentId, String status) {
		
		return paymentRepository.updatePaymentStatus(paymentId, status);
		
	}
	@Override
    public List<Map<String,Object>> getAllPayments(int managerId) {
        return paymentRepository.fetchAllPayments(managerId);
    }
	@Override
	public int updatePaymentstatus(Integer paymentId, String status) {
		
		return paymentRepository.updatePaymentstatus(paymentId,status);
	}


}
