DROP DATABASE if EXISTS medicine;create DATABASE medicine;use medicine;CREATE TABLE `t_customer` (
`CustomerCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`CustomerName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`CustomerTel` int(20) NULL DEFAULT NULL,
`City` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`CustomerCode`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `t_firm` (
`FirmCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`FirmName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`Link` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`LinkTel` int(20) NULL DEFAULT NULL,
`City` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`FirmCode`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `t_kind` (
`KindCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`KindRemark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
PRIMARY KEY (`KindCode`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `t_medicine` (
`MedicineCode` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`MedicineName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`KindCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`ListPrice` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`Price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`Stock` int(8) NULL DEFAULT NULL,
`FirmCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`FirstDate` datetime NULL DEFAULT NULL,
`UsefullDate` datetime NULL DEFAULT NULL,
PRIMARY KEY (`MedicineCode`) ,
INDEX `fk_t_medicine_t_firm_1` (`FirmCode`),
INDEX `fk_t_medicine_t_kind_1` (`KindCode`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `t_power` (
`id` int(20) NOT NULL,
`power` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `t_sale` (
`SaleNum` int(11) NOT NULL AUTO_INCREMENT,
`UserId` int(11) NOT NULL,
`CustomerCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`SaleDate` datetime NOT NULL,
`Amount` double(64,0) NOT NULL,
PRIMARY KEY (`SaleNum`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `t_sale_comment` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`SaleNum` int(11) NOT NULL,
`MedicineCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`Price` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`Number` int(64) NULL DEFAULT NULL,
`Amount` double(64,0) NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `fk_t_sale_comment_t_sale_1` (`SaleNum`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `t_stock` (
`StockNum` int(11) NOT NULL AUTO_INCREMENT,
`UserId` int(11) NOT NULL,
`WorkType` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`WorkDate` datetime NOT NULL,
PRIMARY KEY (`StockNum`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `t_stock_comment` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`StockNum` int(11) NOT NULL,
`MedicineCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`WorkNum` int(11) NULL DEFAULT NULL,
`Number` int(11) NULL DEFAULT NULL,
`Amount` double(64,0) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `t_user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`powerId` int(4) NOT NULL,
`position` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `fk_t_user_t_power_1` (`powerId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;


ALTER TABLE `t_medicine` ADD CONSTRAINT `fk_t_medicine_t_firm_1` FOREIGN KEY (`FirmCode`) REFERENCES `t_firm` (`FirmCode`);
ALTER TABLE `t_medicine` ADD CONSTRAINT `fk_t_medicine_t_kind_1` FOREIGN KEY (`KindCode`) REFERENCES `t_kind` (`KindCode`);
ALTER TABLE `t_sale_comment` ADD CONSTRAINT `fk_t_sale_comment_t_sale_1` FOREIGN KEY (`SaleNum`) REFERENCES `t_sale` (`SaleNum`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_power_1` FOREIGN KEY (`powerId`) REFERENCES `t_power` (`id`);
ALTER TABLE `t_sale` ADD CONSTRAINT `fk_t_sale_t_user_1` FOREIGN KEY (`UserId`) REFERENCES `t_user` (`id`);
ALTER TABLE `t_stock_comment` ADD CONSTRAINT `fk_t_stock_comment_t_stock_1` FOREIGN KEY (`StockNum`) REFERENCES `t_stock` (`StockNum`);
ALTER TABLE `t_stock` ADD CONSTRAINT `fk_t_stock_t_user_1` FOREIGN KEY (`UserId`) REFERENCES `t_user` (`id`);
ALTER TABLE `t_stock_comment` ADD CONSTRAINT `fk_t_stock_comment_t_medicine_1` FOREIGN KEY (`MedicineCode`) REFERENCES `t_medicine` (`MedicineCode`);
ALTER TABLE `t_sale` ADD CONSTRAINT `fk_t_sale_t_customer_1` FOREIGN KEY (`CustomerCode`) REFERENCES `t_customer` (`CustomerCode`);
ALTER TABLE `t_sale_comment` ADD CONSTRAINT `fk_t_sale_comment_t_medicine_1` FOREIGN KEY (`MedicineCode`) REFERENCES `t_medicine` (`MedicineCode`);

