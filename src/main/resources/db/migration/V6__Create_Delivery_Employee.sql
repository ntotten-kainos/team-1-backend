CREATE TABLE `DeliveryEmployee` (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(75) NOT NULL,
    BankAcctNum int NOT NULL,
    NINO CHAR(9) NOT NULL,
    Salary decimal(9,2) NOT NULL
);

INSERT INTO `DeliveryEmployee`(
    Name,
    BankAcctNum,
    NINO,
    Salary
    )
    VALUES (
    "Joel barry",
    "12345678",
    "AB123456C",
    "20000.00"
    );