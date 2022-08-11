package codegym.vn.casefurama.entity.ServiceDAO;


import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int rentTypeId;
        private String rentTypeName;

    public int getRentTypeId() {
        return rentTypeId;
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    private double rentTypeCost;

    public RentType() {
    }

    @OneToMany(mappedBy ="rentType", cascade = CascadeType.ALL)
            private List<Service> service;
}
