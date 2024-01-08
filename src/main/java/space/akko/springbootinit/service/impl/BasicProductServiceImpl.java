package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.service.BasicProductService;
import space.akko.springbootinit.mapper.BasicProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【basic_product(产品信息表)】的数据库操作Service实现
* @createDate 2024-01-08 09:48:46
*/
@Service
public class BasicProductServiceImpl extends ServiceImpl<BasicProductMapper, BasicProduct>
    implements BasicProductService{

}




