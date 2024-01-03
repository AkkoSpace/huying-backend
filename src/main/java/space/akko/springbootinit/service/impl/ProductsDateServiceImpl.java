package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.ProductsDateMapper;
import space.akko.springbootinit.model.entity.ProductsDate;
import space.akko.springbootinit.service.ProductsDateService;

/**
 * @author Administrator
 * @description 针对表【products_date】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:26
 */
@Service
public class ProductsDateServiceImpl extends ServiceImpl<ProductsDateMapper, ProductsDate>
        implements ProductsDateService {

}




