package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<String> addLesson(@RequestBody AddLessonRequest lesson){
        lessonService.addLesson(lesson);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
