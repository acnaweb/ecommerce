insert into cliente(id, ativo, bairro, cep, complemento, data_cadastro, logradouro, municipio, 
nome, numero, uf) 
values (nextval('hibernate_sequence'), true, 'Jaguaré', '12345678', 'ap 1', current_timestamp(), 'Rua Abc', 'São Paulo', 'AC', '999', 'SP');

insert into cliente(id, ativo, bairro, cep, complemento, data_cadastro, logradouro, municipio, 
nome, numero, uf) 
values (nextval('hibernate_sequence'), true, 'Jaguaré', '12345678', 'ap 1', current_timestamp(), 'Rua Abc', 'São Paulo', 'DC', '999', 'SP');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 1500.50, 'ATIVO');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 2000, 'ATIVO');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 500, 'ENTREGUE');



