package simple.wireframe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simple.wireframe.model.RequestType;

/**
 * Repository for working with RequestType object
 */
@Repository
public interface RequestTypeRepository extends CrudRepository<RequestType, Integer> {

    /**
     * Get RequestType by value
     * @param value
     * @return RequestType object
     */
    @Query("SELECT rt FROM RequestType rt WHERE rt.value = ?1")
    RequestType findByValue(String value);
}
