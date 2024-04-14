BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, images, posts, comments, likes CASCADE;

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

CREATE TABLE posts (
	post_id SERIAL,
	caption text,
	post_creator varchar(100) NOT NULL,
    created_on timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_posts PRIMARY KEY(post_id),
	CONSTRAINT FK_posts_users FOREIGN KEY(post_creator) REFERENCES users(username)
);

CREATE TABLE images(
	image_id SERIAL,
	image_type varchar(50) NOT NULL,
	post_id int NOT NULL,
	alt_desc varchar(100) NULL,
	CONSTRAINT FK_images_posts FOREIGN KEY(post_id) REFERENCES posts(post_id),
	CONSTRAINT PK_images PRIMARY KEY (image_id)
);

CREATE TABLE comments(
	comment_id SERIAL,
	post_id int NOT NULL,
    text text NOT NULL,
    author_name varchar(100) NOT NULL,
    created_on timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_comments_posts FOREIGN KEY(post_id) REFERENCES posts(post_id),
    CONSTRAINT FK_comments_users FOREIGN KEY(author_name) REFERENCES users(username),
	CONSTRAINT PK_comments PRIMARY KEY (comment_id)
);

CREATE TABLE likes(
	post_id int NOT NULL,
    author_name varchar(100) NOT NULL,
	CONSTRAINT FK_likes_posts FOREIGN KEY(post_id) REFERENCES posts(post_id),
    CONSTRAINT FK_likes_users FOREIGN KEY(author_name) REFERENCES users(username),
	CONSTRAINT PK_likes PRIMARY KEY (post_id, author_name)
);

INSERT INTO users (username, password_hash, email, avatar, name, role) VALUES ('billy', '1234billy1', 'billy@email.com', '', '', 'USER');
INSERT INTO users (username, password_hash, email, avatar, name, role) VALUES ('ben', '1234billy1', 'ben@email.com', '', '', 'USER');
INSERT INTO posts (caption, post_creator) VALUES ('this is post 1', 'billy');
INSERT INTO likes (post_id, author_name) VALUES (1, 'ben');
INSERT INTO comments (post_id, author_name, text) VALUES (1, 'ben', 'This is fabulous!!');
INSERT INTO images (image_type, post_id) VALUES ('jpeg', 1);

COMMIT TRANSACTION;
--ROLLBACK;










