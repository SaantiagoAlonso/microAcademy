package co.scastillos.microservices.curse_microservice.controller;

import co.scastillos.microservices.curse_microservice.domain.curse.CurseResponse;
import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import co.scastillos.microservices.curse_microservice.service.CurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/curses")
@RequiredArgsConstructor
public class CurseController {

    private final CurseService curseService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createCurse(
            @RequestPart("curse") NewCurseRequest curse,
            @RequestPart("image") MultipartFile imageFile

    ){
        return new ResponseEntity<>(curseService.createCurse(curse,imageFile), HttpStatus.CREATED);
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
