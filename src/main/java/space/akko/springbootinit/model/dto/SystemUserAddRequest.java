package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class SystemUserAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 账号
     */
    private String userAccount;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户角色: user, admin
     */
    private String userRole;
}