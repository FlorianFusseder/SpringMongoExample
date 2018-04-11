package ff.test.restdemo.TypeResolver;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ff.test.restdemo.Pojo.Boy;
import ff.test.restdemo.Pojo.Girl;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boy.class, name = "Boy"),
        @JsonSubTypes.Type(value = Girl.class, name = "Girl")}
)
public abstract class IPersonResolver {

}
