CREATE TABLE `Users` (
	`username` VARCHAR(64) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `roleID` TINYINT NOT NULL,
    PRIMARY KEY(`username`),
    FOREIGN KEY (`roleID`) REFERENCES `Roles`(`roleID`)
);

INSERT INTO `Users`(`username`, `password`, `roleID`)
VALUES 	("nathan_manager", "password", 2), 
		("josh_hr", "josh", 1),
        ("sammy_sales", "sammy", 3),
        ("bob_standard", "bob", 4);
