/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50722
Source Host           : 118.24.19.83:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-28 12:00:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_permission`;
CREATE TABLE `tbl_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role_permission
-- ----------------------------
INSERT INTO `tbl_role_permission` VALUES ('1', '1', '1');
INSERT INTO `tbl_role_permission` VALUES ('2', '1', '2');
INSERT INTO `tbl_role_permission` VALUES ('3', '1', '3');
INSERT INTO `tbl_role_permission` VALUES ('4', '1', '4');
INSERT INTO `tbl_role_permission` VALUES ('5', '1', '5');
INSERT INTO `tbl_role_permission` VALUES ('6', '1', '6');
INSERT INTO `tbl_role_permission` VALUES ('7', '2', '10');
INSERT INTO `tbl_role_permission` VALUES ('8', '2', '7');
