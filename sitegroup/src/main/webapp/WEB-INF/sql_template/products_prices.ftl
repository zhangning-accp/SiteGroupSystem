<#setting number_format="#">REPLACE INTO `lc_products_prices` VALUES<#list datas as data><#if data?is_last>(${data.id},${data.productId},${data.usd},${data.eur});
<#else>(${data.id},${data.productId},${data.usd},${data.eur}),</#if></#list>
