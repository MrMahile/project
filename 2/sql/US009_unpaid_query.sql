-- US009: Retrieve consumers who have NOT paid the bill
-- Uses IN operator and WHERE clause
-- Output: ConsumerId | ConsumerName

SELECT ConsumerID, ConsumerName
FROM Consumers
WHERE ConsumerID IN (
    SELECT ConsumerID
    FROM MonthlyBill_June
    WHERE PaymentStatus = 'Unpaid'
);
