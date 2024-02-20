package space.akko.springbootinit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.model.domain.BasicWarehouse;
import space.akko.springbootinit.model.domain.SystemUser;
import space.akko.springbootinit.model.dto.BasicWarehouseAddRequest;
import space.akko.springbootinit.model.dto.BasicWarehouseUpdateRequest;
import space.akko.springbootinit.service.BasicWarehouseService;
import space.akko.springbootinit.service.SystemUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 仓库接口
 *
 * @author Akko
 */
@CrossOrigin(origins = {"http://localhost:5173", "https://hy.akko.space"}, maxAge = 3600)
@RestController
@RequestMapping("/basic")
@Slf4j
public class BasicWarehouseController {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BasicWarehouseService basicWarehouseService;

    /**
     * 新增仓库
     *
     * @param basicWarehouseAddRequest 新增仓库请求
     * @param request                  请求
     * @return 新增仓库 ID
     */
    @PostMapping("/warehouse")
    public BaseResponse<Long> addWarehouse(@RequestBody BasicWarehouseAddRequest basicWarehouseAddRequest, HttpServletRequest request) {
        if (basicWarehouseAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicWarehouse basicWarehouse = new BasicWarehouse();
        BeanUtils.copyProperties(basicWarehouseAddRequest, basicWarehouse);
        basicWarehouseService.validAddWarehouse(basicWarehouseAddRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicWarehouse.setUserId(loginUser.getId());
        boolean result = basicWarehouseService.save(basicWarehouse);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newWarehouseId = basicWarehouse.getId();
        return ResultUtils.success(newWarehouseId);
    }

    /**
     * 修改仓库
     *
     * @param basicWarehouseUpdateRequest 修改仓库请求
     * @param request                     请求
     * @return 修改结果
     */
    @PutMapping("/warehouse")
    public BaseResponse<String> updateWarehouse(@RequestBody BasicWarehouseUpdateRequest basicWarehouseUpdateRequest, HttpServletRequest request) {
        if (basicWarehouseUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicWarehouse basicWarehouse = new BasicWarehouse();
        BeanUtils.copyProperties(basicWarehouseUpdateRequest, basicWarehouse);
        basicWarehouseService.validUpdateWarehouse(basicWarehouseUpdateRequest);
        SystemUser loginUser = systemUserService.getLoginUser(request);
        basicWarehouse.setUserId(loginUser.getId());
        boolean result = basicWarehouseService.updateById(basicWarehouse);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long warehouseId = basicWarehouse.getId();
        return ResultUtils.success("修改仓库" + warehouseId + "成功");
    }

    /**
     * 删除仓库
     *
     * @param id 仓库 ID
     * @return 删除结果
     */
    @DeleteMapping("/warehouse/{id}")
    public BaseResponse<String> deleteWarehouse(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        basicWarehouseService.removeById(id);
        return ResultUtils.success("删除仓库成功");
    }

    /**
     * 获取仓库列表
     *
     * @return 仓库列表
     */
    @GetMapping("/warehouse")
    public BaseResponse<List<BasicWarehouse>> getWarehouseList() {
        return ResultUtils.success(basicWarehouseService.list());
    }

    /**
     * 获取仓库详情
     *
     * @param id 仓库 ID
     * @return 仓库详情
     */
    @GetMapping("/warehouse/{id}")
    public BaseResponse<BasicWarehouse> getWarehouseDetail(@PathVariable Integer id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BasicWarehouse basicWarehouse = basicWarehouseService.getById(id);
        return ResultUtils.success(basicWarehouse);
    }
}
