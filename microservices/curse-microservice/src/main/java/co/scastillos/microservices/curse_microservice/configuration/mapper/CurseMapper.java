package co.scastillos.microservices.curse_microservice.configuration.mapper;

import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseResponse;
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
                .imageCurseURL(curse.imageCurseURL())
                .build();
    }

    public CurseResponse toCurseResponse(Curse curse) {
        return CurseResponse.builder()
                .name(curse.getName())
                .creationDate(curse.getCreationDate())
                .description(curse.getDescription())
                .imageCurseURL(curse.getImageCurseURL())
                .build();
    }
}
