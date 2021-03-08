package simple.wireframe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String requestType;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String request;

    public ContactRequest() {
    }

    public int getId() {
        return id;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRequest() {
        return request;
    }

    public ContactRequest(String requestType, String policyNumber, String name, String surname, String request) {
        this.requestType = requestType;
        this.policyNumber = policyNumber;
        this.name = name;
        this.surname = surname;
        this.request = request;
    }
}
