/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50722
Source Host           : 118.24.19.83:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-28 12:00:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_permission`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_permission`;
CREATE TABLE `tbl_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_permission
-- ----------------------------
INSERT INTO `tbl_permission` VALUES ('1', 'delUser', '删除用户');
INSERT INTO `tbl_permission` VALUES ('2', 'updateUser', '更新用户');
INSERT INTO `tbl_permission` VALUES ('3', 'addUser', '添加用户');
INSERT INTO `tbl_permission` VALUES ('4', 'updateSpiderRule', '更新爬虫规则');
INSERT INTO `tbl_permission` VALUES ('5', 'addSpiderRule', '新增爬虫规则');
INSERT INTO `tbl_permission` VALUES ('6', 'getSystemLog', '查看系统日志');
INSERT INTO `tbl_permission` VALUES ('7', 'searchNovel', '搜索小说');
INSERT INTO `tbl_permission` VALUES ('8', 'updateNovel', '更新小说');
INSERT INTO `tbl_permission` VALUES ('9', 'deleteNovel', '删除小说');
INSERT INTO `tbl_permission` VALUES ('10', 'lookHistory', '浏览历史');
