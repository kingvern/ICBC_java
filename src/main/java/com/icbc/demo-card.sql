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
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` varchar(19) NOT NULL,
  `branch_of_opening_bank` varchar(255) DEFAULT NULL,
  `user_id` int(11)  DEFAULT NULL,
  `payment_password` varchar(6) NOT NULL,
  `master_card_id` varchar(19)  DEFAULT NULL,
  `balance` double(16,2) NOT NULL,
  `level` int(1) NOT NULL,
  `alive` int(1) NOT NULL,
  `register_date` datetime NOT NULL,
  `cancelation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`master_card_id`) REFERENCES `card`(`card_id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` varchar(19) NOT NULL,
  `branch_of_opening_bank` varchar(255) DEFAULT NULL,
  `user_id` int(11)  DEFAULT NULL,
  `payment_password` varchar(6) NOT NULL,
  `master_card_id` int(11)  DEFAULT NULL,
  `balance` double(16,2) NOT NULL,
  `level` int(1) NOT NULL,
  `alive` int(1) NOT NULL,
  `register_date` datetime NOT NULL,
  `cancelation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`master_card_id`) REFERENCES `card`(`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `card` VALUES ('10', '9559480089071474410', '中国工商银行(北京分行)','0','000000','','1000.00','1','1','2020-06-23 14:24:23',null);
INSERT INTO `card` VALUES ('11', '9559480089071474411', '中国工商银行(北京分行)','1','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('12', '9559480089071474412', '中国工商银行(北京分行)','2','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('13', '9559480089071474413', '中国工商银行(北京分行)','3','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('14', '9559480089071474414', '中国工商银行(北京分行)','4','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('15', '9559480089071474415', '中国工商银行(北京分行)','5','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('16', '9559480089071474416', '中国工商银行(北京分行)','6','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('17', '9559480089071474417', '中国工商银行(北京分行)','7','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('18', '9559480089071474418', '中国工商银行(北京分行)','8','000000','','1000.00','1','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('25', '9559480089071474425', '中国工商银行(北京分行)','5','000000','9559480089071474415','1000.00','2','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('26', '9559480089071474426', '中国工商银行(北京分行)','6','000000','9559480089071474416','1000.00','2','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('27', '9559480089071474427', '中国工商银行(北京分行)','7','000000','9559480089071474417','1000.00','2','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
INSERT INTO `card` VALUES ('28', '9559480089071474428', '中国工商银行(北京分行)','8','000000','9559480089071474418','1000.00','2','1','2020-06-23 14:24:23','0001-01-01 00:00:00');
SET FOREIGN_KEY_CHECKS=1;
