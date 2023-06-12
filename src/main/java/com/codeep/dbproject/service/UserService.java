package com.codeep.dbproject.service;

import com.codeep.dbproject.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 24796
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-06-12 17:37:24
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userNo 学号
     * @param username 姓名
     * @param userPassword  密码
     * @param checkPassword 确认密码
     * @return 新用户id
     */
    long userRegister(String userNo, String username, String userPassword, String checkPassword);

}
