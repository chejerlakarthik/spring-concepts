create table dbo.ASSETS (ASSET_ID  bigserial not null, ASSET_TYPE varchar(255), employee_EMP_ID int4, primary key (ASSET_ID));
create table dbo.DEPARTMENT (DEPARTMENT_ID  serial not null, DEPARTMENT_NAME varchar(255), DEPARTMENT_DESC varchar(255), primary key (DEPARTMENT_ID));
create table dbo.EMPLOYEE (EMP_ID  serial not null, CUBICLE_ID int8, EMP_NAME varchar(255), EMP_EMPLOYER varchar(255), salary float8, DEPARTMENT_ID int4, primary key (EMP_ID));
create table dbo.EMPLOYEE_ASSETS (EMP_ID int4 not null, ASSET_ID int8 not null);
alter table dbo.DEPARTMENT add constraint uk_department_name unique (DEPARTMENT_NAME);
alter table dbo.EMPLOYEE add constraint uk_cubicle unique (CUBICLE_ID);
alter table dbo.EMPLOYEE_ASSETS add constraint UK_3jniya4k7x7bfvo7lkvpjq4l5 unique (ASSET_ID);
alter table dbo.ASSETS add constraint FKsrya1i796si1f2mdwm3jc775k foreign key (employee_EMP_ID) references dbo.EMPLOYEE;
alter table dbo.EMPLOYEE add constraint FKfvt83ye0flecxfewcniue0n9n foreign key (DEPARTMENT_ID) references dbo.DEPARTMENT;
alter table dbo.EMPLOYEE_ASSETS add constraint FKoxn8s9xnw9khcic3tr4hkcu7t foreign key (ASSET_ID) references dbo.ASSETS;
alter table dbo.EMPLOYEE_ASSETS add constraint FKnn2tnkxdqg0r87i5qul8uli8c foreign key (EMP_ID) references dbo.EMPLOYEE;