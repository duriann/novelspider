/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-21 15:31:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_search_history
-- ----------------------------
DROP TABLE IF EXISTS `tbl_search_history`;
CREATE TABLE `tbl_search_history` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(30) DEFAULT '' COMMENT '搜索关键词',
  `count` int(9) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_search_history
-- ----------------------------
INSERT INTO `tbl_search_history` VALUES ('1', '盘龙', '13', '0:0:0:0:0:0:0:1', '2018-06-21 11:55:41');
INSERT INTO `tbl_search_history` VALUES ('2', '明茧', '1', '0:0:0:0:0:0:0:1', '2018-06-21 13:42:29');
