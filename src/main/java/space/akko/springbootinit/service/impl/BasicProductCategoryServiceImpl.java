package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicProductCategoryMapper;
import space.akko.springbootinit.model.domain.BasicProductCategory;
import space.akko.springbootinit.model.dto.BasicProductCategoryAddRequest;
import space.akko.springbootinit.model.dto.BasicProductCategoryUpdateRequest;
import space.akko.springbootinit.service.BasicProductCategoryService;

/**
 * @author Administrator
 * @description 针对表【basic_product_category(产品分类表)】的数据库操作Service实现
 * @createDate 2024-01-08 10:20:48
 */
@Service
public class BasicProductCategoryServiceImpl extends ServiceImpl<BasicProductCategoryMapper, BasicProductCategory>
        implements BasicProductCategoryService {

    @Override
    public void validAddProductCategory(BasicProductCategoryAddRequest basicProductCategoryAddRequest) {
        if (basicProductCategoryAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        String productAttribute = basicProductCategoryAddRequest.getProductAttribute();
        String productType = basicProductCategoryAddRequest.getProductType();

        // 参数非空校验
        if (productAttribute == null || productAttribute.isEmpty() || productType == null || productType.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        // 长度不大于 10
        if (productAttribute.length() > 10 || productType.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
    }

    @Override
    public void validUpdateProductCategory(BasicProductCategoryUpdateRequest basicProductCategoryUpdateRequest) {
        if (basicProductCategoryUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer id = basicProductCategoryUpdateRequest.getId();
        String productAttribute = basicProductCategoryUpdateRequest.getProductAttribute();
        String productType = basicProductCategoryUpdateRequest.getProductType();

        // 参数非空校验
        if (id == null || productAttribute == null || productAttribute.isEmpty() || productType == null || productType.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        // 长度不大于 10
        if (productAttribute.length() > 10 || productType.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
    }
}




