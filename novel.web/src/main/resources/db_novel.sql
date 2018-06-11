/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-11 16:44:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='操作历史表';

-- ----------------------------
-- Table structure for tbl_novel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_novel`;
CREATE TABLE `tbl_novel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '小说表自增主键',
  `name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '书名',
  `author` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '作者名',
  `url` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '小说的链接',
  `TYPE` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '小说的类别：如武侠修真，都市言情',
  `last_update_chapter` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '最后一章的章节名',
  `last_update_chapter_url` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '最后一章的url',
  `last_update_time` datetime DEFAULT NULL COMMENT '小说最后的更新时间',
  `STATUS` int(5) DEFAULT NULL COMMENT '小说的状态：1 连载 2 完结',
  `first_letter` char(1) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '书名的首字母',
  `platform_id` int(5) DEFAULT NULL COMMENT '小说平台的id',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '这本小说存储到我们数据库的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=333939 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(32) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `last_read_chapter_detail_url` varchar(255) DEFAULT NULL COMMENT '上次阅读章节',
  `last_read_chapter_detail_title` varchar(255) DEFAULT NULL COMMENT '最后阅读章节标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
