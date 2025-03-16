package prms.homeaxis.landlord.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import prms.homeaxis.landlord.entities.Payments;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Map<String,Object>> getAllPayments() {
		String sql = "SELECT \r\n"
				+ "    u.name AS tenant_name,\r\n"
				+ "    p.title AS property_title,\r\n"
				+ "    pay.rent_paid AS amount,pay.payment_id,\r\n"
				+ "    pay.payment_method,\r\n"
				+ "    pay.payment_date,\r\n"
				+ "    pay.status\r\n"
				+ "FROM \r\n"
				+ "    payment pay\r\n"
				+ "JOIN \r\n"
				+ "    tenants t ON pay.tenant_id = t.tenant_id\r\n"
				+ "JOIN \r\n"
				+ "    user u ON t.tenant_id = u.user_id\r\n"
				+ "JOIN \r\n"
				+ "    property p ON pay.property_id = p.property_id";
		return jdbcTemplate.queryForList(sql);
	}


	@Override
	public int updatePaymentStatus(int paymentId, String status) {
		
		String sql = "UPDATE payment SET status = ? WHERE payment_id = ?";
		return jdbcTemplate.update(sql, status, paymentId);
	}
	public List<Map<String,Object>> fetchAllPayments(int managerId) {
        final String GET_ALL_PAYMENTS =   " SELECT \r\n"
        		  +" u.name, p.payment_id, p.property_id,p.manager_id,  p.payment_method, p.rental_price,\r\n"
        		 +"  p.rent_paid, p.rent_balance, p.payment_date,p.status \r\n"
        		+"from \r\n"
        		+"user u \r\n"
        		+"inner join \r\n"
        		+"payment p \r\n"
        		+"on u.user_id = p.tenant_id where p.manager_id= ? \r\n";
        
        return jdbcTemplate.queryForList(GET_ALL_PAYMENTS ,managerId);
    }
 
	@Override
	public int updatePaymentstatus(Integer paymentId, String status) {
		String UPDATE_AUTHORITY="";
		System.out.println("Payment Status: " + status);
		if ("Approved".equals(status)) {//('Pending','Approved','Declined')
			UPDATE_AUTHORITY = "update payment set  status= 'Pending' where payment_id=? ";
			System.out.println(" Payment Status query: " + UPDATE_AUTHORITY);
		} else {
			UPDATE_AUTHORITY = "update payment set  status= 'Approved' where payment_id=?";
			System.out.println("Payment Status query: " + UPDATE_AUTHORITY);
 
		}
		return jdbcTemplate.update( UPDATE_AUTHORITY, paymentId);
	}

}
