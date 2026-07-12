-- US008: Create CustomerBill table
-- Contains customer details, address, city, and bill amount

DROP TABLE IF EXISTS CustomerBill;

CREATE TABLE CustomerBill (
    ID              INTEGER PRIMARY KEY AUTOINCREMENT,
    ConsumerID      BIGINT NOT NULL,
    CustomerName    VARCHAR(50) NOT NULL,
    Address         VARCHAR(200) NOT NULL,
    City            VARCHAR(50) NOT NULL,
    BillAmount      DECIMAL(10,2) NOT NULL
);
