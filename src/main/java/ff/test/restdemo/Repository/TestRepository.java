package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Wrapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TestRepository extends CrudRepository<Wrapper, String> {
}
