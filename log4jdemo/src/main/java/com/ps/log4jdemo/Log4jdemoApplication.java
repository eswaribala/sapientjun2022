package com.ps.log4jdemo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.services.kinesis.model.PutRecordResult;
import net.minidev.json.JSONObject;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EnableScheduling

@SpringBootApplication
public class Log4jdemoApplication implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(Log4jdemoApplication.class);
    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

   // @Value("${aws.kinesis.dataStream.name}")
   // private String kinesisDataStreamName;



    public static void main(String[] args) {

        SpringApplication.run(Log4jdemoApplication.class, args);
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");

    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
/*
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);

        AmazonKinesis amazonKinesis = AmazonKinesisClientBuilder
                .standard().withRegion(Regions.AP_SOUTHEAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        JSONObject messageJson = new JSONObject();
        messageJson.put("test1", "We are testing Amazon Kinesis Firehose!");
        messageJson.put("integerKey", 38585);
        messageJson.put("booleanKey", true);
        messageJson.put("anotherString", "This should work!");

        LOGGER.info("Message to Data Stream: " + messageJson.toString());

        PutRecordRequest putRecordRequest = new PutRecordRequest();
        putRecordRequest.setStreamName(kinesisDataStreamName);
        putRecordRequest.setPartitionKey("myPartitionKey");
        putRecordRequest.withData(ByteBuffer.wrap(messageJson.toString().getBytes()));

        PutRecordResult putRecordResult = amazonKinesis.putRecord(putRecordRequest);

        LOGGER.info("Record sequence number: " + putRecordResult.getSequenceNumber());
        LOGGER.info("Shard Id: " + putRecordResult.getShardId());
        LOGGER.info("Record Data: " + putRecordResult.toString());
   */
    }



}
