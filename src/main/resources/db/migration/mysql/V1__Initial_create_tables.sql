SET NAMES utf8mb4;

DROP TABLE IF EXISTS `adsense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adsense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '0 动态轮播图 1个人中心',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='广告';

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `created_At` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='图片';

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '发布人',
  `fid` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '回复id',
  `fnum` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '被回复数',
  `data` varchar(225) NOT NULL,
  `created_At` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id` bigint(20) NOT NULL COMMENT '发布者 ID',
    `title` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文本内容',
    `titlepic` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '路径',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `post_class_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态';

DROP TABLE IF EXISTS `post_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '帖子id',
  `image_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '图片id',
  `create_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章图片关联表';

DROP TABLE IF EXISTS `post_like`;
CREATE TABLE `post_like`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `post_id` bigint(20) NOT NULL COMMENT '动态 ID',
    `user_id` bigint(20) NOT NULL COMMENT '点赞用户 ID',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态点赞';

DROP TABLE IF EXISTS `post_stat`;
CREATE TABLE `post_stat`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `post_id` bigint(20) NOT NULL COMMENT '动态 ID',
    `like_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '被喜欢次数',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态统计';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_name` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `user_pic` varchar(100) DEFAULT NULL COMMENT '头像地址',
    `password` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '已加密的密码',
    `phone` char(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
    `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
    `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '0 禁用 1启用',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE `user_follow`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `following_id` bigint(20) NOT NULL COMMENT '被关注用户 ID',
    `follower_id` bigint(20) NOT NULL COMMENT '粉丝用户 ID',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户关注';

DROP TABLE IF EXISTS `user_stat`;
CREATE TABLE `user_stat`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
    `post_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '发布动态数',
    `like_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '喜欢动态数',
    `following_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '关注人数',
    `follower_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '粉丝人数',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户统计';
