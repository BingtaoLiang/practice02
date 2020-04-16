create table user
(
	id int auto_increment,
-- 	account_id VARCHAR(100) null,
	name VARCHAR(100) null,
	password varchar(50)  not null,
	token char(36) null,
	gmt_create BIGINT null,
	constraint user_pk
		primary key (id)
);
