SHELL ?= /bin/bash

DOCKER_COMPOSE ?= docker-compose -f ./docker/docker-compose.build.yml
DOCKER ?= docker
MVN ?= ${DOCKER_COMPOSE} run --rm mvn -B

run:
	${DOCKER_COMPOSE} -f ./docker/docker-compose.yml up --force-recreate app

unit-tests:
	${MVN} test

integration-tests:
	${MVN} verify -Dskip.unit.tests=true

qa: validate checkstyle

validate:
	${MVN} validate

checkstyle:
	${MVN} checkstyle:check