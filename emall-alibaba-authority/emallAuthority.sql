SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT 'T',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('998', 'test1', 'Just for test');
INSERT INTO `t_authority` VALUES ('999', 'test', 'Just for test');
INSERT INTO `t_authority` VALUES ('50001', 'admin', 'Administrator');
INSERT INTO `t_authority` VALUES ('50002', 'customer', 'A customer');
INSERT INTO `t_authority` VALUES ('50003', 'staff', 'A staff worked for a supplier');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('998', 'test1', 'A role for test');
INSERT INTO `t_role` VALUES ('999', 'test', 'A role for test');
INSERT INTO `t_role` VALUES ('20001', 'admin', 'The administrator');
INSERT INTO `t_role` VALUES ('20002', 'customer', 'A customer');
INSERT INTO `t_role` VALUES ('20003', 'staff', 'A staff worked for a supplier');

-- ----------------------------
-- Table structure for t_role_granted_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_granted_authority`;
CREATE TABLE `t_role_granted_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `role_id` int(20) NOT NULL,
  `authority_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_granted_authority` (`role_id`,`authority_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_granted_authority
-- ----------------------------
INSERT INTO `t_role_granted_authority` VALUES ('1', 'T', '20001', '50001');
INSERT INTO `t_role_granted_authority` VALUES ('2', 'T', '20001', '50002');
INSERT INTO `t_role_granted_authority` VALUES ('3', 'T', '20001', '50003');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account_expired` int(1) unsigned zerofill DEFAULT NULL,
  `account_locked` int(1) unsigned zerofill DEFAULT NULL,
  `credentials_expired` int(1) unsigned zerofill DEFAULT NULL,
  `disabled` int(1) unsigned zerofill DEFAULT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('998', 'test1', '{noop}1111', '0', '0', '0', '0', 'guest');
INSERT INTO `t_user` VALUES ('999', 'test', '{noop}1111', '0', '0', '0', '0', 'guest');
INSERT INTO `t_user` VALUES ('10001', 'admin', '{noop}1234', '0', '0', '0', '0', 'administrator');
INSERT INTO `t_user` VALUES ('10002', 'guest', '{noop}1234', '0', '0', '0', '0', 'guest');
INSERT INTO `t_user` VALUES ('10003', 'mary', '{noop}1234', '0', '0', '0', '0', 'customer');
INSERT INTO `t_user` VALUES ('10004', 'jack', '{noop}1234', '0', '0', '0', '0', 'customer');
INSERT INTO `t_user` VALUES ('20001', 'patric', '{noop}1111', '0', '0', '0', '0', 'staff');

-- ----------------------------
-- Table structure for t_user_granted_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_granted_authority`;
CREATE TABLE `t_user_granted_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `user_id` int(20) NOT NULL,
  `authority_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_granted_authority` (`user_id`,`authority_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_granted_authority
-- ----------------------------
INSERT INTO `t_user_granted_authority` VALUES ('7', 'T', '10001', '50001');
INSERT INTO `t_user_granted_authority` VALUES ('8', 'T', '10001', '50002');
INSERT INTO `t_user_granted_authority` VALUES ('9', 'T', '10001', '50003');

-- ----------------------------
-- Table structure for t_user_granted_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_granted_role`;
CREATE TABLE `t_user_granted_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `available` char(1) DEFAULT 'T',
  `user_id` int(20) NOT NULL,
  `role_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_granted_role` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user_granted_role
-- ----------------------------
INSERT INTO `t_user_granted_role` VALUES ('1', 'T', '10001', '20001');
INSERT INTO `t_user_granted_role` VALUES ('2', 'T', '10003', '20002');
INSERT INTO `t_user_granted_role` VALUES ('3', 'T', '10004', '20002');
INSERT INTO `t_user_granted_role` VALUES ('4', 'T', '20001', '20003');
