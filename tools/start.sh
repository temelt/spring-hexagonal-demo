#!/bin/bash

if [[ "$#" -eq 0 ]];
then
    docker-compose -f docker-compose.dev.yml --profile dev up -d --build
    exit
else
    docker-compose -f docker-compose.dev.yml --profile dev "$@" up -d --build
    exit
fi
