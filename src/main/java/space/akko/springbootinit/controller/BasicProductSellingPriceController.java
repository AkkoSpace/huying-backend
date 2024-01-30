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
import space.akko.springbootinit.model.dto.BasicProductSellingPriceAddRequest;
import space.akko.springbootinit.model.dto.BasicProductSellingPriceUpdateRequest;
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
@RequestMapping("/basic/product")
@Slf4j
public class BasicProductSellingPriceController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicProductSellingPriceService basicProductSellingPriceService;

    /**
     * 查询产品列表
     *
     * @return 产品列表
     */
    @GetMapping("/sellingPrice")
    public BaseResponse<List<BasicProductSellingPriceVO>> getProductList() {
        return ResultUtils.success(basicProductSellingPriceService.listDetail());
    }

    /**
     * 新增产品价格
     *
     * @param basicProductSellingPriceAddRequest 产品信息
     * @param request                            请求
     * @return 新增产品 ID
     */
    @PostMapping("/sellingPrice")
    public BaseResponse<Long> addProduct(@RequestBody BasicProductSellingPriceAddRequest basicProductSellingPriceAddRequest, HttpServletRequest request) {
        if (basicProductSellingPriceAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductSellingPrice basicProductSellingPrice = new BasicProductSellingPrice();
        BeanUtils.copyProperties(basicProductSellingPriceAddRequest, basicProductSellingPrice);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductSellingPrice.setUserId(loginUser.getId());
        boolean result = basicProductSellingPriceService.save(basicProductSellingPrice);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long productSellingPriceId = basicProductSellingPrice.getId();
        return ResultUtils.success(productSellingPriceId);
    }

    /**
     * 修改产品
     *
     * @param
     * @return
     */
    @PutMapping("/sellingPrice")
    public BaseResponse<String> updateProduct(@RequestBody BasicProductSellingPriceUpdateRequest basicProductSellingPriceUpdateRequest, HttpServletRequest request) {
        if (basicProductSellingPriceUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicProductSellingPrice basicProductSellingPrice = new BasicProductSellingPrice();
        BeanUtils.copyProperties(basicProductSellingPriceUpdateRequest, basicProductSellingPrice);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicProductSellingPrice.setUserId(loginUser.getId());
        boolean result = basicProductSellingPriceService.updateById(basicProductSellingPrice);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long productSellingPriceId = basicProductSellingPrice.getId();
        return ResultUtils.success("修改产品价格" + productSellingPriceId + "成功");
    }

    /**
     * 删除产品
     *
     * @param id 产品 ID
     * @return 删除结果
     */
    @DeleteMapping("/product/{id}")
    public BaseResponse<String> deleteProduct(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        basicProductSellingPriceService.removeById(id);
        return ResultUtils.success("删除产品成功");
    }


}
