package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.PurchaseOrderDetail;
import space.akko.springbootinit.service.PurchaseOrderDetailService;
import space.akko.springbootinit.mapper.PurchaseOrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【purchase_order_detail(采购订单详情表)】的数据库操作Service实现
* @createDate 2024-01-08 10:22:03
*/
@Service
public class PurchaseOrderDetailServiceImpl extends ServiceImpl<PurchaseOrderDetailMapper, PurchaseOrderDetail>
    implements PurchaseOrderDetailService{

}




