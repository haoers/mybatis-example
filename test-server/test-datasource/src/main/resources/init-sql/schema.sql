

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(16) DEFAULT NULL,
  `del_flg` tinyint(4) DEFAULT '0' COMMENT '0未删除,1已删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';




INSERT INTO `user` (`id`, `phone_num`, `del_flg`, `create_time`, `update_time`) VALUES ('1', '110', '0', '2021-02-22 11:14:52', '2021-02-22 11:43:30');

