package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicProductMapper;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.service.BasicProductService;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @description 针对表【basic_product(产品信息表)】的数据库操作Service实现
 * @createDate 2024-01-08 09:48:46
 */
@Service
public class BasicProductServiceImpl extends ServiceImpl<BasicProductMapper, BasicProduct>
        implements BasicProductService {

    @Override
    public void validProducts(BasicProduct basicProduct, boolean add) {
        if (basicProduct == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer id = basicProduct.getId();
        Integer brandId = basicProduct.getBrandId();
        Integer categoryId = basicProduct.getCategoryId();
        String productName = basicProduct.getProductName();
        String productCode = basicProduct.getBarCode();
        String productUnit = basicProduct.getProductUnit();
        String productSpec = basicProduct.getProductSpec();
        BigDecimal purchasePrice = basicProduct.getPurchasePrice();
        BigDecimal standardPrice = basicProduct.getStandardPrice();

        // id 为空时，表示新增，id 不为空时，表示修改
        if (!add && id == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "id 不能为空");
        }
        // 参数非空校验
        if (brandId == null || categoryId == null || productName == null || productUnit == null || productSpec == null || purchasePrice == null || standardPrice == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "参数不能为空");
        }
        // 参数范围校验
        if (brandId < 0 || categoryId < 0 || productName.isEmpty() || productUnit.isEmpty() || productSpec.isEmpty() || purchasePrice.compareTo(BigDecimal.ZERO) < 0 || standardPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "参数范围不正确");
        }
        // productCode 只能是数字或英文
        if (productCode != null && !productCode.isEmpty() && (!productCode.matches("^[A-Za-z0-9]+$"))) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "条形码只能是数字或英文");
        }
        // standardPrice 需要大于 purchasePrice
        if (standardPrice.compareTo(purchasePrice) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "标准单价不能小于进货单价");
        }


    }
}




