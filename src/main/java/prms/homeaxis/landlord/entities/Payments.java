package prms.homeaxis.landlord.entities;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.user.entities.User;

public class Payments extends User{
	// `payment_id`, `tenant_id`, `manager_id`, `property_id`, `payment_method`,
	// `rental_price`, `rent_paid`, `rent_balance`, `payment_date`, `receipt`,
	// `status`

	private int paymentId;
	private int tenantId;
	private int managerId;
	private int propertyId;
	private String paymentMethod;
	private float rentalPrice;
	private float rentPaid;
	private float rentBalance;
	private Date paymentDate;
	private MultipartFile receipt;
	private String status;

	public Payments() {
		super();
	}

	public Payments(int paymentId, int tenantId, int managerId, int propertyId, String paymentMethod, float rentalPrice,
			float rentPaid, float rentBalance, Date paymentDate, MultipartFile receipt, String status) {
		super();
		this.paymentId = paymentId;
		this.tenantId = tenantId;
		this.managerId = managerId;
		this.propertyId = propertyId;
		this.paymentMethod = paymentMethod;
		this.rentalPrice = rentalPrice;
		this.rentPaid = rentPaid;
		this.rentBalance = rentBalance;
		this.paymentDate = paymentDate;
		this.receipt = receipt;
		this.status = status;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public float getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public float getRentPaid() {
		return rentPaid;
	}

	public void setRentPaid(float rentPaid) {
		this.rentPaid = rentPaid;
	}

	public float getRentBalance() {
		return rentBalance;
	}

	public void setRentBalance(float rentBalance) {
		this.rentBalance = rentBalance;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public MultipartFile getReceipt() {
		return receipt;
	}

	public void setReceipt(MultipartFile receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", tenantId=" + tenantId + ", managerId=" + managerId
				+ ", propertyId=" + propertyId + ", paymentMethod=" + paymentMethod + ", rentalPrice=" + rentalPrice
				+ ", rentPaid=" + rentPaid + ", rentBalance=" + rentBalance + ", paymentDate=" + paymentDate
				+ ", receipt=" + receipt + ", status=" + status + "]";
	}

}
