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
 * 产品信息表
 * @TableName basic_product
 */
@TableName(value ="basic_product")
@Data
public class BasicProduct implements Serializable {
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
