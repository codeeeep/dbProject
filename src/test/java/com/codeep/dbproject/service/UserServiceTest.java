package com.codeep.dbproject.service;
import java.util.Date;

import com.codeep.dbproject.mapper.UserMapper;
import com.codeep.dbproject.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

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

}