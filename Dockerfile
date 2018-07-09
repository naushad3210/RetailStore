FROM openjdk:8
COPY /target/RetailStore.war /test/RetailStore.war
WORKDIR /test
EXPOSE 8080
ENTRYPOINT ["java","-jar","./RetailStore.war"]