CREATE TABLE t_menu(
	id INT(11) NOT NULL AUTO_INCREMENT,
	pid INT(11),
	NAME VARCHAR(200),
	url VARCHAR(200),
	icon VARCHAR(200),
	PRIMARY KEY(id)
);

INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('1',NULL,'系统权限菜单','glyphicon
glyphicon-th-list',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('2','1',' 控制面板','glyphicon
glyphicon-dashboard','main.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('3','1','权限管理','glyphicon glyphicon
glyphicon-tasks',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('4','3',' 用户维护','glyphicon
glyphicon-user','user/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('5','3',' 角色维护','glyphicon
glyphicon-king','role/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('6','3',' 菜单维护','glyphicon
glyphicon-lock','permission/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('7','1',' 业务审核','glyphicon
glyphicon-ok',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('8','7',' 实名认证审核','glyphicon
glyphicon-check','auth_cert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('9','7',' 广告审核','glyphicon
glyphicon-check','auth_adv/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('10','7',' 项目审核','glyphicon
glyphicon-check','auth_project/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('11','1',' 业务管理','glyphicon
glyphicon-th-large',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('12','11',' 资质维护','glyphicon
glyphicon-picture','cert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('13','11',' 分类管理','glyphicon
glyphicon-equalizer','certtype/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('14','11',' 流程管理','glyphicon
glyphicon-random','process/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('15','11',' 广告管理','glyphicon
glyphicon-hdd','advert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('16','11',' 消息模板','glyphicon
glyphicon-comment','message/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('17','11',' 项目分类','glyphicon
glyphicon-list','projectType/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('18','11',' 项目标签','glyphicon
glyphicon-tags','tag/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('19','1',' 参数管理','glyphicon
glyphicon-list-alt','param/index.htm');

SELECT * FROM t_menu;