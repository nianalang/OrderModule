--
-- 购物车实体
--

create database order_module;

use order_module;

drop database order_module;

CREATE TABLE `cart` 
(
	`cart_id` int(11) NOT NULL  AUTO_INCREMENT,
  
	`member_id` int(11) NOT NULL,
 
	`goods_id` int(11) DEFAULT NULL,
  
	`goods_num` int(11) DEFAULT NULL,
  
	`choose` tinyint(4) DEFAULT NULL,
 
	`amount` decimal(20,2) DEFAULT NULL,
  
	`creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
	`modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY (cart_id)
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- 转存表中的数据 
--

INSERT INTO 
`cart` 
(`member_id`, `goods_id`, `goods_num`, `choose`, `amount`, `creatime`, `modifytime`) 
VALUES
( 1, 1, 3, 1, 19.80, '2016-11-22 06:22:50', '2016-12-06 02:40:38'),

( 1, 2, 5, 1, 39.80, '2016-11-23 01:58:23', '2016-12-27 08:22:00'),

( 1, 3, 2, 1, 19.80, '2016-12-29 03:44:47', '2016-12-29 03:45:51');


--
-- 订单实体：
--

CREATE TABLE `order` 
(
	`order_id` int(11) NOT NULL AUTO_INCREMENT,
 
	`sn` varchar(255) NOT NULL,
  
	`member_id` int(11) DEFAULT NULL,
  
	`status` smallint(6) DEFAULT NULL,
 
	`payment_id` int(11) DEFAULT NULL,
  
	`logi_id` int(11) DEFAULT NULL,
  
	`total_amount` decimal(20,2) DEFAULT NULL,
  
	`address_id` char(10) DEFAULT NULL,
  
	`creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
	`modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	
	PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 物流实体：
--


CREATE TABLE `logi` 
(
	`logi_id` int(11) NOT NULL AUTO_INCREMENT,
  
	`ship_id` int(11) NOT NULL,
  
	`sn` varchar(50) NOT NULL,
  
	`carriage` decimal(20,2) DEFAULT NULL,
  
	`sender` varchar(50) DEFAULT NULL,
  
	`status` smallint(6) DEFAULT NULL,
  
	`creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
	`modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	
	PRIMARY KEY (logi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- 转存表中的数据 
--

INSERT INTO 
`logi` 
(`ship_id`, `sn`, `carriage`, `sender`, `status`, `creatime`, `modifytime`) 
VALUES
(1, '20161125001', 0.00, '张三', 2, '2016-11-25 03:25:57', '2016-11-25 03:26:36'),

(2, 'yt20161202008', 8.00, '李四', 2, '2016-11-25 06:28:26', '2016-12-02 01:53:34'),

(3, 'sf20161206008', 8.00, '赵柳柳', 1, '2016-12-06 02:03:51', '2016-12-06 02:08:40'),

(4, '', 8.00, '', 0, '2016-12-06 02:04:15', '2016-12-06 02:04:15');



--
--订单商品实体：

CREATE TABLE `order_goods` 
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
  
	`order_id` int(11) DEFAULT NULL,
  
	`goods_id` int(11) NOT NULL ,
  
	`goods_num` int(11) NOT NULL,
  
	`price` decimal(20,2) DEFAULT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
--订单日志实体：


CREATE TABLE `order_log` 
(
	`log_id` int(11) NOT NULL AUTO_INCREMENT,
  
	`order_id` int(11) NOT NULL,
  
	`status` int(11) DEFAULT NULL,
  
	`time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	PRIMARY KEY (log_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
--货运公司实体：

CREATE TABLE `ship` 
(
	`ship_id` int(11) NOT NULL AUTO_INCREMENT,
  
	`name` varchar(50) NOT NULL,
  
	`code` varchar(50) DEFAULT NULL,
  
	`creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
	`modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	
	PRIMARY KEY (ship_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- 转存表中的数据 

INSERT INTO 
`ship` (`name`, `code`, `creatime`, `modifytime`) 
VALUES
('申通快递', 'shentong', '2016-11-22 07:13:39', '2016-11-22 07:50:00'),
('圆通快递', 'yuantong', '2016-11-22 07:14:04', '2016-11-22 08:08:57'),

('韵达快递', 'ydkd', '2016-11-22 07:35:05', '2016-11-22 07:35:05'),

('顺丰速运', 'sfsy', '2016-11-22 07:36:09', '2016-11-22 07:36:09'),

('跨越速运', 'kuayue', '2016-11-22 08:07:24', '2016-11-22 08:07:24'),

('天天快递', 'ttkd', '2016-11-24 00:42:54', '2017-01-06 03:48:52');





--外键 商品表
--
--

CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sn` varchar(50) NOT NULL,
  `brief` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(20,2) NOT NULL,
  `cost` decimal(20,2) NOT NULL,
  `mktprice` decimal(20,2) NOT NULL,
  `mkt_enable` tinyint(4) NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `weight` decimal(20,2) NOT NULL,
  `intro` text,
  `params` text,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modify` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `view_count` int(11) DEFAULT NULL,
  `buy_count` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `big` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods`
--

INSERT INTO `goods` (`goods_id`, `name`, `sn`, `brief`, `description`, `price`, `cost`, `mktprice`, `mkt_enable`, `cat_id`, `brand_id`, `weight`, `intro`, `params`, `creatime`, `last_modify`, `view_count`, `buy_count`, `thumbnail`, `big`, `small`, `original`) VALUES
(1, '正品Davidoff 大卫杜夫冷水女士淡香水2', 'sp123457', 'Cool Water（冷水）女士香水可以说是男用香水的一款延伸之作', '30/50/100ml气质优雅包邮', 89.00, 80.00, 90.00, 1, 23, 5, 300.00, '商品品牌  Davidoff/大卫杜夫', '{"产地":"","净含量":"","保质期":"","口味":""}', '2017-01-05 01:43:23', '2017-01-05 09:05:23', 0, 0, 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_orig.jpg'),
(2, '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', 'sn001', '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', 38.00, 20.00, 40.00, 0, 62, 40, 2940.00, '<img src="/MobileShop/upload/kindeditor/image/96jz34UeExOINrY8Gg7lhQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XNPsL+Rjx1mohoJ0Q7It8Q==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/0E15y6cphCLX5XKgeCECng==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/jlGl2dUtA2jQjS1h4jFJcw==.jpg" alt="" />', '{"产地":"","净含量":"","保质期":"","口味":""}', '2017-01-13 03:27:01', '2017-01-13 03:27:01', 2, 0, 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_big.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_small.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_orig.jpg'),
(3, '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', 'sn002', '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', 349.00, 200.00, 400.00, 0, 6, 2, 9300.00, '<img src="/MobileShop/upload/kindeditor/image/XnDb7JeYaFGlzSC7kvDUUQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/cQvQKHlnK4YvxjXaAl21Ag==.jpg" alt="" />', '{"产地":"泸州","储存方法":"密闭","品种":"白酒","净含量":"9300","保质期":"十年","配料":""}', '2017-01-13 03:52:09', '2017-01-13 03:52:09', 2, 0, 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_thum.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_big.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_small.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_orig.jpg'),
(4, '雅顿第五大道香水女士持久淡香125ml正品代购包邮', 'sn003', '雅顿第五大道', '第五大道表达女性自信、现代以及智慧优雅的一面，适合现代都市中自信、时尚又追求个人风格的女性。是女孩们最经典的入门香水！注：此商品为新版包装，喷头是塑料喷头不是金属喷头哦~', 199.00, 120.00, 266.00, 0, 63, 42, 1000.00, '<p>\n	<br />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/qJxQb3Vq8gS8skjncQ3OCw==.jpg" alt="" />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/nz8Q5bPWC31H1dvM62MyGQ==.jpg" alt="" />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/ePiRQ0detuYhc7k80T+4uA==.jpg" alt="" />\n</p>', '{"产地":"美国","适用人群":"任何人群","香调":"花香调 东方香调","规格":"125mL","保质期":"3年"}', '2017-01-13 06:15:31', '2017-01-13 06:15:31', 0, 0, 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_big.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_small.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_orig.jpg'),
(5, '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', 'sn004', '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', 265.00, 200.00, 300.00, 0, 63, 43, 300.00, '<img src="/MobileShop/upload/kindeditor/image/KIzQIb44OVjCaF8BQZYf+g==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/M0mNCEEXDrfcgvJHdV5BKA==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XifuOStWPiQd40LSMadA2w==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/bd4b4kc9eLUA6MbJrKx1vg==.jpg" alt="" />', '{"产地":"法国","适用人群":"女士","香调":"花果香调","规格":"100mL","保质期":"5年"}', '2017-01-13 06:22:09', '2017-01-13 06:22:09', 1, 0, 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_big.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_small.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_orig.jpg'),
(6, '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', 'sn005', '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', 215.00, 130.00, 300.00, 0, 63, 45, 500.00, '<img src="/MobileShop/upload/kindeditor/image/pZ2ET+GkovAYo8uPooPkIw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/DyWfOwn9JV0RfBRluVyrkw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/kex57I7Al73JJjITKO14rw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XtKkP9TPWzYKaH3Av8E08g==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/4TuP840bD5ZlRPnq5DM5ag==.jpg" alt="" />', '{"产地":"意大利","适用人群":"女生","香调":"花香调 树木香调","规格":"65mL","保质期":"5年"}', '2017-01-13 06:29:09', '2017-01-13 06:29:09', 0, 0, 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_orig.jpg'),
(7, '正品Bvlgari man宝格丽当代绅士男淡香30ml/60ml/100ml/150ml包邮', 'sn006', '正品Bvlgari man宝格丽当代绅士男淡香30ml/60ml/100ml/150ml包邮', '为创造出一种崭新、珍贵且充满活力的嗅觉体验，BVLGARI MAN散发出东方的白木香味，诠译出全新的男性典范。强烈的木质香气，令一向在男性香水中扮演传统元素的成分因加入自然纯净的微妙光采，变得更加出色。', 225.00, 130.00, 280.00, 0, 63, 45, 400.00, '<img src="/MobileShop/upload/kindeditor/image/tKWU3ZhZqb3OnOnHpOnTag==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/M5oN7aGQyjl8jk3wzlXmwg==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/L3J7wNjNx+m0xBn1XAHZkw==.jpg" alt="" />', '{"产地":"意大利","适用人群":"男士","香调":"树木香调","规格":"150mL","保质期":"5年"}', '2017-01-13 06:38:06', '2017-01-13 06:38:06', 0, 0, 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_thum.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_big.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_small.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_orig.jpg'),
(8, '正品Bvlgari Pour Homme宝格丽大吉岭茶中性香水30/50/100ML包邮', 'sn007', '正品Bvlgari Pour Homme宝格丽大吉岭茶中性香水30/50/100ML包邮', '在2006年，Bvlgari针对旗下的经典香水全面推出新改版，更加精緻的瓶身及外盒设计，更能显现出宝格丽的品牌精神！宝格丽大吉岭极緻中性香水，献给自然优雅、充满自信的你。无比魅力的秘密，就是沉稳而果决的风格与出人意表的性感。', 216.00, 180.00, 280.00, 0, 63, 45, 150.00, '<img src="/MobileShop/upload/kindeditor/image/V+JBV3kyZFlw6DRjjLMuNw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/I9WsFDEeDKeXK7j4eoXBBw==.jpg" alt="" />', '{"产地":"意大利","适用人群":"男士","香调":"花香调 树木香调","规格":"65mL","保质期":"5年"}', '2017-01-13 06:43:56', '2017-01-13 06:43:56', 0, 0, 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_big.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_small.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_orig.jpg'),
(9, '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', 'sn008', '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', 1232.00, 1000.00, 1300.00, 0, 46, 33, 4.00, '<img src="/MobileShop/upload/kindeditor/image/PDC4hRdiZnbw2nwGiGPlqQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/cOkWV7xG2STFguc3igoGTg==.jpg" alt="" />', '{"产地":"周大福","重量":"4","贵重金属成分":"千足金","售后服务":"专柜联保 店铺保修","款式":"吊坠"}', '2017-01-13 06:48:52', '2017-01-13 06:48:52', 0, 0, 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_orig.jpg'),
(10, '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', 'sn009', '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', 1800.00, 1300.00, 2300.00, 0, 47, 34, 5.00, '<img src="/MobileShop/upload/kindeditor/image/a1zazmNRZTWiubdxEsrNjA==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/V+x9Hx25ZxuQxVf5LXF7Tw==.jpg" alt="" />', '{"产地":"香港","重量":"10分","贵重金属成分":"钻石 黄18K金","售后服务":"店铺保修","款式":"戒指/指环"}', '2017-01-13 06:54:22', '2017-01-13 06:54:22', 0, 0, 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_big.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_small.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_orig.jpg');