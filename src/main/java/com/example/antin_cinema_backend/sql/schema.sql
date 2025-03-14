create database antin_cinema;
use antin_cinema;

create table users(
	uid int auto_increment primary key,
    name varchar(64),
    dob date,
    gender varchar(1),
    phone varchar(16) unique,
    email varchar(50) unique,
    username varchar(64) unique,
    password varchar(128),
    avatar text,		
    points int,
    status int,
    role varchar(1)
);

create table khach(
	kid int auto_increment primary key,
    fullname varchar(64),
    phone varchar(16),
    email varchar(50)
);

create table movie_type(
	mtid int auto_increment primary key,
    movie_type_name varchar(64)
);

create table movie_rated(
	mrid int auto_increment primary key,
    movie_rated_name varchar(100)
);

create table movie_language(
	mlid int auto_increment primary key,
    movie_language_name varchar(50)
);

create table movie(
	mid int auto_increment primary key,
    movie_name varchar(50) unique,
    movie_description text,
    movie_director varchar(50),
    movie_actor varchar(128),
    mtid int,
    foreign key (mtid) references movie_type(mtid),
    movie_time varchar(24),
    mlid int,
    foreign key (mlid) references movie_language(mlid),
    mrid int,
    foreign key (mrid) references movie_rated(mrid),
    poster text,
    banner text,
    openday date,
    closeday date,
    movie_status int
);

create table room(
	rid int auto_increment primary key,
    room_name int
);

create table movie_showtime(
	msid int auto_increment primary key,
    mid int,
    foreign key (mid) references movie(mid),
    rid int,
    foreign key (rid) references room(rid),
    start_time datetime,
    end_time datetime
);

create table seat_type(
	stid int auto_increment primary key,
    seat_type_name varchar(64)
);

create table seat(
	sid int auto_increment primary key,
	rid int,
    foreign key (rid) references room(rid),
    seat_location varchar(16),
    stid int,
    foreign key (stid) references seat_type(stid),
    seat_price float
);

create table discount(
	discount_id int auto_increment primary key,
    discountCode varchar(64),
    discountDescription varchar(255),
    discountPercentage int,
    start_date date,
    end_date date,
    min_ticket_quantity int,
    max_ticket_quantity int,
	max_discount_amount int,
    status int
);

create table booking(
	bid int auto_increment primary key,
    date timestamp,
    uid int,
    foreign key (uid) references users(uid),
    msid int,
    foreign key(msid) references movie_showtime(msid),
    sid int,
    foreign key(sid) references seat(sid),
    discount_id int,
    foreign key(discount_id) references discount(discount_id),
    totalprice float,
    status tinyint,
    vnpay_data json
);