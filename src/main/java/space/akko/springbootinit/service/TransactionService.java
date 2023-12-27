package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.entity.Transaction;

/**
 * @author Administrator
 * @description 针对表【transaction(交易)】的数据库操作Service
 * @createDate 2023-12-26 17:21:47
 */
public interface TransactionService extends IService<Transaction> {

    /**
     * 校验
     *
     * @param transaction 交易
     * @param add         新增
     */
    void validTransaction(Transaction transaction, boolean add);

}
