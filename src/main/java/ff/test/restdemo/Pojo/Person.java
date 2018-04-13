package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.Id;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Boy.class, name = "Boy"),
        @JsonSubTypes.Type(value = Girl.class, name = "Girl")}
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = prop.prop)
@JsonIgnoreProperties(value={ "type"}, allowGetters=true)
public abstract class Person implements IPerson {


    @Id
    private String mongoId;
    private URI uri;
    private int jsonId;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public int getJsonId() {
        return jsonId;
    }

    public void setJsonId(int jsonId) {
        this.jsonId = jsonId;
    }

    @ResourceId
    public URI getUri() {
        return uri;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public abstract String getType();

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
