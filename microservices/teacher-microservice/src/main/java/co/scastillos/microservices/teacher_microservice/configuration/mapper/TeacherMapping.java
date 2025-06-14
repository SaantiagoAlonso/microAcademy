package co.scastillos.microservices.teacher_microservice.configuration.mapper;

import co.scastillos.microservices.teacher_microservice.domain.teacher.NewTeacherRequest;
import co.scastillos.microservices.teacher_microservice.domain.teacher.Teacher;
import co.scastillos.microservices.teacher_microservice.domain.teacher.TeacherResponse;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapping {

    public Teacher toTeacher(NewTeacherRequest teacher){
        return Teacher.builder()
                .username(teacher.username())
                .name(teacher.name())
                .lastname(teacher.lastname())
                .aboutMe(teacher.aboutMe())
                .build();
    }

    public TeacherResponse toTeacherResponse(Teacher teacher){
        return TeacherResponse.builder()
                .username(teacher.getUsername())
                .name(teacher.getName())
                .lastname(teacher.getLastname())
                .aboutMe(teacher.getEmail())
                .email(teacher.getEmail())
                .build();
    }


}
