package ff.test.restdemo.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@RemoteResource("/testClasses")
public class Wrapper {

    @Id
    private String id;

    @DBRef
    private Person person;

    private URI uri;

    @ResourceId
    public URI getUri() {
        return uri;
    }

    @LinkedResource
    public Person getPerson() {
        return person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
