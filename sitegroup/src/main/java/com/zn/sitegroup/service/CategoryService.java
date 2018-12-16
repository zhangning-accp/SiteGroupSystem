package com.zn.sitegroup.service;

import com.zn.sitegroup.dto.CategoryDto;
import com.zn.sitegroup.entity.LcCategoriesEntity;
import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import com.zn.sitegroup.repository.ICategoryInfoRepository;
import com.zn.sitegroup.repository.ICategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zn on 2018/12/16.
 * 分类相关的服务
 */
@Service
public class CategoryService {
    @Autowired
    ICategoryInfoRepository categoryInfoRepository;
    @Autowired
    ICategoryRepository categoryRepository;

    /**
     * 查询指定父类下的一级子分类
     * @param parentId
     * @param level:搜索层级，如果小于1，就是递归搜索所有子分类。预留参数。
     * @return 返回CategoryDto对象
     */
    List<CategoryDto> findChildCategoriesByParentId(int parentId,int level) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<LcCategoriesEntity> categoryIds = categoryRepository.findByParentId(parentId);
        CategoryDto categoryDto = null;
        for(LcCategoriesEntity categoriesEntity:categoryIds) {
            LcCategoriesInfoEntity categoriesInfoEntity = categoryInfoRepository.findById(categoriesEntity.getId()).get();
            categoryDto = new CategoryDto();
            /*Categories*/
            categoryDto.setCategoryId(categoriesEntity.getId());
            categoryDto.setParentId(parentId);
            categoryDto.setGoogleTaxonomyId(categoriesEntity.getGoogleTaxonomyId());
            categoryDto.setStatus(categoriesEntity.getStatus());
            categoryDto.setCode(categoriesEntity.getCode());
            categoryDto.setListStyle(categoriesEntity.getListStyle());
            categoryDto.setDock(categoriesEntity.getDock());
            categoryDto.setKeywords(categoriesEntity.getKeywords());
            categoryDto.setImage(categoriesEntity.getImage());
            categoryDto.setPriority(categoriesEntity.getPriority());
            categoryDto.setDateCreated(categoriesEntity.getDateCreated());
            categoryDto.setDateUpdated(categoriesEntity.getDateUpdated());
            /*Categories info*/
            categoryDto.setCategoryInfoId(categoriesInfoEntity.getId());
            categoryDto.setLanguageCode(categoriesInfoEntity.getLanguageCode());
            categoryDto.setName(categoriesInfoEntity.getName());
            categoryDto.setShortDescription(categoriesInfoEntity.getShortDescription());
            categoryDto.setDescription(categoriesInfoEntity.getDescription());
            categoryDto.setHeadTitle(categoriesInfoEntity.getHeadTitle());
            categoryDto.setH1Title(categoriesInfoEntity.getH1Title());
            categoryDto.setMetaDescription(categoriesInfoEntity.getMetaDescription());

            categoryDtoList.add(categoryDto);

        }

        return categoryDtoList;
    }

}
