create database if not exists case_study_2;
use case_study_2;
create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,
foreign key(position_id) references `position`(position_id),
education_degree_id int,
foreign key(education_degree_id) references education_degree(education_degree_id),
division_id int,
foreign key (division_id) references division(division_id)
);
create table `position`(
position_id int primary key auto_increment,
position_name varchar(45)
);
create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);
create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);
create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);
create table customer(
customer_id int primary key auto_increment,
customer_type_id int,
foreign key(customer_type_id) references customer_type(customer_type_id),
customer_name varchar(45),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45)
);
create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);
create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);
create table service(
service_id int primary key auto_increment,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,
foreign key(rent_type_id) references rent_type(rent_type_id),
service_type_id int,
foreign key(service_type_id) references service_type(service_type_id),
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);
create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);
create table contract_detail(
contract_detail_id int primary key auto_increment,
contract_id int,
foreign key(contract_id) references contract(contract_id),
attach_service_id int,
foreign key(attach_service_id) references attach_service(attach_service_id),
quantity int
);
create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int,
foreign key(employee_id) references employee(employee_id),
customer_id int,
foreign key(customer_id) references customer(customer_id),
service_id int,
foreign key(service_id) references service(service_id)
);