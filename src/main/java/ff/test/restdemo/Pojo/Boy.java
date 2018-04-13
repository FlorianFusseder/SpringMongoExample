package ff.test.restdemo.Pojo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/boys")
public class Boy extends Person {

    private final String sex = "b";
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

    public int getSet(int a) {
        if (this.getBestFriend() != null) {
            return a;
        }
        return 0;
    }

    @Override
    public String getType() {
        return sex;
    }
}
