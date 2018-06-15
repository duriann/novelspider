/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-15 16:36:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_permission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_permission`;
CREATE TABLE `tbl_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_permission
-- ----------------------------
INSERT INTO `tbl_permission` VALUES ('1', '删除用户');
INSERT INTO `tbl_permission` VALUES ('2', '更新用户');
INSERT INTO `tbl_permission` VALUES ('3', '新增用户');
INSERT INTO `tbl_permission` VALUES ('4', '修改爬虫规则');
INSERT INTO `tbl_permission` VALUES ('5', '新增爬虫规则');
INSERT INTO `tbl_permission` VALUES ('6', '查看日志');
