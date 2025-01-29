CREATE TABLE students (
    id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    gender INTEGER,
    dob DATE,
    phone_number VARCHAR(255),
    card VARCHAR(255),
    created_date TIMESTAMP,
    created_by VARCHAR(255),
    deleted_date TIMESTAMP,
    deleted_by VARCHAR(255)
);