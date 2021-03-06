package com.twf.sleuth.product.core.persistence;

import java.util.List;

import com.twf.sleuth.product.api.domain.Product;

public interface ProductMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);
    
    int insertSelective(Product record);
    
    Product selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(Product record);
    
    int updateByPrimaryKey(Product record);
    
    public List<Product> findAllProduct();
}