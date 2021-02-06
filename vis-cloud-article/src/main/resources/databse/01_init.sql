# create database
CREATE DATABASE visArticle DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

# create user
CREATE USER 'visArticle'@'%' IDENTIFIED BY 'visArticle@Power2021';
GRANT ALL PRIVILEGES ON visArticle.* TO 'visArticle'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;