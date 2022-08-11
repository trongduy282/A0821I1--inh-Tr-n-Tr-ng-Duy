package codegym.vn.casefurama;

import codegym.vn.casefurama.entity.ContractDao.AttachService;
import codegym.vn.casefurama.entity.CustomerDAO.CustomerType;
import codegym.vn.casefurama.entity.EmployeeDAO.Division;
import codegym.vn.casefurama.entity.EmployeeDAO.EducationDegree;
import codegym.vn.casefurama.entity.EmployeeDAO.Position;
import codegym.vn.casefurama.entity.ServiceDAO.RentType;
import codegym.vn.casefurama.entity.ServiceDAO.ServiceType;
import codegym.vn.casefurama.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaseFurama implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CaseFurama.class, args);
    }

    @Autowired
    CustomerTypleRepo customerTypleRepo;

    @Autowired
    DivisionRepo divisionRepo;
    @Autowired
    EducationDegreeRepo educationDegreeRepo;
    @Autowired
    PositionRepo positionRepo;

    @Autowired
    RentTypeRepo rentTypeRepo;

    @Autowired
    ServiceTypeRepo serviceTypeRepo;

    @Autowired
    AttachServiceRepo attachServiceRepo;

    @Override
    public void run(String... args) throws Exception {

        customerTypleRepo.save(new CustomerType(1,"Diamond"));
        customerTypleRepo.save(new CustomerType(3,"Gold"));
        customerTypleRepo.save(new CustomerType(2,"Platinium"));
        customerTypleRepo.save(new CustomerType(4,"Silver"));
        customerTypleRepo.save(new CustomerType(5,"Member"));

        positionRepo.save((new Position(1, "Lễ tân")));
        positionRepo.save((new Position(2, "phục vụ")));
        positionRepo.save((new Position(3, "chuyên viên")));
        positionRepo.save((new Position(4, "giám sát")));
        positionRepo.save((new Position(5, "quản lý")));
        positionRepo.save((new Position(6, "giám đốc")));

        educationDegreeRepo.save(new EducationDegree( 1, "Trung cấp"));
        educationDegreeRepo.save(new EducationDegree( 2, "Cao đẳng"));
        educationDegreeRepo.save(new EducationDegree( 3, "Đại học"));
        educationDegreeRepo.save(new EducationDegree( 4, "sau đại học"));

        divisionRepo.save( new Division( 1, "Sale – Marketing"));
        divisionRepo.save( new Division(2, "Hành Chính"));
        divisionRepo.save( new Division(3, "Phục vụ"));
        divisionRepo.save( new Division(4, "Quản lý"));

        rentTypeRepo.save( new RentType(1,"Theo Nam", 2000));
        rentTypeRepo.save( new RentType(2,"Theo Thang", 200));
        rentTypeRepo.save( new RentType(3,"Theo Ngay", 20));
        rentTypeRepo.save( new RentType(4,"Theo Gio", 2));

        serviceTypeRepo.save(new ServiceType(1,"Villa"));
        serviceTypeRepo.save(new ServiceType(2,"House"));
        serviceTypeRepo.save(new ServiceType(3,"Room"));

        attachServiceRepo.save(new AttachService(1, "dv kem 1", 1232, 23, "Con"));
        attachServiceRepo.save(new AttachService(2, "dv kem 2", 32423, 54, "Con"));
        attachServiceRepo.save(new AttachService(3, "dv kem 3", 5345, 23, "Con"));
        attachServiceRepo.save(new AttachService(4, "dv kem 4", 1223532, 54, "Con"));
    }
}
