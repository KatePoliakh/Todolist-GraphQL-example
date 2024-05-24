CREATE TABLE IF NOT EXISTS Task (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description VARCHAR(1000),
                      completed BOOLEAN NOT NULL DEFAULT FALSE
);
