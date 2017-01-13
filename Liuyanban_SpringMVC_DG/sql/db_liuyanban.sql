/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : db_liuyanban

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-08-26 19:39:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_message`
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `Messages` varchar(500) NOT NULL,
  `Time` varchar(20) NOT NULL,
  `userId` int(11) NOT NULL,
  `Root` int(11) NOT NULL COMMENT '0根节点 tb_message代表子节点',
  `rootUserId` int(11) NOT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=1046 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('1003', '没事干说啥上午好~', '20160823 14:19:09', '1003', '1001', '1003');
INSERT INTO `tb_message` VALUES ('1004', '我就想说说', '20160823 15:24:33', '1001', '1001', '1003');
INSERT INTO `tb_message` VALUES ('1005', '下午好啊A兄', '20160823 15:38:00', '1001', '0', '1003');
INSERT INTO `tb_message` VALUES ('1011', '我也说一句...', '2016/08/26 01:08:57', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1012', '说你妹啊', '2016/08/26 01:09:14', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1013', '我自己给自己留个言吧', '2016/08/26 01:09:27', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1017', '黄兄晚上好啊', '2016/08/26 01:15:50', '1003', '0', '1001');
INSERT INTO `tb_message` VALUES ('1018', '为啥要给自己说话呢', '2016/08/26 11:37:47', '1003', '1009', '1003');
INSERT INTO `tb_message` VALUES ('1019', '000000', '2016/08/26 11:44:37', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1021', '666', '2016/08/26 11:55:28', '1003', '1001', '1003');
INSERT INTO `tb_message` VALUES ('1022', 'ghjghj', '2016/08/26 12:07:01', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1023', '我也说一句...', '2016/08/26 12:08:07', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1025', '黄兄中午好', '2016/08/26 13:38:18', '1003', '1017', '1001');
INSERT INTO `tb_message` VALUES ('1026', '李晨好啊', '2016/08/26 13:43:41', '1003', '0', '1002');
INSERT INTO `tb_message` VALUES ('1027', '中午好', '2016/08/26 13:47:05', '1003', '1026', '1002');
INSERT INTO `tb_message` VALUES ('1028', '李晨好啊，我是黄渤', '2016/08/26 14:26:00', '1001', '0', '1002');
INSERT INTO `tb_message` VALUES ('1029', '我是黄渤诶', '2016/08/26 14:26:48', '1001', '1028', '1002');
INSERT INTO `tb_message` VALUES ('1030', '李晨好', '2016/08/26 15:11:57', '1001', '1026', '1002');
INSERT INTO `tb_message` VALUES ('1031', '我是陈建琴', '2016/08/26 15:15:22', '1001', '0', '1002');
INSERT INTO `tb_message` VALUES ('1032', '我是是是是', '2016/08/26 15:15:32', '1001', '1031', '1002');
INSERT INTO `tb_message` VALUES ('1033', '我是卢茹', '2016/08/26 15:16:06', '1001', '0', '1002');
INSERT INTO `tb_message` VALUES ('1034', '卢茹回复', '2016/08/26 15:16:24', '1001', '1033', '1002');
INSERT INTO `tb_message` VALUES ('1037', '从容，是一种修练，是镇定自若、安之泰然的心理素质；遇事不急不躁，理智地看待问题，生活和工作中怀揣一颗感恩之心，学会赞美，享受一份从容淡定。', '2016/08/26 15:21:15', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1038', '从容，是一种修练，是镇定自若、安之泰然的心理素质；遇事不急不躁，理智地看待问题，生活和工作中怀揣一颗感恩之心，学会赞美，享受一份从容淡定。', '2016/08/26 15:22:38', '1003', '1005', '1003');
INSERT INTO `tb_message` VALUES ('1039', '从容，是一种修练，是镇定自若、安之泰然的心理素质；遇事不急不躁，理智地看待问题，生活和工作中怀揣一颗感恩之心，学会赞美，享受一份从容淡定。　　　　\n\n此生，最渴望的不是娇艳的鲜花，也不是醉人的掌声，而是生命中的平静和平静中从容。从容的心让世间的喧嚣瞬间静止了，抬头仰望，天高云淡，万物欣然。一直所追慕的，还有一种从容中的淡定。淡定是一种优雅，淡定不是平庸，他是一种生活态度，是智慧的不争，是宠辱不惊，是对简单生活的一种追求！就像秋叶般静美，淡淡地来，淡淡地去，淡淡地相处，给人以宁静，给人以淡淡的欲望，活的简单而有味道。　　　　\n简单的活着，善良、率直、坦荡地行于尘世，就使人有时间有心情去品位人生的滋味，享受人生的乐趣。时间不断流逝，增长的是年龄，成熟的是心智。', '2016/08/26 15:25:03', '1003', '0', '1002');
INSERT INTO `tb_message` VALUES ('1040', '为目标，晚卧夜半，梦别星辰，脚踏实地，凌云舍我其谁!', '2016/08/26 16:56:57', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1041', '为目标，晚卧夜半，梦别星辰，脚踏实地，凌云舍我其谁!', '2016/08/26 16:57:01', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1042', '学练并举，成竹在胸，敢问逐鹿群雄今何在?师生同志，协力攻关，笑看燕赵魁首谁人得。', '2016/08/26 16:57:27', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1043', '竹子用了4年时间，仅仅长了3cm，从第五年开始，以每天30cm的速度疯狂的生长，仅仅用了六周时间就长到了15米。其实在前面的四年，竹子将根在土壤里延伸了数百平米。做人做事亦是如此，不要担心你此时的付出得不到回报，因为这些付出都是为了扎根。人生需要储备!多少人，没熬过那三厘米!', '2016/08/26 16:59:38', '1003', '0', '1003');
INSERT INTO `tb_message` VALUES ('1044', '4234', '2016/08/26 17:04:48', '1003', '0', '1001');
INSERT INTO `tb_message` VALUES ('1045', '诶 艰苦奋斗吧', '2016/08/26 18:00:14', '1003', '1040', '1003');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(10) NOT NULL,
  `Pwd` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Jurisdiction` varchar(10) NOT NULL COMMENT '用户表',
  `Image` varchar(100) NOT NULL COMMENT 'user表',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1001', '1001', '1001', '黄渤', 'user', '/images/User/UserImage/1.gif');
INSERT INTO `tb_user` VALUES ('1002', '1002', '1002', '李晨', 'user', '/images/User/UserImage/2.gif');
INSERT INTO `tb_user` VALUES ('1003', 'admin', 'admin', 'Admin', 'admin', '/images/User/UserImage/3.gif');
