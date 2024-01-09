package space.akko.springbootinit.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库信息表
 *
 * @TableName basic_warehouse
 */
@TableName(value = "basic_warehouse")
@Data
public class BasicWarehouse implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
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
