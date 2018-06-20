/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-15 16:36:13
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=340589 DEFAULT CHARSET=latin1;
