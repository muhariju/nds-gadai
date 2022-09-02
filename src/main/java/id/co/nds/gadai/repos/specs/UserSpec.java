package id.co.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai.entities.UserEntity;
import id.co.nds.gadai.models.UserModel;

public class UserSpec implements Specification<UserEntity>{
    private UserModel userModel;

    public UserSpec(UserModel userModel){
        super();
        this.userModel = userModel;
    }

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> cq,
        CriteriaBuilder cb){
            Predicate p = cb.and();
            //Predicate p = cb.disjunction();

            // id user criteria
            if(userModel.getId() != null && userModel.getId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("id")),
                "%" + userModel.getId().toLowerCase()+ "%"));
            }

            // keterangan criteria
            if(userModel.getNamaUser() != null && userModel.getNamaUser().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("namaUser")),
                "%" + userModel.getNamaUser().toLowerCase()+ "%"));
            }

            // keterangan criteria
            if(userModel.getKeterangan() != null && userModel.getKeterangan().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("keterangan")),
                "%" + userModel.getKeterangan().toLowerCase()+ "%"));
            }

            // status criteria
            if(userModel.getRecStatus() != null && userModel.getRecStatus().length() > 0){
                p.getExpressions().add(cb.equal(root.get("recStatus"), userModel.getRecStatus()));
            }

            // nomor hp criteria
            if(userModel.getNomorHp() != null && userModel.getNomorHp().length() > 0){
                p.getExpressions().add(cb.like(root.get("nomorHp"),
                "%" + userModel.getNomorHp()+ "%"));
            }
            cq.orderBy(cb.asc(root.get("id")));

            return p;
        }
}
