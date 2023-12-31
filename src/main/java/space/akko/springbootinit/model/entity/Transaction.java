package space.akko.springbootinit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 交易
 *
 * @TableName transaction
 */
@TableName(value = "transaction")
@Data
public class Transaction implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 交易订单
     */
    private String transactionOrder;
    /**
     * 交易日期
     */
    private LocalDate transactionDate;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 订单 ID
     */
    private String orderId;
    /**
     * 描述
     */
    private String description;
    /**
     * 操作用户 ID
     */
    private Long userId;
    /**
     * 交易状态：0-未付款，1-已付款，2-已取消，3-已退款
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDelete;
}
