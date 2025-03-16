package prms.homeaxis.tenant.entities;

import java.sql.Date;

public class Tenant {

	private int tenantId;
	private String tenantType;
	private int noOfPerson;
	private String tenantStatus;
	private Date createdAt;
	private Date updatedAt;

	public Tenant() {
		super();
	}

	public Tenant(int tenantId, String tenantType, int noOfPerson, String tenantStatus, Date createdAt,
			Date updatedAt) {
		super();
		this.tenantId = tenantId;
		this.tenantType = tenantType;
		this.noOfPerson = noOfPerson;
		this.tenantStatus = tenantStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantType() {
		return tenantType;
	}

	public void setTenantType(String tenantType) {
		this.tenantType = tenantType;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantType=" + tenantType + ", noOfPerson=" + noOfPerson
				+ ", tenantStatus=" + tenantStatus + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
