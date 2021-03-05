`t_role`CREATE DATABASE `security` CHARACTER SET utf8;

CREATE TABLE persistent_logins (
username VARCHAR (64) NOT NULL,
series VARCHAR (64) PRIMARY KEY,
token VARCHAR (64) NOT NULL,
last_used TIMESTAMP NOT NULL
);

SELECT * FROM`persistent_logins`;

CREATE TABLE t_admin
(
id INT NOT NULL AUTO_INCREMENT,
loginacct VARCHAR(255) NOT NULL,
userpswd CHAR(32) NOT NULL,
username VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
createtime CHAR(19),
PRIMARY KEY (id)
);`t_auth`


SELECT DISTINCT t_auth.name
FROM t_auth
LEFT JOIN inner_role_auth ON t_auth.id = inner_role_auth.auth_id
LEFT JOIN inner_admin_role ON inner_admin_role.role_id = inner_role_auth.role_id
WHERE inner_admin_role.admin_id = 460 
AND t_auth.name != ""
AND t_auth.name IS NOT NULL;

SELECT * FROM t_admin;`inner_admin_role`


SELECT t_auth.name
    FROM t_auth
    LEFT JOIN inner_role_auth ON t_auth.id = inner_role_auth.auth_id
    LEFT JOIN inner_admin_role ON inner_admin_role.role_id = inner_role_auth.role_id
    WHERE inner_admin_role.admin_id = 3
    AND t_auth.name != ""
    AND t_auth.name IS NOT NULL;

