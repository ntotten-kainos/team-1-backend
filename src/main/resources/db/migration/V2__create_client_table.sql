CREATE TABLE `Client` (
    clientID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    clientName VARCHAR(64) NOT NULL UNIQUE
);

INSERT INTO `Client`(`clientName`) VALUES ("Top Client"), ("Other Client");