/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50722
Source Host           : 118.24.19.83:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-28 12:01:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_search_history`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_search_history`;
CREATE TABLE `tbl_search_history` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(30) DEFAULT '' COMMENT '搜索关键词',
  `count` int(9) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_search_history
-- ----------------------------
INSERT INTO `tbl_search_history` VALUES ('3', '恸', '3', '0:0:0:0:0:0:0:1', '2018-06-27 18:43:32');
INSERT INTO `tbl_search_history` VALUES ('4', '日末', '1', '0:0:0:0:0:0:0:1', '2018-06-27 18:43:44');
INSERT INTO `tbl_search_history` VALUES ('5', '东京食尸鬼', '1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:04');
INSERT INTO `tbl_search_history` VALUES ('6', '道君', '1', '117.136.63.183', '2018-06-27 19:12:39');
INSERT INTO `tbl_search_history` VALUES ('7', '斗破', '1', '171.210.51.8', '2018-06-27 19:20:07');
INSERT INTO `tbl_search_history` VALUES ('8', '豹', '1', '59.175.239.251', '2018-06-27 19:25:39');
INSERT INTO `tbl_search_history` VALUES ('9', '龙族', '7', '202.114.113.217', '2018-06-27 19:31:11');
INSERT INTO `tbl_search_history` VALUES ('10', '江南', '3', '202.114.113.217', '2018-06-27 19:31:29');
INSERT INTO `tbl_search_history` VALUES ('11', '龙族 江南', '2', '202.114.113.217', '2018-06-27 19:31:47');
INSERT INTO `tbl_search_history` VALUES ('12', '唐三', '1', '36.23.27.158', '2018-06-27 20:07:15');
INSERT INTO `tbl_search_history` VALUES ('13', '斗罗大陆', '2', '36.23.27.158', '2018-06-27 20:07:26');
INSERT INTO `tbl_search_history` VALUES ('14', '兰帝魅晨', '4', '36.23.27.158', '2018-06-27 20:07:55');
INSERT INTO `tbl_search_history` VALUES ('15', '尸契', '1', '211.97.126.31', '2018-06-27 20:52:47');
INSERT INTO `tbl_search_history` VALUES ('16', '盘龙', '13', '211.97.126.31', '2018-06-27 23:57:57');
INSERT INTO `tbl_search_history` VALUES ('17', '遮天', '2', '202.114.113.217', '2018-06-28 20:09:07');
INSERT INTO `tbl_search_history` VALUES ('18', '斩命龙魔', '1', '211.97.126.31', '2018-06-29 15:11:30');
INSERT INTO `tbl_search_history` VALUES ('19', '计划开始', '3', '211.97.126.31', '2018-06-29 15:12:31');
INSERT INTO `tbl_search_history` VALUES ('20', '将头', '1', '211.97.126.31', '2018-07-02 16:43:41');
INSERT INTO `tbl_search_history` VALUES ('21', 'NB', '1', '211.97.126.31', '2018-07-02 16:44:16');
