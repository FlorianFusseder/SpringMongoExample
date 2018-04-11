package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Wrapper2;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedWrapperRepository {

    Wrapper2 getCompleteWrapper();

}
