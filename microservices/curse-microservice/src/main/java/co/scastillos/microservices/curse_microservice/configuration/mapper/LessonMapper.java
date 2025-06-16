package co.scastillos.microservices.curse_microservice.configuration.mapper;

import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.domain.lesson.AllLessonsOfCurseResponse;
import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import co.scastillos.microservices.curse_microservice.domain.lesson.LessonResponse;
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

    public LessonResponse toLessonResponse(Lesson lesson){
        return LessonResponse.builder()
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .videoUrl(lesson.getVideoUrl())
                .order(lesson.getOrder())
                .build();
    }



}
