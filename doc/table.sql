CREATE TABLE `lc_option_trees` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `group_id` BIGINT NOT NULL COMMENT '',
  `group_value_id` BIGINT NOT NULL COMMENT '',
  `parent_group_id` BIGINT NOT NULL COMMENT '',
  `parent_group_value_id` BIGINT NOT NULL COMMENT '',
  `links` VARCHAR(2000) DEFAULT '' COMMENT '',
  `date_updated` DATETIME NOT NULL COMMENT '',
  `date_created` DATETIME NOT NULL COMMENT '',
  KEY (`group_id`,`group_value_id`,`parent_group_id`,`parent_group_value_id`),
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;