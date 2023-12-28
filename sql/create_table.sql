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
    isDelete     tinyint       default 0                                       not null comment '是否删除',
    constraint uk_user_account
        unique (userAccount)
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
    isDelete         tinyint  default 0                 not null comment '是否删除',
    constraint uk_transaction_order
        unique (transactionOrder)
)
    comment '交易' collate = utf8mb4_unicode_ci;

-- 订单表
create table `transaction_products`
(
    id            int auto_increment comment '自增主键'
        primary key,
    transactionId varchar(255)                       not null comment '交易 ID',
    products      json                               not null comment '订单产品',
    userId        bigint                             not null comment '操作用户 ID',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除',
    constraint fk_transaction_products_transaction_id
        foreign key (transactionId) references transaction (transactionOrder)
            on update cascade on delete cascade
)
    comment '订单产品' collate = utf8mb4_unicode_ci;

-- 产品品牌
create table products_brands
(
    id         int auto_increment comment '自增主键'
        primary key,
    brandName  varchar(255)                       not null comment '品牌名称',
    barCode    varchar(255)                       null comment '条形码',
    userId     bigint                             not null comment '操作用户 ID',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint uk_products_brands_brand_name
        unique (brandName)
)
    comment '产品品牌' collate = utf8mb4_unicode_ci;

-- 产品规格
create table products_spec
(
    id         int auto_increment comment '自增主键'
        primary key,
    specName   varchar(255)                       not null comment '规格',
    userId     bigint                             not null comment '操作用户 ID',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint uk_products_spec_spec_name
        unique (specName)
)
    comment '产品规格' collate = utf8mb4_unicode_ci;

-- 产品单位
create table products_unit
(
    id         int auto_increment comment '自增主键'
        primary key,
    unitName   varchar(255)                       not null comment '单位',
    userId     bigint                             not null comment '操作用户 ID',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint uk_products_unit_unit_name
        unique (unitName)
)
    comment '产品单位' collate = utf8mb4_unicode_ci;

-- 产品价格
create table products_price
(
    id         int auto_increment comment '自增主键'
        primary key,
    productId  int                                not null comment '产品 ID',
    price      decimal(10, 2)                     not null comment '价格',
    priceDate  date                               not null comment '价格日期',
    userId     bigint                             not null comment '操作用户 ID',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint fk_products_price_product_id
        foreign key (productId) references products (id)
            on update cascade on delete cascade
);

-- 产品生产日期
create table products_date
(
    id            int auto_increment comment '自增主键'
        primary key,
    productId     int                                not null comment '产品 ID',
    transactionId varchar(255)                       not null comment '交易 ID',
    productDate   date                               not null comment '生产日期',
    userId        bigint                             not null comment '操作用户 ID',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除',
    constraint fk_products_date_product_id
        foreign key (productId) references products (id)
            on update cascade on delete cascade,
    constraint fk_products_date_transaction_id
        foreign key (transactionId) references transaction (transactionOrder)
            on update cascade on delete cascade
);

-- 产品表
create table products
(
    id            int auto_increment comment '自增主键'
        primary key,
    brandId       tinyint                            not null comment '品牌 ID',
    productName   varchar(255)                       not null comment '产品名称',
    productSpecId tinyint                            not null comment '产品规格 ID',
    productUnitId tinyint                            not null comment '产品单位 ID',
    userId        bigint                             not null comment '操作用户 ID',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除',
    constraint fk_products_brand_id
        foreign key (brandId) references products_brands (id)
            on update cascade on delete cascade,
    constraint fk_products_spec_id
        foreign key (productSpecId) references products_spec (id)
            on update cascade on delete cascade,
    constraint fk_products_unit_id
        foreign key (productUnitId) references products_unit (id)
            on update cascade on delete cascade
)
    comment '产品' collate = utf8mb4_unicode_ci;

-- 公司表
create table companies
(
    id             int auto_increment comment '自增主键'
        primary key,
    companyId      varchar(255)                       not null comment '公司 ID',
    companyName    varchar(255)                       not null comment '公司名称',
    companyAddress varchar(255)                       null comment '公司地址',
    contactPhone   varchar(20)                        null comment '联系电话',
    contactEmail   varchar(255)                       null comment '联系邮箱',
    userId         bigint                             not null comment '操作用户 id',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除',
    constraint uk_companies_company_id
        unique (companyId)
)
    comment '公司' collate = utf8mb4_unicode_ci;

