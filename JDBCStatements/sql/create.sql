CREATE OR REPLACE PROCEDURE insertEMPLOYEES(NAME IN VARCHAR2 , ID IN NUMBER)
IS
BEGIN
	INSERT INTO EMPLOYEES VALUES(NAME,ID);
END;
/

CREATE TABLE EMPLOYEES (NAME VARCHAR2(20) , ID NUMBER(5));


SELECT * FROM EMPLOYEES;