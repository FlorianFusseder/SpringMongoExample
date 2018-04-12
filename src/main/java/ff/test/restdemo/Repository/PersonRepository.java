package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstName(@Param(value = "name") String firstname);
}
