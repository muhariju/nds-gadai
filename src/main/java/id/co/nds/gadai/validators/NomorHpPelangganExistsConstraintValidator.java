package id.co.nds.gadai.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import id.co.nds.gadai.repos.PelangganRepo;

public class NomorHpPelangganExistsConstraintValidator implements ConstraintValidator<NomorHpPelangganExistsConstraint, String> {

    @Autowired
    private PelangganRepo pelangganRepo;
    
    @Override
    public void initialize(NomorHpPelangganExistsConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String nomorHp,
      ConstraintValidatorContext cxt) {
        Long count = pelangganRepo.countByNomorHP(nomorHp);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
   
