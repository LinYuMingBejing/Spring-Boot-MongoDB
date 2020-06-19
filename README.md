# Spring-Boot-MongoDB
如何使用Docker-compose部署？
步驟一： git clone https://github.com/LinYuMingBejing/Spring-Boot-MongoDB.git
步驟二： cd Spring-Boot-MongoDB
步驟三： sudo mvn clean package docker:build -Dmaven.test.skip=true
步驟四： cd docker_prd
步驟五： sudo docker-compose up --build -d
