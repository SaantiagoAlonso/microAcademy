package co.scastillos.microservices.curse_microservice.domain.curse;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurseRepository extends MongoRepository<Curse,String> {
}
