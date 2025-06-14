package co.scastillos.microservices.curse_microservice.service;

import co.scastillos.microservices.curse_microservice.configuration.mapper.LessonMapper;
import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseRepository;
import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final CurseRepository curseRepository;
    private final LessonMapper lessonMapper;


    public void addLesson(AddLessonRequest lesson) {
        Curse curse = curseRepository.findById(lesson.curseId()).orElseThrow();
        Lesson newLesson = lessonMapper.toLesson(lesson);
        List<Lesson> lessonList = curse.getLessons();
        lessonList.add(newLesson);
        curse.setLessons(lessonList);
        curseRepository.save(curse);

    }
}
