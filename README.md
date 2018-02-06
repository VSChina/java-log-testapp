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
```
mvn clean install
```
Place the generated war file under target to tomcat service.
