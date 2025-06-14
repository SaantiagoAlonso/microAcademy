package co.scastillos.microservices.teacher_microservice.domain.teacher;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher,String> {
}
