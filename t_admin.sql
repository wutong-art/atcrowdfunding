`project_crowd`

USE `project_crowd`;

DROP TABLE IF EXISTS t_admin;

CREATE TABLE t_admin(
	id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
	login_acct VARCHAR(255) NOT NULL COMMENT '登录账号',
	user_pswd CHAR(32) NOT NULL COMMENT '登录密码',
	user_name VARCHAR(255) NOT NULL COMMENT '昵称',
	email VARCHAR(255) NOT NULL COMMENT '邮件地址',
	create_time CHAR(19) COMMENT '创建时间',
	PRIMARY KEY(id)
);

SELECT * FROM t_admin;