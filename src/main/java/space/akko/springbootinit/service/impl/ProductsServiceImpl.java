package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.ProductsMapper;
import space.akko.springbootinit.model.entity.Products;
import space.akko.springbootinit.service.ProductsService;

/**
 * @author Administrator
 * @description 针对表【products(产品)】的数据库操作Service实现
 * @createDate 2023-12-29 16:38:08
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
        implements ProductsService {

    @Override
    public void validProducts(Products products, boolean add) {

        if (products == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        String productName = products.getProductName();
        Integer brandId = products.getBrandId();
        Integer productSpecId = products.getProductSpecId();
        Integer productUnitId = products.getProductUnitId();

        // 创建时，参数不能为空
        if (add) {
            // 判断产品名称是否为空
            if (productName == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品名称不能为空");
            }
            // 判断品牌是否为空
            if (brandId == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "品牌不能为空");
            }

            // 判断产品规格是否为空
            if (productSpecId == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品规格不能为空");
            }
            // 判断产品单位是否为空
            if (productUnitId == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品单位不能为空");
            }
        } else {
            // 修改时，参数不能同时为空
            if (productName == null && brandId == null && productSpecId == null && productUnitId == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL,ErrorCode.PARAMS_IS_NULL.getMessage());
            }
        }
    }
}




