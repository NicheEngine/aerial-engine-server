

DROP TABLE IF EXISTS "public"."arl_user";
CREATE TABLE "public"."arl_user"
(
    "id"               VARCHAR(64) COLLATE "pg_catalog"."default"  NOT NULL,
    "name"             VARCHAR(256) COLLATE "pg_catalog"."default",
    "description"      VARCHAR(1024) COLLATE "pg_catalog"."default",
    "username"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "password"         VARCHAR(256) COLLATE "pg_catalog"."default",
    "logic"       INT4,
    "create_time"      TIMESTAMPTZ,
    "update_time"      TIMESTAMPTZ
);

ALTER TABLE "public"."arl_user"
    ADD CONSTRAINT "PK_ARL_USER_ID" PRIMARY KEY ("id");

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_NAME" ON "public"."arl_user" USING BTREE (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_USERNAME" ON "public"."arl_user" USING BTREE (
    "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_LOGIC" ON "public"."arl_user" USING BTREE (
    "logic" "pg_catalog"."int4_ops" ASC NULLS LAST
    );

INSERT INTO "public"."arl_user" ("id",  "name", "description", "username", "password", "logic", "create_time", "update_time")
VALUES ('1835974778298056704', 'testUser', 'test user', 'test', '941121347CFDD1A334FABCA970C1B9137B5E105470AC55C2B48A1B59492661AD',1, now(), now());

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
