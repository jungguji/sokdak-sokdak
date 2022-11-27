insert into member(email, nickname, password, profile_image, create_date, update_date) values('jg.ji@gmail.com', '연못지', 'qweqweqwe', 'https://google.co.kr', now(), now());
insert into member(email, nickname, password, profile_image, create_date, update_date) values('test@naver.com', '테스트트', 'qweqweqwe', 'https://google.co.kr', now(), now());
insert into member(email, nickname, password, profile_image, create_date, update_date) values('test2@naver.com', '모임가입된유저', 'qweqweqwe', 'https://google.co.kr', now(), now());

insert into groups(logo, name) values('https://lh3.googleusercontent.com/ogw/AOh-ky2i3VOnTBNNQlBOE5pFtOZxT3y71YZfGlpA7Omm=s32-c-mo', '기본 생성 모임 1호');

insert into member_group(member_id, group_id) values(3, 1);

insert into place(name, road, zip, location) values('흥인지문', '서울 종로구 종로 288 흥인지문', '03119', 'POINT (127.0095452 37.5711389)');