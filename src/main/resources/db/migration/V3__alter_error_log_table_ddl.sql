alter table error_log add column account_number varchar(255);

comment on column error_log.account_number is 'Account number of the bank account. Type is varchar(255)';