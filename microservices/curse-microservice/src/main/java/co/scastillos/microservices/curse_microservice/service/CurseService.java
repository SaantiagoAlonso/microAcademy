package co.scastillos.microservices.curse_microservice.service;

import co.scastillos.microservices.curse_microservice.configuration.mapper.CurseMapper;
import co.scastillos.microservices.curse_microservice.domain.curse.Curse;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseRepository;
import co.scastillos.microservices.curse_microservice.domain.curse.CurseResponse;
import co.scastillos.microservices.curse_microservice.domain.curse.NewCurseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurseService {

    private final CurseRepository curseRepository;
    private final CurseMapper curseMapper;

    public String createCurse(NewCurseRequest curse) {
        Curse newCurse = curseMapper.toCurse(curse);
        curseRepository.save(newCurse);
        return newCurse.getCurseId();
    }

    public CurseResponse findByCurseId(String curseId) {
        Curse curse = curseRepository.findById(curseId).orElseThrow();
        return curseMapper.toCurseResponse(curse);
    }

    public List<CurseResponse> findAllCurses() {
        return curseRepository.findAll().stream()
                .map(curseMapper::toCurseResponse).toList();
    }
}
