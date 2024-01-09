package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class BasicProductCategoryAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 产品属性
     */
    private String productAttribute;
    /**
     * 产品类型
     */
    private String productType;

}
