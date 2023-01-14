DROP TABLE users;
DROP TABLE docs;

CREATE TABLE users (
	u_id		VARCHAR(20)		PRIMARY KEY,
	u_pw		CHAR(20)		NOT NULL
);

CREATE TABLE docs (
	d_num		INT				PRIMARY KEY		AUTO_INCREMENT,
	d_content	TEXT			NOT NULL,
	u_id		VARCHAR(20)		NOT NULL,
	d_date		CHAR(50)		NOT NULL,
	
	FOREIGN KEY(u_id) REFERENCES users(u_id)
		ON DELETE CASCADE
);