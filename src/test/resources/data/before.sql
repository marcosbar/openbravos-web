SET foreign_key_checks = 0;

CREATE TABLE `closedcash` (
  `MONEY` varchar(255) NOT NULL,
  `HOST` varchar(255) NOT NULL,
  `HOSTSEQUENCE` int(11) NOT NULL,
  `DATESTART` datetime NOT NULL,
  `DATEEND` datetime DEFAULT NULL,
  PRIMARY KEY (`MONEY`),
  UNIQUE KEY `CLOSEDCASH_INX_SEQ` (`HOST`,`HOSTSEQUENCE`),
  KEY `CLOSEDCASH_INX_1` (`DATESTART`)
);

CREATE TABLE `receipts` (
  `ID` varchar(255) NOT NULL,
  `MONEY` varchar(255) NOT NULL,
  `DATENEW` datetime NOT NULL,
  `ATTRIBUTES` mediumblob,
  PRIMARY KEY (`ID`),
  KEY `RECEIPTS_FK_MONEY` (`MONEY`),
  KEY `RECEIPTS_INX_1` (`DATENEW`),
  CONSTRAINT `RECEIPTS_FK_MONEY` FOREIGN KEY (`MONEY`) REFERENCES `closedcash` (`MONEY`)
);

CREATE TABLE `payments` (
  `ID` varchar(255) NOT NULL,
  `RECEIPT` varchar(255) NOT NULL,
  `PAYMENT` varchar(255) NOT NULL,
  `TOTAL` double NOT NULL,
  `TRANSID` varchar(255) DEFAULT NULL,
  `RETURNMSG` mediumblob,
  PRIMARY KEY (`ID`),
  KEY `PAYMENTS_FK_RECEIPT` (`RECEIPT`),
  KEY `PAYMENTS_INX_1` (`PAYMENT`),
  CONSTRAINT `PAYMENTS_FK_RECEIPT` FOREIGN KEY (`RECEIPT`) REFERENCES `receipts` (`ID`)
);

SET foreign_key_checks = 1;

INSERT INTO `closedcash` VALUES ('248191f5-938b-4109-8b19-ab6008dd5d79','Test',21,'2013-08-26 22:32:59',NULL);

INSERT INTO `receipts` VALUES ('0171227f-bfe4-479f-a6e3-35dab9673d75','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 20:52:15','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('0d9da535-fec8-4dcc-9905-a85454aa234b','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:19:43','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('2d33d790-268b-45f6-a6d5-3c69134b1021','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:13:28','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('3bb07d60-71ef-413b-b711-acd0ee4f6b26','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 18:59:23','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('4e4513dc-105d-455d-9d4c-e63157fdd144','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:21:06','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('4ee55604-c7ee-4eaf-8637-937ca41a5152','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:47:50','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('5b323092-5f54-4829-bd7f-b2fc3568e60c','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 19:35:34','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('678b120c-d9bd-4308-bcf7-6dcf7e1d97ec','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:42:16','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('6c043408-4c9e-42fc-98be-67a18f5d41e9','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:26:04','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('78b755f4-0e11-48b5-976e-7ebd8930fe2c','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:01:47','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('7c045037-efa2-4bd8-b56d-b1ebb65f4e04','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 10:09:54','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('7edc5fc5-0e1c-4453-9a1b-ab76b14115cb','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:39:35','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('8385172b-e587-4929-9574-ea14799dcbe1','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:47:21','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('99d87fa6-ad0a-4b05-b2c3-fb57d9628db9','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:09:06','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('9ae892c2-2739-42b1-881e-ee42d2558548','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 12:17:49','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('a3550884-1cc5-4b18-95a4-e7d88a170238','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:37:44','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('bb89888b-1d25-4a63-aa1e-1dd3f04d3c8d','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 10:43:47','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('bb947142-d548-4ce7-816e-c3ec6fda8069','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 10:08:29','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('c2d4374c-4d23-41f8-bf88-25cd5e9361e7','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 20:24:54','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('dde679fe-c03a-4bc0-ad85-88646dad0b64','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:39:22','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('e25582ce-a233-4fa3-812b-92eae39bc848','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:47:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('c4f06470-554e-4599-91d0-612e44c2e4bf','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:47:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('305d1d30-efa3-4c67-8197-5ffbf03da28a','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:47:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');



INSERT INTO `payments` VALUES ('0c44e3db-618a-4534-9eb3-8581a5174e23','3bb07d60-71ef-413b-b711-acd0ee4f6b26','cash',1.3,'no ID','OK');
INSERT INTO `payments` VALUES ('14f6a591-7f40-4f65-9f44-ba76609eb50b','c2d4374c-4d23-41f8-bf88-25cd5e9361e7','cash',38,'no ID','OK');
INSERT INTO `payments` VALUES ('25be5735-be07-4b7b-9eb4-63c89dbf8352','4ee55604-c7ee-4eaf-8637-937ca41a5152','cash',15.9,'no ID','OK');
INSERT INTO `payments` VALUES ('284982fa-c0bc-43c6-a35f-fe361da56a44','7c045037-efa2-4bd8-b56d-b1ebb65f4e04','cash',7.7,'no ID','OK');
INSERT INTO `payments` VALUES ('286a9070-b683-428e-8870-290962ad02d3','9ae892c2-2739-42b1-881e-ee42d2558548','cash',2.5,'no ID','OK');
INSERT INTO `payments` VALUES ('356db708-93a8-4ca9-a3a5-ff4190df314e','5b323092-5f54-4829-bd7f-b2fc3568e60c','cash',33.9,'no ID','OK');
INSERT INTO `payments` VALUES ('37720209-7bf1-499a-8faf-57d3625f5c2a','0171227f-bfe4-479f-a6e3-35dab9673d75','cash',48,'no ID','OK');
INSERT INTO `payments` VALUES ('3c662fe6-acb7-43ee-a5e2-8c22e0d854ce','99d87fa6-ad0a-4b05-b2c3-fb57d9628db9','cash',2.5,'no ID','OK');
INSERT INTO `payments` VALUES ('57b6d26f-b25d-4361-bc2a-e76bb231d7ed','6c043408-4c9e-42fc-98be-67a18f5d41e9','cash',2.2,'no ID','OK');
INSERT INTO `payments` VALUES ('5a70481a-f1b8-4cc3-9b28-1a1482afeefc','678b120c-d9bd-4308-bcf7-6dcf7e1d97ec','cash',2.5,'no ID','OK');
INSERT INTO `payments` VALUES ('6d79d082-6683-432e-bf62-d179df1307cf','a3550884-1cc5-4b18-95a4-e7d88a170238','cash',2.2,'no ID','OK');
INSERT INTO `payments` VALUES ('7a9316b2-b2c8-46d2-971c-635e7c343476','e25582ce-a233-4fa3-812b-92eae39bc848','cash',2.2,'no ID','OK');
INSERT INTO `payments` VALUES ('a95d3c1a-bf85-4606-8f62-f620d679c313','0d9da535-fec8-4dcc-9905-a85454aa234b','cash',12,'no ID','OK');
INSERT INTO `payments` VALUES ('b311332b-5156-4b27-8185-9f83242605f9','78b755f4-0e11-48b5-976e-7ebd8930fe2c','cash',1,'no ID','OK');
INSERT INTO `payments` VALUES ('ba9e4fa7-1c43-429e-8616-13ed410ba99a','bb89888b-1d25-4a63-aa1e-1dd3f04d3c8d','cash',2.3,'no ID','OK');
INSERT INTO `payments` VALUES ('d12a64c3-012a-460d-9cd6-fc4f6f7fdd69','2d33d790-268b-45f6-a6d5-3c69134b1021','cash',0.5,'no ID','OK');
INSERT INTO `payments` VALUES ('e0bd3dea-e13e-4bfa-8439-d6ff7a3e1864','4e4513dc-105d-455d-9d4c-e63157fdd144','cash',7.6,'no ID','OK');
INSERT INTO `payments` VALUES ('e5ba19c7-4732-4adb-9d32-9129d8131130','7edc5fc5-0e1c-4453-9a1b-ab76b14115cb','cash',2.5,'no ID','OK');
INSERT INTO `payments` VALUES ('e88b111f-0b0d-49a6-a907-e5a9d6b18d72','8385172b-e587-4929-9574-ea14799dcbe1','cash',2.6,'no ID','OK');
INSERT INTO `payments` VALUES ('eff7aa65-aa41-44ad-91a2-317c34e6ce10','dde679fe-c03a-4bc0-ad85-88646dad0b64','cash',2.5,'no ID','OK');
INSERT INTO `payments` VALUES ('fd028c1c-489e-45a3-9c67-51b2ff96b46f','bb947142-d548-4ce7-816e-c3ec6fda8069','cash',2.5,'no ID','OK');

INSERT INTO `payments` VALUES ('06ee7538-8a39-4dec-b0ca-35c52197d4f1','c4f06470-554e-4599-91d0-612e44c2e4bf','magcard',24,'634086698687',NULL);
INSERT INTO `payments` VALUES ('084c157f-f0b0-4820-a963-3e4e8a07ee03','305d1d30-efa3-4c67-8197-5ffbf03da28a','magcard',46,'125176069213',NULL);