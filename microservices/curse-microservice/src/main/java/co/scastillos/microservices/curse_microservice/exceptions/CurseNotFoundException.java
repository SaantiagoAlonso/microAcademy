package co.scastillos.microservices.curse_microservice.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class CurseNotFoundException extends RuntimeException {

    private final String curseId;

    public CurseNotFoundException(String curseId) {
        super();
        this.curseId = curseId;
    }
}
