package simple.wireframe.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import simple.wireframe.model.ContactRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class ContactRequestRepositoryTest {

    @Autowired
    ContactRequestRepository contactRequestRepository;

    @Test
    public void testInsertContactRequest() {
        ContactRequest contactRequest = new ContactRequest("requestType", "policyNumber", "name", "surname", "yourRequest");

        contactRequestRepository.save(contactRequest);

        List<ContactRequest> contactRequests = new ArrayList<>();

        contactRequestRepository.findAll().forEach(request -> contactRequests.add(request));
        Assertions.assertEquals(contactRequests.get(0).getRequestType(), contactRequest.getRequestType());
        Assertions.assertEquals(contactRequests.get(0).getPolicyNumber(), contactRequest.getPolicyNumber());
        Assertions.assertEquals(contactRequests.get(0).getName(), contactRequest.getName());
        Assertions.assertEquals(contactRequests.get(0).getSurname(), contactRequest.getSurname());
        Assertions.assertEquals(contactRequests.get(0).getRequest(), contactRequest.getRequest());
    }
}
