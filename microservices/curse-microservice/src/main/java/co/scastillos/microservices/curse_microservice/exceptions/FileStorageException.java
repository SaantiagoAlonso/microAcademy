package co.scastillos.microservices.curse_microservice.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class FileStorageException extends RuntimeException {

    private final Throwable cause;

    public FileStorageException(Throwable cause) {
        super();
        this.cause = cause;
    }
}
