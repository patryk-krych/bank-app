CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       password TEXT NOT NULL,
                       first_name VARCHAR(40) NOT NULL,
                       second_name VARCHAR(40),
                       last_name VARCHAR(40) NOT NULL,
                       birthday DATE NOT NULL
);

CREATE TABLE accounts (
                          account_id CHAR(26) PRIMARY KEY,
                          user_id INTEGER NOT NULL,
                          currency VARCHAR(3) NOT NULL,
                          balance NUMERIC(14,2) NOT NULL DEFAULT 0,
                          CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              from_account_id CHAR(26) NOT NULL,
                              to_account_id CHAR(26) NOT NULL,
                              amount NUMERIC(10,2) NOT NULL,
                              currency VARCHAR(3) NOT NULL,
                              date TIMESTAMPTZ NOT NULL,
                              title TEXT NOT NULL,
                              CONSTRAINT fk_from_account FOREIGN KEY (from_account_id) REFERENCES accounts (account_id),
                              CONSTRAINT fk_to_account FOREIGN KEY (to_account_id) REFERENCES accounts (account_id)
);

INSERT INTO users (id, password, first_name, second_name, last_name, birthday)
VALUES
    (1, 'test123', 'Jan', 'Marek', 'Kowalski', '1990-05-15'),
    (2, 'test123', 'Anna', NULL, 'Nowak', '1985-12-01');

INSERT INTO accounts (account_id, user_id, currency, balance)
VALUES
    ('ACC00000000000000000000001', 1, 'PLN', 15000.00),
    ('ACC00000000000000000000002', 2, 'PLN', 25000.00);
