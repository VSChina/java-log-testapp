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
- **Deploy to Azure Web App**  
  
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
    
    After deployment, you could navigate to test app `https://<app-name>.azurewebsites.net/app`.
    
    
- **Deploy to ACS**   
  Follow [this instruction](https://github.com/Microsoft/todo-app-java-on-azure/blob/master/doc/deployment/deploy-to-azure-container-service-using-maven-plugin.md) to deploy Kubernetes in Azure Container Service. Add steps at below for reference.
  
  - Run below azure cli cmds to create ACR,ACS.
    ```properties
    az login
    az account set -s <your-subscription-id>
    az group create -n <your-resource-group-name> -l eastus 
    az acs create --orchestrator-type kubernetes -g <your-resource-grouop-name> -n <your-k8s-cluster-name> --generate-ssh-keys
    az acs kubernetes get-credentials -g <your-resource-grouop-name> -n <your-k8s-cluster-name>
    az acs kubernetes install-cli
    az acr create -n <your-acr-name> -g <your-resource-grouop-name> --sku Basic
    az acr update -n <your-acr-name> --admin-enabled true
    az acr credential show -n acregister1
    ```
    
  - Setup container registry url.  
    In the Maven settings file `~/.m2/settings.xml` or `<maven_install_dir>/conf/settings.xml`, add a new `<server>` element with your container registry credentials from previous steps.
    
    ```xml
    <server>
      <id>put-your-docker-registry-url</id>
      <username>put-your-docker-username</username>
      <password>put-your-docker-key</password>
      <configuration>
        <email>put-your-email</email>
      </configuration>
    </server>
    ```    
    
  - Update `pom.xml`, replace `<docker.image.prefix>` in `<properties>` to your docker registry URL. Replace `<resourcegroup>` to your resourece group name. 
  
  - Run it.
    ```
    mvn clean package
    mvn docker:build docker:push
    mvn fabric8:resource fabric8:apply
    kubectl get svc -w
    ```
    
    get `EXTERNAL-IP` from last cmd output, then navigate to `http://<external-ip>/app`.
