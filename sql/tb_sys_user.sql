/*
Navicat MySQL Data Transfer

Source Server         : mysql56_3307
Source Server Version : 50636
Source Host           : localhost:3307
Source Database       : j-util

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-08-31 11:29:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `user_id` varchar(50) NOT NULL COMMENT '用户账号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `passwork` varchar(100) DEFAULT NULL,
  `user_sex` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 0-禁用，1-正常',
  `dep_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_user
-- ----------------------------
INSERT INTO `tb_sys_user` VALUES ('admin', '系统管理员', null, '0', '2018-05-24 11:09:28', '0', null);
INSERT INTO `tb_sys_user` VALUES ('test', '测试人员', null, '2', '2018-05-24 11:09:45', '0', null);
INSERT INTO `tb_sys_user` VALUES ('wuweimian', '吾未眠', '', '1', '2018-05-03 11:09:11', '1', null);
