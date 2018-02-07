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


## Deploy
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

- **Deploy to Azure Function**  
  
  Need [prerequisites](https://github.com/Microsoft/azure-maven-plugins/tree/master/azure-functions-maven-plugin#prerequisites) to run azure-functions-maven-plugin.    
  - Windows
    ```properties
    mvn azure-functions:package   # package azure function
    mvn azure-functions:run       # run azure function local
    mvn azure-functions:deploy    # deploy to azure
    ```
  - Linux
    ```properties
    mvn azure-functions:package   # package azure function
    mvn azure-functions:run       # run azure function local
    mvn azure-functions:deploy    # deploy to azure
    ```