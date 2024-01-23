package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicProductCategory;
import space.akko.springbootinit.model.dto.BasicProductCategoryAddRequest;
import space.akko.springbootinit.model.dto.BasicProductCategoryUpdateRequest;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【basic_product_category(产品分类表)】的数据库操作Service
 * @createDate 2024-01-08 10:20:48
 */
public interface BasicProductCategoryService extends IService<BasicProductCategory> {

    void validAddProductCategory(BasicProductCategoryAddRequest basicProductCategoryAddRequest);

    void validUpdateProductCategory(BasicProductCategoryUpdateRequest basicProductCategoryUpdateRequest);

    List<BasicProductCategory> searchProductCategory(String value);
}
