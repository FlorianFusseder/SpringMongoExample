package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Girl;
import ff.test.restdemo.Pojo.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BoyRepository extends MongoRepository<Boy, String> {

    List<Boy> findByFirstName(@Param(value = "name") String firstname);

}
