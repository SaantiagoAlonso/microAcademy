package co.scastillos.microservices.teacher_microservice.service;

import co.scastillos.microservices.teacher_microservice.configuration.mapper.TeacherMapping;
import co.scastillos.microservices.teacher_microservice.domain.teacher.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapping teacherMapping;

    public String createTeacher(NewTeacherRequest teacher) {
        Teacher newTeacher = teacherMapping.toTeacher(teacher);
        teacherRepository.save(newTeacher);
        return newTeacher.getTeacherId();
    }

    public List<TeacherResponse> findAllTeacher() {
        return teacherRepository.findAll().stream()
                .map(teacherMapping::toTeacherResponse).toList();
    }


    public TeacherResponse updateTeacher(UpdateTeacherRequest teacherDto) {
        Teacher teacher = teacherRepository.findById(teacherDto.teacherId()).orElseThrow();
        if(teacherDto.aboutMe() != null){
            teacher.setAboutMe(teacherDto.aboutMe());
        }
        return teacherMapping.toTeacherResponse(teacher);
    }
}
