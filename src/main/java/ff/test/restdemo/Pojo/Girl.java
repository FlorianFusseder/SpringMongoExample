package ff.test.restdemo.Pojo;

import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/girls")
public class Girl extends Person {

    private final String sex = "g";

    @Override
    public String getType() {
        return sex;
    }

    public String getSex() {
        return sex;
    }
}
