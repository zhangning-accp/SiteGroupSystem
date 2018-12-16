package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by zn on 2018/12/15.
 */
public interface ICategoryInfoRepository extends JpaRepository<LcCategoriesInfoEntity,Integer> {

//    @Query(value="SELECT categories.parentId,categoriesInfo.name,categoriesInfo.categoryId " +
//            "FROM LcCategoriesEntity as categories,LcCategoriesInfoEntity as categoriesInfo " +
//            "WHERE categories.parentId =?1 AND categoriesInfo.categoryId=categories.id")
//    List findChildCategoriesByParentId(int parentId);
}
