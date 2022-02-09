# Write your MySQL query statement below
Select score, DENSE_RANK() OVER(
    ORDER BY score desc
)  as 'rank'
fROM Scores
