package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.entity.Products;
import space.akko.springbootinit.mapper.ProductsMapper;
import space.akko.springbootinit.service.ProductsService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【products(产品)】的数据库操作Service实现
* @createDate 2023-12-27 09:30:04
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService{

}




