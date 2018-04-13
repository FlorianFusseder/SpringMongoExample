package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/" + IGirl.TYPE + "s")
@JsonTypeName(IGirl.TYPE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = prop.prop)
public class Girl extends Person implements IGirl {

    private final String sex = "Girl";

    @Override
    public String getType() {
        return IGirl.TYPE;
    }

    public String getSex() {
        return sex;
    }

}
