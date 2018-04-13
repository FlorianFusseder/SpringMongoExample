package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boy.class, name = "Boy"),
        @JsonSubTypes.Type(value = Girl.class, name = "Girl")}
)
public interface IPerson {

    String TYPE = "Person";

    int getJsonId();

    void setJsonId(int jsonId);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getType();

}
