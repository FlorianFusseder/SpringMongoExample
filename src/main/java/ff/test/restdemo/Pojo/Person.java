package ff.test.restdemo.Pojo;

import org.springframework.data.annotation.Id;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

public abstract class Person implements IPerson {


    @Id
    private String id;

    private URI uri;

    private String firstName;
    private String lastName;

    @ResourceId
    public URI getUri() {
        return uri;
    }

    public abstract String getType();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
