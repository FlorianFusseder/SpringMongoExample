package ff.test.restdemo.Pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boy.class, name = "b"),
        @JsonSubTypes.Type(value = Girl.class, name = "g")
})
public abstract class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public abstract String getType();

}
