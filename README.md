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
  




## Deploy
- **Deploy to web app**  
  
  Please make docker is installed and running on your dev machine.
  - Windows web app
    ```properties
    mvn docker:build <-Pwindowswebapp> -DpushImage # build docker image and push to registry
    mvn azure-webapp:deploy                         # deploy to azure web app
    ```
    **Note** If image push failed, you could try use `docker push <image_name>` to push it to docker hub.
  - Linux web app
    ```properties
    mvn docker:build -DpushImage  # build docker image and push to registry
    mvn azure-webapp:deploy        # deploy to azure web app
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
    
    After deployment, you could access the function by nagivation to `https: <function-name>.azurewebsites.net/api/hello`
