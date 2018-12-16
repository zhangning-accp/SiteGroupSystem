<#setting number_format="#">
REPLACE INTO `lc_products_info` VALUES
    <#list productsInfo as info>
        <#if info?is_last>
            (${info.id},${info.productId},'${info.languageCode}',
            '${info.name}','${info.shortDescription}','${info.description}',
            '${info.headTitle}','${info.metaDescription}','${info.attributes}');
        <#else>
            (${info.id},${info.productId},'${info.languageCode}',
            '${info.name}','${info.shortDescription}','${info.description}',
            '${info.headTitle}','${info.metaDescription}','${info.attributes}'),
        </#if>
    </#list>
