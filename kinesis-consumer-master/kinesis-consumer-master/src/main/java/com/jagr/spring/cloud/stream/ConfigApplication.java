package com.jagr.spring.cloud.stream;




import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;

import software.amazon.awssdk.services.kinesis.model.ListShardsRequest;
import software.amazon.awssdk.services.kinesis.model.ListShardsResponse;


import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class ConfigApplication  implements CommandLineRunner {
	private static final Logger LOGGER = LogManager.getLogger(ConfigApplication.class);
	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	@Value("${aws.kinesis.dataStream.name}")
	private String kinesisDataStreamName;



	public static void main(String[] args) {

		SpringApplication.run(ConfigApplication.class, args);
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");

	}

	@Override
	public void run(String... args) {


		KinesisAsyncClient client = KinesisAsyncClient.builder().build();
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);

		AmazonKinesis amazonKinesis = AmazonKinesisClientBuilder
				.standard().withRegion(Regions.AP_SOUTHEAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();

		ListShardsRequest request = ListShardsRequest
				.builder().streamName("videostream")
				.build();

		try {
			ListShardsResponse response = client.listShards(request).get(5000, TimeUnit.MILLISECONDS);
			System.out.println(response.toString());
			String shardIterator;
			GetShardIteratorRequest getShardIteratorRequest = new GetShardIteratorRequest();
			getShardIteratorRequest.setStreamName("videostream");
			getShardIteratorRequest.setShardId(response.shards().get(0).shardId());

			getShardIteratorRequest.setShardIteratorType("TRIM_HORIZON");

			GetShardIteratorResult getShardIteratorResult = amazonKinesis.getShardIterator(getShardIteratorRequest);
			if (getShardIteratorResult != null) {
				shardIterator = getShardIteratorResult.getShardIterator();
				// Continuously read data records from shard.
				List<Record> records;
				while (true) {
					// Create new GetRecordsRequest with existing shardIterator.
					// Set maximum records to return to 1000.
					GetRecordsRequest getRecordsRequest = new GetRecordsRequest();
					getRecordsRequest.setShardIterator(shardIterator);
					getRecordsRequest.setLimit(1000);
					GetRecordsResult result = amazonKinesis.getRecords(getRecordsRequest);
					// Put result into record list. Result may be empty.
					records = result.getRecords();
					// Print records
					for (Record record : records) {
						ByteBuffer byteBuffer = record.getData();
						System.out.println(String.format("Seq No: %s - %s", record.getSequenceNumber(), new String(byteBuffer.array())));
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException exception) {
						throw new RuntimeException(exception);
					}
					shardIterator = result.getNextShardIterator();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
