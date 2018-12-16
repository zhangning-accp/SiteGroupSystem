<#setting number_format="#">
REPLACE INTO `lc_option_groups` VALUES
<#list optionGroups as optionGroup>
    <#if optionGroup?is_last>
        (${optionGroup.id},'${optionGroup.function}',${optionGroup.required},'${optionGroup.sort}',
        '${optionGroup.dateUpdated!'1970-01-01 01:01:01'}','${optionGroup.dateCreated!'1970-01-01 01:01:01'}');
    <#else>
    (${optionGroup.id},'${optionGroup.function}',${optionGroup.required},'${optionGroup.sort}',
    '${optionGroup.dateUpdated!'1970-01-01 01:01:01'}','${optionGroup.dateCreated!'1970-01-01 01:01:01'}'),
    </#if>
</#list>

