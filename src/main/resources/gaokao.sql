/*
Navicat MySQL Data Transfer

Source Server         : 172.28.5.64_test
Source Server Version : 50621
Source Host           : 172.28.5.64:3333
Source Database       : lmw

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-02-08 15:06:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gaokao
-- ----------------------------
DROP TABLE IF EXISTS `gaokao`;
CREATE TABLE `gaokao` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `zhuanyemingcheng` varchar(255) DEFAULT NULL,
  `gaoxiaomingcheng` varchar(255) DEFAULT NULL,
  `pingjunfen` varchar(255) DEFAULT NULL,
  `zuigaofen` varchar(255) DEFAULT NULL,
  `kaoshengdiqu` varchar(255) DEFAULT NULL,
  `kebie` varchar(255) DEFAULT NULL,
  `nianfen` varchar(255) DEFAULT NULL,
  `pici` varchar(255) DEFAULT NULL,
  `zhuanyeduibi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80926 DEFAULT CHARSET=utf8;
