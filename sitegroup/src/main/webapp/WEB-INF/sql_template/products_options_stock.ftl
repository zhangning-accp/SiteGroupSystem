<#setting number_format="#">REPLACE INTO `lc_products_options_stock` VALUES<#list datas as data><#if data?is_last>(${data.id},${data.productId},'${data.combination}','${data.sku}',${data.weight},'${data.weightClass}',${data.dimX},${data.dimY},${data.dimZ},'${data.dimClass}',${data.quantity},${data.priority},'${(data.dateUpdated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}','${(data.dateCreated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}');
<#else>(${data.id},${data.productId},'${data.combination}','${data.sku}',${data.weight},'${data.weightClass}',${data.dimX},${data.dimY},${data.dimZ},'${data.dimClass}',${data.quantity},${data.priority},'${(data.dateUpdated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}','${(data.dateCreated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}'),</#if></#list>