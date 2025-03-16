package prms.homeaxis.landlord.entities;

public class Landlord {
	private int landlordId;
	private String bankDetails;
	private String upiDetails;

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getUpiDetails() {
		return upiDetails;
	}

	public void setUpiDetails(String upiDetails) {
		this.upiDetails = upiDetails;
	}

	public Landlord() {
		super();
	}

	public Landlord(int landlordId) {
		super();
		this.landlordId = landlordId;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + "]";
	}
	
	
	
	

}
