package co.scastillos.microservices.teacher_microservice.domain.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Teacher {

    @Id
    private String teacherId;

    private String username;
    private String name;
    private String lastname;
    private String email;
    private String aboutMe;


}
