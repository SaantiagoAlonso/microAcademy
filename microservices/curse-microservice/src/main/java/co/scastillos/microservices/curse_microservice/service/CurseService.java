package co.scastillos.microservices.curse_microservice.service;

import co.scastillos.microservices.curse_microservice.configuration.mapper.CurseMapper;
import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseRepository;
import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurseService {

    private final CurseRepository curseRepository;
    private final CurseMapper curseMapper;

    public void createCurse(NewCurseRequest curse) {
        Curse newCurse = curseMapper.toCurse(curse);
        curseRepository.save(newCurse);
    }
}
