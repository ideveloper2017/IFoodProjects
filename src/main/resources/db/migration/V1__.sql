CREATE TABLE apps
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    class_name   VARCHAR(255),
    icon         VARCHAR(255),
    description  VARCHAR(255),
    state        INTEGER,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_apps PRIMARY KEY (id)
);

CREATE TABLE apps_help
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    str_val      VARCHAR(255),
    state        INTEGER,
    orderby      INTEGER,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_apps_help PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255)                             NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE permission
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_permission PRIMARY KEY (id)
);

CREATE TABLE role_permissions
(
    permission_id BIGINT NOT NULL,
    role_id       BIGINT NOT NULL,
    CONSTRAINT pk_role_permissions PRIMARY KEY (permission_id, role_id)
);

CREATE TABLE roles
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE ss_categories
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    parent_id     BIGINT,
    name          VARCHAR(255)                            NOT NULL,
    department_id BIGINT,
    color_button  VARCHAR(255),
    color_text    VARCHAR(255),
    text_size     VARCHAR(255),
    image         VARCHAR(255),
    orderby       INTEGER,
    state         BOOLEAN,
    created_date  TIMESTAMP WITHOUT TIME ZONE,
    update_date   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_categories PRIMARY KEY (id)
);

CREATE TABLE ss_departments
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    orderby      BYTEA,
    warehouse_id BIGINT,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_departments PRIMARY KEY (id)
);

CREATE TABLE ss_goods
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    category_id  BIGINT,
    name         VARCHAR(255),
    unit_id      BIGINT,
    price        BIGINT,
    percent      INTEGER,
    price_sell   BIGINT,
    state        BOOLEAN,
    by_service   BOOLEAN,
    by_time      BOOLEAN,
    play_time    BIGINT,
    orderby      INTEGER,
    image        VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_goods PRIMARY KEY (id)
);

CREATE TABLE ss_hall
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_hall PRIMARY KEY (id)
);

CREATE TABLE ss_remakes
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    num          INTEGER,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_remakes PRIMARY KEY (id)
);

CREATE TABLE ss_send_state
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_send_state PRIMARY KEY (id)
);

CREATE TABLE ss_services
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255)                            NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_services PRIMARY KEY (id)
);

CREATE TABLE ss_table
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    is_service   INTEGER,
    hall_id      INTEGER,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_table PRIMARY KEY (id)
);

CREATE TABLE ss_unit
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    status       BOOLEAN,
    orderby      INTEGER,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_unit PRIMARY KEY (id)
);

CREATE TABLE ss_warehouse
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ss_warehouse PRIMARY KEY (id)
);

CREATE TABLE users
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username     VARCHAR(255)                            NOT NULL,
    password     VARCHAR(255)                            NOT NULL,
    first_name   VARCHAR(255)                            NOT NULL,
    last_name    VARCHAR(255)                            NOT NULL,
    email        VARCHAR(255)                            NOT NULL,
    active       BOOLEAN                                 NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    update_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

ALTER TABLE ss_categories
    ADD CONSTRAINT FK_SS_CATEGORIES_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES ss_departments (id);

ALTER TABLE ss_departments
    ADD CONSTRAINT FK_SS_DEPARTMENTS_ON_WAREHOUSE FOREIGN KEY (warehouse_id) REFERENCES ss_warehouse (id);

ALTER TABLE ss_goods
    ADD CONSTRAINT FK_SS_GOODS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES ss_categories (id);

ALTER TABLE ss_goods
    ADD CONSTRAINT FK_SS_GOODS_ON_UNIT FOREIGN KEY (unit_id) REFERENCES ss_unit (id);

ALTER TABLE ss_table
    ADD CONSTRAINT FK_SS_TABLE_ON_HALL FOREIGN KEY (hall_id) REFERENCES ss_hall (id);

ALTER TABLE role_permissions
    ADD CONSTRAINT fk_rolper_on_permission FOREIGN KEY (permission_id) REFERENCES permission (id);

ALTER TABLE role_permissions
    ADD CONSTRAINT fk_rolper_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (id);
