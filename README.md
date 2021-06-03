## Spring Boot project

Run Redis in Docker:

Creating Redis container:
```bash
docker run -it --name redis -p 6379:6379 redis:latest
```

Checking data in Redis
```bash
docker exec -it redis /bin/bash
redis-cli
KEYS *
get "key name"
```