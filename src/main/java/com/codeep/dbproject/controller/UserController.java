package com.codeep.dbProject.controller;

import com.codeep.dbProject.model.domain.User;
import com.codeep.dbProject.model.domain.request.UserLoginRequest;
import com.codeep.dbProject.model.domain.request.UserRegisterRequest;
import com.codeep.dbProject.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author codeep
 * @date 2023/6/13 10:28
 * @description: 用户控制器
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Long useRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null){
            return null;
        }
        String username = userRegisterRequest.getUsername();
        String userNo = userRegisterRequest.getUserNo();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(username, userNo, userPassword, checkPassword)){
            return null;
        }
        return userService.userRegister(userNo, username, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null){
            return null;
        }
        String userNo = userLoginRequest.getUserNo();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userNo, userPassword)){
            return null;
        }
        return userService.userLogin(userNo, userPassword, request);
    }

}
