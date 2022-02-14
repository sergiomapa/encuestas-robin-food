CREATE USER robinfood PASSWORD 'robin2022';

CREATE DATABASE encuestas_robinfood WITH OWNER robinfood;  

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO robinfood;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO robinfood;