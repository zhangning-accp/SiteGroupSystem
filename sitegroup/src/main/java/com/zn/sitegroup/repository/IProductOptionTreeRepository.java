package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductOptionTreesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductOptionTreeRepository extends JpaRepository<LcProductOptionTreesEntity,Long> {
    List<LcProductOptionTreesEntity> findByProductId(long productId);
}
