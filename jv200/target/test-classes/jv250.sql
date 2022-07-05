CREATE TABLE Sample10 (
   no         INT(11)      DEFAULT NULL,
   name       VARCHAR(20)  DEFAULT NULL,
   birthday   DATE         DEFAULT NULL,
   address    VARCHAR(40)  DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 VALUES (1, '성호', '1993-04-18', '대구 서구 평리동');
INSERT INTO Sample10 VALUES (2, '관우', '1996-10-25', '대구 중구 반월당');
INSERT INTO Sample10 VALUES (3, '장비', '1998-12-12', '대구 남구 반야월');

UPDATE Sample10 SET name='이성호' WHERE birthday = '1993-04-18';

CREATE TABLE Customer (
   cid         	BIGINT         	PRIMARY KEY AUTO_INCREMENT,
   name      	VARCHAR(20)     NOT NULL,
   ssn         	VARCHAR(14)    	NOT NULL,
   phone      	VARCHAR(14)     NOT NULL,
   customerId   VARCHAR(16)   	NOT NULL,
   passwd      	VARCHAR(60)    	NOT NULL,
   regDate      TIMESTAMP    	NOT NULL   DEFAULT CURRENT_TIMESTAMP
)   AUTO_INCREMENT = 1001;
ALTER TABLE Customer CHANGE customerId userId VARCHAR(16) NOT NULL;

SELECT * FROM Customer;

DELETE FROM Customer WHERE name = '여포';

INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('김치', '930418-1111111', '010-2503-4372', 'java', '1111');

INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('깍두기', '961025-1111111', '010-2503-4372', 'servlet', '1111');

INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('총각김치', '981212-1111111', '010-2503-4372', 'jsp', '1111');

UPDATE Customer SET phone = '010-2222-2222' WHERE cid=1003;

UPDATE Customer SET phone = '010-2503-4372' WHERE cid=1001;

UPDATE Customer SET ssn = "961225-1111111", phone= "010-2222-2222" WHERE cid=1002;

UPDATE Customer SET ssn = "981212-1111111", phone= "010-1111-1111" WHERE cid=1003;

DELETE FROM Customer WHERE cid=1003;   

DROP TABLE Customer;

DROP TABLE Account;

CREATE TABLE Account(
   aid          	BIGINT         PRIMARY KEY AUTO_INCREMENT,
   accountNum     	VARCHAR(11)    NOT NULL,   -- 111-11-1111
   balance        	DOUBLE         NOT NULL   DEFAULT 0.0,
   interestRate   	DOUBLE         NOT NULL   DEFAULT 0.0,
   overdraft      	DOUBLE         NOT NULL   DEFAULT 0.0,
   accountType      CHAR(1)        NOT NULL   DEFAULT 'S',
   customerId     	BIGINT         NOT NULL,
   regDate       	TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;
SELECT * FROM Customer;

INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
VALUES  ('508-12-4728', 10000.0, 0.3, 1000.0, 'S', 1001),
        ('508-12-4721', 20000.0, 0.4, 2000.0, 'C', 1002),
      	('508-12-4722', 30000.0, 0.5, 3000.0, 'S', 1003);
      	
-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid
AND Customer.ssn = '981212-1111111';

SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '981212-1111111';

SELECT a.aid, a.accountNum, a.overdraft, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '981212-1111111';
SELECT accountNum,balance FROM Account WHERE accountNum = '508-12-4728';
UPDATE Account SET balance = balance + 500 WHERE accountNum = '508-12-4728';

CREATE TABLE STUDENT (
   num        BIGINT       PRIMARY KEY AUTO_INCREMENT,
   name       VARCHAR(20)  DEFAULT NULL,
   birthday   DATE         DEFAULT NULL
);

DROP TABLE STUDENT;

INSERT INTO STUDENT (name, birthday) VALUES ('홍길동', '1995-01-05');

SELECT * FROM STUDENT;