insert into inventory (id, name, count, created_at) values(1, 'Item 1', 1, now());
insert into inventory (id, name, count, created_at) values(2, 'Item 2', 2, now());
insert into inventory (id, name, count, created_at) values(3, 'Item 3', 100, now());
alter sequence inventory_id_seq restart with 4;