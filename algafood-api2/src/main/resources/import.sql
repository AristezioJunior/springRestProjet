insert into cozinha (id, nome) values (1,'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');


insert into restaurante (nome, taxa_frete, cozinha_id) values ('Dona Florinda', 5, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Aristezio Bar', 3, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Malakas Bar', 3.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10.00, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15.00, 2);


    insert into estado (nome) values ('Minas Gerais');
    insert into estado (nome) values ('São Paulo');
    insert into estado (nome) values ('Ceará');

    insert into cidade (nome, estado_id) values ('Uberlândia', 1);
    insert into cidade (nome, estado_id) values ('Belo Horizonte', 1);
    insert into cidade (nome, estado_id) values ('São Paulo', 2);
    insert into cidade (nome, estado_id) values ('Campinas', 2);
    insert into cidade (nome, estado_id) values ('Fortaleza', 3);

    insert into forma_pagamento (descricao) values ('Cartão de crédito');
    insert into forma_pagamento (descricao) values ('Cartão de débito');
    insert into forma_pagamento (descricao) values ('Dinheiro');

    insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
    insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');