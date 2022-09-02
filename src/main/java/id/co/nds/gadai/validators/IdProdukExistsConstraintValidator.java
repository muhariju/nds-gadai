package id.co.nds.gadai.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import id.co.nds.gadai.repos.ProdukRepo;

public class IdProdukExistsConstraintValidator implements ConstraintValidator<IdProdukExistsConstraint, String> {

    @Autowired
    private ProdukRepo produkRepo;
    
    @Override
    public void initialize(IdProdukExistsConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String id,
      ConstraintValidatorContext cxt) {
        Long count = produkRepo.countById(id);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
   
