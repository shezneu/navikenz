create table if not exists consumer
(
    id                            bigint primary key auto_increment,
    email                         varchar(70) not null,
    identification_no             varchar(50) not null,
    identification_type           varchar(10) not null,
    consent_given                 bool,
    terms_and_conditions_accepted bool
)