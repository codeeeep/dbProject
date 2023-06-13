package com.codeep.dbProject.service;
import java.util.Date;

import com.codeep.dbProject.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author codeep
 * @date 2023/6/12 19:19
 * @description:
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUserNo("2110802203");
        user.setUsername("程瑜");
        user.setGender(1);
        user.setUserPassword("123456789");
        user.setClassNo("21108013");
        user.setPhone("13600000000");
        user.setUserRole(0);
        user.setIdDelete(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        boolean save = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(save);
    }

    @Test
    void userRegister() {
        String userNo = "2110801303";
        String username = "程天乐";
        String userPassword = "123456";
        String checkPassword = "";
        // 判空校验
        Long result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 学号长度规范检验
        checkPassword = "123456";
        userNo = "211080220";
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 学号格式特殊字符校验
        userNo = "211080130@";
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 密码长度校验
        userPassword = "12345";
        checkPassword = "12345";
        userNo = "2110801303";
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 密码一致性校验
        userPassword = "123456789";
        checkPassword = "1234567899";
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 学号判重校验
        userNo = "2110802203";
        checkPassword = "123456789";
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        // 成功插入
        userNo = "2110801303";
        // System.out.println(userNo + username + userPassword + checkPassword);
        result = userService.userRegister(userNo, username, userPassword, checkPassword);
        Assertions.assertEquals(2, result);
    }
}