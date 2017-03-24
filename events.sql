CREATE  TABLE event
(
EventID number(10,0) NOT NULL,
EventName varchar(255),
EventDis varchar(255),
owner varchar(255),
startTime number(19,0),
endTime number(19,0),
venue varchar(255),
groupName varchar(255),
primary key(EventID)
);

create table users 
(
username varchar(255),
pwd varchar(255),
role varchar(255)
);
Insert into users values('ramesh','password','admin');
Insert into users values('suresh','finaculas','admin');
Insert into users values('raja','mypwd','admin');