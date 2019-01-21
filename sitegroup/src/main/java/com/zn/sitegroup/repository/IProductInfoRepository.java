package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by zn on 2018/12/14.
 */
public interface IProductInfoRepository extends JpaRepository<LcProductsInfoEntity,Long> {
    LcProductsInfoEntity findByProductId(long productId);

}
