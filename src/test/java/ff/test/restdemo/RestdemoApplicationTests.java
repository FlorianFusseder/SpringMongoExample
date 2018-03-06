package ff.test.restdemo;

import ff.test.restdemo.Pojo.DistinctValues;
import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() throws IOException {

        Person person = new Person("Sonja", "Riethig");
        Person person1 = new Person("Florian", "Fusseder");
        Person person2 = new Person("Juergen", "Schmid");
        Person person3 = new Person("Juergen", "Reichl");
        Person person4 = new Person("Matthias", "Huber");
        Person person5 = new Person("Matthias", "Sommer");

        personRepository.deleteAll();
        personRepository.saveAll(Arrays.asList(person, person1, person2, person3, person4, person5));


        DistinctValues distinctValues = personRepository.findDistinctValues();

        System.out.println(distinctValues);
    }

}
