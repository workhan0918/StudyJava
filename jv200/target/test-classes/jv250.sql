DROP TABLE Sample10; --table 삭제
SHOW DATABASES; --데이터베이스들 확인
use jv250;
SHOW TABLES; --테이블들 확인

CREATE TABLE Sample10 (
	no 			INT(11) 		DEFAULT NULL,
	name		VARCHAR(20) 	DEFAULT NULL,
	birthday	DATE			DEFAULT NULL,
	address		VARCHAR(40)		DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 VALUES(1, '한태우', '1999-09-18', '대구 중구 반월당');
INSERT INTO Sample10 VALUES(2, '이지은', '1993-05-16', '서울 서초구');
INSERT INTO Sample10 VALUES(3, '박재범', '1987-04-25', 'New York City');

CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	CustomerId	VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

SELECT * FROM Customer;
INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('한태우', '990918-1234567', '010-7777-7777', 'java', '0000');
--('이지은', '930516-1234567', '010-6776-4747', 'java2', '0000'),
--('박재범', '870425-1234567', '010-5775-1717', 'java3', '0000'),
INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('이지은', '930516-1234567', '010-6776-4747', 'java2', '0000');

INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('박재범', '870425-1234567', '010-5775-1717', 'java3', '0000');

UPDATE Customer SET ssn='990912-1234567',phone='010-6666-6666' WHERE cid='1001';

DELETE FROM Customer WHERE cid = '1004';