/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50142
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50142
File Encoding         : 65001

Date: 2016-12-25 20:34:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `remote_addr` varchar(50) DEFAULT NULL COMMENT 'IP',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operate_type` enum('LOGIN','LOGOUT','CREATE','DELETE','UPDATE') NOT NULL DEFAULT 'LOGIN' COMMENT '动作类型，CREATE,DELETE,UPDATE,LOGIN,LOGOUT',
  `operate_business` varchar(50) DEFAULT NULL COMMENT '业务名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户操作记录表';

-- ----------------------------
-- Records of system_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE `system_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `type` enum('MENU','BUTTON') DEFAULT NULL COMMENT '资源类型',
  `url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限字符串,例如admin:create',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `publish_status` tinyint(1) DEFAULT '1' COMMENT '是否发布',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='资源权限表';

-- ----------------------------
-- Records of system_resource
-- ----------------------------
INSERT INTO `system_resource` VALUES ('1', '0', '系统管理', 'MENU', '/manage/admin/sys', '0', 'admin:list', '系统管理', '1');
INSERT INTO `system_resource` VALUES ('2', '1', '用户管理', 'MENU', '/manage/admin/user/toList', '0', 'user:toList', '用户管理', '1');
INSERT INTO `system_resource` VALUES ('3', '2', '添加用户', 'BUTTON', '/manage/admin/user/add', '0', 'user:add', '添加用户', '1');
INSERT INTO `system_resource` VALUES ('4', '2', '删除用户', 'BUTTON', '/manage/admin/user/delete', '0', 'user:delete', '删除用户', '1');
INSERT INTO `system_resource` VALUES ('5', '2', '编辑用户', 'BUTTON', '/manage/admin/user/edit', '0', 'user:edit', '编辑用户', '1');
INSERT INTO `system_resource` VALUES ('6', '2', '查询用户', 'BUTTON', '/manage/admin/user/ajaxList', '0', 'user:ajaxList', '查询用户', '1');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL,
  `publish_status` tinyint(1) DEFAULT '1' COMMENT '是否发布',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '超级管理员', 'admin', '1', '超级管理员');

-- ----------------------------
-- Table structure for system_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_role_resource`;
CREATE TABLE `system_role_resource` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源中间表';

-- ----------------------------
-- Records of system_role_resource
-- ----------------------------
INSERT INTO `system_role_resource` VALUES ('1', '1');
INSERT INTO `system_role_resource` VALUES ('1', '2');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '登陆账号',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `contact` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `reail_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `sex` int(1) DEFAULT '2' COMMENT '性别，0-女，1-男，2-未知',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `token` varchar(100) DEFAULT NULL COMMENT '加盐',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_num` int(11) DEFAULT '0' COMMENT '登录次数',
  `is_locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  `is_admin` tinyint(1) DEFAULT '0' COMMENT '是否管理员',
  `remote_addr` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `publish_status` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', 'admin', 'f9620b2992d9134421fd292f8834af3b', 'liudw2@163.com', '18520147639', '超级管理员', '2', '1988-10-03', '广东省广州市', '123qwe', null, '2016-12-23 22:33:18', '2016-12-23 22:33:44', '0', '0', '1', '127.0.0.1', '1');

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('1', '1');

-- ----------------------------
-- Procedure structure for formDataList
-- ----------------------------
DROP PROCEDURE IF EXISTS `formDataList`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `formDataList`(tableName varchar(50),dbFields varchar(500),whereSql varchar(1000))
BEGIN
	declare exe_sql varchar(2000);
	SET exe_sql = CONCAT("select ",dbFields," from ",tableName,whereSql);
	set @v_sql=exe_sql;   
	prepare stmt from @v_sql; 
	EXECUTE stmt;     
	deallocate prepare stmt; 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for replaceOrgCode
-- ----------------------------
DROP PROCEDURE IF EXISTS `replaceOrgCode`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `replaceOrgCode`()
BEGIN
DECLARE code_length int DEFAULT 0 ;
DECLARE new_code VARCHAR(500);
DECLARE org_id VARCHAR(500);
DECLARE old_code VARCHAR(500);
DECLARE code_length_index int DEFAULT 1;
DECLARE b int default 0;
DECLARE pro CURSOR for select id,org_code,LENGTH(org_code) from t_s_depart;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET b = 1;
OPEN pro;
FETCH pro into org_id,old_code,code_length;
 while b<>1 do
   set code_length_index=1;
	 set new_code='';
	 while code_length_index<code_length do
     set new_code=CONCAT(new_code,'A',SUBSTR(old_code,code_length_index,2));
     set code_length_index=code_length_index+2;
   end while;
    update t_s_depart set org_code=new_code where id=org_id;
  FETCH pro into org_id,old_code,code_length;
end while;
close pro;
end
;;
DELIMITER ;
