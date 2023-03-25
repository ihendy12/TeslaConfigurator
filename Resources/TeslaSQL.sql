BEGIN TRANSACTION;

DROP TABLE IF EXISTS customer, model, trim_level, exterior_color, wheel_type, interior_color,
autopilot_level, charging, tow_hitch, seat_number;

create table model (
	model_id serial,
	model_name varchar(40) not null,
	model_price int not null,
	constraint pk_model_id primary key (model_id)

);

create table trim_level (
	trim_level_id serial,
	trim_level_name varchar (40) not null,
	trim_price int not null,
	constraint pk_trim_level_id primary key (trim_level_id)
);

create table exterior_color (
	exterior_color_id serial,
	exterior_color_name varchar (40) not null,
	exterior_price int not null,
	constraint pk_exterior_color_id primary key (exterior_color_id)
);

create table wheel_type (
	wheel_type_id serial,
	wheel_type_name varchar (40) not null,
	wheel_price int not null,
	constraint pk_wheel_type_id primary key (wheel_type_id)
);

create table interior_color (
	interior_color_id serial,
	interior_color_name varchar(40) not null,
	interior_price int not null,
	constraint pk_interior_color_id primary key (interior_color_id)
);

create table autopilot_level (
	autopilot_level_id serial,
	autopilot_level_name varchar (40) not null,
	autopilot_price int not null,
	constraint pk_autopilot_level_id primary key (autopilot_level_id)
);

create table charging (
	charging_id serial,
	charging_type varchar (50) not null,
	charging_price int not null,
	constraint pk_charging_id primary key (charging_id)
);

create table tow_hitch (
	tow_hitch_id serial,
	has_tow boolean not null,
	constraint pk_tow_hitch_id primary key (tow_hitch_id)
);

create table seat_number (
	seat_id serial,
	number_of_seats int not null,
	constraint pk_seat_id primary key (seat_id)
);

create table customer (
	customer_id serial,
	model_id int not null,
	trim_level_id int not null,
	exterior_color_id int not null,
	wheel_type_id int null,
	interior_color_id int not null,
	autopilot_level_id int not null,
	charging_id int not null,
	tow_hitch_id int not null,
	seats int not null,
	total_price int,

	constraint pk_customer_id primary key (customer_id),
	constraint fk_model_id foreign key references model(model_id),
	constraint fk_trim_level_id foreign key references trim_level(trim_level_id),
	constraint fk_exterior_color_id foreign key references exterior_color(exterior_color_id),
	constraint fk_wheel_type_id foreign key references wheel_type(wheel_type_id),
	constraint fk_interior_color_id foreign key references interior_color(interior_color_id),
	constraint fk_autopilot_level_id foreign key references autopilot_level(autopilot_level_id),
	constraint fk_charging_id foreign key references charging(charging_id),
	constraint fk_tow_hitch_id foreign key references tow_hitch(tow_hitch_id),
	constraint fk_seat_id foreign key references seat_number(seat_id)

);


select * from customer;
select * from model;
select * from trim_level;
select * from exterior_color;
select * from wheel_type;
select * from interior_color;
select * from autopilot_level;
select * from charging;
select * from tow_hitch;
select * from seat_number

commit;

