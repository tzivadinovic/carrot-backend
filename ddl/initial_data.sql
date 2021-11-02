set
foreign_key_checks = 0;

insert into `category`
values (1, 'Laptopovi', '2021-10-15 16:03:47', 'system', '2021-10-15 16:03:47', 1);
insert into `country`
values (1, 'Srbija', '2021-10-15 14:27:40', 'system', '2021-10-15 14:27:40', 1);
insert into `order`
values (1, 1, 1, '2021-10-15 16:04:35', 'system', '2021-10-15 16:04:35', 1);
insert into `product`
values (1, 'Laptop Asus VivoBook', 1, 1, 120, 90000, null, null, null, '2021-10-15 16:04:06', 'system',
        '2021-10-15 16:04:06', 1);
insert into `product_brand`
values (1, 'ASUS', '2021-10-15 16:02:18', 'system', '2021-10-15 16:02:18', 1);
insert into `product_model`
values (1, 'VivoBook', 1, '2021-10-15 16:02:33', 'system', '2021-10-15 16:02:33', 1);
insert into `product_order`
values (2, 1, 1, 1, '2021-10-15 16:04:37', 'system', '2021-10-15 16:04:37', 1);
insert into `role`
values (1, 'ADMIN', '2021-10-15 14:49:49', 'system', '2021-10-15 14:49:49', 1);
insert into `sub_category`
values (1, 'Laptopovi2', 1, null, '2021-10-15 16:04:00', 'system', '2021-10-15 16:04:00', 1);
insert into `user`
values (1, 'Ad', 'Min', null, null, 'admin@carrot.rs', 'admin',
        '$2a$12$w8OJe3AQzNGA2V5iB3EvoeiKog45zfQR3eI0pzUcGD/irOvOhbttm', '2021-10-15 14:50:30', 'system',
        '2021-10-15 14:50:30', 1);
insert into `user_role`
values (1, 1, 1, '2021-10-15 14:50:37', 'system', '2021-10-15 14:50:37', 1);

set
foreign_key_checks = 1;