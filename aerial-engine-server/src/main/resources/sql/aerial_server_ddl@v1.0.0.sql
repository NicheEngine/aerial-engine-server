
DROP TABLE IF EXISTS "public"."arl_workspace";
CREATE TABLE "public"."arl_workspace"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "bind_code"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "platform"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "properties"       jsonb,
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_workspace"."name" IS '工作空间名称';
COMMENT ON COLUMN "public"."arl_workspace"."description" IS '设备描述';
COMMENT ON COLUMN "public"."arl_workspace"."bind_code" IS '绑定码';
COMMENT ON COLUMN "public"."arl_workspace"."platform" IS '平台名称';
COMMENT ON COLUMN "public"."arl_workspace"."properties" IS '扩展数据';

ALTER TABLE "public"."arl_workspace"
    ADD CONSTRAINT "PK_ARL_WORKSPACE_ID" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "UK_ARL_WORKSPACE_BIND_CODE" ON "public"."arl_workspace" ("bind_code");

CREATE INDEX if NOT EXISTS "IDX_ARL_WORKSPACE_NAME" ON "public"."arl_workspace" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WORKSPACE_BIND_CODE" ON "public"."arl_workspace" USING BTREE (
    "bind_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WORKSPACE_LOGIC" ON "public"."arl_workspace" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WORKSPACE_PROPERTIES" ON "public"."arl_workspace" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );

INSERT INTO "public"."arl_workspace" ("id",  "name", "description",  "bind_code", "platform", "logic", "create_time", "update_time")
VALUES ('1835974778298056789', '无人机云平台', '无人机AI巡检云平台', 'qwe', '无人机云',1, now(), now());

DROP TABLE IF EXISTS "public"."arl_role";
CREATE TABLE "public"."arl_role"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "key"              VARCHAR(256) COLLATE "pg_catalog"."default",
    "value"            INT8,
    "complex"          INT8,
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_role"."name" IS '角色名称';
COMMENT ON COLUMN "public"."arl_role"."description" IS '角色描述';
COMMENT ON COLUMN "public"."arl_role"."key" IS '角色键';
COMMENT ON COLUMN "public"."arl_role"."value" IS '角色值';
COMMENT ON COLUMN "public"."arl_role"."complex" IS '角色组合值';

ALTER TABLE "public"."arl_role"
    ADD CONSTRAINT "PK_ARL_ROLE_ID" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "UK_ARL_ROLE_KEY" ON "public"."arl_role" ("key");

CREATE INDEX if NOT EXISTS "IDX_ARL_ROLE_NAME" ON "public"."arl_role" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_ROLE_KEY" ON "public"."arl_role" USING BTREE (
    "key" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_ROLE_COMPLEX" ON "public"."arl_role" USING BTREE (
    "complex" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_ROLE_LOGIC" ON "public"."arl_role" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_role" ("id",  "name", "description",  "key", "value", "complex", "logic", "create_time", "update_time")
VALUES ('1835974778298056781', '普通用户', '工作空间普通用户', 'user', 1, 1, 1, now(), now());


INSERT INTO "public"."arl_role" ("id",  "name", "description",  "key", "value", "complex", "logic", "create_time", "update_time")
VALUES ('1835974778298056782', '管理员', '工作空间管理员', 'admin', 2, 3,1, now(), now());


INSERT INTO "public"."arl_role" ("id",  "name", "description",  "key", "value", "complex", "logic", "create_time", "update_time")
VALUES ('1835974778298056783', '超级管理员', '平台超级管理员', 'super',4, 7,1, now(), now());



DROP TABLE IF EXISTS "public"."arl_purview";
CREATE TABLE "public"."arl_purview"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "key"              VARCHAR(256) COLLATE "pg_catalog"."default",
    "value"            INT8,
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_purview"."name" IS '权限名称';
COMMENT ON COLUMN "public"."arl_purview"."description" IS '权限描述';
COMMENT ON COLUMN "public"."arl_purview"."key" IS '权限键';
COMMENT ON COLUMN "public"."arl_purview"."value" IS '权限值';
COMMENT ON COLUMN "public"."arl_purview"."workspace_id" IS '权限所属工作空间id';

ALTER TABLE "public"."arl_purview"
    ADD CONSTRAINT "PK_ARL_PURVIEW_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_PURVIEW_NAME" ON "public"."arl_purview" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_PURVIEW_KEY" ON "public"."arl_purview" USING BTREE (
    "key" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_PURVIEW_VALUE" ON "public"."arl_purview" USING BTREE (
    "value" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_PURVIEW_LOGIC" ON "public"."arl_purview" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_purview" ("id", "workspace_id", "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054781', null,'查询', '基础查询权限', 'query', 1, 1, now(), now());

INSERT INTO "public"."arl_purview" ("id","workspace_id",   "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054782', null,'新增', '基础新增权限', 'insert', 2, 1, now(), now());

INSERT INTO "public"."arl_purview" ("id","workspace_id",   "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054783', null,'更新', '基础更新权限', 'update', 4, 1, now(), now());

INSERT INTO "public"."arl_purview" ("id", "workspace_id",  "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054784', null,'删除', '基础删除权限', 'delete',8, 1, now(), now());

INSERT INTO "public"."arl_purview" ("id", "workspace_id",  "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054786', null,'上传', '基础上传权限', 'upload',16, 1, now(), now());

INSERT INTO "public"."arl_purview" ("id", "workspace_id",  "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054787', null,'下载', '基础下载权限', 'download',32, 1, now(), now());

-- 普通用户权限 查询 下载
INSERT INTO "public"."arl_purview" ("id", "workspace_id",  "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054788', '1835974778298056789','普通用户权限', '工作空间自定义普通用户权限', 'user_purview',33, 1, now(), now());

-- 管理员权限 所有
INSERT INTO "public"."arl_purview" ("id", "workspace_id",  "name", "description",  "key", "value", "logic", "create_time", "update_time")
VALUES ('1835974778298054789', '1835974778298056789','管理员权限', '工作空间自定义管理员权限', 'admin_purview',63, 1, now(), now());


DROP TABLE IF EXISTS "public"."arl_user";
CREATE TABLE "public"."arl_user"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "nickname"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "password"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "logic"       INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_user"."name" IS '用户名称';
COMMENT ON COLUMN "public"."arl_user"."description" IS '用户描述';
COMMENT ON COLUMN "public"."arl_user"."workspace_id" IS '权限所属工作空间id';
COMMENT ON COLUMN "public"."arl_user"."nickname" IS '用户昵称';
COMMENT ON COLUMN "public"."arl_user"."password" IS '用户密码';


ALTER TABLE "public"."arl_user"
    ADD CONSTRAINT "PK_ARL_USER_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_WORKSPACE_ID" ON "public"."arl_user" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_NAME" ON "public"."arl_user" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_NICKNAME" ON "public"."arl_user" USING BTREE (
    "nickname" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_LOGIC" ON "public"."arl_user" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_user" ("id", "workspace_id", "name", "description", "nickname", "password", "logic", "create_time", "update_time")
VALUES ('1835974778298056704', null,'super', '超级管理员账户', 'Aerial Super', '014F18978F965C63AC2B3DD348CE6D4523B48F778AC0274BA66CE3F455F77F3B',1, now(), now());

INSERT INTO "public"."arl_user" ("id", "workspace_id", "name", "description", "nickname", "password", "logic", "create_time", "update_time")
VALUES ('1835974778298056705', '1835974778298056789','admin', '管理员账户', 'Aerial Admin', '014F18978F965C63AC2B3DD348CE6D4523B48F778AC0274BA66CE3F455F77F3B',1, now(), now());

INSERT INTO "public"."arl_user" ("id", "workspace_id", "name", "description", "nickname", "password", "logic", "create_time", "update_time")
VALUES ('1835974778298056706', '1835974778298056789','user', '普通账户', 'Aerial User', '014F18978F965C63AC2B3DD348CE6D4523B48F778AC0274BA66CE3F455F77F3B',1, now(), now());


DROP TABLE IF EXISTS "public"."arl_user_purview";
CREATE TABLE "public"."arl_user_purview"
(
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "purview_id"       VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL
);

ALTER TABLE "public"."arl_user_purview"
    ADD CONSTRAINT "PK_ARL_USER_PURVIEW_ID" PRIMARY KEY ("user_id","purview_id","workspace_id");

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_PURVIEW_USER_ID" ON "public"."arl_user_purview" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_PURVIEW_PURVIEW_ID" ON "public"."arl_user_purview" USING BTREE (
    "purview_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_PURVIEW_WORKSPACE_ID" ON "public"."arl_user_purview" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_user_purview" ("user_id", "purview_id", "workspace_id")
VALUES ('1835974778298056704', '1835974778298054789', '1835974778298056789');

INSERT INTO "public"."arl_user_purview" ("user_id", "purview_id", "workspace_id")
VALUES ('1835974778298056705', '1835974778298054789', '1835974778298056789');

INSERT INTO "public"."arl_user_purview" ("user_id", "purview_id", "workspace_id")
VALUES ('1835974778298056706', '1835974778298054788', '1835974778298056789');


DROP TABLE IF EXISTS "public"."arl_user_role";
CREATE TABLE "public"."arl_user_role"
(
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "role_id"          VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL
);

ALTER TABLE "public"."arl_user_role"
    ADD CONSTRAINT "PK_ARL_USER_ROLE_ID" PRIMARY KEY ("user_id","role_id","workspace_id");

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_USER_ID" ON "public"."arl_user_role" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_ROLE_ID" ON "public"."arl_user_role" USING BTREE (
    "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_WORKSPACE_ID" ON "public"."arl_user_role" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_user_role" ("user_id", "role_id", "workspace_id")
VALUES ('1835974778298056704', '1835974778298056783', '1835974778298056789');

INSERT INTO "public"."arl_user_role" ("user_id", "role_id", "workspace_id")
VALUES ('1835974778298056705', '1835974778298056782', '1835974778298056789');

INSERT INTO "public"."arl_user_role" ("user_id", "role_id", "workspace_id")
VALUES ('1835974778298056706', '1835974778298056781', '1835974778298056789');

-- --------------------
-- arl_userlog 用户操作日志
-- --------------------
DROP TABLE IF EXISTS "public"."arl_userlog";
CREATE TABLE "public"."arl_userlog"
(
    "id"               VARCHAR(256) COLLATE "default" NOT NULL,
    "user_id"          VARCHAR(256) COLLATE "default",
    "target_ids"       JSONB,
    "username"         VARCHAR(256) COLLATE "default",
    "user_agent"       VARCHAR(512) COLLATE "default",
    "ip_address"       VARCHAR(256) COLLATE "default",
    "request_method"   VARCHAR(256) COLLATE "default",
    "request_params"   TEXT,
    "request_url"      VARCHAR(256) COLLATE "default",
    "method_name"      VARCHAR(256) COLLATE "default",
    "media_type"       VARCHAR(256) COLLATE "default",
    "response_time"    INT8,
    "response_status"  INT4,
    "response_message" TEXT,
    "notelog"          VARCHAR(256) COLLATE "default",
    "userlog"          VARCHAR(256) COLLATE "default",
    "logging_key"          INT4,
    "logging_value"        VARCHAR(256) COLLATE "default",
    "logging_type"         VARCHAR(256) COLLATE "default",
    "logging_time"         TIMESTAMPTZ
);
COMMENT ON COLUMN "public"."arl_userlog"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."arl_userlog"."target_ids" IS '操作数据id集合';
COMMENT ON COLUMN "public"."arl_userlog"."username" IS '用户名';
COMMENT ON COLUMN "public"."arl_userlog"."user_agent" IS '用户代理';
COMMENT ON COLUMN "public"."arl_userlog"."ip_address" IS '用户ip';
COMMENT ON COLUMN "public"."arl_userlog"."request_method" IS '请求方式';
COMMENT ON COLUMN "public"."arl_userlog"."request_params" IS '请求参数';
COMMENT ON COLUMN "public"."arl_userlog"."request_url" IS '请求地址';
COMMENT ON COLUMN "public"."arl_userlog"."method_name" IS '方法名';
COMMENT ON COLUMN "public"."arl_userlog"."media_type" IS '请求媒介类型';
COMMENT ON COLUMN "public"."arl_userlog"."response_time" IS '响应耗费时间';
COMMENT ON COLUMN "public"."arl_userlog"."response_status" IS '响应状态码';
COMMENT ON COLUMN "public"."arl_userlog"."response_message" IS '响应消息';
COMMENT ON COLUMN "public"."arl_userlog"."notelog" IS '标题';
COMMENT ON COLUMN "public"."arl_userlog"."userlog" IS '信息';
COMMENT ON COLUMN "public"."arl_userlog"."logging_key" IS '操作key';
COMMENT ON COLUMN "public"."arl_userlog"."logging_value" IS '操作值';
COMMENT ON COLUMN "public"."arl_userlog"."logging_type" IS '日志类型';
COMMENT ON COLUMN "public"."arl_userlog"."logging_time" IS '记录时间';

-- PK 主键

ALTER TABLE "public"."arl_userlog"
    ADD CONSTRAINT "pk_arl_userlog_id" PRIMARY KEY ("id");

-- INDEX 索引

CREATE INDEX "IDX_ARL_USERLOG_USER_ID" ON "public"."arl_userlog" USING BTREE (
    "user_id"  COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "IDX_ARL_USERLOG_USERNAME" ON "public"."arl_userlog" USING BTREE (
    "username"  COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "IDX_ARL_USERLOG_RESPONSE_STATUS" ON "public"."arl_userlog" USING BTREE (
    "response_status" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX "IDX_ARL_USERLOG_LOGGING_KEY" ON "public"."arl_userlog" USING BTREE (
    "logging_key" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX "IDX_ARL_USERLOG_LOGGING_TYPE" ON "public"."arl_userlog" USING BTREE (
    "logging_type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "IDX_ARL_USERLOG_LOGGING_TIME" ON "public"."arl_userlog" USING BTREE (
    "logging_time"  "pg_catalog"."timestamptz_ops" ASC NULLS LAST
    );


DROP TABLE IF EXISTS "public"."arl_menu";
CREATE TABLE "public"."arl_menu" (
    "name"         VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "path"         VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "role"         VARCHAR(64) COLLATE "pg_catalog"."default",
    "workspace_id" VARCHAR(64) COLLATE "pg_catalog"."default",
    "parent"       VARCHAR(64) COLLATE "pg_catalog"."default",
    "redirect"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "component"    VARCHAR(64) COLLATE "pg_catalog"."default",
    "type"         VARCHAR(32) COLLATE "pg_catalog"."default",
    "meta"         JSONB
);

COMMENT ON COLUMN "public"."arl_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "public"."arl_menu"."path" IS '菜单路径';
COMMENT ON COLUMN "public"."arl_menu"."workspace_id" IS '权限所属工作空间id';
COMMENT ON COLUMN "public"."arl_menu"."role" IS '菜单访问角色';
COMMENT ON COLUMN "public"."arl_menu"."parent" IS '父菜单id';
COMMENT ON COLUMN "public"."arl_menu"."redirect" IS '菜单重定向';
COMMENT ON COLUMN "public"."arl_menu"."component" IS '菜单组件';
COMMENT ON COLUMN "public"."arl_menu"."type" IS '菜单类型';
COMMENT ON COLUMN "public"."arl_menu"."meta" IS '菜单元数据';

ALTER TABLE "public"."arl_menu"
    ADD CONSTRAINT "PK_ARL_MENU_ID"
        PRIMARY KEY ("name");

CREATE INDEX if NOT EXISTS "IDX_ARL_MENU_WORKSPACE_ID" ON "public"."arl_menu" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MENU_NAME" ON "public"."arl_menu" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MENU_PARENT" ON "public"."arl_menu" USING BTREE (
    "parent" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MENU_TYPE" ON "public"."arl_menu" USING BTREE (
    "type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('Dashboard', '/dashboard', NULL, NULL, NULL, '/analytics', NULL, 'demo', '{"order": {"value": -1}, "title": {"value": "page.dashboard.title"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('Analytics', '/analytics', NULL, NULL, 'Dashboard', NULL, '/dashboard/analytics/index', 'demo', '{"title": {"value": "page.dashboard.analytics"}, "affixTab": {"value": true}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('Workspace', '/workspace', NULL, NULL, 'Dashboard', NULL, '/dashboard/workspace/index', 'demo', '{"title": {"value": "page.dashboard.workspace"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('Demos', '/demos', NULL, NULL, NULL, '/demos/access', NULL, 'demo', '{"icon": {"value": "ic:baseline-view-in-ar"}, "order": {"value": 1000}, "title": {"value": "demos.title"}, "keepAlive": {"value": true}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessAdminVisibleDemo', '/demos/access/admin-visible', 'admin', NULL, 'AccessDemos', NULL, '/demos/access/admin-visible', 'demo', '{"icon": {"value": "mdi:button-cursor"}, "title": {"value": "demos.access.adminVisible"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessSuperVisibleDemo', '/demos/access/super-visible', 'super', NULL, 'AccessDemos', NULL, '/demos/access/super-visible', 'demo', '{"icon": {"value": "mdi:button-cursor"}, "title": {"value": "demos.access.superVisible"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessUserVisibleDemo', '/demos/access/user-visible', 'user', NULL, 'AccessDemos', NULL, '/demos/access/user-visible', 'demo', '{"icon": {"value": "mdi:button-cursor"}, "title": {"value": "demos.access.userVisible"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessDemos', '/demosaccess', NULL, NULL, 'Demos', '/demos/access/page-control', NULL, 'demo', '{"icon": {"value": "mdi:cloud-key-outline"}, "title": {"value": "demos.access.backendPermissions"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessPageControlDemo', '/demos/access/page-control', NULL, NULL, 'AccessDemos', NULL, '/demos/access/index', 'demo', '{"icon": {"value": "mdi:page-previous-outline"}, "title": {"value": "demos.access.pageAccess"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessButtonControlDemo', '/demos/access/button-control', NULL, NULL, 'AccessDemos', NULL, '/demos/access/button-control', 'demo', '{"icon": {"value": "mdi:button-cursor"}, "title": {"value": "demos.access.buttonControl"}}');

INSERT INTO "public"."arl_menu" ("name", "path", "role", "workspace_id", "parent", "redirect", "component", "type", "meta")
VALUES ('AccessMenuVisible403Demo', '/demos/access/menu-visible-403', NULL, NULL, 'AccessDemos', NULL, '/demos/access/menu-visible-403', 'demo', '{"icon": {"value": "mdi:button-cursor"}, "title": {"value": "demos.access.menuVisible403"}, "authority": {"value": ["no-body"]}, "menuVisibleWithForbidden": {"value": true}}');

DROP TABLE IF EXISTS "public"."arl_device";
CREATE TABLE "public"."arl_device"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "device_name"      VARCHAR(256) COLLATE "pg_catalog"."default",
    "thing_type"       INT4,
    "device_type"      INT4,
    "device_subtype"   INT4,
    "device_domain"    INT4,
    "device_index"     VARCHAR(32) COLLATE "pg_catalog"."default",
    "firmware_version" VARCHAR(32) COLLATE "pg_catalog"."default",
    "protocol_version" VARCHAR(32) COLLATE "pg_catalog"."default",
    "compatible_state" BOOLEAN,
    "child_sn"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "bound_time"       TIMESTAMPTZ,
    "bound_state"      BOOLEAN,
    "last_time"        TIMESTAMPTZ,
    "icon_normal"      VARCHAR(256) COLLATE "pg_catalog"."default",
    "icon_select"      VARCHAR(256) COLLATE "pg_catalog"."default",
    "location"         GEOMETRY,
    "properties"       jsonb,
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_device"."name" IS '设备自定义名称';

COMMENT ON COLUMN "public"."arl_device"."description" IS '设备描述';
COMMENT ON COLUMN "public"."arl_device"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."arl_device"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_device"."device_sn" IS '设备sn编码';
COMMENT ON COLUMN "public"."arl_device"."device_name" IS '设备默认名称';
COMMENT ON COLUMN "public"."arl_device"."thing_type" IS '事物类型';
COMMENT ON COLUMN "public"."arl_device"."device_type" IS '设备类型';
COMMENT ON COLUMN "public"."arl_device"."device_subtype" IS '设备子类型';
COMMENT ON COLUMN "public"."arl_device"."device_domain" IS '设备作用域';
COMMENT ON COLUMN "public"."arl_device"."device_index" IS '设备控制序列，无人机A控或B控';
COMMENT ON COLUMN "public"."arl_device"."firmware_version" IS '设备固件版本';
COMMENT ON COLUMN "public"."arl_device"."protocol_version" IS '设备协议版本（预留）';
COMMENT ON COLUMN "public"."arl_device"."compatible_state" IS '设备兼容状态';
COMMENT ON COLUMN "public"."arl_device"."child_sn" IS '子设备sn编码';
COMMENT ON COLUMN "public"."arl_device"."bound_time" IS '设备绑定时间';
COMMENT ON COLUMN "public"."arl_device"."bound_state" IS '设备绑定状态';
COMMENT ON COLUMN "public"."arl_device"."last_time" IS '设备最后上线时间';
COMMENT ON COLUMN "public"."arl_device"."icon_normal" IS '设备远程控制中展示图标';
COMMENT ON COLUMN "public"."arl_device"."icon_select" IS '设备远程控制中选中时的图标';
COMMENT ON COLUMN "public"."arl_device"."location" IS '设备位置';
COMMENT ON COLUMN "public"."arl_device"."properties" IS '设备扩展数据';

ALTER TABLE "public"."arl_device"
    ADD CONSTRAINT "PK_ARL_DEVICE_ID" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "UK_ARL_DEVICE_DEVICE_SN" ON "public"."arl_device" ("device_sn");

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_NAME" ON "public"."arl_device" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_THING_TYPE" ON "public"."arl_device" USING BTREE (
    "thing_type" "pg_catalog"."int4_ops" ASC NULLS LAST
   );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_USER_ID" ON "public"."arl_device" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_WORKSPACE_ID" ON "public"."arl_device" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_LOGIC" ON "public"."arl_device" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_LOCATION" ON "public"."arl_device" USING GIST (
    "location" "public"."gist_geometry_ops_2d"
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_PROPERTIES" ON "public"."arl_device" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );

DROP TABLE IF EXISTS "public"."arl_device_dictionary";
CREATE TABLE "public"."arl_device_dictionary"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "type"             INT4,
    "subtype"          INT4,
    "domain"           INT4
);

COMMENT ON COLUMN "public"."arl_device_dictionary"."name" IS '设备字典名称';
COMMENT ON COLUMN "public"."arl_device_dictionary"."description" IS '设备字典描述';
COMMENT ON COLUMN "public"."arl_device_dictionary"."type" IS '设备类型';
COMMENT ON COLUMN "public"."arl_device_dictionary"."subtype" IS '设备字典子类型';
COMMENT ON COLUMN "public"."arl_device_dictionary"."domain" IS '作用域, 0: 无人机; 1: 负载; 2: 远程控制; 3: 机舱;';


ALTER TABLE "public"."arl_device_dictionary"
    ADD CONSTRAINT "PK_ARL_DEVICE_DICTIONARY_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_DICTIONARY_NAME" ON "public"."arl_device_dictionary" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_DICTIONARY_TYPE" ON "public"."arl_device_dictionary" USING BTREE (
    "type" "pg_catalog"."int4_ops" ASC NULLS LAST
    );


INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056701', 3, 1, 0, 'DJI Dock1', '大疆机场');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056702', 3, 2, 0, 'DJI Dock2', '大疆机场2');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056703', 3, 3, 0, 'DJI Dock3', '大疆机场3');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056704', 2, 56, 0, 'DJI Remote Control', '搭配 Matrice 300 RTK');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056705', 2, 119, 0, 'DJI RC Plus', '搭配 Matrice 350 RTK,Matrice 300 RTK,Matrice 30/30T');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056706', 2, 174, 0, 'DJI RC Plus 2', '搭配 >DJI Matrice 4 系列');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056707', 2, 144, 0, 'DJI RC Pro', '搭配 Mavic 3 行业系列');
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056708', 0, 103, 0, 'Mavic 400', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056709', 0, 89, 0, 'Mavic 350', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056710', 0, 50, 0, 'Mavic 300', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056711', 0, 67, 0, 'Mavic 30', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056712', 0, 67, 1, 'Mavic 30T', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056713', 0, 77, 0, 'Mavic 3E', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056714', 0, 77, 1, 'Mavic 3T', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056715', 0, 77, 2, 'Mavic 3M', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056716', 0, 91, 0, 'Mavic 3D', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056717', 0, 91, 1, 'Mavic 3TD', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056718', 0, 100, 0, 'Mavic 4D', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056719', 0, 100, 1, 'Mavic4TD', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056720', 0, 99, 0, 'Mavic 4E', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056721', 0, 99, 1, 'Mavic 4T', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056722', 1, 90742, 0, 'L1 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056723', 1, 50, 65535, 'P1 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056724', 1, 165, 0, 'DJI Dock Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056725', 1, 39, 0, 'FPV Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056726', 1, 176, 0, 'FPV Shadow Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056727', 1, 20, 0, 'Z30 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056728', 1, 26, 0, 'XT2 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056729', 1, 41, 0, 'XTS Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056730', 1, 42, 0, 'H20 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056731', 1, 43, 0, 'H20T Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056732', 1, 61, 0, 'H20N Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056733', 1, 82, 0, 'H30 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056734', 1, 83, 0, 'H30T Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056735', 1, 52, 0, 'Mavic 30 Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056736', 1, 53, 0, 'Mavic 30T Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056737', 1, 66, 0, 'Mavic 3E Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056738', 1, 67, 0, 'Mavic 3T Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056739', 1, 68, 0, 'Mavic 3M Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056740', 1, 80, 0, 'Mavic 3D Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056741', 1, 81, 0, 'Mavic 3TD Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056742', 1, 88, 0, 'Mavic 4E Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056743', 1, 89, 0, 'Mavic 4T Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056744', 1, 98, 0, 'Mavic 4D Camera', NULL);
INSERT INTO  "public"."arl_device_dictionary" ("id", "domain", "type", "subtype", "name", "description") VALUES ('1835974778298056745', 1, 99, 0, 'Mavic 4TD Camera', NULL);


DROP TABLE IF EXISTS "public"."arl_device_payload";
CREATE TABLE "public"."arl_device_payload"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "subtype"          INT4,
    "payload_sn"       VARCHAR(256) COLLATE "pg_catalog"."default",
    "payload_type"     INT4,
    "payload_index"    INT4,
    "firmware_version" VARCHAR(256) COLLATE "pg_catalog"."default",
    "control_source"   VARCHAR(1) COLLATE "pg_catalog"."default",
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_device_payload"."name" IS '负载名称';
COMMENT ON COLUMN "public"."arl_device_payload"."description" IS '负载描述';
COMMENT ON COLUMN "public"."arl_device_payload"."device_sn" IS '设备编码';
COMMENT ON COLUMN "public"."arl_device_payload"."subtype" IS '负载子类型';
COMMENT ON COLUMN "public"."arl_device_payload"."payload_sn" IS '负载sn编码';
COMMENT ON COLUMN "public"."arl_device_payload"."payload_type" IS '负载类型';
COMMENT ON COLUMN "public"."arl_device_payload"."payload_index" IS '负载序列';
COMMENT ON COLUMN "public"."arl_device_payload"."firmware_version" IS '负载固件版本';
COMMENT ON COLUMN "public"."arl_device_payload"."control_source" IS '负载控制源';


ALTER TABLE "public"."arl_device_payload"
    ADD CONSTRAINT "PK_ARL_DEVICE_PAYLOAD_ID" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "UK_ARL_DEVICE_PAYLOAD_PAYLOAD_SN" ON "public"."arl_device_payload" ("payload_sn");

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_PAYLOAD_NAME" ON "public"."arl_device_payload" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_PAYLOAD_DEVICE_SN" ON "public"."arl_device_payload" USING BTREE (
   "device_sn" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_PAYLOAD_PAYLOAD_SN" ON "public"."arl_device_payload" USING BTREE (
   "payload_sn" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_PAYLOAD_PAYLOAD_TYPE" ON "public"."arl_device_payload" USING BTREE (
    "payload_type" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

DROP TABLE IF EXISTS "public"."arl_device_hms";
CREATE TABLE "public"."arl_device_hms"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "tid"              VARCHAR(64) COLLATE "pg_catalog"."default",
    "bid"              VARCHAR(256) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "hms_level"        INT4,
    "hms_key"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "module"           INT4,
    "message_zh"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "message_en"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "read_status"      INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_device_hms"."id" IS 'hms消息id';
COMMENT ON COLUMN "public"."arl_device_hms"."tid" IS 'hms消息tid';
COMMENT ON COLUMN "public"."arl_device_hms"."bid" IS 'hms消息bid';
COMMENT ON COLUMN "public"."arl_device_hms"."device_sn" IS 'hms消息设备sn编码';
COMMENT ON COLUMN "public"."arl_device_hms"."hms_level" IS 'hms消息级别';
COMMENT ON COLUMN "public"."arl_device_hms"."hms_key" IS 'hms消息键';
COMMENT ON COLUMN "public"."arl_device_hms"."module" IS 'hms消息模块';
COMMENT ON COLUMN "public"."arl_device_hms"."message_zh" IS 'hms中文消息';
COMMENT ON COLUMN "public"."arl_device_hms"."message_en" IS 'hms英文消息';
COMMENT ON COLUMN "public"."arl_device_hms"."read_status" IS 'hms读取状态';


ALTER TABLE "public"."arl_device_hms"
    ADD CONSTRAINT "PK_ARL_DEVICE_HMS_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_HMS_DEVICE_SN" ON "public"."arl_device_hms" USING BTREE (
    "device_sn" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_HMS_HMS_LEVEL" ON "public"."arl_device_hms" USING BTREE (
    "hms_level" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_DEVICE_HMS_READ_STATUS" ON "public"."arl_device_hms" USING BTREE (
    "read_status" "pg_catalog"."int4_ops" ASC NULLS LAST
    );


DROP TABLE IF EXISTS "public"."arl_flight_area";
CREATE TABLE "public"."arl_flight_area"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "file_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "sync_result"      VARCHAR(32) COLLATE "pg_catalog"."default",
    "sync_code"        INT4,
    "sync_time"        TIMESTAMPTZ,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_flight_area"."file_id" IS '飞行区域文件id';
COMMENT ON COLUMN "public"."arl_flight_area"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_flight_area"."device_sn" IS '设备sn编码';
COMMENT ON COLUMN "public"."arl_flight_area"."sync_result" IS '飞行区域同步结果';
COMMENT ON COLUMN "public"."arl_flight_area"."sync_code" IS '飞行区域同步编码';
COMMENT ON COLUMN "public"."arl_flight_area"."sync_time" IS '飞行区域同步时间';


ALTER TABLE "public"."arl_flight_area"
    ADD CONSTRAINT "PK_ARL_FLIGHT_AREA_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_AREA_DEVICE_SN" ON "public"."arl_flight_area" USING BTREE (
    "device_sn" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_AREA_WORKSPACE_ID" ON "public"."arl_flight_area" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_AREA_SYNC_TIME" ON "public"."arl_flight_area" USING BTREE (
    "sync_time" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
    );

DROP TABLE IF EXISTS "public"."arl_flight_area_file";
CREATE TABLE "public"."arl_flight_area_file"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "filename"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "object_key"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "sign_sha256"      VARCHAR(32) COLLATE "pg_catalog"."default",
    "file_size"        INT8,
    "latest"           INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_flight_area_file"."id" IS '文件id';
COMMENT ON COLUMN "public"."arl_flight_area_file"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_flight_area_file"."filename" IS '文件名称';
COMMENT ON COLUMN "public"."arl_flight_area_file"."object_key" IS '存储路径';
COMMENT ON COLUMN "public"."arl_flight_area_file"."sign_sha256" IS 'sha256验证值';
COMMENT ON COLUMN "public"."arl_flight_area_file"."file_size" IS '文件大小';
COMMENT ON COLUMN "public"."arl_flight_area_file"."latest" IS '是否是最后版本';


ALTER TABLE "public"."arl_flight_area_file"
    ADD CONSTRAINT "PK_ARL_FLIGHT_AREA_FILE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_AREA_FILE_WORKSPACE_ID" ON "public"."arl_flight_area_file" USING BTREE (
     "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_AREA_FILE_LATEST" ON "public"."arl_flight_area_file" USING BTREE (
     "latest" "pg_catalog"."int4_ops" ASC NULLS LAST
    );


DROP TABLE IF EXISTS "public"."arl_map_layer";
CREATE TABLE "public"."arl_map_layer"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "type"             INT4,
    "shared"           INT4,
    "locked"           INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_map_layer"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_map_layer"."name" IS '图层名称';
COMMENT ON COLUMN "public"."arl_map_layer"."type" IS '图层类型';
COMMENT ON COLUMN "public"."arl_map_layer"."shared" IS '是否分发';
COMMENT ON COLUMN "public"."arl_map_layer"."locked" IS '是否锁定';


ALTER TABLE "public"."arl_map_layer"
    ADD CONSTRAINT "PK_ARL_MAP_LAYER_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_LAYER_WORKSPACE_ID" ON "public"."arl_map_layer" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_LAYER_LOCKED" ON "public"."arl_map_layer" USING BTREE (
    "locked" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

DROP TABLE IF EXISTS "public"."arl_map_feature";
CREATE TABLE "public"."arl_map_feature"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "layer_id"         VARCHAR(64) COLLATE "pg_catalog"."default",
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "creator"          VARCHAR(256) COLLATE "pg_catalog"."default",
    "display"          INT4,
    "type"             INT4,
    "color"            VARCHAR(32) COLLATE "pg_catalog"."default",
    "onland"           INT4,
    "properties"       jsonb,
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_map_feature"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_map_feature"."layer_id" IS '图层id';
COMMENT ON COLUMN "public"."arl_map_feature"."user_id" IS '创建用户';
COMMENT ON COLUMN "public"."arl_map_feature"."name" IS '要素名称';
COMMENT ON COLUMN "public"."arl_map_feature"."creator" IS '创建人';
COMMENT ON COLUMN "public"."arl_map_feature"."display" IS '是否有效';
COMMENT ON COLUMN "public"."arl_map_feature"."type" IS '要素类型';
COMMENT ON COLUMN "public"."arl_map_feature"."color" IS '要素渲染颜色';
COMMENT ON COLUMN "public"."arl_map_feature"."onland" IS '要素是否紧贴地面';
COMMENT ON COLUMN "public"."arl_map_feature"."properties" IS '要素扩展属性';


ALTER TABLE "public"."arl_map_feature"
    ADD CONSTRAINT "PK_ARL_MAP_FEATURE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_FEATURE_WORKSPACE_ID" ON "public"."arl_map_feature" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_FEATURE_LAYER_ID" ON "public"."arl_map_feature" USING BTREE (
   "layer_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_FEATURE_USER_ID" ON "public"."arl_map_feature" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_FEATURE_DISPLAY" ON "public"."arl_map_feature" USING BTREE (
    "display" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MAP_FEATURE_PROPERTIES" ON "public"."arl_map_feature" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );

DROP TABLE IF EXISTS "public"."arl_media_file";
CREATE TABLE "public"."arl_media_file"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "filename"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "file_path"        VARCHAR(1024) COLLATE "pg_catalog"."default",
    "task_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "object_key"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "device_id"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(32) COLLATE "pg_catalog"."default",
    "device_payload"   VARCHAR(32) COLLATE "pg_catalog"."default",
    "preview"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "subtype"          INT4,
    "control_type"     INT4,
    "file_type"        INT4,
    "media_type"       INT4,
    "position"         GEOMETRY,
    "media_time"       TIMESTAMPTZ,
    "properties"       jsonb,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);
COMMENT ON COLUMN "public"."arl_media_file"."filename" IS '文件名';
COMMENT ON COLUMN "public"."arl_media_file"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_media_file"."file_path" IS '文件路径';
COMMENT ON COLUMN "public"."arl_media_file"."task_id" IS '任务id';
COMMENT ON COLUMN "public"."arl_media_file"."object_key" IS '存储路径';
COMMENT ON COLUMN "public"."arl_media_file"."device_id" IS '设备id';
COMMENT ON COLUMN "public"."arl_media_file"."device_payload" IS '设备负载';
COMMENT ON COLUMN "public"."arl_media_file"."subtype" IS '媒体照片类型，0：普通照片，1：全景照片';
COMMENT ON COLUMN "public"."arl_media_file"."preview" IS '预览参数';
COMMENT ON COLUMN "public"."arl_media_file"."control_type" IS '控制类型';
COMMENT ON COLUMN "public"."arl_media_file"."file_type" IS '文件类型';
COMMENT ON COLUMN "public"."arl_media_file"."media_type" IS '媒体文件类型';
COMMENT ON COLUMN "public"."arl_media_file"."position" IS '媒体文件位置';
COMMENT ON COLUMN "public"."arl_media_file"."media_time" IS '媒体文件时间';
COMMENT ON COLUMN "public"."arl_media_file"."properties" IS '扩展属性';


ALTER TABLE "public"."arl_media_file"
    ADD CONSTRAINT "PK_ARL_MEDIA_FILE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_WORKSPACE_ID" ON "public"."arl_media_file" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_TASK_ID" ON "public"."arl_media_file" USING BTREE (
    "task_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_DEVICE_ID" ON "public"."arl_media_file" USING BTREE (
    "device_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_MEDIA_TYPE" ON "public"."arl_media_file" USING BTREE (
    "media_type" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_POSITION" ON "public"."arl_media_file" USING GIST (
    "position" "public"."gist_geometry_ops_2d"
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_MEDIA_FILE_PROPERTIES" ON "public"."arl_media_file" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );


DROP TABLE IF EXISTS "public"."arl_wayline_file";
CREATE TABLE "public"."arl_wayline_file"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "filename"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_model_key"     VARCHAR(32) COLLATE "pg_catalog"."default",
    "payload_model_key"    VARCHAR(256) COLLATE "pg_catalog"."default",
    "object_key"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "sign_md5"         VARCHAR(64) COLLATE "pg_catalog"."default",
    "template_type"    VARCHAR(32) COLLATE "pg_catalog"."default",
    "creator"          VARCHAR(256) COLLATE "pg_catalog"."default",
    "file_type"        INT4,
    "wayline"          GEOMETRY,
    "properties"       jsonb,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_wayline_file"."name" IS '航线名称';
COMMENT ON COLUMN "public"."arl_wayline_file"."filename" IS '航线文件名称';
COMMENT ON COLUMN "public"."arl_wayline_file"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_wayline_file"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."arl_wayline_file"."device_model_key" IS '设备组合键';
COMMENT ON COLUMN "public"."arl_wayline_file"."payload_model_key" IS '负载组合键';
COMMENT ON COLUMN "public"."arl_wayline_file"."object_key" IS '存储路径';
COMMENT ON COLUMN "public"."arl_wayline_file"."sign_md5" IS '文件MD5';
COMMENT ON COLUMN "public"."arl_wayline_file"."template_type" IS '航线模板类型';
COMMENT ON COLUMN "public"."arl_wayline_file"."creator" IS '航线创建人';
COMMENT ON COLUMN "public"."arl_wayline_file"."file_type" IS '文件类型';
COMMENT ON COLUMN "public"."arl_wayline_file"."wayline" IS '航线文件数据';
COMMENT ON COLUMN "public"."arl_wayline_file"."properties" IS '扩展属性';


ALTER TABLE "public"."arl_wayline_file"
    ADD CONSTRAINT "PK_ARL_WAYLINE_FILE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_NAME" ON "public"."arl_wayline_file" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_WORKSPACE_ID" ON "public"."arl_wayline_file" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_USER_ID" ON "public"."arl_wayline_file" USING BTREE (
   "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_FILE_TYPE" ON "public"."arl_wayline_file" USING BTREE (
   "file_type" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_WAYLINE" ON "public"."arl_wayline_file" USING GIST (
   "wayline" "public"."gist_geometry_ops_2d"
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WAYLINE_FILE_PROPERTIES" ON "public"."arl_wayline_file" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );


DROP TABLE IF EXISTS "public"."arl_flight_task";
CREATE TABLE "public"."arl_flight_task"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "wayline_id"       VARCHAR(64) COLLATE "pg_catalog"."default",
    "parent_id"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "wayline_name"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_id"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "creator"          VARCHAR(256) COLLATE "pg_catalog"."default",
    "preview"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "task_type"        INT4,
    "wayline_type"     INT4,
    "execute_time"     TIMESTAMPTZ,
    "completed_time"   TIMESTAMPTZ,
    "begin_time"       TIMESTAMPTZ,
    "end_time"         TIMESTAMPTZ,
    "error_code"       INT4,
    "task_status"      INT4,
    "rth_altitude"     INT4,
    "out_of_control"   INT4,
    "media_size"       INT4,
    "image_detect"     INT4,
    "properties"       jsonb,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

COMMENT ON COLUMN "public"."arl_flight_task"."name" IS '任务名称';
COMMENT ON COLUMN "public"."arl_flight_task"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_flight_task"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."arl_flight_task"."wayline_id" IS '航线id';
COMMENT ON COLUMN "public"."arl_flight_task"."wayline_name" IS '航线名称';
COMMENT ON COLUMN "public"."arl_flight_task"."device_id" IS '设备id';
COMMENT ON COLUMN "public"."arl_flight_task"."device_sn" IS '机舱设备sn编码';
COMMENT ON COLUMN "public"."arl_flight_task"."creator" IS '任务创建人';
COMMENT ON COLUMN "public"."arl_flight_task"."preview" IS '图片预览参数';
COMMENT ON COLUMN "public"."arl_flight_task"."task_type" IS '任务类型';
COMMENT ON COLUMN "public"."arl_flight_task"."wayline_type" IS '航线类型';
COMMENT ON COLUMN "public"."arl_flight_task"."execute_time" IS '执行时间';
COMMENT ON COLUMN "public"."arl_flight_task"."completed_time" IS '完成时间';
COMMENT ON COLUMN "public"."arl_flight_task"."begin_time" IS '开始时间';
COMMENT ON COLUMN "public"."arl_flight_task"."end_time" IS '结束时间';
COMMENT ON COLUMN "public"."arl_flight_task"."error_code" IS '错误码';
COMMENT ON COLUMN "public"."arl_flight_task"."task_status" IS '航线状态';
COMMENT ON COLUMN "public"."arl_flight_task"."rth_altitude" IS '返回高度';
COMMENT ON COLUMN "public"."arl_flight_task"."out_of_control" IS '失控操作类型';
COMMENT ON COLUMN "public"."arl_flight_task"."media_size" IS '媒体数量';
COMMENT ON COLUMN "public"."arl_flight_task"."image_detect" IS '图片识别';
COMMENT ON COLUMN "public"."arl_flight_task"."properties" IS '扩展数据';


ALTER TABLE "public"."arl_flight_task"
    ADD CONSTRAINT "PK_ARL_FLIGHT_TASK_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_NAME" ON "public"."arl_flight_task" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_WORKSPACE_ID" ON "public"."arl_flight_task" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_USER_ID" ON "public"."arl_flight_task" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_WAYLINE_ID" ON "public"."arl_flight_task" USING BTREE (
    "wayline_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_DEVICE_ID" ON "public"."arl_flight_task" USING BTREE (
    "device_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_TASK_TYPE" ON "public"."arl_flight_task" USING BTREE (
    "task_type" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_TASK_STATUS" ON "public"."arl_flight_task" USING BTREE (
    "task_status" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_MEDIA_SIZE" ON "public"."arl_flight_task" USING BTREE (
    "media_size" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_FLIGHT_TASK_PROPERTIES" ON "public"."arl_flight_task" USING GIN (
    ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );


DROP TABLE IF EXISTS "public"."arl_warn_file";
CREATE TABLE "public"."arl_warn_file"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "filename"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "file_path"        VARCHAR(1024) COLLATE "pg_catalog"."default",
    "task_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "object_key"       VARCHAR(1024) COLLATE "pg_catalog"."default",
    "device_id"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "device_sn"        VARCHAR(32) COLLATE "pg_catalog"."default",
    "device_name"      VARCHAR(32) COLLATE "pg_catalog"."default",
    "preview"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "warn_id"          VARCHAR(64) COLLATE "pg_catalog"."default",
    "warn_code"        VARCHAR(128) COLLATE "pg_catalog"."default",
    "warn_channel"     VARCHAR(128) COLLATE "pg_catalog"."default",
    "warn_name"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "warn_type"        VARCHAR(64) COLLATE "pg_catalog"."default",
    "warn_level"       INT4,
    "warn_level_name"  VARCHAR(32) COLLATE "pg_catalog"."default",
    "confirm_status"   INT4,
    "position"         GEOMETRY,
    "warn_time"        TIMESTAMPTZ,
    "properties"       jsonb,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);
COMMENT ON COLUMN "public"."arl_warn_file"."filename" IS '文件名';
COMMENT ON COLUMN "public"."arl_warn_file"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_warn_file"."file_path" IS '文件路径';
COMMENT ON COLUMN "public"."arl_warn_file"."task_id" IS '任务id';
COMMENT ON COLUMN "public"."arl_warn_file"."object_key" IS '存储路径';
COMMENT ON COLUMN "public"."arl_warn_file"."device_id" IS '设备id';
COMMENT ON COLUMN "public"."arl_warn_file"."device_sn" IS '设备sn编码';
COMMENT ON COLUMN "public"."arl_warn_file"."device_name" IS '设备名称';
COMMENT ON COLUMN "public"."arl_warn_file"."preview" IS '预览参数';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_id" IS '告警id';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_code" IS '告警编码';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_channel" IS '告警通道';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_name" IS '告警名称';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_level" IS '告警级别';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_level_name" IS '告警级别名称';
COMMENT ON COLUMN "public"."arl_warn_file"."confirm_status" IS '确认状态';
COMMENT ON COLUMN "public"."arl_warn_file"."position" IS '位置数据';
COMMENT ON COLUMN "public"."arl_warn_file"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."arl_warn_file"."properties" IS '扩展属性';



ALTER TABLE "public"."arl_warn_file"
    ADD CONSTRAINT "PK_ARL_WARN_FILE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_WORKSPACE_ID" ON "public"."arl_warn_file" USING BTREE (
   "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_TASK_ID" ON "public"."arl_warn_file" USING BTREE (
   "task_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_DEVICE_ID" ON "public"."arl_warn_file" USING BTREE (
   "device_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_WARN_CHANNEL" ON "public"."arl_warn_file" USING BTREE (
    "warn_channel" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_WARN_TYPE" ON "public"."arl_warn_file" USING BTREE (
    "warn_type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_WARN_TIME" ON "public"."arl_warn_file" USING BTREE (
   "warn_time" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_POSITION" ON "public"."arl_warn_file" USING GIST (
   "position" "public"."gist_geometry_ops_2d"
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_FILE_PROPERTIES" ON "public"."arl_warn_file" USING GIN (
   ("properties" -> 'value'::text) "pg_catalog"."jsonb_ops"
    );


DROP TABLE IF EXISTS "public"."arl_warn_type";
CREATE TABLE "public"."arl_warn_type"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default",
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "value"            VARCHAR(64) COLLATE "pg_catalog"."default",
    "level"            INT4
);
COMMENT ON COLUMN "public"."arl_warn_type"."workspace_id" IS '工作空间id';
COMMENT ON COLUMN "public"."arl_warn_type"."name" IS '类型名称';
COMMENT ON COLUMN "public"."arl_warn_type"."value" IS '类型值';
COMMENT ON COLUMN "public"."arl_warn_type"."level" IS '告警级别';

ALTER TABLE "public"."arl_warn_type"
    ADD CONSTRAINT "PK_ARL_WARN_TYPE_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_WARN_TYPE_WORKSPACE_ID" ON "public"."arl_warn_type" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

INSERT INTO "arl_warn_type" ("id", "workspace_id", "name", "value", "level") VALUES ('1835942778298056701', '1835974778298056789','火焰', 'fire', 3);
INSERT INTO "arl_warn_type" ("id", "workspace_id", "name", "value", "level") VALUES ('1835942778298056702', '1835974778298056789','安全帽', 'helmet', 2);
INSERT INTO "arl_warn_type" ("id", "workspace_id", "name", "value", "level") VALUES ('1835942778298056703', '1835974778298056789','人员', 'person', 0);
INSERT INTO "arl_warn_type" ("id", "workspace_id", "name", "value", "level") VALUES ('1835942778298056704', '1835974778298056789','反光衣', 'safedress', 1);
