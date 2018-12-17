<#setting number_format="#">
REPLACE INTO `lc_option_values` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},${data.groupId},'${data.value}',${data.priority});
    <#else>
    (${data.id},${data.groupId},'${data.value}',${data.priority}),
    </#if>
</#list>

