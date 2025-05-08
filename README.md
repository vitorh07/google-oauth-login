# Google OAuth Login

Este é um projeto de demonstração que utiliza Spring Boot para implementar autenticação via Google OAuth2. Após o login bem-sucedido, o sistema retorna um JSON com as informações do usuário autenticado.

## Funcionalidades

- Autenticação via Google OAuth2.
- Redirecionamento automático para o Google para login.
- Retorno de informações do usuário autenticado em formato JSON.
- Configuração de segurança com Spring Security.
- Banco de dados H2 para persistência (opcional).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.5**
  - Spring Security
  - Spring OAuth2 Client
  - Spring Data JPA
  - Spring Web
- **Banco de Dados H2**
- **Lombok** para reduzir boilerplate no código.

## Pré-requisitos

- JDK 17 ou superior.
- Maven 3.9.9 ou superior.
- Conta no Google Cloud com um projeto configurado para OAuth2.

## Configuração

1. **Crie um projeto no Google Cloud Console**:
   - Acesse [Google Cloud Console](https://console.cloud.google.com/).
   - Crie um novo projeto.
   - Ative a API "Google+ API" ou "Google Identity Services".
   - Configure as credenciais OAuth2 e obtenha o `Client ID` e `Client Secret`.
   - Configure o URI de redirecionamento como `http://localhost:8080/login/oauth2/code/google`.

2. **Configure as variáveis de ambiente**:
   - Defina as variáveis de ambiente `GOOGLE_CLIENT_ID` e `GOOGLE_CLIENT_SECRET` com os valores obtidos no Google Cloud Console.

3. **Configure o arquivo `application.properties`**:
   O arquivo já está configurado para utilizar as variáveis de ambiente:
   ```properties
   spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
   spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
   spring.security.oauth2.client.registration.google.scope=profile,email
   spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}
   ```

## Como executar
1. **Clone o repositório:**
    ```bash
    git clone https://github.com/vitorh07/google-oauth-login.git
    cd google-oauth-login
    ```

2. **Compile e execute o projeto:**
    ```bash
    ./mvnw spring-boot:run
    ```
3. **Acesse o sistema:**
    - Abra o navegador e acesse http://localhost:8080.
    - Você será redirecionado para a página de login do Google.
    - Após autenticar, será redirecionado para /api/user, onde verá um JSON com as informações do usuário.

## Endpoint
- GET /api/user: Retorna as informações do usuário autenticado em formato JSON.
- Exemplo de Resposta:
```json
{
  "sub": "12345678910123456789",
  "name": "João Pedro",
  "given_name": "João",
  "family_name": "Pedro",
  "picture": "https://lh3.googleusercontent.com/a/ACg8ocK2F2FhdmMc...",
  "email": "joao@gmail.com",
  "email_verified": true,
  "hd": "gmail.com"
}
```