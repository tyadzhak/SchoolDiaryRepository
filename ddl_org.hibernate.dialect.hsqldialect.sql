
    drop table person if exists;

    create table person (
        recId bigint generated by default as identity (start with 1),
        dob varbinary(255),
        firstName varchar(255),
        gender integer,
        lastName varchar(255),
        middleName varchar(255),
        primary key (recId)
    );
