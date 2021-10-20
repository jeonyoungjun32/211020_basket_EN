CREATE TABLE member (
  id VARCHAR(20) NOT NULL,/*1*/
  pw VARCHAR(30) NOT NULL,/*2*/
  name VARCHAR(10) NOT NULL,/*3*/
  address_number VARCHAR(10) NOT NULL,/*4*/
  address VARCHAR(100) NOT NULL,/*5*/
  address_contents VARCHAR(100) NOT NULL,/*6*/
  email VARCHAR(30) NOT NULL,/*7*/
  birth DATE NOT NULL,/*8*/
  gender CHAR(1) NOT NULL,/*9*/
  grade CHAR(1) NOT NULL DEFAULT '1',/*10*/
  id_code int NOT NULL,/*11*/
  join_member DATE NOT NULL,/*12*/
  money INT NULL,/*13*/
  point INT NULL DEFAULT 0,/*14*/
  author CHAR(1) NOT NULL,/*15*/
  PRIMARY KEY (id)
)
select count(*) as count from member_order
/*회원 탈퇴시 각 테이블에서 삭제해줘야할 테이블*/
member, member_order_point, member_order, /*게시판*/Notice, board_question

select * from member_point_order where id ='test';
select * from member_order;
select * from Notice
select * from board_question

select sum(point) from member_point_order where point_status='O';

select m1.point_number, m1.point, m1.point_status, m1.point_date, m1.id, m1.serial_code, m2.name from member_point_order m1, (select serial_code, name from Product) m2
where m1.serial_code = m2.serial_code and id = 'test' order by point_date desc limit 1,20;

/*방문자 이벤트 활용을위한 방문자 카운터*/

select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m1.id, m2.serial_code from member_order m1,
(select serial_code, name from Product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 7 day) and now())
group by m1.order_code, m2.serial_code, m2.name
order by 6 desc;

select * from member_order

select count(order_count), serial_code, order_date from member_order
where order_date between date_sub(now(),interval 7 day) and now()
group by serial_code;

/*많이 팔린 순위 뽑기 추후 수정해야함*/
select count(m1.order_count) as count, m2.name, m1.serial_code, m1.order_date from member_order m1,
(select serial_code, name from Product where choice ='5') m2
where m1.serial_code=m2.serial_code and (m1.order_date between date_sub(now(),interval 7 day) and now())
group by m1.serial_code
order by 1 desc, 4 asc limit 0,5;

(select serial_code, name from Product)

select * from member

select name from member where name = '123';

/*
 * grade : 1. 일반회원 2.우수회원 3.최종 관리자(모든 권한 있음)
 */

/*
 * gender M.남자 F.여자
 */

/*
 * author : 1 회원
 * author : 2 관리자
 */
drop tabel member;
select id from member;
select * from member limit 1,10
select id from member where id ='asdasd';

select * from member;

delete from member where id ='test2';

select count(*) from member;

update member set author = '3' where id = 'admin';
update member set author = '1' where id = '13';

update member set money = 0 where id = 'test';
update member set point = 1000 where id = 'test';
update member set email = 'a@a.com' where id = 'test';

select * from member where id = 'test';

update member set pw = 'zxcvqwer' where id = 'admin';

select * from member where id ='test' and pw = 'test';2

select count(id) from member;

select now();

insert into member values('1','1','1','1','1','1','1','2000/11/11','M','1',1,'2000/11/11',0,default,'1');
insert into member values('2','1','1','1','1','1','1','2000/11/11','M','1',2,'2000/11/11',0,default,'1');
insert into member values('3','1','1','1','1','1','1','2000/11/11','M','1',3,'2000/11/11',0,default,'1');
insert into member values('4','1','1','1','1','1','1','2000/11/11','M','1',4,'2000/11/11',0,default,'1');
insert into member values('5','1','1','1','1','1','1','2000/11/11','M','1',5,'2000/11/11',0,default,'1');
insert into member values('6','1','1','1','1','1','1','2000/11/11','M','1',6,'2000/11/11',0,default,'1');
insert into member values('7','1','1','1','1','1','1','2000/11/11','M','1',7,'2000/11/11',0,default,'1');
insert into member values('8','1','1','1','1','1','1','2000/11/11','M','1',8,'2000/11/11',0,default,'1');
insert into member values('9','1','1','1','1','1','1','2000/11/11','M','1',9,'2000/11/11',0,default,'1');
insert into member values('10','1','1','1','1','1','1','2000/11/11','M','1',10,'2000/11/11',0,default,'1');
insert into member values('11','1','1','1','1','1','1','2000/11/11','M','1',11,'2000/11/11',0,default,'1');
insert into member values('12','1','1','1','1','1','1','2000/11/11','M','1',12,'2000/11/11',0,default,'1');
insert into member values('13','1','1','1','1','1','1','2000/11/11','M','1',13,'2000/11/11',0,default,'1');
insert into member values('14','1','1','1','1','1','1','2000/11/11','M','1',14,'2000/11/11',0,default,'1');
insert into member values('15','1','1','1','1','1','1','2000/11/11','M','1',15,'2000/11/11',0,default,'1');
insert into member values('16','1','1','1','1','1','1','2000/11/11','M','1',16,'2000/11/11',0,default,'1');
insert into member values('17','1','1','1','1','1','1','2000/11/11','M','1',17,'2000/11/11',0,default,'1');
insert into member values('18','1','1','1','1','1','1','2000/11/11','M','1',18,'2000/11/11',0,default,'1');
insert into member values('19','1','1','1','1','1','1','2000/11/11','M','1',19,'2000/11/11',0,default,'1');
insert into member values('20','1','1','1','1','1','1','2000/11/11','M','1',20,'2000/11/11',0,default,'1');
insert into member values('21','1','1','1','1','1','1','2000/11/11','M','1',21,'2000/11/11',0,default,'1');
insert into member values('22','1','1','1','1','1','1','2000/11/11','M','1',22,'2000/11/11',0,default,'1');
insert into member values('23','1','1','1','1','1','1','2000/11/11','M','1',23,'2000/11/11',0,default,'1');
insert into member values('24','1','1','1','1','1','1','2000/11/11','M','1',24,'2000/11/11',0,default,'1');
insert into member values('25','1','1','1','1','1','1','2000/11/11','M','1',25,'2000/11/11',0,default,'1');
insert into member values('26','1','1','1','1','1','1','2000/11/11','M','1',26,'2000/11/11',0,default,'1');
insert into member values('27','1','1','1','1','1','1','2000/11/11','M','1',27,'2000/11/11',0,default,'1');
insert into member values('28','1','1','1','1','1','1','2000/11/11','M','1',28,'2000/11/11',0,default,'1');
insert into member values('29','1','1','1','1','1','1','2000/11/11','M','1',29,'2000/11/11',0,default,'1');
insert into member values('30','1','1','1','1','1','1','2000/11/11','M','1',30,'2000/11/11',0,default,'1');
insert into member values('31','1','1','1','1','1','1','2000/11/11','M','1',31,'2000/11/11',0,default,'1');
insert into member values('32','1','1','1','1','1','1','2000/11/11','M','1',32,'2000/11/11',0,default,'1');
insert into member values('33','1','1','1','1','1','1','2000/11/11','M','1',33,'2000/11/11',0,default,'1');
insert into member values('34','1','1','1','1','1','1','2000/11/11','M','1',34,'2000/11/11',0,default,'1');
insert into member values('35','1','1','1','1','1','1','2000/11/11','M','1',35,'2000/11/11',0,default,'1');

delete from member where id ='13';
/*회원 고유 번호*/
select concat(date_format(sysdate(),'%y%m%d%i%S')) from member;

SELECT LPAD('1',5,'0');

/*member_id fk*/


CREATE TABLE Notice_review (
  Notice_review_contents VARCHAR(200) NOT NULL,
  member_id VARCHAR(20) NOT NULL,
  Notice_num INT NOT NULL
)
/*member_id, Notice_num fk*/

/*member_id fk*/

/*포인트 사용 내역 뽑기*/
create table member_point_order (
point_number int NOT NULL,
point int NOT NULL,
point_status char(1) NOT NULL,
point_date DATETIME NOT NULL,
id VARCHAR(20) NOT NULL,
serial_code int NOT NULL,
PRIMARY KEY (point_number)
)
/*point_status I 들어옴 / O 나감 / R 환불*/

select * from member_point_order
select * from member_point_order where id ='test' and point_date='2021-10-18 21:08:25' and serial_code = 10120211;

select * from member_point_order where id ='test' and point_date='2021-10-18 20:34:47' and serial_code = 10120007;

select * from member_point_order where point_status='O' and point_date='2021-10-18 20:38:36' and serial_code = 10120211 and id ='test';

select * from member_point_order m1, (select serial_code, name from Product) m2
where m1.serial_code = m2.serial_code and id ='test'
order by point_date desc limit 0,10 ;


select distinct serial_code from member_point_order

drop table  member_point_order

/*아이스크림 + 물건 합치기*/

/*물건*/
CREATE TABLE Product (
  serial_code int NOT NULL,
  name VARCHAR(200) NOT NULL,
  kcal INT NULL,
  allergy VARCHAR(200) NULL,
  price INT NULL,
  choice CHAR(1) NOT NULL,
  status CHAR(1) NOT NULL,
  PI_date DATE NOT NULL,
  count INT NULL,
  id VARCHAR(20) NOT NULL,
  PRIMARY KEY (serial_code)
)
select count(*) from Product where choice ='4';

select * from Product;

drop table Product
/*아이스크림 가격 통일 할지 의문 */
/*콘 : 싱글레귤러 3,200원 / 싱글킹 4,000원 / 더블주니어 4,300원 / 더블 레귤러 6,200원 */
/*팩 : 파인트 8,200원 / 쿼터 15,500원  / 패밀리 22,000원 / 하프갤런 26,500원 */
/*등록 예시*/

/*아이스크림*/
insert into Product values(10120007,'바닐라',246,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10120116,'31요거트',198,'우유,대두',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10120211,'바람과함께사라지다',275,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10122240,'베리베리스트로베리',201,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10122542,'북극곰폴라베어',206,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10122646,'사랑에빠진딸기',298,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10123028,'그린티',245,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10123801,'뉴욕치즈케이크',234,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10124445,'레드라즈베리소르베',189,'우유',4000,'5','O','2021-10-12',0,'admin');
insert into Product values(10124737,'민트초콜릿칩',201,'우유',4000,'5','O','2021-10-12',0,'admin');

/*음료*/
insert into Product values(10121604,'꼬북칩초코츄러스블라스트',510,'우유,대두',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10122507,'자두블라스트',506,'없음',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10122729,'레몬라임블라스트',499,'없음',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10123706,'맥심모카골드블라스트',502,'우유',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10123948,'민트초코봉봉블라스트',508,'우유',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10124047,'밀크쉐이크',472,'우유',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10124155,'복숭아아이스티',488,'없음',2000,'2','O','2021-10-12',0,'admin');
insert into Product values(10124329,'스위스미스핫초코',489,'우유',4500,'2','O','2021-10-12',0,'admin');
insert into Product values(10124450,'오레오쉐이크',542,'우유',5100,'2','O','2021-10-12',0,'admin');
insert into Product values(10124606,'체리초코쥬빌레블라스트',513,'없음',5100,'2','O','2021-10-12',0,'admin');

/*아이스크림케이크*/
insert into Product values(10120200,'나눠먹는와츄원',1935,'우유,대두,밀,계란',32000,'1','O','2021-10-12',0,'admin');
insert into Product values(10120458,'나눠먹는큐브와츄원',1935,'우유,대두,밀,계란',32000,'1','O','2021-10-12',0,'admin');
insert into Product values(10120906,'듀얼와츄원NO9',2125,'우유,대두,밀,계란',30000,'1','O','2021-10-12',0,'admin');
insert into Product values(10122249,'리얼27큐브',2171,'우유,대두,밀,계란',28000,'1','O','2021-10-12',0,'admin');
insert into Product values(10122432,'바로먹는와츄원',2142,'우유,대두,밀,계란',26000,'1','O','2021-10-12',0,'admin');
insert into Product values(10122631,'스마일스노우블러섬',1820,'우유,대두,밀,계란',28000,'1','O','2021-10-12',0,'admin');
insert into Product values(10123046,'해피스마일플라워',2025,'우유,대두,밀,계란',26000,'1','O','2021-10-12',0,'admin');
insert into Product values(10123356,'빙그르르마카롱',2145,'우유,대두,밀,계란',25000,'1','O','2021-10-12',0,'admin');
insert into Product values(10123537,'시크릿라이언',1823,'우유,대두,밀,계란',28000,'1','O','2021-10-12',0,'admin');
insert into Product values(10125533,'골라먹는와츄원',1677,'우유,대두,밀,계란',26000,'1','O','2021-10-12',0,'admin');

/*커피*/
insert into Product values(10120138,'아이스카라멜마끼야또',190,'없음',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10120314,'아이스카페라떼',125,'우유',3000,'3','O','2021-10-12',0,'admin');
insert into Product values(10120522,'아이스카페모카',215,'우유,대두',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10120949,'연유라떼',285,'우유',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10121131,'연유크러쉬라떼',425,'우유',3800,'3','O','2021-10-12',0,'admin');
insert into Product values(10121257,'카라멜마끼야또',230,'우유',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10121449,'카페모카',250,'우유,대두',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10125156,'아이스아메리카노L',15,'없음',4600,'3','O','2021-10-12',0,'admin');
insert into Product values(10125510,'아이스바닐라빈라떼',155,'우유',3500,'3','O','2021-10-12',0,'admin');
insert into Product values(10125801,'아이스연유라떼',160,'우유',3500,'3','O','2021-10-12',0,'admin');

/*디저트*/
insert into Product values(10122823,'미니아이스모찌',188,'우유,계란,대두',2800,'4','O','2021-10-12',0,'admin');
insert into Product values(10123158,'아빵우유',178,'우유',2800,'4','O','2021-10-12',0,'admin');
insert into Product values(10124247,'아이스마카롱체리쥬빌레',246,'밀',1500,'4','O','2021-10-12',0,'admin');
insert into Product values(10124355,'아이스마카롱쿠키앤크림',246,'밀',1500,'4','O','2021-10-12',0,'admin');
insert into Product values(10124648,'아이스모찌바나나킥',215,'밀,호두',3400,'4','O','2021-10-12',0,'admin');
insert into Product values(10124831,'아이스바나나모나카',142,'땅콩,호두',2500,'4','O','2021-10-12',0,'admin');
insert into Product values(10125057,'제주감귤아이스모찌',143,'밀,대두',2800,'4','O','2021-10-12',0,'admin');
insert into Product values(10125206,'아이스호떡',222,'밀,대두',2500,'4','O','2021-10-12',0,'admin');
insert into Product values(10125624,'아이스크림롤바닐라',96,'우유,계란,대두,밀',1500,'4','O','2021-10-12',0,'admin');
insert into Product values(10125726,'아이스크림롤초콜릿',113,'우유,계란,대두,밀',1500,'4','O','2021-10-12',0,'admin');


/*테스트*/ /*할필요없음*/

select * from member_point_order;
select * from Product;
select * from member_order;


/*포인트 사용시 막는 3개 조인*/
select m1.order_code, m1.order_price, m2.name, m2.choice, m1.order_count, m1.order_how, m1.order_date, m2.serial_code, m3.point from member_order m1,
(select serial_code, name, choice from Product) m2, (select serial_code, point from member_point_order) m3
where m1.serial_code=m2.serial_code and m2.serial_code=m3.serial_code and (order_date between date_sub(now(),interval 7 day) and now()) and id ='test'
group by m1.order_code, m2.serial_code, m2.name, m2.choice

/*총 주문 내역*/
select m1.order_code, m1.order_price, m2.name, m2.choice, m1.order_count, m1.order_how, m1.order_date, m2.serial_code from member_order m1,
(select serial_code, name, choice from Product) m2
where m1.serial_code=m2.serial_code  and (order_date between date_sub(now(),interval 7 day) and now()) and id ='test'
group by m1.order_code, m2.serial_code, m2.name, m2.choice


select serial_code, name, kcal, allergy, price, choice, status, PI_date, count, id from product where choice = 5 limit 0,10

/*물건 이미지(컬럼) 혹시 몰라서 뺴둠*/
/*물건 고유 번호 object(2) + sysdate(2000/12/20) + start(1)*/
/*Product_status 물건이 있으면 I 없으면 O*/

/*Product_choice 1 : 케이크 / 2 : 음료 / 3.커피 / 4.디저트 / 5. 아이스크림 */

select date_format(sysdate(),'%m%d') from Product;

select concat(2,date_format(sysdate(),'%m%d%i%S'))
delete from Product where Product_choice = '3';

delete from Product where Product_choice = '4';

drop table Product

select * from Product;

select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m1.id, m2.serial_code
from member_order m1, (select serial_code, name from product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 7 day) and now()) and m1.id ='test'
group by m1.order_code, m2.serial_code, m2.name, m1.id

select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m2.serial_code from member_order m1,
(select serial_code, name from product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 7 day) and now())and m1.id ='test'
group by m1.order_code, m2.serial_code, m2.name
order by 1 asc limit 0,2;

select * from member_order;

select count(*) from member_order m1, (select serial_code, name from product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 7 day) and now())and m1.id ='test'

select count(*) from member_order m1, (select serial_code, name from product) m2 
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 6 month) and now()) and m1.id = 'test'

select count(*) from member_order m1, 
(select serial_code, name from product) m2 
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 6 month) and now())

select count(*) as serial_code_count, serial_code
from member_order
group by serial_code
order by 1 desc

(select count(*) as serial_code_count, serial_code from member_order
group by serial_code)

CREATE TABLE IO (
  IO_index INT NOT NULL,
  IO_inout CHAR(1) NOT NULL,
  IO_count INT NULL,
  IO_date DATETIME NOT NULL,
  serial_code int not null default 0,
  PRIMARY KEY (IO_index)
)

select * from IO m1, (select serial_code, name from product) m2
where m1.serial_code=m2.serial_code
group by m1.IO_index
order by 1 asc limit 0,20


/*product_code, icecream_code fk*/
/*IO_status : 입고 I / 출고 O*/

drop table IO;

select count(IO_index)+1 from IO

select * from IO

drop table IO

--select IO_index, IO_status,IO_count, IO_date, icecream_code
--from IO natural join icecream

--drop table IO

/*수정해야함*/
CREATE TABLE object_review (
  member_id VARCHAR(20) NOT NULL,
  object_object_code INT NOT NULL,
  object_review VARCHAR(200) NULL,
  object_review_grade INT NULL  
)
/*member_id fk*/

select * from member_order;

/*주문 내역 한개씩 등록 */
CREATE TABLE member_order (
  order_code INT NOT NULL,
  order_price INT NOT NULL,
  order_count INT NOT NULL,
  order_how CHAR(1) NOT NULL,
  order_date DATETIME NULL,
  id VARCHAR(20) NOT NULL,
  serial_code int not null default 0
)
/*member_id, Product_code, icecream_code fk*/
/*order_how  주문 방식 1.매장(오프라인) 2.배달(온라인)*/
select ifnull(max(order_code),0)+1 from member_order

drop table member_order

select * from member_order;

select sum(order_price*order_count) as totalPrice from member_order;

select date_format(sysdate(),'%y%m%d%i%S');
select * from member_order

select * from member_order where id ='test';

/*주간 아이스크림 순위 5개*/
select count(order_count) as order_cout,serial_code from member_order
where order_date between date_sub(now(),interval 7 day) and now()
group by serial_code
order by 1 desc;

select count(*), serial_code from member_order
group by serial_code;

/*test*/
insert into member_order values (103,200000,20,'1','2021-09-25','test',109294343);

select * from member_order;

select serial_code, name, kcal, allergy, price, choice, status, PI_date, count, id
from Product
where choice = 3
order by 1 asc limit 1,10

select sum(money) from member;

select * from member_order where id = 'test';
/*date_sub 빼기 / date_add 더하기*/
/*주문 내역 이름 뽑기*/
select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m2.serial_code from member_order m1,
(select serial_code, name from product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 2 day) and now())
group by m1.order_code, m2.serial_code, m2.name;

select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m1.id, m2.serial_code from member_order m1,
(select serial_code, name from Product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 6 month) and now())
group by m1.order_code, m2.serial_code, m2.name;

select m1.order_code, m1.order_price, m2.name, m1.order_count, m1.order_how, m1.order_date, m2.serial_code from member_order m1,
(select serial_code_i as serial_code, name from icecream
union
select serial_code_p as serial_code, name from product) m2
where m1.serial_code=m2.serial_code and (order_date between date_sub(now(),interval 7 day) and now())
group by m1.order_code, m2.serial_code, m2.name;


select * from member_order where order_date between date_sub(now(),interval -1 day) and now();


select serial_code_i as serial_code, name from icecream

union

select serial_code_p as serial_code, name from product;

select id, serial_code from member_order where serial_code='109294343';

drop table member_order;

/*배송 단계 오프라인으로 할시*/
CREATE TABLE order_summary (
  order_summary_process VARCHAR(1) NOT NULL,
  order_code INT NOT NULL
)
/*order_code fk*/
/*order_summary_process 주문상태  관리자 페이지에서 처리해줘야함*/


/*member_id fk*/

/*추후 업데이트*/
CREATE TABLE basket (
  basket_num INT NOT NULL,
  basket_name VARCHAR(20) NOT NULL,
  basket_choice CHAR(1) NOT NULL,
  basket_count INT NULL,
  basket_date DATE NOT NULL,
  id VARCHAR(20) NOT NULL
)
drop table basket
/*member_id fk*/

select ifnull(max(basket_num),0)+1 from basket

select * from basket where id= ?;

(select ifnull(max(basket_num),0)+1 from basket)

select * from basket

insert into basket values (2,'1','4',100,now(),'test');
--이걸로 딜리트 하고

CREATE TABLE Notice (
  Notice_num INT NOT NULL,
  Notice_title VARCHAR(50) NOT NULL,
  Notice_contents VARCHAR(1000) NULL,
  Notice_readcount INT NULL DEFAULT 0,
  Notice_date DATETIME NOT NULL,
  Notice_file varchar(50) null,
  id VARCHAR(20) NOT NULL,
  primary key(Notice_num)
)

CREATE TABLE board_question (
board_num int not null,/*글번호*/
board_choice char(1) null default '1',/*공개:1,비공개 선택:2*/
q_choice char(1) not null,/*문의종류 1:배송  2:결제  3:상품  4:기타*/
board_subject Nvarchar(20) not null,/*글제목*/
board_content Nvarchar(2000) not null,/*글내용*/
board_file varchar(50) null,/*사진파일*/
board_re int not null,/*답변글*/
board_re_loc int not null,/*답변글 위치*/
board_re_seq int not null,/*관련글 출력 순서*/
board_date date,/*작성일자*/
id varchar(20) not null,/*작성자id*/
primary key(board_num)
)

select IFNULL(max(board_num),0)+1 from board_question

--CREATE TABLE basket (
--  basket_num INT NOT NULL,
--  basket_choice CHAR(1) NULL,
--  member_id VARCHAR(20) NOT NULL,
--  PRIMARY KEY (basket_num) 
--)

--CREATE TABLE basket_detail (
--  basket_detail_name VARCHAR(20) NOT NULL,
--  basket_detail_choice CHAR(1) NOT NULL,
--  basket_detail_count INT NULL,
--  basket_detail_date DATE NOT NULL,
--  basket_basket_num INT NOT NULL
--)
