/*
Navicat MySQL Data Transfer

Source Server         : mysql56_3307
Source Server Version : 50636
Source Host           : localhost:3307
Source Database       : j-util

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-05-25 15:15:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role`;
CREATE TABLE `tb_sys_role` (
  `id` varchar(36) NOT NULL,
  `role_name` varchar(60) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
