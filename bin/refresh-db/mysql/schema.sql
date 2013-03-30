-- ���ݹ������Ա���
drop table if exists cms_guestbook;
create table cms_guestbook (
	id bigint not null auto_increment comment '���',
	type varchar(100) not null comment '���Է��ࣨ��ѯ�����顢Ͷ�ߡ�������',
	content varchar(255) not null comment '��������',
	name varchar(100) not null comment '����',
	email varchar(100) not null comment '����',
	phone varchar(100) not null comment '�绰',
	workunit varchar(100) not null comment '��λ',
	ip varchar(100) not null comment 'IP',
	create_date timestamp default now() comment '����ʱ��',
	re_user_id bigint comment '�ظ���',
	re_date timestamp null comment '�ظ�ʱ��',
	re_content varchar(100) comment '�ظ�����',
	status char(1) default '0' comment '״̬��0��������1�����ϣ�2����ˣ���',
	primary key (id),
	key (status)
) engine=innodb comment '���ݹ������Ա���';

-- ���ݹ����������۱�
drop table if exists cms_comment;
create table cms_comment (
	id bigint not null auto_increment comment '���',
	module varchar(20) not null comment '����ģ�ͣ�article�����£�picture��ͼƬ��download�����أ�',
	content_id bigint not null comment '�����������ݵı�ţ�Article.id��Photo.id��Download.id��',
	title varchar(255) comment '�����������ݵı��⣨Article.title��Photo.title��Download.title��',
	content varchar(255) comment '��������',
	name varchar(100) comment '��������',
	ip varchar(100) comment '����IP',
	create_date timestamp default now() comment '����ʱ��',
	audit_user_id bigint comment '�����',
	audit_date timestamp null comment '���ʱ��',
	status char(1) default '0' comment 'ɾ����ǣ�0��������1�����ϣ�2����ˣ���',
	primary key (id),
	key (module),
	key (content_id),
	key (status)
) engine=innodb comment '���ݹ����������۱�';

-- ���ݹ�������ģ�ͱ�
drop table if exists cms_link;
create table cms_link (
	id bigint not null auto_increment comment '���',
	category_id bigint not null comment '������',
	user_id bigint not null comment '������',
	title varchar(255) not null comment '��������',
	color varchar(50) default '' comment '������ɫ��red����ɫ��green����ɫ��blue����ɫ��yellow����ɫ��orange����ɫ��',
	image varchar(255) default '' comment '����ϴ���ͼƬ������ʾΪͼƬ����',
	href varchar(255) default '' comment '���ӵ�ַ',
	remarks varchar(255) default '' comment '��ע',
	status char(1) default '' comment '״̬��0��������1�����ϣ�2����ˣ���',
	weight int default 0 comment 'Ȩ�أ�Խ��Խ��ǰ',
	input_date timestamp default now() comment '¼��ʱ��',
	update_date timestamp comment '����ʱ��',
	primary key (id),
	key (user_id),
	key (title),
	key (status),
	key (weight),
	key (input_date),
	key (update_date)
) engine=innodb comment '���ݹ�������ģ�ͱ�';

-- ���ݹ�������ģ�ͱ�
drop table if exists cms_article;
create table cms_article (
	id bigint not null auto_increment comment '���',
	category_id bigint not null comment '������',
	user_id bigint not null comment '������',
	title varchar(255) not null comment '����',
	color varchar(50) default '' comment '������ɫ��red����ɫ��green����ɫ��blue����ɫ��yellow����ɫ��orange����ɫ��',
	thumb varchar(255) default '' comment '����ͼ',
	keywords varchar(255) default '' comment '�ؼ���',
	desciption varchar(255) default '' comment '������ժҪ',
	status char(1) default '' comment '״̬��0��������1�����ϣ�2����ˣ���',
	weight int default 0 comment 'Ȩ�أ�Խ��Խ��ǰ',
    hits int default 0 comment '�����',
    posid varchar(10) comment '�Ƽ�λ����ѡ��1����ҳ����ͼ��2����Ŀҳ�����Ƽ�����',
	input_date timestamp default now() comment '¼��ʱ��',
	update_date timestamp comment '����ʱ��',
	primary key (id),
	key (user_id),
	key (title),
	key (keywords),
	key (status),
	key (weight),
	key (input_date),
	key (update_date)
) engine=innodb comment '���ݹ�������ģ�ͱ�';

-- ���ݹ�������ģ�͸���
drop table if exists cms_article_data;
create table cms_article_data (
	id bigint not null auto_increment comment '���',
	content mediumtext comment '����',
	copyfrom varchar(255) comment '��Դ',
	relation varchar(255) comment '�������',
	allow_comment char(1) comment '�Ƿ���������',
	primary key (id)
) engine=innodb comment '���ݹ�������ģ�ͱ�';

-- ���ݹ�����Ŀ��
drop table if exists cms_category;
create table cms_category (
	id bigint not null auto_increment comment '���',
    site_id bigint default '1' comment 'վ����',
    parent_id bigint not null comment '�������',
	parent_ids varchar(255) not null comment '���и������',
	module varchar(20) not null comment '��Ŀģ�飨article�����£�picture��ͼƬ��download�����أ�link�����ӣ�special��ר�⣩',
	name varchar(100) not null comment '��Ŀ����',
	image varchar(255) default '' comment '��ĿͼƬ',
    href varchar(255) not null comment '����',
    target varchar(20) not null comment 'Ŀ�꣨ _blank��_self��_parent��_top��',
	desciption varchar(255) default '' comment '��������д���������������Ż�',
    keywords varchar(255) default '' comment '�ؼ��֣���д���������������Ż�',
    sort int default 30 comment '��������',
    in_menu char(1) default '1' comment '�Ƿ��ڵ�������ʾ��1����ʾ��0������ʾ��',
    in_list char(1) default '1' comment '�Ƿ��ڷ���ҳ����ʾ�б�1����ʾ��0������ʾ��',
	show_modes char(1) default '0' comment 'չ�ַ�ʽ��0:������Ŀ��ʾ��Ŀ�б�������Ŀ��ʾ�����б�;1������Ŀ�����б�2����Ŀ��һ�����ݣ�',
	allow_comment char(1) comment '�Ƿ���������',
	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
	primary key (id),
	key (parent_id),
	key (parent_ids),
	key (module),
	key (name),
	key (sort),
	key (del_flag)
) engine=innodb comment '���ݹ�����Ŀ��';

-- ���ݹ���վ�����ñ�
drop table if exists cms_site;
create table cms_site (
	id bigint not null auto_increment comment '���',
	name varchar(100) not null comment 'վ������',
	title varchar(100) not null comment 'վ�����',
	desciption varchar(255) default '' comment '��������д���������������Ż�',
    keywords varchar(255) default '' comment '�ؼ��֣���д���������������Ż�',
    theme varchar(255) default 'default' comment '����',
    copyright mediumtext comment '��Ȩ��Ϣ',
	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
	primary key (id),
	key (del_flag)
) engine=innodb comment '���ݹ���վ�����ñ�';

-- ϵͳ�ϴ��ļ���
--drop table if exists sys_attachment;
--create table sys_attachment (
--	id bigint not null auto_increment comment '���',
--	area_id bigint not null comment '��������',
--	office_id bigint not null comment '��������',
--	user_id bigint not null comment '�ϴ���',
--	name varchar(255) not null comment '�ļ���',
--	file_name varchar(255) not null comment '�ϴ�����ļ���',
--	file_ext varchar(16) not null comment '��չ��',
--	file_type varchar(100) not null comment '�ļ�����',
--	file_size bigint not null comment '�ļ���С',
--	file_path varchar(255) not null comment '���·����/files/year/month/area_office_user/��',
--	create_date timestamp default now() comment '�ϴ�ʱ��',
--	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
--	primary key (id),
--	key (area_id),
--	key (office_id),
--	key (user_id),
--	key (del_flag)
--) engine=innodb comment 'ϵͳ�ϴ��ļ���';

-- ϵͳ�ֵ��
drop table if exists sys_dict;
create table sys_dict (
	id bigint not null auto_increment comment '���',
	label varchar(100) not null comment '��ǩ',
	value varchar(100) not null comment '��ֵ',
	type varchar(100) not null comment '����',
	desciption varchar(100) not null comment '����',
    sort int not null comment '��������',
	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
	primary key (id),
	key (value),
	key (label),
	key (del_flag)
) engine=innodb comment 'ϵͳ�ֵ��';

-- ϵͳ�����
drop table if exists sys_area;
create table sys_area (
	id bigint not null auto_increment comment '���',
	parent_id bigint not null comment '�������',
	parent_ids varchar(255) not null comment '���и������',
	code varchar(100) comment '�������',
	name varchar(100) comment '��������',
	remarks varchar(255) comment '��ע',
	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
	primary key (id),
	key (parent_id),
	key (parent_ids),
	key (del_flag)
) engine=innodb comment 'ϵͳ�����';

-- ϵͳ���ű�
drop table if exists sys_office;
create table sys_office (
	id bigint not null auto_increment comment '���',
	parent_id bigint not null comment '�������',
	parent_ids varchar(255) not null comment '���и������',
	area_id bigint not null comment '��������',
	code varchar(100) comment '�������',
	name varchar(100) not null comment '��������',
	remarks varchar(255) comment '��ע',
	del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
	primary key (id),
	key (parent_id),
	key (parent_ids),
	key (del_flag)
) engine=innodb comment 'ϵͳ���ű�';

-- ϵͳ�˵���
drop table if exists sys_menu;
create table sys_menu (
    id bigint not null auto_increment comment '���',
    parent_id bigint not null comment '�������',
	parent_ids varchar(255) not null comment '���и������',
    name varchar(100) not null comment '�˵�����',
    href varchar(255) not null comment '����',
    target varchar(20) not null comment 'Ŀ�꣨mainFrame�� _blank��_self��_parent��_top��',
    icon varchar(100) not null comment 'ͼ��',
    sort int not null comment '��������',
    is_show char(1) not null comment '�Ƿ��ڲ˵�����ʾ��1����ʾ��0������ʾ��',
    permission varchar(200) not null comment 'Ȩ�ޱ�ʶ',
    del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
    primary key (id),
	key (parent_id),
	key (parent_ids),
	key (del_flag)
) engine=innodb comment 'ϵͳ�˵���';

-- ϵͳ��ɫ��
drop table if exists sys_role;
create table sys_role (
    id bigint not null auto_increment comment '���',
    name varchar(100) not null comment '����',
    del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
    primary key (id),
	key (del_flag)
) engine=innodb comment 'ϵͳ��ɫ��';

-- ϵͳ��ɫ��˵�������
drop table if exists sys_role_menu;
create table sys_role_menu (
    role_id bigint not null comment '��ɫ���',
    menu_id bigint not null comment '�˵����',
	primary key (role_id,menu_id)
) engine=innodb comment 'ϵͳ��ɫ��˵�������';

-- ϵͳ��ɫ��˵�������
drop table if exists sys_role_category;
create table sys_role_category (
  role_id bigint(20) not null comment '��ɫ���',
  category_id bigint(20) not null comment '���ݷ�����',
  primary key (role_id,category_id)
) engine=innodb comment 'ϵͳ��ɫ�����ݷ��������';

-- ϵͳ�û���
drop table if exists sys_user;
create table sys_user (
    id bigint not null auto_increment comment '���',
    area_id bigint not null comment '������',
    office_id bigint not null comment '���ű��',
    login_name varchar(100) not null comment '��¼��',
    password varchar(100) comment '����',
    name varchar(100) comment '����',
    email varchar(200) comment '����',
    phone varchar(200) comment '�绰',
    mobile varchar(200) comment '�ֻ�',
    remarks varchar(255) default '' comment '��ע',
    user_type varchar(100) default '' comment '�û�����',
    create_date timestamp default now() comment '����ʱ��',
    del_flag char(1) default '0' comment 'ɾ����ǣ�0��������1��ɾ����',
    login_ip varchar(100) comment '����½IP',
    login_date datetime comment '����½ʱ��',
    primary key (id),
	key (area_id),
	key (office_id),
	key (login_name),
	key (del_flag)
) engine=innodb comment 'ϵͳ�û���';

-- ϵͳ�û����ɫ������
drop table if exists sys_user_role;
create table sys_user_role (
    user_id bigint not null comment '�û����',
    role_id bigint not null comment '��ɫ���',
	primary key (user_id,role_id)
) engine=innodb comment 'ϵͳ�û����ɫ������';
