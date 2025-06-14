package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import co.scastillos.microservices.curse_microservice.service.CurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/curses")
@RequiredArgsConstructor
public class CurseController {

    private final CurseService curseService;

    @PostMapping
    public ResponseEntity<Void> createCurse(@RequestBody NewCurseRequest curse){
        curseService.createCurse(curse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
