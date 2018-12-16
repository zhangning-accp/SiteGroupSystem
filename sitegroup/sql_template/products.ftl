<#setting number_format="#">
REPLACE INTO `lc_products` VALUES
    <#list datas as data>
        <#if data?is_last>
            (${data.id},${data.status},${data.manufacturerId},${data.supplierId},
        ${data.deliveryStatusId},${data.soldOutStatusId},${data.defaultCategoryId},
        '${data.productGroups}','${data.keywords}','${data.code}','${data.sku}',
        '${data.mpn}','${data.upc}','${data.gtin}','${data.taric}',${data.quantity},
        ${data.quantityUnitId},${data.weight},'${data.weightClass}',${data.dimX},${data.dimY},${data.dimZ},
        '${data.dimClass}',${data.purchasePrice},'${data.purchasePriceCurrencyCode}',
        ${data.taxClassId},'${data.image}',${data.views},${data.purchases},'${data.dateValidFrom!'1970-01-01 01:01:01'}',
        '${data.dateValidTo!'1970-01-01 01:01:01'}','${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}');
        <#else>
            (${data.id},${data.status},${data.manufacturerId},${data.supplierId},
        ${data.deliveryStatusId},${data.soldOutStatusId},${data.defaultCategoryId},
        '${data.productGroups}','${data.keywords}','${data.code}','${data.sku}',
        '${data.mpn}','${data.upc}','${data.gtin}','${data.taric}',${data.quantity},
        ${data.quantityUnitId},${data.weight},'${data.weightClass}',${data.dimX},${data.dimY},${data.dimZ},
        '${data.dimClass}',${data.purchasePrice},'${data.purchasePriceCurrencyCode}',
        ${data.taxClassId},'${data.image}',${data.views},${data.purchases},'${data.dateValidFrom!'1970-01-01 01:01:01'}',
        '${data.dateValidTo!'1970-01-01 01:01:01'}','${data.dateUpdated!'1970-01-01 01:01:01'}','${data.dateCreated!'1970-01-01 01:01:01'}'),
        </#if>
    </#list>
