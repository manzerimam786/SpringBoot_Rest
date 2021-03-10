FROM openjdk:8
COPY target/SBRA.war SBRA.war
EXPOSE 8089:8085
ENTRYPOINT ["java"]
CMD ["-jar", "SBRA.war"]