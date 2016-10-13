create schema school_diary if not exists;
create table school_diary.child (id bigint not null, dob date, first_name varchar(255), gender varchar(255), last_name varchar(255), middle_name varchar(255), school_id bigint, school_class_id bigint, primary key (id)) if not exists;
create table school_diary.school (id bigint not null, name varchar(255), primary key (id)) if not exists;
create table school_diary.school_class (id bigint not null, name varchar(255), curator_id bigint, school_id bigint, primary key (id)) if not exists;
create table school_diary.subject (id bigint not null, name varchar(255), school_class_id bigint, primary key (id)) if not exists;
create table school_diary.teacher (id bigint not null, dob date, first_name varchar(255), gender varchar(255), last_name varchar(255), middle_name varchar(255), school_id bigint, primary key (id)) if not exists;
create table school_diary.teacher_subject (teacher_id bigint not null, subject_id bigint not null, primary key (teacher_id, subject_id)) if not exists;
create sequence hibernate_sequence start with 1 increment by 1 if not exists;

alter table school_diary.child add constraint fk_child_school_id foreign key (school_id) references school_diary.school if not exists;
alter table school_diary.child add constraint fk_child_school_class_id foreign key (school_class_id) references school_diary.school_class if not exists;
alter table school_diary.school_class add constraint fk_school_class_curator_id foreign key (curator_id) references school_diary.teacher if not exists;
alter table school_diary.school_class add constraint fk_school_class_school_id foreign key (school_id) references school_diary.school if not exists;
alter table school_diary.subject add constraint fk_subject_school_class_id foreign key (school_class_id) references school_diary.school_class if not exists;
alter table school_diary.teacher add constraint fk_teacher_school_id foreign key (school_id) references school_diary.school if not exists;
alter table school_diary.teacher_subject add constraint fk_subject_teacher_id foreign key (subject_id) references school_diary.subject if not exists;
alter table school_diary.teacher_subject add constraint fk_teacher_subject_id foreign key (teacher_id) references school_diary.teacher if not exists;


