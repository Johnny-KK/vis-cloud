# create database
CREATE DATABASE visAdmin DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

# create user
CREATE USER 'visAdmin'@'%' IDENTIFIED BY 'visAdmin@Power2021';
GRANT ALL PRIVILEGES ON visAdmin.* TO 'visAdmin'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;