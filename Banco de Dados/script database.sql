CREATE ROLE petservicos LOGIN ENCRYPTED PASSWORD 'md5392147c97dec212b268abb7f5b41d0fb'
  SUPERUSER CREATEDB CREATEROLE REPLICATION
   VALID UNTIL 'infinity'
   CONNECTION LIMIT 10;

CREATE DATABASE petservicos
  WITH ENCODING='UTF8'
	   OWNER=petservicos
       CONNECTION LIMIT=-1;

   
COMMENT ON DATABASE petservicos
  IS 'Sistema para contole de serviços feitos em um petshop.';
	   
/*
CREATE DATABASE petservicosteste
  WITH ENCODING='UTF8'
	   OWNER=petservicos
       CONNECTION LIMIT=-1;	   */