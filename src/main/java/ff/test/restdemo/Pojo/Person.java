package ff.test.restdemo.Pojo;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    private String id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
