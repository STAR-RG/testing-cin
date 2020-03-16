FROM java:7

RUN apt-get update && \
    apt-get install curl -y && \
    curl -o webgoat.jar https://s3.amazonaws.com/webgoat-war/webgoat-container-7.0.1-war-exec.jar

CMD ["java", "-jar", "webgoat.jar"]
