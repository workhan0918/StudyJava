CREATE TABLE Customer(
	cid			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	email		VARCHAR(20)		NOT NULL,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL, -- 123456-1234567
	phone		VARCHAR(13)		NOT NULL, -- 010-1234-5678
	regDate	 	TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

SELECT count(*) FROM Customer;

CREATE TABLE Account(
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT		NOT NULL,
	accountNum		CHAR(11)		NOT NULL, -- 000-00-0000
	accType			CHAR(1)		NOT NULL	DEFAULT 'S',
	balance			DOUBLE		NOT NULL	DEFAULT	0,
	interestRate	DOUBLE		NOT NULL	DEFAULT	0.0,
	overAmount		DOUBLE		NOT NULL	DEFAULT	0.0,
	regDate			TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	Account_customerId_FK
		FOREIGN KEY(customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;

DELETE FROM Account WHERE aid = 3003;

SELECT * FROM Account;

SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, a.regDate, ssn 
				FROM Account AS a INNER JOIN Customer AS c ON a.customerId = c.cid
				WHERE ssn = '940504-1234567';
-- regDate Column이Account, Customer 두 테이블에 다 있기 때문에 어디 Column인지 정해줘야한다 ex) a.regDate

DROP TABLE Account;

DROP TABLE Customer;