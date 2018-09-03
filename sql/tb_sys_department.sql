/*
Navicat MySQL Data Transfer

Source Server         : mysql56_3307
Source Server Version : 50636
Source Host           : localhost:3307
Source Database       : j-util

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-08-31 11:29:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_department`;
CREATE TABLE `tb_sys_department` (
  `id` varchar(36) DEFAULT NULL,
  `dep_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_department
-- ----------------------------
