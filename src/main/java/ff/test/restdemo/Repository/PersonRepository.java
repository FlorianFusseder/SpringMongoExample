package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, String> {

}
