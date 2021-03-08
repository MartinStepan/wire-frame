package simple.wireframe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simple.wireframe.model.ContactRequest;

/**
 * Repository for working with ContactRequest object
 */
@Repository
public interface ContactRequestRepository extends CrudRepository<ContactRequest, Integer> {
}
