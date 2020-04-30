package Default;

import java.util.ArrayList;
import java.util.List;

public class MedicData {
	private List<String> specialities = new ArrayList<String>();
	private String degree;
	private String stamp;
	private String scientificTitle;
	private String teachingSpot;
	private float percentage;
	
	public List<String> getSpecialities() {
		return specialities;
	}
	public void addSpeciality(String speciality) {
		specialities.add(speciality);
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getStamp() {
		return stamp;
	}
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
	public String getScientificTitle() {
		return scientificTitle;
	}
	public void setScientificTitle(String scientificTitle) {
		this.scientificTitle = scientificTitle;
	}
	public String getTeachingSpot() {
		return teachingSpot;
	}
	public void setTeachingSpot(String teachingSpot) {
		this.teachingSpot = teachingSpot;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
}
