
SELECT request_at AS 'Day', 
Round(Sum(If(status!='completed',1,0))/Count(request_at),2)  AS 'Cancellation Rate' from trips
where request_at between '2013-10-01' and '2013-10-03'
and client_id not in(Select users_id from Users where banned='Yes')
and driver_id not in(select users_id from Users where banned='Yes')
group by request_at
