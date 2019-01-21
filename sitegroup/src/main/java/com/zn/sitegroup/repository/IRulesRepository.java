package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.DcRulesEntity;
import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IRulesRepository extends JpaRepository<DcRulesEntity,Long> {

}
