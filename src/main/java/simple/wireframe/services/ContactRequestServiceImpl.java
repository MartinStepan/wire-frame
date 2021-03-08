package simple.wireframe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.wireframe.model.ContactRequest;
import simple.wireframe.repository.ContactRequestRepository;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    @Autowired
    ContactRequestRepository contactRequestRepository;

    @Override
    public void saveContactRequest(ContactRequest request) {
        contactRequestRepository.save(request);
    }
}
