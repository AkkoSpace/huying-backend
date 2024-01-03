-- 系统
-- 用户表
create table system_user
(
    id           bigint auto_increment comment '用户 ID'
        primary key,
    userAccount  varchar(15)                                                         not null comment '账号',
    userPassword varchar(512)                                                        not null comment '密码',
    userName     varchar(6)                                                          null comment '姓名',
    userPhone    char(11)                                                            null comment '电话',
    userAvatar   varchar(1024)       default 'https://akko.space/upload/default.png' null comment '头像',
    userProfile  varchar(512)                                                        null comment '简介',
    userRole     varchar(10)         default 'user'                                  not null comment '角色：user/admin/ban',
    createTime   datetime            default CURRENT_TIMESTAMP                       not null comment '创建时间',
    updateTime   datetime            default CURRENT_TIMESTAMP                       not null comment '更新时间',
    isDelete     tinyint(1) unsigned default 0                                       not null comment '是否删除'
)
    comment '用户表' collate = utf8mb4_unicode_ci;

-- 基础信息
-- 产品信息表
create table basic_product
(
    id            int auto_increment comment '自增主键'
        primary key,
    brandId       tinyint unsigned                              null comment '品牌 ID',
    productName   varchar(20)                                   not null comment '产品名称',
    barCode       varchar(20)                                   null comment '条形码',
    productSpec   varchar(20)                                   not null comment '产品规格',
    productUnit   char                                          not null comment '产品单位',
    purchasePrice decimal(10, 2)                                null comment '进货单价',
    standardPrice decimal(10, 2)                                null comment '标准单价',
    userId        bigint                                        not null comment '操作用户 ID',
    createTime    datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '产品信息表' collate = utf8mb4_unicode_ci;

-- 产品品牌表
create table basic_product_brand
(
    id         int auto_increment comment '自增主键'
        primary key,
    brandName  varchar(10)                                   not null comment '品牌名称',
    userId     bigint                                        not null comment '操作用户 ID',
    createTime datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '产品品牌表' collate = utf8mb4_unicode_ci;

-- 产品分类表
create table basic_product_category
(
    id               int auto_increment comment '自增主键'
        primary key,
    productAttribute varchar(10)                                   not null comment '产品属性',
    productType      varchar(10)                                   not null comment '产品类型',
    userId           bigint                                        not null comment '操作用户 ID',
    createTime       datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime       datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete         tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '产品分类表' collate = utf8mb4_unicode_ci;

-- 产品销售价格表
create table basic_product_selling_price
(
    id            int auto_increment comment '自增主键'
        primary key,
    productId     int                                           not null comment '产品 ID',
    purchasePrice decimal(10, 2)                                null comment '进货单价',
    standardPrice decimal(10, 2)                                null comment '标准单价',
    sellingPrice  decimal(10, 2)                                null comment '销售单价',
    productProfit decimal(10, 2)                                null comment '产品利润',
    userId        bigint                                        not null comment '操作用户 ID',
    createTime    datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '产品销售价格表' collate = utf8mb4_unicode_ci;

-- 仓库信息表
create table basic_warehouse
(
    id                 int auto_increment comment '自增主键'
        primary key,
    warehouseName      varchar(10)                                   not null comment '仓库名称',
    warehouseAddress   varchar(50)                                   null comment '仓库地址',
    warehouseStatus    tinyint(1) unsigned default 1                 not null comment '仓库状态：0-停用，1-启用',
    warehouseManagerId bigint                                        not null comment '仓库负责人 ID',
    userId             bigint                                        not null comment '操作用户 ID',
    createTime         datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime         datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete           tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '仓库信息表' collate = utf8mb4_unicode_ci;
