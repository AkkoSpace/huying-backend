package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.exception.ThrowUtils;
import space.akko.springbootinit.mapper.TransactionMapper;
import space.akko.springbootinit.model.entity.Transaction;
import space.akko.springbootinit.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Administrator
 * @description 针对表【transaction(交易)】的数据库操作Service实现
 * @createDate 2023-12-29 16:39:05
 */
@Service
public class TransactionServiceImpl extends ServiceImpl<TransactionMapper, Transaction>
        implements TransactionService {

    @Override
    public void validTransaction(Transaction transaction, boolean add) {

        if (transaction == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        LocalDate transactionDate = transaction.getTransactionDate();
        String transactionOrder = transaction.getTransactionOrder();
        BigDecimal amount = transaction.getAmount();
        String description = transaction.getDescription();

        // 创建时，参数不能为空
        if (add) {
            // 判断交易单号是否为空
            ThrowUtils.throwIf(StringUtils.isAnyBlank(transactionOrder), ErrorCode.PARAMS_ERROR);
            // 判断交易日期是否为空
            ThrowUtils.throwIf(transactionDate == null, ErrorCode.PARAMS_ERROR);
            // 判断交易金额是否为空
            ThrowUtils.throwIf(amount == null, ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        // 判断交易单号是否过长，最大长度为20
        if (StringUtils.isNotBlank(transactionOrder) && transactionOrder.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "交易单号过长");
        }
        // 判断交易金额是否合理
        if (amount != null && amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "交易金额不能为负数");
        }
        // 描述不能过长，最大长度为100
        if (StringUtils.isNotBlank(description) && description.length() > 100) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "描述过长");
        }
    }
}
