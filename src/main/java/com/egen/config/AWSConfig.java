package com.egen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AWSConfig {

	/**
	 * private Region region = Region.US_EAST_1;
	 * 
	 * @Bean("snsClient") public SnsClient snsClient() { return
	 * SnsClient.builder().region(region).credentialsProvider(EnvironmentVariableCredentialsProvider.create())
	 * .build(); }
	 * 
	 * @Bean("sqsClient") public SqsClient sqsClient() { return
	 * SqsClient.builder().region(region).credentialsProvider(c.create()) .build();
	 * }
	 */

	@Value("${cloud.aws.credentials.accessKey}")
	public String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	public String secretKey;

	@Bean
	public AmazonSNS sns() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonSNSClientBuilder.standard().withRegion(com.amazonaws.regions.Regions.US_EAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}

	@Bean
	public NotificationMessagingTemplate notificationTemplate(AmazonSNS sns) {
		return new NotificationMessagingTemplate(sns);
	}

}
