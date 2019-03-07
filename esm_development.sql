/*
 Navicat Premium Data Transfer

 Source Server         : yangbin
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : www.yangbin.com:3306
 Source Schema         : esm_development

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 07/03/2019 22:24:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for esm_address
-- ----------------------------
DROP TABLE IF EXISTS `esm_address`;
CREATE TABLE `esm_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `consignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `postcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esm_admin
-- ----------------------------
DROP TABLE IF EXISTS `esm_admin`;
CREATE TABLE `esm_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `adminname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esm_cart
-- ----------------------------
DROP TABLE IF EXISTS `esm_cart`;
CREATE TABLE `esm_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `amount` int(255) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `esm_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_cart
-- ----------------------------
INSERT INTO `esm_cart` VALUES (1, 'wanl2411096785', 88715749, 4);
INSERT INTO `esm_cart` VALUES (2, 'wanl2411096785', 88715742, 10);
INSERT INTO `esm_cart` VALUES (3, 'wanl2411096785', 88715757, 2);
INSERT INTO `esm_cart` VALUES (4, 'wanl2411096785', 88715747, 1);
INSERT INTO `esm_cart` VALUES (5, 'wanl2411096785', 88715766, 1);

-- ----------------------------
-- Table structure for esm_cate
-- ----------------------------
DROP TABLE IF EXISTS `esm_cate`;
CREATE TABLE `esm_cate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类描述',
  `display` int(11) NULL DEFAULT 1 COMMENT '是否显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_cate
-- ----------------------------
INSERT INTO `esm_cate` VALUES (5, 0, '鞋靴', '鞋靴', 1);
INSERT INTO `esm_cate` VALUES (15, 0, '襦裙', '襦，即短上衣，按款式分类，有对襟（亦称直领）、交领（亦称斜襟）、坦领（亦称U领）等；裙，即下裙，通常为一片式合围裙，按制作方式分类，分为褶裙、片裙等', 1);
INSERT INTO `esm_cate` VALUES (16, 15, '齐腰襦裙', '可搭配披帛。袖型不限于窄袖，亦有直袖、宽袖、广袖等。', 1);
INSERT INTO `esm_cate` VALUES (17, 15, '高腰襦裙', '可搭配披帛。袖型不限于窄袖，亦有直袖、宽袖、广袖等。', 1);
INSERT INTO `esm_cate` VALUES (18, 15, '齐胸襦裙', '可搭配披帛。袖型不限于窄袖，亦有直袖、宽袖、广袖等。', 1);
INSERT INTO `esm_cate` VALUES (19, 15, '半臂襦裙', '可搭配披帛。袖型不限于窄袖，亦有直袖、宽袖、广袖等。', 1);
INSERT INTO `esm_cate` VALUES (20, 15, '交领襦裙', '交领指衣襟左右相交。', 1);
INSERT INTO `esm_cate` VALUES (21, 0, '衣裳', '又称上衣下裳。上衣下裳是中国最早的服装形制之一，为汉服体系的第一个款式，约出现于商朝。上衣交领右衽，下裳一片式围合，皆以带结系，这也是汉服最基本的特征。秦汉之后，男子深衣制逐渐取代上衣下裳制，上衣下裳逐渐只作为礼服存在，后世更是成为男子最为严肃的最高礼服。', 1);
INSERT INTO `esm_cate` VALUES (22, 21, '玄端', '玄端为先秦时通用的朝服及士礼服，自天子至士皆可穿，为国家的法服，天子平时燕居之服。诸侯祭宗庙也穿玄端，大夫、士早上入庙，叩见父母也穿玄端。', 1);
INSERT INTO `esm_cate` VALUES (23, 21, '短打', '裋褐为上衣下裤的形制，上衣为交领衣，长度一般在臀部，裤为直筒裤。此款本为男装，适用于居家劳动，现代发展为男女通用。', 1);
INSERT INTO `esm_cate` VALUES (24, 21, '半臂', '短半臂：男装短半臂在现代一般作为汉元素穿着。长半臂：此款形制暂无文物佐证，不确定历史上存在与否。图为现代商家制作。', 1);
INSERT INTO `esm_cate` VALUES (25, 5, '布鞋', '挑一双好看的绣花鞋，真的是又美又舒服呢。绣花鞋', 1);
INSERT INTO `esm_cate` VALUES (26, 5, '翘头履', '我国古代鞋子款式以鞋头上翘为常见，其样式是为了防止踩到身前下裙，多称为“翘头履”。', 1);

-- ----------------------------
-- Table structure for esm_collection
-- ----------------------------
DROP TABLE IF EXISTS `esm_collection`;
CREATE TABLE `esm_collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `esm_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_collection_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esm_order
-- ----------------------------
DROP TABLE IF EXISTS `esm_order`;
CREATE TABLE `esm_order`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '支付日期',
  `delivery_date` datetime(0) NULL DEFAULT NULL COMMENT '发货日期',
  `confirm_date` datetime(0) NULL DEFAULT NULL COMMENT '收获日期',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `ordertotal` decimal(10, 0) NULL DEFAULT NULL COMMENT '总价',
  `address_id` int(11) NULL DEFAULT NULL COMMENT '地址ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  CONSTRAINT `esm_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `esm_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esm_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `esm_orderitem`;
CREATE TABLE `esm_orderitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `esm_orderitem_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_orderitem_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `esm_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_orderitem_ibfk_4` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esm_product
-- ----------------------------
DROP TABLE IF EXISTS `esm_product`;
CREATE TABLE `esm_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品主键ID',
  `cate_id` int(11) NULL DEFAULT NULL COMMENT '分类ID',
  `main_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品主标题',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `old_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '原价',
  `buy_count` bigint(20) NULL DEFAULT NULL COMMENT '购买数量',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品主图',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品详情',
  `status` int(255) NULL DEFAULT 1 COMMENT '状态',
  `is_hot` int(255) NULL DEFAULT 0 COMMENT '是否热门',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `shelf_time` datetime(0) NULL DEFAULT NULL COMMENT '上架时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cate_id`(`cate_id`) USING BTREE,
  CONSTRAINT `esm_product_ibfk_1` FOREIGN KEY (`cate_id`) REFERENCES `esm_cate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 88715773 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_product
-- ----------------------------
INSERT INTO `esm_product` VALUES (82522957, 16, '钟灵记般若齐胸襦裙对襟齐腰汉服女改良春夏秋冬装传统绿重工大摆', '对襟齐腰汉服女改良春夏秋冬装传统绿重工大摆', 188.00, 288.00, 0, 'productimg/2019/3/82522957/TB2LfR1ceSSBuNjy0FlXXbBpVXa_!!411005513.jpg', '钟灵记般若齐胸襦裙对襟齐腰汉服女改良春夏秋冬装传统绿重工大摆', 1, 1, 99, '2019-03-02 19:57:33');
INSERT INTO `esm_product` VALUES (82522958, 20, '如梦霓裳汉服女装交领襦裙翎羽大袖孔雀绣花春夏季原创日常新款', '女装交领襦裙翎羽大袖孔雀绣花', 189.00, 259.00, 0, 'productimg/2019/3/82522958/O1CN01EnfbZP1IuVwGs11zG_!!4194630953.jpg_430x430q90.jpg', '如梦霓裳汉服女装交领襦裙翎羽大袖孔雀绣花春夏季原创日常新款', 1, 1, 99, '2019-03-21 20:49:00');
INSERT INTO `esm_product` VALUES (82522959, 20, '重回汉唐汉服女 襦裙行香子传统日常交领齐腰襦裙民族风绣花春装', '交领齐腰襦裙民族风绣花春装', 136.00, 189.00, 0, 'productimg/2019/3/82522959/O1CN01ZiO0Lm1vZgvtURT4Z_!!0-item_pic.jpg_430x430q90.jpg', '重回汉唐汉服女 襦裙行香子传统日常交领齐腰襦裙民族风绣花春装', 1, 1, 99, '2019-03-02 21:02:38');
INSERT INTO `esm_product` VALUES (86626581, 16, '钟灵记【绯烟】日常汉服女对襟上襦改良齐腰襦裙吊带中国风春夏秋', '齐腰襦裙吊带中国风春夏秋', 115.00, 198.00, 0, 'productimg/2019/3/O1CN01kxDaD71qb00nTJNEL_!!0-item_pic.jpg', '钟灵记【绯烟】日常汉服女对襟上襦改良齐腰襦裙吊带中国风春夏秋', 1, 0, 99, '2019-02-28 09:12:16');
INSERT INTO `esm_product` VALUES (87754945, 16, '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', 148.00, 256.00, 0, 'productimg/2019/3/O1CN01GXZnzl1b673yDgh7R_!!1766643415.jpg', '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', 1, 0, 99, '2019-03-15 19:41:45');
INSERT INTO `esm_product` VALUES (88715736, 16, '钟灵记原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带非 古风春夏秋冬款', '原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带', 198.00, 245.00, 0, 'productimg/2019/3/O1CN01ZCTDIk1qb00nuS2CM_!!0-item_pic.jpg', '灵记原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带非 古风春夏秋冬款', 1, 1, 99, '2019-03-02 19:34:37');
INSERT INTO `esm_product` VALUES (88715737, 20, '传统汉服男女款魏晋风大袖衫交领襦裙广袖齐腰襦裙绣花古装女套装', '大袖衫交领襦裙广袖齐腰襦裙绣花古装', 100.00, 165.00, 0, 'productimg/2019/3/88715737/O1CN01nv5THS1pgCsGxo1dU_!!4122985389.jpg_430x430q90.jpg', '传统汉服男女款魏晋风大袖衫交领襦裙广袖齐腰襦裙绣花古装女套装', 1, 0, 99, '2019-03-03 11:48:43');
INSERT INTO `esm_product` VALUES (88715738, 20, '汉尚华莲雾影仙传统汉服女装交领大袖襦裙齐腰双层套装日常春夏款', '汉尚华莲雾影仙传统汉服女装', 468.00, 569.00, 0, 'productimg/2019/3/88715738/O1CN01CXavn52Ccl4sveZm9_!!0-item_pic.jpg_430x430q90.jpg', '汉尚华莲雾影仙传统汉服女装交领大袖襦裙齐腰双层套装日常春夏款', 1, 0, 99, '2019-03-03 11:56:01');
INSERT INTO `esm_product` VALUES (88715739, 19, '绒莲绿篱花灯节汉服女中国风秋季新款绣花半臂齐胸襦裙连衣裙套装', '绒莲绿篱花灯节汉服', 98.00, 156.00, 0, 'productimg/2019/3/88715739/O1CN01kuEz9g1ZpnKsR7fL3_!!0-saturn_solar.jpg_250x250.jpg_.webp.jpg', '绒莲绿篱花灯节汉服女中国风秋季新款绣花半臂齐胸襦裙连衣裙套装', 1, 1, 99, '2019-03-03 12:02:56');
INSERT INTO `esm_product` VALUES (88715740, 19, '都城南庄原创齐腰袒领襦裙绣花半臂印花渐变下裙袒领汉服丹尘子', '齐腰袒领襦裙绣花半臂印花', 226.00, 346.00, 0, 'productimg/2019/3/88715740/TB1tlLzhLuSBuNkHFqDYXFfhVXa_M2.SS2_250x250.jpg_.webp.jpg', '都城南庄原创齐腰袒领襦裙绣花半臂印花渐变下裙袒领汉服丹尘子', 1, 0, 99, '2019-03-03 12:25:20');
INSERT INTO `esm_product` VALUES (88715741, 19, '流烟昔泠清霜 秋款传统汉服破裙绣花坦领襦裙半臂非古装', '秋款传统汉服破裙绣花坦领襦裙半臂', 89.00, 156.00, 0, 'productimg/2019/3/88715741/O1CN01bXLEaj1f965IsqdLi_!!0-item_pic.jpg_430x430q90.jpg', '流烟昔泠清霜 秋款传统汉服破裙绣花坦领襦裙半臂非古装', 1, 0, 99, '2019-03-03 12:34:54');
INSERT INTO `esm_product` VALUES (88715742, 19, '钟灵记原创【碧桃香】汉服交领襦裙女款对襟半臂齐腰非改良春夏秋', '【碧桃香】汉服交领襦裙女款对襟半臂齐腰', 120.00, 199.00, 0, 'productimg/2019/3/88715742/TB2dnrUn90mpuFjSZPiXXbssVXa_!!411005513.jpg', '钟灵记原创【碧桃香】汉服交领襦裙女款对襟半臂齐腰非改良春夏秋', 1, 1, 99, '2019-03-03 12:41:34');
INSERT INTO `esm_product` VALUES (88715743, 18, '汉服女菩提雪妙上齐胸襦裙女装秋古装服装仙女飘逸清新淡雅中国风', '齐胸襦裙女装秋古装服装', 78.00, 138.00, 0, 'productimg/2019/3/88715743/O1CN01Wkjnen1ghHGeti6e5_!!0-item_pic.jpg_430x430q90.jpg', '汉服女菩提雪妙上齐胸襦裙女装秋古装服装仙女飘逸清新淡雅中国风', 1, 1, 99, '2019-03-03 12:49:25');
INSERT INTO `esm_product` VALUES (88715744, 18, '汉尚华莲周年店庆款传统汉服龙母齐胸襦裙内衬6米摆高腰重工绣花', '传统汉服龙母齐胸襦裙内衬6米摆高腰重工绣花', 888.00, 1088.00, 0, 'productimg/2019/3/88715744/O1CN01n4gxoU2Ccl3yVXXzl_!!0-item_pic.jpg_430x430q90.jpg', '汉尚华莲周年店庆款传统汉服龙母齐胸襦裙内衬6米摆高腰重工绣花', 1, 0, 99, '2019-03-03 12:56:42');
INSERT INTO `esm_product` VALUES (88715745, 18, '新款汉服释妙仙仙鹤刺绣齐胸襦裙汉元素古装改良日常清新淡雅秋冬', '妙仙仙鹤刺绣齐胸襦裙', 78.00, 189.00, 0, 'productimg/2019/3/88715745/TB1Req0oruWBuNjSszgXXb8jVXa_!!0-item_pic.jpg_430x430q90.jpg', '新款汉服释妙仙仙鹤刺绣齐胸襦裙汉元素古装改良日常清新淡雅秋冬', 1, 1, 99, '2019-03-03 13:02:32');
INSERT INTO `esm_product` VALUES (88715746, 18, '重回汉唐原创汉服女燕燕于飞日常古中国风对襟齐胸襦裙套装春夏季', '重回汉唐原创汉服女燕燕于飞日常', 125.00, 235.00, 0, 'productimg/2019/3/88715746/TB2iSxot98YBeNkSnb4XXaevFXa_!!2835046187.jpg_430x430q90.jpg', '重回汉唐原创汉服女燕燕于飞日常古中国风对襟齐胸襦裙套装春夏季', 1, 0, 99, '2019-03-03 13:09:14');
INSERT INTO `esm_product` VALUES (88715747, 17, '汉尚华莲锦宫传统汉服女高腰刺绣齐胸襦裙3米内摆日常显瘦春夏装', '汉服女高腰刺绣齐胸襦裙3米', 528.00, 635.00, 0, 'productimg/2019/3/88715747/O1CN01kOj2y22Ccl4qLoXmz_!!3358098495.jpg_430x430q90.jpg', '汉尚华莲锦宫传统汉服女高腰刺绣齐胸襦裙3米内摆日常显瘦春夏装', 1, 1, 99, '2019-03-03 13:19:20');
INSERT INTO `esm_product` VALUES (88715748, 17, '汉尚华莲十周年店庆款鲛人泪花嫁传统汉服女高腰齐胸襦裙大袖衫秋', '鲛人泪花嫁传统汉服女高腰齐胸襦裙', 338.00, 538.00, 0, 'productimg/2019/3/88715748/TB2NMCoqJcnBKNjSZR0XXcFqFXa_!!124896744.jpg_250x250.jpg_.webp.jpg', '汉尚华莲十周年店庆款鲛人泪花嫁传统汉服女高腰齐胸襦裙大袖衫秋', 1, 0, 99, '2019-03-03 13:27:14');
INSERT INTO `esm_product` VALUES (88715749, 17, '汉尚华莲传统汉服女重工锦鲤绣花唐制齐胸襦裙高腰多片春夏大摆裙', '汉服女重工锦鲤绣花唐制齐胸襦裙高腰', 538.00, 688.00, 0, 'productimg/2019/3/88715749/TB2aX8YicLJ8KJjy0FnXXcFDpXa_!!124896744.jpg', '汉尚华莲传统汉服女重工锦鲤绣花唐制齐胸襦裙高腰多片春夏大摆裙', 1, 0, 99, '2019-03-03 13:35:08');
INSERT INTO `esm_product` VALUES (88715750, 17, '陛下兰他惜春夏新款古风改良日常汉服襦裙珍珠网纱蓬蓬仙女连衣裙', '陛下兰他惜春夏新款古风改良日常汉服襦裙珍珠网纱蓬蓬仙女连衣裙', 358.00, 167.00, 0, 'productimg/2019/3/88715750/TB1EBz1b9tYBeNjSspaXXaOOFXa_!!0-item_pic.jpg_430x430q90.jpg', '陛下兰他惜春夏新款古风改良日常汉服襦裙珍珠网纱蓬蓬仙女连衣裙', 1, 1, 99, '2019-03-03 13:42:44');
INSERT INTO `esm_product` VALUES (88715751, 22, '6068+6069汉服毕业成人礼服运动会开幕式演出玄端男女情侣 绣龙凤', '成人礼服运动会开幕式演出玄端男女情侣 绣龙凤', 140.00, 350.00, 0, 'productimg/2019/3/88715751/O1CN01ODiDaI1DTQRmnu9rS_!!2242500217.jpg_430x430q90.jpg', '6068+6069汉服毕业成人礼服运动会开幕式演出玄端男女情侣 绣龙凤', 1, 0, 99, '2019-03-03 16:48:24');
INSERT INTO `esm_product` VALUES (88715752, 22, '【七年老店原创】汉唐之梦汉服男玄端成人礼非古装情侣龙凤套装女', '汉唐之梦汉服男玄端成人礼非古装情侣龙凤套装女', 149.00, 189.00, 0, 'productimg/2019/3/88715752/O1CN01DuS4nu2HmRWXMvG6I_!!55739193.jpg', '汉唐之梦汉服男玄端成人礼非古装情侣龙凤套装女', 1, 1, 99, '2019-03-03 16:55:26');
INSERT INTO `esm_product` VALUES (88715753, 22, '汉服出租 玄端 祭祀祭孔 礼服 成人礼 婚服 冕服『青岚之风』', '礼服 成人礼 婚服 冕服『青岚之风』', 198.00, 235.00, 0, 'productimg/2019/3/88715753/TB2hh.RsiMnBKNjSZFCXXX0KFXa_!!404187285.jpg', '礼服 成人礼 婚服 冕服『青岚之风』', 1, 0, 99, '2019-03-03 17:03:59');
INSERT INTO `esm_product` VALUES (88715754, 22, '可以订制的汉服玄端', '汉服玄端', 330.00, 350.00, 0, 'productimg/2019/3/88715754/TB1tTV9RXXXXXaAXpXXYXGcGpXX_M2.jpg', '本品包含：上衣、下裳、蔽膝、大带、中单。玄冠（要冠加100）\r\n\r\n布料：主体用卡丹皇\r\n\r\n布料特点：卡丹皇布面织纹清晰细致，手感舒适、垂感性强、不起皱、不起球、不扒丝、颜色艳丽', 1, 1, 99, '2019-03-03 17:09:39');
INSERT INTO `esm_product` VALUES (88715755, 23, '传统汉元素改良汉服日常情侣男女CP刺绣短褐短打中国风套装复古', '传统汉元素改良汉服日常情侣男女CP刺绣短褐短打', 125.00, 189.00, 0, 'productimg/2019/3/88715755/O1CN01gAM2qn2MyPxH6hpfi_!!1666879896.jpg_430x430q90.jpg', '传统汉元素改良汉服日常情侣男女CP刺绣短褐短打', 1, 0, 99, '2019-03-03 17:27:53');
INSERT INTO `esm_product` VALUES (88715756, 23, '汉服短褐上衣下裤男女情侣装古装平民百姓服便服短打古风日常装秋', '古装平民百姓服便服短打古风日常装秋', 89.00, 136.00, 0, 'productimg/2019/3/88715756/O1CN011XjiobP3TwZLQHu_!!2270682960.jpg', '古装平民百姓服便服短打古风日常装秋', 1, 1, 99, '2019-02-27 17:33:51');
INSERT INTO `esm_product` VALUES (88715757, 23, '流烟昔泠 溯洄 秋款传统汉服情侣男女CP绣花裋褐短打非古装', '秋款传统汉服情侣男女CP绣花裋褐', 89.00, 178.00, 0, 'productimg/2019/3/88715757/O1CN01P6G24222AgcbXQM5T_!!0-item_pic.jpg', '流烟昔泠 溯洄 秋款传统汉服情侣男女CP绣花裋褐短打非古装', 1, 1, 99, '2019-03-03 17:39:45');
INSERT INTO `esm_product` VALUES (88715758, 23, '改良新款交领怀楚原创长中长半臂短打裋褐上衣汉服男绣花日常春秋', '短打裋褐上衣汉服男绣花日常春秋', 56.00, 89.00, 0, 'productimg/2019/3/88715758/O1CN01ewJLcJ1fQV9pCQPGb_!!2104704001.jpg', '短打裋褐上衣汉服男绣花日常春秋', 1, 0, 99, '2019-03-03 17:45:41');
INSERT INTO `esm_product` VALUES (88715759, 24, '重回汉唐汉服男装铭乐古传统日常民族风刺绣半臂原创交领衣裳春秋', '日常民族风刺绣半臂原创交领衣裳春秋', 218.00, 315.00, 0, 'productimg/2019/3/88715759/TB2dufyrv5TBuNjSspmXXaDRVXa_!!2835046187.jpg_430x430q90.jpg', '日常民族风刺绣半臂原创交领衣裳春秋', 1, 1, 99, '2019-03-03 17:51:15');
INSERT INTO `esm_product` VALUES (88715760, 24, '重回汉唐汉服女装千枝日常中国风刺绣半臂交领上襦齐腰破裙春夏装', '女装千枝日常中国风刺绣半臂交领上襦齐腰破裙春夏装', 98.00, 156.00, 0, 'productimg/2019/3/88715760/TB1tW5IrYwrBKNjSZPcXXXpapXa_!!0-item_pic.jpg_430x430q90.jpg', '重回汉唐汉服女装千枝日常中国风刺绣半臂交领上襦齐腰破裙春夏装', 1, 0, 99, '2019-03-03 17:57:05');
INSERT INTO `esm_product` VALUES (88715761, 24, '【流烟昔泠 锦书】春款传统汉服情侣男女CP款绣花半臂衣裳非古装', '绣花半臂衣裳非古装', 89.00, 98.00, 0, 'productimg/2019/3/88715761/O1CN011wMCXm22Agd7iEMWM_!!1766737080.jpg_250x250.jpg_.webp.jpg', '【流烟昔泠 锦书】春款传统汉服情侣男女CP款绣花半臂衣裳非古装', 1, 1, 99, '2019-03-03 18:03:32');
INSERT INTO `esm_product` VALUES (88715762, 24, '沐汉风奉瑞汉元素男装改良汉服唐风直领半臂中国风半袖短外套春装', '汉元素男装改良汉服唐风直领半臂中国风半袖短外套春装', 156.00, 189.00, 0, 'productimg/2019/3/88715762/O1CN01JVrY7Q1QqriPuezpx_!!0-item_pic.jpg_250x250.jpg_.webp.jpg', '沐汉风奉瑞汉元素男装改良汉服唐风直领半臂中国风半袖短外套春装', 1, 0, 99, '2019-03-03 18:09:49');
INSERT INTO `esm_product` VALUES (88715763, 25, '瑞彩祥云复古风汉服鞋亚麻中式布鞋平跟中国风绣花鞋民族风布鞋女', '布鞋平跟中国风绣花鞋民族风布鞋女', 89.00, 123.00, 0, 'productimg/2019/3/88715763/O1CN01khPBhF1vYmAJ7eDXP_!!679246185.jpg_430x430q90.jpg', '瑞彩祥云复古风汉服鞋亚麻中式布鞋平跟中国风绣花鞋民族风布鞋女', 1, 1, 99, '2019-03-03 18:29:43');
INSERT INTO `esm_product` VALUES (88715764, 25, '重回汉唐汉服配饰女鞋熙颜民族风刺绣平底弓鞋千层底手工绣花布鞋', '民族风刺绣平底弓鞋千层底手工绣花布鞋', 98.00, 108.00, 0, 'productimg/2019/3/88715764/TB2kGC_slsmBKNjSZFsXXaXSVXa_!!2835046187.jpg_430x430q90.jpg', '重回汉唐汉服配饰女鞋熙颜民族风刺绣平底弓鞋千层底手工绣花布鞋', 1, 1, 99, '2019-03-03 18:36:44');
INSERT INTO `esm_product` VALUES (88715765, 26, '新复古民族风手工古装绣花鞋古代戏剧汉履汉服鞋千层底翘头履', '汉服鞋千层底翘头履', 138.00, 139.00, 0, 'productimg/2019/3/88715765/TB278_ka7ZmBKNjSZPiXXXFNVXa_!!3487945483.jpg_430x430q90.jpg', '新复古民族风手工古装绣花鞋古代戏剧汉履汉服鞋千层底翘头履', 1, 1, 99, '2019-03-03 18:43:31');
INSERT INTO `esm_product` VALUES (88715766, 26, '简百莲绣花鞋新款古风日常改良弓鞋女汉服翘头内增高复古浅口布鞋', '日常改良弓鞋女汉服翘头内增高复古浅口布鞋', 56.00, 66.00, 0, 'productimg/2019/3/88715766/O1CN011TQhv8uSOQGVlFu_!!4014322377.jpg_430x430q90.jpg', '简百莲绣花鞋新款古风日常改良弓鞋女汉服翘头内增高复古浅口布鞋', 1, 1, 99, '2019-03-03 18:49:10');
INSERT INTO `esm_product` VALUES (88715767, 25, '步瀛斋 女士绣花鞋 春夏季老北京布鞋女手工千层底 盘扣水墨民族风布鞋 古装鞋子女 汉服鞋 千底蓝印花盘扣女鞋蓝色', '步瀛斋 女士绣花鞋', 258.00, 298.00, 0, 'productimg/2019/3/88715767/5b0bad85Nc49b4ed5.jpg', '步瀛斋 女士绣花鞋 春夏季老北京布鞋女手工千层底 盘扣水墨民族风布鞋 古装鞋子女 汉服鞋 千底蓝印花盘扣女鞋蓝色 39', 1, 1, 99, '2019-03-05 20:37:44');
INSERT INTO `esm_product` VALUES (88715768, 25, '古风鞋子白汉服鞋子女 布鞋民族风内增高系带坡跟绣花鞋女 五厘米仙鹤白系带 ', '民族风内增高系带坡跟绣花鞋女', 35.00, 60.00, 0, 'productimg/2019/3/88715768/5b72d3a6N4c0203aa.jpg', '古风鞋子白汉服鞋子女 布鞋民族风内增高系带坡跟绣花鞋女 五厘米仙鹤白系带 ', 1, 0, 99, '2019-03-05 20:48:23');
INSERT INTO `esm_product` VALUES (88715769, 25, '【新品上市】新款汉服鞋子女鞋老北京布鞋古风民族风内增高坡跟百搭学生绣花鞋 竹叶红色', '北京布鞋古风民族风内增高坡跟百搭学生绣花鞋', 100.00, 150.00, 0, 'productimg/2019/3/88715769/1e608bf8654b0b18.jpg', '【新品上市】新款汉服鞋子女鞋老北京布鞋古风民族风内增高坡跟百搭学生绣花鞋 竹叶红色', 1, 1, 99, '2019-03-05 20:56:08');
INSERT INTO `esm_product` VALUES (88715770, 26, '古风鞋子女汉服鞋平跟弓鞋翘头履汉服配鞋古装鞋软底中国风绣花鞋', '汉服配鞋古装鞋软底中国风绣花鞋', 75.00, 128.00, 0, 'productimg/2019/3/88715770/5bc4230aN1ce0c0f7.jpg', '古风鞋子女汉服鞋平跟弓鞋翘头履汉服配鞋古装鞋软底中国风绣花鞋', 1, 1, 99, '2019-03-05 21:03:43');
INSERT INTO `esm_product` VALUES (88715771, 26, '汉服鞋古风鞋子女老北京布鞋弓鞋民族风学生平底系带绣花鞋千层底 浅紫色 星月翘头', '民族风学生平底系带绣花鞋千层底 浅紫色 星月翘头', 189.00, 289.00, 0, 'productimg/2019/3/88715771/5bf51520N01f22f38.jpg', '汉服鞋古风鞋子女老北京布鞋弓鞋民族风学生平底系带绣花鞋千层底 浅紫色 星月翘头', 1, 0, 99, '2019-03-05 21:10:02');
INSERT INTO `esm_product` VALUES (88715772, 26, '古风鞋子女汉服鞋子女坡跟绣花鞋中国风女鞋民族风春夏季翘头履', '古风鞋子女汉服鞋子', 359.00, 389.00, 0, 'productimg/2019/3/88715772/98ec3e0e1fd73c9e.jpg', '古风鞋子女汉服鞋子女坡跟绣花鞋中国风女鞋民族风春夏季翘头履', 1, 0, 99, '2019-03-05 21:15:52');

-- ----------------------------
-- Table structure for esm_product_img
-- ----------------------------
DROP TABLE IF EXISTS `esm_product_img`;
CREATE TABLE `esm_product_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `esm_product_img_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 223 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_product_img
-- ----------------------------
INSERT INTO `esm_product_img` VALUES (1, 86626581, 'productimg/2019/3/TB2GcVcb_dYBeNkSmLyXXXfnVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (2, 86626581, 'productimg/2019/3/O1CN01kxDaD71qb00nTJNEL_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (3, 86626581, 'productimg/2019/3/TB2L4.1g_lYBeNjSszcXXbwhFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (4, 86626581, 'productimg/2019/3/TB2NNr5bFooBKNjSZPhXXc2CXXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (5, 86626581, 'productimg/2019/3/TB22M7JbOMnBKNjSZFCXXX0KFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (6, 86626581, 'productimg/2019/3/TB27736dljTBKNjSZFwXXcG4XXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (7, 88715736, 'productimg/2019/3/O1CN01Tzbped1qb008WHxm8_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (8, 88715736, 'productimg/2019/3/O1CN01Wfhi9X1qb009Iudm7_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (9, 88715736, 'productimg/2019/3/O1CN01ZCTDIk1qb00nuS2CM_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (10, 88715736, 'productimg/2019/3/TB2.DNYtHBmpuFjSZFAXXaQ0pXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (11, 88715736, 'productimg/2019/3/TB2Ilexot0opuFjSZFxXXaDNVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (12, 88715736, 'productimg/2019/3/TB2O8k7u80lpuFjSszdXXcdxFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (13, 87754945, 'productimg/2019/3/O1CN01GXZnzl1b673yDgh7R_!!1766643415.jpg');
INSERT INTO `esm_product_img` VALUES (14, 87754945, 'productimg/2019/3/O1CN01JuJak91b673woXq7c_!!1766643415.jpg');
INSERT INTO `esm_product_img` VALUES (15, 87754945, 'productimg/2019/3/O1CN01vfRbF21b673W52gXf_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (16, 87754945, 'productimg/2019/3/O1CN01YuxbAK1b673X5N9Bq_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (17, 87754945, 'productimg/2019/3/O1CN011b6725tLwCMHlDF_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (18, 82522957, 'productimg/2019/3/82522957/O1CN017cFOfj1qb00o29HaD_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (19, 82522957, 'productimg/2019/3/82522957/TB2.DNYtHBmpuFjSZFAXXaQ0pXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (20, 82522957, 'productimg/2019/3/82522957/TB2.ePTcrSYBuNjSspfXXcZCpXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (21, 82522957, 'productimg/2019/3/82522957/TB2_U_jer9YBuNjy0FgXXcxcXXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (22, 82522957, 'productimg/2019/3/82522957/TB2HOeLakomBKNjSZFqXXXtqVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (23, 82522957, 'productimg/2019/3/82522957/TB2LfR1ceSSBuNjy0FlXXbBpVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (24, 82522958, 'productimg/2019/3/82522958/O1CN01EnfbZP1IuVwGs11zG_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (25, 82522958, 'productimg/2019/3/82522958/O1CN01UR0ANd1IuVwFOP2FU_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (26, 82522958, 'productimg/2019/3/82522958/O1CN01wb3ytz1IuVwERMevX_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (27, 82522958, 'productimg/2019/3/82522958/O1CN013YJden1IuVwFcF5IV_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (28, 82522958, 'productimg/2019/3/82522958/O1CN017nHxHG1IuVwE2ndvW_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (29, 82522959, 'productimg/2019/3/82522959/O1CN01ZiO0Lm1vZgvtURT4Z_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (30, 82522959, 'productimg/2019/3/82522959/TB1t0uDdbSYBuNjSspiYXFNzpXa_M2.SS2_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (31, 82522959, 'productimg/2019/3/82522959/TB2J.sTmY_I8KJjy1XaXXbsxpXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (32, 82522959, 'productimg/2019/3/82522959/TB2WbpZqQCWBuNjy0FaXXXUlXXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (33, 82522959, 'productimg/2019/3/82522959/TB24j6kjVGWBuNjy0FbXXb4sXXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (34, 88715737, 'productimg/2019/3/88715737/O1CN01nv5THS1pgCsGxo1dU_!!4122985389.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (35, 88715737, 'productimg/2019/3/88715737/O1CN01UBZ0zO1pgCsJBNwcl_!!4122985389.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (36, 88715737, 'productimg/2019/3/88715737/O1CN014llQNX1pgCsJo9Hrn_!!4122985389.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (37, 88715737, 'productimg/2019/3/88715737/O1CN017OjOMh1pgCsGzkBrM_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (38, 88715738, 'productimg/2019/3/88715738/O1CN01CXavn52Ccl4sveZm9_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (39, 88715738, 'productimg/2019/3/88715738/O1CN01Ck4ifa2Ccl4mgUOHU_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (40, 88715738, 'productimg/2019/3/88715738/O1CN01qbHhZI2Ccl4uDrmR1_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (41, 88715738, 'productimg/2019/3/88715738/O1CN01t60MtF2Ccl4uMIU41_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (42, 88715738, 'productimg/2019/3/88715738/O1CN01yTmmpU2Ccl4vY0KtF_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (43, 88715739, 'productimg/2019/3/88715739/O1CN01kuEz9g1ZpnKsR7fL3_!!0-saturn_solar.jpg_250x250.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (44, 88715739, 'productimg/2019/3/88715739/O1CN011CPvlmp6eFGb0Y1_!!1745670074.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (45, 88715739, 'productimg/2019/3/88715739/O1CN011CPvlmYu345omGu_!!1745670074.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (46, 88715739, 'productimg/2019/3/88715739/O1CN011CPvloaD4WJniSd_!!1745670074.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (47, 88715739, 'productimg/2019/3/88715739/O1CN011CPvloFCen0pe7r_!!1745670074.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (48, 88715739, 'productimg/2019/3/88715739/O1CN011CPvlp93s87DlIU_!!1745670074.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (49, 88715740, 'productimg/2019/3/88715740/TB1tlLzhLuSBuNkHFqDYXFfhVXa_M2.SS2_250x250.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (50, 88715740, 'productimg/2019/3/88715740/O1CN01jV8Ok91sVACIVYqZr_!!0-item_pic.jpg_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (51, 88715740, 'productimg/2019/3/88715740/TB1tlLzhLuSBuNkHFqDYXFfhVXa_M2.SS2_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (52, 88715740, 'productimg/2019/3/88715740/TB2j2oee9YTBKNjSZKbXXXJ8pXa_!!133035771.jpg_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (53, 88715740, 'productimg/2019/3/88715740/TB2WMseeYwrBKNjSZPcXXXpapXa_!!133035771.jpg_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (54, 88715740, 'productimg/2019/3/88715740/TB13MG1qntYBeNjy1XdYXFXyVXa_M2.SS2_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (55, 88715740, 'productimg/2019/3/88715740/TB29rDwhMKTBuNkSne1XXaJoXXa_!!133035771.jpg_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (56, 88715741, 'productimg/2019/3/88715741/O1CN01bXLEaj1f965IsqdLi_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (57, 88715741, 'productimg/2019/3/88715741/O1CN011f9647DR7ZjrJeX_!!3538793963.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (58, 88715741, 'productimg/2019/3/88715741/O1CN011f9647f0lwgr6GB_!!3538793963.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (59, 88715741, 'productimg/2019/3/88715741/O1CN011f9648iWxWaQmIV_!!3538793963.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (60, 88715741, 'productimg/2019/3/88715741/O1CN011f9648OFo47Wl7s_!!3538793963.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (61, 88715742, 'productimg/2019/3/88715742/TB2dnrUn90mpuFjSZPiXXbssVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (62, 88715742, 'productimg/2019/3/88715742/TB2dnrUn90mpuFjSZPiXXbssVXa_!!411005513.jpg_400x400.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (63, 88715742, 'productimg/2019/3/88715742/O1CN01yepzi11qb00fMkmDT_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (64, 88715742, 'productimg/2019/3/88715742/TB2CBd7ActnpuFjSZFKXXalFFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (65, 88715742, 'productimg/2019/3/88715742/TB2Or1wiMvD8KJjSsplXXaIEFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (66, 88715742, 'productimg/2019/3/88715742/TB2q8jqlHXlpuFjSszfXXcSGXXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (67, 88715742, 'productimg/2019/3/88715742/TB2XNnxn4BmpuFjSZFsXXcXpFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (68, 88715743, 'productimg/2019/3/88715743/O1CN01Wkjnen1ghHGeti6e5_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (69, 88715743, 'productimg/2019/3/88715743/O1CN011ghHFGFUXXqag5h_!!3316404173.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (70, 88715743, 'productimg/2019/3/88715743/TB1_M7AjTlYBeNjSszcYXHwhFXa_M2.SS2_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (71, 88715743, 'productimg/2019/3/88715743/TB1pI6CjKuSBuNjy1XcYXIYjFXa_M2.SS2_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (72, 88715743, 'productimg/2019/3/88715743/TB1TD66jUR1BeNjy0FmYXH0wVXa_M2.SS2_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (73, 88715744, 'productimg/2019/3/88715744/O1CN01n4gxoU2Ccl3yVXXzl_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (74, 88715744, 'productimg/2019/3/88715744/TB2Ew8NqIUrBKNjSZPxXXX00pXa_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (75, 88715744, 'productimg/2019/3/88715744/TB2GwgIqOAnBKNjSZFvXXaTKXXa_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (76, 88715744, 'productimg/2019/3/88715744/TB2ies.qAZmBKNjSZPiXXXFNVXa_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (77, 88715744, 'productimg/2019/3/88715744/TB2SKxIqGQoBKNjSZJnXXaw9VXa_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (78, 88715745, 'productimg/2019/3/88715745/TB1Req0oruWBuNjSszgXXb8jVXa_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (79, 88715745, 'productimg/2019/3/88715745/TB2bL5ygm8YBeNkSnb4XXaevFXa_!!3878957045.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (80, 88715745, 'productimg/2019/3/88715745/TB2FUFMevImBKNjSZFlXXc43FXa_!!3878957045.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (81, 88715745, 'productimg/2019/3/88715745/TB2lovCoACWBuNjy0FaXXXUlXXa_!!3878957045.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (82, 88715745, 'productimg/2019/3/88715745/TB2XEzqor1YBuNjSszhXXcUsFXa_!!3878957045.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (83, 88715746, 'productimg/2019/3/88715746/TB2iSxot98YBeNkSnb4XXaevFXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (84, 88715746, 'productimg/2019/3/88715746/TB2kix.AkyWBuNjy0FpXXassXXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (85, 88715746, 'productimg/2019/3/88715746/TB2n74MjyQnBKNjSZFmXXcApVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (86, 88715746, 'productimg/2019/3/88715746/TB2pH08AbGYBuNjy0FoXXciBFXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (87, 88715746, 'productimg/2019/3/88715746/TB22e8pCbGYBuNjy0FoXXciBFXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (88, 88715747, 'productimg/2019/3/88715747/O1CN01kOj2y22Ccl4qLoXmz_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (89, 88715747, 'productimg/2019/3/88715747/O1CN01L1kYWh2Ccl4rnivPp_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (90, 88715747, 'productimg/2019/3/88715747/O1CN01w3RrG52Ccl4rGM2dC_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (91, 88715747, 'productimg/2019/3/88715747/O1CN015qC6CV2Ccl4sCw5kc_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (92, 88715747, 'productimg/2019/3/88715747/O1CN0121fw3G2Ccl4p4viau_!!3358098495.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (93, 88715748, 'productimg/2019/3/88715748/TB2NMCoqJcnBKNjSZR0XXcFqFXa_!!124896744.jpg_250x250.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (94, 88715748, 'productimg/2019/3/88715748/TB2E1errOMnBKNjSZFzXXc_qVXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (95, 88715748, 'productimg/2019/3/88715748/TB2guV8rHZnBKNjSZFKXXcGOVXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (96, 88715748, 'productimg/2019/3/88715748/TB2M288rFkoBKNjSZFEXXbrEVXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (97, 88715748, 'productimg/2019/3/88715748/TB2oSqzrRjTBKNjSZFuXXb0HFXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (98, 88715748, 'productimg/2019/3/88715748/TB25vX_rRjTBKNjSZFwXXcG4XXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (99, 88715749, 'productimg/2019/3/88715749/TB2aX8YicLJ8KJjy0FnXXcFDpXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (100, 88715749, 'productimg/2019/3/88715749/O1CN01nlMlWn1zgnY7FqDrJ_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (101, 88715749, 'productimg/2019/3/88715749/O1CN01tFX3IL1zgnZE2hTEf_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (102, 88715749, 'productimg/2019/3/88715749/TB2FYBKibYI8KJjy0FaXXbAiVXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (103, 88715749, 'productimg/2019/3/88715749/TB2JK.9hZrI8KJjy0FhXXbfnpXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (104, 88715749, 'productimg/2019/3/88715749/TB28nhfilTH8KJjy0FiXXcRsXXa_!!124896744.jpg');
INSERT INTO `esm_product_img` VALUES (105, 88715750, 'productimg/2019/3/88715750/TB1EBz1b9tYBeNjSspaXXaOOFXa_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (106, 88715750, 'productimg/2019/3/88715750/TB2_5aub1GSBuNjSspbXXciipXa_!!2263392416.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (107, 88715750, 'productimg/2019/3/88715750/TB2jBFHcAOWBuNjSsppXXXPgpXa_!!2263392416.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (108, 88715750, 'productimg/2019/3/88715750/TB2OiFEahuTBuNkHFNRXXc9qpXa_!!2263392416.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (109, 88715750, 'productimg/2019/3/88715750/TB2TVscb_JYBeNjy1zeXXahzVXa_!!2263392416.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (110, 88715751, 'productimg/2019/3/88715751/O1CN01ODiDaI1DTQRmnu9rS_!!2242500217.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (111, 88715751, 'productimg/2019/3/88715751/O1CN01cjRQ1a1DTQRmQFs5t_!!2242500217.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (112, 88715751, 'productimg/2019/3/88715751/O1CN01LgV5K11DTQRhH7kvu_!!2242500217.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (113, 88715751, 'productimg/2019/3/88715751/O1CN01PRnw5F1DTQRqY9nMr_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (114, 88715751, 'productimg/2019/3/88715751/O1CN0172eFK61DTQRhH81Ya_!!2242500217.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (115, 88715752, 'productimg/2019/3/88715752/O1CN01DuS4nu2HmRWXMvG6I_!!55739193.jpg');
INSERT INTO `esm_product_img` VALUES (116, 88715752, 'productimg/2019/3/88715752/O1CN01F38bpd2HmRWXMwOmC_!!55739193.jpg');
INSERT INTO `esm_product_img` VALUES (117, 88715752, 'productimg/2019/3/88715752/O1CN01FeTxAs2HmRWW9tpLy_!!55739193.jpg');
INSERT INTO `esm_product_img` VALUES (118, 88715752, 'productimg/2019/3/88715752/O1CN01i20vnV2HmRWWQkukR_!!55739193.jpg');
INSERT INTO `esm_product_img` VALUES (119, 88715752, 'productimg/2019/3/88715752/O1CN01oUz3if2HmRWXRvLRo_!!55739193.jpg');
INSERT INTO `esm_product_img` VALUES (120, 88715752, 'productimg/2019/3/88715752/O1CN01SESbca2HmRWYNCyCV_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (121, 88715753, 'productimg/2019/3/88715753/TB2hh.RsiMnBKNjSZFCXXX0KFXa_!!404187285.jpg');
INSERT INTO `esm_product_img` VALUES (122, 88715753, 'productimg/2019/3/88715753/TB2Uam8nwZC2uNjSZFnXXaxZpXa_!!404187285.jpg');
INSERT INTO `esm_product_img` VALUES (123, 88715753, 'productimg/2019/3/88715753/TB26Cj8sXkoBKNjSZFkXXb4tFXa_!!404187285.jpg');
INSERT INTO `esm_product_img` VALUES (124, 88715754, 'productimg/2019/3/88715754/TB1tTV9RXXXXXaAXpXXYXGcGpXX_M2.jpg');
INSERT INTO `esm_product_img` VALUES (125, 88715754, 'productimg/2019/3/88715754/TB2UPbSfmhlpuFjSspkXXa1ApXa_!!82485486.jpg');
INSERT INTO `esm_product_img` VALUES (126, 88715754, 'productimg/2019/3/88715754/TB2Ux04hb_0UKFjy1XaXXbKfXXa_!!82485486.jpg');
INSERT INTO `esm_product_img` VALUES (127, 88715755, 'productimg/2019/3/88715755/O1CN01gAM2qn2MyPxH6hpfi_!!1666879896.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (128, 88715755, 'productimg/2019/3/88715755/O1CN01pljYJh2MyPxIGkdiU_!!1666879896.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (129, 88715755, 'productimg/2019/3/88715755/O1CN01SLd9UW2MyPxB00VIk_!!1666879896.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (130, 88715755, 'productimg/2019/3/88715755/O1CN01vo0eIW2MyPxJY9ouE_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (131, 88715755, 'productimg/2019/3/88715755/O1CN012k5g9S2MyPxB01J99_!!1666879896.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (132, 88715756, 'productimg/2019/3/88715756/O1CN011XjiobP3TwZLQHu_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (133, 88715756, 'productimg/2019/3/88715756/O1CN011Xjiob8W7hyn2tA_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (134, 88715756, 'productimg/2019/3/88715756/O1CN011XjiobG4BcFiDfj_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (135, 88715756, 'productimg/2019/3/88715756/O1CN011XjiobP1TCdeVCU_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (136, 88715756, 'productimg/2019/3/88715756/O1CN011XjioZjhGiktdfL_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (137, 88715756, 'productimg/2019/3/88715756/O1CN011XjioZjig3IbGFM_!!2270682960.jpg');
INSERT INTO `esm_product_img` VALUES (138, 88715757, 'productimg/2019/3/88715757/O1CN01P6G24222AgcbXQM5T_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (139, 88715757, 'productimg/2019/3/88715757/TB2EVw9EY1YBuNjSszeXXablFXa_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (140, 88715757, 'productimg/2019/3/88715757/TB2ODHMwOOYBuNjSsD4XXbSkFXa_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (141, 88715757, 'productimg/2019/3/88715757/TB2SJTDE3aTBuNjSszfXXXgfpXa_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (142, 88715757, 'productimg/2019/3/88715757/TB2t3__wMKTBuNkSne1XXaJoXXa_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (143, 88715757, 'productimg/2019/3/88715757/TB11XVsFbSYBuNjSspfXXcZCpXa_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (144, 88715758, 'productimg/2019/3/88715758/O1CN01ewJLcJ1fQV9pCQPGb_!!2104704001.jpg');
INSERT INTO `esm_product_img` VALUES (145, 88715758, 'productimg/2019/3/88715758/O1CN01Fb7s6S1fQV9rHoVjk_!!2104704001.jpg');
INSERT INTO `esm_product_img` VALUES (146, 88715758, 'productimg/2019/3/88715758/O1CN01kwGiDr1fQV9pu3edZ_!!2104704001.jpg');
INSERT INTO `esm_product_img` VALUES (147, 88715758, 'productimg/2019/3/88715758/O1CN01x1033s1fQV9syM9wL_!!2104704001.jpg');
INSERT INTO `esm_product_img` VALUES (148, 88715758, 'productimg/2019/3/88715758/TB2MA1YhER1BeNjy0FmXXb0wVXa_!!2104704001.jpg');
INSERT INTO `esm_product_img` VALUES (149, 88715759, 'productimg/2019/3/88715759/TB2dufyrv5TBuNjSspmXXaDRVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (150, 88715759, 'productimg/2019/3/88715759/TB2Hftpq49YBuNjy0FfXXXIsVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (151, 88715759, 'productimg/2019/3/88715759/TB2x8sVqH5YBuNjSspoXXbeNFXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (152, 88715759, 'productimg/2019/3/88715759/TB25uoaqL9TBuNjy0FcXXbeiFXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (153, 88715759, 'productimg/2019/3/88715759/TB26RIaqMaTBuNjSszfXXXgfpXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (154, 88715760, 'productimg/2019/3/88715760/TB1tW5IrYwrBKNjSZPcXXXpapXa_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (155, 88715760, 'productimg/2019/3/88715760/TB2BEwZnhSYBuNjSsphXXbGvVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (156, 88715760, 'productimg/2019/3/88715760/TB2bm5WX1UXBuNjt_XBXXXeDXXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (157, 88715760, 'productimg/2019/3/88715760/TB2fzRonv9TBuNjy1zbXXXpepXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (158, 88715760, 'productimg/2019/3/88715760/TB2T0NVhndYBeNkSmLyXXXfnVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (159, 88715761, 'productimg/2019/3/88715761/O1CN011wMCXm22Agd7iEMWM_!!1766737080.jpg_250x250.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (160, 88715761, 'productimg/2019/3/88715761/O1CN01FRM12E22AgdjeECbr_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (161, 88715761, 'productimg/2019/3/88715761/O1CN01JCQDH922AgdkI9j3A_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (162, 88715761, 'productimg/2019/3/88715761/O1CN01pRdLUU22AgdlZsVM3_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (163, 88715761, 'productimg/2019/3/88715761/O1CN01ztnHWA22Agdj4Ijj1_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (164, 88715761, 'productimg/2019/3/88715761/O1CN016Wy4k122AgdhESx69_!!1766737080.jpg');
INSERT INTO `esm_product_img` VALUES (165, 88715762, 'productimg/2019/3/88715762/O1CN01JVrY7Q1QqriPuezpx_!!0-item_pic.jpg_250x250.jpg_.webp.jpg');
INSERT INTO `esm_product_img` VALUES (166, 88715762, 'productimg/2019/3/88715762/O1CN01Af1Kji1QqriOgwg0U_!!3584492028.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (167, 88715762, 'productimg/2019/3/88715762/O1CN01gAH2Og1QqriPNsQH1_!!3584492028.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (168, 88715762, 'productimg/2019/3/88715762/O1CN01HKxPsk1QqriPUw0az_!!3584492028.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (169, 88715762, 'productimg/2019/3/88715762/O1CN013R4jWU1QqriO72UMz_!!3584492028.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (170, 88715762, 'productimg/2019/3/88715762/O1CN016dIBPP1QqriPUyQQc_!!3584492028.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (171, 88715763, 'productimg/2019/3/88715763/O1CN01khPBhF1vYmAJ7eDXP_!!679246185.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (172, 88715763, 'productimg/2019/3/88715763/O1CN01OvmyLk1vYmAHkDMqO_!!679246185.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (173, 88715763, 'productimg/2019/3/88715763/O1CN01scS9CO1vYmAJQuUek_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (174, 88715763, 'productimg/2019/3/88715763/O1CN014zIr0o1vYmAItVNCh_!!679246185.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (175, 88715763, 'productimg/2019/3/88715763/O1CN019e3YKA1vYmAJ8zRzK_!!679246185.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (176, 88715764, 'productimg/2019/3/88715764/TB2kGC_slsmBKNjSZFsXXaXSVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (177, 88715764, 'productimg/2019/3/88715764/TB2R3xVnwZC2uNjSZFnXXaxZpXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (178, 88715764, 'productimg/2019/3/88715764/TB2Uhnzr7ZmBKNjSZPiXXXFNVXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (179, 88715764, 'productimg/2019/3/88715764/TB2xY2lsnqWBKNjSZFxXXcpLpXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (180, 88715764, 'productimg/2019/3/88715764/TB235P4rWAoBKNjSZSyXXaHAVXa_!!2835046187-0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (181, 88715765, 'productimg/2019/3/88715765/TB278_ka7ZmBKNjSZPiXXXFNVXa_!!3487945483.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (182, 88715765, 'productimg/2019/3/88715765/TB2SqxHeuuSBuNjSsziXXbq8pXa_!!3487945483.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (183, 88715765, 'productimg/2019/3/88715765/TB2nvgma_qWBKNjSZFxXXcpLpXa_!!3487945483.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (184, 88715765, 'productimg/2019/3/88715765/TB2I9NaewmTBuNjy1XbXXaMrVXa_!!3487945483.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (185, 88715765, 'productimg/2019/3/88715765/TB1SgljerGYBuNjy0FoXXciBFXa_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (186, 88715766, 'productimg/2019/3/88715766/O1CN011TQhv8uSOQGVlFu_!!4014322377.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (187, 88715766, 'productimg/2019/3/88715766/O1CN011TQhv8Xns5EldYt_!!4014322377.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (188, 88715766, 'productimg/2019/3/88715766/O1CN011TQhv9NG1g13kvW_!!4014322377.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (189, 88715766, 'productimg/2019/3/88715766/O1CN011TQhv9SmEts8272_!!4014322377.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (190, 88715766, 'productimg/2019/3/88715766/O1CN0155hrHu1TQhv9lBv9l_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (191, 88715767, 'productimg/2019/3/88715767/5b0bad85Nc49b4ed5.jpg');
INSERT INTO `esm_product_img` VALUES (192, 88715767, 'productimg/2019/3/88715767/5ad707f2N64880ac2.jpg');
INSERT INTO `esm_product_img` VALUES (193, 88715767, 'productimg/2019/3/88715767/59fc1a3dN3d368364.jpg');
INSERT INTO `esm_product_img` VALUES (194, 88715767, 'productimg/2019/3/88715767/59fc1a3dNfa010535.jpg');
INSERT INTO `esm_product_img` VALUES (195, 88715767, 'productimg/2019/3/88715767/59156f60N45def8f8.jpg');
INSERT INTO `esm_product_img` VALUES (196, 88715767, 'productimg/2019/3/88715767/59156f62Na3905e32.jpg');
INSERT INTO `esm_product_img` VALUES (197, 88715768, 'productimg/2019/3/88715768/5b72d3a6N4c0203aa.jpg');
INSERT INTO `esm_product_img` VALUES (198, 88715768, 'productimg/2019/3/88715768/5b72d36aNdd0c0d39.jpg');
INSERT INTO `esm_product_img` VALUES (199, 88715768, 'productimg/2019/3/88715768/5b72d365N0ad5ffe0.jpg');
INSERT INTO `esm_product_img` VALUES (200, 88715768, 'productimg/2019/3/88715768/5b72d367Nf9c2341f.jpg');
INSERT INTO `esm_product_img` VALUES (201, 88715768, 'productimg/2019/3/88715768/5b72d368N049dfef3.jpg');
INSERT INTO `esm_product_img` VALUES (202, 88715768, 'productimg/2019/3/88715768/5b72d369Nfdd97343.jpg');
INSERT INTO `esm_product_img` VALUES (203, 88715769, 'productimg/2019/3/88715769/1e608bf8654b0b18.jpg');
INSERT INTO `esm_product_img` VALUES (204, 88715769, 'productimg/2019/3/88715769/6bf752aff3b43f27.jpg');
INSERT INTO `esm_product_img` VALUES (205, 88715769, 'productimg/2019/3/88715769/8da8a7fd218e60b2.jpg');
INSERT INTO `esm_product_img` VALUES (206, 88715769, 'productimg/2019/3/88715769/e9b4c1da0692347c.jpg');
INSERT INTO `esm_product_img` VALUES (207, 88715770, 'productimg/2019/3/88715770/5bc4230aN1ce0c0f7.jpg');
INSERT INTO `esm_product_img` VALUES (208, 88715770, 'productimg/2019/3/88715770/5bc42305N98fbb187.jpg');
INSERT INTO `esm_product_img` VALUES (209, 88715770, 'productimg/2019/3/88715770/5bc42306N2db3b5cf.jpg');
INSERT INTO `esm_product_img` VALUES (210, 88715770, 'productimg/2019/3/88715770/5bc42307Ne02ef1a0.jpg');
INSERT INTO `esm_product_img` VALUES (211, 88715770, 'productimg/2019/3/88715770/5bc42308N1af32b97.jpg');
INSERT INTO `esm_product_img` VALUES (212, 88715770, 'productimg/2019/3/88715770/9b0418af779db3b9.jpg');
INSERT INTO `esm_product_img` VALUES (213, 88715771, 'productimg/2019/3/88715771/5bf51520N01f22f38.jpg');
INSERT INTO `esm_product_img` VALUES (214, 88715771, 'productimg/2019/3/88715771/5bf51520Nd27e5c10.jpg');
INSERT INTO `esm_product_img` VALUES (215, 88715771, 'productimg/2019/3/88715771/5bf51521N332ed4ca.jpg');
INSERT INTO `esm_product_img` VALUES (216, 88715771, 'productimg/2019/3/88715771/5bf51522N4bc29bdd.jpg');
INSERT INTO `esm_product_img` VALUES (217, 88715771, 'productimg/2019/3/88715771/5bf51526N8c189ff6.jpg');
INSERT INTO `esm_product_img` VALUES (218, 88715772, 'productimg/2019/3/88715772/98ec3e0e1fd73c9e.jpg');
INSERT INTO `esm_product_img` VALUES (219, 88715772, 'productimg/2019/3/88715772/243e9cc478a03ff3.jpg');
INSERT INTO `esm_product_img` VALUES (220, 88715772, 'productimg/2019/3/88715772/269f1cb16a872875.jpg');
INSERT INTO `esm_product_img` VALUES (221, 88715772, 'productimg/2019/3/88715772/0322b24908e34b96.jpg');
INSERT INTO `esm_product_img` VALUES (222, 88715772, 'productimg/2019/3/88715772/33481ec5234843ac.jpg');

-- ----------------------------
-- Table structure for esm_property
-- ----------------------------
DROP TABLE IF EXISTS `esm_property`;
CREATE TABLE `esm_property`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `cate_id` int(11) NULL DEFAULT NULL COMMENT '分类ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cate_id`(`cate_id`) USING BTREE,
  CONSTRAINT `esm_property_ibfk_1` FOREIGN KEY (`cate_id`) REFERENCES `esm_cate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_property
-- ----------------------------
INSERT INTO `esm_property` VALUES (1, 16, '品牌');
INSERT INTO `esm_property` VALUES (2, 16, '上市年份季节');
INSERT INTO `esm_property` VALUES (3, 16, '尺码');
INSERT INTO `esm_property` VALUES (4, 16, '颜色分类');
INSERT INTO `esm_property` VALUES (5, 20, '品牌');
INSERT INTO `esm_property` VALUES (6, 20, '尺码');
INSERT INTO `esm_property` VALUES (8, 20, '货号');
INSERT INTO `esm_property` VALUES (9, 20, '上市年份季节');
INSERT INTO `esm_property` VALUES (10, 20, '材质成分');
INSERT INTO `esm_property` VALUES (11, 20, '颜色分类');
INSERT INTO `esm_property` VALUES (12, 19, '品牌');
INSERT INTO `esm_property` VALUES (13, 19, '适用年龄');
INSERT INTO `esm_property` VALUES (14, 19, '尺码');
INSERT INTO `esm_property` VALUES (15, 19, '颜色分类');
INSERT INTO `esm_property` VALUES (16, 19, '上市年份季节');
INSERT INTO `esm_property` VALUES (17, 19, '材质成分');
INSERT INTO `esm_property` VALUES (18, 19, '货号');
INSERT INTO `esm_property` VALUES (19, 18, '品牌');
INSERT INTO `esm_property` VALUES (20, 18, '尺码');
INSERT INTO `esm_property` VALUES (21, 18, '颜色分类');
INSERT INTO `esm_property` VALUES (22, 18, '货号');
INSERT INTO `esm_property` VALUES (23, 18, '上市年份季节');
INSERT INTO `esm_property` VALUES (24, 18, '材质成分');
INSERT INTO `esm_property` VALUES (25, 17, '品牌');
INSERT INTO `esm_property` VALUES (26, 17, '适用年龄');
INSERT INTO `esm_property` VALUES (27, 17, '材质成分');
INSERT INTO `esm_property` VALUES (28, 17, '尺码');
INSERT INTO `esm_property` VALUES (29, 17, '颜色分类');
INSERT INTO `esm_property` VALUES (30, 17, '货号');
INSERT INTO `esm_property` VALUES (31, 17, '上市年份季节');
INSERT INTO `esm_property` VALUES (32, 17, '材质');
INSERT INTO `esm_property` VALUES (33, 22, '品牌');
INSERT INTO `esm_property` VALUES (34, 22, '尺码');
INSERT INTO `esm_property` VALUES (35, 22, '颜色分类');
INSERT INTO `esm_property` VALUES (36, 22, '货号');
INSERT INTO `esm_property` VALUES (37, 22, '上市年份季节');
INSERT INTO `esm_property` VALUES (38, 22, '材质成分');
INSERT INTO `esm_property` VALUES (39, 23, '品牌名称');
INSERT INTO `esm_property` VALUES (40, 23, '上市年份季节');
INSERT INTO `esm_property` VALUES (41, 23, '尺码');
INSERT INTO `esm_property` VALUES (42, 23, '货号');
INSERT INTO `esm_property` VALUES (43, 23, '材质成分');
INSERT INTO `esm_property` VALUES (44, 23, '颜色分类');
INSERT INTO `esm_property` VALUES (45, 24, '品牌');
INSERT INTO `esm_property` VALUES (46, 24, '适用年龄');
INSERT INTO `esm_property` VALUES (47, 24, '尺码');
INSERT INTO `esm_property` VALUES (48, 24, '颜色分类');
INSERT INTO `esm_property` VALUES (49, 24, '货号');
INSERT INTO `esm_property` VALUES (50, 24, '上市年份季节');
INSERT INTO `esm_property` VALUES (51, 24, '材质成分');
INSERT INTO `esm_property` VALUES (52, 25, '品牌');
INSERT INTO `esm_property` VALUES (53, 25, '闭合方式');
INSERT INTO `esm_property` VALUES (54, 25, '尺码');
INSERT INTO `esm_property` VALUES (55, 25, '图案');
INSERT INTO `esm_property` VALUES (56, 25, '风格');
INSERT INTO `esm_property` VALUES (57, 25, '鞋头款式');
INSERT INTO `esm_property` VALUES (58, 25, '流行元素');
INSERT INTO `esm_property` VALUES (59, 25, '后跟高');
INSERT INTO `esm_property` VALUES (60, 25, '颜色分类');
INSERT INTO `esm_property` VALUES (61, 25, '上市年份季节');
INSERT INTO `esm_property` VALUES (62, 25, '鞋底材质');
INSERT INTO `esm_property` VALUES (63, 26, '品牌名称');
INSERT INTO `esm_property` VALUES (64, 26, '上市年份季节');
INSERT INTO `esm_property` VALUES (65, 26, '风格');
INSERT INTO `esm_property` VALUES (66, 26, '鞋头款式');
INSERT INTO `esm_property` VALUES (67, 26, '尺码');
INSERT INTO `esm_property` VALUES (68, 26, '流行元素');
INSERT INTO `esm_property` VALUES (69, 26, '颜色分类');

-- ----------------------------
-- Table structure for esm_propertyvalue
-- ----------------------------
DROP TABLE IF EXISTS `esm_propertyvalue`;
CREATE TABLE `esm_propertyvalue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `property_id` int(11) NULL DEFAULT NULL COMMENT '属性ID',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `property_id`(`property_id`) USING BTREE,
  CONSTRAINT `esm_propertyvalue_ibfk_2` FOREIGN KEY (`property_id`) REFERENCES `esm_property` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_propertyvalue_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 293 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_propertyvalue
-- ----------------------------
INSERT INTO `esm_propertyvalue` VALUES (1, 86626581, 1, '钟灵记');
INSERT INTO `esm_propertyvalue` VALUES (2, 86626581, 2, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (3, 86626581, 3, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (4, 86626581, 4, '上襦一件 下裙一件 吊带一件 上襦1件 下裙1件 吊带1件 吊带1件. 下裙1件. 上襦一件.');
INSERT INTO `esm_propertyvalue` VALUES (5, 88715736, 1, '钟灵记');
INSERT INTO `esm_propertyvalue` VALUES (6, 88715736, 2, '2017年春季');
INSERT INTO `esm_propertyvalue` VALUES (7, 88715736, 3, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (8, 88715736, 4, '齐胸裙（不含上襦、批帛） 吊带一件 上襦1件 齐腰下裙一件 上襦一件 齐胸裙（不含上襦、批帛) 齐腰下裙1件 吊带1件');
INSERT INTO `esm_propertyvalue` VALUES (9, 87754945, 1, '钟灵记');
INSERT INTO `esm_propertyvalue` VALUES (10, 87754945, 2, '2017年春季');
INSERT INTO `esm_propertyvalue` VALUES (11, 87754945, 3, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (12, 87754945, 4, '齐胸裙（不含上襦、批帛） 吊带一件 上襦1件 齐腰下裙一件 上襦一件 齐胸裙（不含上襦、批帛) 齐腰下裙1件 吊带1件');
INSERT INTO `esm_propertyvalue` VALUES (13, 82522957, 1, '钟灵记');
INSERT INTO `esm_propertyvalue` VALUES (14, 82522957, 2, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (15, 82522957, 3, 'M+ S+ XS S M L 均码');
INSERT INTO `esm_propertyvalue` VALUES (16, 82522957, 4, '上襦一件 齐胸下裙一件 齐腰下裙 齐胸下裙1件 上襦一件. 齐胸下裙一件. 齐腰下裙1件');
INSERT INTO `esm_propertyvalue` VALUES (17, 82522958, 5, '如梦霓裳');
INSERT INTO `esm_propertyvalue` VALUES (18, 82522958, 6, '155 160 165 170');
INSERT INTO `esm_propertyvalue` VALUES (19, 82522958, 8, '襦裙[翎羽]');
INSERT INTO `esm_propertyvalue` VALUES (20, 82522958, 9, '2018年冬季');
INSERT INTO `esm_propertyvalue` VALUES (21, 82522958, 10, '其他100%');
INSERT INTO `esm_propertyvalue` VALUES (22, 82522958, 11, '黑色上襦.一件 现货 黑色上襦.一件 预售 30天左右发货 白色上襦.一件 现货 白色上襦.一件 预售 30天左右发货 肉色上襦.一件 现货 肉色上襦.一件 预售 30天左右发货 黑红下裙.一件 现货 黑红下裙.一件 预售 30天左右发货 浅蓝下裙.一件 现货 浅蓝下裙.一件 预售 30天左右发货');
INSERT INTO `esm_propertyvalue` VALUES (23, 82522959, 5, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (24, 82522959, 6, '155 160 165 170');
INSERT INTO `esm_propertyvalue` VALUES (25, 82522959, 8, 'HFJY1235');
INSERT INTO `esm_propertyvalue` VALUES (26, 82522959, 9, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (27, 82522959, 10, '聚对苯二甲酸乙二酯(涤纶)100%');
INSERT INTO `esm_propertyvalue` VALUES (28, 82522959, 11, '仅浅肉粉上襦 现货 仅浅肉粉上襦 预售 仅深红色下裙  现货 仅深红色下裙 预售');
INSERT INTO `esm_propertyvalue` VALUES (29, 88715737, 5, '蜜形');
INSERT INTO `esm_propertyvalue` VALUES (30, 88715737, 6, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (31, 88715737, 8, 'MX001');
INSERT INTO `esm_propertyvalue` VALUES (32, 88715737, 9, '2018年冬季');
INSERT INTO `esm_propertyvalue` VALUES (33, 88715737, 10, '聚酯纤维100%');
INSERT INTO `esm_propertyvalue` VALUES (34, 88715737, 11, '蓝色四件套【送发带】 蓝色四件套【送发带+折扇】 秋水款');
INSERT INTO `esm_propertyvalue` VALUES (35, 88715738, 5, '汉尚华莲');
INSERT INTO `esm_propertyvalue` VALUES (36, 88715738, 6, 'XS S M L');
INSERT INTO `esm_propertyvalue` VALUES (37, 88715738, 8, 'HJL219');
INSERT INTO `esm_propertyvalue` VALUES (38, 88715738, 9, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (39, 88715738, 10, '聚对苯二甲酸乙二酯(涤纶)100%');
INSERT INTO `esm_propertyvalue` VALUES (40, 88715738, 11, '仅交领襦裙一套-3月20日发货 仅交领襦裙一套-4月30日发货');
INSERT INTO `esm_propertyvalue` VALUES (41, 88715739, 12, '绒莲');
INSERT INTO `esm_propertyvalue` VALUES (42, 88715739, 13, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (43, 88715739, 14, 'S M L');
INSERT INTO `esm_propertyvalue` VALUES (44, 88715739, 15, '绿色半臂 白色上襦 两片式齐胸下裙');
INSERT INTO `esm_propertyvalue` VALUES (45, 88715739, 16, '2018年秋季');
INSERT INTO `esm_propertyvalue` VALUES (46, 88715739, 17, '其他100%');
INSERT INTO `esm_propertyvalue` VALUES (47, 88715739, 18, 'R185520');
INSERT INTO `esm_propertyvalue` VALUES (48, 88715740, 12, '都城南庄');
INSERT INTO `esm_propertyvalue` VALUES (49, 88715740, 13, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (50, 88715740, 14, 'S（4月初陆续发货） M（4月初陆续发货） L（4月初陆续发货） XL（4月初陆续发货）');
INSERT INTO `esm_propertyvalue` VALUES (51, 88715740, 15, '浅黄色');
INSERT INTO `esm_propertyvalue` VALUES (52, 88715740, 16, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (53, 88715740, 17, '仿真丝绸');
INSERT INTO `esm_propertyvalue` VALUES (54, 88715740, 18, 'R185527');
INSERT INTO `esm_propertyvalue` VALUES (55, 88715741, 12, '流烟昔泠');
INSERT INTO `esm_propertyvalue` VALUES (56, 88715741, 13, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (57, 88715741, 14, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (58, 88715741, 15, '清霜上襦 清霜半臂 清霜下裙');
INSERT INTO `esm_propertyvalue` VALUES (59, 88715741, 16, '2018年秋季');
INSERT INTO `esm_propertyvalue` VALUES (60, 88715741, 17, '聚对苯二甲酸乙二酯(涤纶)97% 聚氨酯弹性纤维(氨纶)3%');
INSERT INTO `esm_propertyvalue` VALUES (61, 88715741, 18, 'L8BSQSB31');
INSERT INTO `esm_propertyvalue` VALUES (62, 88715742, 12, '钟灵记');
INSERT INTO `esm_propertyvalue` VALUES (63, 88715742, 13, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (64, 88715742, 14, 'S M L');
INSERT INTO `esm_propertyvalue` VALUES (65, 88715742, 15, '上襦一件 半臂一件 下裙一件 半臂1件 上襦1件 下裙1件');
INSERT INTO `esm_propertyvalue` VALUES (66, 88715742, 16, '2017年春季');
INSERT INTO `esm_propertyvalue` VALUES (67, 88715742, 17, '其他100%');
INSERT INTO `esm_propertyvalue` VALUES (68, 88715742, 18, 'L8BSQ565');
INSERT INTO `esm_propertyvalue` VALUES (69, 88715743, 19, 'XOOiiOOR/旭图');
INSERT INTO `esm_propertyvalue` VALUES (70, 88715743, 20, 'XXL S M L XL XXXL 加大XXXL');
INSERT INTO `esm_propertyvalue` VALUES (71, 88715743, 21, '逍遥客（上襦+襦裙+披帛） 慈航静（上襦+襦裙+披帛） 胸前印花（上衣+襦裙+外批+批帛） 胸前无印花（上衣+襦裙+外批+批帛） 凤歌鸾（上襦+襦裙+披帛） 妙上（上衣+襦裙+披帛）浅蓝色 妙上（上衣+襦裙+披帛）浅紫色');
INSERT INTO `esm_propertyvalue` VALUES (72, 88715743, 22, '妙上襦裙');
INSERT INTO `esm_propertyvalue` VALUES (73, 88715743, 23, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (74, 88715743, 24, '其他100%');
INSERT INTO `esm_propertyvalue` VALUES (75, 88715744, 19, '汉尚华莲');
INSERT INTO `esm_propertyvalue` VALUES (76, 88715744, 20, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (77, 88715744, 21, '上襦+下裙一套（内衬4米裙摆）-3月31日发货 上襦+下裙一套（内衬6米裙摆）-4月10日发货 上襦+下裙一套（内衬4米裙摆）-4月30日发货 上襦+下裙一套（内衬6米裙摆）-5月20日发货');
INSERT INTO `esm_propertyvalue` VALUES (78, 88715744, 22, 'HQX205');
INSERT INTO `esm_propertyvalue` VALUES (79, 88715744, 23, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (80, 88715744, 24, '聚酯纤维100%');
INSERT INTO `esm_propertyvalue` VALUES (81, 88715745, 19, '追忆云裳');
INSERT INTO `esm_propertyvalue` VALUES (82, 88715745, 20, 'S M L');
INSERT INTO `esm_propertyvalue` VALUES (83, 88715745, 21, '慈航净');
INSERT INTO `esm_propertyvalue` VALUES (84, 88715745, 22, '17459L41756');
INSERT INTO `esm_propertyvalue` VALUES (85, 88715745, 23, '2017年春季');
INSERT INTO `esm_propertyvalue` VALUES (86, 88715745, 24, '其他100.00%');
INSERT INTO `esm_propertyvalue` VALUES (87, 88715746, 19, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (88, 88715746, 20, '155 160 165 170');
INSERT INTO `esm_propertyvalue` VALUES (89, 88715746, 21, '浅黄上衣+浅粉蓝拼色交窬裙 预售3月31号陆续发货 浅黄上衣+浅粉蓝拼色交窬裙 现货 浅粉上衣+浅黄绿拼色交窬裙 预售3月31号陆续发货 浅粉上衣+浅黄绿拼色交窬裙 现货');
INSERT INTO `esm_propertyvalue` VALUES (90, 88715746, 22, 'HFXY2133');
INSERT INTO `esm_propertyvalue` VALUES (91, 88715746, 23, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (92, 88715746, 24, '新型聚酯纤维100%');
INSERT INTO `esm_propertyvalue` VALUES (93, 88715747, 25, '汉尚华莲');
INSERT INTO `esm_propertyvalue` VALUES (94, 88715747, 26, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (95, 88715747, 27, '聚酯纤维100%');
INSERT INTO `esm_propertyvalue` VALUES (96, 88715747, 28, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (97, 88715747, 29, '齐胸襦裙一套-3月31日发货 齐胸襦裙一套-4月30日发货');
INSERT INTO `esm_propertyvalue` VALUES (98, 88715747, 30, 'HQX209');
INSERT INTO `esm_propertyvalue` VALUES (99, 88715747, 31, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (100, 88715747, 32, '涤纶');
INSERT INTO `esm_propertyvalue` VALUES (101, 88715748, 25, '汉尚华莲');
INSERT INTO `esm_propertyvalue` VALUES (102, 88715748, 26, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (103, 88715748, 27, '涤纶  96%及以上');
INSERT INTO `esm_propertyvalue` VALUES (104, 88715748, 28, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (105, 88715748, 29, '仅大袖衫一件-3月31日发货 上襦+下裙+头纱-4月20日发货 仅大袖衫一件-4月30日发货 上襦+下裙+头纱-5月20日发货');
INSERT INTO `esm_propertyvalue` VALUES (106, 88715748, 30, 'HQX206');
INSERT INTO `esm_propertyvalue` VALUES (107, 88715748, 31, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (108, 88715748, 32, '涤纶');
INSERT INTO `esm_propertyvalue` VALUES (109, 88715749, 25, '汉尚华莲');
INSERT INTO `esm_propertyvalue` VALUES (110, 88715749, 26, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (111, 88715749, 27, '涤纶  96%及以上');
INSERT INTO `esm_propertyvalue` VALUES (112, 88715749, 28, 'XS S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (113, 88715749, 29, '仅齐胸襦裙一套-3月31日发货 仅齐胸襦裙一套-4月30日发货');
INSERT INTO `esm_propertyvalue` VALUES (114, 88715749, 30, 'HQX139');
INSERT INTO `esm_propertyvalue` VALUES (115, 88715749, 31, '2017年冬季');
INSERT INTO `esm_propertyvalue` VALUES (116, 88715749, 32, '涤纶');
INSERT INTO `esm_propertyvalue` VALUES (117, 88715750, 25, '陛下兰他惜');
INSERT INTO `esm_propertyvalue` VALUES (118, 88715750, 26, '25-29周岁');
INSERT INTO `esm_propertyvalue` VALUES (119, 88715750, 27, '聚酯纤维98% 其他2%\r\n');
INSERT INTO `esm_propertyvalue` VALUES (120, 88715750, 28, 'S M L');
INSERT INTO `esm_propertyvalue` VALUES (121, 88715750, 29, '月光蓝（预售） 月光蓝（现货）');
INSERT INTO `esm_propertyvalue` VALUES (122, 88715750, 30, '共婵娟/ T1219');
INSERT INTO `esm_propertyvalue` VALUES (123, 88715750, 31, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (124, 88715750, 32, '其他');
INSERT INTO `esm_propertyvalue` VALUES (125, 88715751, 33, '卡都狼');
INSERT INTO `esm_propertyvalue` VALUES (126, 88715751, 34, 'S M L XL 均码');
INSERT INTO `esm_propertyvalue` VALUES (127, 88715751, 35, '红上衣套装 黑色套装 腰带绣龙均码 腰带绣凤均码');
INSERT INTO `esm_propertyvalue` VALUES (128, 88715751, 36, '99928L76712');
INSERT INTO `esm_propertyvalue` VALUES (129, 88715751, 37, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (131, 88715751, 38, '其他100.00%\r\n');
INSERT INTO `esm_propertyvalue` VALUES (132, 88715752, 33, 'other/其他');
INSERT INTO `esm_propertyvalue` VALUES (133, 88715752, 34, '定做 S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (134, 88715752, 35, '红上衣套装(女) 黑上衣套装(男) 黑上衣套装(男)+腰带绣龙 红上衣套装(女)+腰带绣凤');
INSERT INTO `esm_propertyvalue` VALUES (135, 88715752, 36, '叙6068+6069');
INSERT INTO `esm_propertyvalue` VALUES (136, 88715752, 37, '2019年');
INSERT INTO `esm_propertyvalue` VALUES (137, 88715752, 38, '其他');
INSERT INTO `esm_propertyvalue` VALUES (138, 88715753, 33, '其他');
INSERT INTO `esm_propertyvalue` VALUES (139, 88715753, 34, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (140, 88715753, 35, '玄端 皂靴+梁冠');
INSERT INTO `esm_propertyvalue` VALUES (142, 88715753, 36, '99928L7656');
INSERT INTO `esm_propertyvalue` VALUES (143, 88715753, 37, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (144, 88715753, 38, NULL);
INSERT INTO `esm_propertyvalue` VALUES (145, 88715754, 33, 'B．L．WEIMAN/保珞威蔓');
INSERT INTO `esm_propertyvalue` VALUES (146, 88715754, 34, '175/96A');
INSERT INTO `esm_propertyvalue` VALUES (147, 88715754, 35, '红色');
INSERT INTO `esm_propertyvalue` VALUES (148, 88715754, 36, NULL);
INSERT INTO `esm_propertyvalue` VALUES (149, 88715754, 37, NULL);
INSERT INTO `esm_propertyvalue` VALUES (150, 88715754, 38, NULL);
INSERT INTO `esm_propertyvalue` VALUES (151, 88715755, 39, '诺俏儿');
INSERT INTO `esm_propertyvalue` VALUES (152, 88715755, 40, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (153, 88715755, 41, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (154, 88715755, 42, 'NQE19C12006');
INSERT INTO `esm_propertyvalue` VALUES (155, 88715755, 43, '聚酯纤维85% 聚对苯二甲酸乙二酯(涤纶)15%');
INSERT INTO `esm_propertyvalue` VALUES (156, 88715755, 44, '5537粉色短褐+5535米白裤子 5537蓝色短褐+5537深灰裤子 5537红色短褐+5535米白裤子 5537黑色短褐+5537深灰裤子 5537粉色短褐 5537浅蓝色短褐 5537红色短褐 5537黑色短褐 仅米白裤子5535 仅深灰裤子5535');
INSERT INTO `esm_propertyvalue` VALUES (157, 88715756, 39, 'other/其他');
INSERT INTO `esm_propertyvalue` VALUES (158, 88715756, 40, '2018年');
INSERT INTO `esm_propertyvalue` VALUES (159, 88715756, 41, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (160, 88715756, 42, '2650375');
INSERT INTO `esm_propertyvalue` VALUES (161, 88715756, 43, NULL);
INSERT INTO `esm_propertyvalue` VALUES (162, 88715756, 44, '仅一件粉色短褐 仅一件白色裤子 粉色短褐+白裤子 仅一件蓝色短褐 仅一件深灰裤子 蓝色短褐+深灰裤子');
INSERT INTO `esm_propertyvalue` VALUES (163, 88715757, 39, '流烟昔泠');
INSERT INTO `esm_propertyvalue` VALUES (164, 88715757, 40, '2018年夏季');
INSERT INTO `esm_propertyvalue` VALUES (165, 88715757, 41, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (166, 88715757, 42, NULL);
INSERT INTO `esm_propertyvalue` VALUES (167, 88715757, 43, NULL);
INSERT INTO `esm_propertyvalue` VALUES (168, 88715757, 44, '溯洄男款（赠送手部绑带） 溯洄女款（赠送手部绑带） 腰带（均码）');
INSERT INTO `esm_propertyvalue` VALUES (169, 88715758, 39, '其他');
INSERT INTO `esm_propertyvalue` VALUES (170, 88715758, 40, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (171, 88715758, 41, 'S M L XL XXL');
INSERT INTO `esm_propertyvalue` VALUES (172, 88715758, 42, NULL);
INSERT INTO `esm_propertyvalue` VALUES (173, 88715758, 43, NULL);
INSERT INTO `esm_propertyvalue` VALUES (174, 88715758, 44, '6012黑色 半壁 6013长袖（配手绳） 6011黑色裤子');
INSERT INTO `esm_propertyvalue` VALUES (175, 88715759, 45, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (176, 88715759, 46, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (177, 88715759, 47, '165 170 175 180');
INSERT INTO `esm_propertyvalue` VALUES (178, 88715759, 48, '黑色半臂 现货 黑色半臂 预售 白色里衣(不含绑手带) 现货 白色里衣(不含绑手带)  预售 红色下裙 现货 红色下裙 预售');
INSERT INTO `esm_propertyvalue` VALUES (179, 88715759, 49, 'HFB2072');
INSERT INTO `esm_propertyvalue` VALUES (180, 88715759, 50, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (181, 88715759, 51, '聚对苯二甲酸乙二酯(涤纶)100%');
INSERT INTO `esm_propertyvalue` VALUES (182, 88715760, 45, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (183, 88715760, 46, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (184, 88715760, 47, '155 160 165 170');
INSERT INTO `esm_propertyvalue` VALUES (185, 88715760, 48, '白色上襦 现货 白色上襦  预售3月15号陆续发货 玉色半臂 现货 玉色半臂  预售3月15号陆续发货 红色半臂 现货 红色半臂  预售3月15号陆续发货 间色破裙 现货 间色破裙  预售');
INSERT INTO `esm_propertyvalue` VALUES (186, 88715760, 49, 'HFEJY2063');
INSERT INTO `esm_propertyvalue` VALUES (187, 88715760, 50, '2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (188, 88715760, 51, '棉100%');
INSERT INTO `esm_propertyvalue` VALUES (189, 88715761, 45, '流烟昔泠');
INSERT INTO `esm_propertyvalue` VALUES (190, 88715761, 46, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (191, 88715761, 47, 'S M L XL');
INSERT INTO `esm_propertyvalue` VALUES (192, 88715761, 48, '女款半臂 女款上襦 女款下裳 男款半臂 男款上襦 男款下裳');
INSERT INTO `esm_propertyvalue` VALUES (193, 88715761, 49, NULL);
INSERT INTO `esm_propertyvalue` VALUES (194, 88715761, 50, '2018年冬季');
INSERT INTO `esm_propertyvalue` VALUES (195, 88715761, 51, NULL);
INSERT INTO `esm_propertyvalue` VALUES (196, 88715762, 45, '沐汉风');
INSERT INTO `esm_propertyvalue` VALUES (197, 88715762, 46, '18-25周岁');
INSERT INTO `esm_propertyvalue` VALUES (198, 88715762, 47, NULL);
INSERT INTO `esm_propertyvalue` VALUES (199, 88715762, 48, NULL);
INSERT INTO `esm_propertyvalue` VALUES (200, 88715762, 49, 'MF080');
INSERT INTO `esm_propertyvalue` VALUES (201, 88715762, 50, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (202, 88715762, 51, '其他100%');
INSERT INTO `esm_propertyvalue` VALUES (203, 88715763, 52, '京儿丫秀');
INSERT INTO `esm_propertyvalue` VALUES (204, 88715763, 53, '一字式扣带');
INSERT INTO `esm_propertyvalue` VALUES (205, 88715763, 54, '35 36 37 38 39 40');
INSERT INTO `esm_propertyvalue` VALUES (206, 88715763, 55, '植物花卉');
INSERT INTO `esm_propertyvalue` VALUES (207, 88715763, 56, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (208, 88715763, 57, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (209, 88715763, 58, '防水台 绣花');
INSERT INTO `esm_propertyvalue` VALUES (210, 88715763, 59, '低跟(1-3cm)');
INSERT INTO `esm_propertyvalue` VALUES (211, 88715763, 60, '灰色（银鼠灰） 米色（藕荷色） 绿色（玉簪绿）');
INSERT INTO `esm_propertyvalue` VALUES (212, 88715763, 61, '2019年春季');
INSERT INTO `esm_propertyvalue` VALUES (213, 88715763, 62, '布');
INSERT INTO `esm_propertyvalue` VALUES (214, 88715764, 52, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (215, 88715764, 53, NULL);
INSERT INTO `esm_propertyvalue` VALUES (216, 88715764, 54, '34 35 36 37 38 39');
INSERT INTO `esm_propertyvalue` VALUES (217, 88715764, 55, NULL);
INSERT INTO `esm_propertyvalue` VALUES (218, 88715764, 56, NULL);
INSERT INTO `esm_propertyvalue` VALUES (219, 88715764, 57, NULL);
INSERT INTO `esm_propertyvalue` VALUES (220, 88715764, 58, NULL);
INSERT INTO `esm_propertyvalue` VALUES (221, 88715764, 59, NULL);
INSERT INTO `esm_propertyvalue` VALUES (222, 88715764, 60, '粉色弓鞋 现货 粉色弓鞋 预售 蓝色弓鞋 现货 蓝色弓鞋 预售');
INSERT INTO `esm_propertyvalue` VALUES (223, 88715764, 61, '2018年秋季');
INSERT INTO `esm_propertyvalue` VALUES (224, 88715764, 62, NULL);
INSERT INTO `esm_propertyvalue` VALUES (225, 88715765, 63, '洪濑');
INSERT INTO `esm_propertyvalue` VALUES (226, 88715765, 64, '2017年秋季');
INSERT INTO `esm_propertyvalue` VALUES (227, 88715765, 65, '休闲');
INSERT INTO `esm_propertyvalue` VALUES (228, 88715765, 66, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (229, 88715765, 67, '34 35 36 37 38 39 40');
INSERT INTO `esm_propertyvalue` VALUES (230, 88715765, 68, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (231, 88715765, 69, '海棠白色 海棠浅蓝');
INSERT INTO `esm_propertyvalue` VALUES (232, 88715766, 63, '简百莲');
INSERT INTO `esm_propertyvalue` VALUES (233, 88715766, 64, '2018年秋季');
INSERT INTO `esm_propertyvalue` VALUES (234, 88715766, 65, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (235, 88715766, 66, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (236, 88715766, 67, '34 35 36 37 38 39 40');
INSERT INTO `esm_propertyvalue` VALUES (237, 88715766, 68, '浅口 花朵');
INSERT INTO `esm_propertyvalue` VALUES (238, 88715766, 69, '米白1(清荷) 浅蓝1(清荷) 白色2(碧游) 灰色2(碧游) 白色3(清欢) 粉色3(清欢)');
INSERT INTO `esm_propertyvalue` VALUES (239, 88715767, 52, '步瀛斋');
INSERT INTO `esm_propertyvalue` VALUES (240, 88715767, 53, '套脚');
INSERT INTO `esm_propertyvalue` VALUES (241, 88715767, 54, '39');
INSERT INTO `esm_propertyvalue` VALUES (242, 88715767, 55, '花纹');
INSERT INTO `esm_propertyvalue` VALUES (243, 88715767, 56, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (244, 88715767, 57, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (245, 88715767, 58, '车缝线，绣花');
INSERT INTO `esm_propertyvalue` VALUES (246, 88715767, 59, '平跟');
INSERT INTO `esm_propertyvalue` VALUES (247, 88715767, 60, '千底蓝印花盘扣女鞋蓝色');
INSERT INTO `esm_propertyvalue` VALUES (248, 88715767, 61, '2017秋季');
INSERT INTO `esm_propertyvalue` VALUES (249, 88715767, 62, NULL);
INSERT INTO `esm_propertyvalue` VALUES (250, 88715768, 52, '怡品堂');
INSERT INTO `esm_propertyvalue` VALUES (251, 88715768, 53, '系带');
INSERT INTO `esm_propertyvalue` VALUES (252, 88715768, 54, '大于40');
INSERT INTO `esm_propertyvalue` VALUES (253, 88715768, 55, '花纹');
INSERT INTO `esm_propertyvalue` VALUES (254, 88715768, 56, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (255, 88715768, 57, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (256, 88715768, 58, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (257, 88715768, 59, '内增高');
INSERT INTO `esm_propertyvalue` VALUES (258, 88715768, 60, '白色');
INSERT INTO `esm_propertyvalue` VALUES (259, 88715768, 61, '2018秋季');
INSERT INTO `esm_propertyvalue` VALUES (260, 88715768, 62, NULL);
INSERT INTO `esm_propertyvalue` VALUES (261, 88715769, 52, '驭驾者（YUJIAZHE）');
INSERT INTO `esm_propertyvalue` VALUES (262, 88715769, 53, '套脚');
INSERT INTO `esm_propertyvalue` VALUES (263, 88715769, 54, '37');
INSERT INTO `esm_propertyvalue` VALUES (264, 88715769, 55, '花纹');
INSERT INTO `esm_propertyvalue` VALUES (265, 88715769, 56, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (266, 88715769, 57, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (267, 88715769, 58, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (268, 88715769, 59, '内增高');
INSERT INTO `esm_propertyvalue` VALUES (269, 88715769, 60, '竹叶蓝色');
INSERT INTO `esm_propertyvalue` VALUES (270, 88715769, 61, '2019春季');
INSERT INTO `esm_propertyvalue` VALUES (271, 88715769, 62, '棉布底');
INSERT INTO `esm_propertyvalue` VALUES (272, 88715770, 63, '筎筠');
INSERT INTO `esm_propertyvalue` VALUES (273, 88715770, 64, '2018秋季');
INSERT INTO `esm_propertyvalue` VALUES (274, 88715770, 65, '复古');
INSERT INTO `esm_propertyvalue` VALUES (275, 88715770, 66, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (276, 88715770, 67, '34，35，36，37，38，39，40');
INSERT INTO `esm_propertyvalue` VALUES (277, 88715770, 68, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (278, 88715770, 69, '白色');
INSERT INTO `esm_propertyvalue` VALUES (279, 88715771, 63, '四超健步（SICHAO）');
INSERT INTO `esm_propertyvalue` VALUES (280, 88715771, 64, '2018秋季');
INSERT INTO `esm_propertyvalue` VALUES (281, 88715771, 65, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (282, 88715771, 66, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (283, 88715771, 67, '34，35，36，37，38，39，40');
INSERT INTO `esm_propertyvalue` VALUES (284, 88715771, 68, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (285, 88715771, 69, '粉色仙鹤');
INSERT INTO `esm_propertyvalue` VALUES (286, 88715772, 63, '朝戈尔（CHAOGEER）');
INSERT INTO `esm_propertyvalue` VALUES (287, 88715772, 64, '2018冬季');
INSERT INTO `esm_propertyvalue` VALUES (288, 88715772, 65, '民族风');
INSERT INTO `esm_propertyvalue` VALUES (289, 88715772, 66, '圆头');
INSERT INTO `esm_propertyvalue` VALUES (290, 88715772, 67, '34，35，36，37，38，39，40');
INSERT INTO `esm_propertyvalue` VALUES (291, 88715772, 68, '绣花');
INSERT INTO `esm_propertyvalue` VALUES (292, 88715772, 69, '蓝色');

-- ----------------------------
-- Table structure for esm_review
-- ----------------------------
DROP TABLE IF EXISTS `esm_review`;
CREATE TABLE `esm_review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `esm_review_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esm_review_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `esm_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_review
-- ----------------------------
INSERT INTO `esm_review` VALUES (1, 'wanl2411096785', 82522957, '第一次买，很不错', '2019-03-06 21:09:21');

-- ----------------------------
-- Table structure for esm_user
-- ----------------------------
DROP TABLE IF EXISTS `esm_user`;
CREATE TABLE `esm_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '绑定手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '绑定邮箱',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名唯一性',
  UNIQUE INDEX `phone`(`phone`) USING BTREE COMMENT '用户手机号唯一性',
  UNIQUE INDEX `email`(`email`) USING BTREE COMMENT '用户邮箱唯一性'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_user
-- ----------------------------
INSERT INTO `esm_user` VALUES ('wanl2411096785', '婉碧凤殇', 'MjVmOWU3OTQzMjNiNDUzODg1ZjUxODFmMWI2MjRkMGI=', '18802927580', '344295704@qq.com', '/static/images/01460b57e4a6fa0000012e7ed75e83.png', 0);

-- ----------------------------
-- Table structure for esm_useraccount
-- ----------------------------
DROP TABLE IF EXISTS `esm_useraccount`;
CREATE TABLE `esm_useraccount`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `esm_useraccount_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `esm_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_useraccount
-- ----------------------------
INSERT INTO `esm_useraccount` VALUES ('ac9810163452', 'wanl2411096785', 0.00);

SET FOREIGN_KEY_CHECKS = 1;
