package id.co.nds.gadai.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import id.co.nds.gadai.repos.UserRepo;

public class NomorHpUserExistsConstraintValidator implements ConstraintValidator<NomorHpUserExistsConstraint, String> {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public void initialize(NomorHpUserExistsConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String nomorHp,
      ConstraintValidatorContext cxt) {
        Long count = userRepo.countByNomorHP(nomorHp);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
   
