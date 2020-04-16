create table school_pro
(
	id int default 0 not null,
	pid int default 0 not null,
	score int null,
	primary key (id, pid),
	constraint school_pro_ibfk_1
		foreign key (id) references school (id),
	constraint school_pro_ibfk_2
		foreign key (pid) references profession (pid)
);

create index pid
	on school_pro (pid);



