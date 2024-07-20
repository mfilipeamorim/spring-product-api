# API de Produtos e Categorias

Esta API RESTFUL, construída com Spring Boot, permite gerenciar produtos e categorias em um sistema de e-commerce ou catálogo.

## Funcionalidades

### Produtos

- **POST /api/produtos:** Cria um novo produto.
- **PUT /api/produtos:** Atualiza um produto existente.
- **GET /api/produtos:** Lista todos os produtos.
- **GET /api/produtos/{id}:** Busca um produto por ID.
- **DELETE /api/produtos/{id}:** Exclui um produto.

### Categorias

- **POST /api/categorias:** Cria uma nova categoria.
- **PUT /api/categorias:** Atualiza uma categoria existente.

## Tecnologias

- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

## Pré-requisitos

- Java Development Kit (JDK) 17+
- Apache Maven 3.6+

## Execução

1. Clone o repositório: `git clone https://seu-repositorio/api-produtos-categorias.git`
2. Acesse o diretório: `cd api-produtos-categorias`
3. Execute: `mvn spring-boot:run`

A API estará disponível em: `http://localhost:8080`

## Exemplos de Uso

### Criar um Produto

```bash
curl -X POST -H "Content-Type: application/json" -d '{
    "nome": "Novo Produto",
    "preco": 99.99,
    "desconto": 0.15,
    "categoria": {
        "id": 1
    }
}' http://localhost:8080/api/produtos
