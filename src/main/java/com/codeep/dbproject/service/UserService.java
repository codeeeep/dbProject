package com.codeep.dbproject.service;

import com.codeep.dbproject.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

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


    /**
     * 用户登录
     *
     * @param userNo 学号
     * @param userPassword 密码
     * @param request 用于获取用户登录态的信息
     * @return 脱敏后的用户信息
     */
    User userLogin(String userNo, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser 用户的全部信息
     * @return 脱敏的用户信息
     */
    User getSafetyUser(User originUser);

}
