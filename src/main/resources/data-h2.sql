INSERT INTO CUSTOMER (NAME, ADDRESS, PHONE_NUMBER) VALUES ('John', '10th skjfkjf', 01100230),
('Anna', '10th ldajflkdsjf', 01200230),
('Jack', '', 01300230),
('Engy', '', 01400230);

INSERT INTO ERROR_DETAIL (MESSAGE, STATUS_CODE, DETAILS, DATE) VALUES ('TEST', 404, 'TEST DETAILS', '2012-09-17 18:47:52.69'),
('TEST2', 505, 'TEST DETAILS2', CURRENT_TIMESTAMP());



INSERT INTO ROLES (`NAME`) VALUES ('USER'),
('CREATOR'),
('EDITOR'),
('ADMIN');



INSERT INTO USER (`USERNAME`, `EMAIL`, `PASSWORD`, `IS_ENABLED`) VALUES ('patrick', 'user1@email.com', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', '1'),
('alex', 'user2@email.com', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', '1'),
('john', 'user3@email.com', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', '1'),
('namhm', 'user4@email.com', '$2a$10$GQT8bfLMaLYwlyUysnGwDu6HMB5G.tin5MKT/uduv2Nez0.DmhnOq', '1'),
('admin', 'user5@email.com', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', '1');


INSERT INTO USERS_ROLES (`ID`, `ROLE_ID`) VALUES (1, 1), -- user patrick has role USER
(2, 2), -- user alex has role CREATOR
(3, 3), -- user john has role EDITOR
(4, 2), -- user namhm has role CREATOR
(4, 3), -- user namhm has role EDITOR
(5, 4); -- user admin has role ADMIN