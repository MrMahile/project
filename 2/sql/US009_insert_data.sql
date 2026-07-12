-- US009: Insert 10 records in both tables

-- Insert 5 consumers
INSERT INTO Consumers (ConsumerID, ConsumerName, Email, MobileNumber, Address, City)
VALUES (1001, 'Rajesh Kumar', 'rajesh@email.com', '9876543210', '12 MG Road', 'Mumbai');

INSERT INTO Consumers (ConsumerID, ConsumerName, Email, MobileNumber, Address, City)
VALUES (1002, 'Priya Sharma', 'priya@email.com', '8765432109', '45 Park Street', 'Delhi');

INSERT INTO Consumers (ConsumerID, ConsumerName, Email, MobileNumber, Address, City)
VALUES (1003, 'Amit Singh', 'amit@email.com', '7654321098', '78 Anna Salai', 'Chennai');

INSERT INTO Consumers (ConsumerID, ConsumerName, Email, MobileNumber, Address, City)
VALUES (1004, 'Sunita Devi', 'sunita@email.com', '6543210987', '23 Brigade Road', 'Bangalore');

INSERT INTO Consumers (ConsumerID, ConsumerName, Email, MobileNumber, Address, City)
VALUES (1005, 'Mohammed Ali', 'mohammed@email.com', '5432109876', '56 Nehru Nagar', 'Mumbai');

-- Insert 10 bill records (some paid, some unpaid)
INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (1, 1001, 1250.00, 'Paid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (2, 1002, 980.75, 'Unpaid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (3, 1003, 870.00, 'Paid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (4, 1004, 1350.75, 'Unpaid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (5, 1005, 1180.25, 'Paid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (6, 1001, 1100.50, 'Unpaid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (7, 1002, 1050.25, 'Unpaid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (8, 1003, 920.50, 'Paid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (9, 1004, 1420.00, 'Paid');

INSERT INTO MonthlyBill_June (BillID, ConsumerID, BillAmount, PaymentStatus)
VALUES (10, 1005, 1290.50, 'Unpaid');
