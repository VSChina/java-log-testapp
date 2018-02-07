# java-log-testapp
Project which contains multiple simple applications, these applications are runnable and can be deployed.

## How to run

#### spring-webapp-embedded-tomcat, spring-webapp-embedded-jetty, spring-batch-simple
```
mvn clean install & mvn spring-boot:run

OR

mvn clean install & java -jar target/spring-{name}-{version}.jar
```

#### spring-webapp-traditional

- build 
```
mvn clean install
```
   Place the generated war file under target to tomcat service.

- build docker image and push to registry
```properties
mvn docker:build <-Pwindowswebapp> -DpushImage
```

### deploy
```properties
mvn azure-webapp:deploy
```

## Modules description
#### spring-webapp-embedded-jetty
Spring boot application using embedded jetty, runnable as a `jar`, use default logging framework logback.

#### spring-webapp-embedded-tomcat
Spring boot application using embedded tomcat, runnable as a `jar`, use default logging framework logback.

#### spring-webapp-embedded-tomcat-jul
Spring boot application using embedded tomcat, runnable as a `jar`, use java.util.logging(JUL) as logging library.

#### spring-webapp-traditional
Spring boot application packaged as a `war`, requires a web container to deploy the war file, use default logging framework logback.

#### spring-batch-simple
Spring simple batch application,  use default logging framework logback.

#### log-generator
Utility module to write logs using SLF4J as logger.