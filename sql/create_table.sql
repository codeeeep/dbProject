-- @author codeep
-- 数据库初始化

-- 用户表
-- auto-generated definition
create table user
(
    id           bigint auto_increment comment 'id'
        primary key,
    userNo       varchar(256)                       not null comment '账号',
    username     varchar(256)                       not null comment '姓名',
    gender       tinyint                            null comment '性别 -0女 1男 ',
    userPassword varchar(512)                       not null comment '密码',
    classNo        varchar(256)                       null comment '所属班级',
    phone        varchar(128)                       null comment '手机号',
    userRole     int      default 0                 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    idDelete     tinyint  default 0                 null comment '是否删除 0 - 正常 1 - 已删除',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint user_userNo_uindex
        unique (userNo)
)
    comment '用户表';

-- 成绩表
-- auto-generated definition
create table grade
(
    id       bigint auto_increment comment 'id'
        primary key,
    userNo   varchar(256)      null comment '学号',
    lessonNo varchar(256)      null comment '课程编号',
    subject  varchar(256)      null comment '学科',
    score    int               null comment '分数',
    grade    varchar(16)       null comment '实习评级',
    gpa      double            null comment '学分',
    term     tinyint           null comment '学期',
    isDelete tinyint default 0 not null comment '是否删除 0 - 正常 1 - 已被删除'
)
    comment '成绩表';

