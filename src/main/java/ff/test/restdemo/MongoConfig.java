package ff.test.restdemo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mydb";
    }

    @Override
    public Mongo mongo() throws Exception {
//        ServerAddress serverAddress = new ServerAddress("http://mongodb-restmongo.192.168.99.100.nip.io/", 27017);
//        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential("Florian", getDatabaseName(), "time2go".toCharArray());
//        return new MongoClient(serverAddress, Arrays.asList(mongoCredential));
//        return new MongoClient("http://mongodb-restmongo.192.168.99.100.nip.io");
        return new MongoClient();

    }
}
