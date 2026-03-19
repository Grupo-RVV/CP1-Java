# CP1-Java

## Descrição
Projeto da primeira avaliação contínua (CP1) da disciplina de Java da FIAP. Sistema de gerenciamento de funcionários e recursos humanos utilizando JPA/Hibernate com banco Oracle. Inclui entidades como `Funcionario`, `Ceo`, `Senior` e `RecursoHumano`, com funcionalidades como cálculo de salário, inventário de equipamentos e mais.

## Tecnologias
- **Linguagem**: Java
- **Build**: Maven
- **Persistência**: Hibernate JPA 5.4.12.Final
- **Banco de Dados**: Oracle Database (FIAP)
- **Driver JDBC**: ojdbc8 21.1.0.0

## Estrutura do Projeto
```
src/
├── main/
    ├── java/
    │   └── br/com/fiap/
    │       ├── annotation/ (Anotações personalizadas)
    │       ├── dao/ (DAOs)
    │       ├── entity/ (Entidades: Funcionario, Ceo, Senior, RecursoHumano)
    │       ├── enums/ (Equipamentos)
    │       ├── exception/ (Exceções customizadas)
    │       └── view/ (Mains/Testes)
    └── resources/
        └── META-INF/persistence.xml (Configuração JPA)
```

## Pré-requisitos
- JDK 8 ou superior
- Maven 3.x
- Acesso ao banco Oracle da FIAP (oracle.fiap.com.br:1521:orcl)
- Credenciais do banco (usuário: RMxxxxxx, senha: data de nascimento 6 dígitos)

## Configuração
1. Clone o repositório:
   ```
   git clone https://github.com/Grupo-RVV/CP1-Java.git
   cd CP1-Java
   ```

2. Edite `src/main/resources/META-INF/persistence.xml` com suas credenciais Oracle:
   - `javax.persistence.jdbc.user`: Seu RM
   - `javax.persistence.jdbc.password`: Sua senha

3. Compile e execute:
   ```
   mvn clean compile
   mvn exec:java -Dexec.mainClass="br.com.fiap.view.Main"  # Ajuste conforme a classe principal
   ```

**Nota**: Ajuste `hibernate.hbm2ddl.auto` em persistence.xml:
- `update`: Atualiza/cria tabelas
- `create`: Apaga e recria tabelas
- `validate`: Valida estrutura

## Funcionalidades
- Cadastro e gerenciamento de funcionários
- Cálculo de salário baseado em horas trabalhadas
- Inventário de equipamentos (enum)
- Hierarquia: Funcionario, Senior, Ceo, RecursoHumano

## Integrantes
- Rafael Kubagawa Ramos - RM565572
- Victor Sabelli Rocha Batista - RM566224
- Vinícius Soteras Braga - RM566230

## Repositório
[![GitHub Repo](https://img.shields.io/badge/GitHub-Repo-blue?logo=github)](https://github.com/Grupo-RVV/CP1-Java)

## Execução Local
Para rodar testes ou a aplicação principal, use Maven ou sua IDE (Eclipse/IntelliJ).

