# financial-transactions
> Spring Boot project to manage financial transactions producing and consuming messages from Kafka

## Setup
1) [Setup Kafka](https://kafka.apache.org/quickstart)
2) Create a topic called `financial-transactions`
3) Run `mvn spring-boot:run`

## Usage
### POST /transactions
```shell script
curl -X POST -F 'message=test' http://localhost:8080/transactions
```

## License
The MIT License (MIT)