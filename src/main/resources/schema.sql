DROP TABLE IF EXISTS CUSTOMER;
set mode MySQL;
CREATE TABLE CUSTOMER (
ID INT AUTO_INCREMENT PRIMARY KEY,  
NAME VARCHAR(50) NOT NULL,
ADDRESS VARCHAR(50),
PHONE_NUMBER VARCHAR(11) NOT NULL
);