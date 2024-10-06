SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `customer_id` int(20) NOT NULL,
  `address_id` int(20) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `amount` decimal(10,2) NOT NULL,
  `order_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=40022;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('10001', '10001', '1000100', 'create', '8958.00', '2020-12-28 17:07:19', null);
INSERT INTO `t_order` VALUES ('10002', '10002', '1000200', 'create', '829.00', '2021-01-01 12:00:00', null);
INSERT INTO `t_order` VALUES ('10003', '10003', '1000300', 'payoff', '165.80', '2021-02-20 13:01:00', null);
INSERT INTO `t_order` VALUES ('10004', '10004', '1000400', 'payoff', '4999.00', '2008-05-01 00:00:00', null);
INSERT INTO `t_order` VALUES ('10005', '10005', '1000500', 'payoff', '4325.00', '2010-04-01 12:00:00', null);
INSERT INTO `t_order` VALUES ('10006', '10006', '1000600', 'create', '11598.00', '2010-10-12 13:20:17', null);
INSERT INTO `t_order` VALUES ('10007', '10007', '1000700', 'create', '14688.00', '2012-04-22 00:00:00', null);
INSERT INTO `t_order` VALUES ('10008', '10008', '1000800', 'create', '12286.00', '2012-05-10 00:00:00', null);
INSERT INTO `t_order` VALUES ('10009', '10009', '1000900', 'payoff', '7799.00', '2012-06-01 00:00:00', null);
INSERT INTO `t_order` VALUES ('10010', '10001', '1000100', 'create', '5000.00', '2019-12-29 00:00:00', null);
INSERT INTO `t_order` VALUES ('10011', '10001', '1000100', 'create', '16600.00', '2019-12-29 00:00:00', null);
INSERT INTO `t_order` VALUES ('10012', '10010', '1001000', 'payoff', '4790.00', '2012-07-12 00:00:00', null);
INSERT INTO `t_order` VALUES ('10013', '10011', '1001100', 'payoff', '3999.00', '2012-08-08 09:30:00', null);
INSERT INTO `t_order` VALUES ('10014', '10012', '1001200', 'payoff', '8288.00', '2012-09-13 10:00:10', null);
INSERT INTO `t_order` VALUES ('10015', '10011', '1001101', 'create', '5598.00', '2012-10-01 13:23:00', null);
INSERT INTO `t_order` VALUES ('10016', '10001', '1000101', 'payoff', '10688.00', '2012-11-21 18:34:01', null);
INSERT INTO `t_order` VALUES ('10017', '10013', '1001300', 'payoff', '2599.00', '2012-12-31 00:00:00', null);
INSERT INTO `t_order` VALUES ('10018', '10014', '1001400', 'payoff', '2599.00', '2013-01-13 00:00:00', null);
INSERT INTO `t_order` VALUES ('10019', '10015', '1001500', 'create', '4999.00', '2013-02-28 23:59:59', null);
INSERT INTO `t_order` VALUES ('10020', '10012', '1001201', 'create', '2380.00', '2014-06-30 20:00:00', null);
INSERT INTO `t_order` VALUES ('10021', '10012', '1001201', 'create', '28.90', '2014-06-30 21:00:00', null);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `order_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=130211;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('100010', '10001', '30003', '2', '4000.00', '8000.00');
INSERT INTO `t_order_item` VALUES ('100011', '10001', '30004', '1', '958.00', '958.00');
INSERT INTO `t_order_item` VALUES ('100020', '10002', '30010', '10', '82.90', '829.00');
INSERT INTO `t_order_item` VALUES ('100030', '10003', '30010', '1', '82.90', '82.90');
INSERT INTO `t_order_item` VALUES ('100031', '10003', '30011', '1', '82.90', '82.90');
INSERT INTO `t_order_item` VALUES ('100040', '10004', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100050', '10005', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100051', '10005', '30008', '1', '1488.00', '1488.00');
INSERT INTO `t_order_item` VALUES ('100052', '10005', '30015', '1', '238.00', '238.00');
INSERT INTO `t_order_item` VALUES ('100060', '10006', '30007', '2', '5799.00', '11598.00');
INSERT INTO `t_order_item` VALUES ('100070', '10007', '30001', '1', '4000.00', '4000.00');
INSERT INTO `t_order_item` VALUES ('100071', '10007', '30003', '1', '10688.00', '10688.00');
INSERT INTO `t_order_item` VALUES ('100080', '10008', '30007', '1', '5799.00', '5799.00');
INSERT INTO `t_order_item` VALUES ('100081', '10008', '30008', '1', '1488.00', '1488.00');
INSERT INTO `t_order_item` VALUES ('100082', '10008', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100090', '10009', '30012', '1', '7799.00', '7799.00');
INSERT INTO `t_order_item` VALUES ('100110', '10011', '30001', '1', '4000.00', '4000.00');
INSERT INTO `t_order_item` VALUES ('100111', '10011', '30002', '1', '12600.00', '12600.00');
INSERT INTO `t_order_item` VALUES ('100120', '10012', '30004', '5', '958.00', '4790.00');
INSERT INTO `t_order_item` VALUES ('100130', '10013', '30014', '1', '3999.00', '3999.00');
INSERT INTO `t_order_item` VALUES ('100140', '10014', '30005', '1', '8288.00', '8288.00');
INSERT INTO `t_order_item` VALUES ('100150', '10015', '30006', '2', '2799.00', '5598.00');
INSERT INTO `t_order_item` VALUES ('100160', '10016', '30003', '1', '10688.00', '10688.00');
INSERT INTO `t_order_item` VALUES ('100170', '10017', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100180', '10018', '30013', '1', '2599.00', '2599.00');
INSERT INTO `t_order_item` VALUES ('100190', '10019', '30009', '1', '4999.00', '4999.00');
INSERT INTO `t_order_item` VALUES ('100200', '10020', '30015', '10', '238.00', '2380.00');
INSERT INTO `t_order_item` VALUES ('100210', '10021', '30011', '1', '28.90', '28.90');

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `method` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=30005;

-- ----------------------------
-- Records of t_payment
-- ----------------------------

-- ----------------------------
-- Table structure for t_product_discount
-- ----------------------------
DROP TABLE IF EXISTS `t_product_discount`;
CREATE TABLE `t_product_discount` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `discount` decimal(5,4) DEFAULT NULL,
  `discount_type` varchar(20) DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_product_discount
-- ----------------------------
INSERT INTO `t_product_discount` VALUES ('30001', '微软平板电脑笔记本打折', '2020-01-01 00:00:00', null, '0.8000', 'productDiscount', '30005');
INSERT INTO `t_product_discount` VALUES ('30002', '华为Mate 30E打折', '2020-01-01 00:00:00', null, '0.8800', 'productDiscount', '30007');

-- ----------------------------
-- Table structure for t_vip_discount
-- ----------------------------
DROP TABLE IF EXISTS `t_vip_discount`;
CREATE TABLE `t_vip_discount` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `discount` decimal(5,4) DEFAULT NULL,
  `discount_type` varchar(20) DEFAULT NULL,
  `vip_level` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_vip_discount
-- ----------------------------
INSERT INTO `t_vip_discount` VALUES ('1001', '金卡会员打折', '2020-01-01 00:00:00', null, '0.7500', 'vipDiscount', 'golden');
INSERT INTO `t_vip_discount` VALUES ('1002', '银卡会员打折', '2020-01-01 00:00:00', null, '0.9000', 'vipDiscount', 'silver');
