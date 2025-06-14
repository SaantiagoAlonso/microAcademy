package co.scastillos.microservices.teacher_microservice.controller;

import co.scastillos.microservices.teacher_microservice.domain.teacher.NewTeacherRequest;
import co.scastillos.microservices.teacher_microservice.domain.teacher.TeacherResponse;
import co.scastillos.microservices.teacher_microservice.domain.teacher.UpdateTeacherRequest;
import co.scastillos.microservices.teacher_microservice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody NewTeacherRequest teacher){
        return new ResponseEntity<>(teacherService.createTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> findAllTeacher(){
        return ResponseEntity.ok(teacherService.findAllTeacher());
    }

    @PutMapping
    ResponseEntity<TeacherResponse> updateTeacher(@RequestBody UpdateTeacherRequest teacherDto){
        return new ResponseEntity<>(teacherService.updateTeacher(teacherDto),HttpStatus.ACCEPTED);
    }


}
