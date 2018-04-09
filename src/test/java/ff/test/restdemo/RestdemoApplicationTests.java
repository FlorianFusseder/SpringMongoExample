package ff.test.restdemo;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Pojo.TestClass;
import ff.test.restdemo.Repository.BoyRepository;
import ff.test.restdemo.Repository.PersonRepository;
import ff.test.restdemo.Repository.TestRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Autowired
    TestRepository testRepository;

    @Autowired
    BoyRepository boyRepository;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void init() {

        testRepository.deleteAll();
        boyRepository.deleteAll();

        Boy boy0 = new Boy();
        boy0.setFirstName("Matthias");
        boy0.setLastName("Buchwald");

        personRepository.save(boy0);
        boyRepository.save(boy0);


        Boy boy1 = new Boy();
        boy1.setFirstName("Florian");
        boy1.setLastName("Fusseder");
        boy1.setFriends(Lists.newArrayList(boy0));
        TestClass testClass = new TestClass();

        personRepository.save(boy1);
        boyRepository.save(boy1);
        testClass.setPerson(boy1);
        testRepository.save(testClass);


    }

    @Test
    public void BowmanTest() {

        ClientFactory clientFactory = Configuration.builder()
                .setBaseUri("http://localhost:8080").build()
                .buildClientFactory();


        Client<TestClass> girlClient = clientFactory.create(TestClass.class);

        Iterable<TestClass> all = girlClient.getAll();


        for (TestClass testClass : all) {
            Boy person = (Boy) testClass.getPerson();
            System.out.println(testClass.getPerson().getFirstName());
            System.out.println(testClass.getPerson().getLastName());

            for (Person person1 : person.getFriends()) {
                System.out.println(person1);
            }

        }


    }

}
