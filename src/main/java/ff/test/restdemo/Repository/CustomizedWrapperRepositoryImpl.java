package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Person;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomizedWrapperRepositoryImpl implements CustomizedWrapperRepository {


    private MongoTemplate mongoTemplate;

    @Autowired
    public CustomizedWrapperRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Boy> getCompleteWrapperJackson() {

        Boy boy = mongoTemplate.findAll(Boy.class).get(1);
        String mongoId = boy.getMongoId();
        Query id = Query.query(Criteria.where("bestFriend.$id").is(new ObjectId(mongoId)));
        List<Boy> boys = mongoTemplate.find(id, Boy.class);

        return boys;
    }
}
