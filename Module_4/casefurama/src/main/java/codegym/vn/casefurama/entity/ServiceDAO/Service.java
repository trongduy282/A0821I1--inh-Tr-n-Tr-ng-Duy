package codegym.vn.casefurama.entity.ServiceDAO;


import codegym.vn.casefurama.entity.ContractDao.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int serviceId;

    @NotBlank(message = "khong rong")
    private String serviceName;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private  int numberFloats;

    @ManyToOne
    @JoinColumn(name = "idServiceType", referencedColumnName = "idServiceType")
    private ServiceType serviceType;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @ManyToOne
    @JoinColumn(name = "rentTypeId", referencedColumnName = "rentTypeId")
    private RentType rentType;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    List<Contract> contractList;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloats() {
        return numberFloats;
    }

    public void setNumberFloats(int numberFloats) {
        this.numberFloats = numberFloats;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Service(int serviceId, @NotBlank(message = "khong rong") String serviceName, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberFloats, ServiceType serviceType, RentType rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloats = numberFloats;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Service() {
    }
}
