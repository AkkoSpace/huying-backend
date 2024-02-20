package space.akko.springbootinit.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品信息表
 *
 * @TableName basic_product
 */
@TableName(value = "basic_product")
@Data
public class BasicProduct implements Serializable {
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
