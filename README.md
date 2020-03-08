# spring-boot-apache-kafka-producer-consumer

## Apache Kafka Configuration

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
  - Start spring-boot-apache-kafka-producer project
  - Create Topic
    .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic demo
  - Start spring-boot-apache-kafka-consumer project
  - Send the message using the endpoint.
