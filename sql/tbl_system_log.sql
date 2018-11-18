/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50722
Source Host           : 118.24.19.83:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-28 12:01:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_system_log`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_system_log`;
CREATE TABLE `tbl_system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `module` varchar(255) NOT NULL COMMENT '模块',
  `method` varchar(255) NOT NULL COMMENT '方法',
  `status_desc` varchar(255) NOT NULL COMMENT '描述',
  `args` varchar(255) DEFAULT NULL COMMENT '参数',
  `user_id` bigint(20) NOT NULL COMMENT '操作人ID',
  `ip` varchar(20) NOT NULL COMMENT 'IP',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8 COMMENT='操作历史表';

-- ----------------------------
-- Records of tbl_system_log
-- ----------------------------
INSERT INTO `tbl_system_log` VALUES ('13', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '2', '0:0:0:0:0:0:0:1', '2018-06-08 15:44:14');
INSERT INTO `tbl_system_log` VALUES ('14', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:明茧; currentPage:1; pageSize:10}', '2', '0:0:0:0:0:0:0:1', '2018-06-08 15:45:10');
INSERT INTO `tbl_system_log` VALUES ('15', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:饶恕; currentPage:1; pageSize:10}', '2', '0:0:0:0:0:0:0:1', '2018-06-08 15:57:57');
INSERT INTO `tbl_system_log` VALUES ('16', 'getNovelByPage', '<font color=\"red\">执行方法异常:-->搜索小说</font>', '<font color=\"red\">执行方法异常:-->java.lang.RuntimeException: java.lang.NullPointerException</font>', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:49:56');
INSERT INTO `tbl_system_log` VALUES ('17', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:08');
INSERT INTO `tbl_system_log` VALUES ('18', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:17');
INSERT INTO `tbl_system_log` VALUES ('19', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992612.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:19');
INSERT INTO `tbl_system_log` VALUES ('20', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2544252.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:21');
INSERT INTO `tbl_system_log` VALUES ('21', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2544249.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:53:23');
INSERT INTO `tbl_system_log` VALUES ('22', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 11:54:41');
INSERT INTO `tbl_system_log` VALUES ('23', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:X; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-11 15:16:45');
INSERT INTO `tbl_system_log` VALUES ('24', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:X; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-12 13:55:13');
INSERT INTO `tbl_system_log` VALUES ('25', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:23');
INSERT INTO `tbl_system_log` VALUES ('26', 'getChapterDetail', '<font color=\"red\">执行方法异常:-->阅读章节详情</font>', '<font color=\"red\">执行方法异常:-->java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException</font>', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:36');
INSERT INTO `tbl_system_log` VALUES ('27', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:31:42');
INSERT INTO `tbl_system_log` VALUES ('28', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:01');
INSERT INTO `tbl_system_log` VALUES ('29', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:03');
INSERT INTO `tbl_system_log` VALUES ('30', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/2542339.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-15 10:32:08');
INSERT INTO `tbl_system_log` VALUES ('31', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:神墓; currentPage:1; pageSize:10}', '-1', '59.56.91.242', '2018-06-21 15:45:46');
INSERT INTO `tbl_system_log` VALUES ('32', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:神墓; currentPage:1; pageSize:10}', '-1', '59.56.91.242', '2018-06-21 15:46:34');
INSERT INTO `tbl_system_log` VALUES ('33', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1485/3322820.html}', '-1', '59.56.91.242', '2018-06-21 15:46:58');
INSERT INTO `tbl_system_log` VALUES ('34', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:棠; currentPage:1; pageSize:10}', '-1', '117.136.75.247', '2018-06-21 15:54:23');
INSERT INTO `tbl_system_log` VALUES ('35', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/134/134011/25401621.html}', '-1', '110.83.16.205', '2018-06-21 15:56:49');
INSERT INTO `tbl_system_log` VALUES ('36', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:啊; currentPage:1; pageSize:10}', '-1', '110.83.16.205', '2018-06-21 15:56:59');
INSERT INTO `tbl_system_log` VALUES ('37', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:啊; currentPage:8; pageSize:10}', '-1', '110.83.16.205', '2018-06-21 15:57:03');
INSERT INTO `tbl_system_log` VALUES ('38', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:大主宰; currentPage:1; pageSize:10}', '-1', '125.78.208.102', '2018-06-21 16:00:30');
INSERT INTO `tbl_system_log` VALUES ('39', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:大主宰; currentPage:1; pageSize:10}', '-1', '59.56.91.242', '2018-06-21 16:00:52');
INSERT INTO `tbl_system_log` VALUES ('40', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/62/62724/index.html}', '-1', '59.56.91.242', '2018-06-21 16:00:58');
INSERT INTO `tbl_system_log` VALUES ('41', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1215/24855135.html}', '-1', '59.56.91.242', '2018-06-21 16:01:03');
INSERT INTO `tbl_system_log` VALUES ('42', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjE1Lw==}', '-1', '59.56.91.242', '2018-06-21 16:01:13');
INSERT INTO `tbl_system_log` VALUES ('43', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:庞龙; currentPage:1; pageSize:10}', '-1', '218.66.71.149', '2018-06-21 16:01:20');
INSERT INTO `tbl_system_log` VALUES ('44', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1215/24855135.html}', '-1', '59.56.91.242', '2018-06-21 16:01:22');
INSERT INTO `tbl_system_log` VALUES ('45', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:庞龙; currentPage:1; pageSize:10}', '-1', '218.66.71.149', '2018-06-21 16:01:24');
INSERT INTO `tbl_system_log` VALUES ('46', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:G小调; currentPage:1; pageSize:10}', '-1', '218.66.71.149', '2018-06-21 16:01:52');
INSERT INTO `tbl_system_log` VALUES ('47', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:G; currentPage:1; pageSize:10}', '-1', '218.66.71.149', '2018-06-21 16:02:00');
INSERT INTO `tbl_system_log` VALUES ('48', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay82Mjg1NC8=}', '-1', '218.66.71.149', '2018-06-21 16:02:05');
INSERT INTO `tbl_system_log` VALUES ('49', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/62854/11665051.html}', '-1', '218.66.71.149', '2018-06-21 16:02:09');
INSERT INTO `tbl_system_log` VALUES ('50', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/62854/11665051.html}', '-1', '59.36.119.226', '2018-06-21 16:02:09');
INSERT INTO `tbl_system_log` VALUES ('51', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay82Mjg1NC8=}', '-1', '61.151.226.65', '2018-06-21 16:03:04');
INSERT INTO `tbl_system_log` VALUES ('52', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/62854/11665051.html}', '-1', '61.151.226.168', '2018-06-21 16:03:09');
INSERT INTO `tbl_system_log` VALUES ('53', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:遮天; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 16:03:26');
INSERT INTO `tbl_system_log` VALUES ('54', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:遮天; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 16:03:28');
INSERT INTO `tbl_system_log` VALUES ('55', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:遮天; currentPage:1; pageSize:10}', '-1', '117.28.206.162', '2018-06-21 16:20:44');
INSERT INTO `tbl_system_log` VALUES ('56', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/134/134011/25401621.html}', '-1', '106.120.160.109', '2018-06-21 16:21:02');
INSERT INTO `tbl_system_log` VALUES ('57', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:我的君王是石头; currentPage:1; pageSize:10}', '-1', '117.28.206.162', '2018-06-21 16:21:17');
INSERT INTO `tbl_system_log` VALUES ('58', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/134/134011/25401621.html}', '-1', '220.181.132.191', '2018-06-21 16:21:30');
INSERT INTO `tbl_system_log` VALUES ('59', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盛开; currentPage:1; pageSize:10}', '-1', '110.83.16.205', '2018-06-21 16:28:33');
INSERT INTO `tbl_system_log` VALUES ('60', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盛开; currentPage:1; pageSize:10}', '-1', '110.83.16.205', '2018-06-21 16:28:36');
INSERT INTO `tbl_system_log` VALUES ('61', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTAxLzEwMTk4Mi8=}', '-1', '110.83.16.205', '2018-06-21 16:28:43');
INSERT INTO `tbl_system_log` VALUES ('62', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒夫人心; currentPage:1; pageSize:10}', '-1', '125.78.208.102', '2018-06-21 17:15:07');
INSERT INTO `tbl_system_log` VALUES ('63', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒夫人心; currentPage:1; pageSize:10}', '-1', '125.78.208.102', '2018-06-21 17:16:06');
INSERT INTO `tbl_system_log` VALUES ('64', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/118/118132/index.html}', '-1', '125.78.208.102', '2018-06-21 17:16:13');
INSERT INTO `tbl_system_log` VALUES ('65', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/118/118132/index.html}', '-1', '101.91.62.109', '2018-06-21 17:16:13');
INSERT INTO `tbl_system_log` VALUES ('66', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒夫人心; currentPage:1; pageSize:10}', '-1', '125.78.208.102', '2018-06-21 17:16:24');
INSERT INTO `tbl_system_log` VALUES ('67', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/79982/14684419.html}', '-1', '125.78.208.102', '2018-06-21 17:16:28');
INSERT INTO `tbl_system_log` VALUES ('68', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/79982/14684419.html}', '-1', '125.78.208.102', '2018-06-21 17:16:30');
INSERT INTO `tbl_system_log` VALUES ('69', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/118/118132/index.html}', '-1', '61.151.226.61', '2018-06-21 17:17:13');
INSERT INTO `tbl_system_log` VALUES ('70', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/79982/14684419.html}', '-1', '101.227.131.139', '2018-06-21 17:17:28');
INSERT INTO `tbl_system_log` VALUES ('71', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒夫人心; currentPage:1; pageSize:10}', '-1', '125.78.208.102', '2018-06-21 17:29:10');
INSERT INTO `tbl_system_log` VALUES ('72', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '27.156.43.165', '2018-06-21 17:29:21');
INSERT INTO `tbl_system_log` VALUES ('73', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '27.156.43.165', '2018-06-21 17:30:13');
INSERT INTO `tbl_system_log` VALUES ('74', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/5/5132/24604826.html}', '-1', '27.156.43.165', '2018-06-21 17:30:18');
INSERT INTO `tbl_system_log` VALUES ('75', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/5/5132/24604828.html}', '-1', '27.156.43.165', '2018-06-21 17:30:22');
INSERT INTO `tbl_system_log` VALUES ('76', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/5/5132/41208475.html}', '-1', '27.156.43.165', '2018-06-21 17:30:24');
INSERT INTO `tbl_system_log` VALUES ('77', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:神木修; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 17:31:33');
INSERT INTO `tbl_system_log` VALUES ('78', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 17:31:44');
INSERT INTO `tbl_system_log` VALUES ('79', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/5/5132/5264126.html}', '-1', '27.156.43.165', '2018-06-21 17:31:49');
INSERT INTO `tbl_system_log` VALUES ('80', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒妇人心; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 17:32:05');
INSERT INTO `tbl_system_log` VALUES ('81', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:最毒妇人心; currentPage:1; pageSize:10}', '-1', '117.136.75.161', '2018-06-21 17:32:06');
INSERT INTO `tbl_system_log` VALUES ('82', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTMzLzEzMzIzNi8=}', '-1', '117.136.75.161', '2018-06-21 17:32:11');
INSERT INTO `tbl_system_log` VALUES ('83', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/133/133236/24043427.html}', '-1', '117.136.75.161', '2018-06-21 17:32:13');
INSERT INTO `tbl_system_log` VALUES ('84', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTMzLzEzMzIzNi8=}', '-1', '117.136.75.161', '2018-06-21 17:32:16');
INSERT INTO `tbl_system_log` VALUES ('85', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/856/164012.html}', '-1', '117.136.75.134', '2018-06-21 18:03:01');
INSERT INTO `tbl_system_log` VALUES ('86', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.IndexOutOfBoundsException: Index: 0, Size: 0', '{url:http://www.kanshuzhong.com/book/856/}', '-1', '117.136.75.134', '2018-06-21 18:03:14');
INSERT INTO `tbl_system_log` VALUES ('87', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=不被支持的url', '{base64Url:}', '-1', '117.136.75.134', '2018-06-21 18:03:19');
INSERT INTO `tbl_system_log` VALUES ('88', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/856/164011.html}', '-1', '117.136.75.134', '2018-06-21 18:03:25');
INSERT INTO `tbl_system_log` VALUES ('89', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=不被支持的url', '{base64Url:}', '-1', '117.136.75.134', '2018-06-21 18:03:31');
INSERT INTO `tbl_system_log` VALUES ('90', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay84NTYv}', '-1', '117.136.75.134', '2018-06-21 18:03:37');
INSERT INTO `tbl_system_log` VALUES ('91', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/101/101334/index.html}', '-1', '117.136.75.134', '2018-06-21 18:11:52');
INSERT INTO `tbl_system_log` VALUES ('92', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTAxLzEwMTMzNC8=}', '-1', '117.136.75.134', '2018-06-21 18:11:55');
INSERT INTO `tbl_system_log` VALUES ('93', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/101/101334/16527179.html}', '-1', '117.136.75.134', '2018-06-21 18:11:57');
INSERT INTO `tbl_system_log` VALUES ('94', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/101/101334/16527179.html}', '-1', '140.243.1.159', '2018-06-22 09:00:02');
INSERT INTO `tbl_system_log` VALUES ('95', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '1', '59.56.45.25', '2018-06-23 13:42:23');
INSERT INTO `tbl_system_log` VALUES ('96', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:恸; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:43:32');
INSERT INTO `tbl_system_log` VALUES ('97', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:恸; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:43:37');
INSERT INTO `tbl_system_log` VALUES ('98', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:日末; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:43:44');
INSERT INTO `tbl_system_log` VALUES ('99', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:东京食尸鬼; currentPage:1; pageSize:10}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:04');
INSERT INTO `tbl_system_log` VALUES ('100', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTE1LzExNTk5OC8=}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:11');
INSERT INTO `tbl_system_log` VALUES ('101', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/115/115998/20583635.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:16');
INSERT INTO `tbl_system_log` VALUES ('102', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTE1LzExNTk5OC8=}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:36');
INSERT INTO `tbl_system_log` VALUES ('103', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:https://www.bxwx9.org/b/115/115998/20200891.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:46:38');
INSERT INTO `tbl_system_log` VALUES ('104', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/115/115998/index.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:47:06');
INSERT INTO `tbl_system_log` VALUES ('105', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/114/114151/index.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:47:10');
INSERT INTO `tbl_system_log` VALUES ('106', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/81424/14477257.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:47:14');
INSERT INTO `tbl_system_log` VALUES ('107', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:http://www.5858xs.com/html/302/302895/51622279.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:47:18');
INSERT INTO `tbl_system_log` VALUES ('108', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/76389/14096171.html}', '-1', '0:0:0:0:0:0:0:1', '2018-06-27 18:49:04');
INSERT INTO `tbl_system_log` VALUES ('109', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:道君; currentPage:1; pageSize:10}', '-1', '117.136.63.183', '2018-06-27 19:12:39');
INSERT INTO `tbl_system_log` VALUES ('110', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/113446/28243556.html}', '-1', '117.136.63.183', '2018-06-27 19:12:51');
INSERT INTO `tbl_system_log` VALUES ('111', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/113446/28243556.html}', '-1', '117.185.117.56', '2018-06-27 19:13:49');
INSERT INTO `tbl_system_log` VALUES ('112', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:斗破; currentPage:1; pageSize:10}', '-1', '171.210.51.8', '2018-06-27 19:20:07');
INSERT INTO `tbl_system_log` VALUES ('113', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:豹; currentPage:1; pageSize:10}', '-1', '59.175.239.251', '2018-06-27 19:25:39');
INSERT INTO `tbl_system_log` VALUES ('114', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/34/34505/index.html}', '-1', '59.175.239.251', '2018-06-27 19:27:48');
INSERT INTO `tbl_system_log` VALUES ('115', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/69/69678/index.html}', '-1', '59.175.239.251', '2018-06-27 19:27:54');
INSERT INTO `tbl_system_log` VALUES ('116', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/23412/11080696.html}', '-1', '59.175.239.251', '2018-06-27 19:27:58');
INSERT INTO `tbl_system_log` VALUES ('117', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:11');
INSERT INTO `tbl_system_log` VALUES ('118', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:13');
INSERT INTO `tbl_system_log` VALUES ('119', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:2; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:22');
INSERT INTO `tbl_system_log` VALUES ('120', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:3; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:24');
INSERT INTO `tbl_system_log` VALUES ('121', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:4; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:26');
INSERT INTO `tbl_system_log` VALUES ('122', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:江南; currentPage:4; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:29');
INSERT INTO `tbl_system_log` VALUES ('123', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:江南; currentPage:5; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:35');
INSERT INTO `tbl_system_log` VALUES ('124', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:江南; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:39');
INSERT INTO `tbl_system_log` VALUES ('125', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族 江南; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:47');
INSERT INTO `tbl_system_log` VALUES ('126', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族 江南; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:48');
INSERT INTO `tbl_system_log` VALUES ('127', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:55');
INSERT INTO `tbl_system_log` VALUES ('128', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:龙族; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-27 19:31:58');
INSERT INTO `tbl_system_log` VALUES ('129', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:唐三; currentPage:1; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:07:15');
INSERT INTO `tbl_system_log` VALUES ('130', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:斗罗大陆; currentPage:1; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:07:26');
INSERT INTO `tbl_system_log` VALUES ('131', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:斗罗大陆; currentPage:1; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:07:26');
INSERT INTO `tbl_system_log` VALUES ('132', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:兰帝魅晨; currentPage:1; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:07:55');
INSERT INTO `tbl_system_log` VALUES ('133', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:兰帝魅晨; currentPage:2; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:08:03');
INSERT INTO `tbl_system_log` VALUES ('134', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:兰帝魅晨; currentPage:3; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:08:04');
INSERT INTO `tbl_system_log` VALUES ('135', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:兰帝魅晨; currentPage:4; pageSize:10}', '-1', '36.23.27.158', '2018-06-27 20:08:05');
INSERT INTO `tbl_system_log` VALUES ('136', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8yMDY4Lw==}', '-1', '36.23.27.158', '2018-06-27 20:08:08');
INSERT INTO `tbl_system_log` VALUES ('137', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8yMDY4Lw==}', '-1', '101.226.86.156', '2018-06-27 20:09:07');
INSERT INTO `tbl_system_log` VALUES ('138', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:尸契; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 20:52:47');
INSERT INTO `tbl_system_log` VALUES ('139', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/109889/23180687.html}', '-1', '211.97.126.31', '2018-06-27 20:52:50');
INSERT INTO `tbl_system_log` VALUES ('140', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/265/265235/52927059.html不被支持的url', '{url:http://www.5858xs.com/html/265/265235/52927059.html}', '-1', '211.97.126.31', '2018-06-27 20:52:56');
INSERT INTO `tbl_system_log` VALUES ('141', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/31/31206/11570844.html不被支持的url', '{url:http://www.tsxsw.com/html/31/31206/11570844.html}', '-1', '211.97.126.31', '2018-06-27 20:52:58');
INSERT INTO `tbl_system_log` VALUES ('142', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/265/265235不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzI2NS8yNjUyMzU=}', '-1', '211.97.126.31', '2018-06-27 20:53:01');
INSERT INTO `tbl_system_log` VALUES ('143', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/265/265235不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzI2NS8yNjUyMzU=}', '-1', '211.97.126.31', '2018-06-27 20:53:10');
INSERT INTO `tbl_system_log` VALUES ('144', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/31/31206/11570844.html不被支持的url', '{url:http://www.tsxsw.com/html/31/31206/11570844.html}', '-1', '211.97.126.31', '2018-06-27 20:53:53');
INSERT INTO `tbl_system_log` VALUES ('145', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/109889/23180687.html}', '-1', '211.97.126.31', '2018-06-27 20:53:59');
INSERT INTO `tbl_system_log` VALUES ('146', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:57:57');
INSERT INTO `tbl_system_log` VALUES ('147', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:2; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:01');
INSERT INTO `tbl_system_log` VALUES ('148', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:3; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:01');
INSERT INTO `tbl_system_log` VALUES ('149', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:4; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:02');
INSERT INTO `tbl_system_log` VALUES ('150', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:5; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:03');
INSERT INTO `tbl_system_log` VALUES ('151', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:12; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:03');
INSERT INTO `tbl_system_log` VALUES ('152', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:05');
INSERT INTO `tbl_system_log` VALUES ('153', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:2; pageSize:10}', '-1', '211.97.126.31', '2018-06-27 23:58:16');
INSERT INTO `tbl_system_log` VALUES ('154', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/280/280275/42842519.html不被支持的url', '{url:http://www.5858xs.com/html/280/280275/42842519.html}', '-1', '211.97.126.31', '2018-06-27 23:58:20');
INSERT INTO `tbl_system_log` VALUES ('155', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-28 00:02:58');
INSERT INTO `tbl_system_log` VALUES ('156', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:12; pageSize:10}', '-1', '211.97.126.31', '2018-06-28 00:02:59');
INSERT INTO `tbl_system_log` VALUES ('157', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-28 00:03:00');
INSERT INTO `tbl_system_log` VALUES ('158', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:恸; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-28 16:09:44');
INSERT INTO `tbl_system_log` VALUES ('159', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/53/53907/21943632.html不被支持的url', '{url:http://www.tsxsw.com/html/53/53907/21943632.html}', '-1', '211.97.126.31', '2018-06-28 16:09:51');
INSERT INTO `tbl_system_log` VALUES ('160', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/28/28583/index.html}', '-1', '211.97.126.31', '2018-06-28 16:09:54');
INSERT INTO `tbl_system_log` VALUES ('161', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/54679/11155975.html}', '-1', '211.97.126.31', '2018-06-28 16:09:57');
INSERT INTO `tbl_system_log` VALUES ('162', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvMTkxLzE5MTQ5NS8=}', '-1', '211.97.126.31', '2018-06-28 19:31:57');
INSERT INTO `tbl_system_log` VALUES ('163', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:遮天; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-28 20:09:07');
INSERT INTO `tbl_system_log` VALUES ('164', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:遮天; currentPage:1; pageSize:10}', '-1', '202.114.113.217', '2018-06-28 20:09:09');
INSERT INTO `tbl_system_log` VALUES ('165', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvMzQyLw==}', '-1', '202.114.113.217', '2018-06-28 20:09:19');
INSERT INTO `tbl_system_log` VALUES ('166', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/342/9541552.html}', '-1', '202.114.113.217', '2018-06-28 20:09:28');
INSERT INTO `tbl_system_log` VALUES ('167', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:斩命龙魔; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-29 15:11:30');
INSERT INTO `tbl_system_log` VALUES ('168', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:计划开始; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-29 15:12:31');
INSERT INTO `tbl_system_log` VALUES ('169', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:计划开始; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-29 15:12:33');
INSERT INTO `tbl_system_log` VALUES ('170', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:计划开始; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-06-29 15:12:34');
INSERT INTO `tbl_system_log` VALUES ('171', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:27');
INSERT INTO `tbl_system_log` VALUES ('172', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.41', '2018-06-29 17:47:27');
INSERT INTO `tbl_system_log` VALUES ('173', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.41', '2018-06-29 17:47:29');
INSERT INTO `tbl_system_log` VALUES ('174', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:29');
INSERT INTO `tbl_system_log` VALUES ('175', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.41', '2018-06-29 17:47:30');
INSERT INTO `tbl_system_log` VALUES ('176', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.41', '2018-06-29 17:47:32');
INSERT INTO `tbl_system_log` VALUES ('177', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:32');
INSERT INTO `tbl_system_log` VALUES ('178', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:33');
INSERT INTO `tbl_system_log` VALUES ('179', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.41', '2018-06-29 17:47:34');
INSERT INTO `tbl_system_log` VALUES ('180', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.41', '2018-06-29 17:47:37');
INSERT INTO `tbl_system_log` VALUES ('181', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.41', '2018-06-29 17:47:38');
INSERT INTO `tbl_system_log` VALUES ('182', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/不被支持的url', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.41', '2018-06-29 17:47:39');
INSERT INTO `tbl_system_log` VALUES ('183', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.41', '2018-06-29 17:47:39');
INSERT INTO `tbl_system_log` VALUES ('184', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/1423618.html不被支持的url', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.41', '2018-06-29 17:47:39');
INSERT INTO `tbl_system_log` VALUES ('185', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/不被支持的url', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.41', '2018-06-29 17:47:40');
INSERT INTO `tbl_system_log` VALUES ('186', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/1423618.html不被支持的url', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.41', '2018-06-29 17:47:40');
INSERT INTO `tbl_system_log` VALUES ('187', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/117/117691不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.41', '2018-06-29 17:47:40');
INSERT INTO `tbl_system_log` VALUES ('188', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/117/117691不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.41', '2018-06-29 17:47:41');
INSERT INTO `tbl_system_log` VALUES ('189', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/117/117691/48721287.html不被支持的url', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.41', '2018-06-29 17:47:41');
INSERT INTO `tbl_system_log` VALUES ('190', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/117/117691/48721287.html不被支持的url', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.41', '2018-06-29 17:47:42');
INSERT INTO `tbl_system_log` VALUES ('191', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:42');
INSERT INTO `tbl_system_log` VALUES ('192', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.41', '2018-06-29 17:47:43');
INSERT INTO `tbl_system_log` VALUES ('193', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.41', '2018-06-29 17:47:43');
INSERT INTO `tbl_system_log` VALUES ('194', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.41', '2018-06-29 17:47:43');
INSERT INTO `tbl_system_log` VALUES ('195', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.41', '2018-06-29 17:47:44');
INSERT INTO `tbl_system_log` VALUES ('196', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.41', '2018-06-29 17:47:45');
INSERT INTO `tbl_system_log` VALUES ('197', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.41', '2018-06-29 17:47:45');
INSERT INTO `tbl_system_log` VALUES ('198', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.41', '2018-06-29 17:47:49');
INSERT INTO `tbl_system_log` VALUES ('199', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '106.120.160.109', '2018-06-29 18:28:11');
INSERT INTO `tbl_system_log` VALUES ('200', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '101.199.112.54', '2018-06-29 20:01:34');
INSERT INTO `tbl_system_log` VALUES ('201', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:40');
INSERT INTO `tbl_system_log` VALUES ('202', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.15', '2018-06-30 15:14:40');
INSERT INTO `tbl_system_log` VALUES ('203', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.15', '2018-06-30 15:14:41');
INSERT INTO `tbl_system_log` VALUES ('204', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:41');
INSERT INTO `tbl_system_log` VALUES ('205', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:42');
INSERT INTO `tbl_system_log` VALUES ('206', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.15', '2018-06-30 15:14:43');
INSERT INTO `tbl_system_log` VALUES ('207', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:47');
INSERT INTO `tbl_system_log` VALUES ('208', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.15', '2018-06-30 15:14:47');
INSERT INTO `tbl_system_log` VALUES ('209', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.15', '2018-06-30 15:14:48');
INSERT INTO `tbl_system_log` VALUES ('210', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.15', '2018-06-30 15:14:49');
INSERT INTO `tbl_system_log` VALUES ('211', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.15', '2018-06-30 15:14:49');
INSERT INTO `tbl_system_log` VALUES ('212', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/不被支持的url', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.15', '2018-06-30 15:14:50');
INSERT INTO `tbl_system_log` VALUES ('213', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/不被支持的url', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.15', '2018-06-30 15:14:50');
INSERT INTO `tbl_system_log` VALUES ('214', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/1423618.html不被支持的url', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.15', '2018-06-30 15:14:51');
INSERT INTO `tbl_system_log` VALUES ('215', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/117/117691不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.15', '2018-06-30 15:14:51');
INSERT INTO `tbl_system_log` VALUES ('216', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.tsxsw.com/html/2/2771/1423618.html不被支持的url', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.15', '2018-06-30 15:14:52');
INSERT INTO `tbl_system_log` VALUES ('217', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=5858xs.com/html/117/117691不被支持的url', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.15', '2018-06-30 15:14:52');
INSERT INTO `tbl_system_log` VALUES ('218', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/117/117691/48721287.html不被支持的url', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.15', '2018-06-30 15:14:52');
INSERT INTO `tbl_system_log` VALUES ('219', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: url=http://www.5858xs.com/html/117/117691/48721287.html不被支持的url', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.15', '2018-06-30 15:14:52');
INSERT INTO `tbl_system_log` VALUES ('220', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:53');
INSERT INTO `tbl_system_log` VALUES ('221', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.15', '2018-06-30 15:14:54');
INSERT INTO `tbl_system_log` VALUES ('222', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.15', '2018-06-30 15:14:54');
INSERT INTO `tbl_system_log` VALUES ('223', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.15', '2018-06-30 15:14:54');
INSERT INTO `tbl_system_log` VALUES ('224', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.15', '2018-06-30 15:14:54');
INSERT INTO `tbl_system_log` VALUES ('225', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.15', '2018-06-30 15:14:55');
INSERT INTO `tbl_system_log` VALUES ('226', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.15', '2018-06-30 15:14:56');
INSERT INTO `tbl_system_log` VALUES ('227', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.15', '2018-06-30 15:14:57');
INSERT INTO `tbl_system_log` VALUES ('228', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.15', '2018-06-30 15:15:17');
INSERT INTO `tbl_system_log` VALUES ('229', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '211.161.245.154', '2018-06-30 18:53:11');
INSERT INTO `tbl_system_log` VALUES ('230', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '61.151.226.62', '2018-06-30 18:54:10');
INSERT INTO `tbl_system_log` VALUES ('231', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '211.161.245.154', '2018-06-30 20:17:08');
INSERT INTO `tbl_system_log` VALUES ('232', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '2', '211.97.126.31', '2018-07-01 16:31:22');
INSERT INTO `tbl_system_log` VALUES ('233', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/840/150730.html}', '2', '211.97.126.31', '2018-07-01 16:31:22');
INSERT INTO `tbl_system_log` VALUES ('234', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/134/134866/index.html}', '2', '211.97.126.31', '2018-07-01 16:31:22');
INSERT INTO `tbl_system_log` VALUES ('235', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '2', '211.97.126.31', '2018-07-01 16:31:22');
INSERT INTO `tbl_system_log` VALUES ('236', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/163/163841/index.html}', '2', '211.97.126.31', '2018-07-01 16:31:22');
INSERT INTO `tbl_system_log` VALUES ('237', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:09');
INSERT INTO `tbl_system_log` VALUES ('238', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.24', '2018-07-01 20:50:09');
INSERT INTO `tbl_system_log` VALUES ('239', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '104.192.74.24', '2018-07-01 20:50:10');
INSERT INTO `tbl_system_log` VALUES ('240', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:11');
INSERT INTO `tbl_system_log` VALUES ('241', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNS81MTMyLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:11');
INSERT INTO `tbl_system_log` VALUES ('242', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.24', '2018-07-01 20:50:12');
INSERT INTO `tbl_system_log` VALUES ('243', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '104.192.74.24', '2018-07-01 20:50:15');
INSERT INTO `tbl_system_log` VALUES ('244', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy5rYW5zaHV6aG9uZy5jb20vYm9vay8xMjQzLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:16');
INSERT INTO `tbl_system_log` VALUES ('245', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.24', '2018-07-01 20:50:16');
INSERT INTO `tbl_system_log` VALUES ('246', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.24', '2018-07-01 20:50:17');
INSERT INTO `tbl_system_log` VALUES ('247', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '104.192.74.24', '2018-07-01 20:50:18');
INSERT INTO `tbl_system_log` VALUES ('248', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.24', '2018-07-01 20:50:19');
INSERT INTO `tbl_system_log` VALUES ('249', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.24', '2018-07-01 20:50:20');
INSERT INTO `tbl_system_log` VALUES ('250', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzAvODA3Lw==}', '-1', '104.192.74.24', '2018-07-01 20:50:21');
INSERT INTO `tbl_system_log` VALUES ('251', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '-1', '104.192.74.24', '2018-07-01 20:50:22');
INSERT INTO `tbl_system_log` VALUES ('252', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.RuntimeException: org.apache.http.client.ClientProtocolException', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.24', '2018-07-01 20:50:23');
INSERT INTO `tbl_system_log` VALUES ('253', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy50c3hzdy5jb20vaHRtbC8yLzI3NzEv}', '-1', '104.192.74.24', '2018-07-01 20:50:23');
INSERT INTO `tbl_system_log` VALUES ('254', 'getChapters', '执行方法异常:查看章节列表', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.RuntimeException: org.apache.http.client.ClientProtocolException', '{base64Url:NTg1OHhzLmNvbS9odG1sLzExNy8xMTc2OTE=}', '-1', '104.192.74.24', '2018-07-01 20:50:24');
INSERT INTO `tbl_system_log` VALUES ('255', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.24', '2018-07-01 20:50:25');
INSERT INTO `tbl_system_log` VALUES ('256', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:26');
INSERT INTO `tbl_system_log` VALUES ('257', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cHM6Ly93d3cuYnh3eDkub3JnL2IvNC80NTEyLw==}', '-1', '104.192.74.24', '2018-07-01 20:50:27');
INSERT INTO `tbl_system_log` VALUES ('258', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.5858xs.com/html/117/117691/48721287.html}', '-1', '104.192.74.24', '2018-07-01 20:50:27');
INSERT INTO `tbl_system_log` VALUES ('259', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.24', '2018-07-01 20:50:27');
INSERT INTO `tbl_system_log` VALUES ('260', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.24', '2018-07-01 20:50:28');
INSERT INTO `tbl_system_log` VALUES ('261', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/4/4512/index.html}', '-1', '104.192.74.24', '2018-07-01 20:50:28');
INSERT INTO `tbl_system_log` VALUES ('262', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.24', '2018-07-01 20:50:29');
INSERT INTO `tbl_system_log` VALUES ('263', 'getChapters', '查看章节列表', '执行成功!', '{base64Url:aHR0cDovL3d3dy4yM3d4LmNjL2R1LzQvNDgxNi8=}', '-1', '104.192.74.24', '2018-07-01 20:50:29');
INSERT INTO `tbl_system_log` VALUES ('264', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '-1', '104.192.74.24', '2018-07-01 20:50:33');
INSERT INTO `tbl_system_log` VALUES ('265', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/4/4816/14864582.html}', '2', '211.97.126.31', '2018-07-01 22:39:36');
INSERT INTO `tbl_system_log` VALUES ('266', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:将头; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-07-02 16:43:41');
INSERT INTO `tbl_system_log` VALUES ('267', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:NB; currentPage:1; pageSize:10}', '-1', '211.97.126.31', '2018-07-02 16:44:16');
INSERT INTO `tbl_system_log` VALUES ('268', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/109889/23180687.html}', '2', '211.97.126.31', '2018-07-02 16:46:32');
INSERT INTO `tbl_system_log` VALUES ('269', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '2', '211.97.126.31', '2018-07-03 19:27:48');
INSERT INTO `tbl_system_log` VALUES ('270', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.tsxsw.com/html/2/2771/1423618.html}', '2', '211.97.126.31', '2018-07-03 19:28:02');
INSERT INTO `tbl_system_log` VALUES ('271', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/5/5132/index.html}', '-1', '211.97.126.31', '2018-07-04 09:46:15');
INSERT INTO `tbl_system_log` VALUES ('272', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/1243/548574.html}', '-1', '211.97.126.31', '2018-07-04 09:46:19');
INSERT INTO `tbl_system_log` VALUES ('273', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.23wx.cc/du/0/807/9992614.html}', '-1', '211.97.126.31', '2018-07-04 09:46:29');
INSERT INTO `tbl_system_log` VALUES ('274', 'getChapterDetail', '执行方法异常:阅读章节详情', '执行方法异常:java.lang.RuntimeException: java.lang.RuntimeException: java.lang.NullPointerException', '{url:https://www.bxwx9.org/b/145/145472/index.html}', '1', '180.172.73.233', '2018-07-10 08:43:21');
INSERT INTO `tbl_system_log` VALUES ('275', 'getChapterDetail', '阅读章节详情', '执行成功!', '{url:http://www.kanshuzhong.com/book/856/164012.html}', '1', '180.172.73.233', '2018-07-10 08:43:28');
INSERT INTO `tbl_system_log` VALUES ('276', 'getNovelByPage', '搜索小说', '执行成功!', '{keyword:盘龙; currentPage:1; pageSize:10}', '-1', '101.93.116.190', '2018-07-16 22:19:09');
