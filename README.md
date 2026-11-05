🌅 Lily Poente Studio - Back-end API

Este é o repositório back-end do portfólio oficial do Lily Poente Studio. Uma API RESTful robusta e segura, desenvolvida para fornecer os dados da galeria e gerenciar a autenticação do painel administrativo.

O projeto utiliza uma arquitetura baseada em Java e Spring Boot, com banco de dados NoSQL e deploy containerizado, garantindo alta disponibilidade e segurança para a gestão de conteúdo do estúdio.

✨ Funcionalidades Destacadas

Autenticação e Autorização Segura: Implementação de Spring Security com tokens JWT (JSON Web Tokens). Apenas usuários autenticados têm acesso aos endpoints de criação, edição e exclusão de projetos.

Gestão de Portfólio (CRUD): API completa para gerenciamento das imagens e informações da galeria, com respostas otimizadas em formato JSON.

CORS Otimizado: Configuração de Cross-Origin Resource Sharing ajustada para permitir requisições seguras exclusivas do front-end hospedado no Cloudflare Pages.

Deploy Containerizado: Ambiente totalmente configurado com Docker e Docker Compose, facilitando a implantação em qualquer servidor na nuvem.

🛠️ Tecnologias Utilizadas

Linguagem: Java (17+)

Framework: Spring Boot 3

Segurança: Spring Security & JWT (io.jsonwebtoken)

Banco de Dados: MongoDB (Spring Data MongoDB)

Infraestrutura & Deploy: Docker, Docker Compose, Oracle Cloud Infrastructure (OCI)

Gerenciamento de DNS/SSL: sslip.io (para IP público da Oracle)

📡 Endpoints Principais

A API responde no caminho base /api.

Autenticação

POST /api/auth/login - Recebe credenciais e retorna o token JWT.

Portfólio (Galeria)

GET /api/portfolio - Retorna todos os itens da galeria (Rota Pública).

POST /api/portfolio - Cria um novo projeto (Requer JWT).

PUT /api/portfolio/{id} - Edita um projeto existente (Requer JWT).

DELETE /api/portfolio/{id} - Exclui um projeto (Requer JWT).

🚀 Como Executar o Projeto Localmente

Pré-requisitos

Java JDK 17 ou superior

Maven

MongoDB rodando localmente ou na nuvem (Atlas)

Passos para Instalação

Clone o repositório:

git clone https://github.com/seu-usuario/lily-poente-backend.git


Entre no diretório do projeto:

cd lily-poente-backend


Configure as variáveis de ambiente:
Edite o arquivo src/main/resources/application.properties ou exporte as variáveis no seu sistema:

# Configurações do MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/lilypoente

# Chave secreta para geração do JWT (use uma string longa e segura)
jwt.secret=SUA_CHAVE_SECRETA_MUITO_LONGA_AQUI
jwt.expiration=86400000 # 24 horas


Execute a aplicação:

mvn spring-boot:run


A API estará rodando em http://localhost:8080.

📦 Deploy (Oracle Cloud)

O projeto está configurado para ser executado em uma Máquina Virtual (VM) na Oracle Cloud.

No servidor, atualize o repositório:

git pull origin main


Reconstrua e inicie os containers em segundo plano:

docker compose down
docker compose up -d --build


📝 Licença

Desenvolvido exclusivamente para o uso do Lily Poente Studio.
