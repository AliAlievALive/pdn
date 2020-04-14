create table child
(
    id              integer      not null auto_increment,
    address         varchar(255) not null,
    birth_date      date not null,
    fio             varchar(255) not null,
    gift_date_pass  date,
    phone           varchar(255) not null,
    school          varchar(255) not null,
    serial_num_pass varchar(255),
    who_give_pass   varchar(255),
    primary key (id)
) engine = InnoDB;

create table child_parent
(

    child_id  integer not null,
    parent_id integer not null,
    primary key (child_id, parent_id)
) engine = InnoDB;

create table child_violations
(

    child_id      integer not null,
    violations_id bigint  not null,
    primary key (child_id, violations_id)
) engine = InnoDB;

create table parent
(

    id              integer not null auto_increment,
    address         varchar(255) not null,
    birth_date      date not null,
    fio             varchar(255) not null,
    gift_date_pass  date not null,
    phone           varchar(255) not null,
    serial_num_pass varchar(255) not null,
    who_give_pass   varchar(255) not null,
    work            varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table parent_child
(

    parent_id integer not null,
    child_id  integer not null,
    primary key (parent_id, child_id)
) engine = InnoDB;

create table public_educator
(

    id       integer not null auto_increment,
    address  varchar(255) not null,
    fio      varchar(255) not null,
    phone    varchar(255) not null,
    set_date date not null,
    work     varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table violation
(

    id                       bigint not null auto_increment,
    article_violation        varchar(255) not null,
    collected                varchar(255),
    date_of_decision         date default null,
    date_protocol            date not null,
    judgement_decision       varchar(255),
    notifications_count      integer,
    num_protocol             integer not null,
    punishment_type          varchar(255) not null,
    return_to_modify         bit,
    review_date              date default null,
    termination_because_date bit,
    violation_address        varchar(255) not null,
    child_id                 integer not null,
    primary key (id)
) engine = InnoDB;

alter table child
    add constraint child_fk unique (serial_num_pass);

alter table child_violations
    add constraint child_violations_fk unique (violations_id);

alter table child_parent
    add constraint child_parent_parent_fk foreign key (parent_id) references parent (id);

alter table child_parent
    add constraint child_parent_child_fk foreign key (child_id) references child (id);

alter table child_violations
    add constraint child_violations_viol_fk foreign key (violations_id) references violation (id);

alter table child_violations
    add constraint child_violations_child_fk foreign key (child_id) references child (id);

alter table parent_child
    add constraint parent_child_child_fk foreign key (child_id) references child (id);

alter table parent_child
    add constraint parent_child_par_fk foreign key (parent_id) references parent (id);

alter table violation
    add constraint violation_fk foreign key (child_id) references child (id);

