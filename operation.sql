SELECT * FROM t_admin;
ALTER TABLE `t_admin` ADD UNIQUE INDEX(`login_acct`);

CREATE TABLE t_role(
	`id` INT PRIMARY KEY,
	`name` CHAR(100)
);

SELECT * FROM t_role;