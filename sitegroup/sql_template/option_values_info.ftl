<#setting number_format="#">
REPLACE INTO `lc_option_values_info` VALUES
<#list optionValuesInfo as optionValueInfo>
    <#if optionValueInfo?is_last>
        (${optionValueInfo.id},${optionValueInfo.valueId},'${optionValueInfo.languageCode}','${optionValueInfo.name}','${optionValueInfo.extensionName!''}');
    <#else>
        (${optionValueInfo.id},${optionValueInfo.valueId},'${optionValueInfo.languageCode}','${optionValueInfo.name}','${optionValueInfo.extensionName!''}'),
    </#if>
</#list>

