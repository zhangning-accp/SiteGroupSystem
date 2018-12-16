package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsOptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductOptionRepository extends JpaRepository<LcProductsOptionsEntity,Integer> {
}
