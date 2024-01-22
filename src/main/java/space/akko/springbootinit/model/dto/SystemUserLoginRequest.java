package space.akko.springbootinit.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求
 */
@Data
public class SystemUserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}