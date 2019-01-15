package com.zn.sitegroup.service;

import com.zn.sitegroup.dto.ProductDto;
import com.zn.sitegroup.entity.LcProductsEntity;
import com.zn.sitegroup.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zn on 2018/12/13.
 */
@Service
public class ProductService {
    @Autowired
    private IProductRepository iProductRepository;


    public List<LcProductsEntity> findAll() {
        return iProductRepository.findAll();
    }
    public Long count() {
        return iProductRepository.count();
    }

    public List<ProductDto> findProductsByCategoryId(int categoryId) {
        return null;
    }
}
