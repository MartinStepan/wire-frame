package simple.wireframe.services;

import simple.wireframe.model.ContactRequest;

public interface ContactRequestService {

    /**
     * Save ContactRequest to database
     * @param request
     */
    void saveContactRequest(ContactRequest request);
}
