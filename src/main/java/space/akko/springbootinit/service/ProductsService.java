package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.entity.Products;

/**
 * @author Administrator
 * @description 针对表【products(产品)】的数据库操作Service
 * @createDate 2023-12-27 09:30:04
 */
public interface ProductsService extends IService<Products> {
    /**
     * 校验
     *
     * @param products 产品
     * @param add      新增
     */
    void validProducts(Products products, boolean add);
}
