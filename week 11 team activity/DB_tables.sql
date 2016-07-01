USE ancestors;

DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS child_of;


CREATE TABLE IF NOT EXISTS people(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(32) NOT NULL,
	last_name VARCHAR(32) NOT NULL,
	dob VARCHAR(32) NOT NULL
);


CREATE TABLE IF NOT EXISTS child_of(
	child_id int UNSIGNED NOT NULL,
	parent_id int UNSIGNED NOT NULL,
	CONSTRAINT a FOREIGN KEY (child_id) REFERENCES people(id),
	CONSTRAINT b FOREIGN KEY (parent_id) REFERENCES people(id)
);