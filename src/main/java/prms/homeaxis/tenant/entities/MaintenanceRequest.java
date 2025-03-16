package prms.homeaxis.tenant.entities;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MaintenanceRequest {

	// `maintenance_id`, `request_type`, `description`, `photo`, `status`,
	// `manager_id`,
	// `tenant_id`, `requested_date`, `resolved_date`, `final_cost`

	private int maintenanceId;
	private String requestType;
	private String description;
	private MultipartFile photo;
	private String status;
	private int managerId;
	private int tenantId;
	private Date requestedDate;
	private Date resolvedDate;
	private float finalCost;

	public MaintenanceRequest() {
		super();
	}

	public MaintenanceRequest(int maintenanceId, String requestType, String description, MultipartFile photo,
			String status, int managerId, int tenantId, Date requestedDate, Date resolvedDate, float finalCost) {
		super();
		this.maintenanceId = maintenanceId;
		this.requestType = requestType;
		this.description = description;
		this.photo = photo;
		this.status = status;
		this.managerId = managerId;
		this.tenantId = tenantId;
		this.requestedDate = requestedDate;
		this.resolvedDate = resolvedDate;
		this.finalCost = finalCost;
	}

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public float getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(float finalCost) {
		this.finalCost = finalCost;
	}

	@Override
	public String toString() {
		return "MaintenanceRequest [maintenanceId=" + maintenanceId + ", requestType=" + requestType + ", description="
				+ description + ", photo=" + photo + ", status=" + status + ", managerId=" + managerId + ", tenantId="
				+ tenantId + ", requestedDate=" + requestedDate + ", resolvedDate=" + resolvedDate + ", finalCost="
				+ finalCost + "]";
	}

}
