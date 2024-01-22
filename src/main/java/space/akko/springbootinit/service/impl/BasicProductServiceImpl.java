package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicProductMapper;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.model.dto.BasicProductAddRequest;
import space.akko.springbootinit.model.dto.BasicProductUpdateRequest;
import space.akko.springbootinit.service.BasicProductService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【basic_product(产品信息表)】的数据库操作Service实现
 * @createDate 2024-01-08 09:48:46
 */
@Service
public class BasicProductServiceImpl extends ServiceImpl<BasicProductMapper, BasicProduct>
        implements BasicProductService {

    @Override
    public void validAddProduct(BasicProductAddRequest basicProductSaveRequest) {
        if (basicProductSaveRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer brandId = basicProductSaveRequest.getBrandId();
        Integer categoryId = basicProductSaveRequest.getCategoryId();
        String productName = basicProductSaveRequest.getProductName();
        String productCode = basicProductSaveRequest.getBarCode();
        String productSpec = basicProductSaveRequest.getProductSpec();
        String productUnit = basicProductSaveRequest.getProductUnit();
        BigDecimal purchasePrice = basicProductSaveRequest.getPurchasePrice();
        BigDecimal standardPrice = basicProductSaveRequest.getStandardPrice();

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
        // productUnit 单位长度不能大于1
        if (productUnit.length() > 1) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "产品单位长度不能大于1");
        }
        // standardPrice 需要大于 purchasePrice
        if (standardPrice.compareTo(purchasePrice) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "标准单价不能小于进货单价");
        }


    }

    @Override
    public void validUpdateProduct(BasicProductUpdateRequest basicProductUpdateRequest) {
        if (basicProductUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer id = basicProductUpdateRequest.getId();
        Integer brandId = basicProductUpdateRequest.getBrandId();
        Integer categoryId = basicProductUpdateRequest.getCategoryId();
        String productName = basicProductUpdateRequest.getProductName();
        String productCode = basicProductUpdateRequest.getBarCode();
        String productSpec = basicProductUpdateRequest.getProductSpec();
        String productUnit = basicProductUpdateRequest.getProductUnit();
        BigDecimal purchasePrice = basicProductUpdateRequest.getPurchasePrice();
        BigDecimal standardPrice = basicProductUpdateRequest.getStandardPrice();

        // 参数非空校验
        if (id == null || brandId == null || categoryId == null || productName == null || productUnit == null || productSpec == null || purchasePrice == null || standardPrice == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "参数不能为空");
        }
        // 参数范围校验
        if (id < 0 || brandId < 0 || categoryId < 0 || productName.isEmpty() || productUnit.isEmpty() || productSpec.isEmpty() || purchasePrice.compareTo(BigDecimal.ZERO) < 0 || standardPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "参数范围不正确");
        }
        // productCode 只能是数字或英文
        if (productCode != null && !productCode.isEmpty() && (!productCode.matches("^[A-Za-z0-9]+$"))) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "条形码只能是数字或英文");
        }
        // productUnit 单位长度不能大于1
        if (productUnit.length() > 1) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "产品单位长度不能大于1");
        }
        // standardPrice 需要大于 purchasePrice
        if (standardPrice.compareTo(purchasePrice) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "标准单价不能小于进货单价");
        }
    }

    @Override
    public List<BasicProduct> searchProduct(String productName) {
        return this.lambdaQuery().like(BasicProduct::getProductName, productName).list();
    }
}




