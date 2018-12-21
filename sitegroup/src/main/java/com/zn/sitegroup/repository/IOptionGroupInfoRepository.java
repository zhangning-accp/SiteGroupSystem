package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcOptionGroupsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zn on 2018/12/15.
 */
public interface IOptionGroupInfoRepository extends JpaRepository<LcOptionGroupsInfoEntity,Integer> {
    LcOptionGroupsInfoEntity findByGroupId(int groupId);
}
