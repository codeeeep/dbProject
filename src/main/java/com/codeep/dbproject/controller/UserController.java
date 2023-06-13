package com.codeep.dbProject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codeep.dbProject.common.ErrorCode;
import com.codeep.dbProject.exception.BusinessException;
import com.codeep.dbProject.model.domain.User;
import com.codeep.dbProject.model.domain.request.UserLoginRequest;
import com.codeep.dbProject.model.domain.request.UserRegisterRequest;
import com.codeep.dbProject.service.UserService;
import com.sun.javaws.exceptions.ErrorCodeResponseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.codeep.dbProject.constant.UserConstant.ADMIN_ROLE;
import static com.codeep.dbProject.constant.UserConstant.USER_LOGIN_STATE;

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

    /**
     * 根据学号查成员，支持模糊查找
     * ***** 仅管理员可以查询 *****
     *
     * @param userNo 学号
     * @return 符合条件的模糊成员列表
     */
    @GetMapping("/search")
    public List<User> searchUsers(String userNo, HttpServletRequest request) {
        // 仅管理员可查询
        if (!isAdmin(request)){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(userNo)){
            queryWrapper.like("userNo", userNo);
        }
        return userService.list(queryWrapper);
    }

    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody long id, HttpServletRequest request){
        // 仅管理员可删除
        if (!isAdmin(request)){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        if (id < 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return userService.removeById(id);
    }

    private boolean isAdmin(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLE){
            return false;
        }
        return true;
    }

}
