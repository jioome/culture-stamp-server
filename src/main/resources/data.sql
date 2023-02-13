insert into user (nickname, login_id, email, password, last_login_at, fail_count, role)
values ( '별명1', 'test1', '이메일@naver.com', 'password1', now(), 0, 'USER');

insert into category(category_name, review_count, user_id)
values ('Movie', 0, 1);

insert into review(category_id, user_id, created_at, updated_at, content, companion, location, performed_date, price, rating, title )
values ( 1, 1, now(), now(), '내용1', '친구', 'CGV', now(), 10000, 5, '제목1' );

insert into review(category_id, user_id, created_at, updated_at, content, companion, location, performed_date, price, rating, title )
values ( 1, 1, now(), now(), '내용2', '친구', 'CGV', now(), 10000, 5, '제목2' );

insert into review(category_id, user_id, created_at, updated_at, content, companion, location, performed_date, price, rating, title )
values ( 1, 1, now(), now(), '내용3', '친구', 'CGV', now(), 10000, 5, '제목3' );
