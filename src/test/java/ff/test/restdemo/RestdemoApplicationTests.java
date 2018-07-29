package ff.test.restdemo;

import ff.test.restdemo.Repository.PersonRepository;
import ff.test.restdemo.pojo.DistinctValues;
import ff.test.restdemo.pojo.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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
        assertThat(personRepository.findAll(), hasSize(6));
    }

    @Test
    public void DistinctNamesTest() throws IOException {
        DistinctValues distinctValues = personRepository.findDistinctValues();
        assertThat(distinctValues.getOk(), is(1.0f));
        assertThat(distinctValues.getValues(), hasSize(4));
    }
}
