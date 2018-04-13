package ff.test.restdemo.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@RemoteResource("/wrappers")
public class Wrapper {

    @Id
    private String id;

    @DBRef
    private IPerson person;

    private URI uri;

    public Wrapper() {
    }

    @ResourceId
    public URI getUri() {
        return uri;
    }

    @LinkedResource
    public IPerson getPerson() {
        return person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerson(IPerson person) {
        this.person = person;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
