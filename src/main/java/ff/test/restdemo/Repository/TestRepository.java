package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.TestClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestClass, String> {
}
