drop database team_one;
CREATE DATABASE IF NOT EXISTS team_one;
use team_one;
create table orders (id int primary key auto_increment, ticker varchar (10),price double,time_of_day timestamp, asset varchar(20), status_code int, num_shares int, order_type varchar(20));



insert into orders values(1,'AAPL',171.28, '2022-08-12 14:02:29' , 'stock', 1, 100, 'buy' );
insert into orders values(2,'BBBY',12.51,'2022-08-12 15:02:29','stock', 2, 50, 'sell');
insert into orders values(3,'CHPT',19.06, '2022-08-12 16:02:29','stock', 0, 100, 'sell');
insert into orders values(4,'DNA',3.585,'2022-08-12 17:02:29','stock', 3, 20, 'buy');
insert into orders values(5,'UBER',32.21,'2022-08-12 18:02:29','stock', 2, 100, 'buy');
insert into orders values(6,'GOLD',16.75,'2022-08-12 19:02:29','stock', 0, 120, 'sell');
insert into orders values(7,'WBD',13.66,'2022-08-12 20:02:29','stock', 1, 105, 'buy');
insert into orders values(8,'NOK',5.19,'2022-08-12 21:02:29','stock', 3, 100, 'buy');

create table stocks (id int primary key auto_increment, ticker varchar (10),currency varchar(30), market_time varchar(30), volume int, last_price double); 

insert into stocks values(1,'AAPL','USD','14:02 8-12-2022', 100, 171.28);
insert into stocks values(2,'BBBY','USD','14:04 8-12-2022', 50, 12.51);

