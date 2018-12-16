package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcCategoriesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/13.
 */
public interface ICategoryRepository extends JpaRepository<LcCategoriesEntity,Integer> {
    List<LcCategoriesEntity> findByParentId(int parentId);
//    List<Integer> findIdsByParentId(int parentId);
}
