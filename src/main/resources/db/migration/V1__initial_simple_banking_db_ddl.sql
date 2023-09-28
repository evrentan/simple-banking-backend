create table if not exists bank_account
(
    id          uuid primary key default gen_random_uuid(),
    account_number  varchar(255),
    owner  varchar(255),
    balance     decimal(19, 2),
    created_date timestamp default now()
);

comment on table bank_account is 'Stores bank account information';
comment on column bank_account.id is 'Unique identifier for the bank account. Type is uuid';
comment on column bank_account.account_number is 'Account number of the bank account. Type is varchar(255)';
comment on column bank_account.owner is 'Owner of the bank account. Type is varchar(255)';
comment on column bank_account.balance is 'Balance of the bank account. Type is decimal(19, 2)';
comment on column bank_account.created_date is 'Created date of the bank account. Type is timestamp and default is now()';

create table if not exists transaction
(
    id  uuid primary key default gen_random_uuid(),
    date timestamp default now(),
    amount     decimal(19, 2),
    type varchar(255)
);

comment on table transaction is 'Stores transaction information';
comment on column transaction.id is 'Unique identifier for the transaction. Type is uuid';
comment on column transaction.date is 'Date of the transaction. Type is timestamp and default is now()';
comment on column transaction.amount is 'Amount of the transaction. Type is decimal(19, 2)';
comment on column transaction.type is 'Type of the transaction. Type is varchar(255)';

create table if not exists bank_account_transaction
(
    id          uuid primary key default gen_random_uuid(),
    bank_account_id uuid,
    transaction_id uuid,
    foreign key (bank_account_id) references bank_account(id),
    foreign key (transaction_id) references transaction(id)
);

comment on table bank_account_transaction is 'Stores bank account transaction information';
comment on column bank_account_transaction.id is 'Unique identifier for the bank account transaction. Type is uuid';
comment on column bank_account_transaction.bank_account_id is 'Unique identifier for the bank account. Type is uuid. Foreign key to bank_account.id';
