CREATE TABLE car (
                     id REAL PRIMARY KEY,
                     car_brand TEXT,
                     car_model TEXT,
                     price INTEGER

);
CREATE TABLE persons (
                       name TEXT PRIMARY KEY,
                       age INTEGER CHECK (age > 0),
                       license BOOLEAN,
                       car_id REAL REFERENCES car (id)
);

