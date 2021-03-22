FROM openjdk:8
COPY target/SpringBootRestApi-2.0.war SpringBootRestApi-2.0.war
EXPOSE 8089:8089
ENTRYPOINT ["java"]
CMD ["-jar", "SpringBootRestApi-2.0.war"]