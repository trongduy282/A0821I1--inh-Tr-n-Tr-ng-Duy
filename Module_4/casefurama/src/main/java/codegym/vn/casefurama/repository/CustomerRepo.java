package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

//    @Query( "select c from Customer c where c.customerName like :nameSearch" +
//            " and c.customerType.id = :typeSearch and c.customerGender = :genderSearch ")
//    Page<Customer> searchCustomer(@Param("nameSearch") String customerName,
//                                  @Param("typeSearch") String customerType,
//                                  @Param("genderSearch") String genderSearch, Pageable pageable)  ;

    @Query( value="select * from customer   where  customer_name like :nameSearch and customer_type_id like  :typeSearch " , nativeQuery= true )
    Page<Customer> searchCustomer(@Param("nameSearch") String customerName,
                                  @Param("typeSearch") String typeSearch,
                                  Pageable pageable);


//    @Query( value="select c from Customer c  where  c.customerName like :nameSearch" , nativeQuery= false )
//    Page<Customer> searchCustomer(@Param("nameSearch") String customerName,
//                                  String customerType,
//                                  Pageable pageable);
}
