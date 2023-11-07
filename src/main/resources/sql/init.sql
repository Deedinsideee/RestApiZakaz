CREATE TABLE public.ORDERS
(
    id int PRIMARY KEY,
    customer_name varchar NOT NULL,
    customer_adress varchar NOT NULL,
    total_cost int NOT NULL,
    date_of_creation date NOT NULL
);

CREATE SEQUENCE sq_order_id START WITH 1 INCREMENT BY 1;

CREATE TABLE public.DETAILS
(
    id int NOT NULL,
    serial_number varchar NOT NULL,
    product_name varchar NOT NULL,
    amount int NOT NULL,
    order_id int NOT NULL
);

INSERT INTO public.ORDERS (id, customer_name, customer_adress, total_cost, date_of_creation)
VALUES
    (1, 'Иванов', 'Улица Пушкина, 123', 100, '2023-11-01'),
    (2, 'Петров', 'Улица Лермонтова, 456', 150, '2023-11-02');

INSERT INTO public.DETAILS (id, serial_number, product_name, amount, order_id)
VALUES
    (1, 'A001', 'Товар 1', 10, 1),
    (2, 'A002', 'Товар 2', 5, 1),
    (1, 'B001', 'Товар 3', 8, 2),
    (2, 'B002', 'Товар 4', 12, 2);