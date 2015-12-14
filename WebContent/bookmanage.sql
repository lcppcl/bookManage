/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : bookmanage

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-12-15 02:57:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` varchar(20) NOT NULL,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('23414', '放入', '热', '人忒特', '123.00', '二个人', 'upload/firmuserPicture/23414_2015-12-13-12-56-10.jpg');
INSERT INTO `book` VALUES ('704013036', '单片机原理及应用 ', '张毅刚', '高等教育', '65.00', '本书详细地介绍了MCS-51单片机的硬件结构、指令系统，从应用的角度介绍了汇编语言程序设计与各种硬件接口设计、各种常用的数据运算和处理程序、接口驱动程序以及MCS-51单片机应用系统的设计，并对MCS-51单片机应用系统设计中的抗干扰技术以及各种新器件也作了详细的介绍。本书突出了选取内容的实用性、典型性。书中的应用实例，大多来自科研工作及教学实践，且经过检验，内容丰富、详实。', 'upload/firmuserPicture/704013036_2015-12-09-04-55-54.jpg');
INSERT INTO `book` VALUES ('9787111300021', '软件工程教程233', '孙永', '机械工业出版社', '34.00', '本书全面系统地介绍了软件工程的有关概念、原则、方法和工具。全书共15章,内容包括:软件工程中面向过程、面向对象的开发方法,技术度量,质量保证,软件项目计划与管理,用统一建模语言uml开发软件的方法等。另外,还对设计模式、敏捷软件开发、web工程等软件工程相关领域进行了介绍和讨论。本书既注重科学性和系统性,又注重实用性和新颖性。 本书可作为大学计算机及相关专业本(专)科学生的教材或教学参考书,也可作为研究生的参考教材。 ', 'upload/firmuserPicture/9787111300021_2015-12-09-06-01-01.jpg');
INSERT INTO `book` VALUES ('9787111300024', '操作系统', '谢青松', '机械工业出版社', '54.00', '《操作系统原理》操作系统是计算机系统中最重要的系统软件，也是计算机专业的核心课程。本书用通俗的语言、生动的图片、丰富的例题介绍了操作系统经典的设计原理和最新的发展成果，还结合主流操作系统平台，组织了多个丰富而有趣的实验内容，安排了大量各种难度的练习题，并附有参考答案，以便于自学、选讲或考研复习。', 'upload/firmuserPicture/9787111300024_2015-12-09-04-44-31.jpg');
INSERT INTO `book` VALUES ('9787111469201', '计算机学科专业基础综合', '杨维', '清华大学出版社', '66.00', '2009年研究生招生考试计算机专业课初试首次实行全国统一命题。报考计算机科学与技术学科者，考计算机学科专业基础综合（考试时间3小时，满分为150分）。从2009年起，计算机科学与技术学科专业基础综合实行联合命题，命题工作由中国学位与研究生教育学会工科委员会在教育部考试中心指导下组织实施。', 'upload/firmuserPicture/9787111469201_2015-12-09-05-00-42.jpg');
INSERT INTO `book` VALUES ('9787111469209', '图解css', '廖伟华', '机械工业出版社', '54.00', '本书是CSS3领域的标准性著作，由资深Web前端工程师根据CSS3的最新技术标准撰写。内容极为全面、丰富和翔实，由浅入深地讲解了CSS3新特性的语法、功能和使用技巧，涵盖选择器、边框、背景、文本、颜色、UI、动画、新型盒模型、媒体查询、响应式设计等各种模块；写作方式创新，有趣且易懂，用图解的方式来描述CSS3的每一个特性甚至每一个步骤都配有实战效果图；', 'upload/firmuserPicture/9787111469209_2015-12-09-04-50-50.jpg');
INSERT INTO `book` VALUES ('9787122208682', '计算机英语', '苏兵，张淑荣', '清华大学', '23.00', '计算机英语与其他专业英语的最大区别就在于它的“日新月异”，特点也不少：客观、严谨、准确、精练，专业术语多，缩略语经常出现，合成的新词多，介词短语、分词短语和名词性词组使用频繁，长句、祈使句和被动语态使用较多，方程与数字占有一定比列。因此要学好计算机英语，首先要不断地学习新的计算机技术，这样才能对相关内容有很好的理解，对于不断出现的新的计算机专业词汇要注意理解和记忆，在了解技术的基础上，结合对词汇的掌握就能很好地理解，多积累，就能不断提高自己的计算机英语的水平。', 'upload/firmuserPicture/9787122208682_2015-12-09-04-47-01.jpg');
INSERT INTO `book` VALUES ('9787302266587', '网络工程师教程', '雷震甲', '清华大学出版社', '65.00', '根据新的网络工程师考试大纲，这次修订版时对原书内容进行了部分调整。对基础知识部分进行了简化，对应用技术部分进行了改写，突出了网络服务器的配置、路由器和交换机的配置、以及网络安全和网络管理等实用技术', 'upload/firmuserPicture/9787302266587_2015-12-09-04-48-17.jpg');
INSERT INTO `book` VALUES ('9787508415540', '中文windows7操作系统', '孙永', '机械工业出版社', '76.00', 'Windows 7可供家庭及商业工作环境、笔记本电脑、平板电脑、多媒体中心等使用。Windows 7也延续了Windows Vista的Aero 风格，并且在此基础上增添了些许功能。\r\nWindows 7可供选择的版本有：简易版（Starter）、普通家庭版（Home Basic）、高级家庭版（Home Premium）、专业版（Professional）、企业版（Enterprise）（非零售）、旗舰版（Ultimate）。[2] ', 'upload/firmuserPicture/9787508415540_2015-12-09-04-54-18.jpg');
INSERT INTO `book` VALUES ('9787508415543', '计算机科学技术导论', '葛建梅', ' 中国水利水电出版社', '76.00', '本书系统地介绍了计算机科学技术的基础知识、基本概念、基本原理、计算机科学技术的总体结构及学科方向和适应领域。全书共分10章，内容涵盖了计算机科学技术专业主干课程的核心知识，主要内容包括：计算机科学技术的基础知识，计算机硬件系统、软件系统，计算机网络与通信，数据库系统与信息系统，多媒体技术，计算机安全技术，计算机科学技术的研究范畴及其在各领域中的应用，计算机科学技术学科适应领域与择业，计算机常用软件介绍。', 'upload/firmuserPicture/9787508415543_2015-12-09-04-52-03.jpg');

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `bookid` varchar(255) NOT NULL,
  `lenderid` varchar(255) NOT NULL,
  `lTime` datetime DEFAULT NULL,
  `RTime` datetime DEFAULT NULL,
  KEY `bookid` (`bookid`),
  KEY `lenderid` (`lenderid`),
  CONSTRAINT `lend_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `book` (`isbn`),
  CONSTRAINT `lend_ibfk_2` FOREIGN KEY (`lenderid`) REFERENCES `user` (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------
INSERT INTO `lend` VALUES ('704013036', '000000', '2015-12-09 06:04:16', '2016-01-09 06:04:16');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `readerId` varchar(8) NOT NULL,
  `name` varchar(8) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `spec` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('000000', '鹤轩', '1', null, null, '1', '000000');
INSERT INTO `user` VALUES ('201332', '越泽', '1', '市场营销', null, '0', '201332');
INSERT INTO `user` VALUES ('201333', '天佑', '0', '城市规划', null, '0', '201333');
INSERT INTO `user` VALUES ('201334', '文昊', '0', '社会学', null, '0', '201334');
INSERT INTO `user` VALUES ('201335', '俊驰', '1', '侦查学', null, '0', '201335');
INSERT INTO `user` VALUES ('201336', '雨泽', '1', '小语种', null, '0', '201336');
INSERT INTO `user` VALUES ('201337', '修洁', '0', '外贸英语', null, '0', '201337');
INSERT INTO `user` VALUES ('201338', '睿渊', '0', '外贸英语', null, '0', '201338');
