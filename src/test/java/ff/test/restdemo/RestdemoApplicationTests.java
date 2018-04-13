package ff.test.restdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.IPerson;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
    public void saveToFileTest() throws IOException, URISyntaxException {


        Boy boy0 = new Boy();
        boy0.setFirstName("Matthias");
        boy0.setLastName("Buchwald");
        boy0.setUri(new URI("localhost"));


        Boy boy1 = new Boy();
        boy1.setFirstName("Florian");
        boy1.setLastName("Fusseder");
        boy1.setBestFriend(boy0);
        boy1.setUri(new URI("neuerLocalhost"));
        boy0.setBestFriend(boy1);

        Wrapper wrapper = new Wrapper();


        wrapper.setPerson(boy1);


        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerFor(Wrapper.class);
        objectWriter.writeValue(new File("C:\\Users\\f.fusseder\\Desktop\\local.json"), wrapper);
    }

    @Test
    public void saveToMongoDBTest() throws IOException {

        wrapperRepository.deleteAll();
        boyRepository.deleteAll();

        Boy boy0 = new Boy();
        boy0.setFirstName("Matthias");
        boy0.setLastName("Buchwald");
        boy0.setJsonId(1);

        boyRepository.save(boy0);


        Boy boy1 = new Boy();
        boy1.setFirstName("Florian");
        boy1.setLastName("Fusseder");
        boy1.setBestFriend(boy0);
        boy1.setJsonId(0);
        boy0.setBestFriend(boy1);

        Wrapper wrapper = new Wrapper();

        boyRepository.save(boy1);
        boyRepository.save(boy0);

        wrapper.setPerson(boy1);
        wrapperRepository.save(wrapper);

        Wrapper next = wrapperRepository.findAll().iterator().next();


        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerFor(Wrapper.class);
        File resultFile = new File("C:\\Users\\f.fusseder\\Desktop\\database.json");

        objectWriter.writeValue(resultFile, next);
        objectMapper.enableDefaultTyping();
        Wrapper wrapperIn = objectMapper.readValue(resultFile, Wrapper.class);

    }

    @Test
    public void bowmanRequestDataTest() throws IOException {

        ClientFactory clientFactory = Configuration.builder()
                .setBaseUri("http://localhost:8080")
                .build()
                .buildClientFactory();

        Client<Wrapper> wrapperClient = clientFactory
                .create(Wrapper.class);

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
}
