SET CHARSET UTF8;
create table sample.users(
  id bigint(20) unsigned AUTO_INCREMENT PRIMARY KEY,
  name varchar(100),
  age tinyint,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME
);
INSERT INTO sample.users(name,age) VALUES ('yamane',30),('yamane2',25),('yamane3',19);