package id.co.nds.gadai.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai.entities.UserEntity;
import id.co.nds.gadai.globals.GlobalConstant;
import id.co.nds.gadai.models.UserModel;
import id.co.nds.gadai.repos.UserRepo;
import id.co.nds.gadai.repos.specs.UserSpec;

@Service
public class UserService implements Serializable {
    @Autowired
    private UserRepo userRepo;
    
    public List<UserEntity> doGetAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public List<UserEntity> doSearchUser(UserModel userModel) {
        List<UserEntity> users = new ArrayList<>();
        UserSpec specs = new UserSpec(userModel);
        userRepo.findAll(specs).forEach(users::add);
        return users;
    }

    public UserEntity doInsert(UserModel userModel){

        // process
        UserEntity user = new UserEntity();
        user.setId(userModel.getId());
        user.setNamaUser(userModel.getNamaUser());
        user.setNomorHp(userModel.getNomorHp());
        user.setKeterangan(userModel.getKeterangan());
        user.setLimitTransaksi(userModel.getLimitTransaksi());
        user.setTanggalMasuk(userModel.getTanggalMasuk());
        user.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setCreatorId(
                userModel.getActorId() == null ? 0 : userModel.getActorId());
        return userRepo.save(user);
    }
    
    public UserEntity findById(String id) {
        // process
        UserEntity user = userRepo.findById(id).orElse(null);
        return user;
    }

    public UserEntity doUpdate(UserModel userModel) {
        // validation
        
        // process
        UserEntity user = new UserEntity();
        user = findById(userModel.getId());
        user.setNamaUser(userModel.getNamaUser());
        user.setNomorHp(userModel.getNomorHp());
        user.setKeterangan(userModel.getKeterangan());
        user.setLimitTransaksi(userModel.getLimitTransaksi());
        user.setTanggalMasuk(userModel.getTanggalMasuk());

        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdaterId(
                userModel.getActorId() == null ? 0 : userModel.getActorId());

        return userRepo.save(user);
    }

    public UserEntity doDelete(UserModel userModel) {
        // validation

        // process
        UserEntity user = new UserEntity();
        user = findById(userModel.getId());

        user.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        user.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        user.setDeleterId(
                userModel.getActorId() == null ? 0 : userModel.getActorId());

        userRepo.doDelete(user.getId(), user.getDeleterId());
        return user;
    }
}
