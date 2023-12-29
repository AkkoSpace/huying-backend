CREATE TABLE `user`
(
    `id`           bigint PRIMARY KEY AUTO_INCREMENT COMMENT '用户 ID',
    `userAccount`  varchar(32)  NOT NULL COMMENT '账号',
    `userPassword` varchar(512) NOT NULL COMMENT '密码',
    `uid`          varchar(256) COMMENT 'UID',
    `userName`     varchar(32) COMMENT '用户昵称',
    `userAvatar`   varchar(1024)         DEFAULT 'https://akko.space/upload/default.png' COMMENT '用户头像',
    `userProfile`  varchar(512) COMMENT '用户简介',
    `userRole`     varchar(256) NOT NULL DEFAULT 'user' COMMENT '用户角色：user/admin/ban',
    `createTime`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`     tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `transaction`
(
    `id`               int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `transactionOrder` varchar(255)   NOT NULL COMMENT '交易订单',
    `transactionDate`  date           NOT NULL COMMENT '交易日期',
    `amount`           decimal(10, 2) NOT NULL COMMENT '交易金额',
    `orderId`          varchar(255) COMMENT '订单 ID',
    `description`      varchar(255) COMMENT '描述',
    `userId`           bigint         NOT NULL COMMENT '操作用户 ID',
    `status`           tinyint        NOT NULL DEFAULT 0 COMMENT '交易状态：0-未付款，1-已付款，2-已取消，3-已退款',
    `createTime`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`         tinyint        NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `transaction_products`
(
    `id`               int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `transactionOrder` varchar(255) NOT NULL COMMENT '交易 ID',
    `products`         json         NOT NULL COMMENT '订单产品',
    `userId`           bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`         tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products_brands`
(
    `id`         int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `brandName`  varchar(255) NOT NULL COMMENT '品牌名称',
    `barCode`    varchar(255) COMMENT '条形码',
    `userId`     bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`   tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products_spec`
(
    `id`         int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `specName`   varchar(255) NOT NULL COMMENT '规格',
    `userId`     bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`   tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products_unit`
(
    `id`         int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `unitName`   varchar(255) NOT NULL COMMENT '单位',
    `userId`     bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`   tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products`
(
    `id`            int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `productName`   varchar(255) NOT NULL COMMENT '产品名称',
    `brandId`       int      NOT NULL COMMENT '品牌 ID',
    `productSpecId` int      NOT NULL COMMENT '产品规格 ID',
    `productUnitId` int      NOT NULL COMMENT '产品单位 ID',
    `userId`        bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`      tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products_price`
(
    `id`         int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `productId`  int            NOT NULL COMMENT '产品 ID',
    `price`      decimal(10, 2) NOT NULL COMMENT '价格',
    `priceDate`  date           NOT NULL COMMENT '价格日期',
    `userId`     bigint         NOT NULL COMMENT '操作用户 ID',
    `createTime` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`   tinyint        NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `products_date`
(
    `id`               int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `productId`        int          NOT NULL COMMENT '产品 ID',
    `transactionOrder` varchar(255) NOT NULL COMMENT '交易 ID',
    `productDate`      date         NOT NULL COMMENT '生产日期',
    `userId`           bigint       NOT NULL COMMENT '操作用户 ID',
    `createTime`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`         tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE TABLE `companies`
(
    `id`             int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    `companyId`      varchar(255) NOT NULL COMMENT '公司 ID',
    `companyName`    varchar(255) NOT NULL COMMENT '公司名称',
    `companyAddress` varchar(255) COMMENT '公司地址',
    `contactPhone`   varchar(20) COMMENT '联系电话',
    `contactEmail`   varchar(255) COMMENT '联系邮箱',
    `userId`         bigint       NOT NULL COMMENT '操作用户 id',
    `createTime`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `isDelete`       tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除'
);

CREATE INDEX `idx_uid` ON `user` (`uid`);

CREATE INDEX `idx_brand_name` ON `products_brands` (`brandName`);

CREATE INDEX `idx_spec_name` ON `products_spec` (`specName`);

CREATE INDEX `idx_unit_name` ON `products_unit` (`unitName`);

ALTER TABLE `user`
    COMMENT = '用户';

ALTER TABLE `transaction`
    COMMENT = '交易';

ALTER TABLE `transaction_products`
    COMMENT = '订单产品';

ALTER TABLE `products_brands`
    COMMENT = '产品品牌';

ALTER TABLE `products_spec`
    COMMENT = '产品规格';

ALTER TABLE `products_unit`
    COMMENT = '产品单位';

ALTER TABLE `products`
    COMMENT = '产品';

ALTER TABLE `companies`
    COMMENT = '公司';

CREATE INDEX `idx_transaction_order` ON `transaction` (`transactionOrder`);

ALTER TABLE `transaction_products`
    ADD CONSTRAINT `fk_transaction_products_transaction_order` FOREIGN KEY (`transactionOrder`) REFERENCES `transaction` (`transactionOrder`) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE INDEX `idx_product_brand_id` ON `products` (`brandId`);
CREATE INDEX `idx_product_spec_id` ON `products` (`productSpecId`);
CREATE INDEX `idx_product_unit_id` ON `products` (`productUnitId`);

CREATE INDEX `idx_id` ON `products_brands` (`id`);
CREATE INDEX `idx_id` ON `products_spec` (`id`);
CREATE INDEX `idx_id` ON `products_unit` (`id`);


ALTER TABLE `products`
    ADD CONSTRAINT `fk_products_brand_id` FOREIGN KEY (`brandId`) REFERENCES `products_brands` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `products`
    ADD CONSTRAINT `fk_products_spec_id` FOREIGN KEY (`productSpecId`) REFERENCES `products_spec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `products`
    ADD CONSTRAINT `fk_products_unit_id` FOREIGN KEY (`productUnitId`) REFERENCES `products_unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `products_price`
    ADD CONSTRAINT `fk_products_price_product_id` FOREIGN KEY (`productId`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `products_date`
    ADD CONSTRAINT `fk_products_date_product_id` FOREIGN KEY (`productId`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `products_date`
    ADD CONSTRAINT `fk_products_date_transaction_id` FOREIGN KEY (`transactionOrder`) REFERENCES `transaction` (`transactionOrder`) ON DELETE CASCADE ON UPDATE CASCADE;
