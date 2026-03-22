# CP1-Java

## Descrição
Projeto da primeira avaliação (CP1) da disciplina de Java Advanced. Sistema de gerenciamento de funcionários utilizando JPA/Hibernate com banco Oracle. Inclui entidades como `Funcionario`, `Ceo`, `Senior` e `RecursoHumano`, com funcionalidades como cálculo de salário, inventário de equipamentos e mais.

## Tecnologias
- **Linguagem**: Java
- **Build**: Maven
- **Persistência**: Hibernate JPA 5.4.12.Final
- **Banco de Dados**: Oracle Database (FIAP)
- **Driver JDBC**: ojdbc8 21.1.0.0

## Estrutura do Projeto
```
CP1-Java
│   .classpath
│   .gitignore
│   .project
│   CP1-Java.iml
│   Integrantes e GitHub.txt
│   pom.xml
│   README.md
│
├───.idea
│       .gitignore
│       compiler.xml
│       jarRepositories.xml
│       misc.xml
│       vcs.xml
│
├───.settings
│       org.eclipse.jdt.core.prefs
│       org.eclipse.jpt.core.prefs
│       org.eclipse.m2e.core.prefs
│       org.eclipse.wst.common.project.facet.core.prefs.xml
│       org.eclipse.wst.common.project.facet.core.xml
│
├───imagens-teste (Imagens da execução CRUD + resposta do banco)
│       0 - reflection.png
│       1 - cadastro de funcionario.png
│       2 - buscar por id e buscar todos.png
│       3 - atualizar funcionario.png
│       4 - deletar funcionario.png
│
└───src
    └───main
        ├───java
        │   └───br
        │       └───com
        │           └───fiap
        │               ├───annotation
        │               │       Descricao.java
        │               │
        │               ├───dao
        │               │       FuncionarioDao.java
        │               │       FuncionarioDaoImpl.java
        │               │
        │               ├───entity
        │               │       Ceo.java
        │               │       Funcionario.java
        │               │       RecursoHumano.java
        │               │       Senior.java
        │               │
        │               ├───enums
        │               │       Equipamentos.java
        │               │
        │               ├───exception
        │               │       CommitException.java
        │               │       IdNaoEncontradoException.java
        │               │
        │               └───view (Mains/Testes)
        │                       MainCeo.java
        │                       MainFuncionario.java
        │                       MainRecursoHumano.java
        │                       MainSenior.java
        │
        └───resources
            └───META-INF
                    persistence.xml (Configuração JPA)
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
- Inventário de equipamentos

## Integrantes
- Rafael Kubagawa Ramos - RM565572
- Victor Sabelli Rocha Batista - RM566224
- Vinícius Soteras Braga - RM566230

## Repositório
[![GitHub Repo](https://img.shields.io/badge/GitHub-Repo-blue?logo=github)](https://github.com/Grupo-RVV/CP1-Java)

## Execução Local
Para rodar testes ou a aplicação principal, use Maven e/ou sua IDE (Eclipse/IntelliJ).
