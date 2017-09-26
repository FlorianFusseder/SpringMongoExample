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
//        External
//        ServerAddress serverAddress = new ServerAddress("mongodb-mongo.192.168.99.100.nip.io:31247");
        ServerAddress serverAddress = new ServerAddress("172.17.0.2");
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("florian", getDatabaseName(), "time2go".toCharArray());
        return new MongoClient(serverAddress, Arrays.asList(mongoCredential));
    }
}
