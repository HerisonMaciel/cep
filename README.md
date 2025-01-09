# Sistema de Busca de Estabelecimentos por CEP

Este sistema tem como objetivo realizar a busca de estabelecimentos com base no CEP informado pelo usuário. A arquitetura é baseada em *hexagonal* e utiliza Java 21, Maven e MongoDB para persistência de dados. Além disso, o sistema realiza chamadas a APIs externas para obter informações sobre o endereço e os estabelecimentos, unifica os dados e os armazena em bancos MongoDB.

## Pré-requisitos

Antes de rodar o sistema, é necessário ter os seguintes pré-requisitos instalados:

- Docker e Docker Compose
- Java 21
- Maven

## Instruções de Execução

### 1. Subir Bancos e APIs Mocadas

Execute o seguinte comando para subir os bancos de dados MongoDB e as APIs mockadas usando Docker Compose:

docker-compose up -d
Isso irá configurar os containers necessários para o banco MongoDB e para as APIs que simulam o serviço de consulta de endereço e estabelecimento.

### 2. Rodar o Sistema
Após subir os containers, você pode rodar o sistema com o Maven:

mvn spring-boot:run
Isso iniciará o servidor na porta configurada no application.properties.

Funcionalidade
Endpoints
GET /estabelecimentos/{zipcode}
Este endpoint recebe o CEP (zipcode) como parâmetro e retorna os dados dos estabelecimentos correspondentes.

## Fluxo:

Validação do CEP (verifica se é um formato válido).
Chamada à primeira API (API de Endereço) para obter os dados do endereço.
Chamada à segunda API (API de Estabelecimentos) para obter os dados dos estabelecimentos.
Combinação dos dados de endereço e estabelecimentos.
Armazenamento dos dados no banco MongoDB.
Armazenamento dos logs das operações no banco MongoDB de logs.
Retorno dos dados combinados ao usuário.
Banco de Dados
O sistema utiliza MongoDB para persistência de dados, sendo que há dois bancos distintos:

Banco de Dados de Estabelecimentos: Armazena os dados combinados de endereço e estabelecimentos.
Banco de Dados de Logs: Armazena os logs de cada operação realizada pelo sistema.
Estrutura de Arquitetura
A arquitetura do sistema segue o modelo Hexagonal (ou Ports and Adapters), o que permite que o sistema seja facilmente extensível e adaptável a diferentes tecnologias e fontes de dados. As interações com APIs externas, banco de dados e logs são abstraídas através de portas e adaptadores.

## Desenvolvimento
Build do Projeto
Para compilar o projeto e gerar o arquivo executável .jar, execute:

mvn clean install

Isso irá compilar o código e gerar o artefato do Spring Boot.

## Testes
O sistema já inclui testes unitários. Para rodar os testes, execute:
mvn test

## Dependências
Java 21
Spring Boot
MongoDB
Maven
Docker Compose (para rodar as APIs mockadas e o banco)

Licença
Este projeto é licenciado sob a MIT License.
