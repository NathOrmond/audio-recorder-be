#!/bin/bash
echo 'Attempting to build docker image'

# Create the jar with maven
./mvnw package

# Create docker image 
docker build -t emotech-be .

# Run docker image
docker run -p 8080:8080 emotech-be
