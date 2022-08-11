package codegym.vn.casefurama.valid;

import codegym.vn.casefurama.entity.ContractDao.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        {
            return Contract.class.isAssignableFrom(clazz);
        }
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

//        if(!customer.getCustomerCardId().matches("^\\d{9}$|^\\d{12}$")) {
//            errors.rejectValue("customerCardId","customerCardIdError","Invalid input");
//        }

        if ( contract.getStartDate().after( contract.getEndDate())){
            errors.rejectValue("endDate","endDateError");
        }
    }
}
