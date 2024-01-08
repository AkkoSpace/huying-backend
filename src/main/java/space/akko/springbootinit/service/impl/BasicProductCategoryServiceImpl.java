package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.BasicProductCategoryMapper;
import space.akko.springbootinit.model.domain.BasicProductCategory;
import space.akko.springbootinit.service.BasicProductCategoryService;

/**
 * @author Administrator
 * @description 针对表【basic_product_category(产品分类表)】的数据库操作Service实现
 * @createDate 2024-01-08 10:20:48
 */
@Service
public class BasicProductCategoryServiceImpl extends ServiceImpl<BasicProductCategoryMapper, BasicProductCategory>
        implements BasicProductCategoryService {

}




