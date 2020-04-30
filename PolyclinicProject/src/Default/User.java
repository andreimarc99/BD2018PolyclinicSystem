package Default;

import java.util.Date;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String iban;
	private String address;
	private String telephoneNumber;
	private Date employmentDate; 
	private String CNP;
	private String job;
	private int salary;
	private int noOfHours;
	private int ID;
	private int contractNumber;
	private String department;
	boolean medicalAssistant;
	boolean medic;
	MedicalAssistantData medicalAssistantData;
	MedicData medicData;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(Date date) {
		this.employmentDate = date;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String cNP) {
		CNP = cNP;
	}
	public int getID() {
		return ID;
	}
	public String getStringID() {
		return String.format("%d", ID);
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	public MedicalAssistantData getMedicalAssistantData() {
		return medicalAssistantData;
	}
	public void setMedicalAssistantData(MedicalAssistantData medicalAssistantData) {
		this.medicalAssistantData = medicalAssistantData;
	}
	
	public boolean isMedicalAssistant() {
		return medicalAssistant;
	}
	public void setMedicalAssistant(boolean medicalAssistant) {
		this.medicalAssistant = medicalAssistant;
	}
	public boolean isMedic() {
		return medic;
	}
	public void setMedic(boolean medic) {
		this.medic = medic;
	}
	public MedicData getMedicData() {
		return medicData;
	}
	public void setMedicData(MedicData medicData) {
		this.medicData = medicData;
	}
	public int getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
