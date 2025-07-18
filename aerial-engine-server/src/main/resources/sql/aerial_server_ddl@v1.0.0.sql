

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

