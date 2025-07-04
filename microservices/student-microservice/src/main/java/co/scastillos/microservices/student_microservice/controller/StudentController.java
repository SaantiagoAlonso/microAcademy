package co.scastillos.microservices.student_microservice.controller;

import co.scastillos.microservices.student_microservice.domain.student.NewStudentRequest;
import co.scastillos.microservices.student_microservice.domain.student.StudentResponse;
import co.scastillos.microservices.student_microservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> createStudent(NewStudentRequest student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> findByStudentId(@PathVariable String studentId){
        return ResponseEntity.ok(studentService.findByStudentId(studentId));

    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAllStudent(){
        return ResponseEntity.ok(studentService.findAllStudent());
    }



}
