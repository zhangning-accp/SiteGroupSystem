<#setting number_format="#">
REPLACE INTO `lc_option_values_info` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},${data.valueId},'${data.languageCode}','${data.name}','${data.extensionName!''}');
    <#else>
        (${data.id},${data.valueId},'${data.languageCode}','${data.name}','${data.extensionName!''}'),
    </#if>
</#list>

