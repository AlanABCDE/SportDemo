/*
Navicat MySQL Data Transfer

Source Server         : Sayoka
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : sports

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2023-03-03 14:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) DEFAULT NULL,
  `edate` date DEFAULT NULL,
  `etime` time DEFAULT NULL,
  `eplace` varchar(255) DEFAULT NULL,
  `edis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('1', 'basketball', '2023-02-22', '08:00:00', 'Basketball Court 1', 'a basketball match');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000001', 'user01', '男', '111111', 'user', null);
INSERT INTO `user` VALUES ('0000000002', 'admin', '男', 'aaaaaa', 'admin', null);
INSERT INTO `user` VALUES ('0000000003', 'admin2', '女', '111111', 'admin', '1@sport.com');
INSERT INTO `user` VALUES ('0000000004', '94', null, '111111', null, null);
INSERT INTO `user` VALUES ('0000000005', 'duoma', null, '111111', null, null);
INSERT INTO `user` VALUES ('0000000006', '33', null, '111111', null, null);
INSERT INTO `user` VALUES ('0000000007', 'Godlexzzy', null, '111111', null, null);
INSERT INTO `user` VALUES ('0000000008', 'ChenRui', '男', '111111', 'user', null);
INSERT INTO `user` VALUES ('0000000009', 'God_Lian', '男', '111111', 'user', 'God@wsnd.com');
INSERT INTO `user` VALUES ('0000000012', 'Dolphin', '女', '111111', 'user', 'Shao@bei.com');
INSERT INTO `user` VALUES ('0000000013', 'Niyan', '男', '111111', 'user', null);
