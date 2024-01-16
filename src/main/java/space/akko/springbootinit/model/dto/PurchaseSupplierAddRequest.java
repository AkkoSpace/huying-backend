package space.akko.springbootinit.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class PurchaseSupplierAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 供应商名称
     */
    @NotBlank(message = "供应商名称不能为空")
    @Length(max = 10, message = "供应商名称长度不能超过 10 个字符")
    private String supplierName;
    /**
     * 供应商地址
     */
    @NotBlank(message = "供应商地址不能为空")
    @Length(max = 50, message = "供应商地址长度不能超过 50 个字符")
    private String supplierAddress;

}
