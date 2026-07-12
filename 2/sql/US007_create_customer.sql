-- US007: Create Customer Table for name search
-- Retrieve customers whose name ends with 'a', sorted by CustomerName DESC

DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    ConsumerID      BIGINT PRIMARY KEY,
    CustomerName    VARCHAR(50) NOT NULL,
    Email           VARCHAR(100) NOT NULL,
    MobileNumber    VARCHAR(10) NOT NULL,
    UserID          VARCHAR(20) NOT NULL,
    Password        VARCHAR(30) NOT NULL,
    ConfirmPassword VARCHAR(30) NOT NULL,
    Status          VARCHAR(10) DEFAULT 'Active'
);
