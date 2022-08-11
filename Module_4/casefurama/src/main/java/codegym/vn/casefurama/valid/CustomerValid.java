package codegym.vn.casefurama.valid;

import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
            Customer customer = (Customer) target;

        if(!customer.getCustomerCardId().matches("^\\d{9}$|^\\d{12}$")) {
            errors.rejectValue("customerCardId","customerCardIdError","Invalid input");
        }

        if(!customer.getCustomerPhone().matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}")) {
            errors.rejectValue("customerPhone","customerPhoneError","Invalid input");
        }

//        if(!customer.getCustomerId().matches("^KH\\-\\d{4}$")) {
//            errors.rejectValue("customerId","customerIdError","Invalid input");
//        }
    }
}
