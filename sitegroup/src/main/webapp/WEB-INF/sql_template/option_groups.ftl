<#setting number_format="#">REPLACE INTO `lc_option_groups` VALUES<#list datas as data><#if data?is_last>(${data.id},'${data.function}',${data.required},'${data.sort}','${(data.dateUpdated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}','${(data.dateCreated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}');
<#else>(${data.id},'${data.function}',${data.required},'${data.sort}','${(data.dateUpdated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}','${(data.dateCreated?string["yyyy-MM-dd hh:mm:ss"])!'1970-01-01 01:01:01'}'),</#if></#list>