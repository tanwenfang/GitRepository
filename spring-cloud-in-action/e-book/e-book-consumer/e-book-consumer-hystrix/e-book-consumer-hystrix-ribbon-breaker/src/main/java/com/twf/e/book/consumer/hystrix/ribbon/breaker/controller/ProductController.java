package com.twf.e.book.consumer.hystrix.ribbon.breaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twf.e.book.consumer.hystrix.ribbon.breaker.domain.Product;
import com.twf.e.book.consumer.hystrix.ribbon.breaker.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product>listProduct(@RequestParam("n") Integer n) {
		List<Product> list = productService.listProduct(n);
		return list;
	}
}
