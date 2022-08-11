package codegym.vn.casefurama.entity.ContractDao;


import javax.persistence.*;

@Entity
public class ContractDetail {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idContract", referencedColumnName = "idContract")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "idAttachService", referencedColumnName = "idAttachService")
    private AttachService attachService;


    private int quantity;

    public ContractDetail(Contract contract, AttachService attachService, int quantity) {
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public ContractDetail() {
    }


    public Contract getContract() {
        return contract;
    }

    public ContractDetail(int id, Contract contract, AttachService attachService, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", contract=" + contract +
                ", attachService=" + attachService +
                ", quantity=" + quantity +
                '}';
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
