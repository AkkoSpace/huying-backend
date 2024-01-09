package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.model.dto.BasicProductAddRequest;
import space.akko.springbootinit.model.dto.BasicProductUpdateRequest;

/**
 * @author Administrator
 * @description 针对表【basic_product(产品信息表)】的数据库操作Service
 * @createDate 2024-01-08 09:48:46
 */
public interface BasicProductService extends IService<BasicProduct> {

    void validAddProduct(BasicProductAddRequest basicProductAddRequest);

    void validUpdateProduct(BasicProductUpdateRequest basicProductUpdateRequest);
}
