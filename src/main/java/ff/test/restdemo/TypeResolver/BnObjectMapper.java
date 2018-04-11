package ff.test.restdemo.TypeResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import ff.test.restdemo.Pojo.IPerson;
import uk.co.blackpepper.bowman.ObjectMapperConfigurer;

public class BnObjectMapper implements ObjectMapperConfigurer {
    @Override
    public void configure(ObjectMapper objectMapper) {
        objectMapper.addMixIn(IPerson.class, IPersonResolver.class);
    }
}
