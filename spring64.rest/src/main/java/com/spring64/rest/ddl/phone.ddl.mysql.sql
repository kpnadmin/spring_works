




-- create a table TB_PERSON
DROP TABLE IF EXISTS TB_PERSON;
CREATE TABLE TB_PERSON (
      id        NVARCHAR(20)    NOT NULL
    , name      NVARCHAR(40)    NOT NULL
    , email     NVARCHAR(40)    NOT NULL
    , country   NVARCHAR(40)    NOT NULL
);

select * from TB_PERSON;


commit;
