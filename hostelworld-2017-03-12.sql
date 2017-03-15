/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : hostelworld

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-03-12 12:17:02
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
INSERT INTO `bankaccount` VALUES ('6212261234567890001', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890002', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890003', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890004', '10000', '123456');
INSERT INTO `bankaccount` VALUES ('6212261234567890005', '10000', '123456');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `depositno` varchar(7) NOT NULL,
  `bankAccount` varchar(19) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `depositAmount` double(20,0) NOT NULL,
  PRIMARY KEY (`depositno`,`time`),
  KEY `fk_bankAccount_deposit` (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES ('1710001', '6212261234567890004', '2017-03-10 11:09:59', '10000');
INSERT INTO `deposit` VALUES ('1710002', '6212261234567890005', '2017-03-10 11:10:36', '10000');

-- ----------------------------
-- Table structure for hostelplan
-- ----------------------------
DROP TABLE IF EXISTS `hostelplan`;
CREATE TABLE `hostelplan` (
  `hostelplanno` varchar(255) NOT NULL,
  `hostelno` varchar(255) NOT NULL,
  `roomType` enum('STANDARD','BIG') NOT NULL,
  `price` int(5) NOT NULL,
  PRIMARY KEY (`hostelplanno`),
  KEY `fk_hostelno_hostelplan` (`hostelno`),
  CONSTRAINT `fk_hostelno_hostelplan` FOREIGN KEY (`hostelno`) REFERENCES `user` (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelplan
-- ----------------------------
INSERT INTO `hostelplan` VALUES ('17200011', '1720001', 'STANDARD', '188');
INSERT INTO `hostelplan` VALUES ('17200012', '1720002', 'BIG', '288');
INSERT INTO `hostelplan` VALUES ('17200021', '1720002', 'STANDARD', '115');
INSERT INTO `hostelplan` VALUES ('17200022', '1720002', 'BIG', '185');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `hostelno` varchar(7) NOT NULL,
  `ordertime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
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
  PRIMARY KEY (`ordertime`,`hostelno`),
  KEY `fk_hostelno_order` (`hostelno`),
  KEY `fk_memberno_order` (`memberno`),
  CONSTRAINT `fk_hostelno_order` FOREIGN KEY (`hostelno`) REFERENCES `user` (`userno`),
  CONSTRAINT `fk_memberno_order` FOREIGN KEY (`memberno`) REFERENCES `user` (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1720001', '2017-03-10 11:25:26', 'STANDARD', '188', '2017-03-09', '2017-03-10', '1001', '188', '0', '0', '188', '1710001', 'RESERVED', 'MEMBERCARD');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `hostelno` varchar(7) NOT NULL,
  `paytime` datetime(6) NOT NULL,
  `inCome` double NOT NULL,
  `ratio` double NOT NULL,
  `fee` double(255,0) NOT NULL,
  `outcome` double NOT NULL,
  PRIMARY KEY (`hostelno`,`paytime`),
  CONSTRAINT `fk_hostelno_payment` FOREIGN KEY (`hostelno`) REFERENCES `user` (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1720001', '2017-03-10 11:17:54.000000', '10000', '0.01', '100', '9900');
INSERT INTO `payment` VALUES ('1720002', '2017-03-10 11:17:54.000000', '10000', '0.01', '100', '9900');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `hostelno` varchar(7) NOT NULL,
  `roomno` varchar(4) NOT NULL,
  `roomType` enum('BIG','STANDARD') NOT NULL,
  `roomTimeState` text,
  PRIMARY KEY (`hostelno`,`roomno`),
  CONSTRAINT `fk_hostelno_room` FOREIGN KEY (`hostelno`) REFERENCES `user` (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1720001', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1720001', '2001', 'BIG', null);
INSERT INTO `room` VALUES ('1720002', '1001', 'STANDARD', null);
INSERT INTO `room` VALUES ('1720002', '2001', 'BIG', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userno` varchar(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userType` int(2) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phoneNum` varchar(11) NOT NULL,
  `balance` double(20,0) NOT NULL,
  `address` varchar(50) NOT NULL,
  `bankAccount` varchar(19) DEFAULT NULL,
  `state` enum('INACTIVE','NORMAL','VIP','ARREARAGE','STOP','LOGOFF') NOT NULL,
  PRIMARY KEY (`userno`),
  KEY `fk_bankAccount` (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1710001', '123456', '1', '周会员', '18256781237', '10000', '江苏省南京市鼓楼区珠江路4号', '6212261234567890004', 'NORMAL');
INSERT INTO `user` VALUES ('1710002', '123456', '1', '王会员', '18256781234', '10000', '江苏省南京市鼓楼区珠江路5号', '6212261234567890005', 'NORMAL');
INSERT INTO `user` VALUES ('1720001', '123456', '2', '孙商家', '18256781235', '10000', '江苏省南京市鼓楼区珠江路2号', '6212261234567890002', 'NORMAL');
INSERT INTO `user` VALUES ('1720002', '123456', '2', '李商家', '18256781236', '10000', '江苏省南京市鼓楼区珠江路3号', '6212261234567890003', 'NORMAL');
INSERT INTO `user` VALUES ('1730001', '123456', '3', '王经理', '18256781234', '10000', '江苏省南京市鼓楼区珠江路1号', '6212261234567890001', 'NORMAL');
SET FOREIGN_KEY_CHECKS=1;
