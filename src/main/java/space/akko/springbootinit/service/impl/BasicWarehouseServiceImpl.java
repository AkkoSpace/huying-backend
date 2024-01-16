package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicWarehouseMapper;
import space.akko.springbootinit.model.domain.BasicWarehouse;
import space.akko.springbootinit.model.dto.BasicWarehouseAddRequest;
import space.akko.springbootinit.model.dto.BasicWarehouseUpdateRequest;
import space.akko.springbootinit.service.BasicWarehouseService;

/**
 * @author Administrator
 * @description 针对表【basic_warehouse(仓库信息表)】的数据库操作Service实现
 * @createDate 2024-01-08 10:22:03
 */
@Service
public class BasicWarehouseServiceImpl extends ServiceImpl<BasicWarehouseMapper, BasicWarehouse>
        implements BasicWarehouseService {

    @Override
    public void validAddWarehouse(BasicWarehouseAddRequest basicWarehouseAddRequest) {
        if (basicWarehouseAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        String warehouseName = basicWarehouseAddRequest.getWarehouseName();
        String warehouseAddress = basicWarehouseAddRequest.getWarehouseAddress();
        Integer warehouseStatus = basicWarehouseAddRequest.getWarehouseStatus();

        // 参数非空校验
        if (warehouseName == null || warehouseName.trim().isEmpty() || warehouseAddress == null || warehouseAddress.trim().isEmpty() || warehouseStatus == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }
        // 仓库名称长度不能超过 10
        if (warehouseName.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
        // 仓库地址长度不能超过 50
        if (warehouseAddress.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
        // 仓库状态只能为 0 或 1
        if (warehouseStatus != 0 && warehouseStatus != 1) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
    }

    @Override
    public void validUpdateWarehouse(BasicWarehouseUpdateRequest basicWarehouseUpdateRequest) {
        if (basicWarehouseUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }

        Integer id = basicWarehouseUpdateRequest.getId();
        String warehouseName = basicWarehouseUpdateRequest.getWarehouseName();
        String warehouseAddress = basicWarehouseUpdateRequest.getWarehouseAddress();
        Integer warehouseStatus = basicWarehouseUpdateRequest.getWarehouseStatus();

        // 参数非空校验
        if (id == null || warehouseName == null || warehouseName.trim().isEmpty() || warehouseAddress == null || warehouseAddress.trim().isEmpty() || warehouseStatus == null) {
            throw new BusinessException(ErrorCode.PARAMS_IS_NULL);
        }
        // 仓库名称长度不能超过 10
        if (warehouseName.length() > 10) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
        // 仓库地址长度不能超过 50
        if (warehouseAddress.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }
        // 仓库状态只能为 0 或 1
        if (warehouseStatus != 0 && warehouseStatus != 1) {
            throw new BusinessException(ErrorCode.PARAMS_OUT_OF_RANGE);
        }

    }
}




