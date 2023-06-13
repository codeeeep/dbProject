package com.codeep.dbproject.constant;

/**
 * @author codeep
 * @date 2023/6/13 10:12
 * @description: 用户常量
 */
public interface UserConstant {

        /**
         * 用户登录态键
         */
        String USER_LOGIN_STATE = "userLoginState";

        //  ------- 权限 --------

        /**
         * 默认权限
         */
        int DEFAULT_ROLE = 0;

        /**
         * 管理员权限
         */
        int ADMIN_ROLE = 1;

}
