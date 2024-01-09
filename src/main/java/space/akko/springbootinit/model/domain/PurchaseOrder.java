package space.akko.springbootinit.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购订单表
 *
 * @TableName purchase_order
 */
@TableName(value = "purchase_order")
@Data
public class PurchaseOrder implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 订单 ID
     */
    private String orderId;
    /**
     * 供应商 ID
     */
    private Integer supplierId;
    /**
     * 仓库 ID
     */
    private Integer warehouseId;
    /**
     * 订单状态：0-已取消，1-待入库，2-已入库
     */
    private Integer orderStatus;
    /**
     * 订单日期
     */
    private Date orderDate;
    /**
     * 订单总价
     */
    private BigDecimal orderTotal;
    /**
     * 订单备注
     */
    private String orderRemark;
    /**
     * 操作用户 ID
     */
    private Long userId;
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
    @TableLogic
    private Integer isDelete;
}
