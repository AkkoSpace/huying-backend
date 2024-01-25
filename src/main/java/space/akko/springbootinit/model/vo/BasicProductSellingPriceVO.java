package space.akko.springbootinit.model.vo;

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
public class BasicProductSellingPriceVO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 品牌 ID
     */
    private Integer brandId;
    /**
     * 分类 ID
     */
    private Integer categoryId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 条形码
     */
    private String barCode;
    /**
     * 产品规格
     */
    private String productSpec;
    /**
     * 产品单位
     */
    private String productUnit;
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
