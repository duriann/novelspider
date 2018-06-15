/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-15 16:37:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_system_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_system_log`;
CREATE TABLE `tbl_system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `module` varchar(255) NOT NULL COMMENT '模块',
  `method` varchar(255) NOT NULL COMMENT '方法',
  `status_desc` varchar(255) NOT NULL COMMENT '描述',
  `args` varchar(255) DEFAULT NULL COMMENT '参数',
  `user_id` bigint(20) NOT NULL COMMENT '操作人ID',
  `user_nickname` varchar(20) NOT NULL COMMENT '操作人昵称',
  `ip` varchar(20) NOT NULL COMMENT 'IP',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='操作历史表';

-- ----------------------------
-- Records of tbl_system_log
-- ----------------------------
INSERT INTO `tbl_system_log` VALUES ('13', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '2', 'test', '0:0:0:0:0:0:0:1', '2018-06-08 15:44:14');
INSERT INTO `tbl_system_log` VALUES ('14', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:明茧; currentPage:1; pageSize:10}', '2', 'test', '0:0:0:0:0:0:0:1', '2018-06-08 15:45:10');
INSERT INTO `tbl_system_log` VALUES ('15', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:饶恕; currentPage:1; pageSize:10}', '2', 'test', '0:0:0:0:0:0:0:1', '2018-06-08 15:57:57');
INSERT INTO `tbl_system_log` VALUES ('16', 'getNovelByPage', '<font color=\"red\">执行方法异常:-->搜索小说</font>', '<font color=\"red\">执行方法异常:-->java.lang.RuntimeException: java.lang.NullPointerException</font>', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:49:56');
INSERT INTO `tbl_system_log` VALUES ('17', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:08');
INSERT INTO `tbl_system_log` VALUES ('18', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:17');
INSERT INTO `tbl_system_log` VALUES ('19', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992612.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:19');
INSERT INTO `tbl_system_log` VALUES ('20', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2544252.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:21');
INSERT INTO `tbl_system_log` VALUES ('21', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2544249.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:23');
INSERT INTO `tbl_system_log` VALUES ('22', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 11:54:41');
INSERT INTO `tbl_system_log` VALUES ('23', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:X; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-11 15:16:45');
INSERT INTO `tbl_system_log` VALUES ('24', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:X; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-12 13:55:13');
INSERT INTO `tbl_system_log` VALUES ('25', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:23');
INSERT INTO `tbl_system_log` VALUES ('26', 'getChapterDetail', '<font color=\"red\">执行方法异常:-->阅读章节详情</font>', '<font color=\"red\">执行方法异常:-->java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException</font>', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:36');
INSERT INTO `tbl_system_log` VALUES ('27', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:42');
INSERT INTO `tbl_system_log` VALUES ('28', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:01');
INSERT INTO `tbl_system_log` VALUES ('29', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:03');
INSERT INTO `tbl_system_log` VALUES ('30', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2542339.html}', '-1', 'no user', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:08');
