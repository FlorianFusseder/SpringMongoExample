package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Girl;
import ff.test.restdemo.Pojo.IBoy;
import ff.test.restdemo.Pojo.IGirl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = IGirl.TYPE + "s", itemResourceRel = IGirl.TYPE)
public interface GirlRepository extends CrudRepository<Girl, String> {
}
