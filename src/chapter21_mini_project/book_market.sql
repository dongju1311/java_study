use hrdb2019;
select database();

/************************************************************************
	book_market_books : 도서 리스트
    book_market_cart : 장바구니
    book_market_member : 회원테이블
    
*************************************************************************/

show tables;
set sql_safe_updates = 0;
delete from cart_item;
drop table cart_item;
desc books;


create table books(
	bid varchar(8) primary key,
    bname varchar(20),
    price int(8),
    author varchar(10) not null,
    binfo varchar(30) not null,
    department varchar(10),
    bdate datetime);
    
create table user(
	name varchar(10) not null,
    phone varchar(11),
    address char(50),
    order_date datetime
);
    
create table cart_item(
	bname varchar(20),
    user_name varchar(6) not null,
    qty int not null);
    desc cart_item;
    
delimiter $$
create trigger trg_books_bid
before insert on books -- 테이블명
for each row
begin
declare max_code int;
select ifnull(max(cast(right(bid,4) as unsigned)),0)
into max_code
from books;
set new.bid = concat('ISBN', lpad((max_code+1),4,'0'));
end $$
delimiter ;





