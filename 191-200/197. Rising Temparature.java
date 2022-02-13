Select w1.id from Weather W1
join Weather W2 on W1.Temperature >
W2.Temperature and DATEDIFF(W1.Recorddate, W2.Recorddate) =1
