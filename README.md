##PASOS PARA LA EJECUCION DEL BACKEND(DOCKER)
##### 1. Pull de la imagen MySQL del repositorio de Docker
docker pull mysql:8
##### 2. Crear una red para correr nuestra aplicacion
docker network create red-consulti
##### 3. Correr la imagen MySQL en un contenedor llamado "basededatos:" en la red creada previamente
docker run -p 3307:3306 -name basededatos --env MYSQL_ROOT_PASSWORD=m1ch43lhidalgo --env MYSQL_DATABASE=practicanoguiada --network red-consulti mysql:8
##### 4. Correr la imagen de Springboot en la misma red
docker run -8082:8080 -name backend --network red-consulti springboot
