package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcProductGroupsValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IProductGroupValueRepository extends JpaRepository<LcProductGroupsValuesEntity,Integer> {
}
