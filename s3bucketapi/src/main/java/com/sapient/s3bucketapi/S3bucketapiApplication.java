package com.sapient.s3bucketapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
public class S3bucketapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(S3bucketapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String bucketName = "ps-streaming-videos-bucket";

        S3Client client = S3Client.builder().build();

        ListObjectsRequest request = ListObjectsRequest.builder().bucket(bucketName).build();

        ListObjectsResponse response = client.listObjects(request);
        List<S3Object> objects = response.contents();

        ListIterator<S3Object> listIterator = objects.listIterator();
        List<ObjectIdentifier> listObjects = new ArrayList<>();
        while (listIterator.hasNext()) {
            S3Object object = listIterator.next();
            System.out.println(object.key() + " - " + object.size());
            listObjects.add(ObjectIdentifier.builder().key(object.key()).build());

        }
        DeleteObjectsRequest deleteObjectsRequest = DeleteObjectsRequest.builder()
                .bucket(bucketName)
                .delete(Delete.builder().objects(listObjects).build())
                .build();

        DeleteObjectsResponse deleteObjectsResponse = client.deleteObjects(deleteObjectsRequest );

        System.out.println("Deleted: " + deleteObjectsResponse .hasDeleted());

    }
}
