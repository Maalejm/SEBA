/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : slife

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2013-06-05 00:38:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ad`
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `headline` varchar(250) DEFAULT NULL,
  `image` longblob,
  `description` text,
  `studentid` int(11) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES ('1', '1', 'wa', null, 'sample text sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('2', '1', 'wa', null, 'sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('3', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('4', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('5', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('6', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('7', '1', 'sample text sample text sample text sample text  ', null, 'sample text sample text sample text sample text sample text ', '1', '1');
INSERT INTO `ad` VALUES ('8', '1', 'sample text sample text sample text sample text ', null, 'sample text sample text sample text sample text ', '1', '1');

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `answer` text NOT NULL,
  `rating` int(11) DEFAULT '0',
  `ratingCount` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for `categorie`
-- ----------------------------
DROP TABLE IF EXISTS `categorie`;
CREATE TABLE `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catid` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pubularity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorie
-- ----------------------------

-- ----------------------------
-- Table structure for `categorytype`
-- ----------------------------
DROP TABLE IF EXISTS `categorytype`;
CREATE TABLE `categorytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorytype
-- ----------------------------

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) DEFAULT NULL,
  `question` text,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `rentoffer`
-- ----------------------------
DROP TABLE IF EXISTS `rentoffer`;
CREATE TABLE `rentoffer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headline` varchar(250) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `description` text,
  `pricePerNight` float DEFAULT NULL,
  `image` longblob,
  `startDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `isRented` int(11) DEFAULT NULL,
  `IsRentedBy` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rentoffer
-- ----------------------------

-- ----------------------------
-- Table structure for `saleoffer`
-- ----------------------------
DROP TABLE IF EXISTS `saleoffer`;
CREATE TABLE `saleoffer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headline` varchar(250) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `description` text,
  `price` float DEFAULT NULL,
  `image` longblob,
  `SoldBy` int(11) DEFAULT NULL,
  `isSold` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saleoffer
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `birthDate` varchar(20) DEFAULT NULL,
  `university` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `image` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
