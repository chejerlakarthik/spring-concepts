delete from dbo.employee;
drop table dbo.employee;

create table dbo.employee( emp_id integer PRIMARY KEY, emp_name varchar(50));

insert into dbo.employee values(1, 'Karthik');
insert into dbo.employee values(2, 'Aarthi');
insert into dbo.employee values(3, 'Sanjeev');
insert into dbo.employee values(4, 'Archana');