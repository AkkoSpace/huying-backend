package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicProductBrand;
import space.akko.springbootinit.model.dto.BasicProductBrandAddRequest;
import space.akko.springbootinit.model.dto.BasicProductBrandUpdateRequest;

/**
 * @author Administrator
 * @description 针对表【basic_product_brand(产品品牌表)】的数据库操作Service
 * @createDate 2024-01-08 10:13:25
 */
public interface BasicProductBrandService extends IService<BasicProductBrand> {

    void validAddProductBrand(BasicProductBrandAddRequest basicProductBrandAddRequest);

    void validUpdateProductBrand(BasicProductBrandUpdateRequest basicProductBrandUpdateRequest);
}
