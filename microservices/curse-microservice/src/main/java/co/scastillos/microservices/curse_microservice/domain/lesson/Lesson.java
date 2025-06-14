package co.scastillos.microservices.curse_microservice.domain.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lesson {

    @Id
    private String lessonId;

    private String title;
    private String description;
//    private Double durationMinutes;
    private String videoUrl;
    private Integer order;


}
