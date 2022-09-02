package id.co.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai.entities.PelangganEntity;
import id.co.nds.gadai.models.PelangganModel;

public class PelangganSpec implements Specification<PelangganEntity>{
    private PelangganModel pelangganModel;

    public PelangganSpec(PelangganModel pelangganModel){
        super();
        this.pelangganModel = pelangganModel;
    }

    @Override
    public Predicate toPredicate(Root<PelangganEntity> root, CriteriaQuery<?> cq,
        CriteriaBuilder cb){
            Predicate p = cb.and();
            //Predicate p = cb.disjunction();

            // nomor ktp criteria
            if(pelangganModel.getNomorKtp() != null && pelangganModel.getNomorKtp().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("nomorKtp")),
                "%" + pelangganModel.getNomorKtp().toLowerCase()+ "%"));
            }

            // nama pelanggan criteria
            if(pelangganModel.getNamaPelanggan() != null && pelangganModel.getNamaPelanggan().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("namaPelanggan")),
                "%" + pelangganModel.getNamaPelanggan().toLowerCase()+ "%"));
            }

            // id customer criteria
            if(pelangganModel.getId() != null && pelangganModel.getId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("id")),
                "%" + pelangganModel.getId().toLowerCase()+ "%"));
            }

            // status criteria
            if(pelangganModel.getRecStatus() != null && pelangganModel.getRecStatus().length() > 0){
                p.getExpressions().add(cb.equal(root.get("recStatus"), pelangganModel.getRecStatus()));
            }

            // nomor hp criteria
            if(pelangganModel.getNomorHp() != null && pelangganModel.getNomorHp().length() > 0){
                p.getExpressions().add(cb.like(root.get("nomorHp"),
                "%" + pelangganModel.getNomorHp()+ "%"));
            }

            // jenis usaha criteria
            if(pelangganModel.getJenisUsaha() != null && pelangganModel.getJenisUsaha().length() > 0){
                p.getExpressions().add(cb.like(root.get("jenisUsaha"),
                "%" + pelangganModel.getJenisUsaha()+ "%"));
            }

            cq.orderBy(cb.asc(root.get("id")));

            return p;
        }
}
