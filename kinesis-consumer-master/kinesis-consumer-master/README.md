# Simple kinesis consumer

## What is this

Project to show simple kinesis consumer configuration

### Libraries
- spring-cloud-stream
- spring-cloud-stream-binder-kinesis

## Requirements
- Apache Maven 3 - https://maven.apache.org/download.cgi
- JDK 1.8 - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Aws cli to send records to stream. Your credentials should be allowed to use kinesis

## Before run
Remember configure stream on application.properties with your stream.
```
spring.cloud.stream.bindings.incoming.destination
```

## How to run
```
mvn clean install
```

```
mvn spring-boot:run
```

## Send record to your stream
```
aws kinesis put-record --stream-name <HERE_YOUR_STREAM> --data file://<HERE_YOUR_PATH_FILE> --partition-key 1
```


