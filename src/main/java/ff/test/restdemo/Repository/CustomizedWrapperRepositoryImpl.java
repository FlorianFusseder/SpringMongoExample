package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class WrapperRepositoryImpl implements CustomizedWrapperRepository {


    private MongoTemplate mongoTemplate;

    @Autowired
    public WrapperRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Wrapper getCompleteWrapper() {


        return new Wrapper();
    }
}
