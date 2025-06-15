package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.lesson.AddLessonRequest;
import co.scastillos.microservices.curse_microservice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<String> addLesson(@RequestBody AddLessonRequest lesson){
        return new ResponseEntity<>(lessonService.addLesson(lesson),HttpStatus.CREATED);
    }

    @PostMapping("/uploadVideo")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String nameFile = lessonService.uploadFile(file);
        return ResponseEntity.ok("Archivo subido con éxito: " + nameFile);
    }


}
