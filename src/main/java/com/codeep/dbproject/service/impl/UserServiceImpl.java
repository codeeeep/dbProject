package com.codeep.dbproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeep.dbproject.mapper.UserMapper;
import com.codeep.dbproject.model.domain.User;
import com.codeep.dbproject.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author 24796
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-06-12 17:37:24
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




