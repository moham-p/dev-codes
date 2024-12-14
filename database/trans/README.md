### Run PostgreSQL in a Docker Container

```courseignore
docker run --name postgres-demo -e POSTGRES_PASSWORD=password -e POSTGRES_USER=demo -e POSTGRES_DB=demo_db -p 5432:5432 -d postgres:latest
```
