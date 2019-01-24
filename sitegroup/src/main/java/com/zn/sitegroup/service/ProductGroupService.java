package com.zn.sitegroup.service;

import com.zn.sitegroup.dto.ProductDto;
import com.zn.sitegroup.dto.ProductGroupDto;
import com.zn.sitegroup.entity.LcProductGroupsEntity;
import com.zn.sitegroup.entity.LcProductGroupsInfoEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesInfoEntity;
import com.zn.sitegroup.repository.IProductGroupInfoRepository;
import com.zn.sitegroup.repository.IProductGroupRepository;
import com.zn.sitegroup.repository.IProductGroupValueInfoRepository;
import com.zn.sitegroup.repository.IProductGroupValueRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zn on 2019/1/24.
 */
@Service
public class ProductGroupService {
    @Autowired
    IProductGroupRepository productGroupRepository;
    @Autowired
    IProductGroupInfoRepository productGroupInfoRepository;
    @Autowired
    IProductGroupValueRepository productGroupValueRepository;
    @Autowired
    IProductGroupValueInfoRepository productGroupValueInfoRepository;

    public List<ProductGroupDto> findAll() {
        List<ProductGroupDto> list = new ArrayList<>();
        List<LcProductGroupsEntity> productGroupsEntityList = productGroupRepository.findAll();
        List<LcProductGroupsInfoEntity> productGroupsInfoEntityList = productGroupInfoRepository.findAll();
        List<LcProductGroupsValuesEntity> productGroupsValuesEntityList = productGroupValueRepository.findAll();
        List<LcProductGroupsValuesInfoEntity> productGroupsValuesInfoEntityList = productGroupValueInfoRepository.findAll();
        ProductGroupDto dto = null;
        for(LcProductGroupsEntity entity : productGroupsEntityList) {
            dto = new ProductGroupDto();
            long groupId = entity.getId();
            // 获取info信息
            LcProductGroupsInfoEntity infoEntity = productGroupsInfoEntityList.stream().filter(info->{return info.getProductGroupId() == groupId;}).findFirst().get();
            dto.setName(infoEntity.getName());
            dto.setId(groupId);
            // 获取value信息
            List<LcProductGroupsValuesEntity> values = productGroupsValuesEntityList.stream().filter(value->{
                return value.getProductGroupId() == groupId;
            }).collect(Collectors.toList());
            List<ProductGroupDto> valueList = null;
            for(LcProductGroupsValuesEntity value : values) {
                valueList = new ArrayList<>();
                long valueId = value.getId();
                ProductGroupDto valueInfo = new ProductGroupDto();
                LcProductGroupsValuesInfoEntity groupValuesInfo = productGroupsValuesInfoEntityList.stream().filter(v->{
                    return v.getProductGroupValueId() == valueId;
                }).findFirst().get();
                valueInfo.setId(valueId);
                valueInfo.setName(groupValuesInfo.getName());
                valueList.add(valueInfo);
            }
            dto.setValues(valueList);
        }

        return list;

    }

    private ProductGroupDto builder(LcProductGroupsEntity productGroupsEntity,
                                    LcProductGroupsInfoEntity productGroupsInfoEntity,
                                    List<LcProductGroupsValuesEntity> productGroupsValuesEntities,
                                    List<LcProductGroupsValuesInfoEntity> productGroupsValuesInfoEntities) {
        ProductGroupDto dto = new ProductGroupDto();
//        dto.setProductGroupsEntity(productGroupsEntity);
//        dto.setProductGroupsInfoEntity(productGroupsInfoEntity);
//        dto.setProductGroupsValuesEntities(productGroupsValuesEntities);
//        dto.setProductGroupsValuesInfoEntities(productGroupsValuesInfoEntities);

        return dto;
    }
}
