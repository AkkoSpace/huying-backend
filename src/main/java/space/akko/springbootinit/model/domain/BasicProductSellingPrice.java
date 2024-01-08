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
 * 产品销售价格表
 * @TableName basic_product_selling_price
 */
@TableName(value ="basic_product_selling_price")
@Data
public class BasicProductSellingPrice implements Serializable {
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
     * 进货单价
     */
    private BigDecimal purchasePrice;

    /**
     * 标准单价
     */
    private BigDecimal standardPrice;

    /**
     * 销售单价
     */
    private BigDecimal sellingPrice;

    /**
     * 产品利润
     */
    private BigDecimal productProfit;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
