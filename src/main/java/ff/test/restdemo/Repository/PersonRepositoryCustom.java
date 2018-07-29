package ff.test.restdemo.Repository;

import ff.test.restdemo.pojo.DistinctValues;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface PersonRepositoryCustom {

    DistinctValues findDistinctValues() throws IOException;
}
