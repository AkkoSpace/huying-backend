package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.BasicWarehouse;
import space.akko.springbootinit.service.BasicWarehouseService;
import space.akko.springbootinit.mapper.BasicWarehouseMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【basic_warehouse(仓库信息表)】的数据库操作Service实现
* @createDate 2024-01-08 10:22:03
*/
@Service
public class BasicWarehouseServiceImpl extends ServiceImpl<BasicWarehouseMapper, BasicWarehouse>
    implements BasicWarehouseService{

}




