package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.ProductsBrandsMapper;
import space.akko.springbootinit.model.entity.ProductsBrands;
import space.akko.springbootinit.service.ProductsBrandsService;

/**
 * @author Administrator
 * @description 针对表【products_brands(产品品牌)】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:17
 */
@Service
public class ProductsBrandsServiceImpl extends ServiceImpl<ProductsBrandsMapper, ProductsBrands>
        implements ProductsBrandsService {

}




