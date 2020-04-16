create table school
(
	id int auto_increment
		primary key,
	name varchar(20) not null,
	areaid int(10) null,
	constraint sch_areaid_fk
		foreign key (areaid) references area (aid)
);

