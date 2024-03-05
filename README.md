<div align="center">
    <h2>⚜️ F I A P &nbsp; D E L I V E R Y ⚜️</h2>
</div>

<div align="center">
    <p>
        API do Projeto Fiap Delivery
    </p>
</div>

<hr/>

## 💡 Requisitos - Geral

- [ ] [Visualização do Cardápio](#-visualização-do-cardápio)
- [ ] [Visualização do Produto](#-visualização-do-produto)

## 💡 Requisitos - Usuários

- [ ] [Autenticação de Usuário](#-autenticação-de-usuário)
- [ ] [Registro de Usuário](#-registro-de-usuário)
- [ ] [Atualização das Informações do Usuário](#-atualização-das-informações-do-usuário)
- [ ] [Envio de Pedido](#-envio-de-pedido)
- [ ] [Histórico de Pedidos](#-histórico-de-pedidos)

## 💡 Requisitos - Admin

- [ ] [CRUD de Produtos](#-crud-de-produtos)

<br/><hr/>

## 📃 Documentação da API - Geral

### 💠 Visualização do Cardápio

`GET` /cardapio

Lista todos os produtos disponíveis.

#### Resposta - sucesso

```js
{
    cardapio: [
        {
            categoria: "sanduíche",
            produtos: [
                {
                    id: "1",
                    nome: "X-Fiapinho",
                    preco: 30,
                    porcentagem_desconto: 0,
                    ingredientes: "Pão, 2x carnes de 80g",
                    image: "...",
                }
            ]
        },
        {
            categoria: "pizza",
            produtos: [
                {...},
                {...}
            ]
        }
    ]
}
```

#### Resposta - erro

```js
{
    error: "Erro ao recuperar o cardápio.",
    message: "Ocorreu um erro ao processar a solicitação. Por favor, tente novamente."
}
```

#### Códigos de Status

| código | descrição                             |
| ------ | ------------------------------------- |
| 200    | O cardápio foi retornado com sucesso. |

<hr/>

### 💠 Visualização do Produto

`GET` /cardapio/`{id}`

Lista detalhadamente informações sobre o produto.

#### Requisição - via id

#### Resposta - sucesso

```js
{
    id: "1",
    nome: "X-Fiapinho",
    preco: 30,
    porcentagem_desconto: 0,
    ingredientes: "Pão, 2x carnes de 80g",
    image: "...",
}
```

#### Resposta - erro

```js
{
    error: "Produto não encontrado.",
    message: "O produto com o ID fornecido não foi encontrado."
}
```

#### Códigos de Status

| código | descrição                                  |
| ------ | ------------------------------------------ |
| 200    | Detalhes do produto retornado com sucesso. |
| 404    | Produto referente ao `{id}` não encontrado |

<br/><hr/>

## 📃 Documentação da API - Usuários

### 💠 Autenticação de Usuário

`POST` /login

Sistema de login de usuário

#### Requisição

```js
{
    email: "user@email.com",
    senha: "senha123",
}
```

#### Resposta - sucesso

```js
{
  id_usuario: "123",
  message: "Login bem-sucedido."
}
```

#### Resposta - erro

```js
{
  error: "Credenciais inválidas.",
  message: "Usuário não encontrado. Verifique suas credenciais."
}
```

#### Códigos de Status

| código | descrição               |
| ------ | ----------------------- |
| 200    | Login bem-sucedido.     |
| 401    | Usuário não autorizado. |

<hr/>

### 💠 Registro de Usuário

`POST` /registro

Cadastra um usuário no sistema

#### Requisição

```js
{
    nome: "usuario",
    sobrenome: "balacobaco",
    email: "user@email.com",
    senha: "senha123",
    cep: "99999222",
    numero: 444
}
```

#### Resposta - sucesso

```js
{
    id_usuario: "123",
    message: "Usuário cadastrado com sucesso."
}
```

#### Resposta - erro

```js
{
    erro: "Erro ao cadastrar usuário",
    message: "Usuário já existente. Verifique e/ou altere suas credenciais."
}
```

#### Códigos de Status

| código | descrição                                                                    |
| ------ | ---------------------------------------------------------------------------- |
| 201    | Usuário cadastrado com sucesso.                                              |
| 400    | Requisição inválida, dados ausentes, mal formatados ou usuário já existente. |

<hr/>

### 💠 Atualização das Informações do Usuário

`GET` /usuario

Obtém as informações do usuário.

#### Resposta - sucesso

```js
{
    id_usuario: "123",
    nome: "Usuario",
    sobrenome: "Balacobaco",
    email: "user@email.com",
    senha: "senha123",
    cep: "99999222",
    numero: 444
}
```

#### Resposta - erro

```js
{
    error: "Configurações do usuário não encontradas.",
    message: "Não foi possível encontrar as configurações para o usuário especificado."
}
```

#### Códigos de Status

| código | descrição                                  |
| ------ | ------------------------------------------ |
| 200    | Configurações retornadas com sucesso.      |
| 401    | Configurações de usuário não encontradas . |

<br/>

`PUT` /usuario

Altera informações do usuário.

#### Requisição

```js
{
  id_usuario: "123",
  cep: "00077111",
  numero: 777
  senha: "novaSenha123"
}

// OU

{
  id_usuario: "123",
  senha: "novaSenha123"
}
```

#### Resposta - sucesso

```js
{
  message: "Configurações do usuário atualizadas com sucesso.";
}
```

#### Resposta - erro

```js
{
  error: "Erro ao atualizar as configurações do usuário.",
  message: "Ocorreu um erro ao processar a atualização das configurações do usuário."
}
```

#### Códigos de Status

| código | descrição                                                              |
| ------ | ---------------------------------------------------------------------- |
| 200    | Configurações do usuário foram atualizadas com sucesso.                |
| 400    | Requisição inválida, como dados de entrada ausentes ou mal formatados. |

<hr/>

### 💠 Envio de pedido

`POST` /pedido

Envia para o sistema os detalhes do pedido feito pelo usuário

#### Requisição

```js
{
    id_usuario: "123",
    produtos: [
        {
            id_produto: "1",
            quantidade: 2
        },
        {
            id_produto: "3",
            quantidade: 1
        }
    ],
    total: 90,
}
```

#### Resposta - sucesso

```js
{
  id_pedido: "123123",
  message: "Pedido realizado com sucesso."
}
```

#### Resposta - erro

```js
{
    error: "Error ao realizar pedido",
    message: "Ocorreu um erro ao processar o pedido. Por favor, tente novamente."
}
```

#### Códigos de Status

| código | descrição                                        |
| ------ | ------------------------------------------------ |
| 201    | Pedido realizado com sucesso.                    |
| 400    | Pedido inválido. Dados ausente ou mal formatados |

<hr/>

### 💠 Histórico de pedidos

`GET` /pedidos

Envia para o sistema os detalhes do pedido feito pelo usuário

#### Resposta - sucesso

```js
{
  pedidos: [
    {
      id_pedido: "123123",
      produtos: [
        {
          id_produto: "123",
          quantidade: 1,
        },
        {
          id_produto: "456",
          quantidade: 2,
        },
      ],
      total: 90,
      data: "2024-03-05T15:30:00",
    },
  ];
}
```

#### Resposta - erro

```js
{
    error: "Nenhum pedido encontrado.",
    message: "Não há histórico de pedidos disponível."
}
```

#### Códigos de Status

| código | descrição                                   |
| ------ | ------------------------------------------- |
| 200    | Histórico de pedidos retornado com sucesso. |
| 404    | Histórico de pedidos não encontrado.        |

<br/><hr/>

## 📃 Documentação da API - Admin

### 💠 CRUD de produtos

`POST` /admin/produto

Adiciona um novo produto no cardápio.

#### Requisição

```js
{
    categoria: "sanduíches",
    nome: "X-Fiapinho",
    preco: 30,
    porcentagem_desconto: 0,
    ingredientes: "Pão, 2x carnes de 80g",
    imagem: "..."
}
```

#### Resposta - sucesso

```js
{
  message: "Produto adicionado com sucesso.";
}
```

#### Resposta - erro

```js
{
    error: "Erro ao adicionar o produto.",
    message: "Ocorreu um erro ao adicionar o produto."
}
```

#### Códigos de Status

| código | descrição                                                              |
| ------ | ---------------------------------------------------------------------- |
| 201    | Produto adicionado com sucesso.                                        |
| 400    | Requisição inválida, como dados de entrada ausentes ou mal formatados. |

<br/>

`PUT` /admin/produto/{id}

Edita um produto do cardápio.

#### Requisição

```js
{
    categoria: "sanduíches",
    nome: "X-Fiapinho Deluxe",
    preco: 30,
    porcentagem_desconto: 0,
    ingredientes: "Pão, 2x carnes de 80g",
    imagem: "..."
}
```

#### Resposta - sucesso

```js
{
  message: "Produto atualizado com sucesso.";
}
```

#### Resposta - erro

```js
{
    error: "Erro ao atualizar o produto.",
    message: "Ocorreu um erro ao atualizar o produto."
}
```

#### Códigos de Status

| código | descrição                                                              |
| ------ | ---------------------------------------------------------------------- |
| 200    | Produto atualizado com sucesso.                                        |
| 400    | Requisição inválida, como dados de entrada ausentes ou mal formatados. |
| 404    | Produto referente ao `{id}` não encontrado.                            |

<br/>

`DELETE` /admin/produto/{id}

Deleta um produto do cardápio.

#### Requisição - via id

#### Resposta - sucesso

```js
{
  message: "Produto excluído com sucesso.";
}
```

#### Resposta - erro

```js
{
    error: "Erro ao deletar o produto.",
    message: "Ocorreu um erro ao deletar o produto."
}
```

#### Códigos de Status

| código | descrição                                   |
| ------ | ------------------------------------------- |
| 204    | Produto excluído com sucesso.               |
| 404    | Produto referente ao `{id}` não encontrado. |
