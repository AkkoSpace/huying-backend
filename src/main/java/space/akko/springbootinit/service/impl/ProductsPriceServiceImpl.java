package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.ProductsPriceMapper;
import space.akko.springbootinit.model.entity.ProductsPrice;
import space.akko.springbootinit.service.ProductsPriceService;

/**
 * @author Administrator
 * @description 针对表【products_price】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:32
 */
@Service
public class ProductsPriceServiceImpl extends ServiceImpl<ProductsPriceMapper, ProductsPrice>
        implements ProductsPriceService {

}




