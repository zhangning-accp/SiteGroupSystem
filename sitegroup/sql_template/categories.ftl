<#setting number_format="#">
REPLACE INTO `lc_categories` VALUES
    <#list datas as data>
        <#if data?is_last>
            (${data.id},${data.parentId},${data.googleTaxonomyId},${data.status},'${data.code}',
            '${data.listStyle}','${data.dock}','${data.keywords}','${data.image}',
             ${data.priority},'${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}');
        <#else>
            (${data.id},${data.parentId},'${data.googleTaxonomyId}',${data.status},'${data.code}',
            '${data.listStyle}','${data.dock}','${data.keywords}','${data.image}',
             ${data.priority},'${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}'),
        </#if>
    </#list>
