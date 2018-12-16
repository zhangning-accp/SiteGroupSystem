package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zn on 2018/12/13.
 */
public interface IProductRepository extends JpaRepository<LcProductsEntity,Integer>{

}
