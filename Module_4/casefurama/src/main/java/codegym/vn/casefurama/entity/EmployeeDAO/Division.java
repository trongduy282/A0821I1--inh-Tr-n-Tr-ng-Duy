package codegym.vn.casefurama.entity.EmployeeDAO;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Division {

    @Id
    private int divisionId;
    private String divisionName;

    @OneToMany(cascade = CascadeType.ALL
    ,mappedBy="division")
    private List<Employee> employeees;


    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployeees() {
        return employeees;
    }

    public void setEmployeees(List<Employee> employeees) {
        this.employeees = employeees;
    }

    public Division() {
    }

    public Division(int divisionId, String divisionName) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
    }
}
