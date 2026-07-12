-- US005: Create Customer Table
-- Consumer ID: 13 digit integer (Primary Key)
-- Customer Name: max 50 characters
-- Email: text
-- Mobile number: 10 digit
-- User ID: min 5, max 20 characters
-- Password: max 30 characters
-- Confirm Password: max 30 characters
-- Status: Active/Inactive

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
