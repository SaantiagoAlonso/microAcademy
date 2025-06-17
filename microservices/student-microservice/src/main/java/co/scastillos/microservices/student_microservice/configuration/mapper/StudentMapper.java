package co.scastillos.microservices.student_microservice.configuration.mapper;

import co.scastillos.microservices.student_microservice.domain.student.NewStudentRequest;
import co.scastillos.microservices.student_microservice.domain.student.Student;
import co.scastillos.microservices.student_microservice.domain.student.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(NewStudentRequest student){
        return Student.builder()
                .username(student.username())
                .name(student.name())
                .lastname(student.lastname())
                .email(student.email())
                .build();
    }

    public StudentResponse toStudentResponse(Student student) {
        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .username(student.getUsername())
                .name(student.getName())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .build();
    }
}
