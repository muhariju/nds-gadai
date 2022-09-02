package id.co.nds.gadai.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import id.co.nds.gadai.repos.UserRepo;

public class IdUserExistsConstraintValidator implements ConstraintValidator<IdUserExistsConstraint, String> {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public void initialize(IdUserExistsConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String idUser,
      ConstraintValidatorContext cxt) {
        Long count = userRepo.countById(idUser);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
   
