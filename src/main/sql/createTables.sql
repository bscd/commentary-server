DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id`         INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '用户ID',
  `wx_nickname`     VARCHAR(256) NOT NULL
  COMMENT '微信昵称',
  `wx_avatarurl`    VARCHAR(256) NOT NULL
  COMMENT '微信头像',
  `wx_gender`       VARCHAR(64)  NOT NULL
  COMMENT '微信性别',
  `nickname`        VARCHAR(32)           DEFAULT NULL
  COMMENT '昵称',
  `avatarurl`       VARCHAR(255)          DEFAULT NULL
  COMMENT '头像',
  `gender`          VARCHAR(16)           DEFAULT NULL
  COMMENT '性别',
  `phone`           VARCHAR(32)           DEFAULT NULL
  COMMENT '手机号码',
  `desc`            VARCHAR(255)          DEFAULT NULL
  COMMENT '自我介绍',
  `last_login_time` DATETIME              DEFAULT NULL
  COMMENT '最后一次登录时间',
  PRIMARY KEY (`user_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_spot`;
CREATE TABLE `t_spot` (
  `spot_id`       INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '场馆ID',
  `spot_name`     VARCHAR(64)  NOT NULL
  COMMENT '场馆名称',
  `province`      VARCHAR(64)  NOT NULL
  COMMENT '所在的省',
  `city`          VARCHAR(256) NOT NULL
  COMMENT '所在城市',
  `short_picurl`  VARCHAR(256)          DEFAULT NULL
  COMMENT '缩略图',
  `short_desc`    VARCHAR(256)          DEFAULT NULL
  COMMENT '简短说明',
  `detail_picurl` VARCHAR(256)          DEFAULT NULL
  COMMENT '详情图',
  `detail_desc`   TEXT                  DEFAULT NULL
  COMMENT '详细说明',
  PRIMARY KEY (`spot_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `item_id`       INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '展品ID',
  `item_name`     VARCHAR(64) NOT NULL
  COMMENT '展品名称',
  `spot_id`       INT(11)     NOT NULL
  COMMENT '归属场馆的ID',
  `short_picurl`  VARCHAR(256)         DEFAULT NULL
  COMMENT '缩略图',
  `short_desc`    VARCHAR(256)         DEFAULT NULL
  COMMENT '简短说明',
  `detail_picurl` VARCHAR(256)         DEFAULT NULL
  COMMENT '详情图',
  `detail_desc`   TEXT                 DEFAULT NULL
  COMMENT '详细说明',
  PRIMARY KEY (`item_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_voice`;
CREATE TABLE `t_voice` (
  `voice_id` INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '语音资源ID',
  `type`     VARCHAR(16)  NOT NULL
  COMMENT '语音类型\n 1:spot, 2:item, 3:system',
  `author`   INT(11)      NOT NULL
  COMMENT '作者ID',
  `url`      VARCHAR(256) NOT NULL
  COMMENT '语音资源链接',
  `stars`    INT(11)               DEFAULT 0
  COMMENT '标星星的数量',
  PRIMARY KEY (`voice_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `message_id` INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '留言ID',
  `author`     INT(11)      NOT NULL
  COMMENT '作者ID',
  `content`    VARCHAR(256) NOT NULL
  COMMENT '留言内容',
  `type`       VARCHAR(16)  NOT NULL
  COMMENT '留言类型\n 1:spot, 2:item, 3:system',
  `id`         INT(11)      NOT NULL
  COMMENT '归属实体的ID',
  PRIMARY KEY (`message_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = utf8;
