package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.ProductsSpecMapper;
import space.akko.springbootinit.model.entity.ProductsSpec;
import space.akko.springbootinit.service.ProductsSpecService;

/**
 * @author Administrator
 * @description 针对表【products_spec(产品规格)】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:46
 */
@Service
public class ProductsSpecServiceImpl extends ServiceImpl<ProductsSpecMapper, ProductsSpec>
        implements ProductsSpecService {

}




