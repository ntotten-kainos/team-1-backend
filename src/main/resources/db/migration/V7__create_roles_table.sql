CREATE TABLE `Roles` (
	`roleID` TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `roleName` VARCHAR(64) NOT NULL
);

INSERT INTO `Roles`(`roleName`) VALUES ("HR_EMPLOYEE"), ("MANAGEMENT_EMPLOYEE"), ("SALES_EMPLOYEE"), ("STANDARD_EMPLOYEE");