package co.scastillos.microservices.student_microservice.service;

import co.scastillos.microservices.student_microservice.configuration.mapper.StudentMapper;
import co.scastillos.microservices.student_microservice.domain.student.NewStudentRequest;
import co.scastillos.microservices.student_microservice.domain.student.Student;
import co.scastillos.microservices.student_microservice.domain.student.StudentRepository;
import co.scastillos.microservices.student_microservice.domain.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public String createStudent(NewStudentRequest student) {
        Student newStudent = studentMapper.toStudent(student);
        studentRepository.save(newStudent);
        return newStudent.getStudentId();
    }

    public StudentResponse findByStudentId(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return studentMapper.toStudentResponse(student);
    }

    public List<StudentResponse> findAllStudent() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentResponse).toList();
    }
}
