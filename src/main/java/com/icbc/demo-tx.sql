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
DROP TABLE IF EXISTS `tx`;
CREATE TABLE `tx` (
  `tx_id` int(11) NOT NULL,
  `flow_in_card` varchar(19)  DEFAULT NULL,
  `flow_out_card` varchar(19)  DEFAULT NULL,
  `tx_amount` double(16,2) NOT NULL,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`tx_id`),
  FOREIGN KEY (`flow_in_card`) REFERENCES `card`(`card_id`),
  FOREIGN KEY (`flow_out_card`) REFERENCES `card`(`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `tx` VALUES ('0', '9559480089071474420','9559480089071474410','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('1', '9559480089071474421','9559480089071474411','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('2', '9559480089071474422','9559480089071474412','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('3', '9559480089071474423','9559480089071474413','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('4', '9559480089071474424','9559480089071474414','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('5', '9559480089071474425','9559480089071474415','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('6', '9559480089071474426','9559480089071474416','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('7', '9559480089071474427','9559480089071474417','100.00','2020-06-23 14:24:23');
INSERT INTO `tx` VALUES ('8', '9559480089071474428','9559480089071474418','100.00','2020-06-23 14:24:23');
SET FOREIGN_KEY_CHECKS=1;
