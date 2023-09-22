package com.example.demo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

import static com.amazonaws.services.dynamodbv2.streamsadapter.model.RecordObjectMapper.DYNAMODB;

@Configuration
public class AwsConfig {

    @Bean
    public AmazonDynamoDB dynamoDBClient() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("dummy", "dummy");

        return  AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    @Bean
    public AmazonDynamoDBAsync dynamoDBClientAsync() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("dummy", "dummy");

        return AmazonDynamoDBAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
