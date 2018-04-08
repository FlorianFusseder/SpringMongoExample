package ff.test.restdemo.Pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@Data
@RemoteResource("/girls")
public class Girl extends Person {

    private final String sex = "g";

    @Override
    public String getType() {
        return sex;
    }
}
