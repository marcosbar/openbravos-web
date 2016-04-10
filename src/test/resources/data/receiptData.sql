INSERT INTO `closedcash` VALUES ('248191f5-938b-4109-8b19-ab6008dd5d79','Test',21,'2013-08-26 22:32:59',NULL);

INSERT INTO `receipts` VALUES ('e25582ce-a233-4fa3-812b-92eae39bc848','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:45:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('c4f06470-554e-4599-91d0-612e44c2e4bf','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:46:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');
INSERT INTO `receipts` VALUES ('305d1d30-efa3-4c67-8197-5ffbf03da28a','248191f5-938b-4109-8b19-ab6008dd5d79','2013-08-27 11:47:01','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n</properties>\r\n');


INSERT INTO `payments` VALUES ('7a9316b2-b2c8-46d2-971c-635e7c343476','e25582ce-a233-4fa3-812b-92eae39bc848','cash',2.2,'no ID','OK');
INSERT INTO `payments` VALUES ('06ee7538-8a39-4dec-b0ca-35c52197d4f1','c4f06470-554e-4599-91d0-612e44c2e4bf','magcard',24,'634086698687',NULL);
INSERT INTO `payments` VALUES ('084c157f-f0b0-4820-a963-3e4e8a07ee03','305d1d30-efa3-4c67-8197-5ffbf03da28a','magcard',46,'125176069213',NULL);

INSERT INTO `products` VALUES ('4bcf42d8-e922-4fa5-88d0-2398f4c52f6d','1','101',NULL,'P1',0,0,'f3093aa1-e6d9-4197-a65c-ced2625feb0a','000',NULL,NULL,NULL,NULL,'\0','\0',NULL);
INSERT INTO `products` VALUES ('fa7f0a9b-0664-4af8-937b-8118c39aa210','4','MG113RO',NULL,'P2',0,12,'81f49241-5181-41a0-b268-7ac5927df0b2','000',NULL,NULL,NULL,NULL,'\0','\0',NULL);
INSERT INTO `products` VALUES ('fbd37a7e-dede-45bf-89a3-c7bf2142ee0b','5','MG114PL',NULL,'P3',0,12,'81f49241-5181-41a0-b268-7ac5927df0b2','000',NULL,NULL,NULL,NULL,'\0','\0',NULL);
INSERT INTO `products` VALUES ('6ca5d430-6334-4bca-aefb-1b74f85cdad7','12','CV012CO',NULL,'P4',0,46,'2684f8ae-a780-4cf9-ad9e-76d15b069cc1','000',NULL,NULL,NULL,NULL,'\0','\0',NULL);


INSERT INTO `ticketlines` VALUES ('e25582ce-a233-4fa3-812b-92eae39bc848',0,'4bcf42d8-e922-4fa5-88d0-2398f4c52f6d',NULL,1,2.2,'000','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n<entry key=\"product.com\">false</entry>\r\n<entry key=\"product.taxcategoryid\">000</entry>\r\n<entry key=\"product.categoryid\">f3093aa1-e6d9-4197-a65c-ced2625feb0a</entry>\r\n<entry key=\"product.name\">P1</entry>\r\n</properties>\r\n');
INSERT INTO `ticketlines` VALUES ('c4f06470-554e-4599-91d0-612e44c2e4bf',0,'fa7f0a9b-0664-4af8-937b-8118c39aa210',NULL,1,12,'000','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n<entry key=\"product.com\">false</entry>\r\n<entry key=\"product.taxcategoryid\">000</entry>\r\n<entry key=\"product.categoryid\">81f49241-5181-41a0-b268-7ac5927df0b2</entry>\r\n<entry key=\"product.name\">P2</entry>\r\n</properties>\r\n');
INSERT INTO `ticketlines` VALUES ('c4f06470-554e-4599-91d0-612e44c2e4bf',1,'fbd37a7e-dede-45bf-89a3-c7bf2142ee0b',NULL,1,12,'000','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n<entry key=\"product.com\">false</entry>\r\n<entry key=\"product.taxcategoryid\">000</entry>\r\n<entry key=\"product.categoryid\">81f49241-5181-41a0-b268-7ac5927df0b2</entry>\r\n<entry key=\"product.name\">P3</entry>\r\n</properties>\r\n');
INSERT INTO `ticketlines` VALUES ('305d1d30-efa3-4c67-8197-5ffbf03da28a',0,'6ca5d430-6334-4bca-aefb-1b74f85cdad7',NULL,1,46,'000','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\r\n<properties>\r\n<comment>Openbravo POS</comment>\r\n<entry key=\"product.com\">false</entry>\r\n<entry key=\"product.taxcategoryid\">000</entry>\r\n<entry key=\"product.categoryid\">2684f8ae-a780-4cf9-ad9e-76d15b069cc1</entry>\r\n<entry key=\"product.name\">P4</entry>\r\n</properties>\r\n');


