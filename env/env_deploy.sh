#!/bin/bash
## desc: health-station-backend running environment deploy

echo '---- create network ----'
docker network create hs_net

echo '---- run container ----'
docker-compose up -d
