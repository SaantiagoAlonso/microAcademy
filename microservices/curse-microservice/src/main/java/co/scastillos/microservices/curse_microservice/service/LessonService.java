package co.scastillos.microservices.curse_microservice.service;

import co.scastillos.microservices.curse_microservice.configuration.mapper.CurseMapper;
import co.scastillos.microservices.curse_microservice.configuration.mapper.LessonMapper;
import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseRepository;
import co.scastillos.microservices.curse_microservice.domain.lesson.AllLessonsOfCurseResponse;
import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.exceptions.CurseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final CurseRepository curseRepository;
    private final LessonMapper lessonMapper;
    private final FileStorageService fileStorageService;
    private final CurseMapper curseMapper;


    public String addLesson(AddLessonRequest lesson, MultipartFile videoFile) {
        Curse curse = curseRepository.findById(lesson.curseId())
                .orElseThrow(() -> new CurseNotFoundException(lesson.curseId()));
        Lesson newLesson = lessonMapper.toLesson(lesson);
        if(!videoFile.isEmpty()){
            String videoUrl = fileStorageService.uploadFile(videoFile);
            newLesson.setVideoUrl(videoUrl);
        }

        newLesson.setLessonId(UUID.randomUUID().toString());

        List<Lesson> lessonList = curse.getLessons();
        lessonList.add(newLesson);
        curse.setLessons(lessonList);
        curseRepository.save(curse);
        return newLesson.getLessonId();
    }


    public AllLessonsOfCurseResponse allLessonOfCurse(String curseId) {
        Curse curse = curseRepository.findById(curseId)
                .orElseThrow(() -> new CurseNotFoundException(curseId));
        List<Lesson> lessons = curse.getLessons();
        return  AllLessonsOfCurseResponse.builder()
                .curse(curseMapper.toCurseResponse(curse))
                .lessons(lessons.stream().map(lessonMapper::toLessonResponse).toList())
                .build();


    }
}
