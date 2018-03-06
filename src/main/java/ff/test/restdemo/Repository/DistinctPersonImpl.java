package ff.test.restdemo.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ff.test.restdemo.Pojo.DistinctValues;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

public class DistinctPersonImpl implements DistinctPerson {

    @Autowired
    public MongoTemplate mongoTemplate;


    @Override
    public DistinctValues findDistinctValues() throws IOException {

        Document document = mongoTemplate.executeCommand(" { distinct: \"person\", key: \"firstName\" }");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(document.toJson());

        return objectMapper.readValue(document.toJson(), DistinctValues.class);
    }
}
