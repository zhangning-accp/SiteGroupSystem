<#setting number_format="#">
REPLACE INTO `lc_products_images` VALUES
<#list datas as data>
    <#if data?is_last>
    (${data.id},${data.productId},'${data.filename!''}','${data.checksum!''}',${data.priority});
    <#else>
    (${data.id},${data.productId},'${data.filename!''}','${data.checksum!''}',${data.priority}),
    </#if>
</#list>