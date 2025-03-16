package prms.homeaxis.landlord.entities;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.user.entities.User;

public class Property extends User{
	// `property_id`, `title`, `description`, `address`, `price`, `swimming_pool`,
	// `gym`, `parking`, `garden`, `ac`, `lift`, `cctv`, `wifi`, `furnished`,
	// `image`, `status`, `type_id`, `manager_id`, `CreatedAt`

	private int propertyId;
	private String title;
	private String description;
	private String address;
	private int price;
	private boolean swimmingPool;
	private boolean gym;
	private boolean parking;
	private boolean garden;
	private boolean ac;
	private boolean lift;
	private boolean cctv;
	private boolean wifi;
	private boolean furnished;
	private MultipartFile image;
	private String status;
	private int typeId;
	private int managerId;
	private Date createdAt;

	public Property() {
		super();
	}

	public Property(int propertyId, String title, String description, String address, int price, boolean swimmingPool,
			boolean gym, boolean parking, boolean garden, boolean ac, boolean lift, boolean cctv, boolean wifi,
			boolean furnished, MultipartFile image, String status, int typeId, int managerId, Date createdAt) {
		super();
		this.propertyId = propertyId;
		this.title = title;
		this.description = description;
		this.address = address;
		this.price = price;
		this.swimmingPool = swimmingPool;
		this.gym = gym;
		this.parking = parking;
		this.garden = garden;
		this.ac = ac;
		this.lift = lift;
		this.cctv = cctv;
		this.wifi = wifi;
		this.furnished = furnished;
		this.image = image;
		this.status = status;
		this.typeId = typeId;
		this.managerId = managerId;
		this.createdAt = createdAt;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isLift() {
		return lift;
	}

	public void setLift(boolean lift) {
		this.lift = lift;
	}

	public boolean isCctv() {
		return cctv;
	}

	public void setCctv(boolean cctv) {
		this.cctv = cctv;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", title=" + title + ", description=" + description + ", address="
				+ address + ", price=" + price + ", swimmingPool=" + swimmingPool + ", gym=" + gym + ", parking="
				+ parking + ", garden=" + garden + ", ac=" + ac + ", lift=" + lift + ", cctv=" + cctv + ", wifi=" + wifi
				+ ", furnished=" + furnished + ", image=" + image + ", status=" + status + ", typeId=" + typeId
				+ ", managerId=" + managerId + ", createdAt=" + createdAt + "]";
	}

}
