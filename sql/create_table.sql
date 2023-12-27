-- 建表脚本

-- 创建库
create database if not exists huying;

-- 切换库
use huying;

-- 用户表
create table user
(
    id           bigint auto_increment comment '用户 ID'
        primary key,
    userAccount  varchar(32)                                                   not null comment '账号',
    userPassword varchar(512)                                                  not null comment '密码',
    uid          varchar(256)                                                  null comment 'UID',
    userName     varchar(32)                                                   null comment '用户昵称',
    userAvatar   varchar(1024) default 'https://akko.space/upload/default.png' null comment '用户头像',
    userProfile  varchar(512)                                                  null comment '用户简介',
    userRole     varchar(256)  default 'user'                                  not null comment '用户角色：user/admin/ban',
    createTime   datetime      default CURRENT_TIMESTAMP                       not null comment '创建时间',
    updateTime   datetime      default CURRENT_TIMESTAMP                       not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint       default 0                                       not null comment '是否删除'
)
    comment '用户' collate = utf8mb4_unicode_ci;

create index idx_uid
    on user (uid);

-- 交易表
create table transaction
(
    id               int auto_increment comment '自增主键'
        primary key,
    transactionOrder varchar(255)                       not null comment '交易 ID',
    transactionDate  date                               not null comment '交易日期',
    amount           decimal(10, 2)                     not null comment '交易金额',
    orderId          varchar(255)                       null comment '订单 ID',
    description      varchar(255)                       null comment '描述',
    userId           bigint                             not null comment '操作用户 ID',
    status           tinyint  default 0                 not null comment '交易状态：0-未付款，1-已付款，2-已取消，3-已退款',
    createTime       datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime       datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete         tinyint  default 0                 not null comment '是否删除'
)
    comment '交易' collate = utf8mb4_unicode_ci;

-- 产品表
create table products
(
    id          int auto_increment comment '自增主键'
        primary key,
    brand       varchar(255)                       null comment '品牌',
    productName varchar(255)                       not null comment '产品名称',
    productDate date                               null comment '生产日期',
    barCode     varchar(255)                       null comment '条形码',
    productSpec varchar(255)                       not null comment '产品规格',
    productUnit varchar(255)                       not null comment '产品单位',
    unitPrice   decimal(10, 2)                     not null comment '产品单价',
    userId      bigint                             not null comment '操作用户 ID',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '是否删除'
)
    comment '产品' collate = utf8mb4_unicode_ci;

-- 订单表
create table transaction_products
(
    id            int auto_increment comment '自增主键'
        primary key,
    transactionId varchar(255)                       not null comment '交易 ID',
    products      json                               not null comment '订单产品',
    userId        bigint                             not null comment '操作用户 ID',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除'
)
    comment '订单产品' collate = utf8mb4_unicode_ci;

-- 公司表
create table companies
(
    id             int auto_increment comment '自增主键'
        primary key,
    companyName    varchar(255)                       not null comment '公司名称',
    companyAddress varchar(255)                       null comment '公司地址',
    contactPhone   varchar(20)                        null comment '联系电话',
    contactEmail   varchar(255)                       null comment '联系邮箱',
    userId         bigint                             not null comment '操作用户 id',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
)
    comment '公司' collate = utf8mb4_unicode_ci;
