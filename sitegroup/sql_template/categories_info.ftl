<#setting number_format="#">
REPLACE INTO `lc_categories_info` VALUES
<#list categoriesInfo as categoryInfo>
    <#if categoryInfo?is_last>
        (${categoryInfo.id},${categoryInfo.categoryId},'${categoryInfo.languageCode}','${categoryInfo.name}',
        '${categoryInfo.shortDescription}','${categoryInfo.description}','${categoryInfo.headTitle}','${categoryInfo.h1Title}','${categoryInfo.metaDescription}');
    <#else>
    (${categoryInfo.id},${categoryInfo.categoryId},'${categoryInfo.languageCode}','${categoryInfo.name}',
    '${categoryInfo.shortDescription}','${categoryInfo.description}','${categoryInfo.headTitle}','${categoryInfo.h1Title}','${categoryInfo.metaDescription}'),
    </#if>
</#list>

