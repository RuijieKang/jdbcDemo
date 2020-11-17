delete from SBIE.PERSON;
DROP SEQUENCE SBIE.SEQ_PERSON;
create sequence SBIE.SEQ_PERSON
minvalue 1
maxvalue 999999999999999999999
start with 1
increment by 1
cache 20;

insert into SBIE.PERSON(id, name, age) values (1, 'anna',5);
insert into SBIE.PERSON(id, name, age) values (2, 'brian',10);