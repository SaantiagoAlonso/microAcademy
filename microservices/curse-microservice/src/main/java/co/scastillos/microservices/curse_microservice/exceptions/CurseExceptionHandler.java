package co.scastillos.microservices.curse_microservice.exceptions;

import co.scastillos.microservices.common_exception.ErrorResponse;
import co.scastillos.microservices.common_exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
@Primary
public class CurseExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CurseNotFoundException.class)
    public ResponseEntity<ErrorResponse> curseNotFoundHandler404(CurseNotFoundException exception){
        var errors = new HashMap<String,String>();
        var fileName = "curse";
        var message = String.format("curse whit id: %s not found", exception.getCurseId());
        errors.put(fileName,message);
        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileStorageException.class)
    public ResponseEntity<ErrorResponse> handler(FileStorageException exception){
        var errors = new HashMap<String,String>();
        var fileName = "file";
        var message = String.format("error uploading file: %s", exception.getCause());
        errors.put(fileName,message);
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
