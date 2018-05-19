--user表的创建
create table ques_user(userid number(10) constraint ques_user_userid_pk primary key,
gender char(2)  not null,
role char(1)not null,
username varchar2(15) not null,
password char(16) not null,
birth date not null,
phonenum char(11),
email varchar2(50),
unique(username),unique(phonenum),unique(email));

--paper表的创建
create table ques_paper(paperid number(13) primary key,
papername varchar2(20),
unuseracc clob,
preuseracc clob,
removetime timestamp,
userid number(10) references ques_user(userid) not null,
createtime timestamp not null,
resultmessage clob);

--question表的创建
create table ques_question(questionid number(13) primary key,
question varchar2(100) not null,
choose varchar2(200) not null,
result clob);

--paper-question桥表的创建
create table ques_question_paper(paperid number(13) references ques_paper(paperid) not null,
questionid number(13) references ques_question not null,
userid number(10) references ques_user(userid),
filltime date,
pastresult clob);

--序列的创建
create sequence ques_seq
start with 1000
increment by 1
maxvalue 1000000000;