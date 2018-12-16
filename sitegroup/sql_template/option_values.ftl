<#setting number_format="#">
REPLACE INTO `lc_option_values` VALUES
<#list optionValues as optionValue>
    <#if optionValue?is_last>
        (${optionValue.id},${optionValue.groupId},'${optionValue.value}',${optionValue.priority});
    <#else>
    (${optionValue.id},${optionValue.groupId},'${optionValue.value}',${optionValue.priority}),
    </#if>
</#list>

