package com.codeep.dbproject.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String userNo;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别 -0女 1男 
     */
    private Integer gender;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 所属班级
     */
    private String classNo;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    private Integer userRole;

    /**
     * 是否删除 0 - 正常 1 - 已删除
     */
    @TableLogic
    private Integer idDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}