/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50722
Source Host           : 118.24.19.83:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-28 12:01:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'b9d11b3be25f5a1a7dc8ca04cd310b28');
INSERT INTO `tbl_user` VALUES ('2', 'test', '5a2e54ee57e5b7273b9a8fed78c1ebd8');
