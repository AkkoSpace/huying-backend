package space.akko.springbootinit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.model.domain.BasicProductBrand;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.BasicProductBrandAddRequest;
import space.akko.springbootinit.model.dto.BasicProductBrandUpdateRequest;
import space.akko.springbootinit.service.BasicProductBrandService;
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
public class BasicProductBrandController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicProductBrandService basicProductBrandService;

    /**
     * 新增产品品牌
     *
     * @param basicProductBrandAddRequest 新增产品品牌请求
     * @param request                     请求
     * @return 新增产品品牌 ID
     */
    @PostMapping("/productBrand")
    public BaseResponse<Long> addProductBrand(@RequestBody BasicProductBrandAddRequest basicProductBrandAddRequest, HttpServletRequest request) {
        if (basicProductBrandAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductBrand basicProductBrand = new BasicProductBrand();
        BeanUtils.copyProperties(basicProductBrandAddRequest, basicProductBrand);
        basicProductBrandService.validAddProductBrand(basicProductBrandAddRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductBrand.setUserId(loginUser.getId());
        boolean result = basicProductBrandService.save(basicProductBrand);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newProductBrandId = basicProductBrand.getId();
        return ResultUtils.success(newProductBrandId);
    }

    /**
     * 删除产品品牌
     *
     * @param id 产品品牌 ID
     * @return 删除结果
     */
    @DeleteMapping("/productBrand/{id}")
    public BaseResponse<String> deleteProductBrand(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        basicProductBrandService.removeById(id);
        return ResultUtils.success("删除产品品牌成功");
    }

    /**
     * 修改产品品牌
     *
     * @param basicProductBrandUpdateRequest 修改产品品牌请求
     * @param request                        请求
     * @return 修改结果
     */
    @PutMapping("/productBrand")
    public BaseResponse<String> updateProductBrand(@RequestBody BasicProductBrandUpdateRequest basicProductBrandUpdateRequest, HttpServletRequest request) {
        if (basicProductBrandUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductBrand basicProductBrand = new BasicProductBrand();
        BeanUtils.copyProperties(basicProductBrandUpdateRequest, basicProductBrand);
        basicProductBrandService.validUpdateProductBrand(basicProductBrandUpdateRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductBrand.setUserId(loginUser.getId());
        boolean result = basicProductBrandService.updateById(basicProductBrand);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long productBrandId = basicProductBrand.getId();
        return ResultUtils.success("修改产品品牌" + productBrandId + "成功");
    }

    /**
     * 获取产品品牌列表
     *
     * @return 产品品牌列表
     */
    @GetMapping("/productBrand")
    public BaseResponse<List<BasicProductBrand>> getProductBrandList() {
        return ResultUtils.success(basicProductBrandService.list());
    }

    /**
     * 获取产品品牌详情
     *
     * @param id 产品品牌 ID
     * @return 产品品牌详情
     */
    @GetMapping("/productBrand/{id}")
    public BaseResponse<BasicProductBrand> getProductBrandDetail(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductBrand basicProductBrand = basicProductBrandService.getById(id);
        return ResultUtils.success(basicProductBrand);
    }
}
