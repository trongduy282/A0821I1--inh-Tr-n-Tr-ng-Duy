package codegym.vn.casefurama.entity.EmployeeDAO;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EducationDegree {

    @Id
    private int educationId;
    private String educationName;


    @OneToMany(cascade = CascadeType.ALL
            ,mappedBy="educationDegree")
    private List<Employee> employees;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EducationDegree(int educationId, String educationName) {
        this.educationId = educationId;
        this.educationName = educationName;
    }

    public EducationDegree() {
    }
}
