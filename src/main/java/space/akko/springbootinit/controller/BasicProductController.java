package space.akko.springbootinit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.BasicProductSaveRequest;
import space.akko.springbootinit.service.BasicProductService;
import space.akko.springbootinit.service.SystemUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户接口
 *
 * @author Akko
 */
@CrossOrigin(origins = {"http://localhost:5173", "https://hy.akko.space"}, maxAge = 3600)
@RestController
@RequestMapping("/basic")
@Slf4j
public class BasicProductController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicProductService basicProductService;

    /**
     * 新增产品
     *
     * @param
     * @return
     */
    @PostMapping("/product")
    public BaseResponse<Long> addProduct(@RequestBody BasicProductSaveRequest basicProductAddRequest, HttpServletRequest request) {
        if (basicProductAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProduct basicProduct = new BasicProduct();
        basicProductService.validProducts(basicProduct, true);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProduct.setUserId(loginUser.getId());
        boolean result = basicProductService.save(basicProduct);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newProductId = basicProduct.getId();
        return ResultUtils.success(newProductId);
    }

    /**
     * 删除产品
     *
     * @param
     * @return
     */
    @DeleteMapping("/product/{id}")
    public BaseResponse<String> deleteProduct(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        basicProductService.removeById(id);
        return ResultUtils.success("删除产品成功");
    }

    /**
     * 修改产品
     *
     * @param
     * @return
     */
    @PutMapping("/product")
    public BaseResponse<String> updateProduct(@RequestBody BasicProductSaveRequest basicProductAddRequest) {
        if (basicProductAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProduct basicProduct = new BasicProduct();
        BeanUtils.copyProperties(basicProductAddRequest, basicProduct);
        basicProductService.updateById(basicProduct);
        return ResultUtils.success("修改产品成功");
    }

    /**
     * 查询产品
     *
     * @param
     * @return
     */
    @GetMapping("/product/{id}")
    public BaseResponse<BasicProduct> getProduct(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProduct basicProduct = basicProductService.getById(id);
        return ResultUtils.success(basicProduct);
    }

    /**
     * 查询产品列表
     *
     * @param
     * @return
     */
    @GetMapping("/product")
    public BaseResponse<List<BasicProduct>> getProductList() {
        return ResultUtils.success(basicProductService.list());
    }
}
