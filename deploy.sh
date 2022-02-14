#!/bin/bash
## desc: health-station-backend deploy

app_name='hs-backend'

image_name='health-station_hs-backend'

mapfile -t running_container_array < <(docker ps --format "{{.Names}}")

echo "${running_container_array[@]}" | grep -wq ${app_name} &&
  echo '---- stop container ----' &&
  docker stop ${app_name} &&
  echo '---- rm container ----' &&
  docker rm ${app_name}

docker images | grep -wq ${image_name} &&
  echo '---- rm image ----' &&
  docker rmi -f ${image_name}

echo '---- build container ----'
docker-compose build

echo '---- run container ----'
docker-compose up -d
