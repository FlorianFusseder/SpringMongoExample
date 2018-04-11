package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Girl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GirlRepository extends CrudRepository<Girl, String> {
}
