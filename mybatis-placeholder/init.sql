CREATE DATABASE IF NOT EXISTS mybatis_placeholder;

USE mybatis_placeholder;

CREATE TABLE employee
(
  EMPLOYEE_ID BIGINT AUTO_INCREMENT,
  NAME        VARCHAR(100),
  SALARY      BIGINT,
  BIRTHDAY    TIMESTAMP,
  HIREDATE    TIMESTAMP,
  LEVEL       TINYINT,
  DEPARTMENT  VARCHAR(100),
  PRIMARY KEY (EMPLOYEE_ID)
);