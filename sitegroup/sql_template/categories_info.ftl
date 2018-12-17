<#setting number_format="#">
REPLACE INTO `lc_categories_info` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},${data.categoryId},'${data.languageCode}','${data.name}',
        '${data.shortDescription}','${data.description}','${data.headTitle}','${data.h1Title}','${data.metaDescription}');
    <#else>
    (${data.id},${data.categoryId},'${data.languageCode}','${data.name}',
    '${data.shortDescription}','${data.description}','${data.headTitle}','${data.h1Title}','${data.metaDescription}'),
    </#if>
</#list>

