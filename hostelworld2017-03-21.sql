/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : hostelworld

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-03-21 17:36:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bankaccount
-- ----------------------------
DROP TABLE IF EXISTS `bankaccount`;
CREATE TABLE `bankaccount` (
  `bankAccount` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  `password` varchar(6) NOT NULL,
  PRIMARY KEY (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bankaccount
-- ----------------------------
INSERT INTO `bankaccount` VALUES ('6212261234567890001', '9950000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890002', '30000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890003', '40000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890004', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890005', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890006', '130000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890007', '100000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890008', '100000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890009', '100000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890010', '100000', '123456');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `depositno` varchar(40) NOT NULL,
  `bankAccount` varchar(19) NOT NULL,
  `time` datetime NOT NULL,
  `depositAmount` double(20,0) NOT NULL,
  PRIMARY KEY (`depositno`),
  KEY `fk_bankAccount_deposit` (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES ('171000120170310110959', '6212261234567890004', '2017-03-10 11:09:59', '10000');
INSERT INTO `deposit` VALUES ('171000220170310111036', '6212261234567890005', '2017-03-10 11:10:36', '10000');

-- ----------------------------
-- Table structure for hostelplan
-- ----------------------------
DROP TABLE IF EXISTS `hostelplan`;
CREATE TABLE `hostelplan` (
  `hostelplanno` varchar(255) NOT NULL,
  `hostelno` varchar(255) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `roomType` enum('STANDARD','BIG') NOT NULL,
  `price` int(5) NOT NULL,
  `planState` enum('PAST','NOW','FUTURE') NOT NULL,
  PRIMARY KEY (`hostelplanno`),
  KEY `fk_hostelno_hostelplan` (`hostelno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelplan
-- ----------------------------
INSERT INTO `hostelplan` VALUES ('172000120170319123221', '1720001', '2017-03-01', '2018-03-01', 'BIG', '288', 'NOW');
INSERT INTO `hostelplan` VALUES ('172000120170320201114', '1720001', '2018-01-01', '2019-01-01', 'BIG', '288', 'FUTURE');
INSERT INTO `hostelplan` VALUES ('172000220170320112321', '1720002', '2017-03-01', '2018-03-01', 'BIG', '185', 'NOW');
INSERT INTO `hostelplan` VALUES ('172000220170320123221', '1720002', '2017-03-01', '2018-03-01', 'STANDARD', '115', 'NOW');
INSERT INTO `hostelplan` VALUES ('18200042017032113371', '1820004', '2017-03-01', '2018-03-01', 'BIG', '288', 'NOW');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderno` varchar(40) NOT NULL,
  `hostelno` varchar(15) NOT NULL,
  `ordertime` datetime NOT NULL,
  `roomType` enum('BIG','STANDARD') NOT NULL,
  `roomPrice` int(5) NOT NULL,
  `startTime` date NOT NULL,
  `endTime` date NOT NULL,
  `roomNum` int(3) NOT NULL,
  `amount` double NOT NULL,
  `saleRatio` double NOT NULL,
  `saleOff` double NOT NULL,
  `pay` double NOT NULL,
  `memberno` varchar(7) DEFAULT NULL,
  `orderState` enum('RESERVED','CANCEL','CHECKIN','CHECKOUT') NOT NULL,
  `payType` enum('CASH','MEMBERCARD') NOT NULL,
  PRIMARY KEY (`orderno`),
  KEY `fk_memberno_order` (`memberno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('172000120170301132526', '1720001', '2017-03-01 13:25:26', 'BIG', '288', '2017-03-22', '2017-03-23', '2001', '288', '0', '0', '288', '1710001', 'RESERVED', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170303132526', '1720001', '2017-03-03 13:25:26', 'BIG', '288', '2017-03-23', '2017-03-24', '2001', '288', '0', '0', '288', '1710001', 'RESERVED', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170305132526', '1720001', '2017-03-05 13:25:26', 'BIG', '288', '2017-03-24', '2017-03-25', '2001', '288', '0', '0', '288', '1710001', 'RESERVED', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170307132526', '1720001', '2017-03-07 13:25:26', 'BIG', '288', '2017-03-20', '2017-03-21', '2001', '288', '0', '0', '288', '1710001', 'CANCEL', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170309132526', '1720001', '2017-03-09 13:25:26', 'BIG', '288', '2017-03-19', '2017-03-20', '2001', '288', '0', '0', '288', '1710001', 'CHECKOUT', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170310112526', '1720001', '2017-03-10 11:25:26', 'STANDARD', '188', '2017-03-18', '2017-03-19', '1001', '188', '0', '0', '188', '1710001', 'CHECKIN', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170321135154', '1720001', '2017-03-21 13:51:54', 'BIG', '288', '2017-03-21', '2017-03-22', '2001', '288', '0', '0', '288', '1720001', 'CHECKOUT', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170321135528', '1720001', '2017-03-21 13:55:29', 'BIG', '288', '2017-03-21', '2017-03-22', '2002', '288', '0', '0', '288', '1710001', 'CANCEL', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000120170321141051', '1720001', '2017-03-21 14:10:52', 'STANDARD', '188', '2017-03-21', '2017-03-22', '10031002', '376', '0', '0', '376', null, 'CHECKIN', 'CASH');
INSERT INTO `order` VALUES ('172000220170311132526', '1720002', '2017-03-11 13:25:26', 'BIG', '288', '2017-03-20', '2017-03-21', '2001', '288', '0', '0', '288', '1710002', 'CHECKOUT', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000220170314112526', '1720002', '2017-03-14 11:25:26', 'STANDARD', '188', '2017-03-22', '2017-03-23', '1001', '188', '0', '0', '188', '1710002', 'CANCEL', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000220170314122526', '1720002', '2017-03-14 12:25:26', 'STANDARD', '188', '2017-03-22', '2017-03-23', '1001', '188', '0', '0', '188', '1710002', 'CHECKIN', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000220170314132526', '1720002', '2017-03-14 13:25:26', 'STANDARD', '188', '2017-03-23', '2017-03-24', '1001', '188', '0', '0', '188', '1710002', 'CHECKOUT', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000220170320014130', '1720002', '2017-03-20 01:41:31', 'STANDARD', '115', '2017-03-22', '2017-03-23', '1001', '115', '0', '0', '115', '1710002', 'CANCEL', 'MEMBERCARD');
INSERT INTO `order` VALUES ('172000220170320151580', '1720002', '2017-03-20 15:15:09', 'STANDARD', '188', '2017-03-22', '2017-03-23', '10021003', '376', '0', '0', '376', null, 'CHECKIN', 'CASH');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payno` varchar(40) NOT NULL,
  `hostelno` varchar(8) NOT NULL,
  `paytime` datetime(6) NOT NULL,
  `inCome` double NOT NULL,
  `ratio` double NOT NULL,
  `fee` double(255,0) NOT NULL,
  `outcome` double NOT NULL,
  PRIMARY KEY (`payno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('172000120170310111754', '1720001', '2017-03-10 11:17:54.000000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000120170320234834', '1720001', '2017-03-20 23:48:03.555000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000220170310111754', '1720002', '2017-03-10 11:17:54.000000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000220170321005429', '1720002', '2017-03-21 00:54:29.185000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('17200022017032103446', '1720002', '2017-03-21 03:44:06.349000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000320170321004653', '1720003', '2017-03-21 00:46:53.008000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000320170321145449', '1720003', '2017-03-21 14:54:49.570000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('172000420170321003535', '1720004', '2017-03-21 00:35:35.066000', '10000', '0.01', '100', '9900');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `hostelno` varchar(7) NOT NULL,
  `roomno` varchar(4) NOT NULL,
  `roomType` enum('BIG','STANDARD') NOT NULL,
  `roomTimeState` text,
  PRIMARY KEY (`hostelno`,`roomno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1720001', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1720001', '1002', 'STANDARD', '');
INSERT INTO `room` VALUES ('1720001', '1003', 'STANDARD', 'null2017-03-21|');
INSERT INTO `room` VALUES ('1720001', '2001', 'BIG', null);
INSERT INTO `room` VALUES ('1720001', '2002', 'BIG', null);
INSERT INTO `room` VALUES ('1720001', '2003', 'BIG', null);
INSERT INTO `room` VALUES ('1720002', '1001', 'STANDARD', '');
INSERT INTO `room` VALUES ('1720002', '1002', 'STANDARD', '');
INSERT INTO `room` VALUES ('1720002', '1003', 'STANDARD', '');
INSERT INTO `room` VALUES ('1720002', '2001', 'BIG', null);
INSERT INTO `room` VALUES ('1720002', '2002', 'BIG', null);
INSERT INTO `room` VALUES ('1720002', '2003', 'BIG', null);
INSERT INTO `room` VALUES ('1820004', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1820004', '2001', 'BIG', null);
INSERT INTO `room` VALUES ('1820005', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1820005', '2001', 'BIG', null);
INSERT INTO `room` VALUES ('1820006', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1820006', '2001', 'BIG', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userno` varchar(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userType` int(2) NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT '',
  `phoneNum` varchar(11) NOT NULL DEFAULT '',
  `id` varchar(20) NOT NULL DEFAULT '511302567812349876',
  `balance` double(20,0) NOT NULL DEFAULT '0',
  `score` double NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  `bankAccount` varchar(40) NOT NULL,
  `state` enum('INACTIVE','NORMAL','VIP','ARREARAGE','STOP','LOGOFF') NOT NULL DEFAULT 'INACTIVE',
  PRIMARY KEY (`userno`),
  KEY `fk_bankAccount` (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1710001', '123456', '1', '庄会员', '18256781237', '511302123456784321', '10810', '0', '江苏省南京市鼓楼区珠江路104号', '6212261234567890004', 'NORMAL');
INSERT INTO `user` VALUES ('1710002', '123456', '1', '王会员', '18256781234', '511302123456784322', '10000', '500', '江苏省南京市鼓楼区珠江路5号', '6212261234567890005', 'NORMAL');
INSERT INTO `user` VALUES ('1710003', '123456', '1', '庄周', '18260032917', '511302123456784321', '1000', '0', 'Nanjing University Xianlin Campus,Qixia,Nanjing,Jiangsu,China', '6212261234567890009', 'NORMAL');
INSERT INTO `user` VALUES ('1710005', '123456', '1', '到家', '18260032917', '511302123456784321', '0', '0', 'Nanjing University Xianlin Campus,Qixia,Nanjing,Jiangsu,China', '6212261234567890009', 'INACTIVE');
INSERT INTO `user` VALUES ('1720001', '123456', '2', '快乐酒店', '18256781236', '511302123456784324', '490', '0', '江苏省南京市鼓楼区珠江路3号', '6212261234567890003', 'NORMAL');
INSERT INTO `user` VALUES ('1720002', '123456', '2', '东吴酒家', '18256781238', '511302123456784325', '10000', '0', '江苏省南京市鼓楼区珠江路6号', '6212261234567890006', 'NORMAL');
INSERT INTO `user` VALUES ('1720003', '123456', '2', '如家快捷酒店', '18256781239', '511302123456784327', '0', '0', '江苏省南京市鼓楼区珠江路6号', '6212261234567890006', 'NORMAL');
INSERT INTO `user` VALUES ('1730001', '123456', '3', '王经理', '18256781234', '511302123456784326', '10000', '0', '江苏省南京市鼓楼区珠江路1号', '6212261234567890001', 'NORMAL');

-- ----------------------------
-- View structure for hostel_display
-- ----------------------------
DROP VIEW IF EXISTS `hostel_display`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hostel_display` AS select `u`.`name` AS `hostelname`,`u`.`userno` AS `hostelno`,`u`.`address` AS `address`,`hp`.`price` AS `price`,`r`.`roomType` AS `roomType`,`r`.`roomno` AS `roomno`,`r`.`roomTimeState` AS `roomTimeState` from ((`user` `u` join `room` `r`) join `hostelplan` `hp`) where ((`u`.`userno` = `r`.`hostelno`) and (`r`.`hostelno` = `hp`.`hostelno`) and (`hp`.`roomType` = `r`.`roomType`)) ;
SET FOREIGN_KEY_CHECKS=1;
