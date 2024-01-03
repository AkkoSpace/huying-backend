package space.akko.springbootinit.model.dto.products;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建请求
 */
@Data
public class ProductsUpdateRequest implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 生产日期
     */
    private Date productDate;
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
     * 产品单价
     */
    private BigDecimal unitPrice;
    /**
     * 操作用户 ID
     */
    private Long userId;

}
