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
    categoryId    tinyint unsigned                              null comment '分类 ID',
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
    id               int auto_increment comment '自增主键'
        primary key,
    warehouseName    varchar(10)                                   not null comment '仓库名称',
    warehouseAddress varchar(50)                                   null comment '仓库地址',
    warehouseStatus  tinyint(1) unsigned default 1                 not null comment '仓库状态：0-停用，1-启用',
    userId           bigint                                        not null comment '操作用户 ID',
    createTime       datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime       datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete         tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '仓库信息表' collate = utf8mb4_unicode_ci;

-- 采购管理
-- 供应商信息表
create table purchase_supplier
(
    id              int auto_increment comment '自增主键'
        primary key,
    supplierName    varchar(10)                                   not null comment '供应商名称',
    supplierAddress varchar(50)                                   null comment '供应商地址',
    userId          bigint                                        not null comment '操作用户 ID',
    createTime      datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime      datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '供应商信息表' collate = utf8mb4_unicode_ci;

-- 供应商价格表
create table purchase_supplier_price
(
    id            int auto_increment comment '自增主键'
        primary key,
    productId     int                                           not null comment '产品 ID',
    supplierId    int                                           not null comment '供应商 ID',
    purchasePrice decimal(10, 2)                                null comment '进货单价',
    userId        bigint                                        not null comment '操作用户 ID',
    createTime    datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '供应商价格表' collate = utf8mb4_unicode_ci;

-- 采购订单表
create table purchase_order
(
    id          int auto_increment comment '自增主键'
        primary key,
    orderId     varchar(20)                                   not null comment '订单 ID',
    supplierId  int                                           not null comment '供应商 ID',
    warehouseId int                                           not null comment '仓库 ID',
    orderStatus tinyint(1) unsigned default 1                 not null comment '订单状态：0-已取消，1-待入库，2-已入库',
    orderDate   date                                          not null comment '订单日期',
    orderTotal  decimal(10, 2)                                null comment '订单总价',
    orderRemark varchar(50)                                   null comment '订单备注',
    userId      bigint                                        not null comment '操作用户 ID',
    createTime  datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '采购订单表' collate = utf8mb4_unicode_ci;

-- 采购订单详情表
create table purchase_order_detail
(
    id            int auto_increment comment '自增主键'
        primary key,
    orderId       int                                           not null comment '订单 ID',
    productId     int                                           not null comment '产品 ID',
    purchasePrice decimal(10, 2)                                null comment '进货单价',
    purchaseCount int                                           null comment '进货数量',
    purchaseTotal decimal(10, 2)                                null comment '进货总价',
    userId        bigint                                        not null comment '操作用户 ID',
    createTime    datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '采购订单详情表' collate = utf8mb4_unicode_ci;

-- 采购入库表
create table purchase_stock_in
(
    id          int auto_increment comment '自增主键'
        primary key,
    orderId     int                                           not null comment '订单 ID',
    supplierId  int                                           not null comment '供应商 ID',
    warehouseId int                                           not null comment '仓库 ID',
    stockInDate date                                          not null comment '入库日期',
    userId      bigint                                        not null comment '操作用户 ID',
    createTime  datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '采购入库表' collate = utf8mb4_unicode_ci;

-- 库存管理
-- 库存信息表
create table stock_info
(
    id          int auto_increment comment '自增主键'
        primary key,
    productId   int                                           not null comment '产品 ID',
    warehouseId int                                           not null comment '仓库 ID',
    stockCount  int                                           null comment '库存数量',
    stockTotal  decimal(10, 2)                                null comment '库存总价',
    userId      bigint                                        not null comment '操作用户 ID',
    createTime  datetime            default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime            default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint(1) unsigned default 0                 not null comment '是否删除'
)
    comment '库存信息表' collate = utf8mb4_unicode_ci;
