package simple.wireframe.services;

import simple.wireframe.model.RequestType;
import java.util.List;

public interface RequestTypeService {

    /**
     * Return all RequestTypes from database
     * @return
     */
    List<RequestType> gettAllRequestTypes();

    /**
     * Find RequestType by value
     * @param value
     * @return RequestType object
     */
    RequestType findByValue(String value);
}
