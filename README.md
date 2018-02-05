# java-log-testapp
Project which contains multiple simple applications, these applications are runnable and can be deployed.

## How to run

#### spring-webapp-embedded-tomcat
```
mvn clean install & mvn spring-boot:run

OR

mvn clean install & java -jar target/spring-mvc-app-{version}.jar
```

#### spring-webapp-bare
```
mvn clean install
```
Place the generated war file under target to tomcat service.
