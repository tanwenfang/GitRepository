package com.twf.sleuth.zipkin.mq.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.twf.sleuth.zipkin.mq.product.api.facade.ProductFacade;

@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade{

}
