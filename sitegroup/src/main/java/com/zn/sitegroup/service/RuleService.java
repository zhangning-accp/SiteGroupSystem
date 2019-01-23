package com.zn.sitegroup.service;

import com.zn.sitegroup.entity.DcRulesEntity;
import com.zn.sitegroup.repository.IRulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zn on 2019/1/19.
 */
@Service
public class RuleService {
    @Autowired
    IRulesRepository iRulesRepository;
    DcRulesEntity find(long id){
        return iRulesRepository.getOne(id);
    }

}
