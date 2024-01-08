package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.BasicProductBrand;
import space.akko.springbootinit.service.BasicProductBrandService;
import space.akko.springbootinit.mapper.BasicProductBrandMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【basic_product_brand(产品品牌表)】的数据库操作Service实现
* @createDate 2024-01-08 10:13:25
*/
@Service
public class BasicProductBrandServiceImpl extends ServiceImpl<BasicProductBrandMapper, BasicProductBrand>
    implements BasicProductBrandService{

}




