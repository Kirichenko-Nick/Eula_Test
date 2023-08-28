package JavaMit.ProjektArbeit;

//dependencies {
//        implementation 'com.amazonaws:aws-java-sdk-s3:1.12.56' // Или актуальная версия
//        }
//


//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AWSS3Uploader {
//    public static void main(String[] args) {
//        String accessKey = "YOUR_ACCESS_KEY";
//        String secretKey = "YOUR_SECRET_KEY";
//        String bucketName = "your-bucket-name";
//        String objectKey = "path/to/your/object/filename.txt"; // Путь и имя файла на S3
//        byte[] chunkData = {0x12, 0x34, 0x56, 0x78}; // Ваши данные чанка
//
//        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                .withRegion("us-east-1") // Укажите регион S3
//                .build();
//
//        InputStream inputStream = new ByteArrayInputStream(chunkData);
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(chunkData.length);
//
//        s3Client.putObject(bucketName, objectKey, inputStream, metadata);
//
//        System.out.println("Chunk uploaded to S3.");
//    }
}
