package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicProductBrandMapper;
import space.akko.springbootinit.model.domain.BasicProductBrand;
import space.akko.springbootinit.model.dto.BasicProductBrandAddRequest;
import space.akko.springbootinit.model.dto.BasicProductBrandUpdateRequest;
import space.akko.springbootinit.service.BasicProductBrandService;

/**
 * @author Administrator
 * @description 针对表【basic_product_brand(产品品牌表)】的数据库操作Service实现
 * @createDate 2024-01-08 10:13:25
 */
@Service
public class BasicProductBrandServiceImpl extends ServiceImpl<BasicProductBrandMapper, BasicProductBrand>
        implements BasicProductBrandService {

    @Override
    public void validAddProductBrand(BasicProductBrandAddRequest basicProductBrandAddRequest) {
        if (basicProductBrandAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        String brandName = basicProductBrandAddRequest.getBrandName();

        // 参数非空校验
        if (brandName.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "参数不能为空");
        }

        // 品牌名称长度不能超过 10
        if (brandName.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "参数范围不正确");
        }

        // 品牌名称不能重复
        if (this.lambdaQuery().eq(BasicProductBrand::getBrandName, brandName).count() > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "品牌名称已存在");
        }
    }

    @Override
    public void validUpdateProductBrand(BasicProductBrandUpdateRequest basicProductBrandUpdateRequest) {
        if (basicProductBrandUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer id = basicProductBrandUpdateRequest.getId();
        String brandName = basicProductBrandUpdateRequest.getBrandName();

        // 参数非空校验
        if (id == null || brandName == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL, "参数不能为空");
        }

        // 品牌名称长度不能超过 10
        if (brandName.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE, "参数范围不正确");
        }

        // 品牌名称不能重复
        if (this.lambdaQuery().eq(BasicProductBrand::getBrandName, brandName).count() > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "品牌名称已存在");
        }
    }
}




