# Write your MySQL query statement below
SELECT st.student_id ,
     st.student_name ,
     sbj.subject_name , 
     COUNT(ex.subject_name) AS attended_exams
FROM Students AS st
CROSS JOIN Subjects AS sbj 
LEFT JOIN Examinations AS ex
ON st.student_id = ex.student_id AND sbj.subject_name = ex.subject_name
GROUP BY st.student_id , sbj.subject_name
ORDER BY st.student_id , sbj.subject_name;
