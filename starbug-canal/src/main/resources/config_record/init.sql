-- 源数据库：canal01
CREATE
DATABASE `canal01` CHARACTER SET 'utf8mb4';
-- 创建user01表
CREATE TABLE `user01`
(
    `id`       int(64) NOT NULL AUTO_INCREMENT,
    `username` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- 目标数据库：canal02
CREATE
DATABASE `canal02` CHARACTER SET 'utf8mb4';
-- 创建user02表
CREATE TABLE `user02`
(
    `id`       int(64) NOT NULL AUTO_INCREMENT,
    `username` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
