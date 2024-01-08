package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicProduct;

/**
 * @author Administrator
 * @description 针对表【basic_product(产品信息表)】的数据库操作Service
 * @createDate 2024-01-08 09:48:46
 */
public interface BasicProductService extends IService<BasicProduct> {

    void validProducts(BasicProduct basicProduct, boolean b);
}
