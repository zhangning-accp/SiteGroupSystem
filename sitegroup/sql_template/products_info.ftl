<#setting number_format="#">
REPLACE INTO `lc_products_info` VALUES
    <#list datas as data>
        <#if data?is_last>
            (${data.id},${data.productId},'${data.languageCode}',
            '${data.name}','${data.shortDescription}','${data.description}',
            '${data.headTitle}','${data.metaDescription}','${data.attributes}');
        <#else>
            (${data.id},${data.productId},'${data.languageCode}',
            '${data.name}','${data.shortDescription}','${data.description}',
            '${data.headTitle}','${data.metaDescription}','${data.attributes}'),
        </#if>
    </#list>
