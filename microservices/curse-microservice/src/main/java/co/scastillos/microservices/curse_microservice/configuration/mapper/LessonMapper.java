package co.scastillos.microservices.curse_microservice.configuration.mapper;

import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {


    public Lesson toLesson(AddLessonRequest lesson){
        return Lesson.builder()
                .title(lesson.title())
                .description(lesson.description())
//                .videoUrl(lesson.videoUrl())
                .order(lesson.order())
                .build();
    }


}
