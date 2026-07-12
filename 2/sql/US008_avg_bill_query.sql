-- US008: Calculate average bill per city
-- Arrange in descending order of average bill
-- Also identifies the city with highest consumption

SELECT City,
       ROUND(AVG(BillAmount), 2) AS AverageBill
FROM CustomerBill
GROUP BY City
ORDER BY AverageBill DESC;
