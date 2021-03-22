CREATE TABLE IF NOT EXISTS StudentHB (
  studentId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL,
  course VARCHAR(100) NOT NULL
);

insert into StudentHB(studentId,empName,course) values(1,"manzer","java");