
DROP TABLE IF EXISTS "public"."arl_workspace";
CREATE TABLE "public"."arl_workspace"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "bind_code"        VARCHAR(256) COLLATE "pg_catalog"."default",
    "platform"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "logic"            INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

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
