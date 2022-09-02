package id.co.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai.entities.ProdukEntity;
import id.co.nds.gadai.models.ProdukModel;

public class ProdukSpec implements Specification<ProdukEntity>{
    private ProdukModel produkModel;

    public ProdukSpec(ProdukModel produkModel){
        super();
        this.produkModel = produkModel;
    }

    @Override
    public Predicate toPredicate(Root<ProdukEntity> root, CriteriaQuery<?> cq,
        CriteriaBuilder cb){
            Predicate p = cb.and();
            //Predicate p = cb.disjunction();

            // id produk criteria
            if(produkModel.getId() != null && produkModel.getId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("id")),
                "%" + produkModel.getId().toLowerCase()+ "%"));
            }

            // tipe produk criteria
            if(produkModel.getTipeProduk() != null && produkModel.getTipeProduk().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("tipeProduk")),
                "%" + produkModel.getTipeProduk().toLowerCase()+ "%"));
            }

            // nama produk criteria
            if(produkModel.getNamaProduk() != null && produkModel.getNamaProduk().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("namaProduk")),
                "%" + produkModel.getNamaProduk().toLowerCase()+ "%"));
            }

            // status criteria
            if(produkModel.getRecStatus() != null && produkModel.getRecStatus().length() > 0){
                p.getExpressions().add(cb.equal(root.get("recStatus"), produkModel.getRecStatus()));
            }

            // ltv criteria 
            if(produkModel.getLtv() != null){
                p.getExpressions().add(cb.between(root.get("ltv"),produkModel.getLtv(),produkModel.getLtvSampai())
                );
            }

            // jasa penyimpanan criteria 
            if(produkModel.getJasaPenyimpanan() != null && produkModel.getJasaPenyimpananSampai() != null ){
                p.getExpressions().add(cb.between(root.get("jasaPenyimpanan"),produkModel.getJasaPenyimpanan(),produkModel.getJasaPenyimpananSampai())
                );
            }

            cq.orderBy(cb.asc(root.get("id")));

            return p;
        }
}
