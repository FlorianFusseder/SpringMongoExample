package ff.test.restdemo.Pojo;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
public class Person {
    @Id
    private String id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
