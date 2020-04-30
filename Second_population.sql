INSERT INTO MEDICAL_UNIT(unitName, address, medical_services)
			VALUES('Policlinica Promedis', 'Strada Bucuresti 80', 'Neurologie; Neurologie Pediatrica; Psihologie; Psihiatrie; Alergologie si imunologie clinica; Diabet, boli de nutritie si metabolism; Medicina Interna; Endocrinologie; Medicina Generala; Explorari functionale'),
				   ('Policlinica Salvosan', 'Strada Victor Babes 25', 'Obstetrica – Ginecologie; Analize de laborator; Cardiologie; Dermatologie – venerologie; Pneumologie; O.R.L.; Gastroenterologie; Pediatrie - Neonatologie; Urologie'),
				   ('Policlinica Parvulescu', 'Strada Gheorghe Lazar 5', ' Anestezie - terapie intensiva; Ortopedie - Traumatologie; Chirurgie generala; Oftalmologie; Alte servicii; Osteodensitometrie; Stomatologie; Radiologie - Imagistica Medicala');
				   
	
	call policlinica2.MEDICAL_UNIT_PROGRAM(1, '06:00:00', '02:00:00', '19:00:00', '03:30:00');
	call policlinica2.MEDICAL_UNIT_PROGRAM(2, '07:30:00', '01:00:00', '17:00:00', '01:30:00');
	call policlinica2.MEDICAL_UNIT_PROGRAM(3, '06:30:00', '01:30:00', '18:00:00', '02:30:00');
	
	
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('admin@admin.com', 'admin', 'admin', 'ADMINISTRATOR', '1959803283029', 'Andrei', 'Marc', '17 Roses Street', '0795152778', 'RO169NRG2835334487999106', 1999, '2018-11-23', '', '100', 10000.00, '');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('admin2@admin.com', 'admin2', 'admin2', 'ADMINISTRATOR', '1949803283335', 'Razvan', 'Marginean', '29 Beach Street', '0743495367', 'RO99ONRG2825334487989103', 1998, '2018-10-01', '', '100', 10000.00, '');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('admin3@admin.com', 'admin3', 'admin3', 'ADMINISTRATOR', '1979803283029', 'Paul', 'Moldovan', '70 Hill Street', '0794452069', 'RO55ONRG2825334487989105', 1997, '2018-06-04', '', '100', 10000.00, '');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('superadmin@superadmin.com', 'superadmin', 'superadmin', 'SUPER-ADMINISTRATOR', '1919803249729', 'Costel', 'Parvulescu', '20 Lion Street', '0725496309', 'RO199NRG2821486487989102', 2000, '2018-01-01', '', '100', 15000.00, '');	


insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('lwarland1n@skyrock.com', 'lwarland1n', 'Xk1rx11', 'EMPLOYEE', '2999803283029', 'Lind', 'Warland', '16 Monument Street', '0795152069', 'RO16ONRG2825334487989102', 60, '2019-01-03', 'Medic', '180', 25000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('dbugdellg@t-online.de', 'dbugdellg', 'Id0Ajp', 'EMPLOYEE', '2988908018162', 'Dicky', 'Bugdell', '29004 Northwestern Street', '0773571167', 'RO30NLEC9887685936703270', 17, '2016-08-02', 'Medic', '140', 20000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('mjuschkap@unicef.org', 'mjuschkap', 'KIuxVToPM8c', 'EMPLOYEE', '1998377374505', 'Melisande', 'Juschka', '97637 Moose Lane', '0770842038', 'RO43KBJC7495367049549951', 26, '2011-02-05', 'Medic', '180', 25000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('wvynollz@usnews.com', 'wvynollz', 'VpEU4OR', 'EMPLOYEE', '2998586729057', 'Wilie', 'Vynoll', '5525 Jay Terrace', '0767141846', 'RO17EJOK6764437830749364', 36, '2014-02-05', 'Medic', '84', 12000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('lhammell1s@chron.com', 'lhammell1s', 'hG2rVbc7Jo', 'EMPLOYEE', '2997637542660', 'Lynnelle', 'Hammell', '114 Dovetail Park', '0748513447', 'RO32NSFM1599049503123221', 65, '2015-11-26', 'Medic', '160', 22500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('bjenkins6@desdev.cn', 'bjenkins6', 'SpvCmJqZjK', 'EMPLOYEE', '2979335963649', 'Bambi', 'Jenkins', '16 Texas Hill', '0724041090', 'RO75THMQ9806814840209919', 7, '2011-01-30', 'Medic', '174', 24000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('kschohiern@oracle.com', 'kschohiern', 'e88WkUI', 'EMPLOYEE', '1994789969655', 'Kath', 'Schohier', '4 Acker Crossing', '0742649664', 'RO38PSFC0214731815169509', 24, '2010-06-19', 'Medic', '158', 22000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('dbier1o@google.co.jp', 'dbier1o', 'DyGdZjskuhRF', 'EMPLOYEE', '1969201993304', 'Dmitri', 'Bier', '973 Kipling Alley', '0794747699', 'RO87HBNK1966035942471051', 61, '2007-08-25', 'Medic', '158', 22000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('rmcane2o@weather.com', 'rmcane2o', '0Z7agDqluF', 'EMPLOYEE', '2968531099260', 'Roxi', 'McAne', '2616 Elmside Plaza', '0723241475', 'RO09PDRV5254864341228371', 97, '2006-09-15', 'Medic', '116', 17000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('ahugett23@wiley.com', 'ahugett23', 'SSBcUntU8s', 'EMPLOYEE', '1998074677734', 'Angelo', 'Hugett', '5494 Hanson Road', '0789873492', 'RO49EMOH0105010001533903', 76, '2005-02-23', 'Medic', '128', 18000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('gwoolpertd@springer.com', 'gwoolpertd', 'ZD0VvmB6', 'EMPLOYEE', '2987339544366', 'Gabriello', 'Woolpert', '3005 Nova Avenue', '0722263783', 'RO46KIAW9749475805543579', 14, '2012-08-07', 'Medic', '158', 22000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('gmichelir@boston.com', 'gmichelir', '0MaztSVRdE', 'EMPLOYEE', '2999863168489', 'Geri', 'Micheli', '8 Main Road', '0734462244', 'RO85AJPE9072031374770573', 28, '2012-01-11', 'Medic', '120', 17500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('rcarriagej@netscape.com', 'rcarriagej', 'UeWy0n85Tn', 'EMPLOYEE', '1969056319216', 'Robbie', 'Carriage', '4 Scott Drive', '0790717255', 'RO18QLUK4149770090491251', 20, '2018-03-14', 'Medic', '134', 19000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('spochin29@skype.com', 'spochin29', 'CCXmlfx', 'EMPLOYEE', '1969355273061', 'Sal', 'Pochin', '99 Bluejay Place', '0721472707', 'RO59CTYZ7902096385188847', 82, '2014-07-02', 'Medic', '128', 18000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('cspall1a@behance.net', 'cspall1a', 'ng4y0uP4HaB3', 'EMPLOYEE', '2994573604553', 'Cecilio', 'Spall', '90 North Parkway', '0762804238', 'RO27WDSV5426914773387667', 47, '2005-08-28', 'Medic', '84', 12000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('mhaughin3@wordpress.com', 'mhaughin3', 'x4xzEP0x', 'EMPLOYEE', '1999925244527', 'Merrile', 'Haughin', '6172 Golf Course Terrace', '0744639398', 'RO35MIPT7882224740113850', 4, '2013-02-10', 'Medic', '140', 20000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('gkosiadaw@naver.com', 'gkosiadaw', 'bS7yjQlz', 'EMPLOYEE', '2989250521289', 'Grace', 'Kosiada', '45547 Elka Drive', '0770687860', 'RO91IGKP4177966496677601', 33, '2018-10-01', 'Medic', '174', 24000.00, 'Medical');


insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('rlillecrap7@about.com', 'rlillecrap7', 'pVriUxeq76OS', 'EMPLOYEE', '1988338617214', 'Renae', 'Lillecrap', '68 Clarendon Court', '0729498235', 'RO75WDOS7349624137932290', 108, '2010-12-06', 'Asistent Medical', 188, 8000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('kschneidau19@wisc.edu', 'kschneidau19', 'wZdZIqxK', 'EMPLOYEE', '1986588879954', 'Kai', 'Schneidau', '1408 Pennsylvania Point', '0784953915', 'RO27OZIN3767658526409674', 146, '2016-06-26', 'Asistent Medical', 180, 7500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('lheilds49@army.mil', 'lheilds49', 'GV7TKE', 'EMPLOYEE', '1989916333397', 'Loria', 'Heilds', '4217 Texas Way', '0715887780', 'RO91EYHN2162366124252842', 254, '2017-08-04', 'Asistent Medical', 160, 5500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('sswinbourne3k@patch.com', 'sswinbourne3k', '1BNpDdWjV9', 'EMPLOYEE', '2988012252251', 'Sebastian', 'Swinbourne', '2 Doe Crossing Center', '0753933937', 'RO97IYBC4166302102949686', 229, '2011-01-28', 'Asistent Medical', 180, 7500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('gmackee4v@stanford.edu', 'gmackee4v', 'e7YGxPcF7e', 'EMPLOYEE', '2979949968372', 'Gabriel', 'MacKee', '9 Acker Trail', '0736258288', 'RO76AXSV1483803530557448', 276, '2017-04-16', 'Asistent Medical', 140, 3500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('tstirley2g@cdbaby.com', 'tstirley2g', 'sgJHJT7UO', 'EMPLOYEE', '2999139254027', 'Thadeus', 'Stirley', '7 Fisk Plaza', '0780377483', 'RO10BEPT3540057045307557', 189, '2009-10-25', 'Asistent Medical', 140, 3500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('aodom1v@digg.com', 'aodom1v', '0eSGgo', 'EMPLOYEE', '2998084013959', 'Alfonso', 'Odom', '5 Service Court', '0737758566', 'RO15FBSY5816709057038949', 168, '2015-06-21', 'Asistent Medical', 150, 4000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('ecush2c@xrea.com', 'ecush2c', 'K7UWgBNoicRX', 'EMPLOYEE', '1979092180720', 'Evvy', 'Cush', '92 Ohio Junction', '0778184030', 'RO66OQWA1642122642890713', 185, '2006-11-06', 'Asistent Medical', 120, 2500.00 , 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('jraddan3j@msu.edu', 'jraddan3j', 'x6YrEBjYywhs', 'EMPLOYEE', '1999052448812', 'Jase', 'Raddan', '5 Buhler Road', '0789241038', 'RO13BDSA2380673743081800', 228, '2007-07-13', 'Asistent Medical', 156, 5000.00, 'Medical');


insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('nwerndley5@plala.or.jp', 'nwerndley5', '8rXQQLUDs', 'EMPLOYEE', '1989901534969', 'Nannette', 'Werndley', '96 Ramsey Lane', '0718838796', 'RO78ANEX0546926999911551', 381, '2005-01-25', 'Receptioner', 142, 4000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('esilverstone14@printfriendly.com', 'esilverstone14', 'vEwxrAofkc5M', 'EMPLOYEE', '2989340256573', 'Elvera', 'Silverstone', '40579 Northfield Park', '0799383526', 'RO95HXFE8857235277524381', 416, '2016-02-06', 'Receptioner', 142, 4000.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('jmcrinnd@whitehouse.gov', 'jmcrinnd', 'iyQFJPutnf', 'EMPLOYEE', '2999766541876', 'Jennine', 'McRinn', '17130 Talisman Center', '0724333772', 'RO06ZIHV6205325591933357', 389, '2007-02-11', 'Receptioner', 44, 1750.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('drawsthorne0@booking.com', 'drawsthorne0', '0gvIRfYOXbl', 'EMPLOYEE', '1978446252710', 'Dorita', 'Rawsthorne', '0610 Buhler Drive', '0763360581', 'RO09ADXU5865070958472508', 376, '2007-04-22', 'Receptioner', 190, 5500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('afeatenby7@ucoz.com', 'afeatenby7', 'UB9qZGPibw', 'EMPLOYEE', '2999317845738', 'Alexio', 'Featenby', '52 Dunning Junction', '0775900028', 'RO85AIRG2662635737033388', 383, '2013-07-03', 'Receptioner', 92, 2700.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('adymottk@dot.gov', 'adymottk', 'GbqMRXAx', 'EMPLOYEE', '1998072461908', 'Anne-corinne', 'Dymott', '228 Sherman Crossing', '0727149300', 'RO72GXSH5292942287255058', 396, '2005-10-10', 'Receptioner', 144, 4050.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('jstorrahu@spotify.com', 'jstorrahu', 'oA8n8MB7PAt', 'EMPLOYEE', '2998705865843', 'Janka', 'Storrah', '98 Coleman Road', '0728682916', 'RO74ANBD1519424259918819', 406, '2012-10-31', 'Receptioner', 161, 4500.00, 'Medical');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('lgotthard1d@youtube.com', 'lgotthard1d', 'BLpGVtLmWO', 'EMPLOYEE', '1965805706801', 'Leicester', 'Gotthard', '449 Kipling Circle', '0799398357', 'RO79RXGT9893296524233788', 425, '2013-07-25', 'Receptioner', 40, 1500.00, 'Medical');


insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('aroughey0@dyndns.org', 'aroughey0', '15z5Ante8y', 'EMPLOYEE', '1999199074968', 'Ariella', 'Roughey', '8 Norway Maple Drive', '0783118085', 'RO73PGNW3954849555979503', 301, '2012-05-07', 'Expert financiar-contabil', 130, 4500.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('jvidlocx@census.gov', 'jvidlocx', 'bv6K8E', 'EMPLOYEE', '1989368630074', 'Jazmin', 'Vidloc', '12 Oxford Point', '0771182387', 'RO26XALG2366716355203550', 334, '2018-04-22', 'Expert financiar-contabil', 104, 3000.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('dertelt1c@umn.edu', 'dertelt1c', 'HycfAxyW', 'EMPLOYEE', '1999876509628', 'Domingo', 'Ertelt', '2820 Waywood Hill', '0741693904', 'RO96UKNE4490164149788685', 349, '2017-12-21', 'Expert financiar-contabil', 80, 2500.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('allopis1n@ca.gov', 'allopis1n', 'jO2F8e686gLx', 'EMPLOYEE', '2998016742143', 'Annamaria', 'Llopis', '7 Lakewood Gardens Drive', '0707821379', 'RO52WUOH8533839610287970', 360, '2014-11-26', 'Expert financiar-contabil', 116, 3500.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('rstillgoe1z@bbc.co.uk', 'rstillgoe1z', '5YS8R5c', 'EMPLOYEE', '2998615229328', 'Rikki', 'Stillgoe', '48042 Eastlawn Plaza', '0726203759', 'RO51ZFCV1436508706232618', 372, '2008-06-28', 'Expert financiar-contabil', 128, 4000.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('lhadland1q@simplemachines.org', 'lhadland1q', 'A58C18l', 'EMPLOYEE', '1999426777434', 'Lizzy', 'Hadland', '8963 Pankratz Road', '0760389036', 'RO70ZVXC7575590560891890', 363, '2006-12-27', 'Expert financiar-contabil', 126, 4000.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('epepperell1o@hao123.com', 'epepperell1o', '9os0KZ', 'EMPLOYEE', '2979460708503', 'Eugenius', 'Pepperell', '034 Melody Pass', '0719288021', 'RO03ZWCB4399102816228302', 361, '2009-03-04', 'Expert financiar-contabil', 80, 2500.00, 'Financiar contabil');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('jgurton22@merriam-webster.com', 'jgurton22', '6BgWUaA', 'EMPLOYEE', '1989538005705', 'Jorry', 'Gurton', '93 Sauthoff Avenue', '0739695984', 'RO55DTAX8890894596989693', 375, '2018-09-11', 'Expert financiar-contabil', 80, 2500.00, 'Financiar contabil');


insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('blisle0@flickr.com', 'blisle0', 'YEWfmAdHSS', 'EMPLOYEE', '2977480121135', 'Brennan', 'Lisle', '48701 International Way', '0768491265', 'RO93IGAJ6441718247606637', 426, '2017-10-30', 'Inspector resurse umane', 130, 4500.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('smarkham1d@boston.com', 'smarkham1d', 'XlINugzJW', 'EMPLOYEE', '2988470689647', 'Sandi', 'Markham', '5 Cottonwood Drive', '0713012890', 'RO33QWYK7932471153255350', 475, '2018-05-11', 'Inspector resurse umane', 104, 2275.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('klaybourn2@netscape.com', 'klaybourn2', 'ppy8Ugd', 'EMPLOYEE', '1998094083394', 'Kenton', 'Laybourn', '8263 Atwood Park', '0760596834', 'RO90FWAP9608138481249004', 428, '2016-02-15', 'Inspector resurse umane', 80, 1500.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('cbaynomw@is.gd', 'cbaynomw', 'QgYuFqB', 'EMPLOYEE', '1998463847858', 'Chev', 'Baynom', '3 Pawling Parkway', '0732552024', 'RO55HVPA6457897270353417', 458, '2012-01-08', 'Inspector resurse umane', 116, 3500.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('rgollin11@alexa.com', 'rgollin11', 'Rrblk6uNbt7', 'EMPLOYEE', '2989115924783', 'Reynold', 'Gollin', '8047 School Plaza', '0711344350', 'RO27RXVY3242088585387081', 463, '2010-05-21', 'Inspector resurse umane', 128, 4250.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('kgonthard19@vkontakte.ru', 'kgonthard19', 'ozIT7w', 'EMPLOYEE', '2989642960424', 'Kendall', 'Gonthard', '410 Emmet Circle', '0726612216', 'RO36JWEP6811860493781480', 471, '2006-03-05', 'Inspector resurse umane', 126, 4000.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('areinbeck1a@squidoo.com', 'areinbeck1a', 'hpCtCTy', 'EMPLOYEE', '1979446434640', 'Agathe', 'Reinbeck', '1523 Magdeline Pass', '0710358366', 'RO14JQKA7164317176041518', 472, '2008-03-29', 'Inspector resurse umane', 80, 1500.00, 'Resurse umane');
insert into EMPLOYEE (email, username_, password_, userType, CNP, firstName, lastName, address, telephoneNumber, IBAN, contractNumber, employmentDate, employeeType, hoursPerMonth, negotiatedSalary, departmentName) values ('gkinnen1b@ustream.tv', 'gkinnen1b', 'bNfAOEa', 'EMPLOYEE', '2986981257145', 'Genovera', 'Kinnen', '6445 Esker Park', '0770524970', 'RO13YTHB9736486527176100', 473, '2018-08-19', 'Inspector resurse umane', 80, 1500.00, 'Resurse umane');



call policlinica2.ADD_DOCTOR('Lind','Warland', 'Primar', 'Doctor in stiinte medicale', 'Profesor', 0.35, 'stamp1');
call policlinica2.ADD_DOCTOR('Dicky','Bugdell', 'Specialist', 'Doctor in stiinte medicale', 'Conferentiar', 0.23, 'stamp2');
call policlinica2.ADD_DOCTOR('Melisande','Juschka', 'Primar', 'Doctor in stiinte medicale', '', 0.23, 'stamp3');
call policlinica2.ADD_DOCTOR('Wilie','Vynoll','Specialist', 'Doctorand', '', 0.17, 'stamp4');
call policlinica2.ADD_DOCTOR('Lynnelle','Hammell', 'Primar', 'Doctor in stiinte medicale', 'Profesor', 0.35, 'stamp5');
call policlinica2.ADD_DOCTOR('Bambi','Jenkins', 'Primar', 'Doctor in stiinte medicale', 'Conferentiar', 0.31, 'stamp6');
call policlinica2.ADD_DOCTOR('Kath','Schohier', 'Specialist', 'Doctor in stiinte medicale', 'Sef de lucrari', 0.21, 'stamp7');
call policlinica2.ADD_DOCTOR('Dmitri','Bier','Specialist', '', '', 0.17, 'stamp8');
call policlinica2.ADD_DOCTOR('Roxi','McAne','Specialist', 'Doctorand', '', 0.18, 'stamp8');
call policlinica2.ADD_DOCTOR('Angelo','Hugett', 'Primar', 'Doctorand', 'Conferentiar', 0.25, 'stamp9');
call policlinica2.ADD_DOCTOR('Gabriello','Woolpert', 'Specialist', 'Doctor in stiinte medicale', 'Conferentiar', 0.23, 'stamp10');
call policlinica2.ADD_DOCTOR('Geri','Micheli','Specialist', 'Doctorand', '', 0.17, 'stamp11');
call policlinica2.ADD_DOCTOR('Robbie','Carriage', 'Specialist', 'Doctorand', 'Conferentiar', 0.20, 'stamp12');
call policlinica2.ADD_DOCTOR('Sal','Pochin', 'Primar', 'Doctor in stiinte medicale', '', 0.23, 'stamp13');
call policlinica2.ADD_DOCTOR('Cecilio','Spall', 'Primar', 'Doctor in stiinte medicale', '', 0.23, 'stamp14');
call policlinica2.ADD_DOCTOR('Merrile','Haughin', 'Primar', 'Doctorand', 'Profesor', 0.24, 'stamp15');
call policlinica2.ADD_DOCTOR('Grace','Kosiada', 'Primar', 'Doctorand', 'Conferentiar', 0.25, 'stamp16');



call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lind','Warland', 'Neurologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lind','Warland','Neurologie Pediatrica');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lind','Warland','Psihologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lind','Warland','Psihiatrie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Dicky','Bugdell','Analize de laborator');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Dicky','Bugdell','Obstetrica – Ginecologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Melisande','Juschka','Alergologie si imunologie clinica');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Melisande','Juschka','Psihologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Wilie','Vynoll','Anestezie - terapie intensiva');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Wilie','Vynoll','Oftalmologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lynnelle','Hammell','Cardiologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lynnelle','Hammell','Dermatologie – venerologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Lynnelle','Hammell','Analize de laborator');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Bambi','Jenkins','Chirurgie generala');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Bambi','Jenkins','Oftalmologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Kath','Schohier','Diabet, boli de nutritie si metabolism');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Kath','Schohier','Medicina Interna');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Dmitri','Bier','Endocrinologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Dmitri','Bier','Medicina Generala');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Roxi','McAne','Explorari functionale');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Roxi','McAne','Medicina Generala');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Angelo','Hugett','Gastroenterologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Angelo','Hugett','O.R.L.');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Angelo','Hugett','Pneumologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Gabriello','Woolpert','Oftalmologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Gabriello','Woolpert','Alte servicii');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Geri','Micheli','Ortopedie - Traumatologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Geri','Micheli','Anestezie - terapie intensiva');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Robbie','Carriage','Osteodensitometrie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Robbie','Carriage','Stomatologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Sal','Pochin','Pediatrie - Neonatologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Sal','Pochin','Pneumologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Cecilio','Spall','Radiologie - Imagistica Medicala');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Cecilio','Spall','Osteodensitometrie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Merrile','Haughin','Reumatologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Merrile','Haughin','Urologie');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Grace','Kosiada','Alte servicii');
call policlinica2.ADD_SPECIALITY_TO_DOCTOR('Grace','Kosiada','Urologie');


call policlinica2.ADD_MEDICAL_ASSISTANT('Renae','Lillecrap', 'Generalist', 'Principal');
call policlinica2.ADD_MEDICAL_ASSISTANT('Kai','Schneidau', 'Radiologie', 'Principal');
call policlinica2.ADD_MEDICAL_ASSISTANT('Loria','Heilds', 'Laborator', 'Secundar');
call policlinica2.ADD_MEDICAL_ASSISTANT('Sebastian','Swinbourne', 'Generalist', 'Principal');
call policlinica2.ADD_MEDICAL_ASSISTANT('Gabriel','MacKee', 'Radiologie', 'Secundar');
call policlinica2.ADD_MEDICAL_ASSISTANT('Thadeus','Stirley', 'Laborator', 'Secundar');
call policlinica2.ADD_MEDICAL_ASSISTANT('Alfonso','Odom', 'Generalist', 'Secundar');
call policlinica2.ADD_MEDICAL_ASSISTANT('Evvy','Cush', 'Radiologie', 'Principal');
call policlinica2.ADD_MEDICAL_ASSISTANT('Jase','Raddan', 'Laborator', 'Principal');




INSERT INTO GENERIC_TIMETABLE(day_, startTime, endTime, unitID, employeeNo)
		VALUES('Monday', '08:00:00', '17:00:00', 1, 1),
			('Tuesday', '08:00:00', '17:00:00', 1, 1),
			('Wednesday', '09:00:00', '18:00:00', 1, 1),
			('Thursday', '09:00:00', '18:00:00', 1, 1),
			('Friday', '08:30:00', '17:30:00', 1, 1),

			('Tuesday', '08:00:00', '15:00:00', 2, 2),
			('Wednesday', '09:00:00', '16:00:00', 2, 2),
			('Thursday', '09:00:00', '16:00:00', 2, 2),
			('Friday', '09:30:00', '16:30:00', 2, 2),
            ('Saturday', '10:00:00', '17:00:00', 2, 2),
            
           	('Monday', '06:00:00', '15:00:00', 1, 3),
			('Tuesday', '06:00:00', '15:00:00', 1, 3),
			('Wednesday', '06:00:00', '15:00:00', 1, 3),
			('Thursday', '06:00:00', '15:00:00', 1, 3),
			('Friday', '06:00:00', '15:00:00', 1, 3),
            
           	('Friday', '06:30:00', '12:30:00', 3, 4),
           	('Saturday', '08:00:00', '15:30:00', 3, 4),
            ('Sunday', '08:00:00', '15:30:00', 3, 4),

           	('Monday', '06:00:00', '14:00:00', 2, 5),
			('Tuesday', '06:00:00', '14:00:00', 2, 5),
			('Wednesday', '06:00:00', '14:00:00', 2, 5),
			('Thursday', '06:00:00', '14:00:00', 2, 5),
			('Friday', '06:00:00', '14:00:00', 2, 5),
            
           	('Monday', '06:30:00', '15:30:00', 3, 6),
			('Tuesday', '06:30:00', '15:30:00', 3, 6),
			('Wednesday', '06:30:00', '15:30:00', 3, 6),
			('Thursday', '06:30:00', '15:30:00', 3, 6),
			('Friday', '08:00:00', '15:30:00', 3, 6),

			('Monday', '11:00:00', '19:00:00', 1, 7),
			('Tuesday', '11:00:00', '19:00:00', 1, 7),
			('Wednesday', '11:00:00', '19:00:00', 1, 7),
			('Thursday', '11:00:00', '19:00:00', 1, 7),
			('Saturday', '08:00:00', '15:30:00', 1, 7),

			('Monday', '11:00:00', '19:00:00', 1, 8),
			('Tuesday', '11:00:00', '19:00:00', 1, 8),
			('Wednesday', '11:00:00', '19:00:00', 1, 8),
			('Thursday', '11:00:00', '19:00:00', 1, 8),
			('Sunday', '08:00:00', '15:30:00', 1, 8),

			('Monday', '10:00:00', '18:00:00', 1, 9),
			('Friday', '8:00:00', '15:00:00', 1, 9),
			('Saturday', '08:00:00', '15:00:00', 1, 9),
			('Sunday', '08:00:00', '15:00:00', 1, 9),

			('Monday', '06:00:00', '14:00:00', 2, 10),
			('Tuesday', '06:00:00', '14:00:00', 2, 10),
			('Wednesday', '06:00:00', '14:00:00', 2, 10),
			('Thursday', '06:00:00', '14:00:00', 2, 10),
			('Friday', '06:00:00', '14:00:00', 2, 10),

			('Monday', '10:00:00', '18:00:00', 3, 11),
			('Tuesday', '10:00:00', '18:00:00', 3, 11),   
			('Wednesday', '10:00:00', '18:00:00', 3, 11),
			('Thursday', '10:00:00', '18:00:00', 3, 11),
			('Friday', '9:30:00', '17:00:00', 3, 11),

			('Monday', '07:00:00', '15:00:00', 3, 12),
			('Tuesday', '07:00:00', '15:00:00', 3, 12),
			('Saturday', '08:00:00', '15:00:00', 3, 12),
			('Sunday', '08:00:00', '15:00:00', 3, 12),
			
			('Monday', '06:30:00', '18:00:00', 3, 13),
			('Wednesday', '06:30:00', '18:00:00', 3, 13),
			('Friday', '6:30:00', '17:00:00', 3, 13),

			('Monday', '06:00:00', '14:00:00', 2, 14),
			('Tuesday', '06:00:00', '14:00:00', 2, 14),
			('Wednesday', '06:00:00', '14:00:00', 2, 14),
			('Thursday', '06:00:00', '14:00:00', 2, 14),
			('Friday', '06:00:00', '14:00:00', 2, 14),

			('Friday', '06:30:00', '12:30:00', 3, 15),
           	('Saturday', '08:00:00', '15:30:00', 3, 15),
            ('Sunday', '08:00:00', '15:30:00', 3, 15),

			('Tuesday', '08:00:00', '15:00:00', 2, 16),
			('Wednesday', '09:00:00', '16:00:00', 2, 16),
			('Thursday', '09:00:00', '16:00:00', 2, 16),
			('Friday', '09:30:00', '16:30:00', 2, 16),
            ('Saturday', '10:00:00', '17:00:00', 2, 16),
            
			('Monday', '06:30:00', '15:30:00', 3, 17),
			('Tuesday', '06:30:00', '15:30:00', 3, 17),
			('Wednesday', '06:30:00', '15:30:00', 3, 17),
			('Thursday', '06:30:00', '15:30:00', 3, 17),
			('Friday', '08:00:00', '15:30:00', 3, 17);
			
			
			
			
INSERT INTO GENERIC_TIMETABLE(day_, startTime, endTime, unitID, employeeNo)
	VALUES('Monday', '06:00:00', '14:00:00', 1, 18),
			('Tuesday', '06:00:00', '14:00:00', 1, 18),
			('Wednesday', '06:00:00', '14:00:00', 1, 18),
			('Thursday', '06:00:00', '14:00:00', 1, 18),
			('Saturday', '08:00:00', '15:30:00', 1, 18),
           	('Sunday', '08:00:00', '15:30:00', 1, 18),

			('Monday', '10:00:00', '19:00:00', 1, 19),
			('Tuesday', '10:00:00', '19:00:00', 1, 19),
			('Wednesday', '10:00:00', '19:00:00', 1, 19),
			('Thursday', '10:00:00', '19:00:00', 1, 19),
			('Friday', '08:30:00', '17:30:00', 1, 19),

			('Monday', '08:00:00', '16:00:00', 1, 20),
			('Tuesday', '08:00:00', '16:00:00', 1, 20),
			('Wednesday', '08:00:00', '16:00:00', 1, 20),
			('Thursday', '08:00:00', '16:00:00', 1, 20),
			('Friday', '06:00:00', '14:00:00', 1, 20),

			('Monday', '07:30:00', '16:30:00', 2, 21),
			('Tuesday', '07:30:00', '16:30:00', 2, 21),
			('Wednesday', '07:30:00', '16:30:00', 2, 21),
			('Thursday', '07:30:00', '16:30:00', 2, 21),
			('Friday', '08:30:00', '15:30:00', 2, 21),
			
			('Monday', '10:00:00', '17:00:00', 2, 22),
			('Tuesday', '10:00:00', '17:00:00', 2, 22),
			('Thursday', '10:00:00', '17:00:00', 2, 22),
			('Saturday', '08:30:00', '15:30:00', 2, 22),
            ('Sunday', '08:30:00', '15:30:00', 2, 22),
			
			('Monday', '09:00:00', '16:00:00', 2, 23),
			('Tuesday', '09:00:00', '16:00:00', 2, 23),
			('Wednesday', '09:00:00', '16:00:00', 2, 23),
			('Thursday', '09:00:00', '16:00:00', 2, 23),
			('Saturday', '08:30:00', '15:30:00', 2, 23),

			('Monday', '06:30:00', '14:00:00', 3, 24),
			('Tuesday', '06:30:00', '14:00:00', 3, 24),
			('Friday', '06:30:00', '14:30:00', 3, 24),
			('Sunday', '08:30:00', '15:30:00', 3, 24),
			('Saturday', '08:30:00', '15:30:00', 3, 24),

			('Monday', '12:00:00', '18:00:00', 3, 25),
			('Tuesday', '12:00:00', '18:00:00', 3, 25),
			('Wednesday', '12:00:00', '18:00:00', 3, 25),
			('Thursday', '12:00:00', '18:00:00', 3, 25),
			('Friday', '06:30:00', '12:30:00', 3, 25),

			('Wednesday', '10:00:00', '18:00:00', 3, 26),
			('Thursday', '10:00:00', '18:00:00', 3, 26),
			('Friday', '11:00:00', '17:00:00', 3, 26),
			('Saturday', '08:30:00', '15:30:00', 3, 26),
            ('Sunday', '08:30:00', '15:30:00', 3, 26);


			
INSERT INTO GENERIC_TIMETABLE(day_, startTime, endTime, unitID, employeeNo)
	VALUES('Monday', '06:00:00', '13:00:00', 1, 27),
			('Tuesday', '06:00:00', '13:00:00', 1, 27),
			('Wednesday', '06:00:00', '13:00:00', 1, 27),
			('Thursday', '06:00:00', '13:00:00', 1, 27),
            ('Sunday', '08:00:00', '15:30:00', 1, 27),

			('Monday', '13:00:00', '19:00:00', 1, 28),
			('Tuesday', '13:00:00', '19:00:00', 1, 28),
			('Wednesday', '13:00:00', '19:00:00', 1, 28),
			('Thursday', '13:00:00', '19:00:00', 1, 28),
			('Friday', '06:00:00', '14:00:00', 1, 28),

			('Friday', '14:00:00', '17:30:00', 1, 29),
			('Saturday', '08:00:00', '15:30:00', 1, 29),

			('Monday', '07:30:00', '17:00:00', 2, 30),
			('Tuesday', '07:30:00', '17:00:00', 2, 30),
			('Wednesday', '07:30:00', '17:00:00', 2, 30),
			('Thursday', '07:30:00', '17:00:00', 2, 30),

			('Friday', '07:30:00', '16:30:00', 2, 31),
			('Saturday', '08:30:00', '15:30:00', 2, 31),
			('Sunday', '08:30:00', '15:30:00', 2, 31),
           
			('Monday', '06:30:00', '16:00:00', 3, 32),
			('Tuesday', '06:30:00', '16:00:00', 3, 32),
			('Friday', '06:30:00', '15:30:00', 3, 32),
			('Saturday', '08:00:00', '15:30:00', 3, 32),

			('Wednesday', '06:30:00', '16:00:00', 3, 33),
			('Thursday', '06:30:00', '16:00:00', 3, 33),
			('Friday', '15:30:00', '17:00:00', 3, 33),
			('Sunday', '08:00:00', '15:30:00', 3, 33),
			
			('Monday', '16:00:00', '18:00:00', 3, 34),
			('Tuesday', '16:00:00', '18:00:00', 3, 34),
			('Wednesday', '16:00:00', '18:00:00', 3, 34),
			('Thursday', '16:00:00', '18:00:00', 3, 34);


			
INSERT INTO GENERIC_TIMETABLE(day_, startTime, endTime, unitID, employeeNo)
	VALUES('Monday', '06:00:00', '12:30:00', 1, 35),
			('Tuesday', '06:00:00', '12:30:00', 1, 35),
			('Wednesday', '06:00:00', '12:30:00', 1, 35),
			('Thursday', '06:00:00', '12:30:00', 1, 35),
            ('Friday', '06:00:00', '12:30:00', 1, 35),

			('Monday', '12:30:00', '19:00:00', 1, 36),
			('Tuesday', '12:30:00', '19:00:00', 1, 36),
			('Wednesday', '12:30:00', '19:00:00', 1, 36),
			('Thursday', '12:30:00', '19:00:00', 1, 36),

			('Friday', '12:30:00', '17:30:00', 1, 37),
			('Saturday', '08:00:00', '15:30:00', 1, 37),
			('Sunday', '08:00:00', '15:30:00', 1, 37),

			('Monday', '07:30:00', '12:30:00', 2, 38),
			('Tuesday', '07:30:00', '12:30:00', 2, 38),
			('Wednesday', '07:30:00', '12:30:00', 2, 38),
			('Thursday', '07:30:00', '12:30:00', 2, 38),
			('Friday', '07:30:00', '16:30:00', 2, 35),

			('Monday', '12:30:00', '16:30:00', 2, 39),
			('Tuesday', '12:30:00', '16:30:00', 2, 39),
			('Wednesday', '12:30:00', '16:30:00', 2, 39),
			('Thursday', '12:30:00', '16:30:00', 2, 39),
			('Saturday', '08:30:00', '15:30:00', 2, 39),
			('Sunday', '08:30:00', '15:30:00', 2, 39),

			('Monday', '06:30:00', '13:00:00', 3, 40),
			('Tuesday', '06:30:00', '13:00:00', 3, 40),
			('Wednesday', '06:30:00', '13:00:00', 3, 40),
			('Thursday', '06:30:00', '13:00:00', 3, 40),
            ('Friday', '06:30:00', '12:00:00', 3, 40),

			('Monday', '13:00:00', '18:00:00', 3, 41),
			('Tuesday', '13:00:00', '18:00:00', 3, 41),
			('Wednesday', '13:00:00', '18:00:00', 3, 41),
			('Thursday', '13:00:00', '18:00:00', 3, 41),

			('Friday', '12:00:00', '17:00:00', 3, 42),
			('Saturday', '08:00:00', '15:30:00', 3, 42),
			('Sunday', '08:00:00', '15:30:00', 3, 42);



INSERT INTO GENERIC_TIMETABLE(day_, startTime, endTime, unitID, employeeNo)
	VALUES('Monday', '06:00:00', '12:30:00', 1, 43),
			('Tuesday', '06:00:00', '12:30:00', 1, 43),
			('Wednesday', '06:00:00', '12:30:00', 1, 43),
			('Thursday', '06:00:00', '12:30:00', 1, 43),
           	('Friday', '06:00:00', '12:30:00', 1, 43),

			('Monday', '12:30:00', '19:00:00', 1, 44),
			('Tuesday', '12:30:00', '19:00:00', 1, 44),
			('Wednesday', '12:30:00', '19:00:00', 1, 44),
			('Thursday', '12:30:00', '19:00:00', 1, 44),

			('Friday', '12:30:00', '17:30:00', 1, 45),
			('Saturday', '08:00:00', '15:30:00', 1, 45),
			('Sunday', '08:00:00', '15:30:00', 1, 45),

			('Monday', '07:30:00', '12:30:00', 2, 46),
			('Tuesday', '07:30:00', '12:30:00', 2, 46),
			('Wednesday', '07:30:00', '12:30:00', 2, 46),
			('Thursday', '07:30:00', '12:30:00', 2, 46),
			('Friday', '07:30:00', '16:30:00', 2, 46),

			('Monday', '12:30:00', '16:30:00', 2, 47),
			('Tuesday', '12:30:00', '16:30:00', 2, 47),
			('Wednesday', '12:30:00', '16:30:00', 2, 47),
			('Thursday', '12:30:00', '16:30:00', 2, 47),
			('Saturday', '08:30:00', '15:30:00', 2, 47),
			('Sunday', '08:30:00', '15:30:00', 2, 47),

			('Monday', '06:30:00', '13:00:00', 3, 48),
			('Tuesday', '06:30:00', '13:00:00', 3, 48),
			('Wednesday', '06:30:00', '13:00:00', 3, 48),
			('Thursday', '06:30:00', '13:00:00', 3, 48),
            ('Friday', '06:30:00', '12:00:00', 3, 48),

			('Monday', '13:00:00', '18:00:00', 3, 49),
			('Tuesday', '13:00:00', '18:00:00', 3, 49),
			('Wednesday', '13:00:00', '18:00:00', 3, 49),
			('Thursday', '13:00:00', '18:00:00', 3, 49),

			('Friday', '12:00:00', '17:00:00', 3, 50),
			('Saturday', '08:00:00', '15:30:00', 3, 50),
			('Sunday', '08:00:00', '15:30:00', 3, 50);




