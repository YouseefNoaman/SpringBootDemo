DROP TABLE IF EXISTS CUSTOMER;
set mode MySQL;
CREATE TABLE CUSTOMER (
ID INT AUTO_INCREMENT PRIMARY KEY,  
NAME VARCHAR(50) NOT NULL,
ADDRESS VARCHAR(50),
PHONE_NUMBER VARCHAR(11) NOT NULL
);

DROP TABLE IF EXISTS ERROR_DETAIL;
set mode MySQL;
CREATE TABLE ERROR_DETAIL (
ID INT AUTO_INCREMENT PRIMARY KEY,
MESSAGE VARCHAR NOT NULL,
DETAILS VARCHAR,
Date TIMESTAMP(3) NOT NULL
);