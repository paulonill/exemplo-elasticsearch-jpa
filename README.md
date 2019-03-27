# Projeto exemplo utilizando Spring Boot 2 com Elasticsearch e JPA

### Requerimentos/Conhecimentos e Tecnologias utilizadas
* JDK 8   
   (Fonte: https://www.oracle.com/technetwork/java/javaee/overview/index.html)
* Spring Boot 2   
   (Fonte: https://spring.io/projects/spring-boot#learn)
* Spring Fox 2.9.X/Swagger 2   
   (Fonte: https://spring.io/guides/tutorials/spring-boot-oauth2/)
* Spring Fox 2.9.X/Swagger 2   
   (Fonte: https://spring.io/guides/tutorials/spring-boot-oauth2/)
* Elasticsearch 6.7.0
    (Fonte: https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)
* Maven 3.5.2+

 ### Intalação e excecução do Elasticsearch utilzando docker
 
##### Intalação:
#
```bashh
$ docker pull docker.elastic.co/elasticsearch/elasticsearch:6.7.0
 ```
 ##### Execução:
 #
 ```
$ docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.7.0
 ```
##### O Elasticsearch pode ser acessado em http://localhost:9200/

** Para mais detalhe de configuração do elasticsearch acesse https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html#docker

### Serviços do projeto
* Os serviços podem ser acessados através do endereço http://localhost:8080/swagger-ui.html
