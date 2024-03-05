# FIAP.DELIVERY
API do Projeto FIAP.DELIVERY - Aplicação de delivery mobile

## Requisitos

- [ ] CRUD de Usuários
- [ ] CRUD de Produtos
- [ ] Registro de Pedidos
- [ ] Autenticação
- [ ] Cardápio

## Documentação da API

### Endpoints

- [Listar Produtos](#listar-produtos)
- [Cadastrar Produtos](#cadastrar-produtos)
- [Detalhar Produtos](#detalhar-produto)
- [Apagar Produtos](#apagar-produto)
- [Atualizar Produtos](#atualizar-produto)
---

### Listar Produtos

`GET` /produto

Retorna uma série de produtos sugeridos ao usuário


``` js 
[
    {
        "id": 1,
        "titulo": "Burguer",
        "icone": "burguer.jpg"
    }
]
```

#### Códigos de Status

| código | descrição <br>
|--------|----------
|200| Lista de produtos retornada com sucesso
|401| Não autenticado. Se autentique em /login
---

###  Cadastrar Produtos

`POST` /produto

Cadastra um produto com os dados enviados no corpo da requisição

#### Corpo de Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Nome curto para o produto
|icone|string|✅|Foto do produto 

#### Exemplo de Requisição
```js
// POST /produto
{
    "titulo": "Burguer"
}
```

#### Exemplo de Resposta
```js
{
    "id": 1,
    "titulo": "Burguer",
    "icone": "burguer.jpg"
}
```

#### Códigos de Status

|código|descrição
|------|----------
|201| Produto criado com sucesso
|400| Validação falhou. Verifique o corpo da requisição
|401| Não autenticado. Se autentique em /login
---

### Detalhar Produto

`GET`  /produto/`{id}`

Retorna os detalhes do produto com o `id` informado do path

#### Exemplo de Resposta
#### Exemplo de Resposta
```js
{
    "id": 1,
    "titulo": "Burguer",
    "icone": "burguer.jpg"
}
```

#### Códigos de Status

| código | descrição <br>
|--------|----------
|200| Lista de produtos retornada com sucesso
|401| Não autenticado. Se autentique em /login
|403| Não autorizado. Esse produto não pertence ao usuário autenticado
|404| Não existe produto com o `id` informado
---

### Apagar Produto

`DELETE` /produto/`{id}`

Apaga a categoria com o `id` informado no path

#### Códigos de Status

| código | descrição <br>
|--------|----------
|204| Produto apagado com sucesso
|401| Não autenticado. Se autentique em /login
|403| Não autorizado. Esse produto não pertence ao usuário autenticado
|404| Não existe produto com o `id` informado
---

### Atualizar Produto

`PUT` /produto/`{id}`

Atualiza os dados do produto com o `id` informado no path, utilizando as informações do corpo da requisição

#### Corpo de Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Nome curto para o produto
|icone|string|✅|Foto do produto 

#### Exemplo de Requisição
```js
// PUT /produto/1
{
    "titulo": "MegaBurguer",
    "icone": "burguer.jpg"
}
```

#### Exemplo de Resposta
```js
{
    "id": 1,
    "titulo": "MegaBurguer",
    "icone": "burguer.jpg"
}
```

#### Códigos de Status

|código|descrição
|------|----------
|200| Produto atualizado com sucesso
|400| Validação falhou. Verifique o corpo da requisição
|401| Não autenticado. Se autentique em /login
|403| Não autorizado. Esse produto não pertence ao usuário autenticado
|404| Não existe categoria com o `id` informado
---
