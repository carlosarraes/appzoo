# Sistema de Gerenciamento do Zoológico

## Diagrama do Sistema de Gerenciamento do Zoológico

[Zoo](zoologico.png)

O Sistema de Gerenciamento do Zoológico é uma aplicação baseada em Spring que simplifica a gestão das operações de um zoológico, focando especialmente nas relações entre várias entidades como gerentes, cuidadores e animais.

### Funcionalidades:

    - CRUD: O sistema fornece operações de Criar, Ler, Atualizar e Deletar (CRUD) para algumas entidades, oferecendo uma interface abrangente para gerenciar os dados.
    - Relações: No seu núcleo, o sistema implementa relações, pode ser testado no front end a relação Gerente -> Cuidador, que é crucial para acompanhar as responsabilidades.
    - Thymeleaf: O Thymeleaf é usado como mecanismo de template para renderizar a interface do usuário. Ele oferece uma integração perfeita com o Spring e ajuda na criação de visualizações web dinâmicas.
    - Java 17: O sistema é construído usando a versão LTS mais recente do Java, garantindo que se beneficie das últimas funcionalidades, atualizações de segurança e otimizações.
    - PostgreSQL: O PostgreSQL, um poderoso banco de dados relacional de código aberto, é usado para armazenamento de dados persistente, oferecendo uma solução robusta para tarefas de gerenciamento de dados.

### Começando:

Pré-requisitos: Certifique-se de ter o Java 17 e o Docker instalados em sua máquina.

    - Clone o repositório:
        `git clone [url-do-repositório]`
    - Navegue até a raiz do projeto e execute o arquivo Docker compose para configurar o PostgreSQL:
        `docker-compose up -d`
    - Uma vez que o banco de dados esteja funcionando, navegue até a raiz do projeto e execute:
        `./mvnw spring-boot:run`

Isso iniciará a aplicação Spring Boot.

### Utilização:

Acesse o front end pelo http://localhost:8080

    - Registrando um Cuidador: Ao registrar um cuidador, você pode associá-lo a um gerente. Isso reflete o cenário do mundo real em que um cuidador geralmente é supervisionado ou gerenciado por uma autoridade superior.
