select C1.Name as 'Customers' from Customers as C1 
 WHERE C1.ID NOT IN (Select C2.ID FROM Customers C2
inner join Orders O1 ON C2.ID = O1.customerId)
    