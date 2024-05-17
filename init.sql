CREATE TABLE Task (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description VARCHAR(1000),
                      completed BOOLEAN NOT NULL DEFAULT FALSE
);
