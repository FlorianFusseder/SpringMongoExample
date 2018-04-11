package ff.test.restdemo;

import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Pojo.Wrapper;
import ff.test.restdemo.Repository.BoyRepository;
import ff.test.restdemo.Repository.PersonRepository;
import ff.test.restdemo.Repository.WrapperRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Autowired
    WrapperRepository wrapperRepository;

    @Autowired
    BoyRepository boyRepository;

    @Autowired
    PersonRepository personRepository;


    @Before
    public void init() {

    }

    @Test
    public void saveToMongoDBTest() {

        wrapperRepository.deleteAll();
        boyRepository.deleteAll();

        Boy boy0 = new Boy();
        boy0.setFirstName("Matthias");
        boy0.setLastName("Buchwald");

        boyRepository.save(boy0);


        Boy boy1 = new Boy();
        boy1.setFirstName("Florian");
        boy1.setLastName("Fusseder");
        boy1.setBestFriend(boy0);
        boy0.setBestFriend(boy1);

        Wrapper wrapper = new Wrapper();

        boyRepository.save(boy1);
        boyRepository.save(boy0);

        wrapper.setPerson(boy1);
        wrapperRepository.save(wrapper);
    }
    @Test
    public void bowmanRequestDataTest() {

        ClientFactory clientFactory = Configuration.builder()
                .setBaseUri("http://localhost:8080").build()
                .buildClientFactory();

        Client<Wrapper> wrapperClient = clientFactory.create(Wrapper.class);

        Iterable<Wrapper> all = wrapperClient.getAll();

        for (Wrapper wrapper : all) {
            Boy person = (Boy) wrapper.getPerson();
            System.out.println(wrapper.getPerson().getFirstName());
            System.out.println(wrapper.getPerson().getLastName());
            Boy bestFriend = (Boy) person.getBestFriend();
            System.out.println(bestFriend.getFirstName());
            System.out.println(bestFriend.getLastName());

            System.out.println(bestFriend.getBestFriend().getFirstName());
            System.out.println(bestFriend.getBestFriend().getLastName());
        }


    }



    @Test
    public void bowmanSendDataTest() {

        wrapperRepository.deleteAll();
        boyRepository.deleteAll();
        personRepository.deleteAll();

        ClientFactory clientFactory = Configuration.builder()
                .setBaseUri("http://localhost:8080").build()
                .buildClientFactory();

        Client<Boy> boyClient = clientFactory.create(Boy.class);
        Client<Wrapper> wrapperClient = clientFactory.create(Wrapper.class);

        Boy boy0 = new Boy();
        boy0.setFirstName("Matthias");
        boy0.setLastName("Buchwald");
        boy0.setId("1");
        boyClient.post(boy0);


        Boy boy1 = new Boy();
        boy1.setFirstName("Florian");
        boy1.setLastName("Fusseder");
        boy1.setId("2");
        boy1.setBestFriend(boy0);
        boy0.setBestFriend(boy1);


        boyClient.post(boy1);
        boyClient.post(boy0);


        Wrapper personWrapper = new Wrapper();
        personWrapper.setPerson(boy1);
        personWrapper.setId("3");
        URI post = wrapperClient.post(personWrapper);


        Iterable<Wrapper> all = wrapperClient.getAll();

        for (Wrapper wrapper : all) {
            Boy person = (Boy) wrapper.getPerson();
            System.out.println(wrapper.getPerson().getFirstName());
            System.out.println(wrapper.getPerson().getLastName());
            Person bestFriend = person.getBestFriend();
            System.out.println(bestFriend.getFirstName());
            System.out.println(bestFriend.getLastName());
        }


    }

}
