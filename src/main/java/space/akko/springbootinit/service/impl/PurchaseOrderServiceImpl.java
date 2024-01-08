package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.PurchaseOrder;
import space.akko.springbootinit.service.PurchaseOrderService;
import space.akko.springbootinit.mapper.PurchaseOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【purchase_order(采购订单表)】的数据库操作Service实现
* @createDate 2024-01-08 10:22:03
*/
@Service
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder>
    implements PurchaseOrderService{

}




