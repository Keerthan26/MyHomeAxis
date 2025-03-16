package prms.homeaxis.manager.entities;
 
 
import java.sql.Date;
 
 
public class Request {
	private String name;
	private int tenantId;
	private int managerId;
	private int maintenanceId;//AI PK
	private String requestType;
	private String description;
	private Date requestedDate;
	private Date resolvedDate;
    private double finalCost;
    private String status;// enum('open','completed','cancelled')
	
	public Request() {
		super();
	
	}
 
	public Request(String name, int tenantId, int managerId, int maintenanceId, String requestType, String description,
			Date requestedDate, Date resolvedDate, double finalCost, String status) {
		super();
		this.name = name;
		this.tenantId = tenantId;
		this.managerId = managerId;
		this.maintenanceId = maintenanceId;
		this.requestType = requestType;
		this.description = description;
		this.requestedDate = requestedDate;
		this.resolvedDate = resolvedDate;
		this.finalCost = finalCost;
		this.status = status;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
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
 
	public double getFinalCost() {
		return finalCost;
	}
 
	public void setFinalCost(double finalCost) {
		this.finalCost = finalCost;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	@Override
	public String toString() {
		return "Request [name=" + name + ", tenantId=" + tenantId + ", managerId=" + managerId + ", maintenanceId="
				+ maintenanceId + ", requestType=" + requestType + ", description=" + description + ", requestedDate="
				+ requestedDate + ", resolvedDate=" + resolvedDate + ", finalCost=" + finalCost + ", status=" + status
				+ "]";
	}
 
	
 
	
}