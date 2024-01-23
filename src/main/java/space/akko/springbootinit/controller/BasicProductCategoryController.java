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
import space.akko.springbootinit.model.domain.BasicProductCategory;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.BasicProductCategoryAddRequest;
import space.akko.springbootinit.model.dto.BasicProductCategoryUpdateRequest;
import space.akko.springbootinit.service.BasicProductCategoryService;
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
public class BasicProductCategoryController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicProductCategoryService basicProductCategoryService;

    /**
     * 新增产品分类
     *
     * @param basicProductCategoryAddRequest 新增产品分类请求
     * @param request                        请求
     * @return 新增产品分类 ID
     */
    @PostMapping("/productCategory")
    public BaseResponse<Long> addProductCategory(@RequestBody BasicProductCategoryAddRequest basicProductCategoryAddRequest, HttpServletRequest request) {
        if (basicProductCategoryAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductCategory basicProductCategory = new BasicProductCategory();
        BeanUtils.copyProperties(basicProductCategoryAddRequest, basicProductCategory);
        basicProductCategoryService.validAddProductCategory(basicProductCategoryAddRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductCategory.setUserId(loginUser.getId());
        boolean result = basicProductCategoryService.save(basicProductCategory);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newProductCategoryId = basicProductCategory.getId();
        return ResultUtils.success(newProductCategoryId);
    }

    /**
     * 删除产品品牌
     *
     * @param id 产品品牌 ID
     * @return 删除结果
     */
    @DeleteMapping("/productCategory/{id}")
    public BaseResponse<String> deleteProductCategory(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        basicProductCategoryService.removeById(id);
        return ResultUtils.success("删除产品分类成功");
    }

    /**
     * 修改产品品牌
     *
     * @param basicProductCategoryUpdateRequest 修改产品品牌请求
     * @param request                           请求
     * @return 修改结果
     */
    @PutMapping("/productCategory")
    public BaseResponse<String> updateProductCategory(@RequestBody BasicProductCategoryUpdateRequest basicProductCategoryUpdateRequest, HttpServletRequest request) {
        if (basicProductCategoryUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductCategory basicProductCategory = new BasicProductCategory();
        BeanUtils.copyProperties(basicProductCategoryUpdateRequest, basicProductCategory);
        basicProductCategoryService.validUpdateProductCategory(basicProductCategoryUpdateRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductCategory.setUserId(loginUser.getId());
        boolean result = basicProductCategoryService.updateById(basicProductCategory);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long productCategoryId = basicProductCategory.getId();
        return ResultUtils.success("修改产品分类" + productCategoryId + "成功");
    }

    /**
     * 获取产品品牌列表
     *
     * @return 产品品牌列表
     */
    @GetMapping("/productCategory")
    public BaseResponse<List<BasicProductCategory>> getProductCategoryList() {
        return ResultUtils.success(basicProductCategoryService.list());
    }

    /**
     * 获取产品品牌详情
     *
     * @param id 产品品牌 ID
     * @return 产品品牌详情
     */
    @GetMapping("/productCategory/{id}")
    public BaseResponse<BasicProductCategory> getProductCategoryDetail(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductCategory basicProductCategory = basicProductCategoryService.getById(id);
        return ResultUtils.success(basicProductCategory);
    }

    /**
     * 根据产品属性或类型查询
     *
     * @param value 产品属性或类型
     */
    @GetMapping("/productCategory/search")
    public BaseResponse<List<BasicProductCategory>> searchProductCategory(@RequestParam String value) {
        if (value == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<BasicProductCategory> basicProductCategoryList = basicProductCategoryService.searchProductCategory(value);
        return ResultUtils.success(basicProductCategoryList);
    }
}
