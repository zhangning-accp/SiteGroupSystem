package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsOptionsStockEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductOptionStockRepository extends JpaRepository<LcProductsOptionsStockEntity,Integer> {
    List<LcProductsOptionsStockEntity> findByProductId(int productId);
}
