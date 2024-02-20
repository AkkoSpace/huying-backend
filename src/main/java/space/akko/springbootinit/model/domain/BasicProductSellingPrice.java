package space.akko.springbootinit.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品销售价格表
 *
 * @TableName basic_product_selling_price
 */
@TableName(value = "basic_product_selling_price")
@Data
public class BasicProductSellingPrice implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 产品 ID
     */
    private Integer productId;
    /**
     * 供应商 ID
     */
    private Integer supplierId;
    /**
     * 进货单价
     */
    private BigDecimal purchasePrice;
    /**
     * 销售单价
     */
    private BigDecimal sellingPrice;
    /**
     * 产品利润
     */
    private BigDecimal productProfit;
    /**
     * 价格等级：0-特价，1-一级，2-二级，3-三级
     */
    private Integer priceLevel;
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
