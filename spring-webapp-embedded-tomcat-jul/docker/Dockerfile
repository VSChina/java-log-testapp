FROM java:8
VOLUME /tmp
ADD spring-webapp-embedded-tomcat-jul-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]