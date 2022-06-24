CREATE TABLE Customer1 (
	cid      		BIGINT         	PRIMARY KEY AUTO_INCREMENT,
	name 			VARCHAR(10)		NOT NULL,
	ssn				CHAR(14)		NOT NULL,
	regDate			DATE			NOT NULL
)AUTO_INCREMENT = 1001;

CREATE TABLE Account1 (
  	aid          	BIGINT      PRIMARY KEY AUTO_INCREMENT,
	accType 		CHAR(1) 	NOT NULL DEFAULT 'S',
	balance			DOUBLE		NOT NULL DEFAULT 0.0,
	interestRate 	DOUBLE 		NOT NULL DEFAULT 0.0,
	overdraftAmount DOUBLE 		NOT NULL DEFAULT 0.0,
	customerId 		BIGINT		NOT NULL,
	regDate 		TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP, CONSTRAINT Account1_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer1(cid)
)AUTO_INCREMENT = 2001;

DROP TABLE Customer1;
DROP TABLE Account1;

INSERT INTO Customer1 (name, ssn) VALUES('James Bond', '900101-1234567');

INSERT INTO	Account1 (accType, balance, interestRate, overdraftAmount, customerId) VALUES('C', 2000.0, 0.03, 0.0, 1001);

UPDATE Account1 SET name = 'Jason Bourne' WHERE cid = 1002;

DELETE FROM Account1 WHERE cid = 1002;

SELECT accType,balance FROM Account1 WHERE aid = 3001;