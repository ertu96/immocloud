.PHONY: up down

default: up

up:
	docker-compose up -d

down:
	docker-compose down
