package id.co.nds.gadai.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import id.co.nds.gadai.repos.PelangganRepo;

public class NomorKtpPelangganExistsConstraintValidator implements ConstraintValidator<NomorKtpPelangganExistsConstraint, String> {

    @Autowired
    private PelangganRepo pelangganRepo;
    
    @Override
    public void initialize(NomorKtpPelangganExistsConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String nomorKtp,
      ConstraintValidatorContext cxt) {
        Long count = pelangganRepo.countByNomorKTP(nomorKtp);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
   
