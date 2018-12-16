<#setting number_format="#">
REPLACE INTO `lc_product_option_trees` VALUES
<#list datas as data>
    <#if data?is_last>
        (${data.id},${data.productId},${data.groupId},${data.valueId},${data.parentGroupId},${data.parentValueId},
        '${data.links}','${data.dateUpdate!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}');
    <#else>
        (${data.id},${data.productId},${data.groupId},${data.valueId},${data.parentGroupId},${data.parentValueId},
        '${data.links}','${data.dateUpdate!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}'),
    </#if>
</#list>

