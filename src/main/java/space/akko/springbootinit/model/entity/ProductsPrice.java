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
 * @TableName products_price
 */
@TableName(value = "products_price")
@Data
public class ProductsPrice implements Serializable {
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
     * 价格
     */
    private BigDecimal price;
    /**
     * 价格日期
     */
    private LocalDate priceDate;
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
