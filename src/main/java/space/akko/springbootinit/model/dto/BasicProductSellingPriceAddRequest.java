package space.akko.springbootinit.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户创建请求
 */
@Data
public class BasicProductSellingPriceAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 产品 ID
     */
    @NotBlank(message = "产品 ID不能为空")
    private Integer productId;
    /**
     * 进货单价
     */
    @NotBlank(message = "进货单价不能为空")
    private BigDecimal purchasePrice;
    /**
     * 标准单价
     */
    @NotBlank(message = "标准单价不能为空")
    private BigDecimal standardPrice;
    /**
     * 销售单价
     */
    @NotBlank(message = "销售单价不能为空")
    private BigDecimal sellingPrice;
    /**
     * 产品利润
     */
    @NotBlank(message = "产品利润不能为空")
    private BigDecimal productProfit;
    /**
     * 价格等级：0-特价，1-一级，2-二级，3-三级
     */
    @NotBlank(message = "价格等级不能为空")
    private Integer priceLevel;

}
