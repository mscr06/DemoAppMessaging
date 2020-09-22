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
3. Build the project...(mvn clean install)
4. Run jar file in target folder
   java -jar <jar-file>
5. Access index page at localhost:8080
6. Enter details in the form and submit.
