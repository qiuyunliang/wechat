CREATE DATABASE IF NOT EXISTS mybatis_parameter;

USE mybatis_cache;

CREATE TABLE employee
(
  ID         BIGINT AUTO_INCREMENT,
  NAME       VARCHAR(100),
  SALARY     BIGINT,
  BIRTHDAY   TIMESTAMP,
  HIREDATE   TIMESTAMP,
  LEVEL      TINYINT,
  DEPARTMENT VARCHAR(100),
  PRIMARY KEY (ID)
);