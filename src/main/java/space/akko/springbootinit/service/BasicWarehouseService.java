package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicWarehouse;
import space.akko.springbootinit.model.dto.BasicWarehouseAddRequest;
import space.akko.springbootinit.model.dto.BasicWarehouseUpdateRequest;

/**
 * @author Administrator
 * @description 针对表【basic_warehouse(仓库信息表)】的数据库操作Service
 * @createDate 2024-01-08 10:22:03
 */
public interface BasicWarehouseService extends IService<BasicWarehouse> {

    void validAddWarehouse(BasicWarehouseAddRequest basicWarehouseAddRequest);

    void validUpdateWarehouse(BasicWarehouseUpdateRequest basicWarehouseUpdateRequest);
}
