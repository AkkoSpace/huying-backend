package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class BasicProductUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
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

}
