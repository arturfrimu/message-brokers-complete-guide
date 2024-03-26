# Configurarea RabbitMQ în Docker

Pentru a configura RabbitMQ într-un container Docker, 
este necesar să adaugi un utilizator nou, să setezi tag-uri pentru acest utilizator și să-i configurezi permisiunile corespunzător. 
Aceste comenzi se pot executa în interiorul containerului după ce RabbitMQ a fost pornit.

Următoarele comenzi adaugă un nou utilizator (`myuser`), îi setează tag-ul `administrator` și configurează permisiunile globale pentru acest utilizator:

```bash
rabbitmqctl add_user myuser mypassword
rabbitmqctl set_user_tags myuser administrator
rabbitmqctl set_permissions -p / myuser ".*" ".*" ".*"
```

### docker-compose.yaml
```yaml
services:
  rabbitmq:
    image: rabbitmq:3-management
    ports:
      - "5672:5672"
      - "15672:15672"
    environment:
      RABBITMQ_DEFAULT_USER: myuser
      RABBITMQ_DEFAULT_PASS: mypassword
```

application.yaml
```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: myuser
    password: mypassword
```