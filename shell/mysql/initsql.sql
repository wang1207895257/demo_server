create table sys_user
(
    id varchar(32) not null comment 'id',
    user_name varchar(32) not null comment '用户名',
    identity_code varchar(32) comment '编号',
    identity_code_type varchar(32) comment '编号类型',
    create_time Date comment '创建时间',
    update_time Date comment '更新时间',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';