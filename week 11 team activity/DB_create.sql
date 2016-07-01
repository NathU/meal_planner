DROP DATABASE IF EXISTS ancestors;
CREATE DATABASE IF NOT EXISTS ancestors;

USE ancestors;

GRANT EXECUTE
    ON ancestors.*
    TO 'root'@'localhost' IDENTIFIED BY '';

