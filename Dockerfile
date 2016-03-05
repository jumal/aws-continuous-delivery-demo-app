FROM java
RUN groupadd -r application && useradd -rmg application application
WORKDIR /home/application
ADD target/*.jar application.jar
USER application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","application.jar"]