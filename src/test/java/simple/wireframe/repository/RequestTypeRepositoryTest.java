package simple.wireframe.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import simple.wireframe.model.RequestType;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class RequestTypeRepositoryTest {

    @Autowired
    RequestTypeRepository requestTypeRepository;

    @Test
    public void testInsertRequestType() {
        RequestType type1 = new RequestType("type1");
        RequestType type2 = new RequestType("type2");

        requestTypeRepository.save(type1);
        requestTypeRepository.save(type2);

        List<RequestType> requestTypes = new ArrayList<>();

        requestTypeRepository.findAll().forEach(type -> requestTypes.add(type));
        Assertions.assertEquals(requestTypes.get(0).getValue(), type1.getValue());
        Assertions.assertEquals(requestTypes.get(1).getValue(), type2.getValue());
    }
}
