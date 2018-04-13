package ff.test.restdemo.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import ff.test.restdemo.Pojo.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomizedWrapperRepositoryImpl implements CustomizedWrapperRepository {


    private MongoTemplate mongoTemplate;

    @Autowired
    public CustomizedWrapperRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Object getCompleteWrapperJackson() {


        Wrapper object = mongoTemplate.findAll(Wrapper.class).get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectWriter objectWriter = objectMapper.writerFor(Wrapper.class);

        try {
            return objectWriter.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Fail";
    }
}
