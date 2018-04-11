package ff.test.restdemo.Pojo;

import uk.co.blackpepper.bowman.annotation.ResourceId;
import uk.co.blackpepper.bowman.annotation.ResourceTypeInfo;

import java.net.URI;

@ResourceTypeInfo(subtypes = {Boy.class, Girl.class})
public interface IPerson {

    @ResourceId
    URI getUri();

    String getType();

    String getId();

    void setId(String id);

    void setUri(URI uri);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);
}
