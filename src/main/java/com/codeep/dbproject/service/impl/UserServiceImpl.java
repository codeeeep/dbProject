package com.codeep.dbproject.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeep.dbproject.common.ErrorCode;
import com.codeep.dbproject.exception.BusinessException;
import com.codeep.dbproject.mapper.UserMapper;
import com.codeep.dbproject.model.domain.User;
import com.codeep.dbproject.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author 24796
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-06-12 17:37:24
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 盐值，用于混淆密码
     */
    private static final String SALT = "NJFU";


    @Override
    public long userRegister(String userNo, String username, String userPassword, String checkPassword) {
        // 1. 校验
        // 判空
        if (StringUtils.isAnyBlank(userNo, username, userPassword, checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        if (userNo.length() != 10){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "学号格式错误");
        }
        if (userPassword.length() < 6 || checkPassword.length() < 6){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码长度过短");
        }
        // 学号不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userNo);
        if (matcher.find()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "学号违法");
        }
        // 密码和校验密码一致
        if (userPassword != checkPassword){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次密码不一致");
        }
        // 学号不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userNo", userNo);
        Long count = userMapper.selectCount(queryWrapper);
        if (count > 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "学号已被注册");
        }

        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

        // 3. 插入数据
        User user = new User();
        user.setUserNo(userNo);
        user.setUsername(username);
        user.setUserPassword(encryptPassword);
        boolean saveResult = this.save(user);
        if (!saveResult){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "注册失败");
        }
        return user.getId();

    }
}




