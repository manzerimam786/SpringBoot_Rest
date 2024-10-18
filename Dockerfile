FROM openjdk:8
COPY target/SpringBootDataJPAExample.jar SpringBootDataJPAExample.jar
# container port: application port
EXPOSE 8089:9092
ENTRYPOINT ["java"]
CMD ["-jar", "SpringBootDataJPAExample.jar"]