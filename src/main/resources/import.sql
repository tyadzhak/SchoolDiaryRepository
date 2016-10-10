drop table schoolDiary.person if exists;
drop sequence hibernate_sequence if exists;
drop schema schoolDiary;


create schema schoolDiary;
create table schoolDiary.person (recId bigint not null, dob date, firstName varchar(255), gender varchar(255), lastName varchar(255), middleName varchar(255), role varchar(255), primary key (recId));
create sequence hibernate_sequence start with 1 increment by 1
