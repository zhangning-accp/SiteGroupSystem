<#setting number_format="#">
REPLACE INTO `lc_product_groups` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},${data.status},'${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}');
    <#else>
        (${data.id},${data.status},'${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}'),
    </#if>
</#list>

