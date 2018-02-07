package io.axway.iron.spi.aws.s3;

import java.util.*;

import static io.axway.iron.spi.aws.PropertiesHelper.*;

public class AwsS3TestUtils {

    public static AwsS3SnapshotStoreFactory buildTestAwsS3SnapshotStoreFactory() {
        // Disable Cert checking to simplify testing (no need to manage certificates)
        System.setProperty("com.amazonaws.sdk.disableCertChecking", "");
        // Disable CBOR protocol which is not supported by kinesalite
        System.setProperty("com.amazonaws.sdk.disableCbor", "");

        String bucketName = "iron-bucket";
        String accessKey = "AK";
        String secretKey = "SK";
        String region = "eu-west-1";
        String s3Endpoint = "localhost";
        Long s3Port = 4572L;

        Properties properties = buildTestAwsS3Properties(bucketName, accessKey, secretKey, region, s3Endpoint, s3Port);

        return new AwsS3SnapshotStoreFactory(properties);
    }

    public static Properties buildTestAwsS3Properties(String bucketName, String accessKey, String secretKey, String region, String s3Endpoint, Long s3Port) {
        // Disable Cert checking to simplify testing (no need to manage certificates)
        System.setProperty("com.amazonaws.sdk.disableCertChecking", "");
        // Disable CBOR protocol which is not supported by kinesalite
        System.setProperty("com.amazonaws.sdk.disableCbor", "");
        Properties properties = new Properties();
        properties.setProperty(BUCKET_NAME_KEY, bucketName);
        properties.setProperty(ACCESS_KEY_KEY, accessKey);
        properties.setProperty(SECRET_KEY_KEY, secretKey);
        properties.setProperty(REGION_KEY, region);
        properties.setProperty(S3_ENDPOINT_KEY, s3Endpoint);
        properties.setProperty(S3_PORT_KEY, s3Port.toString());
        return properties;
    }
}
