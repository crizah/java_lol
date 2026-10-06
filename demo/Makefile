build:
	./mvnw package -DskipTests

run:
	./mvnw spring-boot:run

test:
	./mvnw test

clean:
	./mvnw clean

db-up:
	docker compose up -d

db-down:
	docker compose down

db-reset:
	docker compose down -v && docker compose up -d

.PHONY: build run test clean db-up db-down db-reset
