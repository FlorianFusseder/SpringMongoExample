package ff.test.restdemo;

import ff.test.restdemo.Pojo.Person;
import ff.test.restdemo.Repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class RestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);

//		Person person = new Person("Sonja", "Riethig");
//
//		try {
//			MongoTemplate mongoTemplate = new MongoConfig().mongoTemplate();
//
//			mongoTemplate.insert(person);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


	}
}
