package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import space.akko.springbootinit.model.domain.PurchaseSupplierPrice;
import space.akko.springbootinit.service.PurchaseSupplierPriceService;
import space.akko.springbootinit.mapper.PurchaseSupplierPriceMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【purchase_supplier_price(供应商价格表)】的数据库操作Service实现
* @createDate 2024-01-08 10:22:03
*/
@Service
public class PurchaseSupplierPriceServiceImpl extends ServiceImpl<PurchaseSupplierPriceMapper, PurchaseSupplierPrice>
    implements PurchaseSupplierPriceService{

}




