
DROP TABLE IF EXISTS "public"."arl_user_role";
CREATE TABLE "public"."arl_user_role"
(
    "user_id"          VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "role_id"          VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
    "workspace_id"     VARCHAR(64) COLLATE "pg_catalog"."default" NOT NULL,
);

ALTER TABLE "public"."arl_user_role"
    ADD CONSTRAINT "PK_ARL_USER_ROLE_ID" PRIMARY KEY ("user_id","role_id","workspace_id");

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_NAME" ON "public"."arl_user_role" USING BTREE (
    "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_KEY" ON "public"."arl_user_role" USING BTREE (
    "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX if NOT EXISTS "IDX_ARL_USER_ROLE_KEY" ON "public"."arl_user_role" USING BTREE (
    "workspace_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );
