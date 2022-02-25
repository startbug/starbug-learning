package com.ggs.product.controller;


import com.ggs.common.R;
import com.ggs.product.entity.Product;
import com.ggs.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author Starbug
 * @since 2022-01-25
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Value("${product.name}")
    private String name;

    @PostMapping("/add")
    public R addProduct(@RequestBody Product product) {
        System.out.println(name);
        boolean result = productService.save(product);
        return result ? R.ok(true) : R.fail("添加失败");
    }

}
