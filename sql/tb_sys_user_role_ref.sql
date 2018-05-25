/*
Navicat MySQL Data Transfer

Source Server         : mysql56_3307
Source Server Version : 50636
Source Host           : localhost:3307
Source Database       : j-util

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-05-25 15:15:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_sys_user_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_role_ref`;
CREATE TABLE `tb_sys_user_role_ref` (
  `id` varchar(36) DEFAULT NULL,
  `role_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
