package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.domain.lesson.AllLessonsOfCurseResponse;
import co.scastillos.microservices.curse_microservice.domain.lesson.LessonResponse;
import co.scastillos.microservices.curse_microservice.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addLesson(
            @Valid @RequestPart("lesson") AddLessonRequest lesson,
            @RequestPart("video") MultipartFile videoFile
    ){
        return new ResponseEntity<>(lessonService.addLesson(lesson,videoFile),HttpStatus.CREATED);
    }

    @GetMapping("/{curseId}")
    public ResponseEntity<AllLessonsOfCurseResponse> allLessonOfCurse(@PathVariable String curseId){
        return ResponseEntity.ok(lessonService.allLessonOfCurse(curseId));
    }


}
