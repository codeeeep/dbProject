package com.codeep.dbproject.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 成绩表
 * @TableName grade
 */
@TableName(value ="grade")
@Data
public class Grade implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学号
     */
    private String userNo;

    /**
     * 课程编号
     */
    private String lessonNo;

    /**
     * 学科
     */
    private String subject;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 实习评级
     */
    private String grade;

    /**
     * 学分
     */
    private Double gpa;

    /**
     * 学期
     */
    private Integer term;

    /**
     * 是否删除 0 - 正常 1 - 已被删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}