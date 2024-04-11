BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, images, posts CASCADE;

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

CREATE TABLE posts(
	post_id SERIAL,
	caption text,
	post_creator varchar(100) NOT NULL,
	CONSTRAINT PK_posts PRIMARY KEY(post_id),
	CONSTRAINT FK_posts_users FOREIGN KEY(post_creator) REFERENCES users(username)
);

CREATE TABLE images(
	image_id SERIAL,
	image_path varchar(200) NOT NULL,
	image_type varchar(50) NOT NULL,
	post_id int NOT NULL,
	CONSTRAINT FK_images_posts FOREIGN KEY(post_id) REFERENCES posts(post_id),
	CONSTRAINT PK_images PRIMARY KEY (image_id)
);

INSERT INTO users (username, password_hash, email, avatar, name, role) VALUES ('billy', '1234billy1', 'billy@email.com', '', '', 'USER');
INSERT INTO posts (caption, post_creator) VALUES ('this is post 1', 'billy');
INSERT INTO images (image_path, image_type, post_id) VALUES ('thispath/path', 'jpeg', 1); 

COMMIT TRANSACTION;
--ROLLBACK;










