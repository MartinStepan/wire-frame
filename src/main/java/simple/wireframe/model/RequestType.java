package simple.wireframe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false, unique = true)
    private String value;

    public RequestType(String value) {
        this.value = value;
    }

    public RequestType() {
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
