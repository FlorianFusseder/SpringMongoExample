package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.IPerson;
import ff.test.restdemo.Pojo.Wrapper;
import ff.test.restdemo.Pojo.Wrapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class CustomizedWrapperRepositoryImpl implements CustomizedWrapperRepository {


    private MongoTemplate mongoTemplate;

    @Autowired
    public CustomizedWrapperRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Wrapper2 getCompleteWrapper() {

        Wrapper object = mongoTemplate.findAll(Wrapper.class).get(0);

        Wrapper2 wrapper2 = new Wrapper2();

        Boy person = (Boy) object.getPerson();
        person.setBestFriend(null);
        wrapper2.setPerson(person);

        return wrapper2;
    }
}
