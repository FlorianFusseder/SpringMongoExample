package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/" + IBoy.TYPE + "s")
@JsonTypeName(IBoy.TYPE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = prop.prop)
public class Boy extends Person implements IBoy {

    private final String sex = "Boy";
    private int test = 5;

    @DBRef
    private IPerson bestFriend;

    @LinkedResource
    public IPerson getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(Person bestFriend) {
        this.bestFriend = bestFriend;
    }

    public String getSex() {
        return sex;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public String getType() {
        return IBoy.TYPE;
    }
}
