create user payment identified by payment;
alter user payment quota 100m on system;

grant create session to payment;

grant create table to payment;
grant create procedure to payment;
grant create trigger to payment;
grant create view to payment;
grant create sequence to payment;

grant alter any table to payment;
grant alter any procedure to payment;
grant alter any trigger to payment;
grant alter profile to payment;

grant delete any table to payment;
grant drop any table to payment;
grant drop any procedure to payment;
grant drop any trigger to payment;
grant drop any view to payment;
grant drop profile to payment;

----------------------------------------------
-- Export file for user PAYMENT             --
-- Created by irina on 02.06.2016, 14:42:27 --
----------------------------------------------

spool PaymentsDB.log

prompt
prompt Creating table HOAS
prompt ===================
prompt
create table PAYMENT.HOAS
(
  HOA_ID      NUMBER(10) not null,
  HOA_NAME    VARCHAR2(255 CHAR) not null,
  HOA_ADDRESS VARCHAR2(255 CHAR) not null,
  HOA_WEBSITE VARCHAR2(255 CHAR),
  HOA_PHONE   VARCHAR2(255 CHAR)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.HOAS
  is 'ТСЖ';
comment on column PAYMENT.HOAS.HOA_ID
  is 'ID ТСЖ';
comment on column PAYMENT.HOAS.HOA_NAME
  is 'Название ТСЖ';
comment on column PAYMENT.HOAS.HOA_ADDRESS
  is 'Юридический адрес';
comment on column PAYMENT.HOAS.HOA_WEBSITE
  is 'Сайт';
comment on column PAYMENT.HOAS.HOA_PHONE
  is 'Телефон';
alter table PAYMENT.HOAS
  add constraint PK_HOAS_HOA_ID primary key (HOA_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ADDRESSES
prompt ========================
prompt
create table PAYMENT.ADDRESSES
(
  ADDRESS_ID     NUMBER(10) not null,
  RESIDENT_CNT   NUMBER(10) default 0 not null,
  REGISTERED_CNT NUMBER(10) not null,
  HOA_ID         NUMBER(10) not null,
  STREET         VARCHAR2(255 CHAR),
  HOUSE          NUMBER(5),
  BUILDING       VARCHAR2(255 CHAR),
  APARTMENT      NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.ADDRESSES
  is 'Адреса прописки';
comment on column PAYMENT.ADDRESSES.ADDRESS_ID
  is 'ID адреса';
comment on column PAYMENT.ADDRESSES.RESIDENT_CNT
  is 'Кол-во проживающих';
comment on column PAYMENT.ADDRESSES.REGISTERED_CNT
  is 'Кол-во зарегистрированных';
comment on column PAYMENT.ADDRESSES.HOA_ID
  is 'Id ТСЖ';
comment on column PAYMENT.ADDRESSES.STREET
  is 'Улица';
comment on column PAYMENT.ADDRESSES.HOUSE
  is 'Номер дома';
comment on column PAYMENT.ADDRESSES.BUILDING
  is 'Корпус';
comment on column PAYMENT.ADDRESSES.APARTMENT
  is 'Квартира';
alter table PAYMENT.ADDRESSES
  add constraint PK_ADDRESSES_ADDRESS_ID primary key (ADDRESS_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.ADDRESSES
  add constraint FK_ADDRESSES_HOA_ID foreign key (HOA_ID)
  references PAYMENT.HOAS (HOA_ID);
alter table PAYMENT.ADDRESSES
  add constraint CK_APARTMENT_ADDRESSES
  check (apartment>0);
alter table PAYMENT.ADDRESSES
  add constraint CK_HOUSE_ADDRESSES
  check (house>0);
alter table PAYMENT.ADDRESSES
  add constraint NN_HOUSE_ADDRESSES
  check ("HOUSE" IS NOT NULL);
alter table PAYMENT.ADDRESSES
  add constraint NN_STREET_ADDRESSES
  check ("STREET" IS NOT NULL);

prompt
prompt Creating table PROVIDERS
prompt ========================
prompt
create table PAYMENT.PROVIDERS
(
  PROVIDER_ID      NUMBER(10) not null,
  PROVIDER_NAME    VARCHAR2(20),
  PROVIDER_ADDRESS VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.PROVIDERS
  is 'Поставщики услуг';
comment on column PAYMENT.PROVIDERS.PROVIDER_ID
  is 'ID поставщика';
comment on column PAYMENT.PROVIDERS.PROVIDER_NAME
  is 'Название';
comment on column PAYMENT.PROVIDERS.PROVIDER_ADDRESS
  is 'Юридический адрес';
alter table PAYMENT.PROVIDERS
  add constraint PK_PROVIDERS_PROVIDER_ID primary key (PROVIDER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SERVICES
prompt =======================
prompt
create table PAYMENT.SERVICES
(
  SERVICE_ID   NUMBER(10) not null,
  SERVICE_NAME VARCHAR2(255 CHAR) not null,
  PROVIDER_ID  NUMBER(10) not null,
  IS_METER     NUMBER(1) default 0 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.SERVICES
  is 'Услуга';
comment on column PAYMENT.SERVICES.SERVICE_ID
  is 'ID услуги';
comment on column PAYMENT.SERVICES.SERVICE_NAME
  is 'Название услуги';
comment on column PAYMENT.SERVICES.PROVIDER_ID
  is 'ID поставщика услуг';
comment on column PAYMENT.SERVICES.IS_METER
  is 'Установлен ли счетчик (1 - Да, 0 - нет)';
alter table PAYMENT.SERVICES
  add constraint PK_SERVICES_SERVICE_ID primary key (SERVICE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.SERVICES
  add constraint FK_SERVICES_PROVIDER_ID foreign key (PROVIDER_ID)
  references PAYMENT.PROVIDERS (PROVIDER_ID);
alter table PAYMENT.SERVICES
  add constraint CK_SERVICES_METER
  check (IS_METER in (0,1));

prompt
prompt Creating table ABONENTS
prompt =======================
prompt
create table PAYMENT.ABONENTS
(
  ABONENT_ID      NUMBER(10) not null,
  SERVICE_ID      NUMBER(10) not null,
  ABONENT_ACCOUNT NUMBER(20) not null,
  ADDRESS_ID      NUMBER(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.ABONENTS
  is 'Абонент';
comment on column PAYMENT.ABONENTS.ABONENT_ID
  is 'ID абонента';
comment on column PAYMENT.ABONENTS.SERVICE_ID
  is 'ID услуги';
comment on column PAYMENT.ABONENTS.ABONENT_ACCOUNT
  is 'Счет абонента';
comment on column PAYMENT.ABONENTS.ADDRESS_ID
  is 'ID адреса';
alter table PAYMENT.ABONENTS
  add constraint PK_ABONENTS_ABONENT_ID primary key (ABONENT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.ABONENTS
  add constraint UQ_ABONENTS_ABONENT_ACCOUNT unique (ABONENT_ACCOUNT)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.ABONENTS
  add constraint FK_ABONENTS_ADDRESS_ID foreign key (ADDRESS_ID)
  references PAYMENT.ADDRESSES (ADDRESS_ID);
alter table PAYMENT.ABONENTS
  add constraint FK_ABONENTS_SERVICE_ID foreign key (SERVICE_ID)
  references PAYMENT.SERVICES (SERVICE_ID);

prompt
prompt Creating table CHARGES
prompt ======================
prompt
create table PAYMENT.CHARGES
(
  CHARGE_ID         NUMBER(10) not null,
  ABONENT_ID        NUMBER(10),
  CHARGE_AMOUNT     NUMBER(10,2),
  PERIOD_BEGIN_DATE DATE,
  PERIOD_END_DATE   DATE,
  CHARGE_PAID       NUMBER(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.CHARGES
  is 'Начисления';
comment on column PAYMENT.CHARGES.CHARGE_ID
  is 'Id начисления';
comment on column PAYMENT.CHARGES.ABONENT_ID
  is 'Id абонента';
comment on column PAYMENT.CHARGES.CHARGE_AMOUNT
  is 'Сумма начисления';
comment on column PAYMENT.CHARGES.PERIOD_BEGIN_DATE
  is 'Дата начала периода';
comment on column PAYMENT.CHARGES.PERIOD_END_DATE
  is 'Дата окончания периода';
comment on column PAYMENT.CHARGES.CHARGE_PAID
  is 'Признак полной оплаты(1/0)';
alter table PAYMENT.CHARGES
  add constraint PK_CHARGES_CHARGE_ID primary key (CHARGE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.CHARGES
  add constraint FK_CHARGES_ABONENT_ID foreign key (ABONENT_ID)
  references PAYMENT.ABONENTS (ABONENT_ID);
alter table PAYMENT.CHARGES
  add constraint CHECK_CHARGE_PAID
  check (CHARGE_PAID in (0,1));

prompt
prompt Creating table PAYMENTS
prompt =======================
prompt
create table PAYMENT.PAYMENTS
(
  PAYMENT_ID     NUMBER(10) not null,
  CHARGE_ID      NUMBER(10),
  PAYMENT_AMOUNT NUMBER(10,2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.PAYMENTS
  is 'Платежи';
comment on column PAYMENT.PAYMENTS.PAYMENT_ID
  is 'ID платежа';
comment on column PAYMENT.PAYMENTS.CHARGE_ID
  is 'ID начисления';
comment on column PAYMENT.PAYMENTS.PAYMENT_AMOUNT
  is 'Фактическая сумма оплаты';
alter table PAYMENT.PAYMENTS
  add constraint PK_PAYMENTS_PAYMENT_ID primary key (PAYMENT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.PAYMENTS
  add constraint FK_PAYMENTS_CHARGE_ID foreign key (CHARGE_ID)
  references PAYMENT.CHARGES (CHARGE_ID);

prompt
prompt Creating table RESIDENTS
prompt ========================
prompt
create table PAYMENT.RESIDENTS
(
  RESIDENT_ID   NUMBER(10) not null,
  ADDRESS_ID    NUMBER(10) not null,
  RESIDENT_NAME VARCHAR2(50) not null,
  MAIN_OWNER    NUMBER(1) default 0 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.RESIDENTS
  is 'Жильцы';
comment on column PAYMENT.RESIDENTS.RESIDENT_ID
  is 'ID жильца';
comment on column PAYMENT.RESIDENTS.ADDRESS_ID
  is 'ID адреса';
comment on column PAYMENT.RESIDENTS.RESIDENT_NAME
  is 'ФИО жильца';
alter table PAYMENT.RESIDENTS
  add constraint PK_RESIDENTS_RESIDENT_ID primary key (RESIDENT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.RESIDENTS
  add constraint FK_RESIDENTS_ADDRESS_ID foreign key (ADDRESS_ID)
  references PAYMENT.ADDRESSES (ADDRESS_ID);
alter table PAYMENT.RESIDENTS
  add constraint CHK_MAIN_OWNER
  check (MAIN_OWNER in (0,1));

prompt
prompt Creating table ROLES
prompt ====================
prompt
create table PAYMENT.ROLES
(
  ROLE_ID   VARCHAR2(20 CHAR) not null,
  ROLE_NAME VARCHAR2(255 CHAR)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.ROLES
  is 'Роли';
comment on column PAYMENT.ROLES.ROLE_ID
  is 'Код роли';
comment on column PAYMENT.ROLES.ROLE_NAME
  is 'Название роли';
alter table PAYMENT.ROLES
  add constraint PK_ROLES_ROLE_ID primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table USERS
prompt ====================
prompt
create table PAYMENT.USERS
(
  USER_ID       VARCHAR2(20) not null,
  USER_PASSWORD VARCHAR2(30) not null,
  ADDRESS_ID    NUMBER(10) not null,
  ROLE_ID       VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table PAYMENT.USERS
  is 'Пользователи';
comment on column PAYMENT.USERS.USER_ID
  is 'ID пользователя';
comment on column PAYMENT.USERS.USER_PASSWORD
  is 'Пароль пользователя';
comment on column PAYMENT.USERS.ADDRESS_ID
  is 'ID адреса';
comment on column PAYMENT.USERS.ROLE_ID
  is 'ID роли';
alter table PAYMENT.USERS
  add constraint PK_USERS_USER_ID primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table PAYMENT.USERS
  add constraint FK_USERS_ADDRESS_ID foreign key (ADDRESS_ID)
  references PAYMENT.ADDRESSES (ADDRESS_ID);
alter table PAYMENT.USERS
  add constraint FK_USERS_ROLE_ID foreign key (ROLE_ID)
  references PAYMENT.ROLES (ROLE_ID);


spool off
