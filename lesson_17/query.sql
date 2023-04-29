create database otus_demo;

create table od_questions
(id_question serial primary key,
 nm_question varchar(200) not null unique);

create table od_answers
(id_answer serial primary key,
 nm_answer varchar(200) not null unique);

create table od_answers_to_questions
(id_question integer not null,
 id_answer integer not null,
 vl_order integer not null,
CONSTRAINT od_a_to_q_key PRIMARY KEY(id_question, id_answer),
CONSTRAINT od_a_to_q_fk1 FOREIGN KEY (id_question)
    REFERENCES od_questions(id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
CONSTRAINT od_a_to_q_fk2 FOREIGN KEY (id_answer)
    REFERENCES od_answers(id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE);

create table od_correct_answ_for_quest
(id_question integer not null,
 id_answer integer not null,
CONSTRAINT od_correct_answ_key PRIMARY KEY(id_question, id_answer));


insert into od_questions (id_question, nm_question)
values (1, 'Какой народ, кивая утвердительно, имеет в виду «нет» и наоборот?'),
       (2, 'Какое из списка этих древних имен относится к мужским?'),
	   (3, 'Какая приправа производится из сушеной коры вечнозеленых деревьев?');
 
insert into od_answers(id_answer, nm_answer)
values (1, 'Китайцы'),
       (2, 'Болгары'),
	   (3, 'Финны'),
	   (4, 'Казахи'),
	   (5, 'Лиа'),
	   (6, 'Иохаведа'),
	   (7, 'Рахиль'),
	   (8, 'Иона'),
	   (9, 'Шафран'),
	   (10, 'Гвоздика'),
	   (11, 'Корица'),
	   (12, 'Горчица');

insert into od_answers_to_questions (id_answer, id_question, vl_order)
values (1, 1, 1),
       (2, 1, 2),
	   (3, 1, 3),
	   (4, 1, 4),
	   (5, 2, 1),
	   (6, 2, 2),
	   (7, 2, 3),
	   (8, 2, 4),
	   (9, 3, 1),
	   (10, 3, 2),
	   (11, 3, 3),
	   (12, 3, 4);

insert into od_correct_answ_for_quest (id_question, id_answer)
values (1, 2),
       (2, 8),
	   (3, 11);
	   
select q.id_question,
       q.nm_question,
	   oa.nm_answer, 
	   ocq.id_question = q.id_question and ocq.id_answer = oa.id_answer pr_correct_answer
  from od_questions q
  join od_answers_to_questions aq
    on aq.id_question = q.id_question
  join od_answers oa
    ON oa.id_answer = aq.id_answer
  left join od_correct_answ_for_quest ocq
    on ocq.id_question = q.id_question
   and ocq.id_answer = oa.id_answer
 order by q.id_question, aq.vl_order
 