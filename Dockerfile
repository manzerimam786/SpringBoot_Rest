FROM alpine:edge
COPY C:/Users/facadmin1/Downloads/Projects/SpringBootRestApi/SpringBootRestApi/target/SBRA.war SBRA.war
EXPOSE 8085:8085
ENTRYPOINT ["java"]
CMD ["-jar", "SBRA.war"]