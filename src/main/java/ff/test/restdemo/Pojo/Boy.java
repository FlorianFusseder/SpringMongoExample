package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/" + IBoy.TYPE + "s")
@JsonTypeName(IBoy.TYPE)
public class Boy extends Person {

    private final String sex = "Boy";
    private int test = 5;

    @DBRef
    private Person bestFriend;

    @LinkedResource
    public Person getBestFriend() {
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
        return sex;
    }
}
