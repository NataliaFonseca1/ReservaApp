# ReservaApp — instruções rápidas

Este projeto Spring Boot fornece uma API para reserva de viagens (Booking, Trip, Destination).

Configurações principais
- Perfil `dev`: por padrão usa PostgreSQL local (veja `application.yml`).
- Perfil `prod`: usa variáveis de ambiente (ex.: Aiven) — `JDBC_URL`, `DB_USER`, `DB_PASSWORD`.

Rodando localmente com PostgreSQL (Docker)

1) Rodar um container PostgreSQL local (PowerShell):

```powershell
docker run --name reserva-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=travel -p 5432:5432 -d postgres:15
```

2) Ajuste se necessário as credenciais em `src/main/resources/application.yml` (perfil `dev`).

3) Rodar a aplicação:

```powershell
cd "c:\Users\natal\OneDrive\Área de Trabalho\ReservasApp\reservaApp"
.\mvnw.cmd spring-boot:run
```

Deploy
- Banco de produção: crie o banco no Aiven e configure as variáveis de ambiente `JDBC_URL`, `DB_USER`, `DB_PASSWORD` no serviço de deploy (Render). Use o profile `prod` em `SPRING_PROFILES_ACTIVE=prod`.
- Backend: publique no Render (ou serviço similar). Configure variáveis de ambiente do banco Aiven.
- Frontend (React): publique no Vercel. Adicione a URL do backend (Render) às origens permitidas no `application.yml` (ou configure `app.allowed-origins` via variável de ambiente no Render).

CORS
- A aplicação expõe caminhos ` /api/**`. A configuração global de CORS permite as origens definidas em `app.allowed-origins`.

Observações
- Flyway está habilitado; mantenha as migrations em `src/main/resources/db/migration`.
- Para testes locais rápidos, mantenha o profile `dev` e o banco Postgres rodando no Docker.
