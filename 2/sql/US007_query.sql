-- US007: Retrieve customer details whose name ends with 'a'
-- Sorted in descending order by customer name
-- Output columns: CustomerId | CustomerName | Email

SELECT ConsumerID AS CustomerId,
       CustomerName,
       Email
FROM Customer
WHERE CustomerName LIKE '%a'
ORDER BY CustomerName DESC;
