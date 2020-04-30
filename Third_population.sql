call policlinica2.ADD_VACATION('Lind', 'Warland', '2019-05-05', '2019-05-21', 'Concediu pentru formare profesionala');
call policlinica2.ADD_VACATION('Bambi','Jenkins', '2019-02-21', '2019-04-21', 'Concediu de maternitate');
call policlinica2.ADD_VACATION('Dmitri','Bier', '2019-10-21', '2019-11-14', 'Concediu de odihna');
call policlinica2.ADD_VACATION('Robbie','Carriage', '2019-04-01', '2019-04-05', 'Probleme personale');
call policlinica2.ADD_VACATION('Sal','Pochin', '2019-06-21', '2019-07-21', 'Concediu medical');
call policlinica2.ADD_VACATION('Sebastian', 'Swinbourne', '2019-02-02', '2019-03-29', 'Concediu parental');
call policlinica2.ADD_VACATION('Thadeus', 'Stirley', '2019-05-10', '2019-05-12', 'Probleme personale');
call policlinica2.ADD_VACATION('Evvy', 'Cush', '2019-03-30', '2019-06-10', 'Concediu de maternitate');
call policlinica2.ADD_VACATION('Nannette', 'Werndley', '2019-05-21', '2019-11-21', 'Concediu de maternitate');
call policlinica2.ADD_VACATION('Jennine', 'McRinn', '2019-10-10', '2019-10-18', 'Concediu pentru formare profesionala');
call policlinica2.ADD_VACATION('Anne-corinne', 'Dymott', '2019-09-22', '2019-12-31', 'Concediu de maternitate');
call policlinica2.ADD_VACATION('Sandi', 'Markham', '2019-02-05', '2019-06-21', 'Concediu de maternitate');
call policlinica2.ADD_VACATION('Reynold', 'Gollin', '2019-06-07', '2019-06-15', 'Probleme personale');
call policlinica2.ADD_VACATION('Jazmin', 'Vidloc', '2019-12-21', '2019-12-25', 'Concediu medical');
call policlinica2.ADD_VACATION('Lizzy', 'Hadland', '2019-03-25', '2019-04-20', 'Concediu parental');
call policlinica2.ADD_VACATION('Eugenius', 'Pepperell', '2019-08-10', '2019-08-15', 'Concediu de odihna');

call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-05-21', '06:30:00', '17:00:00', 'Lind', 'Warland', 1);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-09-09', '12:00:00', '16:00:00', 'Dicky','Bugdell', 2);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-06-23', '08:00:00', '12:00:00', 'Wilie','Vynoll', 3);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-02-04', '07:00:00', '14:00:00', 'Bambi','Jenkins', 3);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-12-12', '06:30:00', '11:00:00', 'Grace','Kosiada', 3);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-02-25', '13:30:00', '19:00:00', 'Nannette', 'Werndley', 1);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-10-01', '10:00:00', '17:00:00', 'Dorita', 'Rawsthorne', 2);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-05-01', '12:00:00', '19:00:00', 'Renae', 'Lillecrap', 1);
call policlinica2.ADD_SPECIFIC_TIMETABLE('2019-04-27', '08:30:00', '12:00:00', 'Jase', 'Raddan', 3);


call ADD_APPOINTMENT_V2('1981230125832', 'Aurel', 'Tamas', 'Lind','Warland','2019-02-07 10:00:00');
call ADD_APPOINTMENT_V2('1981230335832', 'Ciprian', 'Pop', 'Lind','Warland','2019-02-08 11:00:00');
call ADD_APPOINTMENT_V2('1981230121132', 'Rebeca', 'Pirvulescu', 'Bambi','Jenkins','2019-03-20 08:30:00');
call ADD_APPOINTMENT_V2('1981230125532', 'Mihai', 'Man', 'Dicky','Bugdell','2019-02-15 11:00:00');
call ADD_APPOINTMENT_V2('1981233225832', 'Sorana', 'Craciunescu','Melisande','Juschka','2019-02-12 12:00:00');
call ADD_APPOINTMENT_V2('1981291125832', 'Ioan', 'Costache','Grace','Kosiada','2019-02-07 10:00:00');
call ADD_APPOINTMENT_V2('1981230132832', 'Mircea','Irimies','Roxi','McAne','2019-02-08 10:00:00');
call ADD_APPOINTMENT_V2('1981210125832', 'Robert', 'Cobzariu', 'Geri','Micheli','2019-03-01 11:30:00');
call ADD_APPOINTMENT_V2('1981230231832', 'David','Dancila', 'Geri','Micheli','2019-10-11 15:00:00');
call ADD_APPOINTMENT_V2('1981231233832', 'Angelina-Mirela', 'Hurdui', 'Angelo','Hugett','2019-04-02 12:30:00');

call add_medical_service_to_appointment('Consiliere psihologica copil', 'Aurel', 'Tamas', 'Lind', 'Warland');
call add_medical_service_to_appointment('Consiliere psihologica adult', 'Ciprian', 'Pop', 'Lind', 'Warland');
call add_medical_service_to_appointment('Atitudine primara in arsuri', 'Rebeca', 'Pirvulescu', 'Bambi', 'Jenkins');
call add_medical_service_to_appointment('Determinari gaze sangvine', 'Mihai', 'Man', 'Dicky','Bugdell');
call add_medical_service_to_appointment('Testare cutanata la anestezice locale ( maxim 3 anestezice)', 'Sorana', 'Craciunescu', 'Melisande','Juschka');
call add_medical_service_to_appointment('Ecografie aparat urinar','Ioan', 'Costache' , 'Grace','Kosiada');
call add_medical_service_to_appointment('Montare Holter tensiune arteriala', 'Mircea','Irimies', 'Roxi','McAne');
call add_medical_service_to_appointment('Bandaj Dessault', 'Robert', 'Cobzariu', 'Geri','Micheli');
call add_medical_service_to_appointment('Atela deget', 'David','Dancila', 'Geri','Micheli');
call add_medical_service_to_appointment('Aspiratie auriculara', 'Angelina-Mirela', 'Hurdui', 'Angelo','Hugett');