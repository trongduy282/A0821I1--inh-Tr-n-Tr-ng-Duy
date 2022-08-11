package codegym.vn.casefurama.entity.ServiceDAO;


import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiceType;
    private String nameServiceType;


    @OneToMany(  cascade = CascadeType.ALL,
            mappedBy = "serviceType")
    private List<Service> services;

    public ServiceType() {
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public ServiceType(int idServiceType, String nameServiceType) {
        this.idServiceType = idServiceType;
        this.nameServiceType = nameServiceType;
    }
}
