package codegym.vn.casefurama.entity.CustomerDAO;


import codegym.vn.casefurama.entity.ContractDao.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Customer  {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^KH\\-\\d{4}$", message = "{customerIdError}")
    private String customerId;
    @NotBlank(message = "khong rong")
//    @Pattern(regexp = "\\w+", message="Name khong chua cac ky tu dac biet")
    private String customerName;
    private Date customerBirthday;
    private boolean customerGender;
    private String customerCardId;
    private String customerPhone;
    @Email
    private String customerEmail;
    private String customerAddress;

    @ManyToOne
    @JoinColumn( name = "customerTypeId", referencedColumnName = "id")
    private CustomerType customerType;

    public Customer() {
    }


    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    List<Contract> contractList;

    public Customer(String customerId, @NotBlank(message = "khong rong") String customerName, Date customerBirthday, boolean customerGender, String customerCardId, String customerPhone, @Email String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerCardId = customerCardId;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCardId() {
        return customerCardId;
    }

    public void setCustomerCardId(String customerCardId) {
        this.customerCardId = customerCardId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
