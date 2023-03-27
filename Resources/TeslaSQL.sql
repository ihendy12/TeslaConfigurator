--BEGIN TRANSACTION;

DROP TABLE IF EXISTS customer, model, trim_level, exterior_color, wheel_type, interior_color,
autopilot_level, charging, tow_hitch, seat_number;

create table model (
	model_id serial,
	model_name varchar(40) not null,
	model_price numeric (9,2) not null,
	constraint pk_model_id primary key (model_id)

);

create table trim_level (
	trim_level_id serial,
	trim_level_name varchar (40) not null,
	trim_price numeric (9,2) not null,
	constraint pk_trim_level_id primary key (trim_level_id)
);

create table exterior_color (
	exterior_color_id serial,
	exterior_color_name varchar (40) not null,
	exterior_price numeric (9,2) not null,
	constraint pk_exterior_color_id primary key (exterior_color_id)
);

create table wheel_type (
	wheel_type_id serial,
	wheel_type_name varchar (40) not null,
	wheel_price numeric (9,2) not null,
	constraint pk_wheel_type_id primary key (wheel_type_id)
);

create table interior_color (
	interior_color_id serial,
	interior_color_name varchar(40) not null,
	interior_price numeric (9,2) not null,
	constraint pk_interior_color_id primary key (interior_color_id)
);

create table autopilot_level (
	autopilot_level_id serial,
	autopilot_level_name varchar (40) not null,
	autopilot_price numeric (9,2) not null,
	constraint pk_autopilot_level_id primary key (autopilot_level_id)
);

create table charging (
	charging_id serial,
	charging_type varchar (50) not null,
	charging_price numeric (9,2) not null,
	constraint pk_charging_id primary key (charging_id)
);

create table tow_hitch (
	tow_hitch_id serial,
	tow_confirmed varchar(40) not null,
	tow_hitch_price numeric (9,2),
	constraint pk_tow_hitch_id primary key (tow_hitch_id)
);

create table seat_number (
	seat_id serial,
	number_of_seats varchar(40) not null,
	seat_price numeric (9,2),
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
	seat_id int not null,
	total_price int,

	constraint pk_customer_id primary key (customer_id),
	constraint fk_model_id foreign key (model_id) references model(model_id),
	constraint fk_trim_level_id foreign key (trim_level_id) references trim_level(trim_level_id),
	constraint fk_exterior_color_id foreign key (exterior_color_id) references exterior_color(exterior_color_id),
	constraint fk_wheel_type_id foreign key (wheel_type_id) references wheel_type(wheel_type_id),
	constraint fk_interior_color_id foreign key (interior_color_id) references interior_color(interior_color_id),
	constraint fk_autopilot_level_id foreign key (autopilot_level_id) references autopilot_level(autopilot_level_id),
	constraint fk_charging_id foreign key (charging_id) references charging(charging_id),
	constraint fk_tow_hitch_id foreign key (tow_hitch_id) references tow_hitch(tow_hitch_id),
	constraint fk_seat_id foreign key (seat_id) references seat_number(seat_id)

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
select * from seat_number;


INSERT INTO model (model_name, model_price) VALUES ('Model 3', 42990.00);
INSERT INTO model (model_name, model_price) VALUES ('Model Y', 54990.00);
INSERT INTO model (model_name, model_price) VALUES ('Model S', 89990.00);
INSERT INTO model (model_name, model_price) VALUES ('Model X', 99990.00);

INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('3 Rear Wheel Drive', 0.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('3 Long Range', 8000.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('3 Performance', 11000.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('Y Long Range', 0.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('Y Performance', 4000.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('S Regular', 0.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('S Plaid', 20000.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('X Regular', 0.00);
INSERT INTO trim_level (trim_level_name, trim_price) VALUES ('X Plaid', 10000.00);

INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('20" Cyberstream Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('22" Turbine Wheels', 5500.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('18" Aero Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('19" Sport Wheels', 1500.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('20 Uberturbine Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('19" Gemini Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('20" Induction Wheels', 2000.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('21" Uberturbine Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('19" Tempest Wheels', 0.00);
INSERT INTO wheel_type (wheel_type_name, wheel_price) VALUES ('20" Arachnid Wheels', 4500.00);

INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('3&Y Pearl White', 0.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('3&Y Midnight Silver', 1000.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('3&Y Deep Blue Metallic', 1000.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('3&Y Solid Black', 1500.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('3&Y Red Multi-Coat', 2000.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('S&X Pearl White', 0.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('S&X Midnight Silver', 1500.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('S&X Deep Blue Metallic', 1500.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('S&X Solid Black', 1500.00);
INSERT INTO exterior_color (exterior_color_name, exterior_price) VALUES ('S&X Ultra Red', 3000.00);

INSERT INTO interior_color (interior_color_name, interior_price) VALUES ('S&X Black', 0.00);
INSERT INTO interior_color (interior_color_name, interior_price) VALUES ('S&X White', 2000.00);
INSERT INTO interior_color (interior_color_name, interior_price) VALUES ('S&X Cream', 2000.00);
INSERT INTO interior_color (interior_color_name, interior_price) VALUES ('3&Y Black', 0.00);
INSERT INTO interior_color (interior_color_name, interior_price) VALUES ('3&Y White', 1000.00);

INSERT INTO autopilot_level (autopilot_level_name, autopilot_price) VALUES ('Autopilot', 0.00);
INSERT INTO autopilot_level (autopilot_level_name, autopilot_price) VALUES ('Enhanced Autopilot', 6000.00);
INSERT INTO autopilot_level (autopilot_level_name, autopilot_price) VALUES ('Full-Self Driving', 15000.00);

INSERT INTO charging (charging_type, charging_price) VALUES ('None', 0.00);
INSERT INTO charging (charging_type, charging_price) VALUES ('Mobile Bundle', 230.00);
INSERT INTO charging (charging_type, charging_price) VALUES ('Wall Connector', 425.00);

INSERT INTO seat_number (number_of_seats, seat_price) VALUES ('5 Seats', 0.00);
INSERT INTO seat_number (number_of_seats, seat_price) VALUES ('6 Seats', 6500.00);
INSERT INTO seat_number (number_of_seats, seat_price) VALUES ('X 7 Seats', 3500.00);
INSERT INTO seat_number (number_of_seats, seat_price) VALUES ('Y 7 Seats', 4000.00);

INSERT INTO tow_hitch (tow_confirmed, tow_hitch_price) VALUES ('Y Tow Hitch', 1000.00);
INSERT INTO tow_hitch (tow_confirmed, tow_hitch_price) VALUES ('X Tow Hitch', 0.00);

--commit;

