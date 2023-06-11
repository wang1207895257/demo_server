package com.example.model;

import lombok.Data;

// create table `sys_user`
// (
//     `id`                 varchar(36)  NOT NULL,
//     `user_name`          varchar(100) NOT NULL COMMENT '用户名',
//     `identity_code`      varchar(100) DEFAULT NULL COMMENT '身份编码',
//     `identity_code_type` int(1)       DEFAULT NULL COMMENT '身份编码类型',
//     `create_time`        datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//     `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
//     PRIMARY KEY (`id`)
@Data
public class SysUser {

}
