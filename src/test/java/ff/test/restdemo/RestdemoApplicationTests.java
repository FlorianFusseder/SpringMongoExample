package ff.test.restdemo;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Pojo.TestClass;
import ff.test.restdemo.Repository.BoyRepository;
import ff.test.restdemo.Repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Autowired
    TestRepository testRepository;

    @Autowired
    BoyRepository boyRepository;

    @Test
    public void init() {

        testRepository.deleteAll();
        boyRepository.deleteAll();

        Boy boy = new Boy();
        boy.setFirstName("Florian");
        boy.setLastName("Fusseder");
        TestClass testClass = new TestClass();

        boyRepository.save(boy);
        testClass.setPerson(boy);
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
            Person person = testClass.getPerson();
            System.out.println(testClass.getPerson().getFirstName());
            System.out.println(testClass.getPerson().getLastName());
            System.out.println(all.toString());
        }


    }

}
