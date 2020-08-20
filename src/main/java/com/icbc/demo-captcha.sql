/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-23 14:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `captcha`;
CREATE TABLE `captcha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11)  NOT NULL,
  `user_phone_number` varchar(20)  NOT NULL,
  `behavior` int(3)  NOT NULL,
  `captcha_code` varchar(6)  DEFAULT NULL,
  `add_time` datetime NOT NULL,
  `expiration_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `captcha` VALUES ('0', '0','18210443800','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('1', '1','18210443801','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('2', '2','18210443802','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('3', '3','18210443803','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('4', '4','18210443804','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('5', '5','18210443805','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('6', '6','18210443806','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('7', '7','18210443807','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
INSERT INTO `captcha` VALUES ('8', '8','18210443808','1','123456','2020-06-23 14:24:23','2020-06-23 14:34:23');
SET FOREIGN_KEY_CHECKS=1;
