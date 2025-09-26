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
