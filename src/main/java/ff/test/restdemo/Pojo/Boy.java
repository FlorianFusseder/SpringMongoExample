package ff.test.restdemo.Pojo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.List;

@Data
@RemoteResource("/boys")
public class Boy extends Person {

    private final String sex = "b";
    private int test = 5;
    @DBRef(lazy = true)
    private List<Person> friends;

    @Override
    public String getType() {
        return sex;
    }
}
