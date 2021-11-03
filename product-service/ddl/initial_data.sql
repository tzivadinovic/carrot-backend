set foreign_key_checks = 0;

insert into `category`
values (1, 'Laptopovi', '2021-10-15 16:03:47', 'system', '2021-10-15 16:03:47', 1);
insert into `product`
values (1, 'Laptop Asus VivoBook', 1, 1, 120, 90000, null, null, null, '2021-10-15 16:04:06', 'system',
        '2021-10-15 16:04:06', 1);
insert into `product_brand`
values (1, 'ASUS', '2021-10-15 16:02:18', 'system', '2021-10-15 16:02:18', 1);
insert into `product_model`
values (1, 'VivoBook', 1, '2021-10-15 16:02:33', 'system', '2021-10-15 16:02:33', 1);
insert into `product_order`
values (2, 1, 1, 1, '2021-10-15 16:04:37', 'system', '2021-10-15 16:04:37', 1);
insert into `sub_category`
values (1, 'Laptopovi2', 1, null, '2021-10-15 16:04:00', 'system', '2021-10-15 16:04:00', 1);

set foreign_key_checks = 1;