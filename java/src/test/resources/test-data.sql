BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,avatar,name,email) VALUES ('user1','user1','ROLE_USER','yourPic','name','email.com');
INSERT INTO users (username,password_hash,role,avatar,name,email)  VALUES ('user2','user2','ROLE_USER','yourPic','name','email.net');
INSERT INTO users (username,password_hash,role,avatar,name,email)  VALUES ('user3','user3','ROLE_USER','myPic','name','email.gov');

COMMIT TRANSACTION;
