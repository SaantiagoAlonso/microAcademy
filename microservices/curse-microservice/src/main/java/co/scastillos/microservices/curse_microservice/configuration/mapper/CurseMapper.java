package co.scastillos.microservices.curse_microservice.configuration.mapper;

import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CurseMapper {

    public Curse toCurse(NewCurseRequest curse) {
        return Curse.builder()
                .name(curse.name())
                .description(curse.description())
                .creationDate(new Date())
                .build();
    }
}
