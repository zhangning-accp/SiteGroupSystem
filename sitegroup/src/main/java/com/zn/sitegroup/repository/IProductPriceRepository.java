package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsPricesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductPriceRepository extends JpaRepository<LcProductsPricesEntity,Long> {
    List<LcProductsPricesEntity> findByProductId(long productId);
}
