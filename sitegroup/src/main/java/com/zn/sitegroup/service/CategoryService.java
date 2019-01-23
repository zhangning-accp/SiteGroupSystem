package com.zn.sitegroup.service;

import com.zn.sitegroup.dto.CategoryDto;
import com.zn.sitegroup.entity.LcCategoriesEntity;
import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import com.zn.sitegroup.entity.LcProductsEntity;
import com.zn.sitegroup.entity.LcProductsToCategoriesEntity;
import com.zn.sitegroup.repository.ICategoryInfoRepository;
import com.zn.sitegroup.repository.ICategoryRepository;
import com.zn.sitegroup.repository.IProductRepository;
import com.zn.sitegroup.repository.IProductToCategoryRepository;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zn on 2018/12/16.
 * 分类相关的服务
 */
@Service
@Slf4j
public class CategoryService {
    @Autowired
    ICategoryInfoRepository categoryInfoRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IProductToCategoryRepository productToCategoryRepository;


    /**
     * 找到该分类下的产品
     * @param categoryId
     * @param isAll 找到分类下所有商品(递归所有子分类)。如果为false，只找属于当前分类下的商品
     * @return
     */
    List<LcProductsEntity> findProductsByCategoryContainAllChildrenCategory(long categoryId,boolean isAll) {
        List<LcProductsEntity> productsEntityList = new ArrayList<>();
        // 因为一个产品可能属于父分类也可能属于子分类，所以要先去重，减少对象量。同时也能减少sql语句的量
        Set<LcProductsEntity> productsEntitySet = new HashSet<>();
        Set<Integer> productIdSet = new HashSet<>();

        List<CategoryDto> parentsDto = findCategory(categoryId);
        for(CategoryDto categoryDto : parentsDto) {
            categoryId = categoryDto.getCategoryId();

            List<CategoryDto> categoryChildren = null;// 当前分类下子分类集合
            if (isAll == true) {
                // 1 找到当前分类下有哪些子分类
                categoryChildren = findParentAllChildern(categoryId);

            } else {
                // 找到当前分类下的一级分类
                categoryChildren = findFirstChildren(categoryId);
            }
            log.info("categoryId:{} 子分类获取完毕开始获取商品数据，子分类size:{}",categoryId,categoryChildren.size());

            //找到当前父分类有哪些直接产品集合
            List<LcProductsToCategoriesEntity> productsToCategoriesEntityList = productToCategoryRepository.findProductsByCategoryId(categoryId);
            for (LcProductsToCategoriesEntity productToCategory : productsToCategoriesEntityList) {// 这里和下面居然写了两个一样的逻辑，需要检查一下为什么
                int productId = productToCategory.getProductId();
                if (!productIdSet.contains(productId)) {
                    LcProductsEntity productsEntity = productRepository.findById(productId).get();
                    productsEntitySet.add(productsEntity);
                    productIdSet.add(productId);
                }
            }
            log.info("categoryId:{} 商品数据获取完毕,开始获取下属所有子类商品,去重前size:{},去重后size:{}",categoryId,productsToCategoriesEntityList.size(),productsEntitySet.size());
            // 以下代码非常耗时，18w的数据耗时10-12分钟，怎么优化？
            //1. 判断如果产品数量占总数量的2/3以上，则全部导出。
            for (CategoryDto dto : categoryChildren) {
                categoryId = dto.getCategoryId();
                //2. 找到这些子分类对应有哪些产品
                productsToCategoriesEntityList = productToCategoryRepository.findProductsByCategoryId(categoryId);
//                log.info("categoryId:{}商品数据获取完毕,去重前size:{},去重后size:{}",categoryId,productsToCategoriesEntityList.size(),productsEntitySet.size());
                //3. 获取这些产品信息
                for (LcProductsToCategoriesEntity productToCategory : productsToCategoriesEntityList) {
                    int productId = productToCategory.getProductId();
                    if (!productIdSet.contains(productId)) {
                        LcProductsEntity productsEntity = productRepository.findById(productId).get();
                        productsEntitySet.add(productsEntity);
                        productIdSet.add(productId);
                    }
                }
            }
            log.info("所有子分类商品数据获取完毕,开始放入到list集合去重前size:{},去重后size:{}",productsToCategoriesEntityList.size(),productsEntitySet.size());
        }
        log.info("所有商品数据获取完毕，开始放入到商品集合");
        // 4. 将set集合里的数据放入到list，构成当前分类下所有商品集合
        Iterator<LcProductsEntity> iterator = productsEntitySet.iterator();
        while (iterator.hasNext()) {
            productsEntityList.add(iterator.next());
        }
        log.info("商品放入集合完毕 size{}",productsEntityList.size());

        return productsEntityList;
    }

    /**
     * Not test
     * 查询指定父分类id下直接孩子分类(一级子分类)。返回的list里不包含parentId对应的父分类信息
     * @param parentId
      * @return 返回CategoryDto对象
     */
    private List<CategoryDto> findFirstChildren(long parentId) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<LcCategoriesEntity> childrenId = categoryRepository.findByParentId(parentId);
        CategoryDto categoryDto = null;
        for(LcCategoriesEntity categoriesEntity:childrenId) {
            LcCategoriesInfoEntity categoriesInfoEntity = categoryInfoRepository.findByCategoryId(categoriesEntity.getId());
            categoryDto = builder(categoriesEntity,categoriesInfoEntity,true);

            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    /**
     * Not test
     * 获取该父类下的所有孩子，但是没有层级嵌套，是平行结构。返回的结果不包含parentId对应的父分类信息
     * @param parentId
     * @return
     */
   public List<CategoryDto> findParentAllChildern(long parentId) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto categoryDto = null;
        if (parentId < 1) {
            List<LcCategoriesEntity> categoriesEntityList = categoryRepository.findAll();
            List<LcCategoriesInfoEntity> categoriesInfoEntityList = categoryInfoRepository.findAll();
            for (int i = 0; i < categoriesEntityList.size(); i++) {
                LcCategoriesEntity child = categoriesEntityList.get(i);
                LcCategoriesInfoEntity childInfo = categoriesInfoEntityList.get(i);
                categoryDto = builder(child, childInfo, true);
                categoryDtoList.add(categoryDto);
            }
        } else {
            List<Long> childsId = categoryRepository.findParentAllChildrenId(parentId);
             for (int i = 0; i < childsId.size(); i++) {
                 String idString = childsId.get(i)+"";
                 long id = Long.parseLong(idString);
                 LcCategoriesEntity child = categoryRepository.findById(id).get();
                 LcCategoriesInfoEntity childInfo = categoryInfoRepository.findByCategoryId(id);
                 categoryDto = builder(child, childInfo, true);
                 categoryDtoList.add(categoryDto);
            }
        }
        return categoryDtoList;
    }

    /**
     * Not test
     * 返回子类所有的父类，返回的信息里包含childId代表的子类，数据由父到子排列。
     * @param childId
     * @return
     */
    public List<CategoryDto> findChildParents(long childId) {
        // 查询当前分类的所有父分类
        List<LcCategoriesEntity> parents = categoryRepository.findChildParents(childId);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto categoryDto = null;
        for(LcCategoriesEntity parent : parents) {
            LcCategoriesInfoEntity parentInfo = categoryInfoRepository.findByCategoryId(parent.getId());
            categoryDto = builder(parent,parentInfo,true);
            categoryDtoList.add(categoryDto);
        }

        return categoryDtoList;
    }

    /**
     * 获取当前分类的信息，如果categoryId为0，表示是找默认的根分类，此时方法会返回根分类下的一级子分类。
     * @param categoryId
     * @return
     */
    public List<CategoryDto> findCategory(long categoryId) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<LcCategoriesEntity> categoriesEntityList = new ArrayList<>();
        if(categoryId < 1) {// 表示是找根分类下的所有一级子分类
            categoriesEntityList.addAll(categoryRepository.findByParentId(categoryId));
        } else {
            categoriesEntityList.add(categoryRepository.findById(categoryId).get());
        }
        for(LcCategoriesEntity categoriesEntity : categoriesEntityList) {
            LcCategoriesInfoEntity categoriesInfoEntity = categoryInfoRepository.findByCategoryId(categoriesEntity.getId());
            CategoryDto categoryDto = builder(categoriesEntity, categoriesInfoEntity, false);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    /**
     *
     * @param categoriesEntity
     * @param categoriesInfoEntity
     * @param isGetParentId 这个参数指的是dto里的parentId是取categoriesEntity的parentId还是id。
     *                      因为有时传入的categoriesEntity实际上就是parent本身所以这时不能取parentId
     * @return
     */
    private CategoryDto builder(LcCategoriesEntity categoriesEntity,LcCategoriesInfoEntity categoriesInfoEntity,boolean isGetParentId) {
        CategoryDto categoryDto = new CategoryDto();
            /*Categories*/
        categoryDto.setCategoryId(categoriesEntity.getId());
        if(isGetParentId == true) {
            categoryDto.setParentId(categoriesEntity.getParentId());
        } else {
            categoryDto.setParentId(categoriesEntity.getId());
        }
//        categoryDto.setParentId(categoriesEntity.getParentId());
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

        return categoryDto;
    }
    private LcCategoriesEntity getCategoriesEntityByCategoryDto(CategoryDto categoryDto) {
        LcCategoriesEntity categoriesEntity = new LcCategoriesEntity();

        categoriesEntity.setId(categoryDto.getCategoryId());
        categoriesEntity.setParentId(categoryDto.getParentId());
        categoriesEntity.setGoogleTaxonomyId(categoryDto.getGoogleTaxonomyId());
        categoriesEntity.setStatus(categoryDto.getStatus());
        categoriesEntity.setCode(categoryDto.getCode());
        categoriesEntity.setListStyle(categoryDto.getListStyle());
        categoriesEntity.setDock(categoryDto.getDock());
        categoriesEntity.setKeywords(categoryDto.getKeywords());
        categoriesEntity.setImage(categoryDto.getImage());
        categoriesEntity.setPriority(categoryDto.getPriority());
        categoriesEntity.setDateUpdated(categoryDto.getDateUpdated());
        categoriesEntity.setDateCreated(categoryDto.getDateCreated());

        return categoriesEntity;

    }

    private LcCategoriesInfoEntity getCategoriesInfoEntityByCategoryDto(CategoryDto categoryDto) {
        LcCategoriesInfoEntity categoriesInfoEntity = new LcCategoriesInfoEntity();
        categoriesInfoEntity.setId(categoryDto.getCategoryInfoId());
        categoriesInfoEntity.setCategoryId(categoryDto.getCategoryId());
        categoriesInfoEntity.setLanguageCode(categoryDto.getLanguageCode());
        categoriesInfoEntity.setName(categoryDto.getName());
        categoriesInfoEntity.setShortDescription(categoryDto.getShortDescription());
        categoriesInfoEntity.setDescription(categoryDto.getDescription());
        categoriesInfoEntity.setHeadTitle(categoryDto.getHeadTitle());
        categoriesInfoEntity.setH1Title(categoryDto.getH1Title());
        categoriesInfoEntity.setMetaDescription(categoryDto.getMetaDescription());

        return categoriesInfoEntity;
    }
}
