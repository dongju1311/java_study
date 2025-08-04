use hrdb2019;
select database();

-- 테이블 3개 생성, book_tj, book_yes24, book_aladin
-- bid:pk('B001', 트리거 생성),  title, author, price, isbn(랜덤 정수4자리 생성), bdate

create table book_tj(
	bid char(4) primary key,
    title varchar(10) not null,
    author varchar(5) not null,
    price int not null,
    isbn int unique auto_increment,
    bdate date);
    
 create table book_yes24(
	bid char(4) primary key,
    title varchar(10) not null,
    author varchar(5) not null,
    price int not null,
    isbn int unique auto_increment,
    bdate date);   
    
 create table book_aladin(
	bid char(4) primary key,
    title varchar(10) not null,
    author varchar(5) not null,
    price int not null,
    isbn int unique auto_increment,
    bdate date);    
    
delimiter $$
create trigger trg_book_tj_bid
before insert on book_tj
for each row
begin
declare max_code int;
select ifnull(max(cast(right(bid,3) as unsigned)),0)
into max_code
from book_tj;
set new.bid = concat('B',lpad((max_code+1),3,'0'));
end $$
delimiter ;

delimiter $$
create trigger trg_book_yes24_bid
before insert on book_yes24
for each row
begin
declare max_code int;
select ifnull(max(cast(right(bid,3) as unsigned)),0)
into max_code
from book_yes24;
set new.bid = concat('B',lpad((max_code+1),3,'0'));
end $$
delimiter ;     
    
delimiter $$
create trigger trg_book_aladin_bid
before insert on book_aladin
for each row
begin
declare max_code int;
select ifnull(max(cast(right(bid,3) as unsigned)),0)
into max_code
from book_aladin;
set new.bid = concat('B',lpad((max_code+1),3,'0'));
end $$
delimiter ;     

select * from book_tj;
select * from book_aladin;
select * from book_yes24;

show status like 'threads_connected';
show processlist;
show variables like 'max_connections';