CREATE TABLE user_roles(
	role_id int PRIMARY KEY,
	role_title TEXT NOT NULL 
);

CREATE TABLE users(
	user_id serial PRIMARY KEY,
	user_name TEXT UNIQUE,
	user_password TEXT,
	first_name TEXT,
	last_name TEXT,
	role_id_fk int REFERENCES user_roles(role_id)
);

--CREATE TABLE reimbursement_type(
	--reimb_type_id int PRIMARY KEY,
	--reimbursement_type TEXT
--);

CREATE TABLE reimbursement_status(
	reimb_status_id int PRIMARY KEY,
	reimb_status TEXT NOT NULL
);

CREATE TABLE reimbursement(
	reimb_id serial PRIMARY KEY,
	reimb_amount decimal(10,2),
	reimb_description TEXT,
	--reimb_type_id_fk int REFERENCES reimbursement_type(reimb_type_id),
	user_name_fk TEXT REFERENCES users(user_name),
	reimb_status_id_fk int REFERENCES reimbursement_status(reimb_status_id)	
);


INSERT INTO user_roles (role_id, role_title) VALUES (1, 'Manager'),(2, 'Employee');

INSERT INTO users (user_name, user_password, first_name, last_name, role_id_fk)
VALUES ('ags1','password','Grant','Sheppard', 1),('idolittle','password','Ida','Dolittle', 2),
('somemgmt','password','Some','Else', 1), ('regemp','password', 'Regular','Joe', 2);

--INSERT INTO reimbursement_type (reimb_type_id, reimbursement_type) VALUES (1, 'Submitted'), (2, 'Completed'); 

INSERT INTO reimbursement_status (reimb_status_id, reimb_status) VALUES (1, 'Pending'), (2, 'Approved'),
(3, 'Denied');

INSERT INTO reimbursement (reimb_amount, reimb_description, user_name_fk, reimb_status_id_fk)
VALUES (100.00,'Travel','ags1',1); 


SELECT * FROM users;
SELECT * FROM user_roles;
--SELECT * FROM reimbursement_type;
SELECT * FROM reimbursement_status;
SELECT * FROM reimbursement;


DROP TABLE users CASCADE;
DROP TABLE user_roles CASCADE;
DROP TABLE reimbursement;
DROP TABLE reimbursement_status;
--DROP TABLE reimbursement_type CASCADE;