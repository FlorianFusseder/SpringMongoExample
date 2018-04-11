package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boy.class, name = "Boy"),
        @JsonSubTypes.Type(value = Girl.class, name = "Girl")}
)
public interface IPerson {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);
}
