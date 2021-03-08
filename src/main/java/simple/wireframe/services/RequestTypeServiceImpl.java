package simple.wireframe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import simple.wireframe.model.RequestType;
import simple.wireframe.repository.RequestTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Lazy
@Service
public class RequestTypeServiceImpl implements RequestTypeService {

    private boolean initDataInserted;

    @Value("#{'${request.types}'.split(',')}")
    private List<String> requestTypes;

    @Autowired
    RequestTypeRepository requestTypeRepository;

    public RequestTypeServiceImpl() {
        this.initDataInserted = false;
    }

    private void fillRequestTypeTable() {
        requestTypes.forEach(type -> requestTypeRepository.save(new RequestType(type.trim())));
    }

    @Override
    public List<RequestType> gettAllRequestTypes() {
        if(!initDataInserted) {
            fillRequestTypeTable();
            initDataInserted = true;
        }
        List<RequestType> requestTypes = new ArrayList<>();
        requestTypeRepository.findAll().forEach(request -> requestTypes.add(request));

        return requestTypes;
    }

    @Override
    public RequestType findByValue(String value) {
        return requestTypeRepository.findByValue(value);
    }

    public List<String> getRequestTypes() {
        return requestTypes;
    }
}
