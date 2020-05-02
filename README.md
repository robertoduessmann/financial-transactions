# financial-transactions
> Spring Boot project to manage financial transactions producing and consuming messages from Kafka

## Setup
### Dependencies
- PostgresSQL
- Kafka

```sh
$ docker-compose up
```

### Running
```sh
mvn spring-boot:run
```


### Build in docker
```sh
$ docker build -t financial-transactions .
```

## Usage
### POST /transactions
```sh
curl --request POST 'http://localhost:8080/transactions' \
--header 'Content-Type: application/json' \
--data-raw '{
	"userId": "2b4d0c35-b111-472f-b47e-31de6c81d10e",
	"amount": 10
}'
```

### GET /balance/{userId}
```shell script
curl --request GET 'http://localhost:8080/balance/2b4d0c35-b111-472f-b47e-31de6c81d10e'
```

## License
The MIT License (MIT)