
CREATE DATABASE IF NOT EXISTS team_one;
use team_one;
create table stocks (id int primary key auto_increment, ticker varchar (10),currency varchar(30), marketTime varchar(30), volume int, lastPrice double); 



insert into stocks values(1,'AAPL','USD','14:02 8-12-2022', 100, 171.28);
insert into stocks values(2,'BBBY','USD','14:04 8-12-2022', 50, 12.51);
