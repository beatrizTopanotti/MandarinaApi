CREATE UNIQUE INDEX IF NOT EXISTS index_cod_prod ON public.produtos USING btree (codigo_produto) WHERE (deleted_at IS NULL);

INSERT INTO public.produtos
(codigo_produto, descricao, imagem_grande, imagem_pequena, nome, categoria)
VALUES('PRO202401', 'Produto de teste 1', 'https://cdn.pixabay.com/photo/2013/11/24/11/10/lab-217043_1280.jpg', 'https://cdn.pixabay.com/photo/2013/11/24/11/10/lab-217043_1280.jpg', 'Produto 1', 'ORGANIZACAO') ON conflict DO nothing;

INSERT INTO public.produtos
(codigo_produto, descricao, imagem_grande, imagem_pequena, nome, categoria)
VALUES('PRO202402', 'Produto de teste 2', 'https://cdn.pixabay.com/photo/2017/06/28/10/53/board-2450236_1280.jpg', 'https://cdn.pixabay.com/photo/2017/06/28/10/53/board-2450236_1280.jpg', 'Produto 2', 'ORGANIZACAO') ON conflict DO nothing;

INSERT INTO public.produtos
(codigo_produto, descricao, imagem_grande, imagem_pequena, nome, categoria)
VALUES('PRO202403', 'Produto de teste 3', 'https://cdn.pixabay.com/photo/2017/06/28/10/53/board-2450236_1280.jpg', 'https://cdn.pixabay.com/photo/2017/06/28/10/53/board-2450236_1280.jpg', 'Produto 3', 'ORGANIZACAO') ON conflict DO nothing;

INSERT INTO public.produtos
(codigo_produto, descricao, imagem_grande, imagem_pequena, nome, categoria)
VALUES('PRO202404', 'Produto de teste 4', 'https://cdn.pixabay.com/photo/2017/10/05/21/45/laboratory-2821207_1280.jpg', 'https://cdn.pixabay.com/photo/2017/10/05/21/45/laboratory-2821207_1280.jpg', 'Produto 4', 'ORGANIZACAO') ON conflict DO nothing;

INSERT INTO public.produtos
(codigo_produto, descricao, imagem_grande, imagem_pequena, nome, categoria)
VALUES('PRO202405', 'Produto de teste 5', 'https://cdn.pixabay.com/photo/2014/04/05/11/39/read-316508_1280.jpg', 'https://cdn.pixabay.com/photo/2014/04/05/11/39/read-316508_1280.jpg', 'Produto 5', 'ORGANIZACAO') ON conflict DO nothing;

CREATE UNIQUE INDEX IF NOT EXISTS index_prod_precos ON public.produtos_precos USING btree (produtos_id) WHERE (deleted_at IS NULL);

INSERT INTO public.produtos_precos
(id, preco, produtos_id)
VALUES(1, 10.0, (select id from produtos p where p.codigo_produto = 'PRO202401'))  ON conflict DO nothing ;

INSERT INTO public.produtos_precos
(id, preco, produtos_id)
VALUES(2, 30.0, (select id from produtos p where p.codigo_produto = 'PRO202402'))  ON conflict DO nothing ;

INSERT INTO public.produtos_precos
(id, preco, produtos_id)
VALUES(3, 40.0, (select id from produtos p where p.codigo_produto = 'PRO202403'))  ON conflict DO nothing ;

INSERT INTO public.produtos_precos
(id, preco, produtos_id)
VALUES(4, 50.0, (select id from produtos p where p.codigo_produto = 'PRO202404'))  ON conflict DO nothing ;

INSERT INTO public.produtos_precos
(id, preco, produtos_id)
VALUES(5, 60.0, (select id from produtos p where p.codigo_produto = 'PRO202405'))  ON conflict DO nothing ;

INSERT INTO public.cidades
(id, nome, estado)
VALUES(1, 'Criciúma', 'SC') ON conflict DO nothing;

INSERT INTO public.cidades
(id, nome, estado)
VALUES(2, 'Içara', 'SC') ON conflict DO nothing ;

INSERT INTO public.cidades
(id, nome, estado)
VALUES(3, 'Cocal do Sul', 'SC') ON conflict DO nothing;
