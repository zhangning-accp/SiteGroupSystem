CREATE TABLE `dc_option_trees` (
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

CREATE TABLE `dc_rules` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `categories` text DEFAULT '' COMMENT '',
  `product_groups` text DEFAULT '' COMMENT '',
  `option_groups` text DEFAULT '' COMMENT '',
  `rule_type` int DEFAULT 1 COMMENT '1 球衣 2 T恤',
  `seo_info` VARCHAR(2000) DEFAULT '' COMMENT '',
  `product_price` DECIMAL (10,4) DEFAULT 0.00 COMMENT '',
  `filter_name` VARCHAR(2000) DEFAULT '' COMMENT '过滤的产品名，多个用逗号分隔',
  `mathing_rule` int DEFAULT 1 COMMENT '1:模糊匹配filter_name,2:全匹配',
  `stock:` VARCHAR(2000) DEFAULT '' COMMENT '',
  `date_updated` DATETIME NOT NULL COMMENT '',
  `date_created` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '规则表';
CREATE TABLE `dc_assgin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',

  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '分配表';