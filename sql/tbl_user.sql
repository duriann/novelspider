/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-15 16:37:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `last_read_chapter_detail_url` varchar(255) DEFAULT NULL COMMENT '上次阅读章节',
  `last_read_chapter_detail_title` varchar(255) DEFAULT NULL COMMENT '最后阅读章节标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'b9d11b3be25f5a1a7dc8ca04cd310b28', null, null);
INSERT INTO `tbl_user` VALUES ('2', 'test', '5a2e54ee57e5b7273b9a8fed78c1ebd8', null, null);
