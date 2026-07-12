-- US009: Create Consumers table and MonthlyBill table for June

CREATE TABLE Consumers (
    ConsumerID      BIGINT PRIMARY KEY,
    ConsumerName    VARCHAR(50) NOT NULL,
    Email           VARCHAR(100) NOT NULL,
    MobileNumber    VARCHAR(10) NOT NULL,
    Address         VARCHAR(200),
    City            VARCHAR(50)
);

CREATE TABLE MonthlyBill_June (
    BillID          INT PRIMARY KEY,
    ConsumerID      BIGINT NOT NULL,
    BillAmount      DECIMAL(10,2) NOT NULL,
    PaymentStatus   VARCHAR(10) NOT NULL,
    FOREIGN KEY (ConsumerID) REFERENCES Consumers(ConsumerID)
);
