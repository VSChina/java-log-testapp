FROM tomcat:8.5-jre8

RUN apt-get update && \
    apt-get install -y git maven

COPY spring-webapp-traditional-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
COPY spring-webapp-traditional-1.0-SNAPSHOT.war /webapps/app.war