CREATE KEYSPACE events WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
USE events;

CREATE TABLE event (
  sku bigint,
  category1 bigint,
  category2 bigint,
  category3 bigint,
  category4 bigint,
  indicator1 bigint,
  indicator2 bigint,
  indicator3 bigint,
  indicator4 bigint,
  indicator5 bigint,
  indicator6 bigint,
  indicator7 bigint,
  indicator8 bigint,
  indicator9 bigint,
  indicator10 bigint,
  indicator11 bigint,
  indicator12 bigint,
  indicator13 bigint,
  indicator14 bigint,
  indicator15 bigint,
  indicator16 bigint,
  indicator17 bigint,
  indicator18 bigint,
  indicator19 bigint,
  indicator20 bigint,
  PRIMARY KEY (sku)
);


CREATE TABLE event2 (
  sku bigint,
  category1 bigint,
  category2 bigint,
  category3 bigint,
  category4 bigint,
  indicators map<text, bigint>,
  PRIMARY KEY (sku)
);