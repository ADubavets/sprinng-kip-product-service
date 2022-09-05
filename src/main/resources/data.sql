insert into role(name) values ('ADMIN');
insert into role(name) values ('GUEST');
insert into role(name) values ('USER');
insert into role(name) values ('CREATOR');
insert into role(name) values ('EDITOR');

insert into calendar(name) values ('CALENDAR DAYS');
insert into calendar(name) values ('WORKING DAYS');

insert into status(name) values ('AGREEMENT');
insert into status(name) values ('WORK');
insert into status(name) values ('ARCHIVE');
insert into status(name) values ('REJECTED');

insert into users(username,password,email,first_name,last_name,enabled) values ('admin','admin','admin@gmail.com','John','Doe',true);
insert into users(username,password,email,first_name,last_name,enabled) values ('guest','guest','guest@gmail.com','Петр','Петров',true);

insert into users_roles(user_id,role_id) values(1,1);
insert into users_roles(user_id,role_id) values(1,3);
insert into users_roles(user_id,role_id) values(2,2);

insert into customers(firm, address, email, telephone, leadermanager) values ('ООО Миг','Минск','mail@mail.com','+555-88-99','Иванов Иван Иванович');