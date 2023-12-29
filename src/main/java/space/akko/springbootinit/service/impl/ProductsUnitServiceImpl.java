package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.ProductsUnitMapper;
import space.akko.springbootinit.model.entity.ProductsUnit;
import space.akko.springbootinit.service.ProductsUnitService;

/**
 * @author Administrator
 * @description 针对表【products_unit(产品单位)】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:53
 */
@Service
public class ProductsUnitServiceImpl extends ServiceImpl<ProductsUnitMapper, ProductsUnit>
        implements ProductsUnitService {

}




