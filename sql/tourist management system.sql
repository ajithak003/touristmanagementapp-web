create table user_details(
user_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1000,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
wallet number(30) not null,
CONSTRAINT pk_user_id primary key(user_id)
);
describe user_details;
select * from user_details;
delete from user_details where user_id=1125;
alter table user_details add status varchar(30) default 'active';
--drop table users_details;
update user_details set wallet =200000 where user_id = 1040;

create table admin_details(
admin_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
CONSTRAINT pk_admin_id primary key (admin_id)
);
describe admin_details;
select * from admin_details;

insert into admin_details(name,email_id,mobile_no,password) values('ajith','ajith@admin.com',7834661290,'Ajith@123');
insert into admins_table(name,email_id,mobile_no,password) values('saruk','saruk@admin.com',8144873768,'Saruk@123');



create table package_modes (
package_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 100,
package_name varchar(100) not null,
package_price_1n number (30,2) not null,
season varchar(60) not null,
protocols varchar2(3999) not null,
description varchar2(3999) not null, 
status varchar(30) default 'active',
image varchar2(4000),
check(package_price_1n>0),
CONSTRAINT pk_package_id primary key (package_id)
);

--alter table package_modes rename column package_price_2n to package_price_1n;
alter table package_modes modify package_name varchar(500) unique ;
insert into package_modes(package_name,package_price_1n,season,protocols,description) values('usa',2000,3000,4000,'sprin');
update user_details set package_name='maldives',package_price_2n=3000,package_price_3n=5500,package_price_4n=7500,season=snow,protocols=' No restriction on interstate travel as per latest Guidelines issued by the state government
' ,description='Jammu and Kashmir is home to several valleys such as the Kashmir Valley, Chenab Valley, Sindh Valley and Lidder Valley. Some major tourist attractions in Jammu and Kashmir are Srinagar, the Mughal Gardens, Gulmarg, Pahalgam, Patnitop and Jammu.
'where package_id=100;
describe package_modes;
--drop table package_modes CASCADE CONSTRAINTS;
select * from package_modes;
alter table package_modes add image varchar2(4000);
select * from package_modes where package_name='Kashmir' and status='active';
delete from package_modes where package_id=131;

create table flights_details(
flight_no  NUMBER GENERATED ALWAYS AS IDENTITY START WITH 200,
flight_name varchar(100) not null,
depature varchar(100) not null,
destination varchar (100) not null,
depature_date_time TIMESTAMP not null,
arrival_date_time TIMESTAMP not null,
business_class_fare number (30,2) not null,
economic_class_fare number (30,2) not null,
status varchar (60) not null,
business_class_seat_status number not null,
economic_class_seat_status number not null,
check(business_class_fare>0),
check(economic_class_fare>0),
CONSTRAINT pk_flight_no primary key (flight_no)
);
update flights_details set business_class_seat_status  = 40 where flight_no  = 221;
insert into flights_details (flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status,
business_class_seat_status,economic_class_seat_status)values('spiejet' ,'bangalour','kashmir',to_date('03-01-2022 09:30','dd-mm-yyyy hh24:mi'),
to_date('03-01-2022 19:30','dd-mm-yyyy hh24:mi'),4000,3000,available,40,40);
select * from flights_details;
select * from flights_details where status=+'available';
describe flights_details;
--drop table flights_details CASCADE CONSTRAINTS;
alter table flights_details add economic_class_seat_status number default 50;
delete from flights_details where flight_no=276;

create table hotel_details(
hotel_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 600 ,
location varchar (100) not null,
hotel_name varchar(100) not null,
room_type_mid_range_price number(30,2) not null,
room_type_premium_price number(30,2) not null,
status varchar(30) default 'active',
image varchar(4000),
check(room_type_premium_price>0),
check (room_type_mid_range_price>0),
CONSTRAINT pk_hotel_id primary key (hotel_id)
);

alter table hotel_details add image varchar(4000);
alter table hotel_details modify hotel_name varchar(500) unique ;
describe hotel_details;

select * from hotel_details where location='kashmir';
delete from hotel_details where hotel_id=603;
select * from hotel_details;
--drop table hotel_details  CASCADE CONSTRAINTS;
insert into hotel_details(location,hotel_name,room_type_mid_range_price,room_type_premium_price) values('kashmir','white snow',3000,4000);
insert into hotel_details(location,hotel_name,room_type_mid_range_price,room_type_premium_price) values('kashmir','hotel cafe',2500,3750);


create table booking_details(
booking_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 300,
user_id number not null,
package_id number not null,
flight_no number not null,
hotel_id number not null,
number_of_person number not null,
start_date date not null,
end_date date  not null,
total_price number(30,2) not null,
status varchar(30) default 'confirmed',
booking_date TIMESTAMP default sysdate, 
flight_class varchar (30) not null,
hotel_room_type varchar(30) not null,
days_in_night varchar(30) not null,
package_name varchar(50) not null,
payment_details varchar(100) default 'payment successful',
no_of_room number(30)not null,
check(total_price>0),
CONSTRAINT pk_booking_id primary key (booking_id),
CONSTRAINT fk_user_id FOREIGN key (user_id) REFERENCES user_details (user_id),
CONSTRAINT fk_package_id FOREIGN key (package_id) REFERENCES package_modes (package_id),
CONSTRAINT fk_flight_no FOREIGN key (flight_no) REFERENCES flights_details (flight_no),
CONSTRAINT fk_hotel_id FOREIGN key (hotel_id) REFERENCES hotel_details (hotel_id)
);

describe booking_details;
drop table booking_details CASCADE CONSTRAINTS;
select * from booking_details;
alter table booking_details add no_of_room number(30);

create table users_feedback(
feedback_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 800,
user_id number not null,
booking_id number not null,
package_id number not null,
user_name varchar(60) not null,
package_name varchar(3999) not null,
rating number (5,2),    
describtion varchar(200),
status varchar(30) default 'active'
CONSTRAINT pk_feedback_id primary key (feedback_id),
CONSTRAINT fk_feedback_booking_id FOREIGN key (booking_id) REFERENCES booking_details (booking_id),
CONSTRAINT fk_feedback_package_id FOREIGN key (package_id) REFERENCES package_modes (package_id),
CONSTRAINT fk_feedback_user_id FOREIGN key (user_id) REFERENCES user_details (user_id)
);

alter table users_feedback add status varchar(30) default 'active';

--drop table users_feedback CASCADE CONSTRAINTS;
describe users_feedback;
select *    from users_feedback;
update booking_details set status='confirmed' where booking_id=300;
select package_name, avg(rating)as rating  from users_feedback group by package_name;

select email_id from users_table where email_id='ajith@gmail.com';
delete user_details  where email_id='hari@gmail.com';

select flight_no, flight_name,depature,destination, depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status from flights_details ;
--where to_char(depature_date_time,'dd')=21;
select * from flights_details;

--select * from flights_details where destination='kashmir' and to_char(depature_date_time,'dd-mm-yyyy')='21-12-2021';
--select u.name,u.email_id,p.package_name,f.flight_name,f. from booking_details b inner join user_details u on b.user_id=u.user_id inner join package_modes p on b.package_id = p.package_id
--inner join flights_details f on b.flight_no = f.flight_no inner join hotel_details h on b.hotel_id = h.hotel_id)as view_booking v

alter table booking_details add payment_details varchar(100) default 'payment successful';
select * from booking_details;

alter table booking_details modify package_name varchar(50) not null;
desc booking_details;
update package_modes set package_name='maldives' where package_id=120;
update user_details set wallet=10000 ;
delete booking_details where booking_id = 303;
select end_date from booking_details where booking_id=303 and SYSDATE>='23-12-2021';	




--pl sql procedures

create or replace package tour 
as 
procedure insert_package
(
pname package_modes.package_name %type,
ppackage_price_2n package_modes.package_price_2n %type,
ppackage_price_3n package_modes.package_price_3n %type,
ppackage_price_4n package_modes.package_price_4n %type,
pseason package_modes.season %type,
pprotocols package_modes.protocols %type,
pdescription package_modes.description%type,
p_status out varchar2,
p_error out varchar2
);
end tour;
/
procedure delete_package
(
pproduct_id package_modes.package_id%type,
p_status out varchar2,
p_error out varchar2
);

create or replace package body tour
as 
procedure insert_package
(
pname package_modes.package_name %type,
ppackage_price_2n package_modes.package_price_2n %type,
ppackage_price_3n package_modes.package_price_3n %type,
ppackage_price_4n package_modes.package_price_4n %type,
pseason package_modes.season %type,
pprotocols package_modes.protocols %type,
pdescription package_modes.description%type,
p_status out varchar2,
p_error out varchar2
)   
is 
begin
insert into package_modes (package_name,package_price_2n, package_price_3n,package_price_4n,season,protocols,description) 
values (pname,ppackage_price_2n,ppackage_price_3n,ppackage_price_4n,pseason,pprotocols,pdescription);
 if SQL%ROWCOUNT >0 
  then
    p_status:='inserted';
  end if;
if sql%rowcount=0
then p_status:='values not insert';
end if;
exception
  when others then
   p_status:='Somthing went wrong';
   p_error:=sqlcode ||' '|| sqlerrm;
commit;
end insert_package;
end tour;
/

declare
p_status varchar2 (300);
p_error varchar2(500);
begin
tour.insert_package('goa',5000,8000,12000,'winter','ll Arriving passengers seeking entry in the State of Goa must carry a Covid negative test 
report for a test done a maximum of 72 hours prior ','Goa is one of the most visited destinations in India, which is
extremely popular for its beaches, rave parties, nightlife, flea markets, Casinos, Lip smacking ...',p_status,p_error);
DBMS_OUTPUT.PUT_LINE(p_status||''||p_error);
end;
/
select * from products;

procedure updateProduct
procedure deleteProduct
procedure showAll

select * from user_details;
delete from user_details where user_id=1060;


select * from flights_details where status=+"available"+;
select * from package_modes ;
select * from package_modes where package_name='switzerland' and status='active';
select * from booking_details where user_id=1040 order by start_date desc;

select package_name, avg(rating)as rating  from users_feedback where package_name='kashmir' group by package_name;

select flight_no,flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare, status,business_class_seat_status,economic_class_seat_status from flights_details where flight_no=351;
update booking_details set status='cancel',payment_details='payment refunded' where user_id=1040 and to_char(start_date,'yyyy-mm-dd')='2022-01-25' and booking_id=371;