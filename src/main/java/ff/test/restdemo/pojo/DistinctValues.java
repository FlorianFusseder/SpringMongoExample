package ff.test.restdemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = {"waitedMS", "stats"})
public class DistinctValues {

    List<String> values;
    float ok;
}
