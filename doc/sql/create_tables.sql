create schema rocket collate utf8mb4_general_ci;

create table sys_login_log
(
  id bigint auto_increment comment '主键'
    primary key,
  username varchar(50) null comment '登陆用户名，这里不用ID是因为可能有不存在的用户名登陆',
  login_ip varchar(50) null comment '登陆IP地址',
  login_time datetime default CURRENT_TIMESTAMP null comment '登陆时间',
  is_success bigint null comment '是否登陆成功 0-失败 1-成功',
  login_info varchar(50) null comment '登陆信息，记录登陆失败原因等',
  is_deleted int default 0 null comment '软删除字段 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '更新时间'
)
  comment '系统登录日志';

create table sys_menu
(
  id bigint auto_increment comment '主键'
    primary key,
  name varchar(50) null comment '菜单名称',
  url varchar(200) null comment '菜单地址',
  icon varchar(50) null comment '菜单图标',
  description varchar(200) null comment '菜单描述',
  pid bigint null comment '父级菜单ID',
  enabled tinyint default 1 null comment '是否可用 0-不可用 1-可用',
  is_deleted tinyint default 0 null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '最后更新时间'
)
  comment '菜单表';

create table sys_permission
(
  id bigint auto_increment comment '主键'
    primary key,
  name varchar(50) null comment '权限名称',
  label varchar(50) null comment '权限标识字符串，如system:user:list',
  menu_id bigint null comment '权限所属菜单',
  description varchar(200) null comment '权限描述',
  is_deleted tinyint null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '更新时间'
)
  comment '权限表';

create table sys_role
(
  id bigint auto_increment comment '主键'
    primary key,
  name varchar(50) null comment '角色名称',
  description varchar(200) null comment '角色描述',
  is_deleted tinyint default 0 null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '最后更新时间'
)
  comment '角色表';

create table sys_role_menu
(
  id bigint auto_increment comment '主键'
    primary key,
  role_id bigint not null comment '角色ID',
  menu_id bigint not null comment '菜单ID',
  is_deleted tinyint default 0 null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '最后更新时间'
)
  comment '角色菜单关系表';

create table sys_role_permission
(
  id bigint auto_increment comment '主键'
    primary key,
  role_id bigint not null comment '角色ID',
  permission_id bigint not null comment '权限ID',
  is_deleted tinyint default 0 null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '最后更新时间'
)
  comment '角色权限关系表';

create table sys_user
(
  id bigint auto_increment
    primary key,
  username varchar(50) not null comment '用户名',
  password varchar(100) not null comment '密码',
  salt varchar(50) null comment '密码加密的盐',
  nickname varchar(50) null comment '昵称',
  gender tinyint null comment '性别 0-女 1-男',
  email varchar(50) null comment '''电子邮箱''',
  mobile varchar(50) null comment '手机号',
  dept_id bigint null comment '部门ID',
  status tinyint null comment '用户状态 0-正常 1-禁用',
  is_deleted tinyint default 0 null comment '软删除状态 0-正在使用 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null,
  updated_time datetime default CURRENT_TIMESTAMP null,
  constraint sys_user_username_uindex
    unique (username)
)
  comment '系统用户';

create table sys_user_role
(
  id bigint auto_increment comment '主键'
    primary key,
  user_id bigint not null comment '用户ID',
  role_id bigint not null comment '角色ID',
  is_deleted tinyint default 0 null comment '是否删除 0-未删除 1-已删除',
  created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
  updated_time datetime default CURRENT_TIMESTAMP null comment '最后更新时间'
)
  comment '用户角色关系表';

