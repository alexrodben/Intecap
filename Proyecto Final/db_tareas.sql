/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 127.0.0.1:3306
 Source Schema         : db_tareas

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 22/09/2020 11:11:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_tareas
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tareas`;
CREATE TABLE `tbl_tareas`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `estado_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usuario_id`(`usuario_id`) USING BTREE,
  INDEX `estado_id`(`estado_id`) USING BTREE,
  CONSTRAINT `estado_id` FOREIGN KEY (`estado_id`) REFERENCES `tbl_tareas_estado` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `tbl_usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tareas
-- ----------------------------
INSERT INTO `tbl_tareas` VALUES (1, 'Titualo', 'descripcion', '2020-09-14 17:13:16.000000', 1, 1);
INSERT INTO `tbl_tareas` VALUES (3, 'Nueva tarea', 'esto es una tarea', '2020-01-01 00:00:00.000000', 1, 1);

-- ----------------------------
-- Table structure for tbl_tareas_estado
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tareas_estado`;
CREATE TABLE `tbl_tareas_estado`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tareas_estado
-- ----------------------------
INSERT INTO `tbl_tareas_estado` VALUES (1, 'Pendiente');
INSERT INTO `tbl_tareas_estado` VALUES (2, 'Terminada');

-- ----------------------------
-- Table structure for tbl_usuarios
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usuarios`;
CREATE TABLE `tbl_usuarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado_id` int(2) NOT NULL,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `intentos` int(1) NULL DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tbl_usuarios_estado_id`(`estado_id`) USING BTREE,
  CONSTRAINT `tbl_usuarios_ibfk_1` FOREIGN KEY (`estado_id`) REFERENCES `tbl_usuarios_estado` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_usuarios
-- ----------------------------
INSERT INTO `tbl_usuarios` VALUES (1, 2, 'admin', 'admin', 0, 'Admin');

-- ----------------------------
-- Table structure for tbl_usuarios_estado
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usuarios_estado`;
CREATE TABLE `tbl_usuarios_estado`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_usuarios_estado
-- ----------------------------
INSERT INTO `tbl_usuarios_estado` VALUES (1, 'Activo');
INSERT INTO `tbl_usuarios_estado` VALUES (2, 'Inactivo');

SET FOREIGN_KEY_CHECKS = 1;
