package space.akko.springbootinit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.DeleteRequest;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;
import space.akko.springbootinit.constant.CommonConstant;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.model.dto.products.ProductsAddRequest;
import space.akko.springbootinit.model.dto.products.ProductsQueryRequest;
import space.akko.springbootinit.model.dto.products.ProductsUpdateRequest;
import space.akko.springbootinit.model.entity.Products;
import space.akko.springbootinit.model.entity.User;
import space.akko.springbootinit.service.ProductsService;
import space.akko.springbootinit.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 产品接口
 *
 * @author Akko
 * @date 2023/12/27
 */
@CrossOrigin(origins = {"http://localhost:5173", "https://hy.akko.space"}, maxAge = 3600)
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @Resource
    private UserService userService;

    // 增删改查

    /**
     * 创建
     *
     * @param productsAddRequest 新增参数
     * @param request            请求
     * @return 新增的产品 id
     */
    @PostMapping("/add")
    public BaseResponse<Long> addProducts(@RequestBody ProductsAddRequest productsAddRequest, HttpServletRequest request) {
        if (productsAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }
        Products products = new Products();
        BeanUtils.copyProperties(productsAddRequest, products);
        productsService.validProducts(products, true);
        User loginUser = userService.getLoginUser(request);
        products.setUserId(loginUser.getId());
        boolean result = productsService.save(products);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newProductsId = products.getId();
        return ResultUtils.success(newProductsId);
    }

    /**
     * 删除
     *
     * @param deleteRequest 删除参数
     * @param request       请求
     * @return 是否删除成功
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteProducts(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        Products oldProducts = productsService.getById(id);
        ThrowUtils.throwIf(oldProducts == null, ErrorCode.NOT_FOUND_ERROR);
        // 仅本人或管理员可删除
        if (!oldProducts.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_PERMISSION_ERROR);
        }
        boolean b = productsService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新
     *
     * @param productsUpdateRequest 更新参数
     * @return 是否更新成功
     */
    @PostMapping("/update")
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateProducts(@RequestBody ProductsUpdateRequest productsUpdateRequest) {
        if (productsUpdateRequest == null || productsUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Products products = new Products();
        BeanUtils.copyProperties(productsUpdateRequest, products);
        // 参数校验
        productsService.validProducts(products, false);
        long id = productsUpdateRequest.getId();
        // 判断是否存在
        Products oldProducts = productsService.getById(id);
        ThrowUtils.throwIf(oldProducts == null, ErrorCode.NOT_FOUND_ERROR);
        boolean result = productsService.updateById(products);
        return ResultUtils.success(result);
    }

    /**
     * 分页获取列表
     *
     * @param productsQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    public BaseResponse<Page<Products>> listProductsByPage(ProductsQueryRequest productsQueryRequest, HttpServletRequest request) {
        if (productsQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }
        Products productsQuery = new Products();
        BeanUtils.copyProperties(productsQueryRequest, productsQuery);
        long current = productsQueryRequest.getCurrent();
        long size = productsQueryRequest.getPageSize();
        String sortField = productsQueryRequest.getSortField();
        String sortOrder = productsQueryRequest.getSortOrder();
        String brand = productsQuery.getBrand();
        String productName = productsQuery.getProductName();
        // brand, productName 支持模糊搜索
        productsQuery.setBrand(null);
        productsQuery.setProductName(null);
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
        QueryWrapper<Products> queryWrapper = new QueryWrapper<>(productsQuery);
        queryWrapper.like(StringUtils.isNotBlank(brand), "brand", brand);
        queryWrapper.like(StringUtils.isNotBlank(productName), "productName", productName);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<Products> productsPage = productsService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(productsPage);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<Products> getProductsById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Products products = productsService.getById(id);
        if (products == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(products);
    }

}
