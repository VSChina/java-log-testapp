# java-log-testapp
Project which contains multiple simple applications, these applications are runnable and can be deployed.

## Modules description

module name | description
---|---
spring-webapp-embedded-jetty | Spring boot application using embedded jetty, runnable as a `jar`, use default logging framework logback.
spring-webapp-embedded-tomcat |  Spring boot application using embedded tomcat, runnable as a `jar`, use default logging framework logback.
spring-webapp-embedded-tomcat-jul |  Spring boot application using embedded tomcat, runnable as a `jar`, use java.util.logging(JUL) as logging library.
spring-webapp-traditional | Spring boot application packaged as a `war`, requires a web container to deploy the war file, use default logging framework logback.
spring-batch-simple | Spring simple batch application,  use default logging framework logback.
log-generator |  Utility module to write logs using SLF4J as logger.
  

## How to run

- **spring-webapp-embedded-tomcat**, **spring-webapp-embedded-jetty**, **spring-batch-simple**
```
mvn clean install & mvn spring-boot:run

OR

mvn clean install & java -jar target/spring-{name}-{version}.jar
```

- **spring-webapp-traditional**
 
```
mvn clean install
```
   Place the generated war file under target to tomcat service.


## deploy

- [**Deploy to Azure Function**](https://github.com/VSChina/java-log-testapp/blob/function1/README.md)
- **Deploy to web app**  
  
  Please make docker is installed and running on your dev machine.
  - Windows web app
    ```properties
    mvn docker:build <-Pwindowswebapp> -DpushImage # build docker image and push to registry
    mvn azure-webapp:deply                         # deploy to azure web app
    ```
    **Note** If image push failed, you could try use `docker push <image_name>` to push it to docker hub.
  - Linux web app
    ```properties
    mvn docker:build -DpushImage  # build docker image and push to registry
    mvn azure-webapp:deply        # deploy to azure web app
    ```
    
    After deployment, you could navigate to test app `https://<app-name>.azurewebsites.net/app`.
    