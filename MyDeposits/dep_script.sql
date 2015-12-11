DROP DATABASE IF EXISTS deposits_table;
 
CREATE DATABASE deposits_table DEFAULT CHARACTER SET 'utf8';
 
USE deposits_table;
  
create table deposits
(
  id int unsigned not null auto_increment,
  City varchar(255) not null,
  Bank varchar(255) not null,
  Time int not null,
  Percent int not null,
  primary key (id)
) engine=InnoDB;
 
set names 'utf8';
 
insert into deposits (City, Bank, Time, Percent)
values ('Minsk', 'BELARUSBANK', 24, 10);
insert into deposits (City, Bank, Time, Percent)
values ('Минск', 'BELARUSBANK', 6, 13);
insert into deposits (City, Bank, Time, Percent)
values ('Минск', 'BELSWISBANK', 12, 20);
insert into deposits (City, Bank, Time, Percent)
values ('Брест', 'BELARUSBANK', 6, 15);
insert into deposits (City, Bank, Time, Percent)
values ('Брест', 'BELARUSBANK', 12, 11);
insert into deposits (City, Bank, Time, Percent)
values ('Могилев', 'BELARUSBANK', 6, 12);
insert into deposits (City, Bank, Time, Percent)
values ('Минск', 'BELARUSBANK', 24, 7);
