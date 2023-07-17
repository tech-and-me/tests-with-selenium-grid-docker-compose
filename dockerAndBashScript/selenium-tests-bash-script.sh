#!/bin/bash

echo "Starting Selenium Grid services..."
docker-compose up -d hub chrome firefox

echo "Waiting for Selenium Grid to be ready..."
SELENIUM_READY=false
while [[ "$SELENIUM_READY" != "true" ]]; do
  SELENIUM_READY=$(docker-compose exec -T hub curl -s http://localhost:4444/wd/hub/status | jq -r .value.ready)
  sleep 1
done

echo "Selenium Grid is ready. Starting search-module and book-flight-module services..."
docker-compose up -d search-module

echo "Search module test completed"

sleep 10

echo "starting book-flight-module-tests"

docker-compose up -d book-flight-module
sleep 30

echo "Script execution completed."

exit 0

