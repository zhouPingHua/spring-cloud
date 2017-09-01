FROM 192.168.0.1/base/docker-java-base:jdk_8
VOLUME /tmp
ADD config-client-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8881
