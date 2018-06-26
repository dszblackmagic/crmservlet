/*
Navicat MySQL Data Transfer

Source Server         : DSZ
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-26 13:10:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `associ`
-- ----------------------------
DROP TABLE IF EXISTS `associ`;
CREATE TABLE `associ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` varchar(255) DEFAULT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `associTime` varchar(255) DEFAULT NULL,
  `associPlace` varchar(255) DEFAULT NULL,
  `associOutline` varchar(255) DEFAULT NULL,
  `associDetails` varchar(255) DEFAULT NULL,
  `associRemarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of associ
-- ----------------------------
INSERT INTO `associ` VALUES ('6', '203613884336872536697', '蒋氏集团', '2018-04-01', '蒋氏集团', '签订意向协议', '', '');
INSERT INTO `associ` VALUES ('7', '203613884336872536697', '蒋氏集团', '2018-04-02', 'GB宾馆', '签订意向协议', '', '');
INSERT INTO `associ` VALUES ('8', '203613884336872536697', '蒋氏集团', '2018-04-03', 'BL俱乐部', '签订意向协议', '', '');
INSERT INTO `associ` VALUES ('9', '4452786774639041626958', '蒋氏集团', '2018-04-17', 'BL俱乐部', '签订意向协议', '', '');
INSERT INTO `associ` VALUES ('10', '48244798845089734220751', '蒋氏集团', '2018-04-29', 'BL酒店', '签订意向协议书', '', '');

-- ----------------------------
-- Table structure for `contacts`
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` varchar(255) DEFAULT NULL,
  `contactsName` varchar(255) DEFAULT NULL,
  `contactsSex` varchar(255) DEFAULT NULL,
  `contactsPosition` varchar(255) DEFAULT NULL,
  `officePhone` varchar(255) DEFAULT NULL,
  `contactsPhone` varchar(255) DEFAULT NULL,
  `contactsRemarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('5', '203613884336872536697', '蒋毅展', '男', '混子', '15250250250 ', '15250250250 ', '');
INSERT INTO `contacts` VALUES ('6', '203613884336872536697', '蒋玉菡', '男', '总裁', '15250250250', '15250250250', '');
INSERT INTO `contacts` VALUES ('7', '203613884336872536697', '郭鑫', '男', '蒋氏集团投资人', '15250205250', '15250250250', '');
INSERT INTO `contacts` VALUES ('8', '203613884336872536697', '刘宇翔', '男', '销售部经理', '15250250250', '15250250250', '');
INSERT INTO `contacts` VALUES ('9', '48244798845089734220751', '刘宇翔', '男', '销售部经理', '15250250250 ', '15250250250 ', '');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` varchar(255) NOT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `customerArea` varchar(255) DEFAULT NULL,
  `customerManager` varchar(255) DEFAULT NULL,
  `customerLevel` varchar(255) DEFAULT NULL,
  `customerSat` varchar(255) DEFAULT NULL,
  `customerCredit` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `customerFax` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `registerNum` varchar(255) DEFAULT NULL,
  `legalPerson` varchar(255) DEFAULT NULL,
  `registerCapital` varchar(255) DEFAULT NULL,
  `turnover` varchar(255) DEFAULT NULL,
  `openBank` varchar(255) DEFAULT NULL,
  `bankNum` varchar(255) DEFAULT NULL,
  `localTax` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `countryTax` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('19457717010427658453779978', 'DDD', null, null, null, null, null, null, null, 'DD', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('203613884336872536697', '蒋氏集团', '北京', 'jingli', '大客户', '5', '5', '江陵', '000000', '15011011010', '15011011010', 'www.baidu.com', '', '蒋玉菡', '', '', '建设银行', '21492105739025324', '', null, '');
INSERT INTO `customer` VALUES ('4452786774639041626958', '蒋氏集团', '北京', 'khjl', '战略合作伙伴', '5', '5', '洛阳', '000000', '15250250250', '15250250250', 'www.baidu.com', '', '蒋玉菡', '', '', '建设银行', '124123142142123', '', null, '');
INSERT INTO `customer` VALUES ('48244798845089734220751', '蒋氏集团', '北京', 'jingli', '重点开发客户', '5', '5', '洛阳', '000000', '15011912010', '15011912010', 'www.baidu.com', '', '蒋玉菡', '', '', '建设银行', '124214215234234142', '', null, '');
INSERT INTO `customer` VALUES ('5661580358485080378111567', '蒋氏集团', '北京', 'jingli', '重点开发客户', '5', '5', '洛阳', '000000', '15011011412', '15011912010', 'www.baidu.com', '', '蒋玉菡', '', '', '建设银行', '1231432214324123', '', null, '');
INSERT INTO `customer` VALUES ('6080885466588317036243072', '蒋氏集团', '北京', 'jingli', '重点开发客户', '5', '5', '洛阳', '000000', '15011411012', '15011912010', 'www,baidu.com', '', '蒋玉菡', '', '', '建设银行', '123124143221423142', '', null, '');
INSERT INTO `customer` VALUES ('64541355467770768486849918', '蒋玉菡', '北京', 'jingli', '重点开发客户', '5', '5', '洛阳', '000000', '15011411410', '15011912010', 'www,baidu.com', '', '蒋玉菡', '', '', '建设银行', '123124143221423142', '', null, '');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `dictionId` varchar(255) NOT NULL,
  `dictionType` varchar(255) DEFAULT NULL,
  `dictionEntry` varchar(255) DEFAULT NULL,
  `dictionValue` varchar(255) DEFAULT NULL,
  `dictionState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dictionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('00906269745485561040884', '服务类型', '会议', '会议', 'Y');
INSERT INTO `dictionary` VALUES ('0851177014493790198971700', '服务类型', '电话', '电话', 'Y');
INSERT INTO `dictionary` VALUES ('1019844468350263456336', '企业级客户等级', '重点开发客户', '2', 'N');
INSERT INTO `dictionary` VALUES ('1792179214043575834466091', '服务类型', '咨询', '咨询', 'Y');
INSERT INTO `dictionary` VALUES ('2101416764474628996322997', '企业级客户等级', '合作伙伴', '3', 'N');
INSERT INTO `dictionary` VALUES ('4566349508037883', '企业级客户等级', '战略合作伙伴', '5', 'N');
INSERT INTO `dictionary` VALUES ('46226344604818532723886', '服务类型', 'XXX', 'XXX', 'Y');
INSERT INTO `dictionary` VALUES ('4656448457251208662484', '服务类型', '访谈', '访谈', 'Y');
INSERT INTO `dictionary` VALUES ('4663860444890722135975', '企业级客户等级', '普通客户', '1', 'N');
INSERT INTO `dictionary` VALUES ('629542743531826946324', '企业级客户等级', '大客户', '4', 'N');

-- ----------------------------
-- Table structure for `market`
-- ----------------------------
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market` (
  `numberId` varchar(255) NOT NULL,
  `opporTunity` varchar(255) DEFAULT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `probability` int(11) DEFAULT NULL,
  `outLine` varchar(255) DEFAULT NULL,
  `contacts` varchar(255) DEFAULT NULL,
  `contactPhone` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `founder` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `distribution` varchar(255) DEFAULT NULL,
  `distime` varchar(255) DEFAULT NULL,
  `judge` varchar(255) DEFAULT NULL,
  `development` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of market
-- ----------------------------
INSERT INTO `market` VALUES ('1362277995645368902408494', '合作伙伴', '蒋氏集团', '100', '购买轮滑鞋进行无限加速实验', '蒋玉菡', '15011011412', '。。。。。。', 'khjl', '2018-4-9 23:15:41', 'jingli', '2018-4-9 23:20:47', 'Y', 'S');
INSERT INTO `market` VALUES ('19457717010427658453779978', '随便', 'DDD', '11', 'DDD', 'DD', 'DD', 'DDD', 'khjl', '2018-4-10 14:4:6', 'khjlkhjl', '2018-4-10 14:5:47', 'Y', 'YY');
INSERT INTO `market` VALUES ('203613884336872536697', '未知', '蒋氏集团', '0', '烟界大佬，想通过我方向吸毒圈进发，有意向购买大麻', '糊硬僧 ', '15011011010', '虽然此人给出了天价交易金额，但伤天害理之事，本公司是不可能同意参与的', 'khjl', '2018-4-9 23:4:11', 'jingli', '2018-4-9 23:20:54', 'Y', 'YY');
INSERT INTO `market` VALUES ('4452786774639041626958', '熟人', '蒋氏集团', '100', '购买修炼完能够300年不吃不喝的武功秘籍', '蒋毅展', '15250250250', '蒋家之人，天下第一', 'khjl', '2018-4-9 23:16:44', 'khjl', '2018-4-9 23:21:7', 'Y', 'YY');
INSERT INTO `market` VALUES ('48244798845089734220751', '熟人引荐', '蒋氏集团', '100', '购买房产', '蒋毅展', '15011912010', '蒋氏集团总裁的哥哥，人傻好忽悠，但实际上在公司没有大权', 'khjl', '2018-4-9 23:0:37', 'khjlkhjl', '2018-4-9 23:45:18', 'Y', 'YY');
INSERT INTO `market` VALUES ('5661580358485080378111567', '合作伙伴', '蒋氏集团', '100', '购买火车', '蒋玉菡', '15011011412', '牛逼，有钱任性', 'khjl', '2018-4-9 23:14:57', 'jingli', '2018-4-9 23:44:21', 'Y', 'YY');
INSERT INTO `market` VALUES ('6080885466588317036243072', '合作伙伴', '蒋氏集团', '100', '购买航空母舰', '蒋玉菡', '15011411012', '异想天开，有钱无脑，忽悠一波赚大钱', 'khjl', '2018-4-9 23:10:54', 'jingli', '2018-4-9 23:44:36', 'Y', 'YY');
INSERT INTO `market` VALUES ('64541355467770768486849918', '熟人推荐', '蒋玉菡', '100', '蒋氏集团的傀儡总裁，人称“刘禅转世”，喜欢天吹', '郭新', '15011411410', '由于机缘巧合下结实了蒋氏集团幕后大手，从而与蒋氏集团合作，且总裁人傻钱多好忽悠，合作成功率基本为100%', 'khjl', '2018-4-9 22:53:57', 'jingli', '2018-4-9 23:44:43', 'Y', 'YY');
INSERT INTO `market` VALUES ('725543487064496963201', '电话', '刘宇翔', '95', '不言则以，一鸣惊人！！', '江一展', '15211014019', '通过网络通讯手段得知该客户信息', 'khjl', '2018-4-9 22:46:34', 'jingli', '2018-4-9 23:44:53', 'Y', 'N');
INSERT INTO `market` VALUES ('7668543708503101946385', '合作伙伴', '蒋氏集团', '100', '机动车加装火箭喷射器', '蒋玉菡', '15011411012', '对此人已无话可说，反正有钱赚', 'khjl', '2018-4-9 23:12:49', 'jingli', '2018-4-9 23:45:1', 'Y', 'N');
INSERT INTO `market` VALUES ('77230027146476962870535', '网络广告', '郭新', '80', '蒋氏集团的幕后投资人', '蒋毅展', '15011011419', '通过网络宣传手段', 'khjl', '2018-4-9 22:50:22', 'jingli', '2018-4-9 23:45:7', 'Y', 'N');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numberId` varchar(255) DEFAULT NULL,
  `planTime` varchar(255) DEFAULT NULL,
  `executePlan` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `planEffect` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('22', '6829540174342258026818158', '2018-03-02', '今天是2018.3.30', null, '还可以');
INSERT INTO `plan` VALUES ('23', '6829540174342258026818158', '2018-03-01', '12333', null, '一般');
INSERT INTO `plan` VALUES ('24', '75204610146508480284375', '2018-03-03', '阿斯顿', null, '不错');
INSERT INTO `plan` VALUES ('25', '75204610146508480284375', '2018-03-09', '约谈', null, '还行');
INSERT INTO `plan` VALUES ('26', '36134282681688217', '2018-04-06', 'ijjj', null, 'vv');
INSERT INTO `plan` VALUES ('27', '782580248478976558', '2018-04-06', 'gg ', null, null);
INSERT INTO `plan` VALUES ('28', '83039535242739276187314942', '2018-04-12', '开发', null, '还不错');
INSERT INTO `plan` VALUES ('30', '1362277995645368902408494', '2018-04-13', '了解客户要求', null, null);
INSERT INTO `plan` VALUES ('31', '1362277995645368902408494', '2018-04-14', '购买产品', null, null);
INSERT INTO `plan` VALUES ('32', '1362277995645368902408494', '2018-04-15', '完成交易', null, null);
INSERT INTO `plan` VALUES ('33', '203613884336872536697', '2018-04-01', '了解意向', null, '完美');
INSERT INTO `plan` VALUES ('34', '203613884336872536697', '2018-04-02', '拒绝合作', null, '完美');
INSERT INTO `plan` VALUES ('35', '4452786774639041626958', '2018-04-01', '了解意向', null, '完美');
INSERT INTO `plan` VALUES ('36', '48244798845089734220751', '2018-04-03', '了解意向', null, null);
INSERT INTO `plan` VALUES ('37', '48244798845089734220751', '2018-04-04', '完成交易', null, null);
INSERT INTO `plan` VALUES ('38', '5661580358485080378111567', '2018-04-01', '了解意向', null, '完美');
INSERT INTO `plan` VALUES ('39', '5661580358485080378111567', '2018-04-02', '完成交易', null, '完美');
INSERT INTO `plan` VALUES ('40', '6080885466588317036243072', '2018-04-01', '了解意向', null, '完美');
INSERT INTO `plan` VALUES ('41', '6080885466588317036243072', '2018-04-02', '交易成功', null, '完美');
INSERT INTO `plan` VALUES ('42', '64541355467770768486849918', '2018-04-01', '了解意向', null, '完美');
INSERT INTO `plan` VALUES ('43', '64541355467770768486849918', '2018-04-02', '采购商品', null, '完美');
INSERT INTO `plan` VALUES ('44', '64541355467770768486849918', '2018-04-03', '完成交易', null, '完美');
INSERT INTO `plan` VALUES ('46', '19457717010427658453779978', '2018-04-14', 'AAA', null, 'XXX');
INSERT INTO `plan` VALUES ('47', '19457717010427658453779978', '2018-04-26', 'asdsad', null, 'asd');

-- ----------------------------
-- Table structure for `serve`
-- ----------------------------
DROP TABLE IF EXISTS `serve`;
CREATE TABLE `serve` (
  `serveId` varchar(255) NOT NULL,
  `serveType` varchar(255) DEFAULT NULL,
  `serveOutline` varchar(255) DEFAULT NULL,
  `serveCustomer` varchar(255) DEFAULT NULL,
  `serveState` varchar(255) DEFAULT NULL,
  `serveRequest` varchar(255) DEFAULT NULL,
  `serveFounder` varchar(255) DEFAULT NULL,
  `serveTime` varchar(255) DEFAULT NULL,
  `serveDistri` varchar(255) DEFAULT NULL,
  `serveDistritime` varchar(255) DEFAULT NULL,
  `serveHandle` varchar(255) DEFAULT NULL,
  `serveHandlepeo` varchar(255) DEFAULT NULL,
  `serveHandletime` varchar(255) DEFAULT NULL,
  `serveResult` varchar(255) DEFAULT NULL,
  `serveSatisfied` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`serveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serve
-- ----------------------------
INSERT INTO `serve` VALUES ('148046096148149464525070', '咨询', '咨询', '蒋玉菡', 'F', '买电脑', 'khjl', '2018-4-9 23:57:53', 'jingli', '2018-04-09 23:58:27', '顺利完成', 'khjl', '2018-4-9 23:58:34', '五星好评', '5');
INSERT INTO `serve` VALUES ('323759534189196934', '咨询', '咨询', '咨询', 'F', '咨询', '咨询', '咨询', 'khjlkhjl', '2018-04-07 14:14:46', 'sad', 'khjl', '2018-4-7 15:13:8', 'ku', '5');
INSERT INTO `serve` VALUES ('62288213646780305854', '访谈', '谈天说地', '蒋玉菡', 'F', '买下全世界的胖次，当胖次之王', 'khjl', '2018-4-9 23:39:0', 'jingli', '2018-04-09 23:40:06', '很顺利', 'khjl', '2018-4-9 23:40:20', '五星好评', '5');
INSERT INTO `serve` VALUES ('7078254740460872636365', '咨询', '咨询', '蒋玉菡', 'F', '买电脑', 'khjl', '2018-4-9 23:56:12', 'jingli', '2018-04-09 23:57:00', '顺利完成', 'khjl', '2018-4-9 23:57:8', '五星好评', '5');
INSERT INTO `serve` VALUES ('9949942564151823311964463', '咨询', '阿斯顿', '阿迪斯', 'F', '111', 'khjl', '2018-4-9 21:32:34', 'jingli', '2018-04-09 23:40:12', '顺利完成', 'khjl', '2018-4-9 23:41:28', '五星好评', '5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aaa', 'aaa', 'gly');
INSERT INTO `user` VALUES ('admin', 'admin', 'gly');
INSERT INTO `user` VALUES ('gaoguan', 'gaoguan', 'gg');
INSERT INTO `user` VALUES ('jingli', 'jingli', 'khjl');
INSERT INTO `user` VALUES ('khjl', 'khjl', 'khjl');
INSERT INTO `user` VALUES ('khjlkhjl', 'khjl', 'khjl');
INSERT INTO `user` VALUES ('xiaoshou', 'xiaoshou', 'xszg');
