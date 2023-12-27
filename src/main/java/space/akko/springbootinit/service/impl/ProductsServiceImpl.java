package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.ProductsMapper;
import space.akko.springbootinit.model.entity.Products;
import space.akko.springbootinit.service.ProductsService;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @description 针对表【products(产品)】的数据库操作Service实现
 * @createDate 2023-12-27 09:30:04
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
        implements ProductsService {

    @Override
    public void validProducts(Products products, boolean add) {

        if (products == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        String brand = products.getBrand();
        String productName = products.getProductName();
        String productSpec = products.getProductSpec();
        String productUnit = products.getProductUnit();
        BigDecimal unitPrice = products.getUnitPrice();

        // 创建时，参数不能为空
        if (add) {
            // 判断品牌是否为空
            if (brand == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "品牌不能为空");
            }
            // 判断产品名称是否为空
            if (productName == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品名称不能为空");
            }
            // 判断产品规格是否为空
            if (productSpec == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品规格不能为空");
            }
            // 判断产品单位是否为空
            if (productUnit == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品单位不能为空");
            }
            // 判断产品单价是否为空
            if (unitPrice == null) {
                throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "产品单价不能为空");
            }
        }

        // 有参数则校验
        // 判断品牌是否过长，最大长度为20
        if (brand != null && brand.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "品牌过长");
        }
        // 判断产品名称是否过长，最大长度为40
        if (productName != null && productName.length() > 40) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "产品名称过长");
        }
        // 判断产品规格是否过长，最大长度为20
        if (productSpec != null && productSpec.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "产品规格过长");
        }
        // 判断产品单位是否过长，最大长度为20
        if (productUnit != null && productUnit.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "产品单位过长");
        }
        // 判断产品单价是否合理
        if (unitPrice != null && unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "产品单价不能为负数");
        }
    }
}




