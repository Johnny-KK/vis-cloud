docker_user="vis"
docker_pwd="visPower@2021"
docker_project="vis"
docker_domain="ub20-docker.com"

echo "maven version: \c"
mvn -v

mvn clean
mvn package
mvn docker:build

docker login --username=${docker_user} --password=${docker_pwd} ${docker_domain}

docker image ls

docker push ${docker_domain}/${docker_project}/vis-cloud-article:0.0.1