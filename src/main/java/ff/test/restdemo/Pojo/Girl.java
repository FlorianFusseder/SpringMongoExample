package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/Girls")
@JsonTypeName("Girl")
public class Girl extends Person {

    private final String sex = "Girl";

    @Override
    public String getType() {
        return sex;
    }

    public String getSex() {
        return sex;
    }
}
