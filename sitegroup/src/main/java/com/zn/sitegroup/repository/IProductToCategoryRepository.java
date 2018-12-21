package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsToCategoriesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductToCategoryRepository extends JpaRepository<LcProductsToCategoriesEntity,Integer> {
    /**
     * 查找分类下有哪些商品
     * @param categoryId
     * @return
     */
    List<LcProductsToCategoriesEntity> findProductsByCategoryId(int categoryId);

    /**
     * 查找产品下有哪些分类
     * @param productId
     * @return
     */
    List<LcProductsToCategoriesEntity> findByProductId(int productId);
}
