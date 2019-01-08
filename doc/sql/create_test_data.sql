-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: 10.100.13.133    Database: rocket_test
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_login_log`
--

DROP TABLE IF EXISTS `sys_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '登陆用户名，这里不用ID是因为可能有不存在的用户名登陆',
  `login_ip` varchar(50) DEFAULT NULL COMMENT '登陆IP地址',
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登陆时间',
  `is_success` bigint(20) DEFAULT NULL COMMENT '是否登陆成功 0-失败 1-成功',
  `login_info` varchar(50) DEFAULT NULL COMMENT '登陆信息，记录登陆失败原因等',
  `is_deleted` int(11) DEFAULT '0' COMMENT '软删除字段 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_log`
--

LOCK TABLES `sys_login_log` WRITE;
/*!40000 ALTER TABLE `sys_login_log` DISABLE KEYS */;
INSERT INTO `sys_login_log` VALUES (1,'g_seinfeld','10.100.9.104','2018-12-26 21:32:58',1,'登陆成功测试',0,'2018-12-27 11:34:52','2018-12-27 11:34:52'),(4,'g_seinfeld','127.0.0.1','2018-12-26 21:40:26',0,'用户名或密码不正确',0,'2018-12-27 11:40:24','2018-12-27 11:40:24'),(5,'g_seinfeld','127.0.0.1','2018-12-26 21:41:34',1,'登录成功',0,'2018-12-27 11:41:32','2018-12-27 11:41:32'),(6,'g_seinfeld','127.0.0.1','2018-12-27 01:03:23',1,'登录成功',0,'2018-12-27 15:03:20','2018-12-27 15:03:20'),(7,'g_seinfeld','127.0.0.1','2018-12-27 01:26:00',0,'用户名或密码不正确',0,'2018-12-27 15:25:58','2018-12-27 15:25:58'),(8,'g_seinfeld','127.0.0.1','2018-12-27 01:32:54',0,'用户名或密码不正确',0,'2018-12-27 15:32:51','2018-12-27 15:32:51'),(9,'g_seinfeld','127.0.0.1','2018-12-27 01:33:30',1,'登录成功',0,'2018-12-27 15:33:27','2018-12-27 15:33:27'),(10,'g_seinfeld','127.0.0.1','2018-12-27 01:36:06',1,'登录成功',0,'2018-12-27 15:36:03','2018-12-27 15:36:03'),(11,'g_seinfeld','127.0.0.1','2018-12-27 01:37:41',1,'登录成功',0,'2018-12-27 15:37:38','2018-12-27 15:37:38'),(12,'g_seinfeld','127.0.0.1','2018-12-27 01:38:18',1,'登录成功',0,'2018-12-27 15:38:16','2018-12-27 15:38:16'),(13,'g_seinfeld','127.0.0.1','2018-12-27 01:42:49',1,'登录成功',0,'2018-12-27 15:42:46','2018-12-27 15:42:46'),(14,'g_seinfeld','127.0.0.1','2018-12-27 01:43:08',0,'用户名或密码不正确',0,'2018-12-27 15:43:06','2018-12-27 15:43:06'),(17,'g_seinfeld','127.0.0.1','2018-12-27 01:45:20',1,'登录成功',0,'2018-12-27 15:45:17','2018-12-27 15:45:17'),(18,'g_seinfeld','127.0.0.1','2018-12-27 01:45:49',0,'用户名或密码不正确',0,'2018-12-27 15:45:46','2018-12-27 15:45:46'),(19,'123','127.0.0.1','2018-12-27 01:45:49',0,'用户名或密码不正确',0,'2018-12-27 15:45:46','2018-12-27 15:45:46'),(20,'g_seinfeld','127.0.0.1','2018-12-27 01:45:49',1,'登录成功',0,'2018-12-27 15:45:46','2018-12-27 15:45:46'),(24,'g_seinfeld','127.0.0.1','2018-12-27 01:47:00',0,'用户名或密码不正确',0,'2018-12-27 15:46:57','2018-12-27 15:46:57'),(25,'123','127.0.0.1','2018-12-27 01:47:00',0,'用户名或密码不正确',0,'2018-12-27 15:46:57','2018-12-27 15:46:57'),(26,'g_seinfeld','127.0.0.1','2018-12-27 01:47:00',1,'登录成功',0,'2018-12-27 15:46:57','2018-12-27 15:46:57'),(30,'g_seinfeld','127.0.0.1','2018-12-27 02:02:55',0,'用户名或密码不正确',0,'2018-12-27 16:02:52','2018-12-27 16:02:52'),(31,'123','127.0.0.1','2018-12-27 02:02:55',0,'用户名或密码不正确',0,'2018-12-27 16:02:52','2018-12-27 16:02:52'),(32,'g_seinfeld','127.0.0.1','2018-12-27 02:02:55',1,'登录成功',0,'2018-12-27 16:02:52','2018-12-27 16:02:52'),(36,NULL,'10.100.9.104','2018-12-28 02:24:41',0,'账户验证失败',0,'2018-12-28 16:24:37','2018-12-28 16:24:37'),(37,NULL,'10.100.9.104','2018-12-28 02:26:25',0,'账户验证失败',0,'2018-12-28 16:26:21','2018-12-28 16:26:21'),(38,NULL,'10.100.9.104','2018-12-28 02:28:49',0,'账户验证失败',0,'2018-12-28 16:28:45','2018-12-28 16:28:45'),(39,NULL,'10.100.9.104','2018-12-28 02:30:05',0,'账户验证失败',0,'2018-12-28 16:30:00','2018-12-28 16:30:00'),(40,NULL,'10.100.9.104','2018-12-28 02:30:13',0,'账户验证失败',0,'2018-12-28 16:30:08','2018-12-28 16:30:08'),(41,NULL,'10.100.9.104','2018-12-28 02:46:16',0,'账户验证失败',0,'2018-12-28 16:46:12','2018-12-28 16:46:12'),(42,NULL,'10.100.9.104','2018-12-28 02:47:19',0,'账户验证失败',0,'2018-12-28 16:47:14','2018-12-28 16:47:14'),(43,NULL,'10.100.9.104','2018-12-28 02:48:22',0,'账户验证失败',0,'2018-12-28 16:48:18','2018-12-28 16:48:18'),(44,NULL,'10.100.9.104','2018-12-28 02:53:23',0,'账户验证失败',0,'2018-12-28 16:53:19','2018-12-28 16:53:19'),(45,NULL,'10.100.9.104','2018-12-28 02:53:38',0,'账户验证失败',0,'2018-12-28 16:53:33','2018-12-28 16:53:33'),(46,NULL,'10.100.9.104','2018-12-28 02:56:44',0,'账户验证失败',0,'2018-12-28 16:56:40','2018-12-28 16:56:40'),(47,NULL,'10.100.9.104','2018-12-28 02:58:18',0,'账户验证失败',0,'2018-12-28 16:58:13','2018-12-28 16:58:13'),(48,NULL,'10.100.9.104','2018-12-28 03:07:21',0,'账户验证失败',0,'2018-12-28 17:07:16','2018-12-28 17:07:16'),(49,NULL,'10.100.9.104','2018-12-28 03:08:56',0,'账户验证失败',0,'2018-12-28 17:08:52','2018-12-28 17:08:52'),(50,'123','127.0.0.1','2018-12-28 03:12:50',0,'用户名或密码不正确',0,'2018-12-28 17:12:46','2018-12-28 17:12:46'),(51,'g_seinfeld','127.0.0.1','2018-12-28 03:13:26',1,'登录成功',0,'2018-12-28 17:13:22','2018-12-28 17:13:22'),(52,'g_seinfeld','127.0.0.1','2018-12-28 03:21:49',1,'登录成功',0,'2018-12-28 17:21:44','2018-12-28 17:21:44'),(53,'g_seinfeld','127.0.0.1','2018-12-28 03:21:58',0,'用户名或密码不正确',0,'2018-12-28 17:21:53','2018-12-28 17:21:53'),(54,'123','127.0.0.1','2018-12-28 03:22:25',0,'用户名或密码不正确',0,'2018-12-28 17:22:21','2018-12-28 17:22:21'),(55,'123','127.0.0.1','2018-12-28 03:22:36',0,'用户名或密码不正确',0,'2018-12-28 17:22:32','2018-12-28 17:22:32'),(56,'g_seinfeld','127.0.0.1','2018-12-28 03:24:34',1,'登录成功',0,'2018-12-28 17:24:29','2018-12-28 17:24:29'),(57,'g_seinfeld','127.0.0.1','2018-12-28 03:24:47',0,'用户名或密码不正确',0,'2018-12-28 17:24:43','2018-12-28 17:24:43'),(58,'g_seinfeld','127.0.0.1','2018-12-28 03:24:51',0,'用户名或密码不正确',0,'2018-12-28 17:24:46','2018-12-28 17:24:46'),(59,'g_seinfeld','127.0.0.1','2018-12-28 03:24:52',0,'用户名或密码不正确',0,'2018-12-28 17:24:47','2018-12-28 17:24:47'),(60,'123','127.0.0.1','2018-12-28 03:26:18',0,'用户名或密码不正确',0,'2018-12-28 17:26:14','2018-12-28 17:26:14'),(61,'123','127.0.0.1','2018-12-28 03:26:33',0,'用户名或密码不正确',0,'2018-12-28 17:26:28','2018-12-28 17:26:28'),(62,'123','127.0.0.1','2018-12-28 03:26:45',0,'用户名或密码不正确',0,'2018-12-28 17:26:41','2018-12-28 17:26:41'),(63,'123','127.0.0.1','2018-12-28 03:29:37',0,'用户名或密码不正确',0,'2018-12-28 17:29:32','2018-12-28 17:29:32'),(64,'','127.0.0.1','2018-12-28 03:29:55',0,'用户名或密码不正确',0,'2018-12-28 17:29:50','2018-12-28 17:29:50'),(65,'','127.0.0.1','2018-12-28 03:29:57',0,'用户名或密码不正确',0,'2018-12-28 17:29:53','2018-12-28 17:29:53'),(66,'','127.0.0.1','2018-12-28 03:38:39',0,'用户名或密码不正确',0,'2018-12-28 17:38:35','2018-12-28 17:38:35'),(67,'','127.0.0.1','2018-12-28 03:38:53',0,'用户名或密码不正确',0,'2018-12-28 17:38:49','2018-12-28 17:38:49'),(68,'','127.0.0.1','2018-12-28 19:34:08',0,'用户名或密码不正确',0,'2018-12-29 09:34:13','2018-12-29 09:34:13'),(69,'g_seinfeld','127.0.0.1','2018-12-28 19:34:40',1,'登录成功',0,'2018-12-29 09:34:44','2018-12-29 09:34:44'),(70,'g_seinfeld','127.0.0.1','2018-12-28 19:34:52',1,'登录成功',0,'2018-12-29 09:34:56','2018-12-29 09:34:56'),(71,'g_seinfeld','127.0.0.1','2018-12-28 19:34:56',0,'用户名或密码不正确',0,'2018-12-29 09:35:01','2018-12-29 09:35:01'),(72,'g_seinfeld','127.0.0.1','2018-12-28 19:37:56',1,'登录成功',0,'2018-12-29 09:38:01','2018-12-29 09:38:01'),(73,'g_seinfeld','127.0.0.1','2018-12-28 19:39:44',1,'登录成功',0,'2018-12-29 09:39:49','2018-12-29 09:39:49'),(74,'g_seinfeld','127.0.0.1','2018-12-28 19:42:44',1,'登录成功',0,'2018-12-29 09:42:48','2018-12-29 09:42:48'),(75,'g_seinfeld','127.0.0.1','2019-01-01 19:17:08',1,'登录成功',0,'2019-01-02 09:16:56','2019-01-02 09:16:56'),(77,'g_seinfeld','127.0.0.1','2019-01-01 23:55:15',1,'登录成功',0,'2019-01-02 13:55:03','2019-01-02 13:55:03'),(78,'g_seinfeld','127.0.0.1','2019-01-02 01:26:11',1,'登录成功',0,'2019-01-02 15:25:59','2019-01-02 15:25:59'),(79,'g_seinfeld','127.0.0.1','2019-01-02 01:52:25',0,'用户名或密码不正确',0,'2019-01-02 15:52:13','2019-01-02 15:52:13'),(80,'123','127.0.0.1','2019-01-02 01:52:25',0,'用户名或密码不正确',0,'2019-01-02 15:52:13','2019-01-02 15:52:13'),(81,'g_seinfeld','127.0.0.1','2019-01-02 01:52:25',1,'登录成功',0,'2019-01-02 15:52:13','2019-01-02 15:52:13'),(82,'g_seinfeld','127.0.0.1','2019-01-02 01:53:49',1,'登录成功',0,'2019-01-02 15:53:37','2019-01-02 15:53:37'),(83,'g_seinfeld','127.0.0.1','2019-01-02 01:54:44',1,'登录成功',0,'2019-01-02 15:54:32','2019-01-02 15:54:32'),(88,'g_seinfeld','127.0.0.1','2019-01-02 02:01:38',1,'登录成功',0,'2019-01-02 16:01:26','2019-01-02 16:01:26'),(89,'g_seinfeld','127.0.0.1','2019-01-02 02:01:38',1,'登录成功',0,'2019-01-02 16:01:26','2019-01-02 16:01:26'),(90,'g_seinfeld','127.0.0.1','2019-01-02 02:01:38',1,'登录成功',0,'2019-01-02 16:01:26','2019-01-02 16:01:26'),(91,'g_seinfeld','127.0.0.1','2019-01-02 02:01:39',1,'登录成功',0,'2019-01-02 16:01:26','2019-01-02 16:01:26'),(92,'g_seinfeld','127.0.0.1','2019-01-02 02:02:05',0,'用户名或密码不正确',0,'2019-01-02 16:01:53','2019-01-02 16:01:53'),(93,'g_seinfeld','127.0.0.1','2019-01-02 02:02:05',1,'登录成功',0,'2019-01-02 16:01:53','2019-01-02 16:01:53'),(94,'123','127.0.0.1','2019-01-02 02:02:05',0,'用户名或密码不正确',0,'2019-01-02 16:01:53','2019-01-02 16:01:53'),(95,'g_seinfeld','127.0.0.1','2019-01-02 02:02:05',1,'登录成功',0,'2019-01-02 16:01:53','2019-01-02 16:01:53'),(98,'g_seinfeld','127.0.0.1','2019-01-02 02:02:06',1,'登录成功',0,'2019-01-02 16:01:54','2019-01-02 16:01:54'),(99,'g_seinfeld','127.0.0.1','2019-01-02 02:02:06',1,'登录成功',0,'2019-01-02 16:01:54','2019-01-02 16:01:54'),(100,'g_seinfeld','127.0.0.1','2019-01-02 02:02:06',1,'登录成功',0,'2019-01-02 16:01:54','2019-01-02 16:01:54'),(101,'g_seinfeld','127.0.0.1','2019-01-02 02:02:06',1,'登录成功',0,'2019-01-02 16:01:54','2019-01-02 16:01:54'),(104,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',0,'用户名或密码不正确',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(105,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',1,'登录成功',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(106,'123','127.0.0.1','2019-01-02 02:04:29',0,'用户名或密码不正确',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(107,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',1,'登录成功',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(110,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',1,'登录成功',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(111,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',1,'登录成功',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(112,'g_seinfeld','127.0.0.1','2019-01-02 02:04:29',1,'登录成功',0,'2019-01-02 16:04:17','2019-01-02 16:04:17'),(113,'g_seinfeld','127.0.0.1','2019-01-02 02:04:30',1,'登录成功',0,'2019-01-02 16:04:18','2019-01-02 16:04:18'),(116,'g_seinfeld','127.0.0.1','2019-01-02 19:32:24',1,'登录成功',0,'2019-01-03 09:32:11','2019-01-03 09:32:11'),(117,'g_seinfeld','127.0.0.1','2019-01-02 19:32:47',1,'登录成功',0,'2019-01-03 09:32:34','2019-01-03 09:32:34'),(118,'g_seinfeld','127.0.0.1','2019-01-02 19:32:59',1,'登录成功',0,'2019-01-03 09:32:46','2019-01-03 09:32:46'),(119,'g_seinfeld','127.0.0.1','2019-01-02 19:34:52',1,'登录成功',0,'2019-01-03 09:34:58','2019-01-03 09:34:58'),(120,'g_seinfeld','127.0.0.1','2019-01-02 19:38:45',1,'登录成功',0,'2019-01-03 09:38:31','2019-01-03 09:38:31'),(121,'g_seinfeld','127.0.0.1','2019-01-02 19:39:02',1,'登录成功',0,'2019-01-03 09:38:48','2019-01-03 09:38:48'),(122,'g_seinfeld','127.0.0.1','2019-01-02 19:41:43',1,'登录成功',0,'2019-01-03 09:41:30','2019-01-03 09:41:30'),(123,'g_seinfeld','127.0.0.1','2019-01-02 19:44:20',1,'登录成功',0,'2019-01-03 09:44:07','2019-01-03 09:44:07'),(124,'g_seinfeld','127.0.0.1','2019-01-02 19:44:53',1,'登录成功',0,'2019-01-03 09:44:40','2019-01-03 09:44:40'),(125,'g_seinfeld','127.0.0.1','2019-01-02 19:49:44',1,'登录成功',0,'2019-01-03 09:49:31','2019-01-03 09:49:31'),(126,'g_seinfeld','127.0.0.1','2019-01-02 19:53:01',1,'登录成功',0,'2019-01-03 09:52:48','2019-01-03 09:52:48'),(127,'g_seinfeld','127.0.0.1','2019-01-02 19:57:25',1,'登录成功',0,'2019-01-03 09:57:12','2019-01-03 09:57:12'),(128,'g_seinfeld','127.0.0.1','2019-01-02 19:58:00',1,'登录成功',0,'2019-01-03 09:57:47','2019-01-03 09:57:47'),(129,'g_seinfeld','127.0.0.1','2019-01-02 19:59:58',1,'登录成功',0,'2019-01-03 09:59:45','2019-01-03 09:59:45'),(130,'g_seinfeld','127.0.0.1','2019-01-02 20:01:46',1,'登录成功',0,'2019-01-03 10:01:33','2019-01-03 10:01:33'),(131,'g_seinfeld','127.0.0.1','2019-01-02 20:02:05',1,'登录成功',0,'2019-01-03 10:01:51','2019-01-03 10:01:51'),(132,'g_seinfeld','127.0.0.1','2019-01-02 20:04:20',1,'登录成功',0,'2019-01-03 10:04:07','2019-01-03 10:04:07'),(133,'g_seinfeld','127.0.0.1','2019-01-02 20:10:40',1,'登录成功',0,'2019-01-03 10:10:27','2019-01-03 10:10:27'),(134,'g_seinfeld','127.0.0.1','2019-01-02 20:19:30',1,'登录成功',0,'2019-01-03 10:19:34','2019-01-03 10:19:34'),(135,'g_seinfeld','127.0.0.1','2019-01-02 20:22:58',1,'登录成功',0,'2019-01-03 10:22:45','2019-01-03 10:22:45'),(136,'g_seinfeld','127.0.0.1','2019-01-03 07:01:36',1,'登录成功',0,'2019-01-03 21:01:22','2019-01-03 21:01:22'),(137,'g_seinfeld','127.0.0.1','2019-01-03 07:28:11',0,'用户名或密码不正确',0,'2019-01-03 21:27:57','2019-01-03 21:27:57'),(138,'g_seinfeld','127.0.0.1','2019-01-03 07:28:11',1,'登录成功',0,'2019-01-03 21:27:57','2019-01-03 21:27:57'),(139,'123','127.0.0.1','2019-01-03 07:28:11',0,'用户名或密码不正确',0,'2019-01-03 21:27:57','2019-01-03 21:27:57'),(140,'g_seinfeld','127.0.0.1','2019-01-03 07:28:11',1,'登录成功',0,'2019-01-03 21:27:57','2019-01-03 21:27:57'),(143,'g_seinfeld','127.0.0.1','2019-01-03 07:28:12',1,'登录成功',0,'2019-01-03 21:27:58','2019-01-03 21:27:58'),(144,'g_seinfeld','127.0.0.1','2019-01-03 07:28:12',1,'登录成功',0,'2019-01-03 21:27:58','2019-01-03 21:27:58'),(145,'g_seinfeld','127.0.0.1','2019-01-03 07:28:12',1,'登录成功',0,'2019-01-03 21:27:58','2019-01-03 21:27:58'),(146,'g_seinfeld','127.0.0.1','2019-01-03 07:28:12',1,'登录成功',0,'2019-01-03 21:27:58','2019-01-03 21:27:58'),(149,'g_seinfeld','127.0.0.1','2019-01-07 08:10:55',0,'用户名或密码不正确',0,'2019-01-07 22:10:56','2019-01-07 22:10:56'),(150,'g_seinfeld','127.0.0.1','2019-01-07 08:10:55',1,'登录成功',0,'2019-01-07 22:10:56','2019-01-07 22:10:56'),(151,'123','127.0.0.1','2019-01-07 08:10:56',0,'用户名或密码不正确',0,'2019-01-07 22:10:56','2019-01-07 22:10:56'),(152,'g_seinfeld','127.0.0.1','2019-01-07 08:10:56',1,'登录成功',0,'2019-01-07 22:10:57','2019-01-07 22:10:57'),(155,'g_seinfeld','127.0.0.1','2019-01-07 08:10:57',1,'登录成功',0,'2019-01-07 22:10:58','2019-01-07 22:10:58'),(156,'g_seinfeld','127.0.0.1','2019-01-07 08:10:58',1,'登录成功',0,'2019-01-07 22:10:58','2019-01-07 22:10:58'),(157,'g_seinfeld','127.0.0.1','2019-01-07 08:10:58',1,'登录成功',0,'2019-01-07 22:10:59','2019-01-07 22:10:59'),(158,'g_seinfeld','127.0.0.1','2019-01-07 08:10:59',1,'登录成功',0,'2019-01-07 22:10:59','2019-01-07 22:10:59'),(161,'g_seinfeld','127.0.0.1','2019-01-07 08:13:51',0,'用户名或密码不正确',0,'2019-01-07 22:13:52','2019-01-07 22:13:52'),(162,'g_seinfeld','127.0.0.1','2019-01-07 08:13:51',1,'登录成功',0,'2019-01-07 22:13:52','2019-01-07 22:13:52'),(163,'123','127.0.0.1','2019-01-07 08:13:51',0,'用户名或密码不正确',0,'2019-01-07 22:13:52','2019-01-07 22:13:52'),(164,'g_seinfeld','127.0.0.1','2019-01-07 08:13:52',1,'登录成功',0,'2019-01-07 22:13:53','2019-01-07 22:13:53'),(167,'g_seinfeld','127.0.0.1','2019-01-07 08:13:53',1,'登录成功',0,'2019-01-07 22:13:54','2019-01-07 22:13:54'),(168,'g_seinfeld','127.0.0.1','2019-01-07 08:13:54',1,'登录成功',0,'2019-01-07 22:13:55','2019-01-07 22:13:55'),(169,'g_seinfeld','127.0.0.1','2019-01-07 08:13:54',1,'登录成功',0,'2019-01-07 22:13:55','2019-01-07 22:13:55'),(170,'g_seinfeld','127.0.0.1','2019-01-07 08:13:54',1,'登录成功',0,'2019-01-07 22:13:55','2019-01-07 22:13:55'),(173,'g_seinfeld','127.0.0.1','2019-01-07 08:15:45',0,'用户名或密码不正确',0,'2019-01-07 22:15:45','2019-01-07 22:15:45'),(174,'g_seinfeld','127.0.0.1','2019-01-07 08:15:45',1,'登录成功',0,'2019-01-07 22:15:46','2019-01-07 22:15:46'),(175,'123','127.0.0.1','2019-01-07 08:15:45',0,'用户名或密码不正确',0,'2019-01-07 22:15:46','2019-01-07 22:15:46'),(176,'g_seinfeld','127.0.0.1','2019-01-07 08:15:46',1,'登录成功',0,'2019-01-07 22:15:46','2019-01-07 22:15:46'),(179,'g_seinfeld','127.0.0.1','2019-01-07 08:15:47',1,'登录成功',0,'2019-01-07 22:15:48','2019-01-07 22:15:48'),(180,'g_seinfeld','127.0.0.1','2019-01-07 08:15:48',1,'登录成功',0,'2019-01-07 22:15:49','2019-01-07 22:15:49'),(181,'g_seinfeld','127.0.0.1','2019-01-07 08:15:48',1,'登录成功',0,'2019-01-07 22:15:49','2019-01-07 22:15:49'),(182,'g_seinfeld','127.0.0.1','2019-01-07 08:15:49',1,'登录成功',0,'2019-01-07 22:15:49','2019-01-07 22:15:49');
/*!40000 ALTER TABLE `sys_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `description` varchar(200) DEFAULT NULL COMMENT '菜单描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级菜单ID',
  `enabled` tinyint(4) DEFAULT '1' COMMENT '是否可用 0-不可用 1-可用',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'用户管理',NULL,'fa fa-user-circle-o','用户管理菜单',NULL,1,0,'2019-01-03 21:07:41','2019-01-03 21:14:04'),(2,'用户列表','/system/user_list','fa fa-user-circle-o','用户列表菜单',1,1,0,'2019-01-03 21:10:07','2019-01-03 21:10:07'),(3,'权限管理',NULL,'fa fa-permission','权限管理菜单',NULL,1,0,'2019-01-03 21:20:27','2019-01-03 21:20:27');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `label` varchar(50) DEFAULT NULL COMMENT '权限标识字符串，如system:user:list',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '权限所属菜单',
  `description` varchar(200) DEFAULT NULL COMMENT '权限描述',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'查看','system:user:save',2,'查看用户菜单的权限',0,'2019-01-07 21:40:22','2019-01-07 21:40:22'),(2,'修改','system:user:update',2,'修改用户的权限',0,'2019-01-07 22:06:17','2019-01-07 22:06:17'),(3,'删除','system:user:delete',2,'删除用户的权限',0,'2019-01-07 22:06:17','2019-01-07 22:06:17');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','拥有使用一切菜单和功能的权限',0,'2019-01-03 19:52:59','2019-01-03 20:02:05'),(3,'管理员','干一些打杂的小活',0,'2019-01-03 20:16:54','2019-01-03 20:16:54');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色菜单关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,1,1,0,'2019-01-03 21:18:38','2019-01-03 21:18:38'),(2,1,2,0,'2019-01-03 21:18:57','2019-01-03 21:18:57'),(3,3,2,0,'2019-01-03 21:19:09','2019-01-03 21:19:09'),(4,3,3,0,'2019-01-03 21:20:44','2019-01-03 21:20:44');
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色权限关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (1,1,1,0,'2019-01-07 22:03:27','2019-01-07 22:03:27'),(2,1,2,0,'2019-01-07 22:04:05','2019-01-07 22:04:05'),(3,3,2,0,'2019-01-07 22:04:05','2019-01-07 22:04:05'),(4,3,3,0,'2019-01-07 22:04:05','2019-01-07 22:04:05');
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '密码加密的盐',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别 0-女 1-男',
  `email` varchar(50) DEFAULT NULL COMMENT '''电子邮箱''',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `status` tinyint(4) DEFAULT NULL COMMENT '用户状态 0-正常 1-禁用',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '软删除状态 0-正在使用 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `sys_user_username_uindex` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'g_seinfeld','45334b35d686bf5a5fd2e9fcb42ea30ce89e93d4059be27ea56153abfbc7c54b','1e287f2fbdb1bfe1','gsein',1,'lianghao@xihuanqian.com','17549546646',1,1,0,'2018-12-26 17:23:26','2018-12-27 15:42:46'),(11,'sisisi','10bcc268dc188244831458f2018c91b583b0d3357d2b92496d1d2ecd4111b14d','523a72028d18844e','yan',0,'sisisi@qianhui.com','13356985462',1,0,0,'2018-12-26 14:33:37','2019-01-03 19:46:33'),(16,'sisi','fed6c571a51dcb0ee062140b69fd45a34e9718ca73e9b113c2fa1ea08e068921','e0872da8644e7a93','strawberry',0,'cat@huaxi.com','13333333333',1,0,0,'2018-12-26 17:20:17','2018-12-26 17:20:17');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1,1,0,'2019-01-03 20:10:37','2019-01-03 20:25:48'),(2,1,3,0,'2019-01-03 20:17:20','2019-01-03 20:25:48');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-08 19:12:06
