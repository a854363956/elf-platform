-- 创建所属机构
INSERT INTO `elf`.`elf_base_mechanism` (`id`, `mechanism_code`, `mechanism_name`, `invalid`, `effective_date`) VALUES ('0', '0', '管理员机构', '0', '2020-11-12');

-- 创建角色
INSERT INTO `elf`.`elf_base_role` (`id`, `role_name`, `mechanism_id`, `create_date`) VALUES ('0', '系统维护角色', '0', '2018-11-21');

-- 添加人员信息
INSERT INTO `elf`.`elf_base_user` (`id`, `user_name`, `login_name`, `email`, `language`, `role_id`, `create_date`, `online`, `password`) VALUES ('0', '系统管理员', 'root', 'zhangjin0908@hotmail.com', '86', '0', '2018-11-21', '30', 'EQEDSPUEADYPQIYSPUTSQIWYEFERTSIQ');

-- 添加设备
INSERT INTO `elf`.`elf_base_equipment` (`id`, `equipment_name`, `mechanism_id`) VALUES ('0', 'PC/WEB', '0');

-- 添加设备与角色关联表
INSERT INTO `elf`.`elf_base_equipment_group` (`id`, `role_id`, `equipment_id`, `invalid`) VALUES ('0', '0', '0', '0');




-- 添加返回给前台的错误方言信息

INSERT INTO `elf`.`elf_base_language` (`id`, `country`, `key`, `msg`) VALUES ('0', '86', '1000', '无当前人员[ %s ]信息.');
INSERT INTO `elf`.`elf_base_language` (`id`, `country`, `key`, `msg`) VALUES ('1', '86', '1001', '当前人员[ %s ]未维护角色信息.');
INSERT INTO `elf`.`elf_base_language` (`id`, `country`, `key`, `msg`) VALUES ('2', '86', '1002', '用户[ %s ]输入的密码不正确.');
INSERT INTO `elf`.`elf_base_language` (`id`, `country`, `key`, `msg`) VALUES ('3', '86', '1003', '用户[ %s ]无设备登入权限.');
