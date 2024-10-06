SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('1000', 'Apple', null);
INSERT INTO `t_brand` VALUES ('1001', 'Microsoft', null);
INSERT INTO `t_brand` VALUES ('1002', 'Kindle', null);
INSERT INTO `t_brand` VALUES ('1003', 'HUAWEI', null);
INSERT INTO `t_brand` VALUES ('1004', 'SIEMENS', null);
INSERT INTO `t_brand` VALUES ('1005', '荣耀', null);
INSERT INTO `t_brand` VALUES ('2000', '异步图书', null);
INSERT INTO `t_brand` VALUES ('2001', '博文视点', null);
INSERT INTO `t_brand` VALUES ('3000', '万利达', null);

-- ----------------------------
-- Table structure for t_inventory
-- ----------------------------
DROP TABLE IF EXISTS `t_inventory`;
CREATE TABLE `t_inventory` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(10) NOT NULL DEFAULT '0',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inventory
-- ----------------------------
INSERT INTO `t_inventory` VALUES ('30001', '9994', '2024-09-29 21:40:00');
INSERT INTO `t_inventory` VALUES ('30002', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30003', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30004', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30005', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30006', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30007', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30008', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30009', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30010', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30011', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30012', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30013', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30014', '10000', '2024-07-13 00:28:10');
INSERT INTO `t_inventory` VALUES ('30015', '10000', '2024-07-13 00:28:10');

-- ----------------------------
-- Table structure for t_inventory_record
-- ----------------------------
DROP TABLE IF EXISTS `t_inventory_record`;
CREATE TABLE `t_inventory_record` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `product_id` int(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `operation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inventory_record
-- ----------------------------
INSERT INTO `t_inventory_record` VALUES ('1', '1', '1000', '2024-07-03 20:22:20', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('2', '1', '500', '2024-07-03 20:23:53', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('3', '1', '1000', '2024-07-03 20:26:40', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('4', '1', '1000', '2024-07-03 20:27:03', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('5', '1', '1000', '2024-07-03 20:28:07', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('6', '1', '1000', '2024-07-03 20:31:05', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('7', '1', '500', '2024-07-03 20:31:22', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('8', '1', '1500', '2024-07-03 20:31:35', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('9', '1', '1000', '2024-07-03 21:49:56', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('10', '1', '2000', '2024-07-03 21:51:27', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('11', '1', '1000', '2024-07-03 21:52:34', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('12', '1', '500', '2024-07-03 21:52:34', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('13', '30001', '9998', '2024-07-15 23:21:46', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('14', '30001', '10000', '2024-07-15 23:27:57', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('15', '30001', '9998', '2024-07-15 23:33:17', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('16', '30001', '9996', '2024-07-15 23:41:11', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('17', '30001', '9998', '2024-07-15 23:41:42', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('18', '30001', '9996', '2024-07-15 23:56:44', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('19', '30001', '9998', '2024-07-16 00:00:08', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('20', '30001', '9996', '2024-07-16 00:06:09', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('21', '30001', '9998', '2024-07-16 00:07:14', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('22', '1', '1000', '2024-07-21 19:21:39', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('23', '1', '500', '2024-07-21 19:22:16', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('24', '30001', '9996', '2024-09-03 00:51:26', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('25', '30001', '9998', '2024-09-03 00:58:11', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('26', '30001', '9996', '2024-09-03 01:05:09', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('27', '30001', '9998', '2024-09-03 01:05:10', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('28', '30001', '9996', '2024-09-03 01:07:30', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('29', '30001', '9998', '2024-09-03 01:07:42', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('30', '30001', '9996', '2024-09-03 01:09:35', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('31', '30001', '9998', '2024-09-03 01:09:35', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('32', '30001', '9996', '2024-09-03 01:09:49', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('33', '30001', '9998', '2024-09-03 01:09:50', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('34', '30001', '9996', '2024-09-10 16:10:01', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('35', '30001', '9998', '2024-09-10 16:10:46', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('36', '30001', '9996', '2024-09-10 16:45:44', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('37', '30001', '9998', '2024-09-10 16:49:07', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('38', '30001', '9996', '2024-09-10 16:58:53', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('39', '30001', '9994', '2024-09-10 17:00:03', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('40', '30001', '9996', '2024-09-10 17:00:05', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('41', '30001', '9994', '2024-09-10 17:03:16', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('42', '30001', '9996', '2024-09-10 17:03:18', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('43', '1', '1000', '2024-09-10 17:16:05', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('44', '1', '500', '2024-09-10 17:16:06', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('45', '30001', '9994', '2024-09-10 17:38:37', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('46', '30001', '9996', '2024-09-10 17:38:38', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('47', '1', '1000', '2024-09-10 17:39:08', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('48', '1', '500', '2024-09-10 17:39:08', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('49', '30001', '9994', '2024-09-10 17:39:11', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('50', '30001', '9996', '2024-09-10 17:39:13', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('51', '1', '1000', '2024-09-10 20:18:44', 'stock in');
INSERT INTO `t_inventory_record` VALUES ('52', '1', '500', '2024-09-10 20:18:44', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('53', '30001', '9994', '2024-09-29 21:31:31', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('54', '30001', '9992', '2024-09-29 21:39:26', 'stock out');
INSERT INTO `t_inventory_record` VALUES ('55', '30001', '9994', '2024-09-29 21:40:00', 'stock in');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(10,2) NOT NULL,
  `supplier_id` int(20) NOT NULL,
  `category_id` int(20) NOT NULL,
  `brand_id` int(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `tip` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('30001', 'Apple iPhone X 256GB 深空灰色 移动联通电信4G手机', null, '4000.00', '20004', '100100', '1000', '/static/img/product1.jpg', '自营', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30002', 'Apple iPad 平板电脑 2018年新款9.7英寸', null, '12600.00', '20004', '100200', '1000', '/static/img/product2.jpg', '优惠', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30003', 'Apple MacBook Pro 13.3英寸笔记本电脑（2017款Core i5处理器/8GB内存/256GB硬盘 MupxT2CH/A）', null, '10688.00', '20004', '100300', '1000', '/static/img/product3.jpg', '特惠', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30004', 'Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色', null, '958.00', '20002', '100500', '1002', '/static/img/product4.jpg', '自营', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30005', '微软（Microsoft）新Surface Pro 二合一平板电脑笔记本 12.3英寸（i5 8G内存 256G存储）', null, '8288.00', '20005', '100300', '1001', '/static/img/product5.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30006', 'Apple Watch Series 3智能手表（GPS款 42毫米 深空灰色铝金属表壳 黑色运动型表带 MQL12CH/A）', null, '2799.00', '20004', '100400', '1000', '/static/img/product6.jpg', '优惠', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30007', '华为 HUAWEI Mate 30E Pro 5G麒麟990E SoC芯片 双4000万徕卡电影影像 8GB+256GB青山黛全网通手机', null, '5799.00', '20003', '100100', '1003', '/static/img/HUAWEI_Mate_30E Pro.jpg', '秒杀', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30008', 'HUAWEI WATCH GT2 华为手表 运动智能手表 两周长续航/蓝牙通话/血氧检测/麒麟芯片 华为gt2 46mm 曜石黑', null, '1488.00', '20003', '100400', '1003', '/static/img/WATCH_GT2.jpg', '秒杀', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30009', '华为平板MatePad Pro【键盘+笔】10.8英寸麒麟990游戏影音娱乐办公学习全面屏平板电脑8G+256G WIFI', null, '4999.00', '20003', '100200', '1003', '/static/img/MatePad_Pro.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30010', '领域驱动设计 软件核心复杂性应对之道 英文版(异步图书出品)', null, '82.90', '20006', '300100', '2000', '/static/img/DDD.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30011', '实现领域驱动设计(博文视点出品) [Implementing Domain-Driven Design]', null, '82.90', '20006', '300100', '2001', '/static/img/Implementing_Domain-Driven_Design.jpg', '自营', 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30012', 'SIEMENS/西门子冰箱双开门家用家电变频风冷无霜保鲜对开门两门618升电冰箱KA61EA66TI 滤膜保鲜', null, '7799.00', '20007', '200100', '1004', '/static/img/siemens01.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30013', 'SIEMENS/西门子冰箱三门家用家电直冷节能多门小冰箱小型三开门232升电冰箱KG23D113EW', null, '2599.00', '20007', '200100', '1004', '/static/img/siemens02.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30014', '荣耀智慧屏X1 65英寸LOK-360 2G+16G 8K解码开关机无广告远场语音4K超清人工智能液晶教育电视全面屏', null, '3999.00', '20003', '200200', '1005', '/static/img/tv.jpg', null, 'on sale', '2024-09-04 22:57:33', null);
INSERT INTO `t_product` VALUES ('30015', '万利达 商用电压力锅8L10L12L升大容量电高压锅大电饭锅特大号饭煲双胆酒店饭店食堂单位 8升单胆5-9人份', null, '238.00', '20008', '200300', '3000', '/static/img/fff.png', '自营', 'on sale', '2024-09-04 22:57:33', null);

-- ----------------------------
-- Table structure for t_product_category
-- ----------------------------
DROP TABLE IF EXISTS `t_product_category`;
CREATE TABLE `t_product_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  `parent_id` int(20) DEFAULT NULL,
  `layer` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=400001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_category
-- ----------------------------
INSERT INTO `t_product_category` VALUES ('1', '分类产品', null, null, '0');
INSERT INTO `t_product_category` VALUES ('100000', '电子产品', null, '0', '1');
INSERT INTO `t_product_category` VALUES ('100100', '智能手机', null, '100000', '2');
INSERT INTO `t_product_category` VALUES ('100200', '平板电脑', null, '100000', '2');
INSERT INTO `t_product_category` VALUES ('100300', '笔记本电脑', null, '100000', '2');
INSERT INTO `t_product_category` VALUES ('100400', '智能手表', null, '100000', '2');
INSERT INTO `t_product_category` VALUES ('100500', '电纸书', null, '100000', '2');
INSERT INTO `t_product_category` VALUES ('200000', '家用电器', null, '0', '1');
INSERT INTO `t_product_category` VALUES ('200100', '冰箱', null, '200000', '2');
INSERT INTO `t_product_category` VALUES ('200200', '电视', null, '200000', '2');
INSERT INTO `t_product_category` VALUES ('200300', '电饭煲', null, '200000', '2');
INSERT INTO `t_product_category` VALUES ('200400', '洗衣机', null, '200000', '2');
INSERT INTO `t_product_category` VALUES ('300000', '图书', null, '0', '1');
INSERT INTO `t_product_category` VALUES ('300100', '技术书籍', null, '300000', '2');
INSERT INTO `t_product_category` VALUES ('400000', '办公用品', null, '0', '1');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gender` enum('male','female','other') DEFAULT NULL,
  `identification` char(18) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `supplier_id` int(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('20001', '老子', 'male', '110114202201214455', '2022-01-21', 'laozi@126.com', '13600002222', '20001', '2024-10-05 13:51:25', null);
INSERT INTO `t_staff` VALUES ('20002', '庄子', 'male', '140110198910123456', '1989-10-12', 'zhuangzi@126.com', '13688881234', '20002', '2024-10-05 13:53:20', null);

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` text,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES ('20001', '国际商用机器公司(IBM)', '010-65129123', 'business@ibm.com', '北京市朝阳区奥运村街道北四环中路27号', null, null);
INSERT INTO `t_supplier` VALUES ('20002', '上海晨光文具股份有限公司(M&G)', '010-67891122', 'business@chenguang.com', '上海市奉贤区金钱公路3469号3号楼', null, null);
INSERT INTO `t_supplier` VALUES ('20003', '华为技术有限公司', '010-61003419', 'business@huawei.com', '广东省深圳市龙岗区坂田华为基地', null, null);
INSERT INTO `t_supplier` VALUES ('20004', '苹果公司(Apple Inc.)', '010-65128989', 'business@apple.com', null, null, null);
INSERT INTO `t_supplier` VALUES ('20005', '微软公司(Microsoft)', '010-65543423', 'business@microsoft.com', '北京市海淀区丹棱街5号', null, null);
INSERT INTO `t_supplier` VALUES ('20006', '文轩图书出版社', null, null, null, null, null);
INSERT INTO `t_supplier` VALUES ('20007', '德国西门子股份公司(SIEMENS AG)', '010-65882923', 'business@siemens.com', null, null, null);
INSERT INTO `t_supplier` VALUES ('20008', '万利达集团有限公司', '010-67236575', null, null, null, null);
