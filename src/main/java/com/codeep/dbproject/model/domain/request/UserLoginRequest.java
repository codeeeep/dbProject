package com.codeep.dbProject.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codeep
 * @date 2023/6/13 10:42
 * @description:
 */

@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = 1828718622404231215L;

    /**
     * 用户账号
     */
    private String userNo;

    /**
     * 用户密码
     */
    private String userPassword;

}
