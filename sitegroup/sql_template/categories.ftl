<#setting number_format="#">
REPLACE INTO `lc_categories` VALUES
    <#list categories as category>
        <#if category?is_last>
            (${category.id},${category.parentId},${category.googleTaxonomyId},${category.status},'${category.code}',
            '${category.listStyle}','${category.dock}','${category.keywords}','${category.image}',
             ${category.priority},'${category.dateUpdated!'1970-01-01 01:01:01'}','${category.dateCreated!'1970-01-01 01:01:01'}');
        <#else>
            (${category.id},${category.parentId},'${category.googleTaxonomyId}',${category.status},'${category.code}',
            '${category.listStyle}','${category.dock}','${category.keywords}','${category.image}',
             ${category.priority},'${category.dateUpdated!'1970-01-01 01:01:01'}','${category.dateCreated!'1970-01-01 01:01:01'}'),
        </#if>
    </#list>
