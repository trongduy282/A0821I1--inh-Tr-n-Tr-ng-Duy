package codegym.vn.casefurama.entity.ContractDao;


import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttachService;
    private String name;
    private double cost;
    private int unit;
    private String status;

    public AttachService(int idAttachService, String name, double cost, int unit, String status) {
        this.idAttachService = idAttachService;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetailListattachments() {
        return contractDetailListattachments;
    }

    public void setContractDetailListattachments(List<ContractDetail> contractDetailListattachments) {
        this.contractDetailListattachments = contractDetailListattachments;
    }

    public AttachService() {
    }

    public AttachService(int idAttachService, String name, double cost, int unit, String status, List<ContractDetail> contractDetailListattachments) {
        this.idAttachService = idAttachService;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetailListattachments = contractDetailListattachments;
    }

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "contract")
    private List<ContractDetail> contractDetailListattachments;



}
