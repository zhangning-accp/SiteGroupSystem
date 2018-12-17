<#setting number_format="#">
REPLACE INTO `lc_option_groups` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},'${data.function}',${data.required},'${data.sort}',
        '${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}');
    <#else>
    (${data.id},'${data.function}',${data.required},'${data.sort}',
    '${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}'),
    </#if>
</#list>

