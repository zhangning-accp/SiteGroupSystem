<#setting number_format="#">REPLACE INTO `lc_products_campaigns` VALUES<#list datas as data><#if data?is_last>(${data.id},${data.productId},'${data.startDate!'1970-01-01 01:01:01'}','${data.endDate!'1970-01-01 01:01:01'}',${data.usd},${data.eur});
<#else>(${data.id},${data.productId},'${data.startDate!'1970-01-01 01:01:01'}','${data.endDate!'1970-01-01 01:01:01'}',${data.usd},${data.eur}),</#if></#list>