package codegym.vn.casefurama.entity.CustomerDAO;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class CustomerType {


    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "khong rong")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "customerType")
    private List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int id, @NotBlank(message = "khong rong") String name) {
        this.id = id;
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType(int id, @NotBlank String name, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }
}
