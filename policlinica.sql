DROP DATABASE IF EXISTS POLICLINICA2;
CREATE DATABASE IF NOT EXISTS POLICLINICA2;

USE POLICLINICA2;



CREATE TABLE IF NOT EXISTS MEDICAL_UNIT(
	unitID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	unitName VARCHAR(255) NOT NULL UNIQUE,
    address TEXT NOT NULL,
	medical_services TEXT,
    PRIMARY KEY(unitID, unitName)
);


#insert for each day/unit
CREATE TABLE IF NOT EXISTS PROGRAM(
	weekday ENUM('Luni', 'Marti', 'Miercuri', 'Joi', 'Vineri', 'Sambata', 'Duminica') NOT NULL, #
	startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    unitID SMALLINT UNSIGNED NOT NULL,
    KEY (weekday),
    FOREIGN KEY (unitID) REFERENCES MEDICAL_UNIT(unitID) ON DELETE CASCADE,
	KEY (unitID)
);


#CREATE TABLE IF NOT EXISTS _USER(
#	email VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
#	username_ BLOB,
#   password_ BLOB,
#	userType ENUM('ADMINISTRATOR','SUPER-ADMINISTRATOR','EMPLOYEE') DEFAULT 'EMPLOYEE',
#    KEY (userType)
#);


	CREATE TABLE IF NOT EXISTS EMPLOYEE (
		employeeNo INT NOT NULL AUTO_INCREMENT,
        email VARCHAR(255) NOT NULL UNIQUE,
		username_ VARCHAR(255) UNIQUE NOT NULL,
		password_ BLOB,
		userType ENUM('ADMINISTRATOR','SUPER-ADMINISTRATOR','EMPLOYEE') DEFAULT 'EMPLOYEE',
		CNP CHAR(13) NOT NULL UNIQUE,
		firstName VARCHAR(30) NOT NULL,
		lastName VARCHAR(30) NOT NULL,
		address TEXT NOT NULL,
		telephoneNumber CHAR(10) NOT NULL UNIQUE,
		IBAN CHAR(24) NOT NULL UNIQUE,
		contractNumber INT UNSIGNED NOT NULL UNIQUE,
		employmentDate DATE NOT NULL, 
		employeeType ENUM ('', 'Asistent Medical', 'Medic', 'Expert financiar-contabil', 'Receptioner', 'Inspector resurse umane') DEFAULT NULL, 
		hoursPerMonth SMALLINT NOT NULL,
		negotiatedSalary DECIMAL(8,2) NOT NULL,
		departmentName ENUM ('', 'Resurse umane', 'Financiar contabil', 'Medical') DEFAULT NULL,
		#FOREIGN KEY (email) REFERENCES _USER(email),
        UNIQUE INDEX name_idx (firstName, lastName),
        UNIQUE INDEX name_employeetype_idx (employeeType, firstName, lastName), #not tested
		KEY (userType),
        KEY (departmentName),
        KEY (employeeType),
        PRIMARY KEY(employeeNo, username_)	
	);


CREATE TABLE IF NOT EXISTS SALARY(
	employeeNo INT NOT NULL,
    salary DECIMAL(8,2) NOT NULL,
    from_date DATE NOT NULL,
    to_date DATE NOT NULL,
	FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE(employeeNo) ON DELETE CASCADE
    #KEY(employeeNo) #from_date
);


CREATE TABLE IF NOT EXISTS VACATION(
	employeeNo INT NULL,
    startTime DATE NOT NULL,
    endTime DATE NOT NULL,
    details TEXT,
    FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE(employeeNo) ON DELETE CASCADE,
    KEY (startTime),
    KEY (endTime)
);

CREATE TABLE IF NOT EXISTS GENERIC_TIMETABLE (
	day_ ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    unitID SMALLINT UNSIGNED NOT NULL,
    employeeNo INT NOT NULL,
    FOREIGN KEY (unitID) REFERENCES MEDICAL_UNIT(unitID),
    FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE(employeeNo),
	KEY (employeeNo),
    KEY (day_)
);

CREATE TABLE IF NOT EXISTS SPECIFIC_TIMETABLE (
	date_ DATE NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    unitID SMALLINT UNSIGNED NOT NULL,
    employeeNo INT NOT NULL,
    FOREIGN KEY (unitID) REFERENCES MEDICAL_UNIT(unitID),
    FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE(employeeNo),
    KEY (date_)
);


CREATE TABLE IF NOT EXISTS DOCTOR(
	employeeNo INT NOT NULL UNIQUE,
    stamp BLOB,
    degree ENUM ('Specialist', 'Primar') NOT NULL,
    scientificTitle ENUM ('', 'Doctorand', 'Doctor in stiinte medicale') DEFAULT NULL,
    teachingSpot ENUM ('', 'Preparator', 'Asistent', 'Sef de lucrari', 'Conferentiar', 'Profesor') DEFAULT NULL,
    percentage DECIMAL(5,4) NOT NULL,
	FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE (employeeNo),
    PRIMARY KEY (employeeNo)
);


CREATE TABLE IF NOT EXISTS MEDICAL_ASSISTANT(
	employeeNo INT NOT NULL UNIQUE,
    assistantType ENUM ('Generalist', 'Laborator', 'Radiologie') NOT NULL,
    degree ENUM ('Principal', 'Secundar') NOT NULL,
	FOREIGN KEY (employeeNo) REFERENCES EMPLOYEE (employeeNo),
    PRIMARY KEY (employeeNo)
);


#CREATE TABLE IF NOT EXISTS SPECIALITY(
#	specialityName VARCHAR(120) NOT NULL UNIQUE PRIMARY KEY
#);


CREATE TABLE IF NOT EXISTS INVESTIGATIONS(
	specialityName VARCHAR(120) NOT NULL,
	investigationID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    investigationName VARCHAR(245) NOT NULL,
    duration TINYINT DEFAULT 0,	
    price DECIMAL(7,2) DEFAULT 0,
	ability VARCHAR(120) DEFAULT '-',
    KEY (specialityName),
    KEY (investigationName),
	PRIMARY KEY (investigationID, specialityName)
);


CREATE TABLE IF NOT EXISTS ADD_SPECIALITY(
	specialityName VARCHAR(120) NOT NULL,
    employeeNo INT DEFAULT NULL,
    FOREIGN KEY (employeeNo) REFERENCES DOCTOR (employeeNo),
    FOREIGN KEY (specialityName)  REFERENCES INVESTIGATIONS (specialityName)
    #key/index for both
);


CREATE TABLE IF NOT EXISTS PATIENT(
	patientCNP CHAR(13) NOT NULL UNIQUE PRIMARY KEY,
	patient_firstName VARCHAR(30) NOT NULL,
	patient_lastName VARCHAR(30) NOT NULL,
    UNIQUE INDEX patient_name_idx(patient_firstName, patient_lastName)
);


CREATE TABLE IF NOT EXISTS APPOINTMENT(
	appointmentID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	patientCNP CHAR(13) NOT NULL,
	doctorNo INT NOT NULL,
    consultationDate DATETIME NOT NULL,
    FOREIGN KEY (doctorNo) REFERENCES DOCTOR (employeeNo),
    FOREIGN KEY(patientCNP) REFERENCES PATIENT (patientCNP),
    KEY (patientCNP)
);


CREATE TABLE IF NOT EXISTS APPOINTMENT_SERVICES(
	appointmentID INT NOT NULL,
    investigationID INT UNSIGNED NOT NULL,
    FOREIGN KEY (appointmentID) REFERENCES APPOINTMENT(appointmentID),
    FOREIGN KEY (investigationID) REFERENCES INVESTIGATIONS(investigationID)
);



CREATE TABLE IF NOT EXISTS MEDICAL_RAPORT(
	idRaport INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	appointmentID INT NOT NULL,
    patientCNP CHAR(13) NOT NULL UNIQUE,
    patient_firstName VARCHAR(30) NOT NULL,
	patient_lastName VARCHAR(30) NOT NULL,
	doctor_firstName VARCHAR(30) NOT NULL,
	doctor_lastName VARCHAR(30) NOT NULL,
    date_ DATETIME NOT NULL UNIQUE,
    symptoms TEXT,
    diagnostic TEXT,
    recommendations TEXT,
    resultat BOOLEAN DEFAULT FALSE,
    stamp BLOB,
    FOREIGN KEY (appointmentID) REFERENCES APPOINTMENT (appointmentID),
    KEY (patient_firstName, patient_lastName),
    KEY (doctor_firstName, doctor_lastName)
);


CREATE TABLE IF NOT EXISTS INVESTIGATION(
	investigationID INT UNSIGNED NOT NULL,
    idRaport INT NOT NULL,
    details TEXT,
    FOREIGN KEY(investigationID) REFERENCES INVESTIGATIONS(investigationID),
    FOREIGN KEY(idRaport) REFERENCES MEDICAL_RAPORT(idRaport)
);


CREATE TABLE IF NOT EXISTS RECEIPT(
	idRaport INT NOT NULL,
	price DECIMAL(7,2) NOT NULL,
    FOREIGN KEY (idRaport) REFERENCES MEDICAL_RAPORT (idRaport),
    PRIMARY KEY (idRaport)
);

#-----views

DROP PROCEDURE IF EXISTS VIEW_EMPLOYEE_BY_USERNAME;
DELIMITER //
CREATE PROCEDURE VIEW_EMPLOYEE_BY_USERNAME (username_ VARCHAR(30))
BEGIN
	SELECT EMPLOYEE.employeeNo AS 'EMPLOYEE No.', EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', EMPLOYEE.employeeType AS 'EMPLOYEE TYPE',
		EMPLOYEE.address AS 'ADDRESS', EMPLOYEE.telephoneNumber AS 'TELEPHONE NUMBER', EMPLOYEE.email AS 'EMAIL', EMPLOYEE.IBAN AS 'IBAN', EMPLOYEE.contractNumber AS 'CONTRACT NUMBER',
		EMPLOYEE.departmentName AS 'DEPARTAMENT'
    FROM EMPLOYEE WHERE EMPLOYEE.username_=username_;
END //
DELIMITER ;




DROP PROCEDURE IF EXISTS VIEW_DOCTORS_BY_SPECIALITY;
DELIMITER //
CREATE PROCEDURE VIEW_DOCTORS_BY_SPECIALITY(speciality VARCHAR(120))
BEGIN
    IF (SELECT MIN(specialityName) FROM INVESTIGATIONS WHERE INVESTIGATIONS.specialityName = speciality) IS NOT NULL THEN
		SELECT EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', EMPLOYEE.employeeType AS 'EMPLOYEE TYPE', DOCTOR.degree AS 'DOCTOR DEGREE', ADD_SPECIALITY.specialityName AS 'SPECIALITY NAME', EMPLOYEE.hoursPerMonth AS 'HOURS PER MONTH'
			FROM ((EMPLOYEE
			INNER JOIN DOCTOR ON EMPLOYEE.employeeNo = DOCTOR.employeeNo)
			INNER JOIN ADD_SPECIALITY ON EMPLOYEE.employeeNo = ADD_SPECIALITY.employeeNo)
			WHERE ADD_SPECIALITY.specialityName = speciality;
		ELSE SELECT CONCAT('Specialitate gresita!') AS Result;
	END IF;
END //
DELIMITER ;




DROP PROCEDURE IF EXISTS VIEW_MEDICAL_SERVICE_BY_SPECIALITY;
DELIMITER //
CREATE PROCEDURE VIEW_MEDICAL_SERVICE_BY_SPECIALITY (speciality VARCHAR(120))
BEGIN 
	IF (SELECT MIN(specialityName) FROM INVESTIGATIONS WHERE INVESTIGATIONS.specialityName = speciality) IS NOT NULL THEN
		SELECT INVESTIGATIONS.specialityName AS 'SPECIALITY', INVESTIGATIONS.investigationName AS 'Investigation Name', INVESTIGATIONS.price AS 'PRICE', INVESTIGATIONS.duration AS 'DURATION', INVESTIGATIONS.ability AS 'ABILITY'
		FROM INVESTIGATIONS WHERE INVESTIGATIONS.specialityName = speciality ORDER BY investigationName ASC;
	ELSE SELECT CONCAT('Specialitate gresita!') AS RESULT;
	END IF;
END //
DELIMITER ;




CREATE VIEW VIEW_MEDICAL_SERVICES AS
	SELECT INVESTIGATIONS.specialityName AS 'SPECIALITY', INVESTIGATIONS.investigationName AS 'Investigation Name', INVESTIGATIONS.price AS 'PRICE', INVESTIGATIONS.duration AS 'DURATION', INVESTIGATIONS.ability AS 'ABILITY'
	FROM INVESTIGATIONS;




CREATE VIEW VIEW_EMPLOYEES AS
		SELECT EMPLOYEE.employeeNo AS 'EMPLOYEE No.', EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', EMPLOYEE.employeeType AS 'EMPLOYEE TYPE',
		EMPLOYEE.address AS 'ADDRESS', EMPLOYEE.telephoneNumber AS 'TELEPHONE NUMBER', EMPLOYEE.email AS 'EMAIL', EMPLOYEE.IBAN AS 'IBAN', EMPLOYEE.contractNumber AS 'CONTRACT NUMBER',
		EMPLOYEE.departmentName AS 'DEPARTAMENT', EMPLOYEE.hoursPerMonth AS 'HOURS/MONTH', EMPLOYEE.negotiatedSalary AS 'NEGOTIATED SALARY'
    FROM EMPLOYEE ORDER BY firstName ASC;

	
	
	
CREATE VIEW DOCTORS_SPECIALITY AS
	SELECT EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', EMPLOYEE.employeeType AS 'EMPLOYEE TYPE', DOCTOR.degree AS 'DOCTOR DEGREE', ADD_SPECIALITY.specialityName AS 'SPECIALITY'
		FROM ((EMPLOYEE
		INNER JOIN DOCTOR ON EMPLOYEE.employeeNo = DOCTOR.employeeNo)
		INNER JOIN ADD_SPECIALITY ON EMPLOYEE.employeeNo = ADD_SPECIALITY.employeeNo);	
	

	
	
CREATE VIEW MEDICAL_ASSISTANTS AS
	SELECT EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', EMPLOYEE.employeeType AS 'EMPLOYEE TYPE', MEDICAL_ASSISTANT.degree AS 'ASSISTANT DEGREE', MEDICAL_ASSISTANT.assistantType AS 'ASSISTANT TYPE'
		FROM EMPLOYEE
		INNER JOIN MEDICAL_ASSISTANT ON EMPLOYEE.employeeNo = MEDICAL_ASSISTANT.employeeNo;
	
	

CREATE VIEW VIEW_ALL_DOCTORS AS
    SELECT 
        `employee`.`firstName` AS `FIRST NAME`,
        `employee`.`lastName` AS `LAST NAME`,
        `employee`.`employeeType` AS `EMPLOYEE TYPE`,
        `doctor`.`degree` AS `DOCTOR DEGREE`,
        `doctor`.`scientificTitle` AS `Scientific Title`,
        `doctor`.`teachingSpot` AS `Teaching Spot`,
		`doctor`.`percentage` AS `Percentage`
    FROM
        ((`employee`
        JOIN `doctor` ON ((`employee`.`employeeNo` = `doctor`.`employeeNo`))));
		
	
#-----procedures

DROP PROCEDURE IF EXISTS ADD_EMPLOYEE;
DELIMITER //
CREATE PROCEDURE ADD_EMPLOYEE(username_ VARCHAR(255), password_ VARCHAR(255), CNP_ CHAR(13), firstName_ VARCHAR(30), lastName_ VARCHAR(30), address_ TEXT, 
							  telnumber CHAR(10), EMAIL_ VARCHAR(255), IBAN_ CHAR(24), hoursPMonth SMALLINT, negotiatedSalary_ DECIMAL(8,2), departmentName_ VARCHAR(60), 
                              employeeType_ VARCHAR(30), contractNumber_ INT)
BEGIN
    IF (SELECT email FROM EMPLOYEE WHERE EMPLOYEE.email = EMAIL_) IS NULL THEN
		INSERT INTO EMPLOYEE(username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, EMAIL, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName)
			VALUES(username_, AES_ENCRYPT(password_, 'UtcN98#ncd'), 'EMPLOYEE', CNP_, firstName_, lastName_, address_, telnumber, EMAIL_, IBAN_, contractNumber_, CURRENT_DATE(), employeeType_, hoursPMonth, negotiatedSalary_, departmentName_);
	ELSE SELECT CONCAT('Email :', EMAIL_,' already registered.') AS RESULT;
    END IF;
END //
DELIMITER ;



	
DROP PROCEDURE IF EXISTS ADD_DOCTOR;
DELIMITER //
CREATE PROCEDURE ADD_DOCTOR(firstName_ VARCHAR(30), lastName_ VARCHAR(30), degree_ VARCHAR(30), scientificTitle_ VARCHAR(50), teachingSpot_ VARCHAR(50), percentage_ DECIMAL(5,4), stamp_ VARCHAR(20))
	BEGIN
		SET @idDoctor = NULL;
        SELECT @idDoctor := EMPLOYEE.employeeNo from EMPLOYEE WHERE EMPLOYEE.employeeType='Medic' AND EMPLOYEE.firstName = firstName_ AND EMPLOYEE.lastName = lastName_;
        IF @idDoctor IS NOT NULL THEN
			IF(SELECT employeeNo from DOCTOR WHERE DOCTOR.employeeNo = @idDoctor) IS NULL THEN
				INSERT INTO DOCTOR(employeeNo, degree, scientificTitle, teachingSpot, percentage, stamp)
					VALUES(@idDoctor, degree_, scientificTitle_, teachingSpot_, percentage_, stamp_);
			ELSE SELECT CONCAT('Medicul ', firstName_, ' ', lastName_, ' exista deja.') AS RESULT;
            END IF;
		ELSE SELECT CONCAT('Angajatul ', firstName_, ' ', lastName_, ' nu exista sau nu este medic.') AS RESULT;
		END IF;
	END //
DELIMITER ;




DROP PROCEDURE IF EXISTS ADD_MEDICAL_ASSISTANT;     
DELIMITER //
CREATE PROCEDURE ADD_MEDICAL_ASSISTANT(firstName_ VARCHAR(30), lastName_ VARCHAR(30), assistantType_ VARCHAR(30), degree_ VARCHAR(30))
	BEGIN
		SET @idAssistant = NULL;
        SELECT @idAssistant := EMPLOYEE.employeeNo from EMPLOYEE WHERE EMPLOYEE.employeeType='Asistent Medical' AND EMPLOYEE.firstName = firstName_ AND EMPLOYEE.lastName = lastName_;
        IF @idAssistant IS NOT NULL THEN
			IF(SELECT employeeNo FROM MEDICAL_ASSISTANT WHERE MEDICAL_ASSISTANT.employeeNo = @idAssistant) IS NULL THEN
				INSERT INTO MEDICAL_ASSISTANT(employeeNo, degree, assistantType)
					VALUES(@idAssistant, degree_, assistantType_);
			ELSE SELECT CONCAT('Asistentul medical ', firstName_, ' ', lastName_, ' exista deja.') AS RESULT;
			END IF;
		ELSE SELECT CONCAT('Angajatul ', firstName, ' ', lastName, ' nu exista sau nu este asistent medical.') AS RESULT;
		END IF;
	END //
DELIMITER ;




DROP PROCEDURE IF EXISTS ADD_SPECIALITY_TO_DOCTOR;
DELIMITER //
CREATE PROCEDURE ADD_SPECIALITY_TO_DOCTOR(firstName VARCHAR(30), lastName VARCHAR(30), specialityName VARCHAR(120))
	BEGIN
		IF (SELECT MIN(specialityName) FROM INVESTIGATIONS WHERE INVESTIGATIONS.specialityName = specialityName) IS NOT NULL THEN
			SET @idDoctor = NULL;
			SELECT @idDoctor := EMPLOYEE.employeeNo FROM (EMPLOYEE INNER JOIN DOCTOR ON EMPLOYEE.employeeNo = DOCTOR.employeeNo) WHERE EMPLOYEE.firstName = firstName AND EMPLOYEE.lastName = lastName;
            IF @idDoctor IS NOT NULL THEN
				IF (SELECT specialityName FROM ADD_SPECIALITY WHERE ADD_SPECIALITY.specialityName = specialityName AND ADD_SPECIALITY.employeeNo = @idDoctor) IS NULL THEN
								INSERT INTO ADD_SPECIALITY(employeeNo, specialityName) VALUES(@idDoctor, specialityName);
				ELSE SELECT CONCAT('Doctorul ',firstName ,' ', lastName, ' are deja specialitatea ', specialityName, '.') AS RESULT;
				END IF;
            ELSE SELECT CONCAT('Angajatul ', firstName, ' ', lastName, ' nu exista sau nu este medic.') AS RESULT;
			END IF;
		ELSE SELECT CONCAT('Specialitate gresita!') AS RESULT;
		END IF;
	END //
DELIMITER ;


DROP PROCEDURE IF EXISTS ADD_SPECIALITY_TO_DOCTOR_BY_ID;
DELIMITER //
CREATE PROCEDURE ADD_SPECIALITY_TO_DOCTOR_BY_ID(employeeNo_ INT, specialityName VARCHAR(120))
	BEGIN
		IF (SELECT MIN(specialityName) FROM INVESTIGATIONS WHERE INVESTIGATIONS.specialityName = specialityName) IS NOT NULL THEN
            IF (SELECT employeeNo FROM DOCTOR WHERE  DOCTOR.employeeNo = employeeNo_) IS NOT NULL THEN
				IF (SELECT specialityName FROM ADD_SPECIALITY WHERE ADD_SPECIALITY.specialityName = specialityName AND ADD_SPECIALITY.employeeNo = employeeNo_) IS NULL THEN
								INSERT INTO ADD_SPECIALITY(employeeNo, specialityName) VALUES(employeeNo_, specialityName);
				ELSE SELECT CONCAT('Doctorul are deja specialitatea ', specialityName, '.') AS RESULT;
				END IF;
            ELSE SELECT CONCAT('Angajatul nu exista sau nu este medic.') AS RESULT;
			END IF;
		ELSE SELECT CONCAT('Specialitate gresita!') AS RESULT;
		END IF;
	END //
DELIMITER ;




DROP PROCEDURE IF EXISTS MEDICAL_UNIT_PROGRAM;
DELIMITER //
CREATE PROCEDURE MEDICAL_UNIT_PROGRAM(unitID SMALLINT, startTime TIME, weekstartdelay TIME, endTime TIME, weekenddelay TIME)
BEGIN
	DECLARE dayno TINYINT UNSIGNED DEFAULT 1;
    WHILE dayno < 8 DO
			IF dayNo = 1 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Luni', startTime, endTime, unitID);
			END IF;
            IF dayNo = 2 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Marti', startTime, endTime, unitID);
			END IF;
            IF dayNo = 3 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Miercuri', startTime, endTime, unitID);
			END IF;
            IF dayNo = 4 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Joi', startTime, endTime, unitID);
			END IF;
            IF dayNo = 5 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Vineri', startTime, ADDTIME(SUBTIME(endTime, weekstartdelay),'00:30:00'), unitID);
			END IF;
            IF dayNo = 6 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Sambata', ADDTIME(startTime, weekstartdelay), SUBTIME(endTime, weekenddelay), unitID);
			END IF;
            IF dayNo = 7 THEN INSERT INTO PROGRAM(weekday, startTime, endTime, unitID)
								VALUES('Duminica', ADDTIME(startTime, weekstartdelay), SUBTIME(endTime, weekenddelay), unitID);    
			END IF;
		SET dayno = dayno + 1;
    END WHILE;
END //
DELIMITER ;




DROP PROCEDURE IF EXISTS VIEW_MEDICAL_UNIT_PROGRAM;
DELIMITER //
CREATE PROCEDURE VIEW_MEDICAL_UNIT_PROGRAM(unitID SMALLINT)
BEGIN
	IF(SELECT unitID FROM MEDICAL_UNIT WHERE MEDICAL_UNIT.unitID = unitID) IS NOT NULL THEN
		SELECT unitName AS 'MEDICAL UNIT NAME', weekday AS 'WEELDAY', startTime AS 'DAY START', endTime AS 'DAY END'
        FROM (MEDICAL_UNIT INNER JOIN PROGRAM ON MEDICAL_UNIT.unitID = PROGRAM.unitID)
        WHERE MEDICAL_UNIT.unitID = unitID;
	ELSE SELECT CONCAT('Wrong medical unit id!') AS RESULT;
    END IF;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS UPDATE_MEDICAL_UNIT_PROGRAM;
DELIMITER //
CREATE PROCEDURE UPDATE_MEDICAL_UNIT_PROGRAM(unitID SMALLINT, day_ VARCHAR(30), startTime TIME, endTime TIME)
BEGIN
		UPDATE PROGRAM
			SET PROGRAM.startTime = startTime, PROGRAM.endTime = endTime WHERE PROGRAM.unitID = unitID AND PROGRAM.weekday = day_;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS GENERIC_TIMETABLE_BY_NAME;
DELIMITER //
CREATE PROCEDURE GENERIC_TIMETABLE_BY_NAME(first_name VARCHAR(30), last_name VARCHAR(30))
BEGIN
	
    IF (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = first_name AND EMPLOYEE.lastName = last_name) IS NOT NULL THEN
		SELECT MEDICAL_UNIT.unitName AS 'MEDICAL UNIT', GENERIC_TIMETABLE.day_ AS 'WEEKDAY', GENERIC_TIMETABLE.startTime AS 'DAY START', GENERIC_TIMETABLE.endTime AS 'DAY END'
        FROM (GENERIC_TIMETABLE INNER JOIN MEDICAL_UNIT ON GENERIC_TIMETABLE.unitId = MEDICAL_UNIT.unitID) INNER JOIN EMPLOYEE ON GENERIC_TIMETABLE.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = first_name AND EMPLOYEE.lastName = last_name;
	END IF;
    
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS SPECIFIC_TIMETABLE_BY_NAME;
DELIMITER //
CREATE PROCEDURE SPECIFIC_TIMETABLE_BY_NAME(first_name VARCHAR(30), last_name VARCHAR(30))
BEGIN
    IF (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = first_name AND EMPLOYEE.lastName = last_name AND EMPLOYEE.departmentName = 'Medical') IS NOT NULL THEN
		IF (SELECT MAX(SPECIFIC_TIMETABLE.date_) FROM SPECIFIC_TIMETABLE INNER JOIN EMPLOYEE ON SPECIFIC_TIMETABLE.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = first_name AND EMPLOYEE.lastName = last_name AND SPECIFIC_TIMETABLE.date_ >= CURRENT_DATE()) IS NOT NULL THEN
			SELECT MEDICAL_UNIT.unitName AS 'MEDICAL UNIT', SPECIFIC_TIMETABLE.date_ AS 'DATE', SPECIFIC_TIMETABLE.startTime AS 'DAY START', SPECIFIC_TIMETABLE.endTime AS 'DAY END'
			FROM (SPECIFIC_TIMETABLE INNER JOIN MEDICAL_UNIT ON SPECIFIC_TIMETABLE.unitID = MEDICAL_UNIT.unitID) INNER JOIN EMPLOYEE ON SPECIFIC_TIMETABLE.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = first_name AND EMPLOYEE.lastName = last_name ORDER BY SPECIFIC_TIMETABLE.date_ ASC;
		ELSE SELECT CONCAT('Angajatul nu are orar specific!');
        END IF;
    ELSE SELECT CONCAT('Nume angajat gresit!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS ADD_SPECIFIC_TIMETABLE;
DELIMITER //
CREATE PROCEDURE ADD_SPECIFIC_TIMETABLE(specificDate DATE, startTime_ TIME, endTime_ TIME, firstName_ VARCHAR(30), lastName_ VARCHAR(30), unitID_ INT)
BEGIN
	SET @idDoctor = NULL;
    SELECT @idDoctor := EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = firstName_ AND EMPLOYEE.lastName = lastName_ AND EMPLOYEE.departmentName = 'Medical';
	IF(@idDoctor) IS NOT NULL THEN
		IF(specificDate >= CURRENT_DATE()) THEN
			INSERT INTO SPECIFIC_TIMETABLE(date_, startTime, endTime, unitID, employeeNo)
				VALUES(specificDate, startTime_, endTime_, unitID_, @idDoctor);
		ELSE SELECT CONCAT('Data gresita!');
        END IF;
	ELSE SELECT CONCAT('Nume angajat gresit!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_GENERIC_TIMETABLE_BY_TYPE;
DELIMITER //
CREATE PROCEDURE VIEW_GENERIC_TIMETABLE_BY_TYPE(employeeType_ VARCHAR(50))
BEGIN
	IF(SELECT MIN(EMPLOYEE.employeeType) FROM EMPLOYEE WHERE EMPLOYEE.employeeType = employeeType_) IS NOT NULL THEN
		SELECT EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', MEDICAL_UNIT.unitName AS 'MEDICAL UNIT NAME', GENERIC_TIMETABLE.day_ AS 'WEEKDAY',
			   GENERIC_TIMETABLE.startTime AS 'DAY START', GENERIC_TIMETABLE.endTime AS 'END TIME' FROM 
			   (GENERIC_TIMETABLE INNER JOIN EMPLOYEE ON GENERIC_TIMETABLE.employeeNo = EMPLOYEE.employeeNo) INNER JOIN MEDICAL_UNIT ON MEDICAL_UNIT.unitID = GENERIC_TIMETABLE.unitID WHERE EMPLOYEE.employeeType = employeeType_;
	ELSE SELECT CONCAT('Tip gresit');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_MEDICAL_UNIT_PROGRAM;
DELIMITER //
CREATE PROCEDURE VIEW_MEDICAL_UNIT_PROGRAM(unitID SMALLINT)
BEGIN
	IF(SELECT unitID FROM MEDICAL_UNIT WHERE MEDICAL_UNIT.unitID = unitID) IS NOT NULL THEN
		SELECT unitName AS 'MEDICAL UNIT NAME', weekday AS 'WEEKDAY', startTime AS 'DAY START', endTime AS 'DAY END'
        FROM (MEDICAL_UNIT INNER JOIN PROGRAM ON MEDICAL_UNIT.unitID = PROGRAM.unitID)
        WHERE MEDICAL_UNIT.unitID = unitID;
	ELSE SELECT CONCAT('Wrong medical unit id!') AS RESULT;
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_VACATION_FROM_MEDICAL_UNIT;
DELIMITER //
CREATE PROCEDURE VIEW_VACATION_FROM_MEDICAL_UNIT(unitId SMALLINT)
BEGIN
	IF(SELECT unitID FROM MEDICAL_UNIT WHERE MEDICAL_UNIT.unitID = unitID) IS NOT NULL THEN
		SELECT EMPLOYEE.firstName AS 'FIRST NAME', EMPLOYEE.lastName AS 'LAST NAME', VACATION.startTime AS 'START DATE', VACATION.endTime AS 'END DATE', VACATION.details AS 'VACATION DETAILS'
			FROM (EMPLOYEE INNER JOIN VACATION ON EMPLOYEE.employeeNo = VACATION.employeeNo) INNER JOIN GENERIC_TIMETABLE ON EMPLOYEE.employeeNo = GENERIC_TIMETABLE.employeeNo WHERE GENERIC_TIMETABLE.unitID = unitId;
	ELSE SELECT CONCAT('Wrong medical unit id!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS ADD_VACATION;
DELIMITER //
CREATE PROCEDURE ADD_VACATION(first_name VARCHAR(30), last_name VARCHAR(30), startDate DATE, endDate DATE, details_ TEXT)
BEGIN 
	IF startDate < endDate THEN
		IF startDate > CURRENT_DATE() THEN
			SET @idEmployee = NULL;
			SELECT @idEmployee := EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = first_name and EMPLOYEE.lastName = last_name;
			
			IF @idEmployee IS NOT NULL THEN
				INSERT INTO VACATION(employeeNo, startTime, endTime, details)
						VALUES(@idEmployee, startDate, endDate, details_);
			ELSE SELECT CONCAT('Nume angajat gresit');
			END IF;
		ELSE SELECT CONCAT('Data inceput gresita');
		END IF;
	ELSE SELECT CONCAT('Date gresite');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS ADD_APPOINTMENT_V2;
DELIMITER //
CREATE PROCEDURE ADD_APPOINTMENT_V2(patientCNP CHAR(13), patient_firstName VARCHAR(30), patient_lastName VARCHAR(30), doctor_firstName VARCHAR(30), doctor_lastName VARCHAR(30), consultationDate DATETIME)
BEGIN
	IF(SELECT PATIENT.patientCNP FROM PATIENT WHERE PATIENT.patientCNP = patientCNP) IS NULL THEN
		INSERT INTO PATIENT(patientCNP, patient_firstName, patient_lastName)
				VALUES(patientCNP, patient_firstName, patient_lastName);
	ELSE SELECT CONCAT('Pacientul este deja inregistrat.');
	END IF;
    
	IF(DATE(consultationDate) >= CURRENT_DATE()) THEN
		
        SET @idDoctor = NULL;
		SELECT @idDoctor := EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctor_firstName AND EMPLOYEE.lastName = doctor_lastName AND EMPLOYEE.employeeType = 'Medic';
		
        IF @idDoctor IS NOT NULL THEN
        
			IF(SELECT GENERIC_TIMETABLE.day_ FROM GENERIC_TIMETABLE WHERE GENERIC_TIMETABLE.employeeNo = @idDoctor AND GENERIC_TIMETABLE.day_ = (SELECT DAYNAME(consultationDate))) IS NOT NULL THEN
				
                IF(TIME(consultationDate) BETWEEN (SELECT GENERIC_TIMETABLE.startTime FROM GENERIC_TIMETABLE WHERE GENERIC_TIMETABLE.employeeNo = @idDoctor AND GENERIC_TIMETABLE.day_ = (SELECT DAYNAME(consultationDate)))
												AND (SELECT GENERIC_TIMETABLE.endTime FROM GENERIC_TIMETABLE WHERE GENERIC_TIMETABLE.employeeNo = @idDoctor AND GENERIC_TIMETABLE.day_ = (SELECT DAYNAME(consultationDate)))) THEN
					
                    IF(SELECT APPOINTMENT.consultationDate FROM APPOINTMENT WHERE APPOINTMENT.doctorNo = @idDoctor AND (SELECT DAYNAME(APPOINTMENT.consultationDate)) = (SELECT DAYNAME(consultationDate)) ORDER BY APPOINTMENT.consultationDate DESC LIMIT 1) IS NULL THEN
							INSERT INTO APPOINTMENT(patientCNP, doctorNo, consultationDate)
									VALUES(patientCNP, @idDoctor, consultationDate);
                                    
						ELSE IF(SELECT TIME(APPOINTMENT.consultationDate) < TIME(consultationDate) FROM APPOINTMENT WHERE APPOINTMENT.doctorNo = @idDoctor AND (SELECT DAYNAME(APPOINTMENT.consultationDate)) = (SELECT DAYNAME(consultationDate)) ORDER BY APPOINTMENT.consultationDate DESC LIMIT 1) THEN
								INSERT INTO APPOINTMENT(patientCNP, doctorNo, consultationDate)
									VALUES(patientCNP, @idDoctor, consultationDate);
							ELSE SELECT CONCAT('Medicul are deja programare la ora ', TIME(consultationDate));
							END IF;
                    END IF;
                    
				ELSE SELECT CONCAT('Medicul nu lucreaza la ora ', TIME(consultationDate));
				END IF;
                
			ELSE SELECT CONCAT('Medicul ', doctor_firstName, ' ', doctor_lastName, ' nu lucreaza astazi');
			END IF;
            
		ELSE SELECT CONCAT('Nume medic gresit!');
		END IF;
        
    ELSE SELECT CONCAT('Nu puteti face programare in acesta data ',DATE(consultationDate));
    END IF;
    
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS ADD_MEDICAL_SERVICE_TO_APPOINTMENT;
DELIMITER //
CREATE PROCEDURE ADD_MEDICAL_SERVICE_TO_APPOINTMENT(investigationName_ VARCHAR(245), patientFirstName VARCHAR(30), patientLastName VARCHAR(30), doctorFirstName VARCHAR(30), doctorLastName VARCHAR(30))
BEGIN
	IF(SELECT EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') IS NOT NULL THEN
		
        IF(SELECT INVESTIGATIONS.investigationID FROM INVESTIGATIONS INNER JOIN ADD_SPECIALITY ON ADD_SPECIALITY.specialityName = INVESTIGATIONS.specialityName INNER JOIN EMPLOYEE ON ADD_SPECIALITY.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND INVESTIGATIONS.investigationName = investigationName_) IS NOT NULL THEN
				
                IF(SELECT APPOINTMENT.appointmentID FROM APPOINTMENT WHERE APPOINTMENT.patientCNP = (SELECT PATIENT.patientCNP FROM PATIENT WHERE PATIENT.patient_firstName = patientFirstName AND PATIENT.patient_lastName = patientLastName) AND APPOINTMENT.doctorNo = (SELECT EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') AND (DATE(APPOINTMENT.consultationDate) >= CURRENT_DATE()) ORDER BY APPOINTMENT.consultationDate ASC LIMIT 1) IS NOT NULL THEN
					INSERT INTO APPOINTMENT_SERVICES(appointmentID, investigationID)
					VALUES((SELECT APPOINTMENT.appointmentID FROM APPOINTMENT WHERE APPOINTMENT.patientCNP = (SELECT PATIENT.patientCNP FROM PATIENT WHERE PATIENT.patient_firstName = patientFirstName AND PATIENT.patient_lastName = patientLastName) AND APPOINTMENT.doctorNo = (SELECT EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') AND (DATE(APPOINTMENT.consultationDate) >= CURRENT_DATE()) ORDER BY APPOINTMENT.consultationDate ASC LIMIT 1), (SELECT INVESTIGATIONS.investigationID FROM INVESTIGATIONS INNER JOIN ADD_SPECIALITY ON ADD_SPECIALITY.specialityName = INVESTIGATIONS.specialityName INNER JOIN EMPLOYEE ON ADD_SPECIALITY.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND INVESTIGATIONS.investigationName = investigationName_));
				ELSE SELECT CONCAT('Pacientul nu are rezervare!');
                END IF;
                
			ELSE SELECT CONCAT('Serviciu medical gresit sau medicul nu este specializat pentru el!');
		END IF;
        
	ELSE SELECT CONCAT('Nume medic gresit!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_APPOINTMENT_BY_DOCTOR;
DELIMITER //
CREATE PROCEDURE VIEW_APPOINTMENT_BY_DOCTOR(doctorFirstName VARCHAR(30), doctorLastName VARCHAR(30))
BEGIN
	IF(SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') IS NOT NULL THEN
		IF(SELECT MIN(APPOINTMENT.appointmentID) FROM APPOINTMENT WHERE APPOINTMENT.doctorNo = (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic')) IS NOT NULL THEN
			SELECT APPOINTMENT.patientCNP AS 'PATIENT CNP', PATIENT.patient_firstName AS 'PATIENT FIRST NAME', PATIENT.patient_lastName AS 'PATIENT LAST NAME', APPOINTMENT.consultationDate AS 'CONSULATION DATE'
             FROM APPOINTMENT INNER JOIN PATIENT ON APPOINTMENT.patientCNP = PATIENT.patientCNP AND APPOINTMENT.doctorNo = (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') WHERE DATE(APPOINTMENT.consultationDate) >= CURRENT_DATE();
    ELSE SELECT CONCAT('Medicul nu are rezervari');
    END IF;
    
    ELSE SELECT CONCAT('Nume medic gresit!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_APPOINTMENT_SERVICES;
DELIMITER //
CREATE PROCEDURE VIEW_APPOINTMENT_SERVICES(doctorFirstName VARCHAR(30), doctorLastName VARCHAR(30))
BEGIN
	IF(SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') IS NOT NULL THEN
		IF(SELECT MIN(APPOINTMENT.appointmentID) FROM APPOINTMENT WHERE APPOINTMENT.doctorNo = (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic')) IS NOT NULL THEN
			SELECT APPOINTMENT.appointmentID AS 'APPOINTMENT ID', APPOINTMENT.patientCNP AS 'PATIENT CNP', PATIENT.patient_firstName AS 'PATIENT FIRST NAME', PATIENT.patient_lastName AS 'PATIENT LAST NAME', APPOINTMENT.consultationDate AS 'CONSULTATION DATE', INVESTIGATIONS.investigationName AS 'SERVICE NAME', APPOINTMENT_SERVICES.investigationID AS 'SERVICE ID'
             FROM APPOINTMENT INNER JOIN PATIENT ON APPOINTMENT.patientCNP = PATIENT.patientCNP AND APPOINTMENT.doctorNo = (SELECT employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = doctorFirstName AND EMPLOYEE.lastName = doctorLastName AND EMPLOYEE.employeeType = 'Medic') INNER JOIN APPOINTMENT_SERVICES ON APPOINTMENT_SERVICES.appointmentID = APPOINTMENT.appointmentID INNER JOIN INVESTIGATIONS ON APPOINTMENT_SERVICES.investigationID = INVESTIGATIONS.investigationID WHERE DATE(APPOINTMENT.consultationDate) >= CURRENT_DATE();
    ELSE SELECT CONCAT('Medicul nu are rezervari'); 
    END IF;
    
    ELSE SELECT CONCAT('Nume medic gresit!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS DELETE_APPOINTMENT_SERVICES;
DELIMITER //
CREATE PROCEDURE DELETE_APPOINTMENT_SERVICES(investigationID_ VARCHAR(245), appointment_id INT)
BEGIN
	IF(SELECT APPOINTMENT.appointmentID FROM APPOINTMENT WHERE APPOINTMENT.appointmentID = appointment_id) IS NOT NULL THEN
		
        IF(SELECT MIN(APPOINTMENT_SERVICES.investigationID) FROM APPOINTMENT_SERVICES WHERE APPOINTMENT_SERVICES.investigationID = investigationID_) IS NOT NULL THEN
			DELETE FROM APPOINTMENT_SERVICES WHERE  APPOINTMENT_SERVICES.investigationID = investigationID_ AND APPOINTMENT_SERVICES.appointmentID = appointment_id LIMIT 1;
        ELSE SELECT CONCAT('Rezervarea nu are inregistrat acest serviciu medical!');
		END IF;
	ELSE SELECT CONCAT('Wrong appointment id!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_USERTYPE_BY_USERNAME;
DELIMITER //
CREATE PROCEDURE VIEW_USERTYPE_BY_USERNAME(userName VARCHAR(255))
BEGIN
	IF(SELECT EMPLOYEE.username_ FROM EMPLOYEE WHERE EMPLOYEE.username_ = userName) IS NOT NULL THEN
		SELECT EMPLOYEE.userType FROM EMPLOYEE WHERE EMPLOYEE.username_ = userName;
	ELSE SELECT CONCAT('Wrong username!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_REGISTERED_PATIENTS;
DELIMITER //
CREATE PROCEDURE VIEW_REGISTERED_PATIENTS()
BEGIN
	SELECT PATIENT.patientCNP AS 'PATIENT CNP', PATIENT.patient_firstName AS 'FIRST NAME', PATIENT.patient_lastName AS 'LAST NAME'
    FROM PATIENT ORDER BY PATIENT.patient_firstName ASC;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_APPOINTMENTS;
DELIMITER //
CREATE PROCEDURE VIEW_APPOINTMENTS()
BEGIN
	SELECT EMPLOYEE.firstName AS 'DOCTOR FIRST NAME', EMPLOYEE.lastName AS 'DOCTOR LAST NAME', PATIENT.patient_firstName AS 'PATIENT FIRST NAME',  PATIENT.patient_lastName AS 'PATIENTT LAST NAME',
			PATIENT.patientCNP AS 'PATIENT CNP', APPOINTMENT.consultationDate AS 'CONSULTATION DATE', APPOINTMENT.appointmentID AS 'APPOINTMENT ID' , APPOINTMENT_SERVICES.investigationID AS 'INVESTIGATION ID' FROM
            (APPOINTMENT INNER JOIN PATIENT ON APPOINTMENT.patientCNP = PATIENT.patientCNP) INNER JOIN EMPLOYEE ON APPOINTMENT.doctorNo = EMPLOYEE.employeeNo INNER JOIN APPOINTMENT_SERVICES ON APPOINTMENT_SERVICES.appointmentID = APPOINTMENT.appointmentID;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CREATE_MEDICAL_RAPORT;
DELIMITER //
CREATE PROCEDURE CREATE_MEDICAL_RAPORT(appointment_id INT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.appointmentID FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NULL THEN
		
        INSERT INTO MEDICAL_RAPORT(appointmentID, patientCNP, patient_firstName, patient_lastName, doctor_firstName, doctor_lastName, date_)
			VALUES(appointment_id, (SELECT APPOINTMENT.patientCNP FROM APPOINTMENT WHERE APPOINTMENT.appointmentID = appointment_id),
				  (SELECT PATIENT.patient_firstName FROM PATIENT INNER JOIN APPOINTMENT ON PATIENT.patientCNP = APPOINTMENT.patientCNP AND APPOINTMENT.appointmentID = appointment_id),
                  (SELECT PATIENT.patient_lastName FROM PATIENT INNER JOIN APPOINTMENT ON PATIENT.patientCNP = APPOINTMENT.patientCNP AND APPOINTMENT.appointmentID = appointment_id),
				  (SELECT EMPLOYEE.firstName FROM EMPLOYEE INNER JOIN APPOINTMENT ON APPOINTMENT.doctorNo = EMPLOYEE.employeeNo AND APPOINTMENT.appointmentID = appointment_id),
                  (SELECT EMPLOYEE.lastName FROM EMPLOYEE INNER JOIN APPOINTMENT ON APPOINTMENT.doctorNo = EMPLOYEE.employeeNo AND APPOINTMENT.appointmentID = appointment_id),
                  (SELECT APPOINTMENT.consultationDate FROM APPOINTMENT WHERE APPOINTMENT.appointmentID = appointment_id));
                  
    ELSE SELECT CONCAT('Este deja raport medical la aceasta rezervare');
    END IF;
    
	IF(SELECT MEDICAL_RAPORT.appointmentID FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		INSERT INTO INVESTIGATION(investigationID, idRaport)
        SELECT APPOINTMENT_SERVICES.investigationID, MEDICAL_RAPORT.idRaport FROM APPOINTMENT_SERVICES INNER JOIN APPOINTMENT ON APPOINTMENT_SERVICES.appointmentID = APPOINTMENT.appointmentID AND APPOINTMENT.appointmentID = appointment_id
			INNER JOIN MEDICAL_RAPORT ON MEDICAL_RAPORT.appointmentID = APPOINTMENT.appointmentID;
    END IF;
    
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_MEDICAL_RAPORT_BY_ID;
DELIMITER //
CREATE PROCEDURE VIEW_MEDICAL_RAPORT_BY_ID(appointment_id INT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
	SELECT MEDICAL_RAPORT.patientCNP AS 'PATIENT CNP', MEDICAL_RAPORT.patient_firstName AS 'PATIENT FIRST NAME', MEDICAL_RAPORT.patient_lastName AS 'PATIENT LAST NAME', MEDICAL_RAPORT.doctor_firstName AS 'DOCTOR FIRST NAME',
		   MEDICAL_RAPORT.doctor_lastName AS 'DOCTOR LAST NAME', MEDICAL_RAPORT.date_ AS 'CONSULTATION DATE', MEDICAL_RAPORT.symptoms AS 'SYMPTOMS', MEDICAL_RAPORT.diagnostic AS 'DIAGNOSTIC',
           MEDICAL_RAPORT.recommendations AS 'RECOMMENDATIONS', MEDICAL_RAPORT.resultat AS 'RESULT', MEDICAL_RAPORT.stamp AS 'STAMP' 
           FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id;
	ELSE SELECT CONCAT('Raport medical inexistent!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS COMPLETE_MEDICAL_RAPORT;
DELIMITER //
CREATE PROCEDURE COMPLETE_MEDICAL_RAPORT(appointment_id INT, symptoms_ TEXT, diagnostic_ TEXT, recommendations_ TEXT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		IF(SELECT MEDICAL_RAPORT.stamp FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NULL THEN
			UPDATE MEDICAL_RAPORT SET MEDICAL_RAPORT.symptoms = symptoms_, MEDICAL_RAPORT.diagnostic = diagnostic_, MEDICAL_RAPORT.recommendations = recommendations_ WHERE MEDICAL_RAPORT.appointmentID = appointment_id;
		ELSE SELECT CONCAT('Raportul medical nu poate sa fie modificat!');
        END IF;
   ELSE SELECT CONCAT('Raport medical inexistent!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS UPDATE_MEDICAL_RAPORT_SERVICE;
DELIMITER //
CREATE PROCEDURE UPDATE_MEDICAL_RAPORT_SERVICE(appointment_id INT, investigation_id INT, details_ TEXT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		IF(SELECT MEDICAL_RAPORT.stamp FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NULL THEN
			IF(SELECT INVESTIGATION.idRaport FROM INVESTIGATION INNER JOIN MEDICAL_RAPORT ON INVESTIGATION.idRaport = MEDICAL_RAPORT.idRaport WHERE MEDICAL_RAPORT.appointmentID = appointment_id AND INVESTIGATION.investigationID = investigation_id) IS NOT NULL THEN
				UPDATE INVESTIGATION SET INVESTIGATION.details = details_ WHERE INVESTIGATION.idRaport = (SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) AND INVESTIGATION.investigationID = investigation_id;
			END IF;
        ELSE SELECT CONCAT('Raportul medical nu poate sa fie modificat!');
        END IF;
    ELSE SELECT CONCAT('Raport medical inexistent!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS STAMP_MEDICAL_RAPORT;
DELIMITER //
CREATE PROCEDURE STAMP_MEDICAL_RAPORT(appointment_id INT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
			IF(SELECT MEDICAL_RAPORT.stamp FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NULL THEN
				UPDATE MEDICAL_RAPORT SET MEDICAL_RAPORT.stamp = (SELECT DOCTOR.stamp FROM DOCTOR INNER JOIN APPOINTMENT ON DOCTOR.employeeNo = APPOINTMENT.doctorNo AND APPOINTMENT.appointmentID = appointment_id) WHERE MEDICAL_RAPORT.appointmentID = appointment_id;
            ELSE SELECT CONCAT('Raport medical deja stampilat!');
            END IF;
	ELSE SELECT CONCAT('Raport medical inexistent!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_MEDICAL_RAPORT_SERVICES;
DELIMITER //
CREATE PROCEDURE VIEW_MEDICAL_RAPORT_SERVICES(appointment_id INT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		SELECT INVESTIGATION.idRaport AS 'MEDICAL RAPORT ID', INVESTIGATION.investigationID AS 'MEDICAL SERVICE ID', INVESTIGATIONS.investigationName AS 'MEDICAL SERVICE', INVESTIGATION.details AS 'DETAILS'
			FROM INVESTIGATION INNER JOIN MEDICAL_RAPORT ON INVESTIGATION.idRaport = MEDICAL_RAPORT.idRaport AND MEDICAL_RAPORT.appointmentID = appointment_id INNER JOIN INVESTIGATIONS ON INVESTIGATION.investigationID = INVESTIGATIONS.investigationID;
        
        
	ELSE SELECT CONCAT('Raport medical inexistent!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS MEDICAL_RAPORT_RESULT;
DELIMITER //
CREATE PROCEDURE MEDICAL_RAPORT_RESULT(appointment_id INT, result_ BOOLEAN)
BEGIN
	IF(SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		IF(SELECT MEDICAL_RAPORT.stamp FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NULL THEN
				UPDATE MEDICAL_RAPORT SET MEDICAL_RAPORT.resultat= result_ WHERE MEDICAL_RAPORT.appointmentID = appointment_id;
		ELSE SELECT CONCAT('Raport medical deja stampilat!');
		END IF;
    ELSE SELECT CONCAT('Raport medical inexistent!');
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS UPDATE_SALARY;
DELIMITER //
CREATE PROCEDURE UPDATE_SALARY()
BEGIN
	IF(CURRENT_DATE() = DATE_FORMAT(NOW() ,'%Y-%m-01')) IS TRUE THEN
		INSERT INTO SALARY(employeeNo, salary, from_date, to_date)
		SELECT EMPLOYEE.employeeNo, EMPLOYEE.negotiatedSalary, DATE_FORMAT(NOW() ,'%Y-%m-01'), LAST_DAY(CURRENT_DATE()) FROM EMPLOYEE; #WHERE EMPLOYEE.employeeType != 'Medic';
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS VIEW_SALARY_BY_NAME;
DELIMITER //
CREATE PROCEDURE VIEW_SALARY_BY_NAMEfrom_date(firstname_ VARCHAR(30), lastname_ VARCHAR(30))
BEGIN
	IF(SELECT EMPLOYEE.employeeNo FROM EMPLOYEE WHERE EMPLOYEE.firstName = firstname_ AND EMPLOYEE.lastName = lastname_) IS NOT NULL THEN
		SELECT SALARY.salary AS 'SALARY', SALARY.from_date AS 'MONTH START', SALARY.to_date AS 'MONTH END'
        FROM SALARY INNER JOIN EMPLOYEE ON SALARY.employeeNo = EMPLOYEE.employeeNo WHERE EMPLOYEE.firstName = firstname_ AND EMPLOYEE.lastName = lastname_;
    ELSE SELECT CONCAT('Nume angajat gresit!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CALCULATE_PROFIT;
DELIMITER //
CREATE PROCEDURE CALCULATE_PROFIT(month_ DATE)
BEGIN
	IF(MONTH(month_) <= MONTH(CURRENT_DATE())) IS TRUE THEN
		SET @salaries = (SELECT SUM(SALARY.salary) FROM SALARY WHERE MONTH(SALARY.from_date) = MONTH(month_));
		SET @income = (SELECT SUM(INVESTIGATIONS.price) FROM INVESTIGATIONS INNER JOIN INVESTIGATION ON INVESTIGATIONS.investigationID = INVESTIGATION.investigationID 
						INNER JOIN MEDICAL_RAPORT ON INVESTIGATION.idRaport = MEDICAL_RAPORT.idRaport AND MONTH(MEDICAL_RAPORT.date_) = MONTH(month_));
		SELECT CONCAT(@income - @salaries) AS 'PROFIT';
	ELSE SELECT CONCAT('Nu puteti calcula profitul in avans');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CREATE_RECEIPT_MEDICAL_RAPORT;
DELIMITER //
CREATE PROCEDURE CREATE_RECEIPT_MEDICAL_RAPORT(appointment_id INT)
BEGIN
	IF(SELECT MEDICAL_RAPORT.stamp FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id) IS NOT NULL THEN
		INSERT INTO RECEIPT(idRaport, price)
			VALUES((SELECT MEDICAL_RAPORT.idRaport FROM MEDICAL_RAPORT WHERE MEDICAL_RAPORT.appointmentID = appointment_id), 
					(SELECT SUM(INVESTIGATIONS.price) FROM INVESTIGATIONS INNER JOIN INVESTIGATION ON INVESTIGATIONS.investigationID = INVESTIGATION.investigationID INNER JOIN MEDICAL_RAPORT ON INVESTIGATION.idRaport = MEDICAL_RAPORT.idRaport AND MEDICAL_RAPORT.appointmentID = appointment_id));
	ELSE SELECT CONCAT('Raport medical neterminat!');
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS UPDATE_SALARY;
DELIMITER //
CREATE PROCEDURE UPDATE_SALARY()
BEGIN
	IF(CURRENT_DATE() = DATE_FORMAT(NOW() ,'%Y-%m-01')) IS TRUE THEN
		INSERT INTO SALARY(employeeNo, salary, from_date, to_date)
				SELECT EMPLOYEE.employeeNo, EMPLOYEE.negotiatedSalary, DATE_FORMAT(NOW() ,'%Y-%m-01'), LAST_DAY(CURRENT_DATE()) FROM EMPLOYEE WHERE EMPLOYEE.employeeType != 'Medic';
		INSERT INTO SALARY(employeeNo, salary, from_date, to_date)
				SELECT EMPLOYEE.employeeNo, (EMPLOYEE.negotiatedSalary + (SELECT SUM(INVESTIGATIONS.price) * DOCTOR.percentage FROM INVESTIGATIONS INNER JOIN INVESTIGATION ON INVESTIGATIONS.investigationID = INVESTIGATION.investigationID 
						INNER JOIN MEDICAL_RAPORT ON INVESTIGATION.idRaport = MEDICAL_RAPORT.idRaport AND MONTH(MEDICAL_RAPORT.date_) = MONTH(CURRENT_DATE())
                        INNER JOIN EMPLOYEE ON EMPLOYEE.firstName = MEDICAL_RAPORT.doctor_firstName AND EMPLOYEE.lastName = MEDICAL_RAPORT.doctor_lastName
                        INNER JOIN DOCTOR ON DOCTOR.employeeNo = EMPLOYEE.employeeNo)) , DATE_FORMAT(NOW() ,'%Y-%m-01'), LAST_DAY(CURRENT_DATE()) FROM EMPLOYEE WHERE EMPLOYEE.employeeType = 'Medic';
	END IF;
END //
DELIMITER ;

ALTER DATABASE policlinica2 CHARACTER SET utf8 COLLATE utf8_general_ci;