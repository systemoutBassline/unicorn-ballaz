
-- drop table unicorn.users;
create table unicorn.users (
    userid INT PRIMARY KEY,
    username varchar(256) NOT NULL,
    password varchar(256) NOT NULL
);

-- drop table unicorn.products;
create table unicorn.products (
    productid INT PRIMARY KEY,
    productname varchar(256) NOT NULL,
    description varchar(256) NOT NULL,
    ranking INTEGER NOT NULL
);
-- --insert into unicorn.products values(
--     2,
--     'Product 3',
--     'This is the text that describes Product 3. Hopefully something usefull can be read here.',
--     0
-- );

-- drop table unicorn.reviews;
create table unicorn.reviews (
    reviewid INT PRIMARY KEY,
    productid varchar(256) NOT NULL,
    userid INTEGER NOT NULL,
    ranking INTEGER NOT NULL,
    reviewheadline varchar(256) NOT NULL,
    review varchar(512) NOT NULL
);

insert into unicorn.users values (0, 'Cdmin', 'pass');

-- insert into products values(0, 'Product 1', 'This is where the infomative text about the product is to be..', 0);
-- insert into products values(1, 'Product 2', 'This is where the infomative text about the product is to be..', 0);
-- insert into products values(2, 'Product 3', 'This is where the infomative text about the product is to be..', 0);