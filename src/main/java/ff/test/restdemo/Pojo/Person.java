package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import org.springframework.data.annotation.Id;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;
import uk.co.blackpepper.bowman.annotation.ResourceTypeInfo;

import java.net.URI;


@RemoteResource("/persons")
@ResourceTypeInfo(subtypes = {Boy.class, Girl.class})
public abstract class Person {


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
