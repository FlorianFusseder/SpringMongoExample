package ff.test.restdemo;

import ff.test.restdemo.Pojo.DistinctValues;
import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Before
    public void init() {
        personRepository.deleteAll();
        Assert.assertEquals(0, personRepository.findAll().size());

        Person person = new Person("Sonja", "Riethig");
        Person person1 = new Person("Florian", "Fusseder");
        Person person2 = new Person("Juergen", "Schmid");
        Person person3 = new Person("Juergen", "Reichl");
        Person person4 = new Person("Matthias", "Huber");
        Person person5 = new Person("Matthias", "Sommer");

        personRepository.saveAll(Arrays.asList(person, person1, person2, person3, person4, person5));
        Assert.assertEquals(6, personRepository.findAll().size());
    }

    @Test
    public void DistinctNamesTest() throws IOException {
        DistinctValues distinctValues = personRepository.findDistinctValues();
        Assert.assertEquals(1.0, distinctValues.getOk(), 0.00f);
        Assert.assertEquals(4, distinctValues.getValues().size());
    }

}
