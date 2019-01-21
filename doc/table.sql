DROP TABLE dc_option_trees;
DROP TABLE dc_rules;
DROP TABLE dc_assgin;
DROP TABLE dc_assgin_logs;
CREATE TABLE `dc_option_trees` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `group_id` BIGINT NOT NULL COMMENT '',
  `group_value_id` BIGINT NOT NULL COMMENT '',
  `parent_group_id` BIGINT NOT NULL COMMENT '',
  `parent_group_value_id` BIGINT NOT NULL COMMENT '',
  `links` VARCHAR(2000) DEFAULT '' COMMENT '',
  `date_updated` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `date_created` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  KEY (`group_id`,`group_value_id`,`parent_group_id`,`parent_group_value_id`),
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `dc_rules` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `description` VARCHAR (1000) DEFAULT '规则描述',
  `categories` text COMMENT '',
  `product_groups` text COMMENT '',
  `option_groups` text COMMENT '',
  `rule_type` int DEFAULT 1 COMMENT '1 球衣 2 T恤',
  `seo_info` VARCHAR(2000) DEFAULT '' COMMENT '',
  `product_price` DECIMAL (10,4) DEFAULT 0.00 COMMENT '',
  `filter_name` VARCHAR(2000) DEFAULT '' COMMENT '过滤的产品名，多个用逗号分隔',
  `mathing_rule` int DEFAULT 1 COMMENT '1:模糊匹配filter_name,2:全匹配',
  `quantity` DECIMAL (11,4) DEFAULT 0 COMMENT '',
  `date_updated` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `date_created` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '规则表';

CREATE TABLE `dc_assgin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `rule_id` BIGINT NOT NULL  COMMENT '',
  `date_from` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `date_to` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `sites` text NOT NULL  COMMENT '',
  `categories` text NOT NULL COMMENT '',
  `file_name` VARCHAR (100) DEFAULT '' COMMENT '文件名，后期有可能会有路径信息',
  `date_updated` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `date_created` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '分配表';

CREATE TABLE `dc_assgin_logs` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `assgin_id` BIGINT NOT NULL  COMMENT '',
  `site` text NOT NULL COMMENT '单个站点信息',
   `log` text COMMENT '分发情况，如失败成功等信息，仅作为监控使用',
  `date_updated` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  `date_created` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '分配表';
