package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.DistinctValues;

import java.io.IOException;

public interface DistinctPerson {

    DistinctValues findDistinctValues() throws IOException;
}
