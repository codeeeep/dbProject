package com.codeep.dbProject.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codeep
 * @date 2023/6/13 10:52
 * @description:
 */

@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 6099455373874570961L;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户学号
     */
    private String userNo;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;

}
