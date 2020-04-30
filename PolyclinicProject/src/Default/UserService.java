package Default;

import java.util.Map;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService {
	private static HashMap<String, User> users = new HashMap<>();
	private Database database;

	public List<User> findAll() {
		database = new Database();
		ResultSet resultSet = database.executeStatement("select * from EMPLOYEE;");

		final List<User> users = new ArrayList<>();

		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					final String username = resultSet.getString("username_");
					final String password = resultSet.getString("password_");
					final String firstName = resultSet.getString("firstName");
					final String lastName = resultSet.getString("lastName");
					final String CNP = resultSet.getString("CNP");
					final String address = resultSet.getString("address");
					final String telephoneNumber = resultSet.getString("telephoneNumber");
					final String email = resultSet.getString("email");
					final String iban = resultSet.getString("IBAN");
					final int ID = resultSet.getInt("employeeNo");
					final int contractNumber = resultSet.getInt("contractNumber");
					final String employeeType = resultSet.getString("employeeType");
					final Date date = resultSet.getDate("employmentDate");
					final int hours = resultSet.getInt("hoursPerMonth");
					final int salary = resultSet.getInt("negotiatedSalary");
					final String department = resultSet.getString("departmentName");
					final User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setCNP(CNP);
					user.setAddress(address);
					user.setTelephoneNumber(telephoneNumber);
					user.setEmail(email);
					user.setIban(iban);
					user.setID(ID);
					user.setContractNumber(contractNumber);
					user.setJob(employeeType);
					user.setEmploymentDate(date);
					user.setNoOfHours(hours);
					user.setSalary(salary);
					user.setDepartment(department);
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}

	public void save(final User user) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into POLICLINICA2.EMPLOYEE (username_, password_, CNP, firstName, lastName, address, telephoneNumber, email, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getCNP());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getTelephoneNumber());
			preparedStatement.setString(8, user.getEmail());
			preparedStatement.setString(9, user.getIban());
			preparedStatement.setInt(10, user.getContractNumber());
			preparedStatement.setDate(11, (Date) user.getEmploymentDate());
			preparedStatement.setString(12, user.getJob());
			preparedStatement.setInt(13, user.getNoOfHours());
			preparedStatement.setInt(14, user.getSalary());
			if (user.getJob().equals("Asistent medical") || user.getJob().equals("Medic")) {
				preparedStatement.setString(15, "Medical");
			} else if (user.getJob().equals("Receptioner") || user.getJob().equals("Inspector resurse umane")) {
				preparedStatement.setString(15, "Resurse umane");
			} else if (user.getJob().equals("Administrator")) {
				preparedStatement.setString(15, "Administrator");
			} else if (user.getJob().equals("Super-administrator")) {
				preparedStatement.setString(15, "Super-administrator");
			} else {
				preparedStatement.setString(15, "Financiar contabil");
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUser(User newUser) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE EMPLOYEE SET password_ = ?, employeeType = ?, CNP = ?, firstName = ?, lastName = ?, address = ?, telephoneNumber = ?, EMAIL = ?, IBAN = ?, employmentDate = ?, hoursPerMonth = ?, negotiatedSalary = ? WHERE username_= ?");
			preparedStatement.setString(1, newUser.getPassword());
			preparedStatement.setString(2, newUser.getJob());
			preparedStatement.setString(3, newUser.getCNP());
			preparedStatement.setString(4, newUser.getFirstName());
			preparedStatement.setString(5, newUser.getLastName());
			preparedStatement.setString(6, newUser.getAddress());
			preparedStatement.setString(7, newUser.getTelephoneNumber());
			preparedStatement.setString(8, newUser.getEmail());
			preparedStatement.setString(9, newUser.getIban());
			preparedStatement.setDate(10, (Date) newUser.getEmploymentDate());
			preparedStatement.setInt(11, newUser.getNoOfHours());
			preparedStatement.setInt(12, newUser.getSalary());
			preparedStatement.setString(13, newUser.getUsername());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveMedicalAssistant(final String firstName, final String lastName, final String degree,
			final String type) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call ADD_MEDICAL_ASSISTANT(?, ?, ?, ?)}");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, type);
			preparedStatement.setString(4, degree);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUserType(String username) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareCall("{call VIEW_USERTYPE_BY_USERNAME(?)}");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			String userType = new String();
			if (resultSet.next()) {
				userType = resultSet.getString("userType");
			}
			return userType;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveDoctor(String firstName, String lastName, String degree, String scientificTitle,
			String teachingSpot, float percentage, String stamp) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call ADD_DOCTOR(?, ?, ?, ?, ?, ?, ?)}");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, degree);
			preparedStatement.setString(4, scientificTitle);
			preparedStatement.setString(5, teachingSpot);
			preparedStatement.setFloat(6, percentage);
			preparedStatement.setString(7, stamp);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAppointment(User doctor, String patFirstName, String patLastName, String patCNP, Timestamp date) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call ADD_APPOINTMENT_V2(?, ?, ?, ?, ?, ?)}");
			preparedStatement.setString(1, patCNP);
			preparedStatement.setString(2, patFirstName);
			preparedStatement.setString(3, patLastName);
			preparedStatement.setString(4, doctor.getFirstName());
			preparedStatement.setString(5, doctor.getLastName());
			preparedStatement.setTimestamp(6, date);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAppointmentServices(User doctor, String patFirstName, String patLastName, String investigationName) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call ADD_MEDICAL_SERVICE_TO_APPOINTMENT(?, ?, ?, ?, ?)}");
			preparedStatement.setString(1, investigationName);
			preparedStatement.setString(2, patFirstName);
			preparedStatement.setString(3, patLastName);
			preparedStatement.setString(4, doctor.getFirstName());
			preparedStatement.setString(5, doctor.getLastName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addPatient(String firstName, String lastName, String CNP) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into PATIENT(patientCNP, patient_firstName, patient_lastName) values (?, ?, ?)");
			preparedStatement.setString(1, CNP);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addSpeciality(String firstName, String lastName, String speciality) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call ADD_SPECIALITY_TO_DOCTOR(?, ?, ?)}");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, speciality);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MedicalAssistantData retrieveMedicalAssistantData(User medicalAssistant) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select * from medical_assistant where medical_assistant.employeeNo = ?");
			preparedStatement.setInt(1, medicalAssistant.getID());
			resultSet = preparedStatement.executeQuery();
			MedicalAssistantData assistantData = new MedicalAssistantData();
			if (resultSet.next()) {
				assistantData.setDegree(resultSet.getString("degree"));
				assistantData.setDomain(resultSet.getString("assistantType"));
			}
			return assistantData;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MedicData retrieveMedicData(User medic) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from doctor where doctor.employeeNo = ?");
			preparedStatement.setInt(1, medic.getID());
			resultSet = preparedStatement.executeQuery();
			MedicData doctor = new MedicData();
			if (resultSet.next()) {
				doctor.setDegree(resultSet.getString("degree"));
				doctor.setPercentage(resultSet.getFloat("percentage"));
				doctor.setScientificTitle(resultSet.getString("scientificTitle"));
				doctor.setTeachingSpot(resultSet.getString("teachingSpot"));
				doctor.setStamp(resultSet.getString("stamp"));
			}
			return doctor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveAppointmentsForDoctor(User doctor) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_APPOINTMENT_BY_DOCTOR(?, ?)}");
			preparedStatement.setString(1, doctor.getFirstName());
			preparedStatement.setString(2, doctor.getLastName());
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getString("PATIENT FIRST NAME") + " "
						+ resultSet.getString("PATIENT LAST NAME").toString() + " ("
						+ resultSet.getString("PATIENT CNP") + ") - "
						+ resultSet.getTimestamp("CONSULATION DATE").toString());
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveSpecialities(User medic) {
		List<String> specialities = new ArrayList<String>();
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select * from add_speciality where add_speciality.employeeNo = ?");
			preparedStatement.setInt(1, medic.getID());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				specialities.add(resultSet.getString("specialityName"));
			}
			return specialities;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveMedicalServicesForDoctor(User doctor) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_APPOINTMENT_SERVICES(?, ?)}");
			preparedStatement.setString(1, doctor.getFirstName());
			preparedStatement.setString(2, doctor.getLastName());
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add("(" + String.format("%d", resultSet.getInt("APPOINTMENT ID")) + ") "
						+ String.format("%d", resultSet.getInt("SERVICE ID")) + " - "
						+ resultSet.getString("PATIENT FIRST NAME").toString() + " "
						+ resultSet.getString("PATIENT LAST NAME").toString() + " ("
						+ resultSet.getString("PATIENT CNP") + ") - "
						+ resultSet.getTimestamp("CONSULTATION DATE").toString() + " - "
						+ resultSet.getString("SERVICE NAME"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteMedicalService(int medicalServiceId, int appointmentId) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call DELETE_APPOINTMENT_SERVICES(?, ?)}");
			preparedStatement.setInt(1, medicalServiceId);
			preparedStatement.setInt(2, appointmentId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public InvestigationData searchInvestigation(String investigation) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		InvestigationData data = new InvestigationData();
		try {
			preparedStatement = connection
					.prepareStatement("select * from INVESTIGATIONS where INVESTIGATIONS.investigationName = ?");
			preparedStatement.setString(1, investigation);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				data.setAbility(resultSet.getString("ability"));
				data.setDuration(resultSet.getInt("duration"));
				data.setInvestigationName(resultSet.getString("investigationName"));
				data.setPrice(resultSet.getFloat("price"));
				data.setSpecialityName(resultSet.getString("specialityName"));
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveGenericTimetable(User user) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call GENERIC_TIMETABLE_BY_NAME(?, ?)}");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getString("WEEKDAY") + ": " + resultSet.getTime("DAY START").toString() + " - "
						+ resultSet.getTime("DAY END") + "; location: " + resultSet.getString("MEDICAL UNIT"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveSpecificTimetable(User user) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call SPECIFIC_TIMETABLE_BY_NAME(?, ?)}");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getDate("DATE").toString() + ": " + resultSet.getTime("DAY START").toString()
						+ " - " + resultSet.getTime("DAY END") + "; location: " + resultSet.getString("MEDICAL UNIT"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveGenericTimetableByJob(String jobName) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_GENERIC_TIMETABLE_BY_TYPE(?)}");
			preparedStatement.setString(1, jobName);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getString("FIRST NAME").toString() + " "
						+ resultSet.getString("LAST NAME").toString() + " - " + resultSet.getString("MEDICAL UNIT NAME")
						+ " - " + resultSet.getString("WEEKDAY") + ": " + resultSet.getTime("DAY START") + " - "
						+ resultSet.getTime("END TIME"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveMedicalUnitProgram(int id) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_MEDICAL_UNIT_PROGRAM(?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getString("MEDICAL UNIT NAME").toString() + " - "
						+ resultSet.getString("WEEKDAY").toString() + " - " + resultSet.getTime("DAY START") + " - "
						+ resultSet.getTime("DAY END"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveMedicalUnitVacations(int id) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> timetable = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_VACATION_FROM_MEDICAL_UNIT(?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				timetable.add(resultSet.getString("FIRST NAME") + " " + resultSet.getString("LAST NAME") + " - "
						+ resultSet.getDate("START DATE").toString() + " - " + resultSet.getDate("END DATE").toString()
						+ " - " + resultSet.getString("VACATION DETAILS"));
			}
			return timetable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveAllPatients() {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> patients = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_REGISTERED_PATIENTS()}");
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				patients.add(resultSet.getString("FIRST NAME") + " " + resultSet.getString("LAST NAME") + " - "
						+ resultSet.getString("PATIENT CNP"));
			}
			return patients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retrieveAllAppointments() {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> appointments = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_APPOINTMENTS()}");
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				appointments.add("App. " + String.format("%d", resultSet.getInt("APPOINTMENT ID")) + " ("
						+ String.format("%d", resultSet.getInt("INVESTIGATION ID")) + ") "
						+ resultSet.getString("DOCTOR FIRST NAME") + " " + resultSet.getString("DOCTOR LAST NAME")
						+ " - " + resultSet.getString("PATIENT FIRST NAME") + " "
						+ resultSet.getString("PATIENTT LAST NAME") + " (" + resultSet.getString("PATIENT CNP") + ") "
						+ resultSet.getTimestamp("CONSULTATION DATE"));
			}
			return appointments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addMedicalReport(int appointmentId) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call CREATE_MEDICAL_RAPORT(?)}");
			preparedStatement.setInt(1, appointmentId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String retrieveMedicalReport(int appointmentId) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String report = new String();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_MEDICAL_RAPORT_BY_ID(?)}");
			preparedStatement.setInt(1, appointmentId);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			if (resultSet.next()) {
				report = ("Doctor: " + resultSet.getString("DOCTOR FIRST NAME") + " "
						+ resultSet.getString("DOCTOR LAST NAME") + "\n" + "Patient: "
						+ resultSet.getString("PATIENT FIRST NAME") + " " + resultSet.getString("PATIENT LAST NAME")
						+ "\n" + "CNP: " + resultSet.getString("PATIENT CNP") + "\n" + "Consultation date: "
						+ resultSet.getTimestamp("CONSULTATION DATE") + "\n" + "Symptoms: "
						+ resultSet.getString("SYMPTOMS") + "\n" + "Diagnostic: " + resultSet.getString("DIAGNOSTIC")
						+ "\n" + "Recommendations: " + resultSet.getString("RECOMMENDATIONS") + "\n" + "Stamp: "
						+ resultSet.getString("STAMP"));
			}
			return report;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateMedicalReport(int id, String symptoms, String diagnostic, String recommendations) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call COMPLETE_MEDICAL_RAPORT(?, ?, ?, ?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, symptoms);
			preparedStatement.setString(3, diagnostic);
			preparedStatement.setString(4, recommendations);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReportAssistant(int apId, int servId, String details) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call UPDATE_MEDICAL_RAPORT_SERVICE(?, ?, ?)}");
			preparedStatement.setInt(1, apId);
			preparedStatement.setInt(2, servId);
			preparedStatement.setString(3, details);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> retrieveServicesByReport(int id) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		List<String> services = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_MEDICAL_RAPORT_SERVICES(?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				services.add("Rap. " + String.format("%d", resultSet.getInt("MEDICAL RAPORT ID")) + " - serv. "
						+ String.format("%d", resultSet.getInt("MEDICAL SERVICE ID")) + ": "
						+ resultSet.getString("MEDICAL SERVICE") + "\n" + "Details: " + resultSet.getString("DETAILS"));
			}
			return services;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addResult(int id, boolean value) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call MEDICAL_RAPORT_RESULT(?, ?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.setBoolean(2, value);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void stamp(int id) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call STAMP_MEDICAL_RAPORT(?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void calculateSalary() {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call UPDATE_SALARY()}");
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String viewSalaryByName(String firstName, String lastName) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String salaries = new String();
		try {
			preparedStatement = connection.prepareCall("{call VIEW_SALARY_BY_NAME(?, ?)}");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				salaries = String.format("%f", resultSet.getFloat("SALARY")) + " - " + resultSet.getDate("MONTH START").toString()
						+ " to " + resultSet.getDate("MONTH END").toString();
			}
			return salaries;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String calculateProfit(Date month) {
		database = new Database();
		final Connection connection = database.getConnection();
		String profit = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareCall("{call CALCULATE_PROFIT(?)}");
			preparedStatement.setDate(1, month);
			preparedStatement.executeQuery();
			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				profit = String.format("%f", resultSet.getFloat("PROFIT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profit;
	}
	
	public void generateReceipt(int id) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("{call CREATE_RECEIPT_MEDICAL_RAPORT(?)}");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void create(User user) {
		String username = user.getUsername();
		if (username != null) {
			users.put(username, user);
		}
	}

	public static User get(String username) {
		return users.get(username);
	}

	public static void remove(String username) {
		users.remove(username);
	}

	public static boolean userExists(String username) {
		if (users.containsKey(username))
			return true;
		else
			return false;
	}

	public static HashMap<String, User> getMap() {
		return users;
	}
}
