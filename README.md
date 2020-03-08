# spring-boot-apache-kafka-producer-consumer

## Apache Kafka Configuration

To download and install Kafka, please refer to the official guide here https://kafka.apache.org/quickstart.

###  Download and Install
  - Go to the download page of Apache Kafka
    https://kafka.apache.org/downloads
  - Unzip the downloaded file
  
### Start Zookeeper
  - Open a command prompt and start the Zookeeper
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    
### Start Kafka
  - Open a new command prompt and start the Apache Kafka
    .\bin\windows\kafka-server-start.bat .\config\server.properties

### Create Topic
  - Open a new command prompt and create a topic with name setup_test, that has only one partition & one replica.
    .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic setup_test

### Create Producer
  - Next Open a new command prompt and create a producer to send message to the above created setup_test and send a message
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic setup_test
    Hello World

### Create Consumer
  - Finally Open a new command prompt and start the consumer which listens to the topic setup_test we just created above.
    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic setup_test --from-beginning
    
## Producer Consumer Example
  In order to Produce Consumer example follow the below steps
  - Start the Zookeeper (follow the steps from above)
  - Start the Kafka (follow the steps from above)
  - Start spring-boot-apache-kafka-producer project
  - Create a Topic "demo" by running the following cmd in command prompt
    .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic demo
  - Start spring-boot-apache-kafka-consumer project
  - Send the message using the postman 
    - URL : http://localhost:8082/users
    - Method : POST
    - Request Body : 
      {
        "name" : "John Doe",
        "department" : "Administration",
        "salary" : 85150.64
      }
   - You should see the message received in Consumer console.
   - In addition to above steps we can configure one more Topic and Producer through command prompt
   - Create Topic using the following command
      - .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic example
   - Create Producer from Command Prompt
      - .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic example
   - Now you can send the message from command prompt Producer also to the consumer console. 
   
