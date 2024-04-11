BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	email varchar(100) NOT NULL,
	avatar varchar(200),
	name varchar(100),
	role varchar(50) NOT NULL,
	CONSTRAINT PK_users PRIMARY KEY (user_id)
);
CREATE TABLE images(
	image_id SERIAL,
	image_path varchar(200) NOT NULL,
	CONSTRAINT PK_images PRIMARY KEY (image_id)
);
COMMIT TRANSACTION;
--ROLLBACK;










