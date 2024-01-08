package space.akko.springbootinit.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购订单详情表
 *
 * @TableName purchase_order_detail
 */
@TableName(value = "purchase_order_detail")
@Data
public class PurchaseOrderDetail implements Serializable {
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
    private Integer orderId;
    /**
     * 产品 ID
     */
    private Integer productId;
    /**
     * 进货单价
     */
    private BigDecimal purchasePrice;
    /**
     * 进货数量
     */
    private Integer purchaseCount;
    /**
     * 进货总价
     */
    private BigDecimal purchaseTotal;
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
    private Integer isDelete;
}
