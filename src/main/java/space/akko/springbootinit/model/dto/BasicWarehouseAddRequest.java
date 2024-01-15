package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class BasicWarehouseAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库地址
     */
    private String warehouseAddress;
    /**
     * 仓库状态：0-停用，1-启用
     */
    private Integer warehouseStatus;

}
