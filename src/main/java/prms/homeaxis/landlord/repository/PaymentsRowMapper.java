package prms.homeaxis.landlord.repository;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.landlord.entities.Payments;
import prms.homeaxis.utils.Utils;

public class PaymentsRowMapper implements RowMapper<Payments>{

	@Override
	public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {

		//`payment_id`, `tenant_id`, `manager_id`, `property_id`, `payment_method`,
		// `rental_price`, `rent_paid`, `rent_balance`, `payment_date`, `receipt`,
		// `status`
		
		int paymentId=rs.getInt("payment_id");
		int tenantId=rs.getInt("tenant_id");
		int managerId=rs.getInt("manager_id");
		int propertyId=rs.getInt("property_id");
		String paymentMethod=rs.getString("payment_method");
		float retalPrice=rs.getFloat("rental_price");
		float rentPaid=rs.getFloat("rent_paid");
		float rentbalance=rs.getFloat("rent_balance");
		Date PaymentDate=rs.getDate("payment_date");
		Blob receipt =rs.getBlob("receipt");
		String status=rs.getString("status");
		
		MultipartFile Receipt = Utils.convertToMultipart(receipt);
		
		return new Payments(paymentId, tenantId, managerId, propertyId, paymentMethod, 
				retalPrice, rentPaid, rentbalance, PaymentDate, Receipt, status);
	}

}
