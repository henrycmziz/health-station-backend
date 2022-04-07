/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 116.62.205.26:3307
 Source Schema         : health_station

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 07/04/2022 14:02:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biz_health_article
-- ----------------------------
DROP TABLE IF EXISTS `biz_health_article`;
CREATE TABLE `biz_health_article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `article_from` tinyint(1) NOT NULL DEFAULT 0 COMMENT '小知识来源；默认0：自建，1：网络',
  `article` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'article_from=0时, 正文',
  `article_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'article_from=1时, 小知识url',
  `thumbnail` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '缩略图',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态; 1:启用, 0:停用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康小知识维护表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of biz_health_article
-- ----------------------------
INSERT INTO `biz_health_article` VALUES (1, '腰椎间盘突出症锻炼的必要性', 0, '<p style=\"text-align: center; line-height: 2;\"><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/69d1b76f-b682-4db0-a8a1-fed92d19c586.jpeg\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p style=\"line-height: 2;\"><span style=\"font-size: 16px; font-family: 楷体;\">&nbsp;&nbsp;&nbsp;&nbsp;坚持锻炼可加强腰背肌功能锻炼、增强核心肌群,能明显改善腰椎间盘突出症患者临床症状,增强腰部活动功能。我科康复锻炼运动模型是周氏伤科经过近百年的传承、发展和创新的基础上，并结合训练核心肌群的方法，演变而来的一套功法，在临床应用中具有良好疗效，究其原因，概因通过锻炼，增强了腰背部核心肌群力量，腰部气血旺盛充盈，气有温煦，血有营养、滋润的效果，气血旺盛则可温肾助阳、筋强骨健、其病自消。且正气内存、邪不可干，则外邪难以入侵，经络气血运行通畅，进入良性循环。</span></p>', NULL, NULL, 1, 'admin', '2022-03-19 23:41:58', 'admin', '2022-03-20 16:23:20');
INSERT INTO `biz_health_article` VALUES (2, '诱发腰突产生的因素都有哪些？', 0, '<p style=\"text-align: center; line-height: 1.5;\"><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/4011a811-4bc9-4302-b3d1-df02eb8c42d9.jpg\" alt=\"\" data-href=\"\" style=\"width: 30%;\"></p><p style=\"line-height: 1.5;\"><span style=\"font-size: 16px; font-family: 华文仿宋;\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\"line-height: 1.5;\"><span style=\"font-size: 16px; font-family: 华文仿宋;\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\"line-height: 1.5;\"><span style=\"font-size: 16px; font-family: 华文仿宋;\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>', NULL, NULL, 1, 'admin', '2022-03-19 23:50:20', 'admin', '2022-03-20 16:25:44');
INSERT INTO `biz_health_article` VALUES (3, '这20条的健康小知识，每个人都应该看一看，看到就是赚到', 0, '<p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">我们每个人都希望自己身体健康，然后能够长寿！但是很多人都搞不懂自己的身体！在手机上经常能够看到大批的健康小常识，不知道哪些是正确的，哪些是错误的！下面噜噜给大家说点健康小常识！这些都是医生才知道的！都在这里了！&nbsp;</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">1、低头玩手机增加颈椎的重量。当头部弯曲大于60度的是，颈椎承受的力量大约为45斤。</span></p><p style=\"text-indent: 0px; text-align: center; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">&nbsp;</span><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/a36d3f2f-028b-4848-959a-0d7bd0bc8f3d.png\" alt=\"\" data-href=\"\" style=\"width: 30%;\"></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">2、仙人掌防辐射。仙人掌能够抵挡太阳的光线、紫外线的辐射，但是与电脑屏幕中的辐射不相同。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">3、吃到食物相克。有研究表示，人们在生活中吃到“相克”的食物，不会对身体产生太大的影响。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">4、老咬舌头是中风。老人总是说咬舌头是想吃肉了，如果发现经常咬住舌头，可能就会发生中风，大脑神经被压迫不能正常流通。一定要注意！</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">5、擦屁股是从前往后。尤其是女孩子，擦粪便的时候要从前往后擦，顺序为，尿道，阴道，肛门，这几种器官的抵抗病毒的作用依次增强。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">6、刷牙要刷舌头。舌头表面也会有细菌的滋生，长时间不刷舌头，会使得细菌侵害牙齿、牙龈，所以一定要轻轻刷舌头。</span></p><p style=\"text-indent: 0px; text-align: center; line-height: 22.5px;\"><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/148ae11f-a35d-4a31-a874-3715b25b32db.png\" alt=\"\" data-href=\"\" style=\"width: 30%;\"><span style=\"font-size: 21px; font-family: 仿宋;\">&nbsp;</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">7、泡脚水温不要过烫。水温为40度最好，太高的水温容易造成心脑血管疾病，刺激脚底神经系统，对温度的感知出现变化。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">8、煲汤时间不要过长。尤其是高汤炖的时候太长，容易增加嘌呤的含量，进而会出现高尿酸和痛风的情况，并且也会将食物中的营养成分流失。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">9、运动时别用嘴呼吸。在剧烈跑步的时候，用鼻子吸气，嘴凸起，这样能够避免出现冷空气进入咽喉，会刺激呼吸道。</span></p><p style=\"text-indent: 0px; text-align: center; line-height: 22.5px;\"><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/7cb56de7-1fd4-40b3-867f-3bf376da6233.png\" alt=\"\" data-href=\"\" style=\"width: 30%;\"><span style=\"font-size: 21px; font-family: 仿宋;\">&nbsp;</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">10、豆浆不能代替牛奶。虽然这两种食物中都含有钙元素，但是豆浆中的钙低于牛奶中的钙。对中老年人来说，多喝牛奶比较好。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">11、眼药水不能滴在眼球上面。如果把眼药水滴在眼球上，会刺激是视角膜，及时眨眼的频率，就会导致药物流失。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">12、运动后坐下屁股不会变大。生活中能够让屁股变大的因素只有通过锻炼身体，长时间的坐不运动也会出现屁股变大，而运动后坐下屁股不会变大。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">13、补充胶原蛋白不如吃鸡蛋。女性都是要补充胶原蛋白，真正的补充蛋白质，不如每天多吃一个鸡蛋吧。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">14、掉一根头发长出十根头发。能不能长出头发，与身体的素质，和体内分泌的黑色素有关，与掉头发长头发没有关系。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">15、乳腺增生不用治。如果体检的话，女性十个九个都有乳腺增生的情况，一般都是良性的，一定要注意上医院检查就行。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">16、最有效的止咳方式吃糖。咳嗽时吃糖能够在喉咙中形成保护膜，缓解对喉咙的伤害。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">17、脚气是一种全身性疾病。虽然脚气出现在脚上，但是，通常全身都有真菌的存在，这个需要上医院诊断和药物的结合。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">18、胃溃疡和吃什么东西关系不大。这种疾病的形成原因主要是幽门螺杆菌的存在，通过抗酸剂可以治疗！不要吃辛辣刺激的食物。</span></p><p style=\"text-indent: 0px; text-align: center; line-height: 22.5px;\"><img src=\"http://116.62.205.26/prod-api/profile/articleResource/20220320/5c00a78a-9902-4bb9-933b-44ccc4ef1b57.png\" alt=\"\" data-href=\"\" style=\"width: 30%;\"><span style=\"font-size: 21px; font-family: 仿宋;\">&nbsp;</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">19、流鼻血仰头没用。仰头只会让鼻血流入嘴里，进而通过咳嗽咳出来。出血量大，容易被吸入气管中和肺部中。</span></p><p style=\"text-align: justify; line-height: 22.5px;\"><span style=\"font-size: 21px; font-family: 仿宋;\">20、腹泻不要禁食。腹泻的时候，身体的抵抗力和免疫力比较脆弱，一定要吃点东西，让身体恢复体力，才能让腹泻减轻。</span></p>', NULL, NULL, 1, 'admin', '2022-03-20 16:26:05', 'admin', '2022-03-20 16:57:31');
INSERT INTO `biz_health_article` VALUES (4, '2022年收藏这50条健康知识，照着做健康一整年！', 1, '', 'http://wsjkw.sc.gov.cn/scwsjkw/jkys/2022/1/18/b3ee3f5c5b5e4dcaa8110df94e8a7648.shtml', NULL, 1, 'admin', '2022-03-20 17:41:50', '', '2022-03-20 17:41:50');
INSERT INTO `biz_health_article` VALUES (5, '夜跑、晨跑，到底怎么跑？春天甩肉可别“跑偏”！', 1, '', 'http://wsjkw.sc.gov.cn/scwsjkw/jkys/2022/3/1/11ee8fc8a1894a52a3941da794ca3771.shtml', NULL, 1, 'admin', '2022-03-20 17:42:39', 'admin', '2022-03-20 21:59:30');

-- ----------------------------
-- Table structure for biz_video_lib
-- ----------------------------
DROP TABLE IF EXISTS `biz_video_lib`;
CREATE TABLE `biz_video_lib`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `video_url` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频url',
  `extend_type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件拓展名',
  `file_name` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名称',
  `video_thumbnail_url` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频缩略图url',
  `video_duration` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频时长',
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '锻炼视频说明',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '视频状态; 默认1:正常, 0:停用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of biz_video_lib
-- ----------------------------
INSERT INTO `biz_video_lib` VALUES (1, '/profile/video/20220227/077888d2-12c6-4299-af97-556b2f442d1f.mp4', 'mp4', '武当秘传三十六式太极拳', '/profile/video/20220227/077888d2-12c6-4299-af97-556b2f442d1f_sc1.jpg', '04:11', '太极拳学习视频', 0, 'admin', '2022-02-27 19:37:17', '', '2022-02-28 21:00:53');

-- ----------------------------
-- Table structure for biz_wj_answer
-- ----------------------------
DROP TABLE IF EXISTS `biz_wj_answer`;
CREATE TABLE `biz_wj_answer`  (
  `answer_id` int NOT NULL AUTO_INCREMENT COMMENT '答案ID',
  `question_id` bigint NOT NULL COMMENT '问题ID',
  `questionnaire_id` bigint NOT NULL COMMENT '问卷ID',
  `user_id` bigint NOT NULL COMMENT '答题人ID',
  `write_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '答案值',
  `fill_time` datetime NULL DEFAULT NULL COMMENT '填充时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '问卷答案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biz_wj_answer
-- ----------------------------

-- ----------------------------
-- Table structure for biz_wj_question
-- ----------------------------
DROP TABLE IF EXISTS `biz_wj_question`;
CREATE TABLE `biz_wj_question`  (
  `question_id` bigint NOT NULL COMMENT '问题id',
  `questionnaire_id` bigint NOT NULL COMMENT '所属问卷ID',
  `question_index` int NULL DEFAULT NULL COMMENT '问题索引',
  `question_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '问题标题',
  `question_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '问题描述',
  `question_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '问题类型',
  `question_nullable` bit(1) NULL DEFAULT b'1' COMMENT '是否可空(默认1:可空, 0:不可空)',
  `details` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '问题详细',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '问卷问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biz_wj_question
-- ----------------------------
INSERT INTO `biz_wj_question` VALUES (1000, 1, 0, '单选题', '单选题demo', 'single_check', b'0', '{\"date\":\"2022-04-07T05:41:51.480Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":5,\"questionOptions\":[\"选项1\",\"选项2\",\"选项3\",\"选项4\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');
INSERT INTO `biz_wj_question` VALUES (1001, 1, 1, '多选题', '多选题demo', 'multi_check', b'0', '{\"date\":\"2022-04-07T05:42:46.688Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":5,\"questionOptions\":[\"选项1\",\"选项2\",\"选项3\",\"选项4\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');
INSERT INTO `biz_wj_question` VALUES (1002, 1, 2, '单行文本', '单行文本demo', 'single_line_text', b'0', '{\"date\":\"2022-04-07T05:43:28.160Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":5,\"questionOptions\":[\"\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');
INSERT INTO `biz_wj_question` VALUES (1003, 1, 3, '多行文本', '多行文本demo', 'multi_line_text', b'1', '{\"date\":\"2022-04-07T05:43:37.805Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":5,\"questionOptions\":[\"\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');
INSERT INTO `biz_wj_question` VALUES (1004, 1, 4, '数字', '数字demo', 'number', b'0', '{\"date\":\"2022-04-07T05:43:47.099Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":5,\"questionOptions\":[\"\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');
INSERT INTO `biz_wj_question` VALUES (1005, 1, 5, '评分', '评分demo', 'grade', b'0', '{\"date\":\"2022-04-07T05:44:09.445Z\",\"frontOptions\":[[]],\"numberType\":\"integer\",\"defaultNumber\":0,\"frontChoose\":false,\"gradeMax\":6,\"questionOptions\":[\"\"],\"textDescription\":\"\"}', '', '2022-04-07 13:44:35', '', '2022-04-07 13:44:35');

-- ----------------------------
-- Table structure for biz_wj_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `biz_wj_questionnaire`;
CREATE TABLE `biz_wj_questionnaire`  (
  `questionnaire_id` bigint NOT NULL AUTO_INCREMENT COMMENT '问卷ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '请输入标题' COMMENT '问卷标题',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '问卷描述',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开放时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '关闭时间',
  `fill_count` bigint NULL DEFAULT 0 COMMENT '填充数字',
  `status` enum('COLLECTING','EDITING','CLOSED') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`questionnaire_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '问卷概要表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biz_wj_questionnaire
-- ----------------------------
INSERT INTO `biz_wj_questionnaire` VALUES (1, '问卷demo', '问卷demo', NULL, NULL, 0, 'EDITING', 'admin', '2022-04-07 13:41:49', 'admin', '2022-04-07 13:44:35');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob NULL COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Blob类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日历信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Cron类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint NOT NULL COMMENT '触发的时间',
  `sched_time` bigint NOT NULL COMMENT '定时器制定的时间',
  `priority` int NOT NULL COMMENT '优先级',
  `state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '已触发的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'cn.henry.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001D636E2E68656E72792E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720026636E2E68656E72792E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D9A02037878707400007070707400013174000E302F3130202A202A202A202A203F74001172795461736B2E72794E6F506172616D7374000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'cn.henry.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001D636E2E68656E72792E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720026636E2E68656E72792E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D9A02037878707400007070707400013174000E302F3135202A202A202A202A203F74001572795461736B2E7279506172616D7328277279272974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000002740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 'cn.henry.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001D636E2E68656E72792E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720026636E2E68656E72792E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D9A02037878707400007070707400013174000E302F3230202A202A202A202A203F74003872795461736B2E72794D756C7469706C65506172616D7328277279272C20747275652C20323030304C2C203331362E3530442C203130302974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000003740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E5A49AE58F82EFBC8974000133740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存储的悲观锁信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '暂停的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '调度器状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', '824aa95b185d1644822560254', 1645878117469, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '简单触发器的信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int NULL DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int NULL DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint NULL DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint NULL DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '同步机制的行锁表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint NULL DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint NULL DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int NULL DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器的类型',
  `start_time` bigint NOT NULL COMMENT '开始时间',
  `end_time` bigint NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint NULL DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name` ASC, `job_name` ASC, `job_group` ASC) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '触发器详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1645363030000, -1, 5, 'PAUSED', 'CRON', 1645363025000, 0, NULL, 2, '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1645363035000, -1, 5, 'PAUSED', 'CRON', 1645363025000, 0, NULL, 2, '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 1645363040000, -1, 5, 'PAUSED', 'CRON', 1645363026000, 0, NULL, 2, '');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2021-12-08 20:26:03', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2021-12-08 20:26:03', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2021-12-08 20:26:03', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2021-12-08 20:26:03', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2021-12-08 20:26:03', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 203 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '小智康复驿站', 0, 'Henry', '15888888888', 'henrycmziz@gmail.com', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:11:48');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '研发部门', 1, '', '', '', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:17:03');
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '小智医院', 2, '', '', '', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:22:09');
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '后端开发', 1, '', '', '', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:13:48');
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '测试', 2, NULL, NULL, NULL, '0', '0', 'admin', '2022-01-12 15:21:01', 'admin', '2022-01-12 15:21:13');
INSERT INTO `sys_dept` VALUES (105, 102, '0,100,102', '大夫', 1, '', '', '', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:22:15');
INSERT INTO `sys_dept` VALUES (106, 102, '0,100,102', '护士', 2, '', '', '', '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2021-12-29 16:22:37');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2021-12-08 20:26:02', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2021-12-08 20:26:03', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2021-12-08 20:26:03', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2021-12-08 20:26:03', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2014 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2021-12-08 20:26:01', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2021-12-08 20:26:01', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2021-12-08 20:26:01', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2021-12-08 20:26:01', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2021-12-08 20:26:02', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2021-12-08 20:26:02', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2021-12-08 20:26:02', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2021-12-08 20:26:02', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2021-12-08 20:26:02', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2021-12-08 20:26:02', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2021-12-08 20:26:02', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2021-12-08 20:26:02', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2021-12-08 20:26:02', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2021-12-08 20:26:02', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2021-12-08 20:26:02', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2021-12-08 20:26:02', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2021-12-08 20:26:02', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2021-12-08 20:26:02', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2021-12-08 20:26:02', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'knife4j', 'tool/knife4j/index', '', 1, 0, 'C', '0', '0', 'tool:knife4j:list', 'knife4j', 'admin', '2021-12-08 20:26:02', 'admin', '2021-12-28 21:49:50', '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2021-12-08 20:26:02', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2021-12-08 20:26:02', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2021-12-08 20:26:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '资源管理', 0, 4, 'resource', NULL, NULL, 1, 0, 'M', '0', '0', '', 'resource', 'admin', '2022-02-19 15:43:54', 'admin', '2022-02-19 16:24:33', '');
INSERT INTO `sys_menu` VALUES (2001, '视频管理', 2000, 1, 'video', 'resource/video/index', NULL, 1, 0, 'C', '0', '0', 'resource:video:list', 'video', 'admin', '2022-02-19 15:58:34', 'admin', '2022-02-19 16:22:57', '');
INSERT INTO `sys_menu` VALUES (2003, '视频信息查询', 2001, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:video:query', '#', 'admin', '2022-02-22 13:30:39', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '视频新增', 2001, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:video:add', '#', 'admin', '2022-02-22 13:30:39', 'admin', '2022-02-22 13:35:03', '');
INSERT INTO `sys_menu` VALUES (2005, '视频信息修改', 2001, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:video:edit', '#', 'admin', '2022-02-22 13:30:39', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '视频删除', 2001, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:video:remove', '#', 'admin', '2022-02-22 13:30:39', 'admin', '2022-02-22 13:35:10', '');
INSERT INTO `sys_menu` VALUES (2007, '视频信息导出', 2001, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:video:export', '#', 'admin', '2022-02-22 13:30:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2008, '健康小知识', 2000, 1, 'article', 'resource/article/index', NULL, 1, 0, 'C', '0', '0', 'resource:article:list', 'article', 'admin', '2022-03-04 15:28:27', 'admin', '2022-03-08 19:18:36', '健康小知识菜单');
INSERT INTO `sys_menu` VALUES (2009, '健康小知识查询', 2008, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:article:query', '#', 'admin', '2022-03-04 15:28:27', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2010, '健康小知识新增', 2008, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:article:add', '#', 'admin', '2022-03-04 15:28:27', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2011, '健康小知识修改', 2008, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:article:edit', '#', 'admin', '2022-03-04 15:28:27', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '健康小知识删除', 2008, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:article:remove', '#', 'admin', '2022-03-04 15:28:27', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2013, '健康小知识导出', 2008, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'resource:article:export', '#', 'admin', '2022-03-04 15:28:27', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2014, '调查问卷', 0, 5, 'questionnaire', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'questionnaire', 'admin', '2022-03-24 15:10:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2015, '问卷列表', 2014, 1, 'collection', 'questionnaire/collection/index', NULL, 1, 1, 'C', '0', '0', '', 'list', 'admin', '2022-03-24 15:14:38', 'admin', '2022-03-31 19:01:59', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, '视频上传', 1, 'cn.henry.resource.controller.VideoLibController.upload()', 'POST', 1, 'admin', NULL, '/resource/video/upload', '122.238.114.40', 'XX XX', '', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-27 19:37:17');
INSERT INTO `sys_oper_log` VALUES (2, '视频信息', 2, 'cn.henry.resource.controller.VideoLibController.edit()', 'PUT', 1, 'admin', NULL, '/resource/video', '122.238.114.40', 'XX XX', '{\"fileName\":\"武当秘传三十六式太极拳\",\"remark\":\"太极拳学习视频\",\"id\":1,\"status\":\"0\"}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-02-28 21:00:54');
INSERT INTO `sys_oper_log` VALUES (3, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220319/529bd487-12e9-4f10-93cd-163e9be31257.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-19 17:22:28');
INSERT INTO `sys_oper_log` VALUES (4, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 17:23:29');
INSERT INTO `sys_oper_log` VALUES (5, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647681809000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"createBy\":\"admin\",\"createTime\":1647681809000,\"updateBy\":\"admin\",\"id\":1,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 17:24:18');
INSERT INTO `sys_oper_log` VALUES (6, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647681858000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"createBy\":\"admin\",\"createTime\":1647681809000,\"updateBy\":\"admin\",\"id\":1,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 18:06:38');
INSERT INTO `sys_oper_log` VALUES (7, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 18:09:45');
INSERT INTO `sys_oper_log` VALUES (8, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647684585000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"createTime\":1647684585000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 18:11:23');
INSERT INTO `sys_oper_log` VALUES (9, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647684683000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"createTime\":1647684585000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 18:12:03');
INSERT INTO `sys_oper_log` VALUES (10, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647684683000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"createTime\":1647684585000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 18:13:00');
INSERT INTO `sys_oper_log` VALUES (11, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647684683000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"createTime\":1647684585000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 23:37:10');
INSERT INTO `sys_oper_log` VALUES (12, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647684683000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"createBy\":\"admin\",\"createTime\":1647684585000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 23:38:00');
INSERT INTO `sys_oper_log` VALUES (13, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"article\":\"<p style=\\\"line-height: 2;\\\"><span style=\\\"font-size: 16px; font-family: 楷体;\\\">&nbsp;&nbsp;&nbsp;&nbsp;坚持锻炼可加强腰背肌功能锻炼、增强核心肌群,能明显改善腰椎间盘突出症患者临床症状,增强腰部活动功能。我科康复锻炼运动模型是周氏伤科经过近百年的传承、发展和创新的基础上，并结合训练核心肌群的方法，演变而来的一套功法，在临床应用中具有良好疗效，究其原因，概因通过锻炼，增强了腰背部核心肌群力量，腰部气血旺盛充盈，气有温煦，血有营养、滋润的效果，气血旺盛则可温肾助阳、筋强骨健、其病自消。且正气内存、邪不可干，则外邪难以入侵，经络气血运行通畅，进入良性循环。</span></p>\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 23:41:58');
INSERT INTO `sys_oper_log` VALUES (14, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220319/eebdd158-b3e8-4b5b-9a91-2084f46549a4.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-19 23:46:36');
INSERT INTO `sys_oper_log` VALUES (15, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/profile/articleResource/20220319/eebdd158-b3e8-4b5b-9a91-2084f46549a4.jpeg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 50%;\\\"></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-19 23:50:20');
INSERT INTO `sys_oper_log` VALUES (16, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647705020000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"text-align: center; line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220319/eebdd158-b3e8-4b5b-9a91-2084f46549a4.jpeg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 50%;\\\"></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 11:22:07');
INSERT INTO `sys_oper_log` VALUES (17, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/91b30898-06da-46dc-b5e9-73b2f3b66f1d.png\"},\"errno\":0}', 0, NULL, '2022-03-20 12:32:56');
INSERT INTO `sys_oper_log` VALUES (18, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647746527000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"text-align: center; line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220319/eebdd158-b3e8-4b5b-9a91-2084f46549a4.jpeg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 50%;\\\"></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p><p style=\\\"line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26:8080/profile/articleResource/20220320/91b30898-06da-46dc-b5e9-73b2f3b66f1d.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"\\\"></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 12:33:40');
INSERT INTO `sys_oper_log` VALUES (19, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/3f1fe6b9-778b-4284-a136-137a7f94ba87.png\"},\"errno\":0}', 0, NULL, '2022-03-20 14:23:09');
INSERT INTO `sys_oper_log` VALUES (20, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/bfd120c4-e4b1-4c1d-bf9e-3e738ff9ed20.png\"},\"errno\":0}', 0, NULL, '2022-03-20 14:25:21');
INSERT INTO `sys_oper_log` VALUES (21, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/63f81a27-ca33-412b-a26a-89c4d775d11e.png\"},\"errno\":0}', 0, NULL, '2022-03-20 15:12:21');
INSERT INTO `sys_oper_log` VALUES (22, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/4c656ab3-1874-49a3-ac2a-04e4c7b53ffc.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:16:29');
INSERT INTO `sys_oper_log` VALUES (23, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/dec246dd-e5ec-445c-9ae0-6186cd1f4275.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:25:04');
INSERT INTO `sys_oper_log` VALUES (24, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647750820000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 15:32:44');
INSERT INTO `sys_oper_log` VALUES (25, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/9dd0ec45-496d-4a3f-893b-2d719972a836.jpg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:34:08');
INSERT INTO `sys_oper_log` VALUES (26, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/a0d49b76-1ba2-4406-a0c9-82b5e1a16842.jpg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:38:47');
INSERT INTO `sys_oper_log` VALUES (27, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/96edf6fc-d491-4d32-a45b-66b37cfc7e63.jpg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:42:18');
INSERT INTO `sys_oper_log` VALUES (28, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647704518000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"article\":\"<p style=\\\"line-height: 2;\\\"><img src=\\\"http://116.62.205.26/profile/articleResource/20220320/96edf6fc-d491-4d32-a45b-66b37cfc7e63.jpg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"\\\"></p><p style=\\\"line-height: 2;\\\"><span style=\\\"font-size: 16px; font-family: 楷体;\\\">&nbsp;&nbsp;&nbsp;&nbsp;坚持锻炼可加强腰背肌功能锻炼、增强核心肌群,能明显改善腰椎间盘突出症患者临床症状,增强腰部活动功能。我科康复锻炼运动模型是周氏伤科经过近百年的传承、发展和创新的基础上，并结合训练核心肌群的方法，演变而来的一套功法，在临床应用中具有良好疗效，究其原因，概因通过锻炼，增强了腰背部核心肌群力量，腰部气血旺盛充盈，气有温煦，血有营养、滋润的效果，气血旺盛则可温肾助阳、筋强骨健、其病自消。且正气内存、邪不可干，则外邪难以入侵，经络气血运行通畅，进入良性循环。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647704518000,\"updateBy\":\"admin\",\"id\":1,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 15:42:42');
INSERT INTO `sys_oper_log` VALUES (29, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/e01df5ea-3a60-4723-8f7b-f5d85c27c731.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:46:22');
INSERT INTO `sys_oper_log` VALUES (30, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647761564000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"text-align: center; line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/e01df5ea-3a60-4723-8f7b-f5d85c27c731.jpeg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 15:46:58');
INSERT INTO `sys_oper_log` VALUES (31, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/749d58b7-d147-4507-814d-91bcdf7b7c2b.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:54:09');
INSERT INTO `sys_oper_log` VALUES (32, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647762162000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"article\":\"<p style=\\\"line-height: 2;\\\"><br></p><p style=\\\"line-height: 2;\\\"><span style=\\\"font-size: 16px; font-family: 楷体;\\\">&nbsp;&nbsp;&nbsp;&nbsp;坚持锻炼可加强腰背肌功能锻炼、增强核心肌群,能明显改善腰椎间盘突出症患者临床症状,增强腰部活动功能。我科康复锻炼运动模型是周氏伤科经过近百年的传承、发展和创新的基础上，并结合训练核心肌群的方法，演变而来的一套功法，在临床应用中具有良好疗效，究其原因，概因通过锻炼，增强了腰背部核心肌群力量，腰部气血旺盛充盈，气有温煦，血有营养、滋润的效果，气血旺盛则可温肾助阳、筋强骨健、其病自消。且正气内存、邪不可干，则外邪难以入侵，经络气血运行通畅，进入良性循环。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647704518000,\"updateBy\":\"admin\",\"id\":1,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 15:57:29');
INSERT INTO `sys_oper_log` VALUES (33, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/502c06a6-82e0-4f40-8fcd-57a592a01d1f.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 15:57:47');
INSERT INTO `sys_oper_log` VALUES (34, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/a9d9f52d-1717-4b64-9389-f15d946aab1a.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 16:12:54');
INSERT INTO `sys_oper_log` VALUES (35, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '127.0.0.1', '内网IP', '', '{\"data\":{\"url\":\"http://116.62.205.26:8080/profile/articleResource/20220320/b9052c4f-b8cf-43b8-89bd-0778e89c52c1.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 16:13:57');
INSERT INTO `sys_oper_log` VALUES (36, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/69d1b76f-b682-4db0-a8a1-fed92d19c586.jpeg\"},\"errno\":0}', 0, NULL, '2022-03-20 16:22:51');
INSERT INTO `sys_oper_log` VALUES (37, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647763049000,\"params\":{},\"title\":\"腰椎间盘突出症锻炼的必要性\",\"article\":\"<p style=\\\"text-align: center; line-height: 2;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/69d1b76f-b682-4db0-a8a1-fed92d19c586.jpeg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 50%;\\\"></p><p style=\\\"line-height: 2;\\\"><span style=\\\"font-size: 16px; font-family: 楷体;\\\">&nbsp;&nbsp;&nbsp;&nbsp;坚持锻炼可加强腰背肌功能锻炼、增强核心肌群,能明显改善腰椎间盘突出症患者临床症状,增强腰部活动功能。我科康复锻炼运动模型是周氏伤科经过近百年的传承、发展和创新的基础上，并结合训练核心肌群的方法，演变而来的一套功法，在临床应用中具有良好疗效，究其原因，概因通过锻炼，增强了腰背部核心肌群力量，腰部气血旺盛充盈，气有温煦，血有营养、滋润的效果，气血旺盛则可温肾助阳、筋强骨健、其病自消。且正气内存、邪不可干，则外邪难以入侵，经络气血运行通畅，进入良性循环。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647704518000,\"updateBy\":\"admin\",\"id\":1,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:23:20');
INSERT INTO `sys_oper_log` VALUES (38, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647762418000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"text-align: center; line-height: 1.5;\\\"><br></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:23:56');
INSERT INTO `sys_oper_log` VALUES (39, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/4011a811-4bc9-4302-b3d1-df02eb8c42d9.jpg\"},\"errno\":0}', 0, NULL, '2022-03-20 16:25:21');
INSERT INTO `sys_oper_log` VALUES (40, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647764636000,\"params\":{},\"title\":\"诱发腰突产生的因素都有哪些？\",\"article\":\"<p style=\\\"text-align: center; line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/4011a811-4bc9-4302-b3d1-df02eb8c42d9.jpg\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">1、退行性改变：对于部分的中老年人来说，腰椎间盘突出形成的原因是由于椎间盘出现了退化的现象，髓核的含水量降低，纤维环出现脆化，软骨板逐渐变薄</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">2、弯腰负重：长时间使用腰部来进行劳作，长年累积下去的弯腰负重会给椎间盘造成持续性的负荷，就会导致腰椎的纤维环出现破裂，髓核突出纤维环外，压迫神经根。</span></p><p style=\\\"line-height: 1.5;\\\"><span style=\\\"font-size: 16px; font-family: 华文仿宋;\\\">3、久坐不动：很多上班人群工作一天下来基本上是“一动不动稳如山”，长时间下午，腰背部难免会出现肌肉酸痛、痉挛的情况，长时间下去就会导致腰椎受力不均形成腰椎间盘突出。</span></p>\",\"createBy\":\"admin\",\"createTime\":1647705020000,\"updateBy\":\"admin\",\"id\":2,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:25:44');
INSERT INTO `sys_oper_log` VALUES (41, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"666\",\"article\":\"\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:26:05');
INSERT INTO `sys_oper_log` VALUES (42, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647764765000,\"params\":{},\"title\":\"666\",\"article\":\"<p><br></p><pre><code >res.data.url</code></pre><p><br></p>\",\"createBy\":\"admin\",\"createTime\":1647764765000,\"updateBy\":\"admin\",\"id\":3,\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:26:15');
INSERT INTO `sys_oper_log` VALUES (43, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647764775000,\"params\":{},\"title\":\"这20条的健康小知识，每个人都应该看一看，看到就是赚到\",\"article\":\"<p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">我们每个人都希望自己身体健康，然后能够长寿！但是很多人都搞不懂自己的身体！在手机上经常能够看到大批的健康小常识，不知道哪些是正确的，哪些是错误的！下面噜噜给大家说点健康小常识！这些都是医生才知道的！都在这里了！</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">1、低头玩手机增加颈椎的重量。当头部弯曲大于60度的是，颈椎承受的力量大约为45斤。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">2、仙人掌防辐射。仙人掌能够抵挡太阳的光线、紫外线的辐射，但是与电脑屏幕中的辐射不相同。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">3、吃到食物相克。有研究表示，人们在生活中吃到“相克”的食物，不会对身体产生太大的影响。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">4、老咬舌头是中风。老人总是说咬舌头是想吃肉了，如果发现经常咬住舌头，可能就会发生中风，大脑神经被压迫不能正常流通。一定要注意！</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">5、擦屁股是从前往后。尤其是女孩子，擦粪便的时候要从前往后擦，顺序为，尿道，阴道，肛门，这几种器官的抵抗病毒的作用依次增强。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">6、刷牙要刷舌头。舌头表面也会有细菌的滋生，长时间不刷舌头，会使得细菌侵害牙齿、牙龈，所以一定要轻轻刷舌头。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">7、泡脚水温不要过烫', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:29:29');
INSERT INTO `sys_oper_log` VALUES (44, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/a36d3f2f-028b-4848-959a-0d7bd0bc8f3d.png\"},\"errno\":0}', 0, NULL, '2022-03-20 16:32:11');
INSERT INTO `sys_oper_log` VALUES (45, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/148ae11f-a35d-4a31-a874-3715b25b32db.png\"},\"errno\":0}', 0, NULL, '2022-03-20 16:32:51');
INSERT INTO `sys_oper_log` VALUES (46, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/7cb56de7-1fd4-40b3-867f-3bf376da6233.png\"},\"errno\":0}', 0, NULL, '2022-03-20 16:33:01');
INSERT INTO `sys_oper_log` VALUES (47, '图片上传', 1, 'cn.henry.resource.controller.HealthArticleController.upload()', 'POST', 1, 'admin', NULL, '/resource/article/upload', '122.238.114.200', 'XX XX', '', '{\"data\":{\"url\":\"http://116.62.205.26/profile/articleResource/20220320/5c00a78a-9902-4bb9-933b-44ccc4ef1b57.png\"},\"errno\":0}', 0, NULL, '2022-03-20 16:33:29');
INSERT INTO `sys_oper_log` VALUES (48, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"updateTime\":1647764969000,\"params\":{},\"title\":\"这20条的健康小知识，每个人都应该看一看，看到就是赚到\",\"article\":\"<p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">我们每个人都希望自己身体健康，然后能够长寿！但是很多人都搞不懂自己的身体！在手机上经常能够看到大批的健康小常识，不知道哪些是正确的，哪些是错误的！下面噜噜给大家说点健康小常识！这些都是医生才知道的！都在这里了！&nbsp;</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">1、低头玩手机增加颈椎的重量。当头部弯曲大于60度的是，颈椎承受的力量大约为45斤。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/a36d3f2f-028b-4848-959a-0d7bd0bc8f3d.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">2、仙人掌防辐射。仙人掌能够抵挡太阳的光线、紫外线的辐射，但是与电脑屏幕中的辐射不相同。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">3、吃到食物相克。有研究表示，人们在生活中吃到“相克”的食物，不会对身体产生太大的影响。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">4、老咬舌头是中风。老人总是说咬舌头是想吃肉了，如果发现经常咬住舌头，可能就会发生中风，大脑神经被压迫不能正常流通。一定要注意！</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">5、擦屁股是从前往后。尤其是女孩子，擦粪便的时候要从前往后擦，顺序为，尿道，阴道，肛门，这几种器官的抵抗病毒的作用依次增强。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">6、刷牙要刷舌头。舌头表面也会有细菌的滋生，长时间不刷舌头，会使得细菌侵害牙齿、牙龈，所以一定要轻轻刷舌头。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/148ae11f-a35d-4a31-a874-3715b25b32db.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"><span st', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:33:40');
INSERT INTO `sys_oper_log` VALUES (49, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647765220000,\"params\":{},\"title\":\"这20条的健康小知识，每个人都应该看一看，看到就是赚到\",\"article\":\"<p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">我们每个人都希望自己身体健康，然后能够长寿！但是很多人都搞不懂自己的身体！在手机上经常能够看到大批的健康小常识，不知道哪些是正确的，哪些是错误的！下面噜噜给大家说点健康小常识！这些都是医生才知道的！都在这里了！&nbsp;</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">1、低头玩手机增加颈椎的重量。当头部弯曲大于60度的是，颈椎承受的力量大约为45斤。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">&nbsp;</span><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/a36d3f2f-028b-4848-959a-0d7bd0bc8f3d.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">2、仙人掌防辐射。仙人掌能够抵挡太阳的光线、紫外线的辐射，但是与电脑屏幕中的辐射不相同。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">3、吃到食物相克。有研究表示，人们在生活中吃到“相克”的食物，不会对身体产生太大的影响。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">4、老咬舌头是中风。老人总是说咬舌头是想吃肉了，如果发现经常咬住舌头，可能就会发生中风，大脑神经被压迫不能正常流通。一定要注意！</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">5、擦屁股是从前往后。尤其是女孩子，擦粪便的时候要从前往后擦，顺序为，尿道，阴道，肛门，这几种器官的抵抗病毒的作用依次增强。</span></p><p style=\\\"text-indent: 43px; text-align: justify; line-height: 1.5;\\\"><span style=\\\"font-size: 19px; font-family: 仿宋;\\\">6、刷牙要刷舌头。舌头表面也会有细菌的滋生，长时间不刷舌头，会使得细菌侵害牙齿、牙龈，所以一定要轻轻刷舌头。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 1.5;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/148ae11f-a35d-4a31-a874-3715b25b32db.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"><span style=\\\"font-size: 19px; font', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 16:52:39');
INSERT INTO `sys_oper_log` VALUES (50, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"2022年收藏这50条健康知识，照着做健康一整年！\",\"articleUrl\":\"http://wsjkw.sc.gov.cn/scwsjkw/jkys/2022/1/18/b3ee3f5c5b5e4dcaa8110df94e8a7648.shtml\",\"article\":\"\",\"createBy\":\"admin\",\"articleFrom\":1,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 17:41:50');
INSERT INTO `sys_oper_log` VALUES (51, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '122.238.114.200', 'XX XX', '{\"params\":{},\"title\":\"夜跑、晨跑，到底怎么跑？春天甩肉可别“跑偏”！\",\"articleUrl\":\"http://wsjkw.sc.gov.cn/scwsjkw/jkys/2022/3/1/11ee8fc8a1894a52a3941da794ca3771.shtmld\",\"article\":\"\",\"createBy\":\"admin\",\"articleFrom\":1,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 17:42:39');
INSERT INTO `sys_oper_log` VALUES (52, '健康小知识', 1, 'cn.henry.resource.controller.HealthArticleController.add()', 'POST', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"params\":{},\"title\":\"test\",\"article\":\"\",\"createBy\":\"admin\",\"articleFrom\":0,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 18:57:37');
INSERT INTO `sys_oper_log` VALUES (53, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647773981000,\"params\":{},\"title\":\"test\",\"article\":\"<p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">我们每个人都希望自己身体健康，然后能够长寿！但是很多人都搞不懂自己的身体！在手机上经常能够看到大批的健康小常识，不知道哪些是正确的，哪些是错误的！下面噜噜给大家说点健康小常识！这些都是医生才知道的！都在这里了！&nbsp;</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">1、低头玩手机增加颈椎的重量。当头部弯曲大于60度的是，颈椎承受的力量大约为45斤。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/a36d3f2f-028b-4848-959a-0d7bd0bc8f3d.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">2、仙人掌防辐射。仙人掌能够抵挡太阳的光线、紫外线的辐射，但是与电脑屏幕中的辐射不相同。</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">3、吃到食物相克。有研究表示，人们在生活中吃到“相克”的食物，不会对身体产生太大的影响。</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">4、老咬舌头是中风。老人总是说咬舌头是想吃肉了，如果发现经常咬住舌头，可能就会发生中风，大脑神经被压迫不能正常流通。一定要注意！</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">5、擦屁股是从前往后。尤其是女孩子，擦粪便的时候要从前往后擦，顺序为，尿道，阴道，肛门，这几种器官的抵抗病毒的作用依次增强。</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">6、刷牙要刷舌头。舌头表面也会有细菌的滋生，长时间不刷舌头，会使得细菌侵害牙齿、牙龈，所以一定要轻轻刷舌头。</span></p><p style=\\\"text-indent: 0px; text-align: center; line-height: 22.5px;\\\"><img src=\\\"http://116.62.205.26/prod-api/profile/articleResource/20220320/148ae11f-a35d-4a31-a874-3715b25b32db.png\\\" alt=\\\"\\\" data-href=\\\"\\\" style=\\\"width: 30%;\\\"><span style=\\\"font-size: 21px; font-family: 仿宋;\\\">&nbsp;</span></p><p style=\\\"text-align: justify; line-height: 22.5px;\\\"><span style=\\\"font-size: 21px; font-family', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 19:00:02');
INSERT INTO `sys_oper_log` VALUES (54, '健康小知识', 2, 'cn.henry.resource.controller.HealthArticleController.edit()', 'PUT', 1, 'admin', NULL, '/resource/article', '127.0.0.1', '内网IP', '{\"updateTime\":1647769359000,\"params\":{},\"title\":\"夜跑、晨跑，到底怎么跑？春天甩肉可别“跑偏”！\",\"articleUrl\":\"http://wsjkw.sc.gov.cn/scwsjkw/jkys/2022/3/1/11ee8fc8a1894a52a3941da794ca3771.shtml\",\"article\":\"\",\"createBy\":\"admin\",\"createTime\":1647769359000,\"updateBy\":\"admin\",\"id\":5,\"articleFrom\":1,\"status\":1}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 21:59:30');
INSERT INTO `sys_oper_log` VALUES (55, '健康小知识', 3, 'cn.henry.resource.controller.HealthArticleController.remove()', 'DELETE', 1, 'admin', NULL, '/resource/article/6', '127.0.0.1', '内网IP', '{ids=6}', '{\"code\":200,\"data\":1,\"msg\":\"操作成功\"}', 0, NULL, '2022-03-20 21:59:47');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'dev', '开发', 1, '0', 'admin', '2021-12-08 20:26:01', 'admin', '2022-01-13 08:26:50', '');
INSERT INTO `sys_post` VALUES (2, 'user', '普通员工', 2, '0', 'admin', '2021-12-08 20:26:01', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2021-12-08 20:26:01', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '5', 1, 1, '0', '0', 'admin', '2021-12-08 20:26:01', 'admin', '2022-01-13 09:26:34', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', 'Developer', '00', 'henrycmziz@gmail.com', '15888888888', '0', '/profile/avatar/20220227/1ef7b257-a494-49f5-8acb-2a8a3167e248.jpeg', '$2a$10$SOvNHYwNxYyUmW78RfLYr.3Bhg.7fU.TR2b8ZQ3ol7gZ6RyEnatMS', '0', '0', '122.238.121.178', '2022-04-07 13:13:00', 'admin', '2021-12-08 20:26:01', '', '2022-04-07 13:13:00', '管理员');
INSERT INTO `sys_user` VALUES (2, 104, 'test', '测试员', '00', 'ceshi@qq.com', '15666666666', '1', '', '$2a$10$.HhuBy3u2dbbG2M6ZAgahOyKa4P5/.nuVmQXetC4ialqo35XjI3XS', '0', '0', '122.238.121.45', '2022-02-15 10:56:50', 'admin', '2021-12-08 20:26:01', 'admin', '2022-02-15 10:56:50', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
