package co.scastillos.microservices.student_microservice.domain.student;

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
public class Student {

    @Id
    private String studentId;

    private String username;
    private String name;
    private String lastname;
    private String email;

}
