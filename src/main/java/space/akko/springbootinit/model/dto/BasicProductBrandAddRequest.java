package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class BasicProductBrandAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 品牌名称
     */
    private String brandName;

}
