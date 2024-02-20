package space.akko.springbootinit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.model.domain.PurchaseSupplier;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.PurchaseSupplierAddRequest;
import space.akko.springbootinit.model.dto.PurchaseSupplierUpdateRequest;
import space.akko.springbootinit.service.PurchaseSupplierService;
import space.akko.springbootinit.service.SystemUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 供应商接口
 *
 * @author Akko
 */
@CrossOrigin(origins = {"http://localhost:5173", "https://hy.akko.space"}, maxAge = 3600)
@RestController
@RequestMapping("/purchase")
@Slf4j
public class PurchaseSupplierController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private PurchaseSupplierService purchaseSupplierService;

    /**
     * 新增供应商
     *
     * @param purchaseSupplierAddRequest 新增供应商请求
     * @param request                    请求
     * @return 新增供应商 ID
     */
    @PostMapping("/supplier")
    public BaseResponse<Long> addWarehouse(@Validated @RequestBody PurchaseSupplierAddRequest purchaseSupplierAddRequest, HttpServletRequest request) {
        if (purchaseSupplierAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        PurchaseSupplier purchaseSupplier = new PurchaseSupplier();
        BeanUtils.copyProperties(purchaseSupplierAddRequest, purchaseSupplier);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        purchaseSupplier.setUserId(loginUser.getId());
        boolean result = purchaseSupplierService.save(purchaseSupplier);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newWarehouseId = purchaseSupplier.getId();
        return ResultUtils.success(newWarehouseId);
    }

    /**
     * 修改供应商
     *
     * @param purchaseSupplierUpdateRequest 修改供应商请求
     * @param request                       请求
     * @return 修改结果
     */
    @PutMapping("/supplier")
    public BaseResponse<String> updateWarehouse(@Validated @RequestBody PurchaseSupplierUpdateRequest purchaseSupplierUpdateRequest, HttpServletRequest request) {
        if (purchaseSupplierUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        PurchaseSupplier purchaseSupplier = new PurchaseSupplier();
        BeanUtils.copyProperties(purchaseSupplierUpdateRequest, purchaseSupplier);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        purchaseSupplier.setUserId(loginUser.getId());
        boolean result = purchaseSupplierService.updateById(purchaseSupplier);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long supplierId = purchaseSupplier.getId();
        return ResultUtils.success("修改供应商" + supplierId + "成功");
    }


    /**
     * 删除供应商
     *
     * @param id 供应商 ID
     * @return 删除结果
     */
    @DeleteMapping("/supplier/{id}")
    public BaseResponse<String> deleteWarehouse(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        purchaseSupplierService.removeById(id);
        return ResultUtils.success("删除供应商成功");
    }

    /**
     * 获取供应商列表
     *
     * @return 供应商列表
     */
    @GetMapping("/supplier")
    public BaseResponse<List<PurchaseSupplier>> getWarehouseList() {
        return ResultUtils.success(purchaseSupplierService.list());
    }

    /**
     * 获取供应商详情
     *
     * @param id 供应商 ID
     * @return 供应商详情
     */
    @GetMapping("/supplier/{id}")
    public BaseResponse<PurchaseSupplier> getWarehouseDetail(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        PurchaseSupplier purchaseSupplier = purchaseSupplierService.getById(id);
        return ResultUtils.success(purchaseSupplier);
    }
}
