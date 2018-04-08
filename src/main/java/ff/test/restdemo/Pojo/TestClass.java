package ff.test.restdemo.Pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@Data
@NoArgsConstructor
@RemoteResource("/testClasses")
public class TestClass {

    @Id
    private String id;

    @DBRef(lazy = true)
    Person person;

    @LinkedResource
    public Person getPerson() {
        return person;
    }
}
