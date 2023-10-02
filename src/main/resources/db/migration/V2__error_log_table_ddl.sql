create table if not exists error_log (
    id uuid primary key default gen_random_uuid(),
    type varchar(255),
    http_status_code int,
    message varchar(255),
    created_date timestamp default now()
);

comment on table error_log is 'Stores error log information';
comment on column error_log.id is 'Unique identifier for the error log. Type is uuid';
comment on column error_log.type is 'Error type. Type is varchar(255)';
comment on column error_log.http_status_code is 'Http status code. Type is int';
comment on column error_log.message is 'Error message. Type is varchar(255)';
comment on column error_log.created_date is 'Created date of the error log. Type is timestamp and default is now()';