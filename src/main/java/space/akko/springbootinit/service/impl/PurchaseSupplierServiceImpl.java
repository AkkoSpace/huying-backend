package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.PurchaseSupplier;
import space.akko.springbootinit.service.PurchaseSupplierService;
import space.akko.springbootinit.mapper.PurchaseSupplierMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【purchase_supplier(供应商信息表)】的数据库操作Service实现
* @createDate 2024-01-08 10:22:03
*/
@Service
public class PurchaseSupplierServiceImpl extends ServiceImpl<PurchaseSupplierMapper, PurchaseSupplier>
    implements PurchaseSupplierService{

}




