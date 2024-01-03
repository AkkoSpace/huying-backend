package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.TransactionProductsMapper;
import space.akko.springbootinit.model.entity.TransactionProducts;
import space.akko.springbootinit.service.TransactionProductsService;

/**
 * @author Administrator
 * @description 针对表【transaction_products(订单产品)】的数据库操作Service实现
 * @createDate 2023-12-29 16:39:13
 */
@Service
public class TransactionProductsServiceImpl extends ServiceImpl<TransactionProductsMapper, TransactionProducts>
        implements TransactionProductsService {

}




