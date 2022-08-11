package codegym.vn.casefurama.entity.EmployeeDAO;


import codegym.vn.casefurama.entity.ContractDao.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {

    @Id
    private String employeeId;

    @NotBlank(message = "khong rong")
    private String employeeName;
    private Date birthday;


    private String idCardEmployee;
    @Min(value = 0, message= "phai lon hon 0")
    private double employeeSalary;

    @Size( min= 10, max = 10, message = "phai du 10 so")
    private String employeePhone;

    @Email(message = "dinh dang imeal")
    private String employeeEmail;

    @NotBlank(message = "khong rong")
    private String employeeAddress;


    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divisionId", referencedColumnName = "divisionId")
    private Division division;


    @ManyToOne
    @JoinColumn(name = "educationId", referencedColumnName = "educationId")
    private EducationDegree educationDegree;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    List<Contract> contractList;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCardEmployee() {
        return idCardEmployee;
    }

    public void setIdCardEmployee(String idCard) {
        this.idCardEmployee = idCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double salary) {
        this.employeeSalary = salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Employee() {
    }
}
