package ff.test.restdemo.Repository;

import ff.test.restdemo.Pojo.Wrapper;
import org.springframework.stereotype.Repository;

@Repository
public interface WrapperRepositoryCustom {

    Wrapper getCompleteWrapper();

}
