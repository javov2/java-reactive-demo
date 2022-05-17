CREATE TABLE IF NOT EXISTS person (
	id VARCHAR(40) NOT NULL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL
);

insert into person (id, first_name, last_name, email) values ('6ac61924-49c9-4096-99fe-9cf4a8f24ea9', 'Verine', 'Athridge', 'vathridge0@jigsy.com');
insert into person (id, first_name, last_name, email) values ('ce028613-ed8a-43e0-b21b-7dcc91af5aa4', 'Ki', 'Nance', 'knance1@youku.com');
insert into person (id, first_name, last_name, email) values ('684ae37d-d72a-4565-8ff0-d6df93a2cac3', 'Vincenz', 'Schnitter', 'vschnitter2@google.com');
insert into person (id, first_name, last_name, email) values ('631d05e8-64a5-4968-96e6-0bdef4101c8e', 'Byrann', 'Tarquini', 'btarquini3@istockphoto.com');
insert into person (id, first_name, last_name, email) values ('0a285696-c5e0-4742-9446-3abd39d94154', 'Reidar', 'Betho', 'rbetho4@buzzfeed.com');
insert into person (id, first_name, last_name, email) values ('fb922dd7-9cef-463f-8cec-6731e07067e6', 'Fay', 'Chown', 'fchown5@engadget.com');
insert into person (id, first_name, last_name, email) values ('49e4c2d3-1221-48d5-81c2-c958c3a1bc4e', 'Mira', 'Mulligan', 'mmulligan6@godaddy.com');
insert into person (id, first_name, last_name, email) values ('dac752d3-f384-4a0f-bfd7-958aadf93238', 'Vonnie', 'Matteoli', 'vmatteoli7@ifeng.com');
insert into person (id, first_name, last_name, email) values ('644e62f6-d58f-4f9e-823f-22becee7ecda', 'Bevon', 'Oxton', 'boxton8@npr.org');
insert into person (id, first_name, last_name, email) values ('cc4ec3b0-172e-424e-bac1-a91b2347132b', 'Pen', 'Kiffin', 'pkiffin9@hhs.gov');

CREATE TABLE IF NOT EXISTS location (
	id VARCHAR(40) NOT NULL PRIMARY KEY,
	latitude VARCHAR(50) NOT NULL,
	longitude VARCHAR(50) NOT NULL,
	elevation INT NOT NULL
);
insert into location (id, latitude, longitude, elevation) values ('e7f89ca8-3aca-4801-9501-8c99b340335b', 45.402837, 11.8577064, 3301);
insert into location (id, latitude, longitude, elevation) values ('01de41f5-c0c7-43dd-9da1-ff0303345d14', 11.536819, 122.489398, 1277);
insert into location (id, latitude, longitude, elevation) values ('d2ffa497-82bd-431c-ae80-68bf50fd858c', -0.6801982, -47.3510778, 2989);
insert into location (id, latitude, longitude, elevation) values ('476249e8-2bd8-4bbb-b621-c547b8559b62', 45.38193, 121.593799, 5864);
insert into location (id, latitude, longitude, elevation) values ('1411ac03-6048-42ff-8974-0de26606058d', 34.520447, 50.0059337, 2880);
insert into location (id, latitude, longitude, elevation) values ('62648578-4fdd-493a-a5b5-935568928cf1', 21.8528313, 104.0836104, 5612);
insert into location (id, latitude, longitude, elevation) values ('f4d28bd1-0a66-4205-9e3f-2373442bef06', 36.905485, 140.4069331, 1411);
insert into location (id, latitude, longitude, elevation) values ('75405e9c-1d3f-487c-b312-76fa22f3d2db', 24.094765, 116.00509, 3954);
insert into location (id, latitude, longitude, elevation) values ('3f874ff9-e73a-410b-93d4-16af98f2967c', 14.5719534, 121.0344899, 4911);
insert into location (id, latitude, longitude, elevation) values ('49730d12-92d3-43a9-87bd-4d7f356e2004', 13.5353957, -88.3506468, 7586);


CREATE TABLE IF NOT EXISTS person_location (
	person_id VARCHAR(40) not NULL,
	location_id VARCHAR(40) NOT NULL,
	PRIMARY KEY(person_id, location_id)
);

insert into person_location (person_id, location_id) values ('6ac61924-49c9-4096-99fe-9cf4a8f24ea9','e7f89ca8-3aca-4801-9501-8c99b340335b');
insert into person_location (person_id, location_id) values ('ce028613-ed8a-43e0-b21b-7dcc91af5aa4','01de41f5-c0c7-43dd-9da1-ff0303345d14');
insert into person_location (person_id, location_id) values ('684ae37d-d72a-4565-8ff0-d6df93a2cac3','d2ffa497-82bd-431c-ae80-68bf50fd858c');
insert into person_location (person_id, location_id) values ('631d05e8-64a5-4968-96e6-0bdef4101c8e','476249e8-2bd8-4bbb-b621-c547b8559b62');
insert into person_location (person_id, location_id) values ('0a285696-c5e0-4742-9446-3abd39d94154','1411ac03-6048-42ff-8974-0de26606058d');
insert into person_location (person_id, location_id) values ('fb922dd7-9cef-463f-8cec-6731e07067e6','62648578-4fdd-493a-a5b5-935568928cf1');
insert into person_location (person_id, location_id) values ('49e4c2d3-1221-48d5-81c2-c958c3a1bc4e','f4d28bd1-0a66-4205-9e3f-2373442bef06');
insert into person_location (person_id, location_id) values ('dac752d3-f384-4a0f-bfd7-958aadf93238','75405e9c-1d3f-487c-b312-76fa22f3d2db');
insert into person_location (person_id, location_id) values ('644e62f6-d58f-4f9e-823f-22becee7ecda','3f874ff9-e73a-410b-93d4-16af98f2967c');
insert into person_location (person_id, location_id) values ('cc4ec3b0-172e-424e-bac1-a91b2347132b','49730d12-92d3-43a9-87bd-4d7f356e2004');