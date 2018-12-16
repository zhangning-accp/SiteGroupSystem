<#setting number_format="#">
REPLACE INTO `lc_product_groups_info` VALUES
<#list datas as data>
    <#if data?is_last>
    (${data.id},${data.productGroupId},'${data.languageCode}','${data.name}');
    <#else>
    (${data.id},${data.productGroupId},'${data.languageCode}','${data.name}'),
    </#if>
</#list>
