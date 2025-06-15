package co.scastillos.microservices.curse_microservice.service;

import co.scastillos.microservices.curse_microservice.configuration.mapper.LessonMapper;
import co.scastillos.microservices.curse_microservice.configuration.storage.MinIoConfig;
import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseRepository;
import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final CurseRepository curseRepository;
    private final LessonMapper lessonMapper;
    private final MinioClient minioClient;

//    @Value("${minio.bucket-name}")
    private final String BUCKET_NAME = "fileresources";



    public String addLesson(AddLessonRequest lesson) {
        Curse curse = curseRepository.findById(lesson.curseId()).orElseThrow();
        Lesson newLesson = lessonMapper.toLesson(lesson);
        newLesson.setLessonId(UUID.randomUUID().toString());
        List<Lesson> lessonList = curse.getLessons();
        lessonList.add(newLesson);
        curse.setLessons(lessonList);
        curseRepository.save(curse);
        return newLesson.getLessonId();
    }


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

            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Error al subir el archivo a MinIO", e);
        }
    }




}
