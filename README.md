**Resolveremos o Desafio Backend do PicPay e aprenderemos:**

- Como criar uma API com Spring Boot
- Como mapear as entidades com Jakarta Persistence
- Como comunicar com o banco de dados MySQL via Docker
- Como comunicar com API externa via Spring Cloud OpenFeign
- Como realizar processamento assíncrono com CompletableFuture
- Como validar dados de entrada da API com Hibernate Validator
- Como tratar as exceções de sua API com Problem Details (RFC 7807)
- Como efetuar logs com o Log4J

### Lista de tarefas:

Introdução:

- [ ]  Qual é o desafio que vamos resolver?

---

Comunicação com o banco e dados:

- [ ]  Iniciando o projeto Java (JPA, MySQL, Validator, OpenFeign)
- [ ]  Configurando o MySQL no Docker
- [ ]  Configurando a comunicacao do Spring Boot com o MySQL

---

Funcionalidade de Cadastro de Wallet:

- [ ]  Mapear as entidades (Wallet, WalletType)
- [ ]  Criar inicialização de WalletType no banco de dados
- [ ]  Criar a funcionalidade de cadastro de Wallet
1° Validação dos dados únicos
2° Inserção na base
- [ ]  Criar tratamento de exceções com ProblemDetails e RestExceptionHandler
- [ ]  Criar validação de dados de entrada
- [ ]  Ajustar tratamento de exceções
- [ ]  Testar a API e validar no banco de dados

---

Funcionalidade de Transferência:

- [ ]  Mapear a entidade (Transaction)
- [ ]  Criar os mocks do Autorizador e Notificador Externo (https://designer.mocky.io/)
- [ ]  Criar o serviço que irá consultar o autorizador externo
- [ ]  Criar o serviço que irá notificar o recebimento da transferência
- [ ]  Criar a funcionalidade de transação
1° Validar o tipo da carteira
2° Validar o saldo
3° Consultar autorizador externo
4° Realizar a transferência
5° Enviar notificação para o recebedor (CompletableFuture)
- [ ]  Validar o tratamento de exceções com RestExceptionHandler
- [ ]  Testar a API e validar no banco de dados

---

Ajuste final

- [ ]  Aplicar logging no projeto com SLF4J
