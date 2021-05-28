INSERT INTO client
	(name)
VALUES
	('Жилстрой'),
	('Нефтебаза'),
	('ГОСП'),
	('Горстрой'),
	('Центр Для'),
	('Кожзавод'),
	('Теплосети'),
	('Минтруда'),
	('Цветлит'),
	('Чайка'),
	('СервисПромПак'),
	('Навигатор'),
	('Совет Ветеранов'),
	('ЗОВ Профиль'),
	('Бонади'),
	('Синтекс'),
	('Ясень'),
	('ВМ Системс');
	
INSERT INTO cartridge_group
	(title)
VALUES
	('HP 1005'),
	('HP 1005X'),
	('HP 1010'),
	('HP 1200'),
	('Samsung 2160'),
	('Samsung 1610'),
	('Samsung 1710'),
	('Kyocera');
	
INSERT INTO cartridge_model
	(name, group_id, type, color, default_grams)
VALUES
	('737', 1, 'MONOCHROME', 'BLACK', 100),
	('285', 1, 'MONOCHROME', 'BLACK', 100),
	('725', 1, 'MONOCHROME', 'BLACK', 100),
	('737X', 2, 'MONOCHROME', 'BLACK', 100),
	('283X', 2, 'MONOCHROME', 'BLACK', 100),
	('Q2612', 3, 'MONOCHROME', 'BLACK', 100),
	('703', 3, 'MONOCHROME', 'BLACK', 100),
	('FX10', 3, 'MONOCHROME', 'BLACK', 100),
	('EP27', 4, 'MONOCHROME', 'BLACK', 100),
	('101s', 5, 'MONOCHROME', 'BLACK', 100),
	('111x', 5, 'MONOCHROME', 'BLACK', 100),
	('ML1610', 6,'MONOCHROME', 'BLACK', 100),
	('3119', 6, 'MONOCHROME', 'BLACK', 100),
	('1710', 7, 'MONOCHROME', 'BLACK', 100),
	('4220', 7, 'MONOCHROME', 'BLACK', 100);
	
INSERT INTO cartridge
	(added_date, uniq_identify, cartridge_model_id, client_id)
VALUES
	('28-05-2021', 'B2000', 1, 1),
	('28-05-2021', 'B2001', 2, 2),
	('28-05-2021', 'B2002', 3, 1),
	('28-05-2021', 'B2003', 1, 2),
	('28-05-2021', 'B2004', 2, 1);
	
INSERT INTO employee
	(login, password, name, surname, position)
VALUES
	('admin', 'admin', 'Andrew', 'Savich', 'REFUELLER');

INSERT INTO refill
	(refill_date, cartridge_id, actual_grams, changed_drum, changed_magnet, is_issued_act, refueller_id)
VALUES
	('28-05-2021', 1, 90, true, false, true, 1),
	('28-05-2021', 2, 90, false, false, true, 1),
	('28-05-2021', 3, 90, true, true, true, 1),
	('28-05-2021', 1, 90, false, true, false, 1),
	('28-05-2021', 2, 90, true, false, true, 1),
	('28-05-2021', 3, 90, true, true, false, 1);

	