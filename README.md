# Spring-Boot-MongoDB
如何使用Docker-compose部署？
<br/>
步驟一： git clone https://github.com/LinYuMingBejing/Spring-Boot-MongoDB.git
<br/>
步驟二： cd Spring-Boot-MongoDB
<br/>
步驟三： sudo mvn clean package docker:build -Dmaven.test.skip=true
<br/>
步驟四： cd docker_prd
<br/>
步驟五： sudo docker-compose up --build -d
<br/>
