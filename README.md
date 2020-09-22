# DemoAppMessaging
Using twillio and rabbitmq to send text messages to phones

Using below Tech Stack:
1. Spring Boot
2. Twillio SDK
3. Rabbit MQ
4. AngularJS

How To Use:
1. Download and run rabbitmq docker image

   docker run  -itd --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
2. Clone the repo.
3. Update twillio account details in 

   src/main/resources/application.properties
4. Build the project...(mvn clean install)
5. Run jar file in target folder

   java -jar jar-file
6. Access index page at localhost:8080
7. Enter details in the form and submit.
