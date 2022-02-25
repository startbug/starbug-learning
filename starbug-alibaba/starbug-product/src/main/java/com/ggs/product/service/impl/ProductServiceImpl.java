package com.ggs.product.service.impl;

import com.ggs.product.entity.Product;
import com.ggs.product.mapper.ProductMapper;
import com.ggs.product.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author Starbug
 * @since 2022-01-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
