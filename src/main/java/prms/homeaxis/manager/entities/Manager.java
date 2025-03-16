package prms.homeaxis.manager.entities;

import org.springframework.web.multipart.MultipartFile;

import prms.homeaxis.user.entities.User;

public class Manager extends User{
	private int managerId;
	private int experience;
	private MultipartFile resume;

	public Manager() {
		super();
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManager_id(int managerId) {
		this.managerId = managerId;
	}

	

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}

	
	public Manager(int managerId, int user_id, MultipartFile resume) {
		super();
		this.managerId = managerId;
		this.experience = experience;
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Manager [manager_id=" + managerId + ", experience=" + experience + ", resume=" + resume + "]";
	}

	

}
