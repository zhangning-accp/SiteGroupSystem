<#setting number_format="#">
REPLACE INTO `lc_option_groups_info` VALUES
<#list datas as data>
    <#if data?is_last>
    (${data.id},${data.groupId},'${data.languageCode}','${data.name}','${data.description}');
    <#else>
    (${data.id},${data.groupId},'${data.languageCode}','${data.name}','${data.description}'),    </#if>
</#list>

