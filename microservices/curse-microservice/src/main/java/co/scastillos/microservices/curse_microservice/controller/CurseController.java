package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.curse.CurseResponse;
import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import co.scastillos.microservices.curse_microservice.service.CurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/curses")
@RequiredArgsConstructor
public class CurseController {

    private final CurseService curseService;

    @PostMapping
    public ResponseEntity<String> createCurse(@RequestBody NewCurseRequest curse){
        return new ResponseEntity<>(curseService.createCurse(curse), HttpStatus.CREATED);
    }

    @GetMapping("/{curseId}")
    public ResponseEntity<CurseResponse> findByCurseId(@PathVariable String curseId){
        return ResponseEntity.ok(curseService.findByCurseId(curseId));
    }

    @GetMapping
    public ResponseEntity<List<CurseResponse>> fiendAllCurses(){
        return ResponseEntity.ok(curseService.findAllCurses());
    }


}
