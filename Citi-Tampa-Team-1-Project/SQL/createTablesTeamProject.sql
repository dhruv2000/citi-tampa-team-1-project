drop database team_one;
CREATE DATABASE IF NOT EXISTS team_one;
use team_one;
create table orders (id int primary key auto_increment, ticker varchar (10),price double,time_of_day varchar(30), asset varchar(20), status_code int, num_shares int, order_type varchar(20)); 



insert into orders values(1,'AAPL',171.28, '14:04 8-12-2022' , 'stock', 1, 100, 'buy' );
insert into orders values(2,'BBBY',12.51,'14:04 8-12-2022','stock', 2, 50, 'sell');
insert into orders values(3,'CHPT',19.06, '14:05 8-12-2022','stock', 0, 100, 'sell');
insert into orders values(4,'DNA',3.585,'14:05 8-12-2022','stock', 3, 20, 'buy');
insert into orders values(5,'UBER',32.21,'14:07 8-12-2022','stock', 2, 100, 'buy');
insert into orders values(6,'GOLD',16.75,'14:07 8-12-2022','stock', 0, 120, 'sell');
insert into orders values(7,'WBD',13.66,'14:07 8-12-2022','stock', 1, 105, 'buy');
insert into orders values(8,'NOK',5.19,'14:07 8-12-2022','stock', 3, 100, 'buy');

create table stocks (id int primary key auto_increment, ticker varchar (10),currency varchar(30), market_time varchar(30), volume int, last_price double); 

insert into stocks values(1,'AAPL','USD','14:02 8-12-2022', 100, 171.28);
insert into stocks values(2,'BBBY','USD','14:04 8-12-2022', 50, 12.51);

