/*
Navicat MySQL Data Transfer

Source Server         : ziji
Source Server Version : 80017
Source Host           : 49.234.196.87:3306
Source Database       : mood

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-21 18:18:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agree_table`
-- ----------------------------
DROP TABLE IF EXISTS `agree_table`;
CREATE TABLE `agree_table` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `user_id` int(26) NOT NULL,
  `essay_id` int(26) NOT NULL COMMENT '心情随笔id',
  `is_active` int(1) NOT NULL DEFAULT '0' COMMENT '点赞是否取消1表示取消0表示还在',
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agree_table
-- ----------------------------
INSERT INTO `agree_table` VALUES ('1', '4', '1', '1', '2019-09-17 17:20:04');
INSERT INTO `agree_table` VALUES ('2', '3', '1', '1', '2019-09-17 10:49:09');
INSERT INTO `agree_table` VALUES ('3', '3', '2', '1', '2019-09-17 10:59:50');
INSERT INTO `agree_table` VALUES ('4', '4', '2', '0', '2019-09-17 16:00:14');
INSERT INTO `agree_table` VALUES ('5', '4', '3', '1', '2019-09-18 16:11:47');
INSERT INTO `agree_table` VALUES ('6', '3', '4', '1', '2019-09-18 16:14:16');
INSERT INTO `agree_table` VALUES ('7', '3', '3', '1', '2019-09-18 16:17:25');
INSERT INTO `agree_table` VALUES ('8', '4', '5', '1', '2019-09-19 10:39:35');
INSERT INTO `agree_table` VALUES ('9', '4', '7', '1', '2019-09-19 16:06:08');
INSERT INTO `agree_table` VALUES ('10', '5', '6', '1', '2019-09-19 16:07:28');
INSERT INTO `agree_table` VALUES ('11', '5', '7', '1', '2019-09-19 16:07:29');
INSERT INTO `agree_table` VALUES ('12', '5', '5', '1', '2019-09-19 16:07:31');
INSERT INTO `agree_table` VALUES ('13', '5', '4', '1', '2019-09-19 16:07:33');
INSERT INTO `agree_table` VALUES ('14', '5', '8', '1', '2019-09-19 16:21:29');
INSERT INTO `agree_table` VALUES ('15', '4', '8', '1', '2019-09-20 10:27:22');
INSERT INTO `agree_table` VALUES ('16', '6', '9', '1', '2019-09-22 10:24:17');
INSERT INTO `agree_table` VALUES ('17', '3', '9', '1', '2019-09-22 10:24:37');
INSERT INTO `agree_table` VALUES ('18', '3', '10', '1', '2019-09-22 16:09:06');
INSERT INTO `agree_table` VALUES ('19', '6', '11', '1', '2019-09-25 06:11:41');
INSERT INTO `agree_table` VALUES ('20', '6', '10', '1', '2019-09-25 06:11:45');
INSERT INTO `agree_table` VALUES ('21', '3', '12', '1', '2019-09-28 03:27:36');
INSERT INTO `agree_table` VALUES ('22', '4', '13', '1', '2019-09-28 15:41:17');
INSERT INTO `agree_table` VALUES ('23', '4', '12', '1', '2019-09-28 15:41:19');
INSERT INTO `agree_table` VALUES ('24', '4', '11', '1', '2019-09-28 15:41:21');
INSERT INTO `agree_table` VALUES ('25', '4', '10', '1', '2019-09-28 15:41:22');
INSERT INTO `agree_table` VALUES ('26', '6', '14', '1', '2019-09-29 15:13:28');
INSERT INTO `agree_table` VALUES ('27', '6', '15', '1', '2019-09-30 01:28:00');
INSERT INTO `agree_table` VALUES ('28', '4', '17', '1', '2019-10-05 12:38:04');
INSERT INTO `agree_table` VALUES ('29', '3', '14', '1', '2019-10-06 02:18:56');
INSERT INTO `agree_table` VALUES ('30', '3', '17', '1', '2019-10-06 02:44:58');
INSERT INTO `agree_table` VALUES ('31', '6', '20', '1', '2019-10-13 05:32:57');
INSERT INTO `agree_table` VALUES ('32', '3', '16', '1', '2019-10-13 08:38:00');

-- ----------------------------
-- Table structure for `comment_table`
-- ----------------------------
DROP TABLE IF EXISTS `comment_table`;
CREATE TABLE `comment_table` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `user_id` int(26) NOT NULL,
  `essay_id` int(26) NOT NULL,
  `parent_comment_id` int(26) NOT NULL DEFAULT '0' COMMENT '根评论默认为0',
  `add_time` datetime DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment_table
-- ----------------------------
INSERT INTO `comment_table` VALUES ('1', '4', '1', '0', '2019-09-16 23:46:14', '我胡汉三又回来了');
INSERT INTO `comment_table` VALUES ('2', '4', '1', '0', '2019-09-17 23:46:46', '又是我');
INSERT INTO `comment_table` VALUES ('3', '3', '1', '0', '2019-09-10 23:47:03', '皮衣皮');
INSERT INTO `comment_table` VALUES ('4', '3', '1', '0', '2019-09-18 09:33:53', '哈哈');
INSERT INTO `comment_table` VALUES ('5', '6', '1', '0', '2019-09-10 09:34:10', '呵呵');
INSERT INTO `comment_table` VALUES ('6', '5', '1', '0', '2019-09-17 09:34:26', '你说呢');
INSERT INTO `comment_table` VALUES ('7', '4', '1', '0', '2019-09-11 09:35:04', '我是神');
INSERT INTO `comment_table` VALUES ('8', '3', '1', '0', '2019-09-10 09:35:48', '测试');
INSERT INTO `comment_table` VALUES ('9', '3', '1', '0', '2019-09-18 03:37:40', '上天不');
INSERT INTO `comment_table` VALUES ('10', '3', '1', '0', '2019-09-18 03:42:10', '你们的爸爸回来了');
INSERT INTO `comment_table` VALUES ('11', '4', '1', '0', '2019-09-18 06:27:55', '请轻轻资金，悠悠我心，但为君故，沉吟至今，呦呦鹿鸣，食野之苹，单位近日，去日苦多，慨当以慷，忧思难忘，何以解忧，唯有杜康，哈哈哈，赤壁');
INSERT INTO `comment_table` VALUES ('12', '4', '1', '0', '2019-09-18 14:27:14', '走你');
INSERT INTO `comment_table` VALUES ('13', '3', '3', '0', '2019-09-18 16:17:35', '我是胡汉三');
INSERT INTO `comment_table` VALUES ('14', '4', '5', '0', '2019-09-19 11:15:30', '嘿，你真傻');
INSERT INTO `comment_table` VALUES ('15', '3', '10', '0', '2019-09-22 16:09:16', '你是个傻逼吧');
INSERT INTO `comment_table` VALUES ('16', '6', '10', '0', '2019-09-22 16:09:37', '你才是个傻逼');
INSERT INTO `comment_table` VALUES ('17', '4', '10', '0', '2019-09-22 16:09:52', '我是吃瓜群众');
INSERT INTO `comment_table` VALUES ('18', '6', '9', '0', '2019-09-25 06:12:19', '看到这成果有点开心，哈哈');
INSERT INTO `comment_table` VALUES ('19', '4', '12', '0', '2019-09-29 01:20:47', '如盗梦空间般丝滑');

-- ----------------------------
-- Table structure for `friends_table`
-- ----------------------------
DROP TABLE IF EXISTS `friends_table`;
CREATE TABLE `friends_table` (
  `f_id` int(26) NOT NULL AUTO_INCREMENT COMMENT '好友id',
  `f_friend_id` int(26) NOT NULL,
  `f_user_id` int(26) NOT NULL,
  `f_nickname` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `f_add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `1` (`f_friend_id`,`f_user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of friends_table
-- ----------------------------
INSERT INTO `friends_table` VALUES ('1', '3', '4', '会飞的猪', null);
INSERT INTO `friends_table` VALUES ('2', '4', '3', '阔别时光', null);
INSERT INTO `friends_table` VALUES ('126', '3', '5', '会飞的猪', '2019-10-07 13:38:04');
INSERT INTO `friends_table` VALUES ('127', '5', '3', '我在啊', '2019-10-07 13:38:04');

-- ----------------------------
-- Table structure for `group_message_table`
-- ----------------------------
DROP TABLE IF EXISTS `group_message_table`;
CREATE TABLE `group_message_table` (
  `gm_id` int(64) NOT NULL,
  `gm_content` varchar(200) NOT NULL,
  `gm_user_id` int(26) NOT NULL,
  `gm_nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gm_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`gm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of group_message_table
-- ----------------------------

-- ----------------------------
-- Table structure for `group_message_to_user`
-- ----------------------------
DROP TABLE IF EXISTS `group_message_to_user`;
CREATE TABLE `group_message_to_user` (
  `gtu_id` int(26) NOT NULL,
  `gtu_user_id` int(26) NOT NULL,
  `gtu_message_id` int(26) NOT NULL,
  `gtu_group_id` int(26) NOT NULL,
  `gtu_status` char(10) DEFAULT NULL COMMENT '消息接收状态',
  PRIMARY KEY (`gtu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of group_message_to_user
-- ----------------------------

-- ----------------------------
-- Table structure for `group_table`
-- ----------------------------
DROP TABLE IF EXISTS `group_table`;
CREATE TABLE `group_table` (
  `g_id` int(26) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `g_create_name` datetime DEFAULT NULL,
  `g_admin_id` int(26) DEFAULT NULL,
  `g_icon` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '杩欐槸缇ゅ浘鏍?',
  `g_notice` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '缇ゅ叕鍛?',
  `g_intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '缇ょ畝浠?',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of group_table
-- ----------------------------

-- ----------------------------
-- Table structure for `group_to_user_table`
-- ----------------------------
DROP TABLE IF EXISTS `group_to_user_table`;
CREATE TABLE `group_to_user_table` (
  `gtu_id` int(26) NOT NULL AUTO_INCREMENT,
  `gtu_user_id` int(26) NOT NULL,
  `gtu_group_id` int(26) NOT NULL,
  `gtu_create_time` datetime NOT NULL,
  `gtu_nick_name` varchar(26) DEFAULT NULL,
  PRIMARY KEY (`gtu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of group_to_user_table
-- ----------------------------

-- ----------------------------
-- Table structure for `informal_essay`
-- ----------------------------
DROP TABLE IF EXISTS `informal_essay`;
CREATE TABLE `informal_essay` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `user_id` int(26) NOT NULL,
  `content` text,
  `publish_time` datetime DEFAULT NULL,
  `agree_nums` int(26) DEFAULT '0',
  `comment_nums` int(26) DEFAULT '0',
  `picture` varchar(64) DEFAULT NULL,
  `publish_address` varchar(64) DEFAULT NULL,
  `is_visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '0鍙1涓嶅彲瑙?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of informal_essay
-- ----------------------------
INSERT INTO `informal_essay` VALUES ('1', '4', '最佳答案: 比如同时有A.java和B.java两个类,A.java如下: public class A{ private B b1; private List<B> b2; } 在映射b1属性时用association标签, 映射b2.', '2019-09-16 17:28:00', '15', '9', null, null, '0');
INSERT INTO `informal_essay` VALUES ('2', '4', '2017年4月11日 - mybatis 的 association标签 和 collection标签的区别是什么啊 网上看的我头昏眼花 哪位大神可以给我简单明了的解释一下具体什么意思啊?以及什么时候', '2019-09-10 17:28:48', '11', '99', null, null, '0');
INSERT INTO `informal_essay` VALUES ('3', '4', '我', '2019-09-18 16:11:43', '2', '1', null, null, '0');
INSERT INTO `informal_essay` VALUES ('4', '3', '我要出来说句话，我胡汉三又回来了', '2019-09-18 16:14:12', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('5', '4', '你说喜欢下雨天，可是我偏偏没有带伞', '2019-09-19 10:39:29', '2', '1', null, null, '0');
INSERT INTO `informal_essay` VALUES ('6', '3', '我不知到怎么取表达自己，我只想说，我热爱这个世界，希望是接也给我希望', '2019-09-19 11:18:07', '1', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('7', '6', '你们知道我是谁吗？傻瓜', '2019-09-19 11:19:19', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('8', '5', '第一次写，还是蛮紧张的', '2019-09-19 16:21:18', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('11', '3', '临近国亲之际，我只想说，万国之中，属中华最强，万人之中，属你出类拔萃', '2019-09-25 04:29:51', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('12', '3', '不管如何，做个造梦人，然后留在梦里，这就是那个梦工厂', '2019-09-28 03:27:32', '2', '1', null, null, '0');
INSERT INTO `informal_essay` VALUES ('13', '4', '不能说的秘密-周杰伦', '2019-09-28 15:41:04', '1', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('14', '6', '嘿，是谁偷走了我的小熊', '2019-09-29 15:12:41', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('15', '6', '来跟我整齐化一，左边一侧我们画着龙，右边我们画一条彩虹，走起', '2019-09-30 01:26:23', '1', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('17', '10', '我就是想静静', '2019-10-05 10:43:21', '2', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('18', '5', '时间不会为任何人停下,你要听吗,可能要花一整个晚上,小说一样的结局,故事的最后去了哪里', '2019-10-07 01:56:00', '0', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('19', '5', '假期最后一天啊,好忧伤,好迷茫,啊哈哈哈,作品还没有完工,再坚持坚持写完它', '2019-10-07 01:56:53', '0', '0', null, null, '0');
INSERT INTO `informal_essay` VALUES ('20', '6', '有一点点老干部的感觉了，哈哈', '2019-10-13 05:32:42', '1', '0', null, null, '0');

-- ----------------------------
-- Table structure for `message_type_table`
-- ----------------------------
DROP TABLE IF EXISTS `message_type_table`;
CREATE TABLE `message_type_table` (
  `mt_id` int(11) NOT NULL AUTO_INCREMENT,
  `mt_name` varchar(26) NOT NULL,
  PRIMARY KEY (`mt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message_type_table
-- ----------------------------

-- ----------------------------
-- Table structure for `person_message_table`
-- ----------------------------
DROP TABLE IF EXISTS `person_message_table`;
CREATE TABLE `person_message_table` (
  `m_id` int(26) NOT NULL AUTO_INCREMENT,
  `m_message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `m_status` int(1) DEFAULT '0',
  `m_send_time` datetime DEFAULT NULL,
  `m_message_type_id` int(2) DEFAULT NULL,
  `m_from_user_id` int(26) NOT NULL,
  `m_to_user_id` int(26) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of person_message_table
-- ----------------------------
INSERT INTO `person_message_table` VALUES ('1', '你', '0', '2019-09-22 14:22:07', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('2', '好你的', '0', '2019-09-23 14:35:55', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('3', '嘿嘿', '0', '2019-09-23 14:40:07', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('4', '测试一下', '0', '2019-09-23 14:42:38', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('5', '嘿嘿', '0', '2019-09-23 14:44:57', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('6', '我想你', '0', '2019-09-23 14:45:12', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('7', '哈哈，是我', '0', '2019-09-23 14:51:42', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('8', '我是那人', '0', '2019-09-23 14:52:22', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('9', '我是飞啊', '0', '2019-09-23 14:53:15', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('10', '你好', '0', '2019-09-23 14:56:47', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('11', 'wobuhao1', '0', '2019-09-23 23:39:52', null, '4', '3');
INSERT INTO `person_message_table` VALUES ('12', '测试2', '0', '2019-09-23 16:31:29', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('13', '哈哈', '0', '2019-09-23 16:52:59', null, '3', '3');
INSERT INTO `person_message_table` VALUES ('14', '嘿嘿', '0', '2019-09-23 16:53:06', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('15', '测试3', '0', '2019-09-23 16:53:25', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('16', '测试4', '0', '2019-09-23 16:53:48', null, '4', '4');
INSERT INTO `person_message_table` VALUES ('17', '测试5', '0', '2019-09-23 16:54:05', null, '4', '3');
INSERT INTO `person_message_table` VALUES ('18', '真的很开新', '0', '2019-09-24 15:37:23', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('19', '终于快要完工了', '0', '2019-09-24 15:37:30', null, '3', '4');
INSERT INTO `person_message_table` VALUES ('20', '哈哈', '0', '2019-09-24 15:41:23', null, '4', '3');
INSERT INTO `person_message_table` VALUES ('21', '哈哈', '0', '2019-09-24 15:41:56', null, '4', '3');
INSERT INTO `person_message_table` VALUES ('22', '我是阿飞', '0', '2019-10-07 15:09:37', null, '3', '5');
INSERT INTO `person_message_table` VALUES ('23', '你知道吗？', '0', '2019-10-13 09:30:24', null, '3', '5');
INSERT INTO `person_message_table` VALUES ('24', '我是你爸爸', '0', '2019-10-13 09:31:01', null, '3', '5');
INSERT INTO `person_message_table` VALUES ('25', '快叫爸爸', '0', '2019-10-13 09:42:50', null, '3', '5');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `username` varchar(26) NOT NULL,
  `password` varchar(64) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `avatar` varchar(64) DEFAULT NULL,
  `desc` varchar(256) DEFAULT NULL,
  `phone` varchar(26) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `nickname` varchar(26) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('3', 'lifei', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-13 01:08:32', 'picture/6666.jpg', '只要我够快，你就追不上我', '159863254', '天', '会飞的猪', '2019-10-10 00:00:00', '2');
INSERT INTO `user_info` VALUES ('4', 'lifei2', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 14:24:10', 'picture/222.jpg', '我是风一样的男人', null, null, '阔别时光', null, null);
INSERT INTO `user_info` VALUES ('5', 'lifei3', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 06:31:11', 'picture/333.jpg', '来抓我啊', null, null, '我在啊', '2019-10-18 00:00:00', '2');
INSERT INTO `user_info` VALUES ('6', 'lifei4', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 07:02:05', 'picture/4444.jpg', '旋转跳跃', null, null, '你猜猜', null, null);
INSERT INTO `user_info` VALUES ('7', 'lifei5', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 12:27:36', 'picture/6666.jpg', 'asdasd', null, null, '阔别时光', null, null);
INSERT INTO `user_info` VALUES ('8', 'sysuadmin', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 13:44:28', 'picture/6666.jpg', 'asd', null, null, '阔别时光', null, null);
INSERT INTO `user_info` VALUES ('9', 'lifei6', 'e10adc3949ba59abbe56e057f20f883e', '2019-09-15 14:39:08', 'picture/6666.jpg', 'asd', null, null, '阔别时光', null, null);
INSERT INTO `user_info` VALUES ('10', 'haijing', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-05 09:36:26', 'picture/1571482408820timg.jpg', '我就是想静静', null, null, '我想静静', null, null);
INSERT INTO `user_info` VALUES ('11', 'jingjing', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-05 10:44:35', 'picture/moren.jpg', null, null, null, '静静是我啊', null, null);
INSERT INTO `user_info` VALUES ('12', 'fei', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-05 12:08:50', 'picture/moren.jpg', null, null, null, '我要飞', null, null);

-- ----------------------------
-- Table structure for `user_status_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_status_table`;
CREATE TABLE `user_status_table` (
  `us_id` int(26) NOT NULL AUTO_INCREMENT COMMENT '用户状态id',
  `us_name` varchar(26) DEFAULT NULL COMMENT '状态名称',
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_status_table
-- ----------------------------

-- ----------------------------
-- Table structure for `verify_content_table`
-- ----------------------------
DROP TABLE IF EXISTS `verify_content_table`;
CREATE TABLE `verify_content_table` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `v_user_id` int(26) NOT NULL,
  `v_collect_user_id` int(26) NOT NULL,
  `v_send_time` datetime DEFAULT NULL,
  `v_send_content` varchar(200) DEFAULT '无',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of verify_content_table
-- ----------------------------
INSERT INTO `verify_content_table` VALUES ('2', '5', '10', '2019-10-07 09:19:58', '我是阿飞');
INSERT INTO `verify_content_table` VALUES ('3', '5', '3', '2019-10-07 10:26:19', '踩踩我是谁啊');

-- ----------------------------
-- Table structure for `visitor_table`
-- ----------------------------
DROP TABLE IF EXISTS `visitor_table`;
CREATE TABLE `visitor_table` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `user_id` int(26) NOT NULL COMMENT '主人id',
  `visitor_id` int(26) NOT NULL COMMENT '访问者id',
  `visite_time` datetime DEFAULT NULL,
  `is_flag` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of visitor_table
-- ----------------------------

-- ----------------------------
-- Table structure for `word_message_table`
-- ----------------------------
DROP TABLE IF EXISTS `word_message_table`;
CREATE TABLE `word_message_table` (
  `wm_id` int(26) NOT NULL AUTO_INCREMENT,
  `wm_message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `wm_status` int(1) DEFAULT '0',
  `wm_send_time` datetime DEFAULT NULL,
  `wm_message_type_id` int(26) DEFAULT NULL,
  `wm_from_user_id` int(26) NOT NULL,
  PRIMARY KEY (`wm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of word_message_table
-- ----------------------------
INSERT INTO `word_message_table` VALUES ('1', '你好啊', '0', '2019-09-22 13:26:56', null, '4');
INSERT INTO `word_message_table` VALUES ('2', '兄弟', '0', '2019-09-22 13:27:00', null, '4');
INSERT INTO `word_message_table` VALUES ('3', '是兄弟就来砍我', '0', '2019-09-22 13:29:22', null, '4');
INSERT INTO `word_message_table` VALUES ('4', '啥的', '0', '2019-09-22 14:43:17', null, '4');
INSERT INTO `word_message_table` VALUES ('5', '按时大大', '0', '2019-09-22 14:43:51', null, '4');
INSERT INTO `word_message_table` VALUES ('6', '阿大声道', '0', '2019-09-22 14:43:55', null, '4');
INSERT INTO `word_message_table` VALUES ('7', '盛大的', '0', '2019-09-22 14:47:12', null, '4');
INSERT INTO `word_message_table` VALUES ('8', '阿萨德', '0', '2019-09-22 14:48:29', null, '4');
INSERT INTO `word_message_table` VALUES ('9', '阿萨德', '0', '2019-09-22 14:52:33', null, '4');
INSERT INTO `word_message_table` VALUES ('10', '你妹的', '0', '2019-09-22 15:11:52', null, '3');
INSERT INTO `word_message_table` VALUES ('11', '我是爸爸', '0', '2019-09-22 15:11:56', null, '3');
INSERT INTO `word_message_table` VALUES ('12', '你个掉毛', '0', '2019-09-22 15:12:03', null, '4');
INSERT INTO `word_message_table` VALUES ('13', 'haha1', '0', '2019-09-22 15:58:40', null, '4');
INSERT INTO `word_message_table` VALUES ('14', 'hehe1', '0', '2019-09-22 15:58:55', null, '3');
INSERT INTO `word_message_table` VALUES ('15', '我是李飞', '0', '2019-09-22 16:07:24', null, '3');
INSERT INTO `word_message_table` VALUES ('16', '你是谁', '0', '2019-09-22 16:07:28', null, '3');
INSERT INTO `word_message_table` VALUES ('17', '我是会费的猪', '0', '2019-09-22 16:07:37', null, '4');
INSERT INTO `word_message_table` VALUES ('18', '不要爱上我', '0', '2019-09-22 16:07:42', null, '4');
INSERT INTO `word_message_table` VALUES ('19', '是兄弟就来砍我', '0', '2019-09-22 16:10:41', null, '3');
INSERT INTO `word_message_table` VALUES ('20', '呵呵\n', '0', '2019-09-22 16:10:58', null, '6');
INSERT INTO `word_message_table` VALUES ('21', '好好说话', '0', '2019-09-22 16:11:56', null, '4');
INSERT INTO `word_message_table` VALUES ('22', '我就不', '0', '2019-09-22 16:12:04', null, '3');
INSERT INTO `word_message_table` VALUES ('23', '你', '0', '2019-09-22 16:12:37', null, '6');
INSERT INTO `word_message_table` VALUES ('24', '嘿嘿', '0', '2019-09-23 01:31:06', null, '6');
INSERT INTO `word_message_table` VALUES ('25', '真的没有断开啊\n', '0', '2019-09-23 01:31:17', null, '4');
INSERT INTO `word_message_table` VALUES ('26', '是啊', '0', '2019-09-23 01:31:26', null, '6');
INSERT INTO `word_message_table` VALUES ('27', '你妹的', '0', '2019-09-23 14:36:55', null, '3');
INSERT INTO `word_message_table` VALUES ('28', '怎么了', '0', '2019-09-23 14:37:01', null, '3');
INSERT INTO `word_message_table` VALUES ('29', '', '0', '2019-09-23 14:37:01', null, '3');
INSERT INTO `word_message_table` VALUES ('30', '达到', '0', '2019-09-23 14:37:05', null, '3');
INSERT INTO `word_message_table` VALUES ('31', '怎么了', '0', '2019-09-23 14:39:48', null, '3');
INSERT INTO `word_message_table` VALUES ('32', '想你了吗？', '0', '2019-09-23 14:39:56', null, '3');
INSERT INTO `word_message_table` VALUES ('33', '你是', '0', '2019-09-23 14:51:51', null, '4');
INSERT INTO `word_message_table` VALUES ('34', '我不好', '0', '2019-09-23 14:56:57', null, '4');
INSERT INTO `word_message_table` VALUES ('35', '测试1', '0', '2019-09-23 16:30:49', null, '3');
INSERT INTO `word_message_table` VALUES ('36', '只要我够快，你就追不上我\n', '0', '2019-09-24 02:05:55', null, '3');
INSERT INTO `word_message_table` VALUES ('37', '来追我啊，哈哈，傻子', '0', '2019-09-24 02:06:23', null, '3');
INSERT INTO `word_message_table` VALUES ('38', '嘿，傻逼', '0', '2019-09-25 01:29:42', null, '3');
INSERT INTO `word_message_table` VALUES ('39', '你才是傻逼', '0', '2019-09-25 01:30:12', null, '4');
INSERT INTO `word_message_table` VALUES ('40', 'wozai1', '0', '2019-09-28 12:57:03', null, '4');
INSERT INTO `word_message_table` VALUES ('41', '看飞机', '0', '2019-09-28 12:57:18', null, '3');
INSERT INTO `word_message_table` VALUES ('42', '赤道的边境万里无云', '0', '2019-09-29 01:18:24', null, '4');
INSERT INTO `word_message_table` VALUES ('43', '看你千遍终于有回音', '0', '2019-09-29 01:18:51', null, '3');
INSERT INTO `word_message_table` VALUES ('44', '头像\n', '0', '2019-10-05 08:33:01', null, '3');
INSERT INTO `word_message_table` VALUES ('45', '世界突然变得好安静', '0', '2019-10-06 01:57:44', null, '3');
INSERT INTO `word_message_table` VALUES ('46', '阔别时光', '0', '2019-10-06 01:58:00', null, '3');
INSERT INTO `word_message_table` VALUES ('47', 'heihei', '0', '2019-10-08 15:48:28', null, '3');
INSERT INTO `word_message_table` VALUES ('48', '测试', '0', '2019-10-09 15:28:51', null, '3');
INSERT INTO `word_message_table` VALUES ('49', '测试', '0', '2019-10-13 08:15:37', null, '3');
INSERT INTO `word_message_table` VALUES ('50', '测试一下', '0', '2019-10-13 09:33:09', null, '3');
INSERT INTO `word_message_table` VALUES ('51', '一起发消息', '0', '2019-10-20 06:38:28', null, '3');
INSERT INTO `word_message_table` VALUES ('52', '3', '0', '2019-10-20 10:16:35', null, '3');
INSERT INTO `word_message_table` VALUES ('53', '终于弄好了，朋友', '0', '2019-10-21 08:45:59', null, '5');
INSERT INTO `word_message_table` VALUES ('54', '恭喜恭喜', '0', '2019-10-21 08:46:20', null, '3');
INSERT INTO `word_message_table` VALUES ('55', '还需要优化，后面再说了，开心', '0', '2019-10-21 08:46:41', null, '5');

-- ----------------------------
-- Table structure for `you_visite_table`
-- ----------------------------
DROP TABLE IF EXISTS `you_visite_table`;
CREATE TABLE `you_visite_table` (
  `id` int(26) NOT NULL AUTO_INCREMENT,
  `user_id` int(26) NOT NULL COMMENT '主人id',
  `visited_id` int(26) NOT NULL COMMENT '璁块棶鑰卛d',
  `visite_time` datetime DEFAULT NULL,
  `is_flag` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of you_visite_table
-- ----------------------------

-- ----------------------------
-- Table structure for `your_follow_table`
-- ----------------------------
DROP TABLE IF EXISTS `your_follow_table`;
CREATE TABLE `your_follow_table` (
  `a_id` int(26) NOT NULL AUTO_INCREMENT,
  `a_user_id` int(26) NOT NULL,
  `a_follow_user_id` int(26) NOT NULL,
  `a_follow_time` datetime DEFAULT NULL,
  `a_is_flag` int(1) DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `1` (`a_user_id`,`a_follow_user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of your_follow_table
-- ----------------------------
INSERT INTO `your_follow_table` VALUES ('1', '3', '4', '2019-09-25 22:54:33', '0');
INSERT INTO `your_follow_table` VALUES ('2', '4', '3', '2019-09-19 22:54:45', '0');
INSERT INTO `your_follow_table` VALUES ('3', '3', '5', '2019-09-28 22:58:21', '0');
INSERT INTO `your_follow_table` VALUES ('4', '3', '10', '2019-10-06 02:41:37', '0');
INSERT INTO `your_follow_table` VALUES ('10', '3', '3', '2019-10-06 03:29:32', '0');
INSERT INTO `your_follow_table` VALUES ('14', '5', '5', '2019-10-07 01:59:39', '0');
INSERT INTO `your_follow_table` VALUES ('15', '5', '10', '2019-10-07 01:59:43', '0');
