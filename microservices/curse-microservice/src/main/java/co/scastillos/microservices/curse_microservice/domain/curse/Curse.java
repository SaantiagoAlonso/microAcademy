package co.scastillos.microservices.curse_microservice.domain.curse;

import co.scastillos.microservices.curse_microservice.domain.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Curse {

    @Id
    private String curseId;

    private String name;
    private String description;
    private Date creationDate;
    private String teacherId;
    private List<Lesson> lessons = new ArrayList<>();


}
