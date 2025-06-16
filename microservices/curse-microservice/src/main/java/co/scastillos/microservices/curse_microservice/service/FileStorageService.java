package co.scastillos.microservices.curse_microservice.service;

import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final MinioClient minioClient;

    //    @Value("${minio.bucket-name}")
    private static final String BUCKET_NAME = "fileresources";


    public String uploadFile(MultipartFile file) {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            }

            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(fileName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            return getPublicUrl(fileName);
        } catch (Exception e) {
            throw new RuntimeException("Error al subir el archivo a MinIO", e);
        }
    }




    private String getPublicUrl(String objectName) throws Exception {

        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(BUCKET_NAME)
                        .object(objectName)
                        .expiry(7 * 24 * 60 * 60)
                        .build()
        );
    }


}
