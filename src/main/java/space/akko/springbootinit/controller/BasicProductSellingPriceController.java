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
import space.akko.springbootinit.model.domain.BasicProductSellingPrice;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.BasicProductAddRequest;
import space.akko.springbootinit.model.dto.BasicProductUpdateRequest;
import space.akko.springbootinit.model.vo.BasicProductSellingPriceVO;
import space.akko.springbootinit.service.BasicProductSellingPriceService;
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
public class BasicProductSellingPriceController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicProductSellingPriceService basicProductSellingPriceService;

//    /**
//     * 新增产品价格
//     *
//     * @param basicProductSellingPriceAddRequest 产品信息
//     * @param request                请求
//     * @return 新增产品 ID
//     */
//    @PostMapping("/price")
//    public BaseResponse<Long> addProduct(@RequestBody BasicProductAddRequest basicProductSellingPriceAddRequest, HttpServletRequest request) {
//        if (basicProductSellingPriceAddRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        BasicProduct basicProduct = new BasicProduct();
//        BeanUtils.copyProperties(basicProductSellingPriceAddRequest, basicProduct);
//        basicProductService.validAddProduct(basicProductAddRequest);
//        SystemUser loginUser = systemUserService.getLoginUser(request);
//        basicProduct.setUserId(loginUser.getId());
//        boolean result = basicProductService.save(basicProduct);
//        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
//        long newProductId = basicProduct.getId();
//        return ResultUtils.success(newProductId);
//    }
//
//    /**
//     * 删除产品
//     *
//     * @param id 产品 ID
//     * @return 删除结果
//     */
//    @DeleteMapping("/product/{id}")
//    public BaseResponse<String> deleteProduct(@PathVariable Integer id) {
//        if (id == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        basicProductService.removeById(id);
//        return ResultUtils.success("删除产品成功");
//    }
//
//    /**
//     * 修改产品
//     *
//     * @param
//     * @return
//     */
//    @PutMapping("/product")
//    public BaseResponse<String> updateProduct(@RequestBody BasicProductUpdateRequest basicProductUpdateRequest, HttpServletRequest request) {
//        if (basicProductUpdateRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        BasicProduct basicProduct = new BasicProduct();
//        BeanUtils.copyProperties(basicProductUpdateRequest, basicProduct);
//        basicProductService.validUpdateProduct(basicProductUpdateRequest);
//        SystemUser loginUser = systemUserService.getLoginUser(request);
//        basicProduct.setUserId(loginUser.getId());
//        boolean result = basicProductService.updateById(basicProduct);
//        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
//        long productId = basicProduct.getId();
//        return ResultUtils.success("修改产品" + productId + "成功");
//    }
//
//    /**
//     * 查询产品列表
//     *
//     * @return 产品列表
//     */
//    @GetMapping("/product")
//    public BaseResponse<List<BasicProduct>> getProductList() {
//        return ResultUtils.success(basicProductService.list());
//    }

//    /**
//     * 查询产品
//     *
//     * @param id 产品 ID
//     * @return 产品
//     */
//    @GetMapping("/product/{id}")
//    public BaseResponse<BasicProduct> getProductDetail(@PathVariable Integer id) {
//        if (id == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        BasicProduct basicProduct = basicProductService.getById(id);
//        return ResultUtils.success(basicProduct);
//    }
//
//    /**
//     * 根据产品名称查询
//     *
//     * @param productName 产品名称
//     */
//    @GetMapping("/product/search")
//    public BaseResponse<List<BasicProduct>> searchProduct(@RequestParam String productName) {
//        if (productName == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        List<BasicProduct> basicProductList = basicProductService.searchProduct(productName);
//        return ResultUtils.success(basicProductList);
//    }

        /**
         * 查询产品列表
         *
         * @return 产品列表
         */
        @GetMapping("/sellingPrice")
        public BaseResponse<List<BasicProductSellingPriceVO>> getProductList() {
            return ResultUtils.success(basicProductSellingPriceService.listDetail());
        }

}
