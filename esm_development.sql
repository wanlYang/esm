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

 Date: 02/03/2019 21:12:36
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `
sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题',
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
) ENGINE = InnoDB AUTO_INCREMENT = 82522960 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_product
-- ----------------------------
INSERT INTO `esm_product` VALUES (82522957, 16, '钟灵记般若齐胸襦裙对襟齐腰汉服女改良春夏秋冬装传统绿重工大摆', '传统绿重工大摆', 188.00, 288.00, 0, 'productimg\\2019\\3\\82522957\\TB2LfR1ceSSBuNjy0FlXXbBpVXa_!!411005513.jpg', '钟灵记般若齐胸襦裙对襟齐腰汉服女改良春夏秋冬装传统绿重工大摆', 1, 1, 99, '2019-03-02 19:57:33');
INSERT INTO `esm_product` VALUES (82522958, 20, '如梦霓裳汉服女装交领襦裙翎羽大袖孔雀绣花春夏季原创日常新款', '女装交领襦裙翎羽大袖孔雀绣花', 189.00, 259.00, 0, 'productimg\\2019\\3\\82522958\\O1CN01EnfbZP1IuVwGs11zG_!!4194630953.jpg_430x430q90.jpg', '如梦霓裳汉服女装交领襦裙翎羽大袖孔雀绣花春夏季原创日常新款', 1, 1, 99, '2019-03-21 20:49:00');
INSERT INTO `esm_product` VALUES (82522959, 20, '重回汉唐汉服女 襦裙行香子传统日常交领齐腰襦裙民族风绣花春装', '交领齐腰襦裙民族风绣花春装', 136.00, 189.00, 0, 'productimg\\2019\\3\\82522959\\O1CN01ZiO0Lm1vZgvtURT4Z_!!0-item_pic.jpg_430x430q90.jpg', '重回汉唐汉服女 襦裙行香子传统日常交领齐腰襦裙民族风绣花春装', 1, 1, 99, '2019-03-02 21:02:38');
INSERT INTO `esm_product` VALUES (86626581, 16, '钟灵记【绯烟】日常汉服女对襟上襦改良齐腰襦裙吊带中国风春夏秋', '齐腰襦裙吊带中国风春夏秋', 115.00, 198.00, 0, 'productimg\\2019\\3\\O1CN01kxDaD71qb00nTJNEL_!!0-item_pic.jpg', '钟灵记【绯烟】日常汉服女对襟上襦改良齐腰襦裙吊带中国风春夏秋', 1, 1, 99, '2019-02-28 09:12:16');
INSERT INTO `esm_product` VALUES (87754945, 16, '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', 148.00, 256.00, 0, 'productimg\\2019\\3\\O1CN01GXZnzl1b673yDgh7R_!!1766643415.jpg', '雀灵汉服齐腰襦裙广袖大袖衫刺绣孔雀古装仙女裙大学生春夏秋冬装', 1, 1, 99, '2019-03-15 19:41:45');
INSERT INTO `esm_product` VALUES (88715736, 16, '钟灵记原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带非 古风春夏秋冬款', '原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带', 198.00, 245.00, 0, 'productimg\\2019\\3\\O1CN01ZCTDIk1qb00nuS2CM_!!0-item_pic.jpg', '灵记原创雀灵汉服女齐胸襦裙仙女裙齐腰吊带非 古风春夏秋冬款', 1, 1, 99, '2019-03-02 19:34:37');

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
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of esm_product_img
-- ----------------------------
INSERT INTO `esm_product_img` VALUES (1, 86626581, 'productimg\\2019\\3\\TB2GcVcb_dYBeNkSmLyXXXfnVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (2, 86626581, 'productimg\\2019\\3\\O1CN01kxDaD71qb00nTJNEL_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (3, 86626581, 'productimg\\2019\\3\\TB2L4.1g_lYBeNjSszcXXbwhFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (4, 86626581, 'productimg\\2019\\3\\TB2NNr5bFooBKNjSZPhXXc2CXXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (5, 86626581, 'productimg\\2019\\3\\TB22M7JbOMnBKNjSZFCXXX0KFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (6, 86626581, 'productimg\\2019\\3\\TB27736dljTBKNjSZFwXXcG4XXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (7, 88715736, 'productimg\\2019\\3\\O1CN01Tzbped1qb008WHxm8_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (8, 88715736, 'productimg\\2019\\3\\O1CN01Wfhi9X1qb009Iudm7_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (9, 88715736, 'productimg\\2019\\3\\O1CN01ZCTDIk1qb00nuS2CM_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (10, 88715736, 'productimg\\2019\\3\\TB2.DNYtHBmpuFjSZFAXXaQ0pXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (11, 88715736, 'productimg\\2019\\3\\TB2Ilexot0opuFjSZFxXXaDNVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (12, 88715736, 'productimg\\2019\\3\\TB2O8k7u80lpuFjSszdXXcdxFXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (13, 87754945, 'productimg\\2019\\3\\O1CN01GXZnzl1b673yDgh7R_!!1766643415.jpg');
INSERT INTO `esm_product_img` VALUES (14, 87754945, 'productimg\\2019\\3\\O1CN01JuJak91b673woXq7c_!!1766643415.jpg');
INSERT INTO `esm_product_img` VALUES (15, 87754945, 'productimg\\2019\\3\\O1CN01vfRbF21b673W52gXf_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (16, 87754945, 'productimg\\2019\\3\\O1CN01YuxbAK1b673X5N9Bq_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (17, 87754945, 'productimg\\2019\\3\\O1CN011b6725tLwCMHlDF_!!1766643415.png');
INSERT INTO `esm_product_img` VALUES (18, 82522957, 'productimg\\2019\\3\\82522957\\O1CN017cFOfj1qb00o29HaD_!!0-item_pic.jpg');
INSERT INTO `esm_product_img` VALUES (19, 82522957, 'productimg\\2019\\3\\82522957\\TB2.DNYtHBmpuFjSZFAXXaQ0pXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (20, 82522957, 'productimg\\2019\\3\\82522957\\TB2.ePTcrSYBuNjSspfXXcZCpXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (21, 82522957, 'productimg\\2019\\3\\82522957\\TB2_U_jer9YBuNjy0FgXXcxcXXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (22, 82522957, 'productimg\\2019\\3\\82522957\\TB2HOeLakomBKNjSZFqXXXtqVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (23, 82522957, 'productimg\\2019\\3\\82522957\\TB2LfR1ceSSBuNjy0FlXXbBpVXa_!!411005513.jpg');
INSERT INTO `esm_product_img` VALUES (24, 82522958, 'productimg\\2019\\3\\82522958\\O1CN01EnfbZP1IuVwGs11zG_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (25, 82522958, 'productimg\\2019\\3\\82522958\\O1CN01UR0ANd1IuVwFOP2FU_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (26, 82522958, 'productimg\\2019\\3\\82522958\\O1CN01wb3ytz1IuVwERMevX_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (27, 82522958, 'productimg\\2019\\3\\82522958\\O1CN013YJden1IuVwFcF5IV_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (28, 82522958, 'productimg\\2019\\3\\82522958\\O1CN017nHxHG1IuVwE2ndvW_!!4194630953.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (29, 82522959, 'productimg\\2019\\3\\82522959\\O1CN01ZiO0Lm1vZgvtURT4Z_!!0-item_pic.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (30, 82522959, 'productimg\\2019\\3\\82522959\\TB1t0uDdbSYBuNjSspiYXFNzpXa_M2.SS2_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (31, 82522959, 'productimg\\2019\\3\\82522959\\TB2J.sTmY_I8KJjy1XaXXbsxpXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (32, 82522959, 'productimg\\2019\\3\\82522959\\TB2WbpZqQCWBuNjy0FaXXXUlXXa_!!2835046187.jpg_430x430q90.jpg');
INSERT INTO `esm_product_img` VALUES (33, 82522959, 'productimg\\2019\\3\\82522959\\TB24j6kjVGWBuNjy0FbXXb4sXXa_!!2835046187.jpg_430x430q90.jpg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `esm_propertyvalue` VALUES (10, 87754945, 2, ' 2017年春季');
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
INSERT INTO `esm_propertyvalue` VALUES (21, 82522958, 10, ' 其他100%');
INSERT INTO `esm_propertyvalue` VALUES (22, 82522958, 11, ' 黑色上襦.一件 现货 黑色上襦.一件 预售 30天左右发货 白色上襦.一件 现货 白色上襦.一件 预售 30天左右发货 肉色上襦.一件 现货 肉色上襦.一件 预售 30天左右发货 黑红下裙.一件 现货 黑红下裙.一件 预售 30天左右发货 浅蓝下裙.一件 现货 浅蓝下裙.一件 预售 30天左右发货');
INSERT INTO `esm_propertyvalue` VALUES (23, 82522959, 5, '重回汉唐');
INSERT INTO `esm_propertyvalue` VALUES (24, 82522959, 6, '155 160 165 170');
INSERT INTO `esm_propertyvalue` VALUES (25, 82522959, 8, 'HFJY1235');
INSERT INTO `esm_propertyvalue` VALUES (26, 82522959, 9, ' 2018年春季');
INSERT INTO `esm_propertyvalue` VALUES (27, 82522959, 10, ' 聚对苯二甲酸乙二酯(涤纶)100%');
INSERT INTO `esm_propertyvalue` VALUES (28, 82522959, 11, ' 仅浅肉粉上襦 现货 仅浅肉粉上襦 预售 仅深红色下裙  现货 仅深红色下裙 预售');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `esm_user` VALUES ('wanl2411096785', '婉碧凤殇', 'MjVmOWU3OTQzMjNiNDUzODg1ZjUxODFmMWI2MjRkMGI=', '18802927580', NULL, '/static/images/01460b57e4a6fa0000012e7ed75e83.png', 0);

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
