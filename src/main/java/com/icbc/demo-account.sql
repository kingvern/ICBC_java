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
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_card` varchar(18) NOT NULL,
  `username` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `family_address` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `login_password` varchar(255) NOT NULL,
  `job` int(3) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '440102198001021230','张三-0','张小三-0','北京市海淀区颐和园路0号','18210443800', '1ee04e0b1cb5af7367c80c22e42efd8b', '0', '0', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('1', '440102198001021231','张三-1','张小三-1','北京市海淀区颐和园路1号','18210443801', '1ee04e0b1cb5af7367c80c22e42efd8b', '1', '1', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('2', '440102198001021232','张三-2','张小三-2','北京市海淀区颐和园路2号','18210443802', '1ee04e0b1cb5af7367c80c22e42efd8b', '2', '0', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('3', '440102198001021233','张三-3','张小三-3','北京市海淀区颐和园路3号','18210443803', '1ee04e0b1cb5af7367c80c22e42efd8b', '3', '1', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('4', '440102198001021234','张三-4','张小三-4','北京市海淀区颐和园路4号','18210443804', '1ee04e0b1cb5af7367c80c22e42efd8b', '4', '0', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('5', '440102198001021235','张三-5','张小三-5','北京市海淀区颐和园路5号','18210443805', '1ee04e0b1cb5af7367c80c22e42efd8b', '5', '1', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('6', '440102198001021236','张三-6','张小三-6','北京市海淀区颐和园路6号','18210443806', '1ee04e0b1cb5af7367c80c22e42efd8b', '6', '0', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('7', '440102198001021237','张三-7','张小三-7','北京市海淀区颐和园路7号','18210443807', '1ee04e0b1cb5af7367c80c22e42efd8b', '7', '1', '2020-06-23 14:24:23');
INSERT INTO `user` VALUES ('8', '440102198001021238','张三-8','张小三-8','北京市海淀区颐和园路8号','18210443808', '1ee04e0b1cb5af7367c80c22e42efd8b', '8', '0', '2020-06-23 14:24:23');
SET FOREIGN_KEY_CHECKS=1;
