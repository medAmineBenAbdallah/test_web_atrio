CREATE TABLE person (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        birth_date DATE NOT NULL
);

CREATE TABLE job (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     company VARCHAR(255) NOT NULL,
                     position VARCHAR(255) NOT NULL,
                     start_date DATE NOT NULL,
                     end_date DATE,
                     person_id BIGINT,
                     FOREIGN KEY (person_id) REFERENCES person(id)
                 );
