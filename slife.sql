/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : slife

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2013-06-09 23:45:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ad`
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `headline` varchar(250) DEFAULT NULL,
  `image` longblob,
  `description` text,
  `createDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8435FBB0C36` (`student_id`),
  CONSTRAINT `FK8435FBB0C36` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES ('1', '1', '1', 'wa', null, 'sample text sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('2', '1', '1', 'wa', null, 'sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('3', '1', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('4', '1', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('5', '1', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('6', '1', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('7', '1', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1');
INSERT INTO `ad` VALUES ('8', '1', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1');

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `answer` text NOT NULL,
  `rating` int(11) DEFAULT '0',
  `ratingCount` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK752F2BDE8F77231E` (`question_id`),
  KEY `FK752F2BDE5FBB0C36` (`student_id`),
  CONSTRAINT `FK752F2BDE5FBB0C36` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK752F2BDE8F77231E` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryType_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pubularity` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK6DD211EDDE80BFE` (`categoryType_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', 'Cate One ONE', '0');

-- ----------------------------
-- Table structure for `categorytype`
-- ----------------------------
DROP TABLE IF EXISTS `categorytype`;
CREATE TABLE `categorytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorytype
-- ----------------------------
INSERT INTO `categorytype` VALUES ('1', 'Cat one');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `question` text,
  PRIMARY KEY (`id`),
  KEY `FKBE5CA0065FBB0C36` (`student_id`),
  CONSTRAINT `FKBE5CA0065FBB0C36` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `rentoffer`
-- ----------------------------
DROP TABLE IF EXISTS `rentoffer`;
CREATE TABLE `rentoffer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `headline` varchar(250) DEFAULT NULL,
  `description` text,
  `image` longblob,
  `pricePerNight` float DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `isRented` int(11) DEFAULT NULL,
  `IsRentedBy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFF2B0A83FA266C1E` (`category_id`),
  KEY `FKFF2B0A835FBB0C36` (`student_id`),
  KEY `FKFF2B0A83EB283298` (`IsRentedBy_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rentoffer
-- ----------------------------

-- ----------------------------
-- Table structure for `saleoffer`
-- ----------------------------
DROP TABLE IF EXISTS `saleoffer`;
CREATE TABLE `saleoffer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `headline` varchar(250) DEFAULT NULL,
  `description` text,
  `image` longblob,
  `price` float DEFAULT NULL,
  `isSold` int(11) DEFAULT NULL,
  `SoldBy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK70859E354407EC46` (`SoldBy_id`),
  KEY `FK70859E355FBB0C36` (`student_id`),
  CONSTRAINT `FK70859E355FBB0C36` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK70859E354407EC46` FOREIGN KEY (`SoldBy_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saleoffer
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `birthDate` varchar(20) DEFAULT NULL,
  `university` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `image` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'waleed', 'Shihadeh', '2222', '3', '2222222', '22222', '2222', null);
