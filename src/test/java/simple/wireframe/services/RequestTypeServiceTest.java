package simple.wireframe.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class RequestTypeServiceTest {

    @Autowired
    RequestTypeService requestTypeService;

    @Test
    public void testFillAndAllRequestTypes() {
        Assertions.assertEquals(requestTypeService.gettAllRequestTypes().size(), 2);
    }

    @Test
    public void testFindByValue() {
        int size = requestTypeService.gettAllRequestTypes().size();

        Assertions.assertEquals(requestTypeService.findByValue("Contract Adjustment").getValue(), "Contract Adjustment");
    }
}
