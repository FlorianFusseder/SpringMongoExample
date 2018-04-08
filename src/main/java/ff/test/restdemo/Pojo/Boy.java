package ff.test.restdemo.Pojo;

import lombok.*;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@Data
@RemoteResource("/boys")
public class Boy extends Person {

    private final String sex = "b";
    private int test = 5;


    @Override
    public String getType() {
        return sex;
    }
}
